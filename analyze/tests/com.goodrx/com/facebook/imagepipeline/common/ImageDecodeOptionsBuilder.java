package com.facebook.imagepipeline.common;

import com.facebook.imagepipeline.common.ImageDecodeOptions;

public class ImageDecodeOptionsBuilder {
   private int mBackgroundColor = -1;
   private boolean mDecodeAllFrames;
   private boolean mDecodePreviewFrame;
   private boolean mForceOldAnimationCode;
   private int mMinDecodeIntervalMs = 100;
   private boolean mUseLastFrameForPreview;

   public ImageDecodeOptions build() {
      return new ImageDecodeOptions(this);
   }

   public int getBackgroundColor() {
      return this.mBackgroundColor;
   }

   public boolean getDecodeAllFrames() {
      return this.mDecodeAllFrames;
   }

   public boolean getDecodePreviewFrame() {
      return this.mDecodePreviewFrame;
   }

   public boolean getForceOldAnimationCode() {
      return this.mForceOldAnimationCode;
   }

   public int getMinDecodeIntervalMs() {
      return this.mMinDecodeIntervalMs;
   }

   public boolean getUseLastFrameForPreview() {
      return this.mUseLastFrameForPreview;
   }

   public ImageDecodeOptionsBuilder setBackgroundColor(int var1) {
      this.mBackgroundColor = var1;
      return this;
   }

   public ImageDecodeOptionsBuilder setDecodeAllFrames(boolean var1) {
      this.mDecodeAllFrames = var1;
      return this;
   }

   public ImageDecodeOptionsBuilder setDecodePreviewFrame(boolean var1) {
      this.mDecodePreviewFrame = var1;
      return this;
   }

   public ImageDecodeOptionsBuilder setForceOldAnimationCode(boolean var1) {
      this.mForceOldAnimationCode = var1;
      return this;
   }

   public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions var1) {
      this.mBackgroundColor = var1.backgroundColor;
      this.mForceOldAnimationCode = var1.forceOldAnimationCode;
      this.mDecodePreviewFrame = var1.decodePreviewFrame;
      this.mUseLastFrameForPreview = var1.useLastFrameForPreview;
      this.mDecodeAllFrames = var1.decodeAllFrames;
      return this;
   }

   public ImageDecodeOptionsBuilder setMinDecodeIntervalMs(int var1) {
      this.mMinDecodeIntervalMs = var1;
      return this;
   }

   public ImageDecodeOptionsBuilder setUseLastFrameForPreview(boolean var1) {
      this.mUseLastFrameForPreview = var1;
      return this;
   }
}
