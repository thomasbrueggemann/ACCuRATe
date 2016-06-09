package com.facebook.imagepipeline.cache;

import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.cache.CountingMemoryCache;

public class NativeMemoryCacheTrimStrategy implements CountingMemoryCache.CacheTrimStrategy {
   private static final String TAG = "NativeMemoryCacheTrimStrategy";

   public double getTrimRatio(MemoryTrimType var1) {
      switch(null.$SwitchMap$com$facebook$common$memory$MemoryTrimType[var1.ordinal()]) {
      case 2:
      case 3:
      case 4:
         return 1.0D;
      default:
         FLog.wtf("NativeMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[]{var1});
      case 1:
         return 0.0D;
      }
   }
}
