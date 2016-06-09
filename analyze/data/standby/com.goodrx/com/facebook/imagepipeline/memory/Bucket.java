package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@VisibleForTesting
@NotThreadSafe
class Bucket<V> {
   private static final String TAG = "com.facebook.imagepipeline.common.Bucket";
   final Queue mFreeList;
   private int mInUseLength;
   public final int mItemSize;
   public final int mMaxLength;

   public Bucket(int var1, int var2, int var3) {
      boolean var4 = true;
      super();
      boolean var5;
      if(var1 > 0) {
         var5 = var4;
      } else {
         var5 = false;
      }

      Preconditions.checkState(var5);
      boolean var6;
      if(var2 >= 0) {
         var6 = var4;
      } else {
         var6 = false;
      }

      Preconditions.checkState(var6);
      if(var3 < 0) {
         var4 = false;
      }

      Preconditions.checkState(var4);
      this.mItemSize = var1;
      this.mMaxLength = var2;
      this.mFreeList = new LinkedList();
      this.mInUseLength = var3;
   }

   void addToFreeList(V var1) {
      this.mFreeList.add(var1);
   }

   public void decrementInUseCount() {
      boolean var1;
      if(this.mInUseLength > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.checkState(var1);
      this.mInUseLength += -1;
   }

   @Nullable
   public V get() {
      Object var1 = this.pop();
      if(var1 != null) {
         ++this.mInUseLength;
      }

      return var1;
   }

   int getFreeListSize() {
      return this.mFreeList.size();
   }

   public int getInUseCount() {
      return this.mInUseLength;
   }

   public void incrementInUseCount() {
      ++this.mInUseLength;
   }

   public boolean isMaxLengthExceeded() {
      return this.mInUseLength + this.getFreeListSize() > this.mMaxLength;
   }

   @Nullable
   public V pop() {
      return this.mFreeList.poll();
   }

   public void release(V var1) {
      Preconditions.checkNotNull(var1);
      boolean var3;
      if(this.mInUseLength > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkState(var3);
      this.mInUseLength += -1;
      this.addToFreeList(var1);
   }
}
