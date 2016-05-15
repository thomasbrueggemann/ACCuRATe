package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.memory.Bucket;
import com.facebook.imagepipeline.memory.GenericByteArrayPool;
import com.facebook.imagepipeline.memory.NoOpPoolStatsTracker;
import com.facebook.imagepipeline.memory.OOMSoftReferenceBucket;
import com.facebook.imagepipeline.memory.PoolParams;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class FlexByteArrayPool {
   @VisibleForTesting
   final FlexByteArrayPool.SoftRefByteArrayPool mDelegatePool;
   private final ResourceReleaser<byte[]> mResourceReleaser;

   public FlexByteArrayPool(MemoryTrimmableRegistry var1, PoolParams var2) {
      boolean var3;
      if(var2.maxNumThreads > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      this.mDelegatePool = new FlexByteArrayPool.SoftRefByteArrayPool(var1, var2, NoOpPoolStatsTracker.getInstance());
      this.mResourceReleaser = new ResourceReleaser() {
         public void release(byte[] var1) {
            FlexByteArrayPool.this.release(var1);
         }
      };
   }

   public CloseableReference<byte[]> get(int var1) {
      return CloseableReference.method_307(this.mDelegatePool.get(var1), this.mResourceReleaser);
   }

   public int getMinBufferSize() {
      return this.mDelegatePool.getMinBufferSize();
   }

   public Map<String, Integer> getStats() {
      return this.mDelegatePool.getStats();
   }

   public void release(byte[] var1) {
      this.mDelegatePool.release(var1);
   }

   @VisibleForTesting
   static class SoftRefByteArrayPool extends GenericByteArrayPool {
      public SoftRefByteArrayPool(MemoryTrimmableRegistry var1, PoolParams var2, PoolStatsTracker var3) {
         super(var1, var2, var3);
      }

      Bucket<byte[]> newBucket(int var1) {
         return new OOMSoftReferenceBucket(this.getSizeInBytes(var1), this.mPoolParams.maxNumThreads, 0);
      }
   }
}
