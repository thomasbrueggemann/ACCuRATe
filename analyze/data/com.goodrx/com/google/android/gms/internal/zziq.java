package com.google.android.gms.internal;

import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjd;
import com.google.android.gms.internal.zzjg;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzhb
public final class zziq {
   private static final ExecutorService zzLU = Executors.newFixedThreadPool(10, zzaB("Default"));
   private static final ExecutorService zzLV = Executors.newFixedThreadPool(5, zzaB("Loader"));

   public static zzjg<Void> zza(int var0, final Runnable var1) {
      return var0 == 1?zza(zzLV, new Callable() {
         // $FF: synthetic method
         public Object call() throws Exception {
            return this.zzdt();
         }

         public Void zzdt() {
            var1.run();
            return null;
         }
      }):zza(zzLU, new Callable() {
         // $FF: synthetic method
         public Object call() throws Exception {
            return this.zzdt();
         }

         public Void zzdt() {
            var1.run();
            return null;
         }
      });
   }

   public static zzjg<Void> zza(Runnable var0) {
      return zza(0, var0);
   }

   public static <T> zzjg<T> zza(ExecutorService var0, final Callable<T> var1) {
      final zzjd var2 = new zzjd();

      try {
         var2.zzc(new Runnable() {
            // $FF: synthetic field
            final Future zzLZ;

            {
               this.zzLZ = var2x;
            }

            public void run() {
               if(var2.isCancelled()) {
                  this.zzLZ.cancel(true);
               }

            }
         });
         return var2;
      } catch (RejectedExecutionException var4) {
         zzin.zzd("Thread execution is rejected.", var4);
         var2.cancel(true);
         return var2;
      }
   }

   private static ThreadFactory zzaB(final String var0) {
      return new ThreadFactory() {
         private final AtomicInteger zzMa = new AtomicInteger(1);

         public Thread newThread(Runnable var1) {
            return new Thread(var1, "AdWorker(" + var0 + ") #" + this.zzMa.getAndIncrement());
         }
      };
   }
}
