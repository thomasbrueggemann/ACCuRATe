package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.StatefulProducerRunnable;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
   @VisibleForTesting
   static final String CREATED_THUMBNAIL = "createdThumbnail";
   @VisibleForTesting
   static final String PRODUCER_NAME = "VideoThumbnailProducer";
   private final Executor mExecutor;

   public LocalVideoThumbnailProducer(Executor var1) {
      this.mExecutor = var1;
   }

   private static int calculateKind(ImageRequest var0) {
      return var0.getPreferredWidth() <= 96 && var0.getPreferredHeight() <= 96?3:1;
   }

   public void produceResults(final Consumer<CloseableReference<CloseableImage>> var1, ProducerContext var2) {
      final StatefulProducerRunnable var3 = new StatefulProducerRunnable(var1, var2.getListener(), "VideoThumbnailProducer", var2.getId()) {
         // $FF: synthetic field
         final ImageRequest val$imageRequest;

         {
            this.val$imageRequest = var6;
         }

         protected void disposeResult(CloseableReference<CloseableImage> var1) {
            CloseableReference.closeSafely(var1);
         }

         protected Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> var1) {
            boolean var2;
            if(var1 != null) {
               var2 = true;
            } else {
               var2 = false;
            }

            return ImmutableMap.method_205("createdThumbnail", String.valueOf(var2));
         }

         protected CloseableReference<CloseableImage> getResult() throws Exception {
            Bitmap var1 = ThumbnailUtils.createVideoThumbnail(this.val$imageRequest.getSourceFile().getPath(), LocalVideoThumbnailProducer.calculateKind(this.val$imageRequest));
            return var1 == null?null:CloseableReference.method_306(new CloseableStaticBitmap(var1, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
         }
      };
      var2.addCallbacks(new BaseProducerContextCallbacks() {
         public void onCancellationRequested() {
            var3.cancel();
         }
      });
      this.mExecutor.execute(var3);
   }
}
