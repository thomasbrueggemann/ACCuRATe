package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.PoolParams;

public class DefaultFlexByteArrayPoolParams {
   public static final int DEFAULT_MAX_BYTE_ARRAY_SIZE = 4194304;
   public static final int DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
   private static final int DEFAULT_MIN_BYTE_ARRAY_SIZE = 131072;

   public static SparseIntArray generateBuckets(int var0, int var1, int var2) {
      SparseIntArray var3 = new SparseIntArray();

      for(int var4 = var0; var4 <= var1; var4 *= 2) {
         var3.put(var4, var2);
      }

      return var3;
   }

   public static PoolParams get() {
      return new PoolParams(4194304, 4194304 * DEFAULT_MAX_NUM_THREADS, generateBuckets(131072, 4194304, DEFAULT_MAX_NUM_THREADS), 131072, 4194304, DEFAULT_MAX_NUM_THREADS);
   }
}
