package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

// $FF: renamed from: com.google.android.gms.internal.go
public class class_324 {
   // $FF: renamed from: Ci boolean
   private static boolean field_1303 = false;
   // $FF: renamed from: Cj boolean
   private boolean field_1304;
   // $FF: renamed from: Ck boolean
   private boolean field_1305;
   // $FF: renamed from: Cl java.lang.String
   private String field_1306;
   private final String mTag;

   public class_324(String var1) {
      this(var1, method_2062());
   }

   public class_324(String var1, boolean var2) {
      this.mTag = var1;
      this.field_1304 = var2;
      this.field_1305 = false;
   }

   // $FF: renamed from: e (java.lang.String, java.lang.Object[]) java.lang.String
   private String method_2061(String var1, Object... var2) {
      String var3 = String.format(var1, var2);
      if(!TextUtils.isEmpty(this.field_1306)) {
         var3 = this.field_1306 + var3;
      }

      return var3;
   }

   // $FF: renamed from: en () boolean
   public static boolean method_2062() {
      return field_1303;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.Object[]) void
   public void method_2063(String var1, Object... var2) {
      if(this.method_2070()) {
         Log.v(this.mTag, this.method_2061(var1, var2));
      }

   }

   // $FF: renamed from: a (java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public void method_2064(Throwable var1, String var2, Object... var3) {
      if(this.method_2069() || field_1303) {
         Log.d(this.mTag, this.method_2061(var2, var3), var1);
      }

   }

   // $FF: renamed from: ap (java.lang.String) void
   public void method_2065(String var1) {
      String var2;
      if(TextUtils.isEmpty(var1)) {
         var2 = null;
      } else {
         var2 = String.format("[%s] ", new Object[]{var1});
      }

      this.field_1306 = var2;
   }

   // $FF: renamed from: b (java.lang.String, java.lang.Object[]) void
   public void method_2066(String var1, Object... var2) {
      if(this.method_2069() || field_1303) {
         Log.d(this.mTag, this.method_2061(var1, var2));
      }

   }

   // $FF: renamed from: c (java.lang.String, java.lang.Object[]) void
   public void method_2067(String var1, Object... var2) {
      Log.i(this.mTag, this.method_2061(var1, var2));
   }

   // $FF: renamed from: d (java.lang.String, java.lang.Object[]) void
   public void method_2068(String var1, Object... var2) {
      Log.w(this.mTag, this.method_2061(var1, var2));
   }

   // $FF: renamed from: el () boolean
   public boolean method_2069() {
      return this.field_1304;
   }

   // $FF: renamed from: em () boolean
   public boolean method_2070() {
      return this.field_1305;
   }
}
