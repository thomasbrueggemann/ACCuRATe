package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;

public interface AnimatedImageFrame {
   void dispose();

   int getDurationMs();

   int getHeight();

   int getWidth();

   int getXOffset();

   int getYOffset();

   void renderFrame(int var1, int var2, Bitmap var3);
}
