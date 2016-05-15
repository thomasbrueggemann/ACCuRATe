package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.PoolParams;

public class DefaultNativeMemoryChunkPoolParams {
   private static final int LARGE_BUCKET_LENGTH = 2;
   private static final int SMALL_BUCKET_LENGTH = 5;

   public static PoolParams get() {
      SparseIntArray var0 = new SparseIntArray();
      var0.put(1024, 5);
      var0.put(2048, 5);
      var0.put(4096, 5);
      var0.put(8192, 5);
      var0.put(16384, 5);
      var0.put('耀', 5);
      var0.put(65536, 5);
      var0.put(131072, 5);
      var0.put(262144, 2);
      var0.put(524288, 2);
      var0.put(1048576, 2);
      return new PoolParams(getMaxSizeSoftCap(), getMaxSizeHardCap(), var0);
   }

   private static int getMaxSizeHardCap() {
      int var0 = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
      return var0 < 16777216?var0 / 2:3 * (var0 / 4);
   }

   private static int getMaxSizeSoftCap() {
      int var0 = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
      return var0 < 16777216?3145728:(var0 < 33554432?6291456:12582912);
   }
}
