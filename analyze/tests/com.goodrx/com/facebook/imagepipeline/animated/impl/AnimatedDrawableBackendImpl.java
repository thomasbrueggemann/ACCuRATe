package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.concurrent.GuardedBy;

public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
   private final AnimatedDrawableUtil mAnimatedDrawableUtil;
   private final AnimatedImage mAnimatedImage;
   private final AnimatedImageResult mAnimatedImageResult;
   private final int mDurationMs;
   private final int[] mFrameDurationsMs;
   private final AnimatedDrawableFrameInfo[] mFrameInfos;
   private final int[] mFrameTimestampsMs;
   private final Rect mRenderedBounds;
   @GuardedBy("this")
   private Bitmap mTempBitmap;

   public AnimatedDrawableBackendImpl(AnimatedDrawableUtil var1, AnimatedImageResult var2, Rect var3) {
      this.mAnimatedDrawableUtil = var1;
      this.mAnimatedImageResult = var2;
      this.mAnimatedImage = var2.getImage();
      this.mFrameDurationsMs = this.mAnimatedImage.getFrameDurations();
      this.mAnimatedDrawableUtil.fixFrameDurations(this.mFrameDurationsMs);
      this.mDurationMs = this.mAnimatedDrawableUtil.getTotalDurationFromFrameDurations(this.mFrameDurationsMs);
      this.mFrameTimestampsMs = this.mAnimatedDrawableUtil.getFrameTimeStampsFromDurations(this.mFrameDurationsMs);
      this.mRenderedBounds = getBoundsToUse(this.mAnimatedImage, var3);
      this.mFrameInfos = new AnimatedDrawableFrameInfo[this.mAnimatedImage.getFrameCount()];

      for(int var4 = 0; var4 < this.mAnimatedImage.getFrameCount(); ++var4) {
         this.mFrameInfos[var4] = this.mAnimatedImage.getFrameInfo(var4);
      }

   }

   private static Rect getBoundsToUse(AnimatedImage var0, Rect var1) {
      return var1 == null?new Rect(0, 0, var0.getWidth(), var0.getHeight()):new Rect(0, 0, Math.min(var1.width(), var0.getWidth()), Math.min(var1.height(), var0.getHeight()));
   }

   private void renderImageSupportsScaling(Canvas param1, AnimatedImageFrame param2) {
      // $FF: Couldn't be decompiled
   }

   public void dropCaches() {
      synchronized(this){}

      try {
         if(this.mTempBitmap != null) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
         }
      } finally {
         ;
      }

   }

   public AnimatedDrawableBackend forNewBounds(Rect var1) {
      return getBoundsToUse(this.mAnimatedImage, var1).equals(this.mRenderedBounds)?this:new AnimatedDrawableBackendImpl(this.mAnimatedDrawableUtil, this.mAnimatedImageResult, var1);
   }

   public AnimatedImageResult getAnimatedImageResult() {
      return this.mAnimatedImageResult;
   }

   public int getDurationMs() {
      return this.mDurationMs;
   }

   public int getDurationMsForFrame(int var1) {
      return this.mFrameDurationsMs[var1];
   }

   public int getFrameCount() {
      return this.mAnimatedImage.getFrameCount();
   }

   public int getFrameForPreview() {
      return this.mAnimatedImageResult.getFrameForPreview();
   }

   public int getFrameForTimestampMs(int var1) {
      return this.mAnimatedDrawableUtil.getFrameForTimestampMs(this.mFrameTimestampsMs, var1);
   }

   public AnimatedDrawableFrameInfo getFrameInfo(int var1) {
      return this.mFrameInfos[var1];
   }

   public int getHeight() {
      return this.mAnimatedImage.getHeight();
   }

   public int getLoopCount() {
      return this.mAnimatedImage.getLoopCount();
   }

   public int getMemoryUsage() {
      // $FF: Couldn't be decompiled
   }

   public CloseableReference<Bitmap> getPreDecodedFrame(int var1) {
      return this.mAnimatedImageResult.getDecodedFrame(var1);
   }

   public int getRenderedHeight() {
      return this.mRenderedBounds.height();
   }

   public int getRenderedWidth() {
      return this.mRenderedBounds.width();
   }

   public int getTimestampMsForFrame(int var1) {
      Preconditions.checkElementIndex(var1, this.mFrameTimestampsMs.length);
      return this.mFrameTimestampsMs[var1];
   }

   public int getWidth() {
      return this.mAnimatedImage.getWidth();
   }

   public boolean hasPreDecodedFrame(int var1) {
      return this.mAnimatedImageResult.hasDecodedFrame(var1);
   }

   public void renderFrame(int var1, Canvas var2) {
      AnimatedImageFrame var3 = this.mAnimatedImage.getFrame(var1);

      try {
         if(this.mAnimatedImage.doesRenderSupportScaling()) {
            this.renderImageSupportsScaling(var2, var3);
         } else {
            this.renderImageDoesNotSupportScaling(var2, var3);
         }
      } finally {
         var3.dispose();
      }

   }

   public void renderImageDoesNotSupportScaling(Canvas param1, AnimatedImageFrame param2) {
      // $FF: Couldn't be decompiled
   }
}
