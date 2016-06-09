package com.google.android.gms.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.measurement.zzb;
import com.google.android.gms.measurement.zzc;
import com.google.android.gms.measurement.zzh;
import com.google.android.gms.measurement.zzi;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzg {
   private static volatile zzg zzaUv;
   private final Context mContext;
   private volatile zzpq zzQX;
   private final List<zzh> zzaUw;
   private final zzb zzaUx;
   private final zzg.zza zzaUy;
   private UncaughtExceptionHandler zzaUz;

   zzg(Context var1) {
      Context var2 = var1.getApplicationContext();
      zzx.zzz(var2);
      this.mContext = var2;
      this.zzaUy = new zzg.zza();
      this.zzaUw = new CopyOnWriteArrayList();
      this.zzaUx = new zzb();
   }

   public static zzg zzaS(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private void zzb(zzc var1) {
      zzx.zzcE("deliver should be called from worker thread");
      zzx.zzb(var1.zzAz(), "Measurement must be submitted");
      List var2 = var1.zzAw();
      if(!var2.isEmpty()) {
         HashSet var3 = new HashSet();
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            zzi var5 = (zzi)var4.next();
            Uri var6 = var5.zziA();
            if(!var3.contains(var6)) {
               var3.add(var6);
               var5.zzb(var1);
            }
         }
      }

   }

   public static void zzjk() {
      if(!(Thread.currentThread() instanceof zzg.zzc)) {
         throw new IllegalStateException("Call expected from worker thread");
      }
   }

   public Context getContext() {
      return this.mContext;
   }

   public zzpq zzAH() {
      // $FF: Couldn't be decompiled
   }

   public zzps zzAI() {
      DisplayMetrics var1 = this.mContext.getResources().getDisplayMetrics();
      zzps var2 = new zzps();
      var2.setLanguage(zzam.zza(Locale.getDefault()));
      var2.zziB(var1.widthPixels);
      var2.zziC(var1.heightPixels);
      return var2;
   }

   public void zza(UncaughtExceptionHandler var1) {
      this.zzaUz = var1;
   }

   public <V> Future<V> zzc(Callable<V> var1) {
      zzx.zzz(var1);
      if(Thread.currentThread() instanceof zzg.zzc) {
         FutureTask var3 = new FutureTask(var1);
         var3.run();
         return var3;
      } else {
         return this.zzaUy.submit(var1);
      }
   }

   void zze(zzc var1) {
      if(var1.zzAD()) {
         throw new IllegalStateException("Measurement prototype can\'t be submitted");
      } else if(var1.zzAz()) {
         throw new IllegalStateException("Measurement can only be submitted once");
      } else {
         final zzc var2 = var1.zzAu();
         var2.zzAA();
         this.zzaUy.execute(new Runnable() {
            public void run() {
               var2.zzAB().zza(var2);
               Iterator var1 = zzg.this.zzaUw.iterator();

               while(var1.hasNext()) {
                  ((zzh)var1.next()).zza(var2);
               }

               zzg.this.zzb(var2);
            }
         });
      }
   }

   public void zzf(Runnable var1) {
      zzx.zzz(var1);
      this.zzaUy.submit(var1);
   }

   private class zza extends ThreadPoolExecutor {
      public zza() {
         super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
         this.setThreadFactory(new zzg.zzb(null));
      }

      protected <T> RunnableFuture<T> newTaskFor(final Runnable var1, final T var2) {
         return new FutureTask(var1, var2) {
            protected void setException(Throwable var1) {
               UncaughtExceptionHandler var2 = zzg.this.zzaUz;
               if(var2 != null) {
                  var2.uncaughtException(Thread.currentThread(), var1);
               } else if(Log.isLoggable("GAv4", 6)) {
                  Log.e("GAv4", "MeasurementExecutor: job failed with " + var1);
               }

               super.setException(var1);
            }
         };
      }
   }

   private static class zzb implements ThreadFactory {
      private static final AtomicInteger zzaUD = new AtomicInteger();

      private zzb() {
      }

      // $FF: synthetic method
      zzb(Object var1) {
         this();
      }

      public Thread newThread(Runnable var1) {
         return new zzg.zzc(var1, "measurement-" + zzaUD.incrementAndGet());
      }
   }

   private static class zzc extends Thread {
      zzc(Runnable var1, String var2) {
         super(var1, var2);
      }

      public void run() {
         Process.setThreadPriority(10);
         super.run();
      }
   }
}
