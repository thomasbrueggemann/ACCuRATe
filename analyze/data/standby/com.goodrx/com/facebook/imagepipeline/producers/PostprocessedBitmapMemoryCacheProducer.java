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
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import java.util.Map;

public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
   @VisibleForTesting
   static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";
   @VisibleForTesting
   static final String VALUE_FOUND = "cached_value_found";
   private final CacheKeyFactory mCacheKeyFactory;
   private final Producer<CloseableReference<CloseableImage>> mInputProducer;
   private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

   public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> var1, CacheKeyFactory var2, Producer<CloseableReference<CloseableImage>> var3) {
      this.mMemoryCache = var1;
      this.mCacheKeyFactory = var2;
      this.mInputProducer = var3;
   }

   protected String getProducerName() {
      return "PostprocessedBitmapMemoryCacheProducer";
   }

   public void produceResults(Consumer<CloseableReference<CloseableImage>> var1, ProducerContext var2) {
      ProducerListener var3 = var2.getListener();
      String var4 = var2.getId();
      ImageRequest var5 = var2.getImageRequest();
      Postprocessor var6 = var5.getPostprocessor();
      if(var6 != null && var6.getPostprocessorCacheKey() != null) {
         var3.onProducerStart(var4, this.getProducerName());
         CacheKey var7 = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey(var5);
         CloseableReference var8 = this.mMemoryCache.get(var7);
         if(var8 != null) {
            String var13 = this.getProducerName();
            boolean var14 = var3.requiresExtraMap(var4);
            Map var15 = null;
            if(var14) {
               var15 = ImmutableMap.method_205("cached_value_found", "true");
            }

            var3.onProducerFinishWithSuccess(var4, var13, var15);
            var1.onProgressUpdate(1.0F);
            var1.onNewResult(var8, true);
            var8.close();
         } else {
            PostprocessedBitmapMemoryCacheProducer.CachedPostprocessorConsumer var9 = new PostprocessedBitmapMemoryCacheProducer.CachedPostprocessorConsumer(var1, var7, var6 instanceof RepeatedPostprocessor, this.mMemoryCache);
            String var10 = this.getProducerName();
            boolean var11 = var3.requiresExtraMap(var4);
            Map var12 = null;
            if(var11) {
               var12 = ImmutableMap.method_205("cached_value_found", "false");
            }

            var3.onProducerFinishWithSuccess(var4, var10, var12);
            this.mInputProducer.produceResults(var9, var2);
         }
      } else {
         this.mInputProducer.produceResults(var1, var2);
      }
   }

   public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
      private final CacheKey mCacheKey;
      private final boolean mIsRepeatedProcessor;
      private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

      public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> var1, CacheKey var2, boolean var3, MemoryCache<CacheKey, CloseableImage> var4) {
         super(var1);
         this.mCacheKey = var2;
         this.mIsRepeatedProcessor = var3;
         this.mMemoryCache = var4;
      }

      protected void onNewResultImpl(CloseableReference<CloseableImage> param1, boolean param2) {
         // $FF: Couldn't be decompiled
      }
   }
}
