package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;

public abstract class PlatformBitmapFactory {
   public CloseableReference<Bitmap> createBitmap(int var1, int var2) {
      return this.createBitmap(var1, var2, Config.ARGB_8888);
   }

   public abstract CloseableReference<Bitmap> createBitmap(int var1, int var2, Config var3);
}
