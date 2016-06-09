package com.koushikdutta.async.future;

import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;

public abstract class TransformFuture<T, F> extends SimpleFuture<T> implements FutureCallback<F> {
   protected void error(Exception var1) {
      this.setComplete(var1);
   }

   public TransformFuture<T, F> from(Future<F> var1) {
      this.setParent(var1);
      var1.setCallback(this);
      return this;
   }

   public void onCompleted(Exception var1, F var2) {
      if(!this.isCancelled()) {
         if(var1 != null) {
            this.error(var1);
         } else {
            try {
               this.transform(var2);
            } catch (Exception var4) {
               this.error(var4);
            }
         }
      }
   }

   protected abstract void transform(F var1) throws Exception;
}
