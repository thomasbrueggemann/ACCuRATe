package com.google.android.gms.analytics;

import com.google.android.gms.analytics.class_669;

// $FF: renamed from: com.google.android.gms.analytics.o
public final class class_651 {
   // $FF: renamed from: b (java.lang.String, int) java.lang.String
   private static String method_3721(String var0, int var1) {
      if(var1 < 1) {
         class_669.method_3888("index out of range for " + var0 + " (" + var1 + ")");
         return "";
      } else {
         return var0 + var1;
      }
   }

   // $FF: renamed from: s (int) java.lang.String
   static String method_3722(int var0) {
      return method_3721("&cd", var0);
   }

   // $FF: renamed from: t (int) java.lang.String
   static String method_3723(int var0) {
      return method_3721("&cm", var0);
   }

   // $FF: renamed from: u (int) java.lang.String
   public static String method_3724(int var0) {
      return method_3721("&pr", var0);
   }

   // $FF: renamed from: v (int) java.lang.String
   public static String method_3725(int var0) {
      return method_3721("&promo", var0);
   }

   // $FF: renamed from: w (int) java.lang.String
   public static String method_3726(int var0) {
      return method_3721("pi", var0);
   }

   // $FF: renamed from: x (int) java.lang.String
   public static String method_3727(int var0) {
      return method_3721("&il", var0);
   }

   // $FF: renamed from: y (int) java.lang.String
   public static String method_3728(int var0) {
      return method_3721("cd", var0);
   }

   // $FF: renamed from: z (int) java.lang.String
   public static String method_3729(int var0) {
      return method_3721("cm", var0);
   }
}
