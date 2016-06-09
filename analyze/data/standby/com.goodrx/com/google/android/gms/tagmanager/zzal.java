package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.zzbg;
import java.io.File;

class zzal {
   public static int version() {
      try {
         int var1 = Integer.parseInt(VERSION.SDK);
         return var1;
      } catch (NumberFormatException var2) {
         zzbg.method_353("Invalid version number: " + VERSION.SDK);
         return 0;
      }
   }

   @TargetApi(9)
   static boolean zzbo(String var0) {
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
}
