package com.facebook.imagepipeline.cache;

import com.facebook.imagepipeline.cache.CountingMemoryCache;

public interface ImageCacheStatsTracker {
   void onBitmapCacheHit();

   void onBitmapCacheMiss();

   void onBitmapCachePut();

   void onDiskCacheGetFail();

   void onDiskCacheHit();

   void onDiskCacheMiss();

   void onMemoryCacheHit();

   void onMemoryCacheMiss();

   void onMemoryCachePut();

   void onStagingAreaHit();

   void onStagingAreaMiss();

   void registerBitmapMemoryCache(CountingMemoryCache<?, ?> var1);

   void registerEncodedMemoryCache(CountingMemoryCache<?, ?> var1);
}
