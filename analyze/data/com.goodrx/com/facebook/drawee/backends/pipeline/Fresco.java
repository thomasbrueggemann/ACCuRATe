package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;

public class Fresco {
   private static PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier;

   public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier() {
      return sDraweeControllerBuilderSupplier;
   }

   public static ImagePipeline getImagePipeline() {
      return getImagePipelineFactory().getImagePipeline();
   }

   public static ImagePipelineFactory getImagePipelineFactory() {
      return ImagePipelineFactory.getInstance();
   }

   public static void initialize(Context var0) {
      ImagePipelineFactory.initialize(var0);
      initializeDrawee(var0);
   }

   public static void initialize(Context var0, ImagePipelineConfig var1) {
      ImagePipelineFactory.initialize(var1);
      initializeDrawee(var0);
   }

   private static void initializeDrawee(Context var0) {
      sDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(var0);
      SimpleDraweeView.initialize(sDraweeControllerBuilderSupplier);
   }

   public static PipelineDraweeControllerBuilder newDraweeControllerBuilder() {
      return sDraweeControllerBuilderSupplier.get();
   }

   public static void shutDown() {
      sDraweeControllerBuilderSupplier = null;
      SimpleDraweeView.shutDown();
      ImagePipelineFactory.shutDown();
   }
}
