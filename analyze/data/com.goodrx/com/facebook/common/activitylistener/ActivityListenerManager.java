package com.facebook.common.activitylistener;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.activitylistener.BaseActivityListener;
import com.facebook.common.activitylistener.ListenableActivity;
import com.facebook.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public class ActivityListenerManager {
   public static void register(ActivityListener var0, Context var1) {
      if(!(var1 instanceof ListenableActivity) && var1 instanceof ContextWrapper) {
         var1 = ((ContextWrapper)var1).getBaseContext();
      }

      if(var1 instanceof ListenableActivity) {
         ((ListenableActivity)var1).addActivityListener(new ActivityListenerManager.Listener(var0));
      }

   }

   private static class Listener extends BaseActivityListener {
      private final WeakReference<ActivityListener> mActivityListenerRef;

      public Listener(ActivityListener var1) {
         this.mActivityListenerRef = new WeakReference(var1);
      }

      private ActivityListener getListenerOrCleanUp(Activity var1) {
         ActivityListener var2 = (ActivityListener)this.mActivityListenerRef.get();
         if(var2 == null) {
            Preconditions.checkArgument(var1 instanceof ListenableActivity);
            ((ListenableActivity)var1).removeActivityListener(this);
         }

         return var2;
      }

      public void onActivityCreate(Activity var1) {
         ActivityListener var2 = this.getListenerOrCleanUp(var1);
         if(var2 != null) {
            var2.onActivityCreate(var1);
         }

      }

      public void onDestroy(Activity var1) {
         ActivityListener var2 = this.getListenerOrCleanUp(var1);
         if(var2 != null) {
            var2.onDestroy(var1);
         }

      }

      public void onPause(Activity var1) {
         ActivityListener var2 = this.getListenerOrCleanUp(var1);
         if(var2 != null) {
            var2.onPause(var1);
         }

      }

      public void onResume(Activity var1) {
         ActivityListener var2 = this.getListenerOrCleanUp(var1);
         if(var2 != null) {
            var2.onResume(var1);
         }

      }

      public void onStart(Activity var1) {
         ActivityListener var2 = this.getListenerOrCleanUp(var1);
         if(var2 != null) {
            var2.onStart(var1);
         }

      }

      public void onStop(Activity var1) {
         ActivityListener var2 = this.getListenerOrCleanUp(var1);
         if(var2 != null) {
            var2.onStop(var1);
         }

      }
   }
}
