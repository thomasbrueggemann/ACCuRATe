package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.google.android.gms.internal.zzne;

public final class zzmu {
   @TargetApi(20)
   public static boolean zzaw(Context var0) {
      return zzne.zzsl() && var0.getPackageManager().hasSystemFeature("android.hardware.type.watch");
   }

   public static boolean zzb(Resources var0) {
      if(var0 != null) {
         boolean var1;
         if((15 & var0.getConfiguration().screenLayout) > 3) {
            var1 = true;
         } else {
            var1 = false;
         }

         if(zzne.zzsd() && var1 || zzc(var0)) {
            return true;
         }
      }

      return false;
   }

   @TargetApi(13)
   private static boolean zzc(Resources var0) {
      Configuration var1 = var0.getConfiguration();
      boolean var2 = zzne.zzsf();
      boolean var3 = false;
      if(var2) {
         int var4 = 15 & var1.screenLayout;
         var3 = false;
         if(var4 <= 3) {
            int var5 = var1.smallestScreenWidthDp;
            var3 = false;
            if(var5 >= 600) {
               var3 = true;
            }
         }
      }

      return var3;
   }
}
