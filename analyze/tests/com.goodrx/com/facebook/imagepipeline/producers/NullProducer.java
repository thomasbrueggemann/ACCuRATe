package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;

public class NullProducer<T> implements Producer<T> {
   public void produceResults(Consumer<T> var1, ProducerContext var2) {
      var1.onNewResult((Object)null, true);
   }
}
