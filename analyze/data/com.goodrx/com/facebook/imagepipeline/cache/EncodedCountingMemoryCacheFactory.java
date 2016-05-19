package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.ValueDescriptor;
import com.facebook.imagepipeline.memory.PooledByteBuffer;

public class EncodedCountingMemoryCacheFactory {
   public static CountingMemoryCache<CacheKey, PooledByteBuffer> get(Supplier<MemoryCacheParams> var0, MemoryTrimmableRegistry var1) {
      CountingMemoryCache var2 = new CountingMemoryCache(new ValueDescriptor() {
         public int getSizeInBytes(PooledByteBuffer var1) {
            return var1.size();
         }
      }, new NativeMemoryCacheTrimStrategy(), var0);
      var1.registerMemoryTrimmable(var2);
      return var2;
   }
}
