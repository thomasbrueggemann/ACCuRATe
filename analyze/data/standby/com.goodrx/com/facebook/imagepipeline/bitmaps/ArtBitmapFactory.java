package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class ArtBitmapFactory extends PlatformBitmapFactory {
   private final BitmapPool mBitmapPool;

   public ArtBitmapFactory(BitmapPool var1) {
      this.mBitmapPool = var1;
   }

   public CloseableReference<Bitmap> createBitmap(int var1, int var2, Config var3) {
      int var4 = BitmapUtil.getSizeInByteForBitmap(var1, var2, var3);
      Bitmap var5 = (Bitmap)this.mBitmapPool.get(var4);
      Bitmaps.reconfigureBitmap(var5, var1, var2, var3);
      return CloseableReference.method_307(var5, this.mBitmapPool);
   }
}
