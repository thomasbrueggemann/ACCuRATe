package com.facebook.imagepipeline.cache;

import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.cache.CountingMemoryCache;

public class BitmapMemoryCacheTrimStrategy implements CountingMemoryCache.CacheTrimStrategy {
   private static final String TAG = "BitmapMemoryCacheTrimStrategy";

   public double getTrimRatio(MemoryTrimType var1) {
      switch(null.$SwitchMap$com$facebook$common$memory$MemoryTrimType[var1.ordinal()]) {
      case 1:
         if(VERSION.SDK_INT >= 21) {
            return MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio();
         }
         break;
      case 2:
      case 3:
      case 4:
         return 1.0D;
      default:
         FLog.wtf("BitmapMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[]{var1});
      }

      return 0.0D;
   }
}
