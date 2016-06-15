package com.google.android.gms.internal;

import android.os.Looper;
import android.text.TextUtils;

// $FF: renamed from: com.google.android.gms.internal.jx
public final class class_335 {
   // $FF: renamed from: K (boolean) void
   public static void method_2300(boolean var0) {
      if(!var0) {
         throw new IllegalStateException();
      }
   }

   // $FF: renamed from: L (boolean) void
   public static void method_2301(boolean var0) {
      if(!var0) {
         throw new IllegalArgumentException();
      }
   }

   // $FF: renamed from: a (boolean, java.lang.Object) void
   public static void method_2302(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   // $FF: renamed from: a (boolean, java.lang.String, java.lang.Object[]) void
   public static void method_2303(boolean var0, String var1, Object... var2) {
      if(!var0) {
         throw new IllegalStateException(String.format(var1, var2));
      }
   }

   // $FF: renamed from: aU (java.lang.String) void
   public static void method_2304(String var0) {
      if(Looper.myLooper() != Looper.getMainLooper()) {
         throw new IllegalStateException(var0);
      }
   }

   // $FF: renamed from: aV (java.lang.String) void
   public static void method_2305(String var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException(var0);
      }
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object) java.lang.Object
   public static <T> T method_2306(T var0, Object var1) {
      if(var0 == null) {
         throw new NullPointerException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   // $FF: renamed from: b (java.lang.String, java.lang.Object) java.lang.String
   public static String method_2307(String var0, Object var1) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   // $FF: renamed from: b (boolean, java.lang.Object) void
   public static void method_2308(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      }
   }

   // $FF: renamed from: b (boolean, java.lang.String, java.lang.Object[]) void
   public static void method_2309(boolean var0, String var1, Object... var2) {
      if(!var0) {
         throw new IllegalArgumentException(String.format(var1, var2));
      }
   }

   // $FF: renamed from: bb (java.lang.String) java.lang.String
   public static String method_2310(String var0) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("Given String is empty or null");
      } else {
         return var0;
      }
   }

   // $FF: renamed from: i (java.lang.Object) java.lang.Object
   public static <T> T method_2311(T var0) {
      if(var0 == null) {
         throw new NullPointerException("null reference");
      } else {
         return var0;
      }
   }
}
