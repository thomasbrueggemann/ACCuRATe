package com.facebook.common.executors;

import android.os.Handler;
import com.facebook.common.executors.HandlerExecutorService;
import com.facebook.common.executors.ScheduledFutureImpl;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class HandlerExecutorServiceImpl extends AbstractExecutorService implements HandlerExecutorService {
   private final Handler mHandler;

   public HandlerExecutorServiceImpl(Handler var1) {
      this.mHandler = var1;
   }

   public boolean awaitTermination(long var1, TimeUnit var3) throws InterruptedException {
      throw new UnsupportedOperationException();
   }

   public void execute(Runnable var1) {
      this.mHandler.post(var1);
   }

   public boolean isHandlerThread() {
      return Thread.currentThread() == this.mHandler.getLooper().getThread();
   }

   public boolean isShutdown() {
      return false;
   }

   public boolean isTerminated() {
      return false;
   }

   protected <T> ScheduledFutureImpl<T> newTaskFor(Runnable var1, T var2) {
      return new ScheduledFutureImpl(this.mHandler, var1, var2);
   }

   protected <T> ScheduledFutureImpl<T> newTaskFor(Callable<T> var1) {
      return new ScheduledFutureImpl(this.mHandler, var1);
   }

   public void quit() {
      this.mHandler.getLooper().quit();
   }

   public ScheduledFuture<?> schedule(Runnable var1, long var2, TimeUnit var4) {
      ScheduledFutureImpl var5 = this.newTaskFor(var1, (Object)null);
      this.mHandler.postDelayed(var5, var4.toMillis(var2));
      return var5;
   }

   public <V> ScheduledFuture<V> schedule(Callable<V> var1, long var2, TimeUnit var4) {
      ScheduledFutureImpl var5 = this.newTaskFor(var1);
      this.mHandler.postDelayed(var5, var4.toMillis(var2));
      return var5;
   }

   public ScheduledFuture<?> scheduleAtFixedRate(Runnable var1, long var2, long var4, TimeUnit var6) {
      throw new UnsupportedOperationException();
   }

   public ScheduledFuture<?> scheduleWithFixedDelay(Runnable var1, long var2, long var4, TimeUnit var6) {
      throw new UnsupportedOperationException();
   }

   public void shutdown() {
      throw new UnsupportedOperationException();
   }

   public List<Runnable> shutdownNow() {
      throw new UnsupportedOperationException();
   }

   public ScheduledFuture<?> submit(Runnable var1) {
      return this.submit(var1, (Void)null);
   }

   public <T> ScheduledFuture<T> submit(Runnable var1, @Nullable T var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         ScheduledFutureImpl var3 = this.newTaskFor(var1, var2);
         this.execute(var3);
         return var3;
      }
   }

   public <T> ScheduledFuture<T> submit(Callable<T> var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         ScheduledFutureImpl var2 = this.newTaskFor(var1);
         this.execute(var2);
         return var2;
      }
   }
}
