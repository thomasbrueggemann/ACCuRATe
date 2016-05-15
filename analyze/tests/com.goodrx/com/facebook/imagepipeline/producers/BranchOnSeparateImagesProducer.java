package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;

public class BranchOnSeparateImagesProducer implements Producer<EncodedImage> {
   private final Producer<EncodedImage> mInputProducer1;
   private final Producer<EncodedImage> mInputProducer2;

   public BranchOnSeparateImagesProducer(Producer<EncodedImage> var1, Producer<EncodedImage> var2) {
      this.mInputProducer1 = var1;
      this.mInputProducer2 = var2;
   }

   public void produceResults(Consumer<EncodedImage> var1, ProducerContext var2) {
      BranchOnSeparateImagesProducer.OnFirstImageConsumer var3 = new BranchOnSeparateImagesProducer.OnFirstImageConsumer(var1, var2);
      this.mInputProducer1.produceResults(var3, var2);
   }

   private class OnFirstImageConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
      private ProducerContext mProducerContext;

      private OnFirstImageConsumer(Consumer<EncodedImage> var1, ProducerContext var2) {
         super(var2);
         this.mProducerContext = var3;
      }

      // $FF: synthetic method
      OnFirstImageConsumer(Consumer var2, ProducerContext var3, Object var4) {
         this();
      }

      private boolean isResultGoodEnough(EncodedImage var1, ImageRequest var2) {
         return var1 != null && var1.getWidth() >= var2.getPreferredWidth() && var1.getHeight() >= var2.getPreferredHeight();
      }

      protected void onFailureImpl(Throwable var1) {
         BranchOnSeparateImagesProducer.this.mInputProducer2.produceResults(this.getConsumer(), this.mProducerContext);
      }

      protected void onNewResultImpl(EncodedImage var1, boolean var2) {
         ImageRequest var3 = this.mProducerContext.getImageRequest();
         boolean var4 = this.isResultGoodEnough(var1, var3);
         if(var1 != null && (var4 || var3.getLocalThumbnailPreviewsEnabled())) {
            Consumer var5 = this.getConsumer();
            boolean var6;
            if(var2 && var4) {
               var6 = true;
            } else {
               var6 = false;
            }

            var5.onNewResult(var1, var6);
         }

         if(var2 && !var4) {
            BranchOnSeparateImagesProducer.this.mInputProducer2.produceResults(this.getConsumer(), this.mProducerContext);
         }

      }
   }
}
