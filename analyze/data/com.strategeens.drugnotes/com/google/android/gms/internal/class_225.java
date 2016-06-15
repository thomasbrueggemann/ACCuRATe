package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.am
@ey
public class class_225 implements ActivityLifecycleCallbacks {
   private Context mContext;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_377 = new Object();
   // $FF: renamed from: nB android.app.Activity
   private Activity field_378;

   public class_225(Application var1, Activity var2) {
      var1.registerActivityLifecycleCallbacks(this);
      this.setActivity(var2);
      this.mContext = var1.getApplicationContext();
   }

   private void setActivity(Activity param1) {
      // $FF: Couldn't be decompiled
   }

   public Activity getActivity() {
      return this.field_378;
   }

   public Context getContext() {
      return this.mContext;
   }

   public void onActivityCreated(Activity var1, Bundle var2) {
   }

   public void onActivityDestroyed(Activity param1) {
      // $FF: Couldn't be decompiled
   }

   public void onActivityPaused(Activity var1) {
      this.setActivity(var1);
   }

   public void onActivityResumed(Activity var1) {
      this.setActivity(var1);
   }

   public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
   }

   public void onActivityStarted(Activity var1) {
      this.setActivity(var1);
   }

   public void onActivityStopped(Activity var1) {
   }
}
