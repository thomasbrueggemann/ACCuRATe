package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> {
   private final RequestListener mRequestListener;
   private final SettableProducerContext mSettableProducerContext;

   protected AbstractProducerToDataSourceAdapter(Producer<T> var1, SettableProducerContext var2, RequestListener var3) {
      this.mSettableProducerContext = var2;
      this.mRequestListener = var3;
      this.mRequestListener.onRequestStart(var2.getImageRequest(), this.mSettableProducerContext.getCallerContext(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
      var1.produceResults(this.createConsumer(), var2);
   }

   private Consumer<T> createConsumer() {
      return new BaseConsumer() {
         protected void onCancellationImpl() {
            AbstractProducerToDataSourceAdapter.this.onCancellationImpl();
         }

         protected void onFailureImpl(Throwable var1) {
            AbstractProducerToDataSourceAdapter.this.onFailureImpl(var1);
         }

         protected void onNewResultImpl(@Nullable T var1, boolean var2) {
            AbstractProducerToDataSourceAdapter.this.onNewResultImpl(var1, var2);
         }

         protected void onProgressUpdateImpl(float var1) {
            AbstractProducerToDataSourceAdapter.this.setProgress(var1);
         }
      };
   }

   private void onCancellationImpl() {
      synchronized(this){}

      try {
         Preconditions.checkState(this.isClosed());
      } finally {
         ;
      }

   }

   private void onFailureImpl(Throwable var1) {
      if(super.setFailure(var1)) {
         this.mRequestListener.onRequestFailure(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), var1, this.mSettableProducerContext.isPrefetch());
      }

   }

   public boolean close() {
      if(!super.close()) {
         return false;
      } else {
         if(!super.isFinished()) {
            this.mRequestListener.onRequestCancellation(this.mSettableProducerContext.getId());
            this.mSettableProducerContext.cancel();
         }

         return true;
      }
   }

   protected void onNewResultImpl(@Nullable T var1, boolean var2) {
      if(super.setResult(var1, var2) && var2) {
         this.mRequestListener.onRequestSuccess(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
      }

   }
}
