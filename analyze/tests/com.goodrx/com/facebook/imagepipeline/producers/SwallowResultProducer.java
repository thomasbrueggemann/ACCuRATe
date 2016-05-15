package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;

public class SwallowResultProducer<T> implements Producer<Void> {
   private final Producer<T> mInputProducer;

   public SwallowResultProducer(Producer<T> var1) {
      this.mInputProducer = var1;
   }

   public void produceResults(final Consumer<Void> var1, ProducerContext var2) {
      DelegatingConsumer var3 = new DelegatingConsumer(var1) {
         protected void onNewResultImpl(T var1, boolean var2) {
            if(var2) {
               this.getConsumer().onNewResult((Object)null, var2);
            }

         }
      };
      this.mInputProducer.produceResults(var3, var2);
   }
}
