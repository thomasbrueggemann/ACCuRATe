package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.internal.class_347;

// $FF: renamed from: com.google.android.gms.internal.hg
public final class class_352 {
   // $FF: renamed from: GF java.lang.String
   private final String field_1526;

   public class_352(String var1) {
      this.field_1526 = (String)class_347.method_2170(var1);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_2230(String var1, String var2, Throwable var3) {
      if(this.method_2231(4)) {
         Log.i(var1, var2, var3);
      }

   }

   // $FF: renamed from: ap (int) boolean
   public boolean method_2231(int var1) {
      return Log.isLoggable(this.field_1526, var1);
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String, java.lang.Throwable) void
   public void method_2232(String var1, String var2, Throwable var3) {
      if(this.method_2231(6)) {
         Log.e(var1, var2, var3);
      }

   }

   // $FF: renamed from: i (java.lang.String, java.lang.String) void
   public void method_2233(String var1, String var2) {
      if(this.method_2231(2)) {
         Log.v(var1, var2);
      }

   }

   // $FF: renamed from: j (java.lang.String, java.lang.String) void
   public void method_2234(String var1, String var2) {
      if(this.method_2231(5)) {
         Log.w(var1, var2);
      }

   }

   // $FF: renamed from: k (java.lang.String, java.lang.String) void
   public void method_2235(String var1, String var2) {
      if(this.method_2231(6)) {
         Log.e(var1, var2);
      }

   }
}
