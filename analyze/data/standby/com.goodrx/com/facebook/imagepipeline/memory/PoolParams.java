package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

public class PoolParams {
   public static final int IGNORE_THREADS = -1;
   public final SparseIntArray bucketSizes;
   public final int maxBucketSize;
   public final int maxNumThreads;
   public final int maxSizeHardCap;
   public final int maxSizeSoftCap;
   public final int minBucketSize;

   public PoolParams(int var1, int var2, @Nullable SparseIntArray var3) {
      this(var1, var2, var3, 0, Integer.MAX_VALUE, -1);
   }

   public PoolParams(int var1, int var2, @Nullable SparseIntArray var3, int var4, int var5, int var6) {
      boolean var7;
      if(var1 >= 0 && var2 >= var1) {
         var7 = true;
      } else {
         var7 = false;
      }

      Preconditions.checkState(var7);
      this.maxSizeSoftCap = var1;
      this.maxSizeHardCap = var2;
      this.bucketSizes = var3;
      this.minBucketSize = var4;
      this.maxBucketSize = var5;
      this.maxNumThreads = var6;
   }

   public PoolParams(int var1, @Nullable SparseIntArray var2) {
      this(var1, var1, var2, 0, Integer.MAX_VALUE, -1);
   }
}
