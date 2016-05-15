package com.google.ads.conversiontracking;

import android.os.Looper;

// $FF: renamed from: com.google.ads.conversiontracking.p
public final class class_85 {
   // $FF: renamed from: a (java.lang.String) void
   public static void method_561(String var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException(var0);
      }
   }
}
