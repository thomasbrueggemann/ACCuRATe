package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.class_370;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// $FF: renamed from: com.google.android.gms.internal.eo
public final class class_366 {
   // $FF: renamed from: se java.util.concurrent.ThreadFactory
   private static final ThreadFactory field_1578 = new ThreadFactory() {
      // $FF: renamed from: sh java.util.concurrent.atomic.AtomicInteger
      private final AtomicInteger field_2169 = new AtomicInteger(1);

      public Thread newThread(Runnable var1) {
         return new Thread(var1, "AdWorker #" + this.field_2169.getAndIncrement());
      }
   };
   // $FF: renamed from: sf java.util.concurrent.ThreadPoolExecutor
   private static final ThreadPoolExecutor field_1579;

   static {
      field_1579 = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), field_1578);
   }

   public static void execute(final Runnable var0) {
      try {
         field_1579.execute(new Runnable() {
            public void run() {
               Process.setThreadPriority(10);
               var0.run();
            }
         });
      } catch (RejectedExecutionException var2) {
         class_370.method_2361("Too many background threads already running. Aborting task.  Current pool size: " + getPoolSize(), var2);
      }
   }

   public static int getPoolSize() {
      return field_1579.getPoolSize();
   }
}
