package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.PoolParams;

public class DefaultBitmapPoolParams {
   private static final SparseIntArray DEFAULT_BUCKETS = new SparseIntArray(0);
   private static final int MAX_SIZE_SOFT_CAP;

   public static PoolParams get() {
      return new PoolParams(0, getMaxSizeHardCap(), DEFAULT_BUCKETS);
   }

   private static int getMaxSizeHardCap() {
      int var0 = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
      return var0 > 16777216?3 * (var0 / 4):var0 / 2;
   }
}
