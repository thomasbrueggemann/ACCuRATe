package android.support.v4.os;

import android.os.Build.VERSION;
import android.support.v4.os.TraceJellybeanMR2;

public final class TraceCompat {
   public static void beginSection(String var0) {
      if(VERSION.SDK_INT >= 18) {
         TraceJellybeanMR2.beginSection(var0);
      }

   }

   public static void endSection() {
      if(VERSION.SDK_INT >= 18) {
         TraceJellybeanMR2.endSection();
      }

   }
}
