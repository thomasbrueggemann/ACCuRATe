package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
   private static final Class<?> TAG = PipelineDraweeController.class;
   private final AnimatedDrawableFactory mAnimatedDrawableFactory;
   private Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
   private final Resources mResources;

   public PipelineDraweeController(Resources var1, DeferredReleaser var2, AnimatedDrawableFactory var3, Executor var4, Supplier<DataSource<CloseableReference<CloseableImage>>> var5, String var6, Object var7) {
      super(var2, var4, var6, var7);
      this.mResources = var1;
      this.mAnimatedDrawableFactory = var3;
      this.init(var5);
   }

   private void init(Supplier<DataSource<CloseableReference<CloseableImage>>> var1) {
      this.mDataSourceSupplier = var1;
   }

   protected Drawable createDrawable(CloseableReference<CloseableImage> var1) {
      Preconditions.checkState(CloseableReference.isValid(var1));
      CloseableImage var2 = (CloseableImage)var1.get();
      if(var2 instanceof CloseableStaticBitmap) {
         CloseableStaticBitmap var3 = (CloseableStaticBitmap)var2;
         BitmapDrawable var4 = new BitmapDrawable(this.mResources, var3.getUnderlyingBitmap());
         return (Drawable)(var3.getRotationAngle() != 0 && var3.getRotationAngle() != -1?new OrientedDrawable(var4, var3.getRotationAngle()):var4);
      } else if(var2 instanceof CloseableAnimatedImage) {
         return this.mAnimatedDrawableFactory.create(((CloseableAnimatedImage)var2).getImageResult());
      } else {
         throw new UnsupportedOperationException("Unrecognized image class: " + var2);
      }
   }

   protected DataSource<CloseableReference<CloseableImage>> getDataSource() {
      if(FLog.isLoggable(2)) {
         FLog.method_418(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
      }

      return (DataSource)this.mDataSourceSupplier.get();
   }

   protected int getImageHash(@Nullable CloseableReference<CloseableImage> var1) {
      return var1 != null?var1.getValueHash():0;
   }

   protected ImageInfo getImageInfo(CloseableReference<CloseableImage> var1) {
      Preconditions.checkState(CloseableReference.isValid(var1));
      return (ImageInfo)var1.get();
   }

   protected Resources getResources() {
      return this.mResources;
   }

   public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> var1, String var2, Object var3) {
      super.initialize(var2, var3);
      this.init(var1);
   }

   protected void releaseDrawable(@Nullable Drawable var1) {
      if(var1 instanceof DrawableWithCaches) {
         ((DrawableWithCaches)var1).dropCaches();
      }

   }

   protected void releaseImage(@Nullable CloseableReference<CloseableImage> var1) {
      CloseableReference.closeSafely(var1);
   }

   public String toString() {
      return Objects.toStringHelper((Object)this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
   }
}
