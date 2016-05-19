package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class DiskCacheProducer implements Producer<EncodedImage> {
   @VisibleForTesting
   static final String PRODUCER_NAME = "DiskCacheProducer";
   @VisibleForTesting
   static final String VALUE_FOUND = "cached_value_found";
   private final CacheKeyFactory mCacheKeyFactory;
   private final BufferedDiskCache mDefaultBufferedDiskCache;
   private final Producer<EncodedImage> mInputProducer;
   private final BufferedDiskCache mSmallImageBufferedDiskCache;

   public DiskCacheProducer(BufferedDiskCache var1, BufferedDiskCache var2, CacheKeyFactory var3, Producer<EncodedImage> var4) {
      this.mDefaultBufferedDiskCache = var1;
      this.mSmallImageBufferedDiskCache = var2;
      this.mCacheKeyFactory = var3;
      this.mInputProducer = var4;
   }

   @VisibleForTesting
   static Map<String, String> getExtraMap(ProducerListener var0, String var1, boolean var2) {
      return !var0.requiresExtraMap(var1)?null:ImmutableMap.method_205("cached_value_found", String.valueOf(var2));
   }

   private void maybeStartInputProducer(Consumer<EncodedImage> var1, Consumer<EncodedImage> var2, ProducerContext var3) {
      if(var3.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
         var1.onNewResult((Object)null, true);
      } else {
         this.mInputProducer.produceResults(var2, var3);
      }
   }

   private void subscribeTaskForRequestCancellation(final AtomicBoolean var1, ProducerContext var2) {
      var2.addCallbacks(new BaseProducerContextCallbacks() {
         public void onCancellationRequested() {
            var1.set(true);
         }
      });
   }

   public void produceResults(final Consumer<EncodedImage> var1, final ProducerContext var2) {
      ImageRequest var3 = var2.getImageRequest();
      if(!var3.isDiskCacheEnabled()) {
         this.maybeStartInputProducer(var1, var1, var2);
      } else {
         final ProducerListener var4 = var2.getListener();
         final String var5 = var2.getId();
         var4.onProducerStart(var5, "DiskCacheProducer");
         final CacheKey var6 = this.mCacheKeyFactory.getEncodedCacheKey(var3);
         final BufferedDiskCache var7;
         if(var3.getImageType() == ImageRequest.ImageType.SMALL) {
            var7 = this.mSmallImageBufferedDiskCache;
         } else {
            var7 = this.mDefaultBufferedDiskCache;
         }

         Continuation var8 = new Continuation() {
            public Void then(Task<EncodedImage> var1x) throws Exception {
               if(var1x.isCancelled() || var1x.isFaulted() && var1x.getError() instanceof CancellationException) {
                  var4.onProducerFinishWithCancellation(var5, "DiskCacheProducer", (Map)null);
                  var1.onCancellation();
                  return null;
               } else if(var1x.isFaulted()) {
                  var4.onProducerFinishWithFailure(var5, "DiskCacheProducer", var1x.getError(), (Map)null);
                  DiskCacheProducer.this.maybeStartInputProducer(var1, DiskCacheProducer.this.new DiskCacheConsumer(var1, var7, var6, null), var2);
                  return null;
               } else {
                  EncodedImage var2x = (EncodedImage)var1x.getResult();
                  if(var2x != null) {
                     var4.onProducerFinishWithSuccess(var5, "DiskCacheProducer", DiskCacheProducer.getExtraMap(var4, var5, true));
                     var1.onProgressUpdate(1.0F);
                     var1.onNewResult(var2x, true);
                     var2x.close();
                     return null;
                  } else {
                     var4.onProducerFinishWithSuccess(var5, "DiskCacheProducer", DiskCacheProducer.getExtraMap(var4, var5, false));
                     DiskCacheProducer.this.maybeStartInputProducer(var1, DiskCacheProducer.this.new DiskCacheConsumer(var1, var7, var6, null), var2);
                     return null;
                  }
               }
            }
         };
         AtomicBoolean var9 = new AtomicBoolean(false);
         var7.get(var6, var9).continueWith(var8);
         this.subscribeTaskForRequestCancellation(var9, var2);
      }
   }

   private class DiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
      private final BufferedDiskCache mCache;
      private final CacheKey mCacheKey;

      private DiskCacheConsumer(Consumer<EncodedImage> var1, BufferedDiskCache var2, CacheKey var3) {
         super(var2);
         this.mCache = var3;
         this.mCacheKey = var4;
      }

      // $FF: synthetic method
      DiskCacheConsumer(Consumer var2, BufferedDiskCache var3, CacheKey var4, Object var5) {
         this();
      }

      public void onNewResultImpl(EncodedImage var1, boolean var2) {
         if(var1 != null && var2) {
            this.mCache.put(this.mCacheKey, var1);
         }

         this.getConsumer().onNewResult(var1, var2);
      }
   }
}
