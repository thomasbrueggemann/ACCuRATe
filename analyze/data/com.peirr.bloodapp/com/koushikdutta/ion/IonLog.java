package com.koushikdutta.ion;

import android.util.Log;

class IonLog {
   public static final String LOGTAG = "ION";
   public static boolean debug = true;

   // $FF: renamed from: d (java.lang.String) void
   public static void method_8(String var0) {
      if(debug) {
         Log.d("ION", var0);
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.Exception) void
   public static void method_9(String var0, Exception var1) {
      if(debug) {
         Log.d("ION", var0, var1);
      }

   }

   // $FF: renamed from: e (java.lang.String) void
   public static void method_10(String var0) {
      Log.e("ION", var0);
   }

   // $FF: renamed from: e (java.lang.String, java.lang.Exception) void
   public static void method_11(String var0, Exception var1) {
      Log.e("ION", var0, var1);
   }

   // $FF: renamed from: i (java.lang.String) void
   public static void method_12(String var0) {
      Log.i("ION", var0);
   }

   // $FF: renamed from: i (java.lang.String, java.lang.Exception) void
   public static void method_13(String var0, Exception var1) {
      Log.i("ION", var0, var1);
   }

   // $FF: renamed from: w (java.lang.String) void
   public static void method_14(String var0) {
      Log.w("ION", var0);
   }

   // $FF: renamed from: w (java.lang.String, java.lang.Exception) void
   public static void method_15(String var0, Exception var1) {
      Log.w("ION", var0, var1);
   }
}
