package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzhb;

@zzhb
@TargetApi(14)
public class zzbe implements ActivityLifecycleCallbacks {
   private Activity mActivity;
   private Context mContext;
   private final Object zzpV;

   private void setActivity(Activity param1) {
      // $FF: Couldn't be decompiled
   }

   @Nullable
   public Activity getActivity() {
      return this.mActivity;
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
