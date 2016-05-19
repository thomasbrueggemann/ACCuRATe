package com.comscore.utils;

import android.os.Build;
import java.io.File;

public class RootDetector {
   // $FF: renamed from: a () boolean
   private static boolean method_74() {
      String var0 = Build.TAGS;
      return var0 != null && var0.contains("test-keys");
   }

   // $FF: renamed from: b () boolean
   private static boolean method_75() {
      boolean var1;
      try {
         var1 = (new File("/system/app/Superuser.apk")).exists();
      } catch (Exception var2) {
         return false;
      }

      if(var1) {
         return true;
      } else {
         return false;
      }
   }

   public static boolean isDeviceRooted() {
      return method_74() || method_75();
   }
}
