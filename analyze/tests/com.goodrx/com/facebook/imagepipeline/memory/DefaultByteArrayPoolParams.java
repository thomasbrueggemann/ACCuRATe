package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.PoolParams;

public class DefaultByteArrayPoolParams {
   private static final int DEFAULT_BUCKET_SIZE = 5;
   private static final int DEFAULT_IO_BUFFER_SIZE = 16384;
   private static final int MAX_SIZE_HARD_CAP = 1048576;
   private static final int MAX_SIZE_SOFT_CAP = 81920;

   public static PoolParams get() {
      SparseIntArray var0 = new SparseIntArray();
      var0.put(16384, 5);
      return new PoolParams(81920, 1048576, var0);
   }
}
