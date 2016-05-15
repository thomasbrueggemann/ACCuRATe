package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.image.CloseableImage;

public abstract class CloseableBitmap extends CloseableImage {
   public abstract Bitmap getUnderlyingBitmap();
}
