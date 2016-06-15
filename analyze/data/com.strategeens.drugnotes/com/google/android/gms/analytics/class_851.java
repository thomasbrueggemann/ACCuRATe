package com.google.android.gms.analytics;

import com.google.android.gms.analytics.class_863;

// $FF: renamed from: com.google.android.gms.analytics.s
public final class class_851 {
   // $FF: renamed from: A (int) java.lang.String
   public static String method_4713(int var0) {
      return method_4719("&pr", var0);
   }

   // $FF: renamed from: B (int) java.lang.String
   public static String method_4714(int var0) {
      return method_4719("&promo", var0);
   }

   // $FF: renamed from: C (int) java.lang.String
   public static String method_4715(int var0) {
      return method_4719("pi", var0);
   }

   // $FF: renamed from: D (int) java.lang.String
   public static String method_4716(int var0) {
      return method_4719("&il", var0);
   }

   // $FF: renamed from: E (int) java.lang.String
   public static String method_4717(int var0) {
      return method_4719("cd", var0);
   }

   // $FF: renamed from: F (int) java.lang.String
   public static String method_4718(int var0) {
      return method_4719("cm", var0);
   }

   // $FF: renamed from: d (java.lang.String, int) java.lang.String
   private static String method_4719(String var0, int var1) {
      if(var1 < 1) {
         class_863.method_4839("index out of range for " + var0 + " (" + var1 + ")");
         return "";
      } else {
         return var0 + var1;
      }
   }

   // $FF: renamed from: y (int) java.lang.String
   static String method_4720(int var0) {
      return method_4719("&cd", var0);
   }

   // $FF: renamed from: z (int) java.lang.String
   static String method_4721(int var0) {
      return method_4719("&cm", var0);
   }
}
