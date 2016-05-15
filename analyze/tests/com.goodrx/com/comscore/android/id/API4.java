package com.comscore.android.id;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;

@SuppressLint({"NewApi"})
public class API4 {
   // $FF: renamed from: a boolean
   private static boolean field_474 = false;
   // $FF: renamed from: b boolean
   private static boolean field_475 = false;

   public static boolean isPackageInstalledFromGooglePlayStore(Context var0) {
      if(field_474) {
         return field_475;
      } else {
         if(VERSION.SDK_INT > 4) {
            String var2;
            try {
               var2 = var0.getPackageManager().getInstallerPackageName(var0.getPackageName());
            } catch (Exception var3) {
               field_474 = true;
               field_475 = false;
               return false;
            }

            if("com.android.vending".equals(var2) || "com.google.play".equals(var2)) {
               field_474 = true;
               field_475 = true;
               return true;
            }
         }

         field_474 = true;
         field_475 = false;
         return false;
      }
   }
}
