package com.google.android.gms.internal;

import android.content.Context;
import java.util.regex.Pattern;

// $FF: renamed from: com.google.android.gms.internal.ij
public final class class_282 {
   // $FF: renamed from: Hr java.util.regex.Pattern
   private static Pattern field_959 = null;

   // $FF: renamed from: C (android.content.Context) boolean
   public static boolean method_1869(Context var0) {
      return var0.getPackageManager().hasSystemFeature("android.hardware.type.watch");
   }

   // $FF: renamed from: aB (int) int
   public static int method_1870(int var0) {
      return var0 / 1000;
   }

   // $FF: renamed from: aC (int) int
   public static int method_1871(int var0) {
      return var0 % 1000 / 100;
   }

   // $FF: renamed from: aD (int) boolean
   public static boolean method_1872(int var0) {
      return method_1871(var0) == 3;
   }
}
