package com.facebook.imagepipeline.animated.base;

import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptionsBuilder;
import javax.annotation.concurrent.Immutable;

@Immutable
public class AnimatedDrawableOptions {
   public static AnimatedDrawableOptions DEFAULTS = newBuilder().build();
   public final boolean allowPrefetching;
   public final boolean enableDebugging;
   public final boolean forceKeepAllFramesInMemory;
   public final int maximumBytes;

   public AnimatedDrawableOptions(AnimatedDrawableOptionsBuilder var1) {
      this.forceKeepAllFramesInMemory = var1.getForceKeepAllFramesInMemory();
      this.allowPrefetching = var1.getAllowPrefetching();
      this.maximumBytes = var1.getMaximumBytes();
      this.enableDebugging = var1.getEnableDebugging();
   }

   public static AnimatedDrawableOptionsBuilder newBuilder() {
      return new AnimatedDrawableOptionsBuilder();
   }
}
