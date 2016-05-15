package android.support.v4.os;

import android.os.Trace;

class TraceJellybeanMR2 {
   public static void beginSection(String var0) {
      Trace.beginSection(var0);
   }

   public static void endSection() {
      Trace.endSection();
   }
}
