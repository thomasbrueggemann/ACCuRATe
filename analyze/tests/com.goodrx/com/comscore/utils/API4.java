package com.comscore.utils;

import android.content.Context;
import android.os.Build.VERSION;

public class API4 {
   public static boolean isPackageInstalledFromGooglePlayStore(Context var0) {
      int var1 = VERSION.SDK_INT;
      boolean var2 = false;
      if(var1 > 4) {
         String var4;
         try {
            var4 = var0.getPackageManager().getInstallerPackageName(var0.getPackageName());
         } catch (Exception var6) {
            return false;
         }

         if(!"com.android.vending".equals(var4)) {
            boolean var5 = "com.google.play".equals(var4);
            var2 = false;
            if(!var5) {
               return var2;
            }
         }

         var2 = true;
      }

      return var2;
   }
}
