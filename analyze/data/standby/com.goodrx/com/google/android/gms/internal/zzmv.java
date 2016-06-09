package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.google.android.gms.internal.zzne;

public final class zzmv {
   private static IntentFilter zzaob = new IntentFilter("android.intent.action.BATTERY_CHANGED");
   private static long zzaoc;
   private static float zzaod = Float.NaN;

   @TargetApi(20)
   public static int zzax(Context var0) {
      byte var1 = 1;
      if(var0 != null && var0.getApplicationContext() != null) {
         Intent var2 = var0.getApplicationContext().registerReceiver((BroadcastReceiver)null, zzaob);
         int var3;
         if(var2 == null) {
            var3 = 0;
         } else {
            var3 = var2.getIntExtra("plugged", 0);
         }

         byte var4;
         if((var3 & 7) != 0) {
            var4 = var1;
         } else {
            var4 = 0;
         }

         PowerManager var5 = (PowerManager)var0.getSystemService("power");
         if(var5 == null) {
            return -1;
         } else {
            boolean var6;
            if(zzne.zzsl()) {
               var6 = var5.isInteractive();
            } else {
               var6 = var5.isScreenOn();
            }

            byte var7;
            if(var6) {
               var7 = var1;
            } else {
               var7 = 0;
            }

            int var8 = var7 << 1;
            if(var4 == 0) {
               var1 = 0;
            }

            return var8 | var1;
         }
      } else {
         return -1;
      }
   }

   public static float zzay(Context param0) {
      // $FF: Couldn't be decompiled
   }
}
