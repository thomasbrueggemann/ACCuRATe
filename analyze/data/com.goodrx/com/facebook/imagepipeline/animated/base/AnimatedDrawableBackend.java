package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import javax.annotation.Nullable;

public interface AnimatedDrawableBackend {
   void dropCaches();

   AnimatedDrawableBackend forNewBounds(Rect var1);

   AnimatedImageResult getAnimatedImageResult();

   int getDurationMs();

   int getDurationMsForFrame(int var1);

   int getFrameCount();

   int getFrameForPreview();

   int getFrameForTimestampMs(int var1);

   AnimatedDrawableFrameInfo getFrameInfo(int var1);

   int getHeight();

   int getLoopCount();

   int getMemoryUsage();

   @Nullable
   CloseableReference<Bitmap> getPreDecodedFrame(int var1);

   int getRenderedHeight();

   int getRenderedWidth();

   int getTimestampMsForFrame(int var1);

   int getWidth();

   boolean hasPreDecodedFrame(int var1);

   void renderFrame(int var1, Canvas var2);
}
