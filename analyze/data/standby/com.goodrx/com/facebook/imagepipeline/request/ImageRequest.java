package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Objects;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class ImageRequest {
   private final boolean mAutoRotateEnabled;
   private final ImageDecodeOptions mImageDecodeOptions;
   private final ImageRequest.ImageType mImageType;
   private final boolean mIsDiskCacheEnabled;
   private final boolean mLocalThumbnailPreviewsEnabled;
   private final ImageRequest.RequestLevel mLowestPermittedRequestLevel;
   private final Postprocessor mPostprocessor;
   private final boolean mProgressiveRenderingEnabled;
   private final Priority mRequestPriority;
   @Nullable
   ResizeOptions mResizeOptions = null;
   private File mSourceFile;
   private final Uri mSourceUri;

   protected ImageRequest(ImageRequestBuilder var1) {
      this.mImageType = var1.getImageType();
      this.mSourceUri = var1.getSourceUri();
      this.mProgressiveRenderingEnabled = var1.isProgressiveRenderingEnabled();
      this.mLocalThumbnailPreviewsEnabled = var1.isLocalThumbnailPreviewsEnabled();
      this.mImageDecodeOptions = var1.getImageDecodeOptions();
      this.mResizeOptions = var1.getResizeOptions();
      this.mAutoRotateEnabled = var1.isAutoRotateEnabled();
      this.mRequestPriority = var1.getRequestPriority();
      this.mLowestPermittedRequestLevel = var1.getLowestPermittedRequestLevel();
      this.mIsDiskCacheEnabled = var1.isDiskCacheEnabled();
      this.mPostprocessor = var1.getPostprocessor();
   }

   public static ImageRequest fromUri(@Nullable Uri var0) {
      return var0 == null?null:ImageRequestBuilder.newBuilderWithSource(var0).build();
   }

   public static ImageRequest fromUri(@Nullable String var0) {
      return var0 != null && var0.length() != 0?fromUri(Uri.parse(var0)):null;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof ImageRequest) {
         ImageRequest var2 = (ImageRequest)var1;
         if(Objects.equal(this.mSourceUri, var2.mSourceUri) && Objects.equal(this.mImageType, var2.mImageType) && Objects.equal(this.mSourceFile, var2.mSourceFile)) {
            return true;
         }
      }

      return false;
   }

   public boolean getAutoRotateEnabled() {
      return this.mAutoRotateEnabled;
   }

   public ImageDecodeOptions getImageDecodeOptions() {
      return this.mImageDecodeOptions;
   }

   public ImageRequest.ImageType getImageType() {
      return this.mImageType;
   }

   public boolean getLocalThumbnailPreviewsEnabled() {
      return this.mLocalThumbnailPreviewsEnabled;
   }

   public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
      return this.mLowestPermittedRequestLevel;
   }

   @Nullable
   public Postprocessor getPostprocessor() {
      return this.mPostprocessor;
   }

   public int getPreferredHeight() {
      return this.mResizeOptions != null?this.mResizeOptions.height:2048;
   }

   public int getPreferredWidth() {
      return this.mResizeOptions != null?this.mResizeOptions.width:2048;
   }

   public Priority getPriority() {
      return this.mRequestPriority;
   }

   public boolean getProgressiveRenderingEnabled() {
      return this.mProgressiveRenderingEnabled;
   }

   @Nullable
   public ResizeOptions getResizeOptions() {
      return this.mResizeOptions;
   }

   public File getSourceFile() {
      synchronized(this){}

      File var2;
      try {
         if(this.mSourceFile == null) {
            this.mSourceFile = new File(this.mSourceUri.getPath());
         }

         var2 = this.mSourceFile;
      } finally {
         ;
      }

      return var2;
   }

   public Uri getSourceUri() {
      return this.mSourceUri;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mImageType, this.mSourceUri, this.mSourceFile};
      return Objects.hashCode(var1);
   }

   public boolean isDiskCacheEnabled() {
      return this.mIsDiskCacheEnabled;
   }

   public static enum ImageType {
      DEFAULT,
      SMALL;

      static {
         ImageRequest.ImageType[] var0 = new ImageRequest.ImageType[]{SMALL, DEFAULT};
      }
   }

   public static enum RequestLevel {
      BITMAP_MEMORY_CACHE(4),
      DISK_CACHE(2),
      ENCODED_MEMORY_CACHE(3),
      FULL_FETCH(1);

      private int mValue;

      static {
         ImageRequest.RequestLevel[] var0 = new ImageRequest.RequestLevel[]{FULL_FETCH, DISK_CACHE, ENCODED_MEMORY_CACHE, BITMAP_MEMORY_CACHE};
      }

      private RequestLevel(int var3) {
         this.mValue = var3;
      }

      public static ImageRequest.RequestLevel getMax(ImageRequest.RequestLevel var0, ImageRequest.RequestLevel var1) {
         return var0.getValue() > var1.getValue()?var0:var1;
      }

      public int getValue() {
         return this.mValue;
      }
   }
}
