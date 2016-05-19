package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheTracker;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapMemoryCacheFactory {
   public static MemoryCache<CacheKey, CloseableImage> get(CountingMemoryCache<CacheKey, CloseableImage> var0, final ImageCacheStatsTracker var1) {
      var1.registerBitmapMemoryCache(var0);
      return new InstrumentedMemoryCache(var0, new MemoryCacheTracker() {
         public void onCacheHit() {
            var1.onBitmapCacheHit();
         }

         public void onCacheMiss() {
            var1.onBitmapCacheMiss();
         }

         public void onCachePut() {
            var1.onBitmapCachePut();
         }
      });
   }
}
