package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;

public class AddImageTransformMetaDataProducer implements Producer<EncodedImage> {
   private final Producer<EncodedImage> mInputProducer;

   public AddImageTransformMetaDataProducer(Producer<EncodedImage> var1) {
      this.mInputProducer = var1;
   }

   public void produceResults(Consumer<EncodedImage> var1, ProducerContext var2) {
      this.mInputProducer.produceResults(new AddImageTransformMetaDataProducer.AddImageTransformMetaDataConsumer(var1), var2);
   }

   private static class AddImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
      private AddImageTransformMetaDataConsumer(Consumer<EncodedImage> var1) {
         super(var1);
      }

      // $FF: synthetic method
      AddImageTransformMetaDataConsumer(Consumer var1, Object var2) {
         this(var1);
      }

      protected void onNewResultImpl(EncodedImage var1, boolean var2) {
         if(var1 == null) {
            this.getConsumer().onNewResult((Object)null, var2);
         } else {
            if(!EncodedImage.isMetaDataAvailable(var1)) {
               var1.parseMetaData();
            }

            this.getConsumer().onNewResult(var1, var2);
         }
      }
   }
}
