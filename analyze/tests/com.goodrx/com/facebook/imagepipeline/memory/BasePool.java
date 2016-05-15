package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.Bucket;
import com.facebook.imagepipeline.memory.Pool;
import com.facebook.imagepipeline.memory.PoolParams;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

public abstract class BasePool<V> implements Pool<V> {
   private final Class<?> TAG = this.getClass();
   private boolean mAllowNewBuckets;
   @VisibleForTesting
   final SparseArray<Bucket<V>> mBuckets;
   @VisibleForTesting
   @GuardedBy("this")
   final BasePool.Counter mFree;
   @VisibleForTesting
   final Set<V> mInUseValues;
   final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
   final PoolParams mPoolParams;
   private final PoolStatsTracker mPoolStatsTracker;
   @VisibleForTesting
   @GuardedBy("this")
   final BasePool.Counter mUsed;

   public BasePool(MemoryTrimmableRegistry var1, PoolParams var2, PoolStatsTracker var3) {
      this.mMemoryTrimmableRegistry = (MemoryTrimmableRegistry)Preconditions.checkNotNull(var1);
      this.mPoolParams = (PoolParams)Preconditions.checkNotNull(var2);
      this.mPoolStatsTracker = (PoolStatsTracker)Preconditions.checkNotNull(var3);
      this.mBuckets = new SparseArray();
      this.initBuckets(new SparseIntArray(0));
      this.mInUseValues = Sets.newIdentityHashSet();
      this.mFree = new BasePool.Counter();
      this.mUsed = new BasePool.Counter();
   }

   private void ensurePoolSizeInvariant() {
      // $FF: Couldn't be decompiled
   }

   private void initBuckets(SparseIntArray param1) {
      // $FF: Couldn't be decompiled
   }

   @SuppressLint({"InvalidAccessToGuardedField"})
   private void logStats() {
      if(FLog.isLoggable(2)) {
         FLog.method_421(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
      }

   }

   protected abstract V alloc(int var1);

   @VisibleForTesting
   boolean canAllocate(int var1) {
      boolean var2 = false;
      synchronized(this){}
      boolean var7 = false;

      label78: {
         try {
            var7 = true;
            int var4 = this.mPoolParams.maxSizeHardCap;
            if(var1 > var4 - this.mUsed.mNumBytes) {
               this.mPoolStatsTracker.onHardCapReached();
               var7 = false;
               return var2;
            }

            int var5 = this.mPoolParams.maxSizeSoftCap;
            if(var1 > var5 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
               this.trimToSize(var5 - var1);
            }

            if(var1 > var4 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
               this.mPoolStatsTracker.onHardCapReached();
               var7 = false;
               break label78;
            }

            var7 = false;
         } finally {
            if(var7) {
               ;
            }
         }

         var2 = true;
         return var2;
      }

      var2 = false;
      return var2;
   }

   @VisibleForTesting
   protected abstract void free(V var1);

   public V get(int param1) {
      // $FF: Couldn't be decompiled
   }

   @VisibleForTesting
   Bucket<V> getBucket(int param1) {
      // $FF: Couldn't be decompiled
   }

   protected abstract int getBucketedSize(int var1);

   protected abstract int getBucketedSizeForValue(V var1);

   protected abstract int getSizeInBytes(int var1);

   public Map<String, Integer> getStats() {
      // $FF: Couldn't be decompiled
   }

   protected void initialize() {
      this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
      this.mPoolStatsTracker.setBasePool(this);
   }

   @VisibleForTesting
   boolean isMaxSizeSoftCapExceeded() {
      // $FF: Couldn't be decompiled
   }

   protected boolean isReusable(V var1) {
      Preconditions.checkNotNull(var1);
      return true;
   }

   Bucket<V> newBucket(int var1) {
      return new Bucket(this.getSizeInBytes(var1), Integer.MAX_VALUE, 0);
   }

   protected void onParamsChanged() {
   }

   public void release(V param1) {
      // $FF: Couldn't be decompiled
   }

   public void trim(MemoryTrimType var1) {
      this.trimToNothing();
   }

   @VisibleForTesting
   void trimToNothing() {
      // $FF: Couldn't be decompiled
   }

   @VisibleForTesting
   void trimToSize(int param1) {
      // $FF: Couldn't be decompiled
   }

   @VisibleForTesting
   void trimToSoftCap() {
      synchronized(this){}

      try {
         if(this.isMaxSizeSoftCapExceeded()) {
            this.trimToSize(this.mPoolParams.maxSizeSoftCap);
         }
      } finally {
         ;
      }

   }

   @VisibleForTesting
   @NotThreadSafe
   static class Counter {
      private static final String TAG = "com.facebook.imagepipeline.common.BasePool.Counter";
      int mCount;
      int mNumBytes;

      public void decrement(int var1) {
         if(this.mNumBytes >= var1 && this.mCount > 0) {
            this.mCount += -1;
            this.mNumBytes -= var1;
         } else {
            Object[] var2 = new Object[]{Integer.valueOf(var1), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount)};
            FLog.wtf("com.facebook.imagepipeline.common.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", var2);
         }
      }

      public void increment(int var1) {
         ++this.mCount;
         this.mNumBytes += var1;
      }

      public void reset() {
         this.mCount = 0;
         this.mNumBytes = 0;
      }
   }

   public static class InvalidSizeException extends RuntimeException {
      public InvalidSizeException(Object var1) {
         super("Invalid size: " + var1.toString());
      }
   }

   public static class InvalidValueException extends RuntimeException {
      public InvalidValueException(Object var1) {
         super("Invalid value: " + var1.toString());
      }
   }

   public static class PoolSizeViolationException extends RuntimeException {
      public PoolSizeViolationException(int var1, int var2, int var3, int var4) {
         super("Pool hard cap violation? Hard cap = " + var1 + " Used size = " + var2 + " Free size = " + var3 + " Request size = " + var4);
      }
   }

   public static class SizeTooLargeException extends BasePool.InvalidSizeException {
      public SizeTooLargeException(Object var1) {
         super(var1);
      }
   }
}
