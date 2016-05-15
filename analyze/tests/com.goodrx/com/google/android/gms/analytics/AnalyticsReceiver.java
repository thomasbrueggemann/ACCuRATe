package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;

public final class AnalyticsReceiver extends BroadcastReceiver {
   static zzrp zzOM;
   static Boolean zzON;
   static Object zzqy = new Object();

   public static boolean zzY(Context var0) {
      zzx.zzz(var0);
      if(zzON != null) {
         return zzON.booleanValue();
      } else {
         boolean var2 = zzam.zza(var0, AnalyticsReceiver.class, false);
         zzON = Boolean.valueOf(var2);
         return var2;
      }
   }

   @RequiresPermission(
      allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}
   )
   public void onReceive(Context param1, Intent param2) {
      // $FF: Couldn't be decompiled
   }
}
