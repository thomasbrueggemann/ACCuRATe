package com.loopj.android.http;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.util.Log;
import com.loopj.android.http.LogInterface;

public class LogHandler implements LogInterface {
   boolean mLoggingEnabled = true;
   int mLoggingLevel = 2;

   @TargetApi(8)
   private void checkedWtf(String var1, String var2, Throwable var3) {
      Log.wtf(var1, var2, var3);
   }

   // $FF: renamed from: d (java.lang.String, java.lang.String) void
   public void method_1(String var1, String var2) {
      this.log(2, var1, var2);
   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_2(String var1, String var2, Throwable var3) {
      this.logWithThrowable(3, var1, var2, var3);
   }

   // $FF: renamed from: e (java.lang.String, java.lang.String) void
   public void method_3(String var1, String var2) {
      this.log(6, var1, var2);
   }

   // $FF: renamed from: e (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_4(String var1, String var2, Throwable var3) {
      this.logWithThrowable(6, var1, var2, var3);
   }

   // $FF: renamed from: i (java.lang.String, java.lang.String) void
   public void method_5(String var1, String var2) {
      this.log(4, var1, var2);
   }

   public boolean isLoggingEnabled() {
      return this.mLoggingEnabled;
   }

   public void log(int var1, String var2, String var3) {
      this.logWithThrowable(var1, var2, var3, (Throwable)null);
   }

   public void logWithThrowable(int var1, String var2, String var3, Throwable var4) {
      if(this.isLoggingEnabled() && this.shouldLog(var1)) {
         switch(var1) {
         case 2:
            Log.v(var2, var3, var4);
            return;
         case 3:
            Log.d(var2, var3, var4);
            return;
         case 4:
            Log.i(var2, var3, var4);
            return;
         case 5:
            Log.w(var2, var3, var4);
            return;
         case 6:
            Log.e(var2, var3, var4);
            return;
         case 7:
         default:
            break;
         case 8:
            if(Integer.valueOf(VERSION.SDK).intValue() > 8) {
               this.checkedWtf(var2, var3, var4);
               return;
            }

            Log.e(var2, var3, var4);
            return;
         }
      }

   }

   public boolean shouldLog(int var1) {
      return var1 >= this.mLoggingLevel;
   }

   // $FF: renamed from: v (java.lang.String, java.lang.String) void
   public void method_6(String var1, String var2) {
      this.log(2, var1, var2);
   }

   // $FF: renamed from: w (java.lang.String, java.lang.String) void
   public void method_7(String var1, String var2) {
      this.log(5, var1, var2);
   }

   // $FF: renamed from: w (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_8(String var1, String var2, Throwable var3) {
      this.logWithThrowable(5, var1, var2, var3);
   }
}
