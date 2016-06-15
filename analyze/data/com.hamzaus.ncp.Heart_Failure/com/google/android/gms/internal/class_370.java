package com.google.android.gms.internal;

import android.util.Log;

// $FF: renamed from: com.google.android.gms.internal.ev
public final class class_370 {
   // $FF: renamed from: A (java.lang.String) void
   public static void method_2355(String var0) {
      if(method_2362(6)) {
         Log.e("Ads", var0);
      }

   }

   // $FF: renamed from: B (java.lang.String) void
   public static void method_2356(String var0) {
      if(method_2362(4)) {
         Log.i("Ads", var0);
      }

   }

   // $FF: renamed from: C (java.lang.String) void
   public static void method_2357(String var0) {
      if(method_2362(2)) {
         Log.v("Ads", var0);
      }

   }

   // $FF: renamed from: D (java.lang.String) void
   public static void method_2358(String var0) {
      if(method_2362(5)) {
         Log.w("Ads", var0);
      }

   }

   // $FF: renamed from: a (java.lang.String, java.lang.Throwable) void
   public static void method_2359(String var0, Throwable var1) {
      if(method_2362(3)) {
         Log.d("Ads", var0, var1);
      }

   }

   // $FF: renamed from: b (java.lang.String, java.lang.Throwable) void
   public static void method_2360(String var0, Throwable var1) {
      if(method_2362(6)) {
         Log.e("Ads", var0, var1);
      }

   }

   // $FF: renamed from: c (java.lang.String, java.lang.Throwable) void
   public static void method_2361(String var0, Throwable var1) {
      if(method_2362(5)) {
         Log.w("Ads", var0, var1);
      }

   }

   // $FF: renamed from: p (int) boolean
   public static boolean method_2362(int var0) {
      return (var0 >= 5 || Log.isLoggable("Ads", var0)) && var0 != 2;
   }

   // $FF: renamed from: z (java.lang.String) void
   public static void method_2363(String var0) {
      if(method_2362(3)) {
         Log.d("Ads", var0);
      }

   }
}
