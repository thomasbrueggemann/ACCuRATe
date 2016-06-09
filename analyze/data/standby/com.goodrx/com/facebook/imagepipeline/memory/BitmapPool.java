package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.imagepipeline.memory.PoolParams;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class BitmapPool extends BasePool<Bitmap> {
   public BitmapPool(MemoryTrimmableRegistry var1, PoolParams var2, PoolStatsTracker var3) {
      super(var1, var2, var3);
      this.initialize();
   }

   protected Bitmap alloc(int var1) {
      return Bitmap.createBitmap(1, (int)Math.ceil((double)var1 / 2.0D), Config.RGB_565);
   }

   protected void free(Bitmap var1) {
      Preconditions.checkNotNull(var1);
      var1.recycle();
   }

   protected int getBucketedSize(int var1) {
      return var1;
   }

   protected int getBucketedSizeForValue(Bitmap var1) {
      Preconditions.checkNotNull(var1);
      return var1.getAllocationByteCount();
   }

   protected int getSizeInBytes(int var1) {
      return var1;
   }

   protected boolean isReusable(Bitmap var1) {
      Preconditions.checkNotNull(var1);
      return !var1.isRecycled() && var1.isMutable();
   }
}
