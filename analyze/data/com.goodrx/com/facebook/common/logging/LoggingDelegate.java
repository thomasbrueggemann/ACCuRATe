package com.facebook.common.logging;

public interface LoggingDelegate {
   // $FF: renamed from: d (java.lang.String, java.lang.String) void
   void method_9(String var1, String var2);

   // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Throwable) void
   void method_10(String var1, String var2, Throwable var3);

   // $FF: renamed from: e (java.lang.String, java.lang.String) void
   void method_11(String var1, String var2);

   // $FF: renamed from: e (java.lang.String, java.lang.String, java.lang.Throwable) void
   void method_12(String var1, String var2, Throwable var3);

   int getMinimumLoggingLevel();

   // $FF: renamed from: i (java.lang.String, java.lang.String) void
   void method_13(String var1, String var2);

   // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Throwable) void
   void method_14(String var1, String var2, Throwable var3);

   boolean isLoggable(int var1);

   void log(int var1, String var2, String var3);

   void setMinimumLoggingLevel(int var1);

   // $FF: renamed from: v (java.lang.String, java.lang.String) void
   void method_15(String var1, String var2);

   // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Throwable) void
   void method_16(String var1, String var2, Throwable var3);

   // $FF: renamed from: w (java.lang.String, java.lang.String) void
   void method_17(String var1, String var2);

   // $FF: renamed from: w (java.lang.String, java.lang.String, java.lang.Throwable) void
   void method_18(String var1, String var2, Throwable var3);

   void wtf(String var1, String var2);

   void wtf(String var1, String var2, Throwable var3);
}
