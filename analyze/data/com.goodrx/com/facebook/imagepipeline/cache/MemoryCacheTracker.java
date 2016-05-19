package com.facebook.imagepipeline.cache;

public interface MemoryCacheTracker {
   void onCacheHit();

   void onCacheMiss();

   void onCachePut();
}
