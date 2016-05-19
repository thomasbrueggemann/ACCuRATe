package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;

public class PipelineDraweeControllerFactory {
   private AnimatedDrawableFactory mAnimatedDrawableFactory;
   private DeferredReleaser mDeferredReleaser;
   private Resources mResources;
   private Executor mUiThreadExecutor;

   public PipelineDraweeControllerFactory(Resources var1, DeferredReleaser var2, AnimatedDrawableFactory var3, Executor var4) {
      this.mResources = var1;
      this.mDeferredReleaser = var2;
      this.mAnimatedDrawableFactory = var3;
      this.mUiThreadExecutor = var4;
   }

   public PipelineDraweeController newController(Supplier<DataSource<CloseableReference<CloseableImage>>> var1, String var2, Object var3) {
      return new PipelineDraweeController(this.mResources, this.mDeferredReleaser, this.mAnimatedDrawableFactory, this.mUiThreadExecutor, var1, var2, var3);
   }
}
