package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.BaseProducerContext;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerContextCallbacks;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {
   private final Producer<T> mInputProducer;
   @VisibleForTesting
   @GuardedBy("this")
   final Map<K, MultiplexProducer<K, T>.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer> mMultiplexers;

   protected MultiplexProducer(Producer<T> var1) {
      this.mInputProducer = var1;
      this.mMultiplexers = new HashMap();
   }

   // $FF: synthetic method
   static MultiplexProducer.Multiplexer access$100(MultiplexProducer var0, Object var1) {
      return var0.getExistingMultiplexer(var1);
   }

   // $FF: synthetic method
   static void access$700(MultiplexProducer var0, Object var1, MultiplexProducer.Multiplexer var2) {
      var0.removeMultiplexer(var1, var2);
   }

   // $FF: synthetic method
   static Producer access$900(MultiplexProducer var0) {
      return var0.mInputProducer;
   }

   private MultiplexProducer<K, T>.com/facebook/imagepipeline/producers/MultiplexProducer$com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer createAndPutNewMultiplexer(K var1) {
      synchronized(this){}

      MultiplexProducer.Multiplexer var2;
      try {
         var2 = new MultiplexProducer.Multiplexer(var1);
         this.mMultiplexers.put(var1, var2);
      } finally {
         ;
      }

      return var2;
   }

   private MultiplexProducer<K, T>.com/facebook/imagepipeline/producers/MultiplexProducer$com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer getExistingMultiplexer(K var1) {
      synchronized(this){}

      MultiplexProducer.Multiplexer var3;
      try {
         var3 = (MultiplexProducer.Multiplexer)this.mMultiplexers.get(var1);
      } finally {
         ;
      }

      return var3;
   }

   private void removeMultiplexer(K var1, MultiplexProducer<K, T>.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer var2) {
      synchronized(this){}

      try {
         if(this.mMultiplexers.get(var1) == var2) {
            this.mMultiplexers.remove(var1);
         }
      } finally {
         ;
      }

   }

   protected abstract T cloneOrNull(T var1);

   protected abstract K getKey(ProducerContext var1);

   public void produceResults(Consumer<T> param1, ProducerContext param2) {
      // $FF: Couldn't be decompiled
   }

   @VisibleForTesting
   class Multiplexer {
      private final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> mConsumerContextPairs = Sets.newCopyOnWriteArraySet();
      @Nullable
      @GuardedBy("Multiplexer.this")
      private MultiplexProducer<K, T>.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$ForwardingConsumer mForwardingConsumer;
      private final K mKey;
      @Nullable
      @GuardedBy("Multiplexer.this")
      private T mLastIntermediateResult;
      @GuardedBy("Multiplexer.this")
      private float mLastProgress;
      @Nullable
      @GuardedBy("Multiplexer.this")
      private BaseProducerContext mMultiplexProducerContext;

      public Multiplexer(K var1) {
         this.mKey = var2;
      }

      // $FF: synthetic method
      static void access$000(MultiplexProducer.Multiplexer var0) {
         var0.startInputProducerIfHasAttachedConsumers();
      }

      // $FF: synthetic method
      static CopyOnWriteArraySet access$200(MultiplexProducer.Multiplexer var0) {
         return var0.mConsumerContextPairs;
      }

      // $FF: synthetic method
      static BaseProducerContext access$300(MultiplexProducer.Multiplexer var0) {
         return var0.mMultiplexProducerContext;
      }

      private void addCallbacks(final Pair<Consumer<T>, ProducerContext> var1, ProducerContext var2) {
         var2.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
               // $FF: Couldn't be decompiled
            }

            public void onIsIntermediateResultExpectedChanged() {
               BaseProducerContext.callOnIsIntermediateResultExpectedChanged(Multiplexer.this.updateIsIntermediateResultExpected());
            }

            public void onIsPrefetchChanged() {
               BaseProducerContext.callOnIsPrefetchChanged(Multiplexer.this.updateIsPrefetch());
            }

            public void onPriorityChanged() {
               BaseProducerContext.callOnPriorityChanged(Multiplexer.this.updatePriority());
            }
         });
      }

      private void closeSafely(Closeable var1) {
         if(var1 != null) {
            try {
               var1.close();
            } catch (IOException var3) {
               throw new RuntimeException(var3);
            }
         }

      }

      private boolean computeIsIntermediateResultExpected() {
         // $FF: Couldn't be decompiled
      }

      private boolean computeIsPrefetch() {
         // $FF: Couldn't be decompiled
      }

      private Priority computePriority() {
         // $FF: Couldn't be decompiled
      }

      private void startInputProducerIfHasAttachedConsumers() {
         // $FF: Couldn't be decompiled
      }

      @Nullable
      private List<ProducerContextCallbacks> updateIsIntermediateResultExpected() {
         // $FF: Couldn't be decompiled
      }

      @Nullable
      private List<ProducerContextCallbacks> updateIsPrefetch() {
         // $FF: Couldn't be decompiled
      }

      @Nullable
      private List<ProducerContextCallbacks> updatePriority() {
         // $FF: Couldn't be decompiled
      }

      public boolean addNewConsumer(Consumer<T> param1, ProducerContext param2) {
         // $FF: Couldn't be decompiled
      }

      public void onCancelled(MultiplexProducer<K, T>.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$ForwardingConsumer param1) {
         // $FF: Couldn't be decompiled
      }

      public void onFailure(MultiplexProducer<K, T>.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$ForwardingConsumer param1, Throwable param2) {
         // $FF: Couldn't be decompiled
      }

      public void onNextResult(MultiplexProducer<K, T>.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$ForwardingConsumer param1, T param2, boolean param3) {
         // $FF: Couldn't be decompiled
      }

      public void onProgressUpdate(MultiplexProducer<K, T>.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer.com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$ForwardingConsumer param1, float param2) {
         // $FF: Couldn't be decompiled
      }
   }

   private class ForwardingConsumer extends BaseConsumer<T> {
      private ForwardingConsumer() {
      }

      // $FF: synthetic method
      ForwardingConsumer(Object var2) {
         this();
      }

      protected void onCancellationImpl() {
         MultiplexProducer.this.onCancelled(this);
      }

      protected void onFailureImpl(Throwable var1) {
         MultiplexProducer.this.onFailure(this, var1);
      }

      protected void onNewResultImpl(T var1, boolean var2) {
         MultiplexProducer.this.onNextResult(this, var1, var2);
      }

      protected void onProgressUpdateImpl(float var1) {
         MultiplexProducer.this.onProgressUpdate(this, var1);
      }
   }
}
