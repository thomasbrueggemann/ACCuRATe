package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;

public class GingerbreadBitmapFactory extends PlatformBitmapFactory {
   public CloseableReference<Bitmap> createBitmap(int var1, int var2, Config var3) {
      return CloseableReference.method_307(Bitmap.createBitmap(var1, var2, var3), SimpleBitmapReleaser.getInstance());
   }
}
