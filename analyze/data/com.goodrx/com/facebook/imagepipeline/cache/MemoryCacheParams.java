package com.facebook.imagepipeline.cache;

public class MemoryCacheParams {
   public final int maxCacheEntries;
   public final int maxCacheEntrySize;
   public final int maxCacheSize;
   public final int maxEvictionQueueEntries;
   public final int maxEvictionQueueSize;

   public MemoryCacheParams(int var1, int var2, int var3, int var4, int var5) {
      this.maxCacheSize = var1;
      this.maxCacheEntries = var2;
      this.maxEvictionQueueSize = var3;
      this.maxEvictionQueueEntries = var4;
      this.maxCacheEntrySize = var5;
   }
}
