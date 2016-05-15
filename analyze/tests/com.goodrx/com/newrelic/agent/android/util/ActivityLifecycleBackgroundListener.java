package com.newrelic.agent.android.util;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.UiBackgroundListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class ActivityLifecycleBackgroundListener extends UiBackgroundListener implements ActivityLifecycleCallbacks {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private AtomicBoolean isInBackground = new AtomicBoolean(false);

   public void onActivityCreated(Activity var1, Bundle var2) {
      log.info("ActivityLifecycleBackgroundListener.onActivityCreated");
      this.isInBackground.set(false);
   }

   public void onActivityDestroyed(Activity var1) {
      log.info("ActivityLifecycleBackgroundListener.onActivityDestroyed");
      this.isInBackground.set(false);
   }

   public void onActivityPaused(Activity var1) {
      if(this.isInBackground.compareAndSet(false, true)) {
         Runnable var2 = new Runnable() {
            public void run() {
               ActivityLifecycleBackgroundListener.log.debug("ActivityLifecycleBackgroundListener.onActivityPaused - notifying ApplicationStateMonitor");
               ApplicationStateMonitor.getInstance().uiHidden();
            }
         };
         this.executor.submit(var2);
      }

   }

   public void onActivityResumed(Activity var1) {
      log.info("ActivityLifecycleBackgroundListener.onActivityResumed");
      if(this.isInBackground.getAndSet(false)) {
         Runnable var2 = new Runnable() {
            public void run() {
               ApplicationStateMonitor.getInstance().activityStarted();
            }
         };
         this.executor.submit(var2);
      }

   }

   public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
   }

   public void onActivityStarted(Activity var1) {
      if(this.isInBackground.compareAndSet(true, false)) {
         Runnable var2 = new Runnable() {
            public void run() {
               ActivityLifecycleBackgroundListener.log.debug("ActivityLifecycleBackgroundListener.onActivityStarted - notifying ApplicationStateMonitor");
               ApplicationStateMonitor.getInstance().activityStarted();
            }
         };
         this.executor.submit(var2);
      }

   }

   public void onActivityStopped(Activity var1) {
   }

   public void onTrimMemory(int var1) {
      log.info("ActivityLifecycleBackgroundListener.onTrimMemory level: " + var1);
      if(20 == var1) {
         this.isInBackground.set(true);
      }

      super.onTrimMemory(var1);
   }
}
