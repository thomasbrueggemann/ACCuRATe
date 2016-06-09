package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.Set;

public class PipelineDraweeControllerBuilderSupplier implements Supplier<PipelineDraweeControllerBuilder> {
   private final Set<ControllerListener> mBoundControllerListeners;
   private final Context mContext;
   private final ImagePipeline mImagePipeline;
   private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

   public PipelineDraweeControllerBuilderSupplier(Context var1) {
      this(var1, ImagePipelineFactory.getInstance());
   }

   public PipelineDraweeControllerBuilderSupplier(Context var1, ImagePipelineFactory var2) {
      this(var1, var2, (Set)null);
   }

   public PipelineDraweeControllerBuilderSupplier(Context var1, ImagePipelineFactory var2, Set<ControllerListener> var3) {
      this.mContext = var1;
      this.mImagePipeline = var2.getImagePipeline();
      this.mPipelineDraweeControllerFactory = new PipelineDraweeControllerFactory(var1.getResources(), DeferredReleaser.getInstance(), var2.getAnimatedDrawableFactory(), UiThreadImmediateExecutorService.getInstance());
      this.mBoundControllerListeners = var3;
   }

   public PipelineDraweeControllerBuilder get() {
      return new PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners);
   }
}
