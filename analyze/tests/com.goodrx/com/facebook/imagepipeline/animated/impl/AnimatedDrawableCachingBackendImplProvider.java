package com.facebook.imagepipeline.animated.impl;

import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl;

public interface AnimatedDrawableCachingBackendImplProvider {
   AnimatedDrawableCachingBackendImpl get(AnimatedDrawableBackend var1, AnimatedDrawableOptions var2);
}
