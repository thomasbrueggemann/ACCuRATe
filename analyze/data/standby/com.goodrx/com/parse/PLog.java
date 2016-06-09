package com.parse;

import android.util.Log;

class PLog {
   public static final int LOG_LEVEL_NONE = Integer.MAX_VALUE;
   private static int logLevel = Integer.MAX_VALUE;

   // $FF: renamed from: d (java.lang.String, java.lang.String) void
   static void method_359(String var0, String var1) {
      method_360(var0, var1, (Throwable)null);
   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Throwable) void
   static void method_360(String var0, String var1, Throwable var2) {
      log(3, var0, var1, var2);
   }

   // $FF: renamed from: e (java.lang.String, java.lang.String) void
   static void method_361(String var0, String var1) {
      method_362(var0, var1, (Throwable)null);
   }

   // $FF: renamed from: e (java.lang.String, java.lang.String, java.lang.Throwable) void
   static void method_362(String var0, String var1, Throwable var2) {
      log(6, var0, var1, var2);
   }

   public static int getLogLevel() {
      return logLevel;
   }

   // $FF: renamed from: i (java.lang.String, java.lang.String) void
   static void method_363(String var0, String var1) {
      method_364(var0, var1, (Throwable)null);
   }

   // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Throwable) void
   static void method_364(String var0, String var1, Throwable var2) {
      log(4, var0, var1, var2);
   }

   private static void log(int var0, String var1, String var2, Throwable var3) {
      if(var0 >= logLevel) {
         if(var3 != null) {
            Log.println(logLevel, var1, var2 + '\n' + Log.getStackTraceString(var3));
            return;
         }

         Log.println(logLevel, var1, var2);
      }

   }

   public static void setLogLevel(int var0) {
      logLevel = var0;
   }

   // $FF: renamed from: v (java.lang.String, java.lang.String) void
   static void method_365(String var0, String var1) {
      method_366(var0, var1, (Throwable)null);
   }

   // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Throwable) void
   static void method_366(String var0, String var1, Throwable var2) {
      log(2, var0, var1, var2);
   }

   // $FF: renamed from: w (java.lang.String, java.lang.String) void
   static void method_367(String var0, String var1) {
      method_368(var0, var1, (Throwable)null);
   }

   // $FF: renamed from: w (java.lang.String, java.lang.String, java.lang.Throwable) void
   static void method_368(String var0, String var1, Throwable var2) {
      log(5, var0, var1, var2);
   }
}
