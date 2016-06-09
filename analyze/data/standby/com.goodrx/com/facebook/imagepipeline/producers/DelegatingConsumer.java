package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;

public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {
   private final Consumer<O> mConsumer;

   public DelegatingConsumer(Consumer<O> var1) {
      this.mConsumer = var1;
   }

   public Consumer<O> getConsumer() {
      return this.mConsumer;
   }

   protected void onCancellationImpl() {
      this.mConsumer.onCancellation();
   }

   protected void onFailureImpl(Throwable var1) {
      this.mConsumer.onFailure(var1);
   }

   protected void onProgressUpdateImpl(float var1) {
      this.mConsumer.onProgressUpdate(var1);
   }
}
