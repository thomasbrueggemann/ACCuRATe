package com.koushikdutta.async.future;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.DependentFuture;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleCancellable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SimpleFuture<T> extends SimpleCancellable implements DependentFuture<T> {
   FutureCallback<T> callback;
   Exception exception;
   T result;
   AsyncServer.AsyncSemaphore waiter;

   private T getResult() throws ExecutionException {
      if(this.exception != null) {
         throw new ExecutionException(this.exception);
      } else {
         return this.result;
      }
   }

   private void handleCallbackUnlocked(FutureCallback<T> var1) {
      if(var1 != null) {
         var1.onCompleted(this.exception, this.result);
      }

   }

   private FutureCallback<T> handleCompleteLocked() {
      FutureCallback var1 = this.callback;
      this.callback = null;
      return var1;
   }

   public boolean cancel() {
      // $FF: Couldn't be decompiled
   }

   public boolean cancel(boolean var1) {
      return this.cancel();
   }

   AsyncServer.AsyncSemaphore ensureWaiterLocked() {
      if(this.waiter == null) {
         this.waiter = new AsyncServer.AsyncSemaphore();
      }

      return this.waiter;
   }

   public T get() throws InterruptedException, ExecutionException {
      // $FF: Couldn't be decompiled
   }

   public T get(long param1, TimeUnit param3) throws InterruptedException, ExecutionException, TimeoutException {
      // $FF: Couldn't be decompiled
   }

   public FutureCallback<T> getCompletionCallback() {
      return new FutureCallback() {
         public void onCompleted(Exception var1, T var2) {
            SimpleFuture.this.setComplete(var1, var2);
         }
      };
   }

   void releaseWaiterLocked() {
      if(this.waiter != null) {
         this.waiter.release();
         this.waiter = null;
      }

   }

   public SimpleFuture<T> reset() {
      super.reset();
      this.result = null;
      this.exception = null;
      this.waiter = null;
      this.callback = null;
      return this;
   }

   public SimpleFuture<T> setCallback(FutureCallback<T> param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean setComplete() {
      return this.setComplete((Object)null);
   }

   public boolean setComplete(Exception param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean setComplete(Exception var1, T var2) {
      return var1 != null?this.setComplete(var1):this.setComplete(var2);
   }

   public boolean setComplete(T param1) {
      // $FF: Couldn't be decompiled
   }

   public SimpleFuture<T> setParent(Cancellable var1) {
      super.setParent(var1);
      return this;
   }
}
