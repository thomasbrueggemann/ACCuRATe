package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;

public class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer {
   @VisibleForTesting
   static final String PRODUCER_NAME = "BitmapMemoryCacheGetProducer";

   public BitmapMemoryCacheGetProducer(MemoryCache<CacheKey, CloseableImage> var1, CacheKeyFactory var2, Producer<CloseableReference<CloseableImage>> var3) {
      super(var1, var2, var3);
   }

   protected String getProducerName() {
      return "BitmapMemoryCacheGetProducer";
   }

   protected Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> var1, CacheKey var2) {
      return var1;
   }
}
