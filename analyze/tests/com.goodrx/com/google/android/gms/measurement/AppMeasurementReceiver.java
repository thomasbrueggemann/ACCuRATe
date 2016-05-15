package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.measurement.internal.zzaj;

public final class AppMeasurementReceiver extends BroadcastReceiver {
   static zzrp zzOM;
   static Boolean zzON;
   static final Object zzqy = new Object();

   public static boolean zzY(Context var0) {
      zzx.zzz(var0);
      if(zzON != null) {
         return zzON.booleanValue();
      } else {
         boolean var2 = zzaj.zza(var0, AppMeasurementReceiver.class, false);
         zzON = Boolean.valueOf(var2);
         return var2;
      }
   }

   @MainThread
   public void onReceive(Context param1, Intent param2) {
      // $FF: Couldn't be decompiled
   }
}
