package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;

public abstract class DelegatingAnimatedDrawableBackend implements AnimatedDrawableBackend {
   private final AnimatedDrawableBackend mAnimatedDrawableBackend;

   public DelegatingAnimatedDrawableBackend(AnimatedDrawableBackend var1) {
      this.mAnimatedDrawableBackend = var1;
   }

   public void dropCaches() {
      this.mAnimatedDrawableBackend.dropCaches();
   }

   public AnimatedImageResult getAnimatedImageResult() {
      return this.mAnimatedDrawableBackend.getAnimatedImageResult();
   }

   protected AnimatedDrawableBackend getDelegate() {
      return this.mAnimatedDrawableBackend;
   }

   public int getDurationMs() {
      return this.mAnimatedDrawableBackend.getDurationMs();
   }

   public int getDurationMsForFrame(int var1) {
      return this.mAnimatedDrawableBackend.getDurationMsForFrame(var1);
   }

   public int getFrameCount() {
      return this.mAnimatedDrawableBackend.getFrameCount();
   }

   public int getFrameForPreview() {
      return this.mAnimatedDrawableBackend.getFrameForPreview();
   }

   public int getFrameForTimestampMs(int var1) {
      return this.mAnimatedDrawableBackend.getFrameForTimestampMs(var1);
   }

   public AnimatedDrawableFrameInfo getFrameInfo(int var1) {
      return this.mAnimatedDrawableBackend.getFrameInfo(var1);
   }

   public int getHeight() {
      return this.mAnimatedDrawableBackend.getHeight();
   }

   public int getLoopCount() {
      return this.mAnimatedDrawableBackend.getLoopCount();
   }

   public int getMemoryUsage() {
      return this.mAnimatedDrawableBackend.getMemoryUsage();
   }

   public CloseableReference<Bitmap> getPreDecodedFrame(int var1) {
      return this.mAnimatedDrawableBackend.getPreDecodedFrame(var1);
   }

   public int getRenderedHeight() {
      return this.mAnimatedDrawableBackend.getRenderedHeight();
   }

   public int getRenderedWidth() {
      return this.mAnimatedDrawableBackend.getRenderedWidth();
   }

   public int getTimestampMsForFrame(int var1) {
      return this.mAnimatedDrawableBackend.getTimestampMsForFrame(var1);
   }

   public int getWidth() {
      return this.mAnimatedDrawableBackend.getWidth();
   }

   public boolean hasPreDecodedFrame(int var1) {
      return this.mAnimatedDrawableBackend.hasPreDecodedFrame(var1);
   }

   public void renderFrame(int var1, Canvas var2) {
      this.mAnimatedDrawableBackend.renderFrame(var1, var2);
   }
}
