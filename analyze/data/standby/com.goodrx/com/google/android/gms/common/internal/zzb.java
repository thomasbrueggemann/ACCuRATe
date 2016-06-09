package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

public final class zzb {
   public static void zza(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   public static void zzab(boolean var0) {
      if(!var0) {
         throw new IllegalStateException();
      }
   }

   public static void zzcD(String var0) {
      if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
         Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
         throw new IllegalStateException(var0);
      }
   }

   public static void zzcE(String var0) {
      if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
         Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
         throw new IllegalStateException(var0);
      }
   }

   public static void zzv(Object var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("null reference");
      }
   }
}
