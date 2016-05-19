package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class zzv extends zzz {
   private zzv.zzc zzaXI;
   private zzv.zzc zzaXJ;
   private final BlockingQueue<FutureTask<?>> zzaXK = new LinkedBlockingQueue();
   private final BlockingQueue<FutureTask<?>> zzaXL = new LinkedBlockingQueue();
   private final UncaughtExceptionHandler zzaXM = new zzv.zzb("Thread death: Uncaught exception on worker thread");
   private final UncaughtExceptionHandler zzaXN = new zzv.zzb("Thread death: Uncaught exception on network thread");
   private final Object zzaXO = new Object();
   private final Semaphore zzaXP = new Semaphore(2);
   private volatile boolean zzaXQ;

   zzv(zzw var1) {
      super(var1);
   }

   // $FF: synthetic method
   static zzv.zzc zza(zzv var0, zzv.zzc var1) {
      var0.zzaXI = var1;
      return var1;
   }

   // $FF: synthetic method
   static Semaphore zza(zzv var0) {
      return var0.zzaXP;
   }

   private void zza(FutureTask<?> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static zzv.zzc zzb(zzv var0, zzv.zzc var1) {
      var0.zzaXJ = var1;
      return var1;
   }

   private void zzb(FutureTask<?> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static boolean zzb(zzv var0) {
      return var0.zzaXQ;
   }

   // $FF: synthetic method
   static Object zzc(zzv var0) {
      return var0.zzaXO;
   }

   // $FF: synthetic method
   static zzv.zzc zzd(zzv var0) {
      return var0.zzaXI;
   }

   // $FF: synthetic method
   static zzv.zzc zze(zzv var0) {
      return var0.zzaXJ;
   }

   public void zzCd() {
      if(Thread.currentThread() != this.zzaXJ) {
         throw new IllegalStateException("Call expected from network thread");
      }
   }

   public <V> Future<V> zzd(Callable<V> var1) throws IllegalStateException {
      this.zzjv();
      com.google.android.gms.common.internal.zzx.zzz(var1);
      zzv.zza var3 = new zzv.zza(var1, "Task exception on worker thread");
      if(Thread.currentThread() == this.zzaXI) {
         var3.run();
         return var3;
      } else {
         this.zza((FutureTask)var3);
         return var3;
      }
   }

   public void zzg(Runnable var1) throws IllegalStateException {
      this.zzjv();
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zza((FutureTask)(new zzv.zza(var1, "Task exception on worker thread")));
   }

   public void zzh(Runnable var1) throws IllegalStateException {
      this.zzjv();
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzb((FutureTask)(new zzv.zza(var1, "Task exception on network thread")));
   }

   protected void zziJ() {
   }

   public void zzjk() {
      if(Thread.currentThread() != this.zzaXI) {
         throw new IllegalStateException("Call expected from worker thread");
      }
   }

   private final class zza<V> extends FutureTask<V> {
      private final String zzaXR;

      zza(Runnable var2, String var3) {
         super(var2, (Object)null);
         com.google.android.gms.common.internal.zzx.zzz(var3);
         this.zzaXR = var3;
      }

      zza(Callable<V> var1, String var2) {
         super(var2);
         com.google.android.gms.common.internal.zzx.zzz(var3);
         this.zzaXR = var3;
      }

      protected void setException(Throwable var1) {
         zzv.this.zzAo().zzCE().zzj(this.zzaXR, var1);
         super.setException(var1);
      }
   }

   private final class zzb implements UncaughtExceptionHandler {
      private final String zzaXR;

      public zzb(String var2) {
         com.google.android.gms.common.internal.zzx.zzz(var2);
         this.zzaXR = var2;
      }

      public void uncaughtException(Thread var1, Throwable var2) {
         synchronized(this){}

         try {
            zzv.this.zzAo().zzCE().zzj(this.zzaXR, var2);
         } finally {
            ;
         }

      }
   }

   private final class zzc extends Thread {
      private final Object zzaXT;
      private final BlockingQueue<FutureTask<?>> zzaXU;

      public zzc(String var1, BlockingQueue<FutureTask<?>> var2) {
         com.google.android.gms.common.internal.zzx.zzz(var2);
         this.zzaXT = new Object();
         this.zzaXU = var3;
         this.setName(var2);
      }

      private void zza(InterruptedException var1) {
         zzv.this.zzAo().zzCF().zzj(this.getName() + " was interrupted", var1);
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }

      public void zzfb() {
         // $FF: Couldn't be decompiled
      }
   }
}
