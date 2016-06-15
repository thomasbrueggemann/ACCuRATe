package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

// $FF: renamed from: com.google.android.gms.internal.is
public class class_319 {
   // $FF: renamed from: HN boolean
   private static boolean field_789 = false;
   // $FF: renamed from: HO boolean
   private boolean field_790;
   // $FF: renamed from: HP boolean
   private boolean field_791;
   // $FF: renamed from: HQ java.lang.String
   private String field_792;
   protected final String mTag;

   public class_319(String var1) {
      this(var1, method_2229());
   }

   public class_319(String var1, boolean var2) {
      this.mTag = var1;
      this.field_790 = var2;
      this.field_791 = false;
   }

   // $FF: renamed from: go () boolean
   public static boolean method_2229() {
      return field_789;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.Object[]) void
   public void method_2230(String var1, Object... var2) {
      if(this.method_2238()) {
         Log.v(this.mTag, this.method_2236(var1, var2));
      }

   }

   // $FF: renamed from: a (java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public void method_2231(Throwable var1, String var2, Object... var3) {
      if(this.method_2237() || field_789) {
         Log.d(this.mTag, this.method_2236(var2, var3), var1);
      }

   }

   // $FF: renamed from: aK (java.lang.String) void
   public void method_2232(String var1) {
      String var2;
      if(TextUtils.isEmpty(var1)) {
         var2 = null;
      } else {
         var2 = String.format("[%s] ", new Object[]{var1});
      }

      this.field_792 = var2;
   }

   // $FF: renamed from: b (java.lang.String, java.lang.Object[]) void
   public void method_2233(String var1, Object... var2) {
      if(this.method_2237() || field_789) {
         Log.d(this.mTag, this.method_2236(var1, var2));
      }

   }

   // $FF: renamed from: c (java.lang.String, java.lang.Object[]) void
   public void method_2234(String var1, Object... var2) {
      Log.i(this.mTag, this.method_2236(var1, var2));
   }

   // $FF: renamed from: d (java.lang.String, java.lang.Object[]) void
   public void method_2235(String var1, Object... var2) {
      Log.w(this.mTag, this.method_2236(var1, var2));
   }

   // $FF: renamed from: e (java.lang.String, java.lang.Object[]) java.lang.String
   protected String method_2236(String var1, Object... var2) {
      if(var2.length != 0) {
         var1 = String.format(var1, var2);
      }

      if(!TextUtils.isEmpty(this.field_792)) {
         var1 = this.field_792 + var1;
      }

      return var1;
   }

   // $FF: renamed from: gm () boolean
   public boolean method_2237() {
      return this.field_790;
   }

   // $FF: renamed from: gn () boolean
   public boolean method_2238() {
      return this.field_791;
   }
}
