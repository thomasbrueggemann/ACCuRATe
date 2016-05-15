package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;

public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
   private static final int MAX_CACHE_ENTRIES = 256;
   private static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
   private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
   private static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;
   private final ActivityManager mActivityManager;

   public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager var1) {
      this.mActivityManager = var1;
   }

   private int getMaxCacheSize() {
      int var1 = Math.min(1048576 * this.mActivityManager.getMemoryClass(), Integer.MAX_VALUE);
      return var1 < 33554432?4194304:(var1 < 67108864?6291456:(VERSION.SDK_INT < 11?8388608:var1 / 4));
   }

   public MemoryCacheParams get() {
      return new MemoryCacheParams(this.getMaxCacheSize(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
   }
}
