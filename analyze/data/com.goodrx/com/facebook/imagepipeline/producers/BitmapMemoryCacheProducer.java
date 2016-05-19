package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
   @VisibleForTesting
   static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
   @VisibleForTesting
   static final String VALUE_FOUND = "cached_value_found";
   private final CacheKeyFactory mCacheKeyFactory;
   private final Producer<CloseableReference<CloseableImage>> mInputProducer;
   private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

   public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> var1, CacheKeyFactory var2, Producer<CloseableReference<CloseableImage>> var3) {
      this.mMemoryCache = var1;
      this.mCacheKeyFactory = var2;
      this.mInputProducer = var3;
   }

   // $FF: synthetic method
   static MemoryCache access$000(BitmapMemoryCacheProducer var0) {
      return var0.mMemoryCache;
   }

   protected String getProducerName() {
      return "BitmapMemoryCacheProducer";
   }

   public void produceResults(Consumer<CloseableReference<CloseableImage>> var1, ProducerContext var2) {
      ProducerListener var3 = var2.getListener();
      String var4 = var2.getId();
      var3.onProducerStart(var4, this.getProducerName());
      ImageRequest var5 = var2.getImageRequest();
      CacheKey var6 = this.mCacheKeyFactory.getBitmapCacheKey(var5);
      CloseableReference var7 = this.mMemoryCache.get(var6);
      if(var7 != null) {
         boolean var14 = ((CloseableImage)var7.get()).getQualityInfo().isOfFullQuality();
         if(var14) {
            String var15 = this.getProducerName();
            Map var16;
            if(var3.requiresExtraMap(var4)) {
               var16 = ImmutableMap.method_205("cached_value_found", "true");
            } else {
               var16 = null;
            }

            var3.onProducerFinishWithSuccess(var4, var15, var16);
            var1.onProgressUpdate(1.0F);
         }

         var1.onNewResult(var7, var14);
         var7.close();
         if(var14) {
            return;
         }
      }

      if(var2.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
         String var12 = this.getProducerName();
         Map var13;
         if(var3.requiresExtraMap(var4)) {
            var13 = ImmutableMap.method_205("cached_value_found", "false");
         } else {
            var13 = null;
         }

         var3.onProducerFinishWithSuccess(var4, var12, var13);
         var1.onNewResult((Object)null, true);
      } else {
         Consumer var8 = this.wrapConsumer(var1, var6);
         String var9 = this.getProducerName();
         boolean var10 = var3.requiresExtraMap(var4);
         Map var11 = null;
         if(var10) {
            var11 = ImmutableMap.method_205("cached_value_found", "false");
         }

         var3.onProducerFinishWithSuccess(var4, var9, var11);
         this.mInputProducer.produceResults(var8, var2);
      }
   }

   protected Consumer<CloseableReference<CloseableImage>> wrapConsumer(final Consumer<CloseableReference<CloseableImage>> var1, final CacheKey var2) {
      return new DelegatingConsumer(var1) {
         public void onNewResultImpl(CloseableReference<CloseableImage> param1, boolean param2) {
            // $FF: Couldn't be decompiled
         }
      };
   }
}
