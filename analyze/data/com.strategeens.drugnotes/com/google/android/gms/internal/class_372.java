package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.ey;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// $FF: renamed from: com.google.android.gms.internal.gh
@ey
public final class class_372 {
   // $FF: renamed from: ww java.util.concurrent.ThreadFactory
   private static final ThreadFactory field_1137 = new ThreadFactory() {
      // $FF: renamed from: wA java.util.concurrent.atomic.AtomicInteger
      private final AtomicInteger field_442 = new AtomicInteger(1);

      public Thread newThread(Runnable var1) {
         return new Thread(var1, "AdWorker #" + this.field_442.getAndIncrement());
      }
   };
   // $FF: renamed from: wx java.util.concurrent.ExecutorService
   private static final ExecutorService field_1138;

   static {
      field_1138 = Executors.newFixedThreadPool(10, field_1137);
   }

   // $FF: renamed from: a (java.lang.Runnable) java.util.concurrent.Future
   public static Future<Void> method_2539(final Runnable var0) {
      return submit(new Callable() {
         // $FF: synthetic method
         public Object call() throws Exception {
            return this.method_1596();
         }

         // $FF: renamed from: ds () java.lang.Void
         public Void method_1596() {
            var0.run();
            return null;
         }
      });
   }

   public static <T> Future<T> submit(final Callable<T> var0) {
      try {
         Future var2 = field_1138.submit(new Callable() {
            public T call() throws Exception {
               try {
                  Process.setThreadPriority(10);
                  Object var2 = var0.call();
                  return var2;
               } catch (Exception var3) {
                  class_381.method_2613(var3);
                  return null;
               }
            }
         });
         return var2;
      } catch (RejectedExecutionException var3) {
         class_368.method_2510("Thread execution is rejected.", var3);
         return new class_377((Object)null);
      }
   }
}
