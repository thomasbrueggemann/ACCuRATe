package com.robotium.solo;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.app.Instrumentation.ActivityResult;
import android.content.IntentFilter;
import android.util.Log;
import com.robotium.solo.Sleeper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.Timer;
import junit.framework.Assert;

class ActivityUtils {
   private final String LOG_TAG = "Robotium";
   private final int MINISLEEP = 100;
   private Stack<String> activitiesStoredInActivityStack;
   private Activity activity;
   private ActivityMonitor activityMonitor;
   private Stack<WeakReference<Activity>> activityStack;
   private Timer activitySyncTimer;
   Thread activityThread;
   private final Instrumentation inst;
   private boolean registerActivities;
   private final Sleeper sleeper;
   private WeakReference<Activity> weakActivityReference;

   public ActivityUtils(Instrumentation var1, Activity var2, Sleeper var3) {
      this.inst = var1;
      this.activity = var2;
      this.sleeper = var3;
      this.createStackAndPushStartActivity();
      this.activitySyncTimer = new Timer();
      this.activitiesStoredInActivityStack = new Stack();
      this.setupActivityMonitor();
      this.setupActivityStackListener();
   }

   private void addActivityToStack(Activity var1) {
      this.activitiesStoredInActivityStack.push(var1.toString());
      this.weakActivityReference = new WeakReference(var1);
      this.activityStack.push(this.weakActivityReference);
   }

   private void clearActivityStack() {
      this.activityStack.clear();
      this.activitiesStoredInActivityStack.clear();
   }

   private void createStackAndPushStartActivity() {
      this.activityStack = new Stack();
      if(this.activity != null) {
         WeakReference var1 = new WeakReference(this.activity);
         this.activity = null;
         this.activityStack.push(var1);
      }

   }

   private void finishActivity(Activity var1) {
      if(var1 != null) {
         try {
            var1.finish();
         } catch (Throwable var3) {
            var3.printStackTrace();
            return;
         }
      }

   }

   private void removeActivityFromStack(Activity var1) {
      Iterator var2 = this.activityStack.iterator();

      while(var2.hasNext()) {
         Activity var3 = (Activity)((WeakReference)var2.next()).get();
         if(var3 == null) {
            var2.remove();
         }

         if(var1 != null && var3 != null && var3.equals(var1)) {
            var2.remove();
         }
      }

   }

   private void setupActivityMonitor() {
      try {
         this.activityMonitor = this.inst.addMonitor((IntentFilter)null, (ActivityResult)null, false);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   private void setupActivityStackListener() {
      this.setRegisterActivities(true);
      this.activityThread = new Thread(new Runnable() {
         public void run() {
            while(ActivityUtils.this.shouldRegisterActivities()) {
               Activity var1 = ActivityUtils.this.activityMonitor.waitForActivity();
               if(var1 != null) {
                  if(ActivityUtils.this.activitiesStoredInActivityStack.remove(var1.toString())) {
                     ActivityUtils.this.removeActivityFromStack(var1);
                  }

                  if(!var1.isFinishing()) {
                     ActivityUtils.this.addActivityToStack(var1);
                  }
               }
            }

         }
      }, "activityMonitorThread");
      this.activityThread.start();
   }

   private final void waitForActivityIfNotAvailable() {
      if(this.activityStack.isEmpty() || ((WeakReference)this.activityStack.peek()).get() == null) {
         if(this.activityMonitor == null) {
            this.sleeper.sleepMini();
            this.setupActivityMonitor();
            this.waitForActivityIfNotAvailable();
            return;
         }

         Activity var1;
         for(var1 = this.activityMonitor.getLastActivity(); var1 == null; var1 = this.activityMonitor.getLastActivity()) {
            this.sleeper.sleepMini();
         }

         this.addActivityToStack(var1);
      }

   }

   public void finalize() throws Throwable {
      this.activitySyncTimer.cancel();

      try {
         if(this.activityMonitor != null) {
            this.inst.removeMonitor(this.activityMonitor);
            this.activityMonitor = null;
         }
      } catch (Exception var2) {
         ;
      }

      super.finalize();
   }

   public void finishOpenedActivities() {
      this.activitySyncTimer.cancel();
      ArrayList var1 = this.getAllOpenedActivities();

      for(int var2 = -1 + var1.size(); var2 >= 0; --var2) {
         this.sleeper.sleep(100);
         this.finishActivity((Activity)var1.get(var2));
      }

      this.sleeper.sleep(100);
      this.finishActivity(this.getCurrentActivity(true, false));
      this.setRegisterActivities(false);
      this.activity = null;
      this.sleeper.sleepMini();

      try {
         this.inst.sendKeyDownUpSync(4);
         this.sleeper.sleep(100);
         this.inst.sendKeyDownUpSync(4);
      } catch (Throwable var4) {
         ;
      }

      this.clearActivityStack();
   }

   public ActivityMonitor getActivityMonitor() {
      return this.activityMonitor;
   }

   public ArrayList<Activity> getAllOpenedActivities() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.activityStack.iterator();

      while(var2.hasNext()) {
         Activity var3 = (Activity)((WeakReference)var2.next()).get();
         if(var3 != null) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public Activity getCurrentActivity() {
      return this.getCurrentActivity(true, true);
   }

   public Activity getCurrentActivity(boolean var1) {
      return this.getCurrentActivity(var1, true);
   }

   public Activity getCurrentActivity(boolean var1, boolean var2) {
      if(var1) {
         this.sleeper.sleep();
      }

      if(var2) {
         this.waitForActivityIfNotAvailable();
      }

      if(!this.activityStack.isEmpty()) {
         this.activity = (Activity)((WeakReference)this.activityStack.peek()).get();
      }

      return this.activity;
   }

   public String getCurrentActivityName() {
      return !this.activitiesStoredInActivityStack.isEmpty()?(String)this.activitiesStoredInActivityStack.peek():"";
   }

   public String getString(int var1) {
      return this.getCurrentActivity(false).getString(var1);
   }

   public void goBackToActivity(String var1) {
      ArrayList var2 = this.getAllOpenedActivities();
      int var3 = 0;

      boolean var5;
      while(true) {
         int var4 = var2.size();
         var5 = false;
         if(var3 >= var4) {
            break;
         }

         if(((Activity)var2.get(var3)).getClass().getSimpleName().equals(var1)) {
            var5 = true;
            break;
         }

         ++var3;
      }

      if(var5) {
         while(!this.getCurrentActivity().getClass().getSimpleName().equals(var1)) {
            try {
               this.inst.sendKeyDownUpSync(4);
            } catch (SecurityException var9) {
               ;
            }
         }
      } else {
         for(int var6 = 0; var6 < var2.size(); ++var6) {
            Log.d("Robotium", "Activity priorly opened: " + ((Activity)var2.get(var6)).getClass().getSimpleName());
         }

         Assert.fail("No Activity named: \'" + var1 + "\' has been priorly opened");
      }

   }

   public boolean isActivityStackEmpty() {
      return this.activityStack.isEmpty();
   }

   public void setActivityOrientation(int var1) {
      this.getCurrentActivity().setRequestedOrientation(var1);
   }

   public void setRegisterActivities(boolean var1) {
      this.registerActivities = var1;
   }

   public boolean shouldRegisterActivities() {
      return this.registerActivities;
   }
}
