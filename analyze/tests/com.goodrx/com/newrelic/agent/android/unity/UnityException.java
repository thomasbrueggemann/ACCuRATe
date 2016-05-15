package com.newrelic.agent.android.unity;

import android.text.TextUtils;

public class UnityException extends RuntimeException {
   private String sourceExceptionType = null;

   public UnityException() {
   }

   public UnityException(String var1) {
      super(var1);
   }

   public UnityException(String var1, String var2) {
      super(var2);
      this.sourceExceptionType = var1;
   }

   public UnityException(String var1, StackTraceElement[] var2) {
      super(var1);
      this.setStackTrace(var2);
   }

   public void appendStackFrame(StackTraceElement var1) {
      StackTraceElement[] var2 = this.getStackTrace();
      StackTraceElement[] var3 = new StackTraceElement[1 + var2.length];

      for(int var4 = 0; var4 < var2.length; ++var4) {
         var3[var4] = var2[var4];
      }

      var3[var2.length] = var1;
      this.setStackTrace(var3);
   }

   public void appendStackFrame(String var1, String var2, String var3, int var4) {
      StackTraceElement var5 = new StackTraceElement(var1, var2, var3, var4);
      StackTraceElement[] var6 = this.getStackTrace();
      StackTraceElement[] var7 = new StackTraceElement[1 + var6.length];

      for(int var8 = 0; var8 < var6.length; ++var8) {
         var7[var8] = var6[var8];
      }

      var7[var6.length] = var5;
      this.setStackTrace(var7);
   }

   public void setSourceExceptionType(String var1) {
      this.sourceExceptionType = var1;
   }

   public String toString() {
      return TextUtils.isEmpty(this.sourceExceptionType)?this.getClass().getName():this.sourceExceptionType;
   }
}
