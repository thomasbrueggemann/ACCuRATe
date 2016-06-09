package com.facebook.common.executors;

import com.facebook.common.logging.FLog;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstrainedExecutorService extends AbstractExecutorService {
   private static final Class<?> TAG = ConstrainedExecutorService.class;
   private final Executor mExecutor;
   private volatile int mMaxConcurrency;
   private final AtomicInteger mMaxQueueSize;
   private final String mName;
   private final AtomicInteger mPendingWorkers;
   private final ConstrainedExecutorService.Worker mTaskRunner;
   private final BlockingQueue<Runnable> mWorkQueue;

   public ConstrainedExecutorService(String var1, int var2, Executor var3, BlockingQueue<Runnable> var4) {
      if(var2 <= 0) {
         throw new IllegalArgumentException("max concurrency must be > 0");
      } else {
         this.mName = var1;
         this.mExecutor = var3;
         this.mMaxConcurrency = var2;
         this.mWorkQueue = var4;
         this.mTaskRunner = new ConstrainedExecutorService.Worker();
         this.mPendingWorkers = new AtomicInteger(0);
         this.mMaxQueueSize = new AtomicInteger(0);
      }
   }

   // $FF: synthetic method
   static BlockingQueue access$100(ConstrainedExecutorService var0) {
      return var0.mWorkQueue;
   }

   // $FF: synthetic method
   static Class access$200() {
      return TAG;
   }

   // $FF: synthetic method
   static String access$300(ConstrainedExecutorService var0) {
      return var0.mName;
   }

   // $FF: synthetic method
   static AtomicInteger access$400(ConstrainedExecutorService var0) {
      return var0.mPendingWorkers;
   }

   // $FF: synthetic method
   static void access$500(ConstrainedExecutorService var0) {
      var0.startWorkerIfNeeded();
   }

   public static ConstrainedExecutorService newConstrainedExecutor(String var0, int var1, int var2, Executor var3) {
      return new ConstrainedExecutorService(var0, var1, var3, new LinkedBlockingQueue(var2));
   }

   private void startWorkerIfNeeded() {
      for(int var1 = this.mPendingWorkers.get(); var1 < this.mMaxConcurrency; var1 = this.mPendingWorkers.get()) {
         int var2 = var1 + 1;
         if(this.mPendingWorkers.compareAndSet(var1, var2)) {
            FLog.method_420(TAG, "%s: starting worker %d of %d", this.mName, Integer.valueOf(var2), Integer.valueOf(this.mMaxConcurrency));
            this.mExecutor.execute(this.mTaskRunner);
            break;
         }

         FLog.method_418(TAG, "%s: race in startWorkerIfNeeded; retrying", this.mName);
      }

   }

   public boolean awaitTermination(long var1, TimeUnit var3) throws InterruptedException {
      throw new UnsupportedOperationException();
   }

   public void execute(Runnable var1) {
      if(var1 == null) {
         throw new NullPointerException("runnable parameter is null");
      } else if(!this.mWorkQueue.offer(var1)) {
         throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mWorkQueue.size());
      } else {
         int var2 = this.mWorkQueue.size();
         int var3 = this.mMaxQueueSize.get();
         if(var2 > var3 && this.mMaxQueueSize.compareAndSet(var3, var2)) {
            FLog.method_419(TAG, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(var2));
         }

         this.startWorkerIfNeeded();
      }
   }

   public boolean isIdle() {
      return this.mWorkQueue.isEmpty() && this.mPendingWorkers.get() == 0;
   }

   public boolean isShutdown() {
      return false;
   }

   public boolean isTerminated() {
      return false;
   }

   public void shutdown() {
      throw new UnsupportedOperationException();
   }

   public List<Runnable> shutdownNow() {
      throw new UnsupportedOperationException();
   }

   private class Worker implements Runnable {
      private Worker() {
      }

      // $FF: synthetic method
      Worker(Object var2) {
         this();
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
