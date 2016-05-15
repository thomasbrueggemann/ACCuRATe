package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;

public class DefaultEncodedMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
   private static final int MAX_CACHE_ENTRIES = Integer.MAX_VALUE;
   private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;

   private int getMaxCacheSize() {
      int var1 = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
      return var1 < 16777216?1048576:(var1 < 33554432?2097152:4194304);
   }

   public MemoryCacheParams get() {
      int var1 = this.getMaxCacheSize();
      return new MemoryCacheParams(var1, Integer.MAX_VALUE, var1, Integer.MAX_VALUE, var1 / 8);
   }
}
