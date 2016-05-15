package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import javax.annotation.Nullable;

public class ImageRequestBuilder {
   private boolean mAutoRotateEnabled;
   private ImageDecodeOptions mImageDecodeOptions;
   private ImageRequest.ImageType mImageType;
   private boolean mLocalThumbnailPreviewsEnabled;
   private ImageRequest.RequestLevel mLowestPermittedRequestLevel;
   @Nullable
   private Postprocessor mPostprocessor;
   private boolean mProgressiveRenderingEnabled;
   private Priority mRequestPriority;
   @Nullable
   private ResizeOptions mResizeOptions;
   private Uri mSourceUri = null;

   private ImageRequestBuilder() {
      this.mLowestPermittedRequestLevel = ImageRequest.RequestLevel.FULL_FETCH;
      this.mAutoRotateEnabled = false;
      this.mResizeOptions = null;
      this.mImageDecodeOptions = ImageDecodeOptions.defaults();
      this.mImageType = ImageRequest.ImageType.DEFAULT;
      this.mProgressiveRenderingEnabled = false;
      this.mLocalThumbnailPreviewsEnabled = false;
      this.mRequestPriority = Priority.HIGH;
      this.mPostprocessor = null;
   }

   public static ImageRequestBuilder fromRequest(ImageRequest var0) {
      return newBuilderWithSource(var0.getSourceUri()).setAutoRotateEnabled(var0.getAutoRotateEnabled()).setImageDecodeOptions(var0.getImageDecodeOptions()).setImageType(var0.getImageType()).setLocalThumbnailPreviewsEnabled(var0.getLocalThumbnailPreviewsEnabled()).setLowestPermittedRequestLevel(var0.getLowestPermittedRequestLevel()).setPostprocessor(var0.getPostprocessor()).setProgressiveRenderingEnabled(var0.getProgressiveRenderingEnabled()).setRequestPriority(var0.getPriority()).setResizeOptions(var0.getResizeOptions());
   }

   public static ImageRequestBuilder newBuilderWithResourceId(int var0) {
      return newBuilderWithSource((new Builder()).scheme("res").path(String.valueOf(var0)).build());
   }

   public static ImageRequestBuilder newBuilderWithSource(Uri var0) {
      return (new ImageRequestBuilder()).setSource(var0);
   }

   public ImageRequest build() {
      this.validate();
      return new ImageRequest(this);
   }

   public ImageDecodeOptions getImageDecodeOptions() {
      return this.mImageDecodeOptions;
   }

   public ImageRequest.ImageType getImageType() {
      return this.mImageType;
   }

   public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
      return this.mLowestPermittedRequestLevel;
   }

   @Nullable
   public Postprocessor getPostprocessor() {
      return this.mPostprocessor;
   }

   public Priority getRequestPriority() {
      return this.mRequestPriority;
   }

   @Nullable
   public ResizeOptions getResizeOptions() {
      return this.mResizeOptions;
   }

   public Uri getSourceUri() {
      return this.mSourceUri;
   }

   public boolean isAutoRotateEnabled() {
      return this.mAutoRotateEnabled;
   }

   public boolean isDiskCacheEnabled() {
      return UriUtil.isNetworkUri(this.mSourceUri);
   }

   public boolean isLocalThumbnailPreviewsEnabled() {
      return this.mLocalThumbnailPreviewsEnabled;
   }

   public boolean isProgressiveRenderingEnabled() {
      return this.mProgressiveRenderingEnabled;
   }

   public ImageRequestBuilder setAutoRotateEnabled(boolean var1) {
      this.mAutoRotateEnabled = var1;
      return this;
   }

   public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions var1) {
      this.mImageDecodeOptions = var1;
      return this;
   }

   public ImageRequestBuilder setImageType(ImageRequest.ImageType var1) {
      this.mImageType = var1;
      return this;
   }

   public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean var1) {
      this.mLocalThumbnailPreviewsEnabled = var1;
      return this;
   }

   public ImageRequestBuilder setLowestPermittedRequestLevel(ImageRequest.RequestLevel var1) {
      this.mLowestPermittedRequestLevel = var1;
      return this;
   }

   public ImageRequestBuilder setPostprocessor(Postprocessor var1) {
      this.mPostprocessor = var1;
      return this;
   }

   public ImageRequestBuilder setProgressiveRenderingEnabled(boolean var1) {
      this.mProgressiveRenderingEnabled = var1;
      return this;
   }

   public ImageRequestBuilder setRequestPriority(Priority var1) {
      this.mRequestPriority = var1;
      return this;
   }

   public ImageRequestBuilder setResizeOptions(ResizeOptions var1) {
      this.mResizeOptions = var1;
      return this;
   }

   public ImageRequestBuilder setSource(Uri var1) {
      Preconditions.checkNotNull(var1);
      this.mSourceUri = var1;
      return this;
   }

   protected void validate() {
      if(this.mSourceUri == null) {
         throw new ImageRequestBuilder.BuilderException("Source must be set!");
      } else {
         if(UriUtil.isLocalResourceUri(this.mSourceUri)) {
            if(!this.mSourceUri.isAbsolute()) {
               throw new ImageRequestBuilder.BuilderException("Resource URI path must be absolute.");
            }

            if(this.mSourceUri.getPath().isEmpty()) {
               throw new ImageRequestBuilder.BuilderException("Resource URI must not be empty");
            }

            try {
               Integer.parseInt(this.mSourceUri.getPath().substring(1));
            } catch (NumberFormatException var2) {
               throw new ImageRequestBuilder.BuilderException("Resource URI path must be a resource id.");
            }
         }

         if(UriUtil.isLocalAssetUri(this.mSourceUri) && !this.mSourceUri.isAbsolute()) {
            throw new ImageRequestBuilder.BuilderException("Asset URI path must be absolute.");
         }
      }
   }

   public static class BuilderException extends RuntimeException {
      public BuilderException(String var1) {
         super("Invalid request builder: " + var1);
      }
   }
}
