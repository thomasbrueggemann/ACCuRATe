package com.facebook.common.logging;

import android.util.Log;
import com.facebook.common.logging.LoggingDelegate;
import java.io.PrintWriter;
import java.io.StringWriter;

public class FLogDefaultLoggingDelegate implements LoggingDelegate {
   public static final FLogDefaultLoggingDelegate sInstance = new FLogDefaultLoggingDelegate();
   private String mApplicationTag = "unknown";
   private int mMinimumLoggingLevel = 5;

   public static FLogDefaultLoggingDelegate getInstance() {
      return sInstance;
   }

   private static String getMsg(String var0, Throwable var1) {
      return var0 + '\n' + getStackTraceString(var1);
   }

   private static String getStackTraceString(Throwable var0) {
      if(var0 == null) {
         return "";
      } else {
         StringWriter var1 = new StringWriter();
         var0.printStackTrace(new PrintWriter(var1));
         return var1.toString();
      }
   }

   private String prefixTag(String var1) {
      if(this.mApplicationTag != null) {
         var1 = this.mApplicationTag + ":" + var1;
      }

      return var1;
   }

   private void println(int var1, String var2, String var3) {
      Log.println(var1, this.prefixTag(var2), var3);
   }

   private void println(int var1, String var2, String var3, Throwable var4) {
      Log.println(var1, this.prefixTag(var2), getMsg(var3, var4));
   }

   // $FF: renamed from: d (java.lang.String, java.lang.String) void
   public void method_9(String var1, String var2) {
      this.println(3, var1, var2);
   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_10(String var1, String var2, Throwable var3) {
      this.println(3, var1, var2, var3);
   }

   // $FF: renamed from: e (java.lang.String, java.lang.String) void
   public void method_11(String var1, String var2) {
      this.println(6, var1, var2);
   }

   // $FF: renamed from: e (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_12(String var1, String var2, Throwable var3) {
      this.println(6, var1, var2, var3);
   }

   public int getMinimumLoggingLevel() {
      return this.mMinimumLoggingLevel;
   }

   // $FF: renamed from: i (java.lang.String, java.lang.String) void
   public void method_13(String var1, String var2) {
      this.println(4, var1, var2);
   }

   // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_14(String var1, String var2, Throwable var3) {
      this.println(4, var1, var2, var3);
   }

   public boolean isLoggable(int var1) {
      return this.mMinimumLoggingLevel <= var1;
   }

   public void log(int var1, String var2, String var3) {
      this.println(var1, var2, var3);
   }

   public void setApplicationTag(String var1) {
      this.mApplicationTag = var1;
   }

   public void setMinimumLoggingLevel(int var1) {
      this.mMinimumLoggingLevel = var1;
   }

   // $FF: renamed from: v (java.lang.String, java.lang.String) void
   public void method_15(String var1, String var2) {
      this.println(2, var1, var2);
   }

   // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_16(String var1, String var2, Throwable var3) {
      this.println(2, var1, var2, var3);
   }

   // $FF: renamed from: w (java.lang.String, java.lang.String) void
   public void method_17(String var1, String var2) {
      this.println(5, var1, var2);
   }

   // $FF: renamed from: w (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_18(String var1, String var2, Throwable var3) {
      this.println(5, var1, var2, var3);
   }

   public void wtf(String var1, String var2) {
      this.println(6, var1, var2);
   }

   public void wtf(String var1, String var2, Throwable var3) {
      this.println(6, var1, var2, var3);
   }
}
