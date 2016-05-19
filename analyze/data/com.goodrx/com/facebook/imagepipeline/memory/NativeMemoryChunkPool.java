package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.imagepipeline.memory.NativeMemoryChunk;
import com.facebook.imagepipeline.memory.PoolParams;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativeMemoryChunkPool extends BasePool<NativeMemoryChunk> {
   private final int[] mBucketSizes;

   public NativeMemoryChunkPool(MemoryTrimmableRegistry var1, PoolParams var2, PoolStatsTracker var3) {
      super(var1, var2, var3);
      SparseIntArray var4 = var2.bucketSizes;
      this.mBucketSizes = new int[var4.size()];

      for(int var5 = 0; var5 < this.mBucketSizes.length; ++var5) {
         this.mBucketSizes[var5] = var4.keyAt(var5);
      }

      this.initialize();
   }

   protected NativeMemoryChunk alloc(int var1) {
      return new NativeMemoryChunk(var1);
   }

   protected void free(NativeMemoryChunk var1) {
      Preconditions.checkNotNull(var1);
      var1.close();
   }

   protected int getBucketedSize(int var1) {
      if(var1 <= 0) {
         throw new BasePool.InvalidSizeException(Integer.valueOf(var1));
      } else {
         int[] var2 = this.mBucketSizes;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            int var5 = var2[var4];
            if(var5 >= var1) {
               return var5;
            }
         }

         return var1;
      }
   }

   protected int getBucketedSizeForValue(NativeMemoryChunk var1) {
      Preconditions.checkNotNull(var1);
      return var1.getSize();
   }

   public int getMinBufferSize() {
      return this.mBucketSizes[0];
   }

   protected int getSizeInBytes(int var1) {
      return var1;
   }

   protected boolean isReusable(NativeMemoryChunk var1) {
      Preconditions.checkNotNull(var1);
      return !var1.isClosed();
   }
}
