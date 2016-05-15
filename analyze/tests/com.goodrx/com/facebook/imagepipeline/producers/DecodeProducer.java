package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.DownsampleUtil;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
   private static final String BITMAP_SIZE_KEY = "bitmapSize";
   private static final String HAS_GOOD_QUALITY_KEY = "hasGoodQuality";
   private static final String IMAGE_TYPE_KEY = "imageType";
   private static final String IS_FINAL_KEY = "isFinal";
   public static final String PRODUCER_NAME = "DecodeProducer";
   private final ByteArrayPool mByteArrayPool;
   private final boolean mDownsampleEnabled;
   private final boolean mDownsampleEnabledForNetwork;
   private final Executor mExecutor;
   private final ImageDecoder mImageDecoder;
   private final Producer<EncodedImage> mInputProducer;
   private final ProgressiveJpegConfig mProgressiveJpegConfig;

   public DecodeProducer(ByteArrayPool var1, Executor var2, ImageDecoder var3, ProgressiveJpegConfig var4, boolean var5, boolean var6, Producer<EncodedImage> var7) {
      this.mByteArrayPool = (ByteArrayPool)Preconditions.checkNotNull(var1);
      this.mExecutor = (Executor)Preconditions.checkNotNull(var2);
      this.mImageDecoder = (ImageDecoder)Preconditions.checkNotNull(var3);
      this.mProgressiveJpegConfig = (ProgressiveJpegConfig)Preconditions.checkNotNull(var4);
      this.mDownsampleEnabled = var5;
      this.mDownsampleEnabledForNetwork = var6;
      this.mInputProducer = (Producer)Preconditions.checkNotNull(var7);
   }

   // $FF: synthetic method
   static ImageDecoder access$600(DecodeProducer var0) {
      return var0.mImageDecoder;
   }

   public void produceResults(Consumer<CloseableReference<CloseableImage>> var1, ProducerContext var2) {
      Object var3;
      if(!UriUtil.isNetworkUri(var2.getImageRequest().getSourceUri())) {
         var3 = new DecodeProducer.LocalImagesProgressiveDecoder(var1, var2);
      } else {
         var3 = new DecodeProducer.NetworkImagesProgressiveDecoder(var1, var2, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig);
      }

      this.mInputProducer.produceResults((Consumer)var3, var2);
   }

   private class LocalImagesProgressiveDecoder extends DecodeProducer.ProgressiveDecoder {
      public LocalImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> var1, ProducerContext var2) {
         super();
      }

      protected int getIntermediateImageEndOffset(EncodedImage var1) {
         return var1.getSize();
      }

      protected QualityInfo getQualityInfo() {
         return ImmutableQualityInfo.method_328(0, false, false);
      }

      protected boolean updateDecodeJob(EncodedImage var1, boolean var2) {
         synchronized(this){}
         boolean var5;
         if(!var2) {
            var5 = false;
         } else {
            boolean var7 = false;

            boolean var4;
            try {
               var7 = true;
               var4 = super.updateDecodeJob(var1, var2);
               var7 = false;
            } finally {
               if(var7) {
                  ;
               }
            }

            var5 = var4;
         }

         return var5;
      }
   }

   private class NetworkImagesProgressiveDecoder extends DecodeProducer.ProgressiveDecoder {
      private int mLastScheduledScanNumber;
      private final ProgressiveJpegConfig mProgressiveJpegConfig;
      private final ProgressiveJpegParser mProgressiveJpegParser;

      public NetworkImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> var1, ProducerContext var2, ProgressiveJpegParser var3, ProgressiveJpegConfig var4) {
         super();
         this.mProgressiveJpegParser = (ProgressiveJpegParser)Preconditions.checkNotNull(var4);
         this.mProgressiveJpegConfig = (ProgressiveJpegConfig)Preconditions.checkNotNull(var5);
         this.mLastScheduledScanNumber = 0;
      }

      protected int getIntermediateImageEndOffset(EncodedImage var1) {
         return this.mProgressiveJpegParser.getBestScanEndOffset();
      }

      protected QualityInfo getQualityInfo() {
         return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
      }

      protected boolean updateDecodeJob(EncodedImage param1, boolean param2) {
         // $FF: Couldn't be decompiled
      }
   }

   private abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
      private final ImageDecodeOptions mImageDecodeOptions;
      @GuardedBy("this")
      private boolean mIsFinished;
      private final JobScheduler mJobScheduler;
      private final ProducerContext mProducerContext;
      private final ProducerListener mProducerListener;

      public ProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> var1, ProducerContext var2) {
         super(var2);
         this.mProducerContext = var3;
         this.mProducerListener = var3.getListener();
         this.mImageDecodeOptions = var3.getImageRequest().getImageDecodeOptions();
         this.mIsFinished = false;
         JobScheduler.JobRunnable var4 = new JobScheduler.JobRunnable() {
            public void run(EncodedImage var1, boolean var2) {
               if(var1 != null) {
                  if(DecodeProducer.this.mDownsampleEnabled) {
                     ImageRequest var3x = var3.getImageRequest();
                     if(DecodeProducer.this.mDownsampleEnabledForNetwork || !UriUtil.isNetworkUri(var3x.getSourceUri())) {
                        var1.setSampleSize(DownsampleUtil.determineSampleSize(var3x, var1));
                     }
                  }

                  ProgressiveDecoder.this.doDecode(var1, var2);
               }

            }
         };
         this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, var4, this.mImageDecodeOptions.minDecodeIntervalMs);
         this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onIsIntermediateResultExpectedChanged() {
               if(ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
                  ProgressiveDecoder.this.mJobScheduler.scheduleJob();
               }

            }
         });
      }

      private void doDecode(EncodedImage param1, boolean param2) {
         // $FF: Couldn't be decompiled
      }

      private Map<String, String> getExtraMap(@Nullable CloseableImage var1, long var2, QualityInfo var4, boolean var5) {
         if(!this.mProducerListener.requiresExtraMap(this.mProducerContext.getId())) {
            return null;
         } else {
            String var6 = String.valueOf(var2);
            String var7 = String.valueOf(var4.isOfGoodEnoughQuality());
            String var8 = String.valueOf(var5);
            String var9 = String.valueOf(this.mProducerContext.getImageRequest().getImageType());
            if(var1 instanceof CloseableStaticBitmap) {
               Bitmap var10 = ((CloseableStaticBitmap)var1).getUnderlyingBitmap();
               return ImmutableMap.method_209("bitmapSize", var10.getWidth() + "x" + var10.getHeight(), "queueTime", var6, "hasGoodQuality", var7, "isFinal", var8, "imageType", var9);
            } else {
               return ImmutableMap.method_208("queueTime", var6, "hasGoodQuality", var7, "isFinal", var8, "imageType", var9);
            }
         }
      }

      private void handleCancellation() {
         this.maybeFinish(true);
         this.getConsumer().onCancellation();
      }

      private void handleError(Throwable var1) {
         this.maybeFinish(true);
         this.getConsumer().onFailure(var1);
      }

      private void handleResult(CloseableImage var1, boolean var2) {
         CloseableReference var3 = CloseableReference.method_306(var1);

         try {
            this.maybeFinish(var2);
            this.getConsumer().onNewResult(var3, var2);
         } finally {
            CloseableReference.closeSafely(var3);
         }

      }

      private boolean isFinished() {
         synchronized(this){}

         boolean var2;
         try {
            var2 = this.mIsFinished;
         } finally {
            ;
         }

         return var2;
      }

      private void maybeFinish(boolean param1) {
         // $FF: Couldn't be decompiled
      }

      protected abstract int getIntermediateImageEndOffset(EncodedImage var1);

      protected abstract QualityInfo getQualityInfo();

      public void onCancellationImpl() {
         this.handleCancellation();
      }

      public void onFailureImpl(Throwable var1) {
         this.handleError(var1);
      }

      public void onNewResultImpl(EncodedImage var1, boolean var2) {
         if(var2 && !EncodedImage.isValid(var1)) {
            this.handleError(new NullPointerException("Encoded image is not valid."));
         } else if(this.updateDecodeJob(var1, var2) && (var2 || this.mProducerContext.isIntermediateResultExpected())) {
            this.mJobScheduler.scheduleJob();
            return;
         }

      }

      protected boolean updateDecodeJob(EncodedImage var1, boolean var2) {
         return this.mJobScheduler.updateJob(var1, var2);
      }
   }
}
