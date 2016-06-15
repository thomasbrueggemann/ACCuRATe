package com.google.android.gms.internal;

import android.content.Context;
import java.util.regex.Pattern;

// $FF: renamed from: com.google.android.gms.internal.lc
public final class class_722 {
   // $FF: renamed from: Oe java.util.regex.Pattern
   private static Pattern field_3332 = null;

   // $FF: renamed from: K (android.content.Context) boolean
   public static boolean method_4200(Context var0) {
      return var0.getPackageManager().hasSystemFeature("android.hardware.type.watch");
   }

   // $FF: renamed from: aS (int) int
   public static int method_4201(int var0) {
      return var0 / 1000;
   }

   // $FF: renamed from: aT (int) int
   public static int method_4202(int var0) {
      return var0 % 1000 / 100;
   }

   // $FF: renamed from: aU (int) boolean
   public static boolean method_4203(int var0) {
      return method_4202(var0) == 3;
   }
}
