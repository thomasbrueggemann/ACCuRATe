package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.class_515;
import java.io.File;

// $FF: renamed from: com.google.android.gms.tagmanager.ak
class class_548 {
   // $FF: renamed from: N (java.lang.String) boolean
   static boolean method_3101(String var0) {
      if(version() < 9) {
         return false;
      } else {
         File var1 = new File(var0);
         var1.setReadable(false, false);
         var1.setWritable(false, false);
         var1.setReadable(true, true);
         var1.setWritable(true, true);
         return true;
      }
   }

   public static int version() {
      try {
         int var1 = Integer.parseInt(VERSION.SDK);
         return var1;
      } catch (NumberFormatException var2) {
         class_515.method_2916("Invalid version number: " + VERSION.SDK);
         return 0;
      }
   }
}
