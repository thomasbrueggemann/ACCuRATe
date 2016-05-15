package com.facebook.imagepipeline.animated.base;

public class AnimatedDrawableFrameInfo {
   public final AnimatedDrawableFrameInfo.DisposalMethod disposalMethod;
   public final int frameNumber;
   public final int height;
   public final boolean shouldBlendWithPreviousFrame;
   public final int width;
   public final int xOffset;
   public final int yOffset;

   public AnimatedDrawableFrameInfo(int var1, int var2, int var3, int var4, int var5, boolean var6, AnimatedDrawableFrameInfo.DisposalMethod var7) {
      this.frameNumber = var1;
      this.xOffset = var2;
      this.yOffset = var3;
      this.width = var4;
      this.height = var5;
      this.shouldBlendWithPreviousFrame = var6;
      this.disposalMethod = var7;
   }

   public static enum DisposalMethod {
      DISPOSE_DO_NOT,
      DISPOSE_TO_BACKGROUND,
      DISPOSE_TO_PREVIOUS;

      static {
         AnimatedDrawableFrameInfo.DisposalMethod[] var0 = new AnimatedDrawableFrameInfo.DisposalMethod[]{DISPOSE_DO_NOT, DISPOSE_TO_BACKGROUND, DISPOSE_TO_PREVIOUS};
      }
   }
}
