package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_820;

// $FF: renamed from: com.google.android.gms.internal.jp
public final class class_339 {
   // $FF: renamed from: Nq java.lang.String
   private final String field_898;

   public class_339(String var1) {
      this.field_898 = (String)class_335.method_2311(var1);
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_2323(Context var1, String var2, String var3, Throwable var4) {
      StackTraceElement[] var5 = var4.getStackTrace();
      StringBuilder var6 = new StringBuilder();

      for(int var7 = 0; var7 < var5.length && var7 < 2; ++var7) {
         var6.append(var5[var7].toString());
         var6.append("\n");
      }

      class_820 var8 = new class_820(var1, 10);
      String[] var9 = new String[]{"GMS_WTF", var6.toString()};
      var8.method_4477("GMS_WTF", (byte[])null, var9);
      var8.send();
      if(this.method_2325(7)) {
         Log.e(var2, var3, var4);
         Log.wtf(var2, var3, var4);
      }

   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_2324(String var1, String var2, Throwable var3) {
      if(this.method_2325(4)) {
         Log.i(var1, var2, var3);
      }

   }

   // $FF: renamed from: aF (int) boolean
   public boolean method_2325(int var1) {
      return Log.isLoggable(this.field_898, var1);
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_2326(String var1, String var2, Throwable var3) {
      if(this.method_2325(5)) {
         Log.w(var1, var2, var3);
      }

   }

   // $FF: renamed from: c (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_2327(String var1, String var2, Throwable var3) {
      if(this.method_2325(6)) {
         Log.e(var1, var2, var3);
      }

   }

   // $FF: renamed from: m (java.lang.String, java.lang.String) void
   public void method_2328(String var1, String var2) {
      if(this.method_2325(3)) {
         Log.d(var1, var2);
      }

   }

   // $FF: renamed from: n (java.lang.String, java.lang.String) void
   public void method_2329(String var1, String var2) {
      if(this.method_2325(2)) {
         Log.v(var1, var2);
      }

   }

   // $FF: renamed from: o (java.lang.String, java.lang.String) void
   public void method_2330(String var1, String var2) {
      if(this.method_2325(5)) {
         Log.w(var1, var2);
      }

   }

   // $FF: renamed from: p (java.lang.String, java.lang.String) void
   public void method_2331(String var1, String var2) {
      if(this.method_2325(6)) {
         Log.e(var1, var2);
      }

   }
}
