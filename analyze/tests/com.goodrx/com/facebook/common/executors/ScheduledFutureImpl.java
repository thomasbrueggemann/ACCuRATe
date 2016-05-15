package com.facebook.common.executors;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

public class ScheduledFutureImpl<V> implements RunnableFuture<V>, ScheduledFuture<V> {
   private final Handler mHandler;
   private final FutureTask<V> mListenableFuture;

   public ScheduledFutureImpl(Handler var1, Runnable var2, @Nullable V var3) {
      this.mHandler = var1;
      this.mListenableFuture = new FutureTask(var2, var3);
   }

   public ScheduledFutureImpl(Handler var1, Callable<V> var2) {
      this.mHandler = var1;
      this.mListenableFuture = new FutureTask(var2);
   }

   public boolean cancel(boolean var1) {
      return this.mListenableFuture.cancel(var1);
   }

   public int compareTo(Delayed var1) {
      throw new UnsupportedOperationException();
   }

   public V get() throws InterruptedException, ExecutionException {
      return this.mListenableFuture.get();
   }

   public V get(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException {
      return this.mListenableFuture.get(var1, var3);
   }

   public long getDelay(TimeUnit var1) {
      throw new UnsupportedOperationException();
   }

   public boolean isCancelled() {
      return this.mListenableFuture.isCancelled();
   }

   public boolean isDone() {
      return this.mListenableFuture.isDone();
   }

   public void run() {
      this.mListenableFuture.run();
   }
}
