package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.MultiplexProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;

public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, EncodedImage> {
   private final CacheKeyFactory mCacheKeyFactory;

   public EncodedCacheKeyMultiplexProducer(CacheKeyFactory var1, Producer var2) {
      super(var2);
      this.mCacheKeyFactory = var1;
   }

   public EncodedImage cloneOrNull(EncodedImage var1) {
      return EncodedImage.cloneOrNull(var1);
   }

   protected Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext var1) {
      return Pair.create(this.mCacheKeyFactory.getEncodedCacheKey(var1.getImageRequest()), var1.getLowestPermittedRequestLevel());
   }
}
