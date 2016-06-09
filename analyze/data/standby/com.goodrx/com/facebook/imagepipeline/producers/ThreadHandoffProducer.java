package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.producers.StatefulProducerRunnable;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import java.util.Map;

public class ThreadHandoffProducer<T> implements Producer<T> {
   @VisibleForTesting
   protected static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
   private final Producer<T> mInputProducer;
   private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

   public ThreadHandoffProducer(Producer<T> var1, ThreadHandoffProducerQueue var2) {
      this.mInputProducer = (Producer)Preconditions.checkNotNull(var1);
      this.mThreadHandoffProducerQueue = var2;
   }

   public void produceResults(final Consumer<T> var1, final ProducerContext var2) {
      final ProducerListener var3 = var2.getListener();
      final String var4 = var2.getId();
      final StatefulProducerRunnable var5 = new StatefulProducerRunnable(var1, var3, "BackgroundThreadHandoffProducer", var4) {
         protected void disposeResult(T var1x) {
         }

         protected T getResult() throws Exception {
            return null;
         }

         protected void onSuccess(T var1x) {
            var3.onProducerFinishWithSuccess(var4, "BackgroundThreadHandoffProducer", (Map)null);
            ThreadHandoffProducer.this.mInputProducer.produceResults(var1, var2);
         }
      };
      var2.addCallbacks(new BaseProducerContextCallbacks() {
         public void onCancellationRequested() {
            var5.cancel();
            ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(var5);
         }
      });
      this.mThreadHandoffProducerQueue.addToQueueOrExecute(var5);
   }
}
