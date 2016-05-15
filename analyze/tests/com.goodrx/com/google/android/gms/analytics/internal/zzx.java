package com.google.android.gms.analytics.internal;

import android.os.Build.VERSION;
import com.google.android.gms.analytics.internal.zzae;
import java.io.File;

public class zzx {
   public static int version() {
      try {
         int var1 = Integer.parseInt(VERSION.SDK);
         return var1;
      } catch (NumberFormatException var2) {
         zzae.zzf("Invalid version number", VERSION.SDK);
         return 0;
      }
   }

   public static boolean zzbo(String var0) {
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
