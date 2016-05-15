package com.facebook.imagepipeline.cache;

import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;

public class NoOpImageCacheStatsTracker implements ImageCacheStatsTracker {
   private static NoOpImageCacheStatsTracker sInstance = null;

   public static NoOpImageCacheStatsTracker getInstance() {
      synchronized(NoOpImageCacheStatsTracker.class){}

      NoOpImageCacheStatsTracker var1;
      try {
         if(sInstance == null) {
            sInstance = new NoOpImageCacheStatsTracker();
         }

         var1 = sInstance;
      } finally {
         ;
      }

      return var1;
   }

   public void onBitmapCacheHit() {
   }

   public void onBitmapCacheMiss() {
   }

   public void onBitmapCachePut() {
   }

   public void onDiskCacheGetFail() {
   }

   public void onDiskCacheHit() {
   }

   public void onDiskCacheMiss() {
   }

   public void onMemoryCacheHit() {
   }

   public void onMemoryCacheMiss() {
   }

   public void onMemoryCachePut() {
   }

   public void onStagingAreaHit() {
   }

   public void onStagingAreaMiss() {
   }

   public void registerBitmapMemoryCache(CountingMemoryCache<?, ?> var1) {
   }

   public void registerEncodedMemoryCache(CountingMemoryCache<?, ?> var1) {
   }
}
