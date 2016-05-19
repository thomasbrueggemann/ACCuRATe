package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheTracker;
import com.facebook.imagepipeline.memory.PooledByteBuffer;

public class EncodedMemoryCacheFactory {
   public static MemoryCache<CacheKey, PooledByteBuffer> get(CountingMemoryCache<CacheKey, PooledByteBuffer> var0, final ImageCacheStatsTracker var1) {
      var1.registerEncodedMemoryCache(var0);
      return new InstrumentedMemoryCache(var0, new MemoryCacheTracker() {
         public void onCacheHit() {
            var1.onMemoryCacheHit();
         }

         public void onCacheMiss() {
            var1.onMemoryCacheMiss();
         }

         public void onCachePut() {
            var1.onMemoryCachePut();
         }
      });
   }
}
