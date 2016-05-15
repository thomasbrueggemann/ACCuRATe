package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.WakeLockEvent;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.stats.zzd;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmv;
import java.util.List;

public class zzi {
   private static String TAG = "WakeLockTracker";
   private static zzi zzanY = new zzi();
   private static Integer zzanv;

   private static int getLogLevel() {
      try {
         if(zzmp.zzkr()) {
            return ((Integer)zzc.zzb.zzanz.get()).intValue();
         } else {
            int var1 = zzd.LOG_LEVEL_OFF;
            return var1;
         }
      } catch (SecurityException var2) {
         return zzd.LOG_LEVEL_OFF;
      }
   }

   private static boolean zzav(Context var0) {
      if(zzanv == null) {
         zzanv = Integer.valueOf(getLogLevel());
      }

      return zzanv.intValue() != zzd.LOG_LEVEL_OFF;
   }

   public static zzi zzrZ() {
      return zzanY;
   }

   public void zza(Context var1, String var2, int var3, String var4, String var5, int var6, List<String> var7) {
      this.zza(var1, var2, var3, var4, var5, var6, var7, 0L);
   }

   public void zza(Context var1, String var2, int var3, String var4, String var5, int var6, List<String> var7, long var8) {
      if(zzav(var1)) {
         if(TextUtils.isEmpty(var2)) {
            Log.e(TAG, "missing wakeLock key. " + var2);
            return;
         }

         long var10 = System.currentTimeMillis();
         if(7 == var3 || 8 == var3 || 10 == var3 || 11 == var3) {
            WakeLockEvent var12 = new WakeLockEvent(var10, var3, var4, var6, var7, var2, SystemClock.elapsedRealtime(), zzmv.zzax(var1), var5, var1.getPackageName(), zzmv.zzay(var1), var8);

            try {
               var1.startService((new Intent()).setComponent(zzd.zzanF).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", var12));
               return;
            } catch (Exception var14) {
               Log.wtf(TAG, var14);
               return;
            }
         }
      }

   }
}
