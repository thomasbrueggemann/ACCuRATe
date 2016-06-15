package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.gr
@ey
public final class class_368 {
   // $FF: renamed from: S (java.lang.String) void
   public static void method_2502(String var0) {
      if(method_2511(3)) {
         Log.d("Ads", var0);
      }

   }

   // $FF: renamed from: T (java.lang.String) void
   public static void method_2503(String var0) {
      if(method_2511(6)) {
         Log.e("Ads", var0);
      }

   }

   // $FF: renamed from: U (java.lang.String) void
   public static void method_2504(String var0) {
      if(method_2511(4)) {
         Log.i("Ads", var0);
      }

   }

   // $FF: renamed from: V (java.lang.String) void
   public static void method_2505(String var0) {
      if(method_2511(2)) {
         Log.v("Ads", var0);
      }

   }

   // $FF: renamed from: W (java.lang.String) void
   public static void method_2506(String var0) {
      if(method_2511(5)) {
         Log.w("Ads", var0);
      }

   }

   // $FF: renamed from: a (java.lang.String, java.lang.Throwable) void
   public static void method_2507(String var0, Throwable var1) {
      if(method_2511(3)) {
         Log.d("Ads", var0, var1);
      }

   }

   // $FF: renamed from: b (java.lang.String, java.lang.Throwable) void
   public static void method_2508(String var0, Throwable var1) {
      if(method_2511(6)) {
         Log.e("Ads", var0, var1);
      }

   }

   // $FF: renamed from: c (java.lang.String, java.lang.Throwable) void
   public static void method_2509(String var0, Throwable var1) {
      if(method_2511(4)) {
         Log.i("Ads", var0, var1);
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.Throwable) void
   public static void method_2510(String var0, Throwable var1) {
      if(method_2511(5)) {
         Log.w("Ads", var0, var1);
      }

   }

   // $FF: renamed from: v (int) boolean
   public static boolean method_2511(int var0) {
      return (var0 >= 5 || Log.isLoggable("Ads", var0)) && var0 != 2;
   }
}
