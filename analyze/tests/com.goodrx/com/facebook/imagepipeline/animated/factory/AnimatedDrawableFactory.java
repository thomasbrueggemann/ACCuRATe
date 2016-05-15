package com.facebook.imagepipeline.animated.factory;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawable;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImplProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableDiagnosticsImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableDiagnosticsNoop;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import java.util.concurrent.ScheduledExecutorService;

public class AnimatedDrawableFactory {
   private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
   private final AnimatedDrawableCachingBackendImplProvider mAnimatedDrawableCachingBackendProvider;
   private final AnimatedDrawableUtil mAnimatedDrawableUtil;
   private final MonotonicClock mMonotonicClock;
   private final Resources mResources;
   private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

   public AnimatedDrawableFactory(AnimatedDrawableBackendProvider var1, AnimatedDrawableCachingBackendImplProvider var2, AnimatedDrawableUtil var3, ScheduledExecutorService var4, Resources var5) {
      this.mAnimatedDrawableBackendProvider = var1;
      this.mAnimatedDrawableCachingBackendProvider = var2;
      this.mAnimatedDrawableUtil = var3;
      this.mScheduledExecutorServiceForUiThread = var4;
      this.mMonotonicClock = new MonotonicClock() {
         public long now() {
            return SystemClock.uptimeMillis();
         }
      };
      this.mResources = var5;
   }

   private AnimatedDrawable createAnimatedDrawable(AnimatedDrawableOptions var1, AnimatedDrawableBackend var2) {
      DisplayMetrics var3 = this.mResources.getDisplayMetrics();
      AnimatedDrawableCachingBackendImpl var4 = this.mAnimatedDrawableCachingBackendProvider.get(var2, var1);
      Object var5;
      if(var1.enableDebugging) {
         var5 = new AnimatedDrawableDiagnosticsImpl(this.mAnimatedDrawableUtil, var3);
      } else {
         var5 = AnimatedDrawableDiagnosticsNoop.getInstance();
      }

      return new AnimatedDrawable(this.mScheduledExecutorServiceForUiThread, var4, (AnimatedDrawableDiagnostics)var5, this.mMonotonicClock);
   }

   public AnimatedDrawable create(AnimatedImageResult var1) {
      return this.create(var1, AnimatedDrawableOptions.DEFAULTS);
   }

   public AnimatedDrawable create(AnimatedImageResult var1, AnimatedDrawableOptions var2) {
      AnimatedImage var3 = var1.getImage();
      Rect var4 = new Rect(0, 0, var3.getWidth(), var3.getHeight());
      return this.createAnimatedDrawable(var2, this.mAnimatedDrawableBackendProvider.get(var1, var4));
   }
}
