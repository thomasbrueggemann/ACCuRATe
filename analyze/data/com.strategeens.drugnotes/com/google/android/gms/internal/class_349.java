package com.google.android.gms.internal;

import android.os.Looper;
import android.util.Log;

// $FF: renamed from: com.google.android.gms.internal.je
public final class class_349 {
   // $FF: renamed from: K (boolean) void
   public static void method_2425(boolean var0) {
      if(!var0) {
         throw new IllegalStateException();
      }
   }

   // $FF: renamed from: a (boolean, java.lang.Object) void
   public static void method_2426(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   // $FF: renamed from: aU (java.lang.String) void
   public static void method_2427(String var0) {
      if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
         Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
         throw new IllegalStateException(var0);
      }
   }

   // $FF: renamed from: aV (java.lang.String) void
   public static void method_2428(String var0) {
      if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
         Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
         throw new IllegalStateException(var0);
      }
   }

   // $FF: renamed from: f (java.lang.Object) void
   public static void method_2429(Object var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("null reference");
      }
   }
}
