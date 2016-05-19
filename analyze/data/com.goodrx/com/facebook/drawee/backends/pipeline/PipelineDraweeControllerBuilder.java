package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;
import javax.annotation.Nullable;

public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {
   private final ImagePipeline mImagePipeline;
   private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

   public PipelineDraweeControllerBuilder(Context var1, PipelineDraweeControllerFactory var2, ImagePipeline var3, Set<ControllerListener> var4) {
      super(var1, var4);
      this.mImagePipeline = var3;
      this.mPipelineDraweeControllerFactory = var2;
   }

   protected DataSource<CloseableReference<CloseableImage>> getDataSourceForRequest(ImageRequest var1, Object var2, boolean var3) {
      return var3?this.mImagePipeline.fetchImageFromBitmapCache(var1, var2):this.mImagePipeline.fetchDecodedImage(var1, var2);
   }

   protected PipelineDraweeControllerBuilder getThis() {
      return this;
   }

   protected PipelineDraweeController obtainController() {
      DraweeController var1 = this.getOldController();
      if(var1 instanceof PipelineDraweeController) {
         PipelineDraweeController var2 = (PipelineDraweeController)var1;
         var2.initialize(this.obtainDataSourceSupplier(), generateUniqueControllerId(), this.getCallerContext());
         return var2;
      } else {
         return this.mPipelineDraweeControllerFactory.newController(this.obtainDataSourceSupplier(), generateUniqueControllerId(), this.getCallerContext());
      }
   }

   public PipelineDraweeControllerBuilder setUri(Uri var1) {
      return (PipelineDraweeControllerBuilder)super.setImageRequest(ImageRequest.fromUri(var1));
   }

   public PipelineDraweeControllerBuilder setUri(@Nullable String var1) {
      return (PipelineDraweeControllerBuilder)super.setImageRequest(ImageRequest.fromUri(var1));
   }
}
