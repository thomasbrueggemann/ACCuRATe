package com.facebook.imagepipeline.animated.base;

import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;

public interface AnimatedImage {
   void dispose();

   boolean doesRenderSupportScaling();

   int getDuration();

   AnimatedImageFrame getFrame(int var1);

   int getFrameCount();

   int[] getFrameDurations();

   AnimatedDrawableFrameInfo getFrameInfo(int var1);

   int getHeight();

   int getLoopCount();

   int getSizeInBytes();

   int getWidth();
}
