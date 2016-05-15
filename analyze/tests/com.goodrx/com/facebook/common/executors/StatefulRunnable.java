package com.facebook.common.executors;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class StatefulRunnable<T> implements Runnable {
   protected static final int STATE_CANCELLED = 2;
   protected static final int STATE_CREATED = 0;
   protected static final int STATE_FAILED = 4;
   protected static final int STATE_FINISHED = 3;
   protected static final int STATE_STARTED = 1;
   protected final AtomicInteger mState = new AtomicInteger(0);

   public void cancel() {
      if(this.mState.compareAndSet(0, 2)) {
         this.onCancellation();
      }

   }

   protected void disposeResult(T var1) {
   }

   protected abstract T getResult() throws Exception;

   protected void onCancellation() {
   }

   protected void onFailure(Exception var1) {
   }

   protected void onSuccess(T var1) {
   }

   public final void run() {
      if(this.mState.compareAndSet(0, 1)) {
         Object var2;
         try {
            var2 = this.getResult();
         } catch (Exception var7) {
            this.mState.set(4);
            this.onFailure(var7);
            return;
         }

         this.mState.set(3);

         try {
            this.onSuccess(var2);
         } finally {
            this.disposeResult(var2);
         }

      }
   }
}
