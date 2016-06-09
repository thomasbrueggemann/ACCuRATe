package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.memory.PoolParams;
import java.util.concurrent.Semaphore;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class SharedByteArray implements MemoryTrimmable {
   @VisibleForTesting
   final OOMSoftReference<byte[]> mByteArraySoftRef;
   @VisibleForTesting
   final int mMaxByteArraySize;
   @VisibleForTesting
   final int mMinByteArraySize;
   private final ResourceReleaser<byte[]> mResourceReleaser;
   @VisibleForTesting
   final Semaphore mSemaphore;

   public SharedByteArray(MemoryTrimmableRegistry var1, PoolParams var2) {
      Preconditions.checkNotNull(var1);
      boolean var4;
      if(var2.minBucketSize > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      int var5 = var2.maxBucketSize;
      int var6 = var2.minBucketSize;
      boolean var7 = false;
      if(var5 >= var6) {
         var7 = true;
      }

      Preconditions.checkArgument(var7);
      this.mMaxByteArraySize = var2.maxBucketSize;
      this.mMinByteArraySize = var2.minBucketSize;
      this.mByteArraySoftRef = new OOMSoftReference();
      this.mSemaphore = new Semaphore(1);
      this.mResourceReleaser = new ResourceReleaser() {
         public void release(byte[] var1) {
            SharedByteArray.this.mSemaphore.release();
         }
      };
      var1.registerMemoryTrimmable(this);
   }

   private byte[] allocateByteArray(int var1) {
      synchronized(this){}

      byte[] var3;
      try {
         this.mByteArraySoftRef.clear();
         var3 = new byte[var1];
         this.mByteArraySoftRef.set(var3);
      } finally {
         ;
      }

      return var3;
   }

   private byte[] getByteArray(int var1) {
      int var2 = this.getBucketedSize(var1);
      byte[] var3 = (byte[])this.mByteArraySoftRef.get();
      if(var3 == null || var3.length < var2) {
         var3 = this.allocateByteArray(var2);
      }

      return var3;
   }

   public CloseableReference<byte[]> get(int var1) {
      boolean var2 = true;
      boolean var3;
      if(var1 > 0) {
         var3 = var2;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3, "Size must be greater than zero");
      if(var1 > this.mMaxByteArraySize) {
         var2 = false;
      }

      Preconditions.checkArgument(var2, "Requested size is too big");
      this.mSemaphore.acquireUninterruptibly();

      try {
         CloseableReference var5 = CloseableReference.method_307(this.getByteArray(var1), this.mResourceReleaser);
         return var5;
      } catch (Throwable var6) {
         this.mSemaphore.release();
         throw Throwables.propagate(var6);
      }
   }

   @VisibleForTesting
   int getBucketedSize(int var1) {
      return 2 * Integer.highestOneBit(-1 + Math.max(var1, this.mMinByteArraySize));
   }

   public void trim(MemoryTrimType var1) {
      if(this.mSemaphore.tryAcquire()) {
         try {
            this.mByteArraySoftRef.clear();
         } finally {
            this.mSemaphore.release();
         }

      }
   }
}
