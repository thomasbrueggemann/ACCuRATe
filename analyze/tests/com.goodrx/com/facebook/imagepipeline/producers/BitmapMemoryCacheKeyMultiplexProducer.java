package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.MultiplexProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;

public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, CloseableReference<CloseableImage>> {
   private final CacheKeyFactory mCacheKeyFactory;

   public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory var1, Producer var2) {
      super(var2);
      this.mCacheKeyFactory = var1;
   }

   public CloseableReference<CloseableImage> cloneOrNull(CloseableReference<CloseableImage> var1) {
      return CloseableReference.cloneOrNull(var1);
   }

   protected Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext var1) {
      return Pair.create(this.mCacheKeyFactory.getBitmapCacheKey(var1.getImageRequest()), var1.getLowestPermittedRequestLevel());
   }
}
