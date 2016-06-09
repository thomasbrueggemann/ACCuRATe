package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;

public class RemoveImageTransformMetaDataProducer implements Producer<CloseableReference<PooledByteBuffer>> {
   private final Producer<EncodedImage> mInputProducer;

   public RemoveImageTransformMetaDataProducer(Producer<EncodedImage> var1) {
      this.mInputProducer = var1;
   }

   public void produceResults(Consumer<CloseableReference<PooledByteBuffer>> var1, ProducerContext var2) {
      this.mInputProducer.produceResults(new RemoveImageTransformMetaDataProducer.RemoveImageTransformMetaDataConsumer(var1), var2);
   }

   private class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>> {
      private RemoveImageTransformMetaDataConsumer(Consumer<CloseableReference<PooledByteBuffer>> var1) {
         super(var2);
      }

      // $FF: synthetic method
      RemoveImageTransformMetaDataConsumer(Consumer var2, Object var3) {
         this();
      }

      protected void onNewResultImpl(EncodedImage param1, boolean param2) {
         // $FF: Couldn't be decompiled
      }
   }
}
