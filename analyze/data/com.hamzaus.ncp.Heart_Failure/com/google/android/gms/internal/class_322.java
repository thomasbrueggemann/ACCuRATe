package com.google.android.gms.internal;

import android.os.Looper;
import android.util.Log;

// $FF: renamed from: com.google.android.gms.internal.gy
public final class class_322 {
   // $FF: renamed from: A (boolean) void
   public static void method_2050(boolean var0) {
      if(!var0) {
         throw new IllegalStateException();
      }
   }

   // $FF: renamed from: a (boolean, java.lang.Object) void
   public static void method_2051(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   // $FF: renamed from: ay (java.lang.String) void
   public static void method_2052(String var0) {
      if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
         Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
         throw new IllegalStateException(var0);
      }
   }

   // $FF: renamed from: az (java.lang.String) void
   public static void method_2053(String var0) {
      if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
         Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
         throw new IllegalStateException(var0);
      }
   }

   // $FF: renamed from: c (java.lang.Object) void
   public static void method_2054(Object var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("null reference");
      }
   }
}
