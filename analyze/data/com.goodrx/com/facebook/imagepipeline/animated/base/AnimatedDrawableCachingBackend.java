package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;

public interface AnimatedDrawableCachingBackend extends AnimatedDrawableBackend {
   void appendDebugOptionString(StringBuilder var1);

   AnimatedDrawableCachingBackend forNewBounds(Rect var1);

   CloseableReference<Bitmap> getBitmapForFrame(int var1);

   CloseableReference<Bitmap> getPreviewBitmap();
}
