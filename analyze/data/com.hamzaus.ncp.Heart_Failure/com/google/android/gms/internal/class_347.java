package com.google.android.gms.internal;

import android.os.Looper;
import android.text.TextUtils;

// $FF: renamed from: com.google.android.gms.internal.hn
public final class class_347 {
   // $FF: renamed from: A (boolean) void
   public static void method_2159(boolean var0) {
      if(!var0) {
         throw new IllegalStateException();
      }
   }

   // $FF: renamed from: C (boolean) void
   public static void method_2160(boolean var0) {
      if(!var0) {
         throw new IllegalArgumentException();
      }
   }

   // $FF: renamed from: a (boolean, java.lang.Object) void
   public static void method_2161(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   // $FF: renamed from: a (boolean, java.lang.String, java.lang.Object[]) void
   public static void method_2162(boolean var0, String var1, Object... var2) {
      if(!var0) {
         throw new IllegalStateException(String.format(var1, var2));
      }
   }

   // $FF: renamed from: aE (java.lang.String) java.lang.String
   public static String method_2163(String var0) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("Given String is empty or null");
      } else {
         return var0;
      }
   }

   // $FF: renamed from: ay (java.lang.String) void
   public static void method_2164(String var0) {
      if(Looper.myLooper() != Looper.getMainLooper()) {
         throw new IllegalStateException(var0);
      }
   }

   // $FF: renamed from: az (java.lang.String) void
   public static void method_2165(String var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException(var0);
      }
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object) java.lang.Object
   public static <T> T method_2166(T var0, Object var1) {
      if(var0 == null) {
         throw new NullPointerException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   // $FF: renamed from: b (java.lang.String, java.lang.Object) java.lang.String
   public static String method_2167(String var0, Object var1) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   // $FF: renamed from: b (boolean, java.lang.Object) void
   public static void method_2168(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      }
   }

   // $FF: renamed from: b (boolean, java.lang.String, java.lang.Object[]) void
   public static void method_2169(boolean var0, String var1, Object... var2) {
      if(!var0) {
         throw new IllegalArgumentException(String.format(var1, var2));
      }
   }

   // $FF: renamed from: f (java.lang.Object) java.lang.Object
   public static <T> T method_2170(T var0) {
      if(var0 == null) {
         throw new NullPointerException("null reference");
      } else {
         return var0;
      }
   }
}
