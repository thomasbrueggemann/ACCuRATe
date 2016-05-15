package com.facebook.imagepipeline.animated.base;

import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;

public class AnimatedDrawableOptionsBuilder {
   private boolean mAllowPrefetching = true;
   private boolean mEnableDebugging;
   private boolean mForceKeepAllFramesInMemory;
   private int mMaximumBytes = -1;

   public AnimatedDrawableOptions build() {
      return new AnimatedDrawableOptions(this);
   }

   public boolean getAllowPrefetching() {
      return this.mAllowPrefetching;
   }

   public boolean getEnableDebugging() {
      return this.mEnableDebugging;
   }

   public boolean getForceKeepAllFramesInMemory() {
      return this.mForceKeepAllFramesInMemory;
   }

   public int getMaximumBytes() {
      return this.mMaximumBytes;
   }

   public AnimatedDrawableOptionsBuilder setAllowPrefetching(boolean var1) {
      this.mAllowPrefetching = var1;
      return this;
   }

   public AnimatedDrawableOptionsBuilder setEnableDebugging(boolean var1) {
      this.mEnableDebugging = var1;
      return this;
   }

   public AnimatedDrawableOptionsBuilder setForceKeepAllFramesInMemory(boolean var1) {
      this.mForceKeepAllFramesInMemory = var1;
      return this;
   }

   public AnimatedDrawableOptionsBuilder setMaximumBytes(int var1) {
      this.mMaximumBytes = var1;
      return this;
   }
}
