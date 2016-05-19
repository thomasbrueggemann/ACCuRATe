package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class ResizeAndRotateProducer implements Producer<EncodedImage> {
   @VisibleForTesting
   static final int DEFAULT_JPEG_QUALITY = 85;
   private static final String FRACTION_KEY = "Fraction";
   @VisibleForTesting
   static final int MAX_JPEG_SCALE_NUMERATOR = 8;
   @VisibleForTesting
   static final int MIN_TRANSFORM_INTERVAL_MS = 100;
   private static final String ORIGINAL_SIZE_KEY = "Original size";
   private static final String PRODUCER_NAME = "ResizeAndRotateProducer";
   private static final String REQUESTED_SIZE_KEY = "Requested size";
   private static final float ROUNDUP_FRACTION = 0.6666667F;
   private final Executor mExecutor;
   private final Producer<EncodedImage> mInputProducer;
   private final PooledByteBufferFactory mPooledByteBufferFactory;

   public ResizeAndRotateProducer(Executor var1, PooledByteBufferFactory var2, Producer<EncodedImage> var3) {
      this.mExecutor = (Executor)Preconditions.checkNotNull(var1);
      this.mPooledByteBufferFactory = (PooledByteBufferFactory)Preconditions.checkNotNull(var2);
      this.mInputProducer = (Producer)Preconditions.checkNotNull(var3);
   }

   // $FF: synthetic method
   static PooledByteBufferFactory access$600(ResizeAndRotateProducer var0) {
      return var0.mPooledByteBufferFactory;
   }

   // $FF: synthetic method
   static int access$700(ImageRequest var0, EncodedImage var1) {
      return getScaleNumerator(var0, var1);
   }

   // $FF: synthetic method
   static int access$800(ImageRequest var0, EncodedImage var1) {
      return getRotationAngle(var0, var1);
   }

   @VisibleForTesting
   static float determineResizeRatio(ResizeOptions var0, int var1, int var2) {
      float var3;
      if(var0 == null) {
         var3 = 1.0F;
      } else {
         var3 = Math.max((float)var0.width / (float)var1, (float)var0.height / (float)var2);
         if(var3 * (float)var1 > 2048.0F) {
            var3 = 2048.0F / (float)var1;
         }

         if(var3 * (float)var2 > 2048.0F) {
            return 2048.0F / (float)var2;
         }
      }

      return var3;
   }

   private static int getRotationAngle(ImageRequest var0, EncodedImage var1) {
      if(!var0.getAutoRotateEnabled()) {
         return 0;
      } else {
         int var2;
         boolean var3;
         label18: {
            var2 = var1.getRotationAngle();
            if(var2 != 0 && var2 != 90 && var2 != 180) {
               var3 = false;
               if(var2 != 270) {
                  break label18;
               }
            }

            var3 = true;
         }

         Preconditions.checkArgument(var3);
         return var2;
      }
   }

   private static int getScaleNumerator(ImageRequest var0, EncodedImage var1) {
      ResizeOptions var2 = var0.getResizeOptions();
      int var7;
      if(var2 == null) {
         var7 = 8;
      } else {
         int var3 = getRotationAngle(var0, var1);
         boolean var4;
         if(var3 != 90 && var3 != 270) {
            var4 = false;
         } else {
            var4 = true;
         }

         int var5;
         if(var4) {
            var5 = var1.getHeight();
         } else {
            var5 = var1.getWidth();
         }

         int var6;
         if(var4) {
            var6 = var1.getWidth();
         } else {
            var6 = var1.getHeight();
         }

         var7 = roundNumerator(determineResizeRatio(var2, var5, var6));
         if(var7 > 8) {
            return 8;
         }

         if(var7 < 1) {
            return 1;
         }
      }

      return var7;
   }

   @VisibleForTesting
   static int roundNumerator(float var0) {
      return (int)(0.6666667F + 8.0F * var0);
   }

   private static boolean shouldResize(int var0) {
      return var0 < 8;
   }

   private static TriState shouldTransform(ImageRequest var0, EncodedImage var1) {
      if(var1 != null && var1.getImageFormat() != ImageFormat.UNKNOWN) {
         if(var1.getImageFormat() != ImageFormat.JPEG) {
            return TriState.field_223;
         } else {
            boolean var2;
            if(getRotationAngle(var0, var1) == 0 && !shouldResize(getScaleNumerator(var0, var1))) {
               var2 = false;
            } else {
               var2 = true;
            }

            return TriState.valueOf(var2);
         }
      } else {
         return TriState.UNSET;
      }
   }

   public void produceResults(Consumer<EncodedImage> var1, ProducerContext var2) {
      this.mInputProducer.produceResults(new ResizeAndRotateProducer.TransformingConsumer(var1, var2), var2);
   }

   private class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
      private boolean mIsCancelled = false;
      private final JobScheduler mJobScheduler;
      private final ProducerContext mProducerContext;

      public TransformingConsumer(Consumer<EncodedImage> var1, final ProducerContext var2) {
         super(var2);
         this.mProducerContext = var3;
         JobScheduler.JobRunnable var4 = new JobScheduler.JobRunnable() {
            public void run(EncodedImage var1, boolean var2) {
               TransformingConsumer.this.doTransform(var1, var2);
            }
         };
         this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, var4, 100);
         this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
               TransformingConsumer.this.mJobScheduler.clearJob();
               TransformingConsumer.this.mIsCancelled = true;
               var2.onCancellation();
            }

            public void onIsIntermediateResultExpectedChanged() {
               if(TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                  TransformingConsumer.this.mJobScheduler.scheduleJob();
               }

            }
         });
      }

      private void doTransform(EncodedImage param1, boolean param2) {
         // $FF: Couldn't be decompiled
      }

      private Map<String, String> getExtraMap(EncodedImage var1, ImageRequest var2, int var3) {
         if(!this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId())) {
            return null;
         } else {
            String var4 = var1.getWidth() + "x" + var1.getHeight();
            String var5;
            if(var2.getResizeOptions() != null) {
               var5 = var2.getResizeOptions().width + "x" + var2.getResizeOptions().height;
            } else {
               var5 = "Unspecified";
            }

            String var6;
            if(var3 > 0) {
               var6 = var3 + "/8";
            } else {
               var6 = "";
            }

            return ImmutableMap.method_208("Original size", var4, "Requested size", var5, "Fraction", var6, "queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
         }
      }

      protected void onNewResultImpl(@Nullable EncodedImage var1, boolean var2) {
         if(!this.mIsCancelled) {
            if(var1 == null) {
               if(var2) {
                  this.getConsumer().onNewResult((Object)null, true);
                  return;
               }
            } else {
               TriState var3 = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), var1);
               if(var2 || var3 != TriState.UNSET) {
                  if(var3 != TriState.YES) {
                     this.getConsumer().onNewResult(var1, var2);
                     return;
                  }

                  if(this.mJobScheduler.updateJob(var1, var2) && (var2 || this.mProducerContext.isIntermediateResultExpected())) {
                     this.mJobScheduler.scheduleJob();
                     return;
                  }
               }
            }
         }

      }
   }
}
