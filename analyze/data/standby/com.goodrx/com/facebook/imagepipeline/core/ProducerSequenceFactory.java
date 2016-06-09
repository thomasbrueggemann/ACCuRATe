package com.facebook.imagepipeline.core;

import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.core.ProducerFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DiskCacheProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;

public class ProducerSequenceFactory {
   private static final int MAX_SIMULTANEOUS_FILE_FETCH_AND_RESIZE = 5;
   @VisibleForTesting
   Producer<EncodedImage> mBackgroundNetworkFetchToEncodedMemorySequence;
   @VisibleForTesting
   Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> mCloseableImagePrefetchSequences;
   private Producer<EncodedImage> mCommonNetworkFetchToEncodedMemorySequence;
   @VisibleForTesting
   Producer<CloseableReference<CloseableImage>> mDataFetchSequence;
   private final boolean mDownsampleEnabled;
   @VisibleForTesting
   Producer<CloseableReference<PooledByteBuffer>> mEncodedImageProducerSequence;
   @VisibleForTesting
   Producer<CloseableReference<CloseableImage>> mLocalAssetFetchSequence;
   @VisibleForTesting
   Producer<CloseableReference<CloseableImage>> mLocalContentUriFetchSequence;
   @VisibleForTesting
   Producer<CloseableReference<CloseableImage>> mLocalImageFileFetchSequence;
   @VisibleForTesting
   Producer<CloseableReference<CloseableImage>> mLocalResourceFetchSequence;
   @VisibleForTesting
   Producer<CloseableReference<CloseableImage>> mLocalVideoFileFetchSequence;
   @VisibleForTesting
   Producer<CloseableReference<CloseableImage>> mNetworkFetchSequence;
   @VisibleForTesting
   Producer<Void> mNetworkFetchToEncodedMemoryPrefetchSequence;
   private final NetworkFetcher mNetworkFetcher;
   @VisibleForTesting
   Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mPostprocessorSequences;
   private final ProducerFactory mProducerFactory;
   private final boolean mResizeAndRotateEnabledForNetwork;
   private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
   private final boolean mWebpSupportEnabled;

   public ProducerSequenceFactory(ProducerFactory var1, NetworkFetcher var2, boolean var3, boolean var4, boolean var5, ThreadHandoffProducerQueue var6) {
      this.mProducerFactory = var1;
      this.mNetworkFetcher = var2;
      this.mResizeAndRotateEnabledForNetwork = var3;
      this.mDownsampleEnabled = var4;
      this.mWebpSupportEnabled = var5;
      this.mPostprocessorSequences = new HashMap();
      this.mCloseableImagePrefetchSequences = new HashMap();
      this.mThreadHandoffProducerQueue = var6;
   }

   private Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence() {
      synchronized(this){}

      Producer var2;
      try {
         if(this.mBackgroundNetworkFetchToEncodedMemorySequence == null) {
            this.mBackgroundNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(this.getCommonNetworkFetchToEncodedMemorySequence(), this.mThreadHandoffProducerQueue);
         }

         var2 = this.mBackgroundNetworkFetchToEncodedMemorySequence;
      } finally {
         ;
      }

      return var2;
   }

   private Producer<CloseableReference<CloseableImage>> getBasicDecodedImageSequence(ImageRequest var1) {
      Preconditions.checkNotNull(var1);
      Uri var3 = var1.getSourceUri();
      Preconditions.checkNotNull(var3, "Uri is null.");
      if(UriUtil.isNetworkUri(var3)) {
         return this.getNetworkFetchSequence();
      } else if(UriUtil.isLocalFileUri(var3)) {
         return MediaUtils.isVideo(MediaUtils.extractMime(var3.getPath()))?this.getLocalVideoFileFetchSequence():this.getLocalImageFileFetchSequence();
      } else if(UriUtil.isLocalContentUri(var3)) {
         return this.getLocalContentUriFetchSequence();
      } else if(UriUtil.isLocalAssetUri(var3)) {
         return this.getLocalAssetFetchSequence();
      } else if(UriUtil.isLocalResourceUri(var3)) {
         return this.getLocalResourceFetchSequence();
      } else if(UriUtil.isDataUri(var3)) {
         return this.getDataFetchSequence();
      } else {
         String var5 = var3.toString();
         if(var5.length() > 30) {
            var5 = var5.substring(0, 30) + "...";
         }

         throw new RuntimeException("Unsupported uri scheme! Uri is: " + var5);
      }
   }

   private Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence() {
      synchronized(this){}

      Producer var2;
      try {
         if(this.mCommonNetworkFetchToEncodedMemorySequence == null) {
            this.mCommonNetworkFetchToEncodedMemorySequence = ProducerFactory.newAddImageTransformMetaDataProducer(this.newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newNetworkFetchProducer(this.mNetworkFetcher)));
            if(this.mResizeAndRotateEnabledForNetwork && !this.mDownsampleEnabled) {
               this.mCommonNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newResizeAndRotateProducer(this.mCommonNetworkFetchToEncodedMemorySequence);
            }
         }

         var2 = this.mCommonNetworkFetchToEncodedMemorySequence;
      } finally {
         ;
      }

      return var2;
   }

   private Producer<CloseableReference<CloseableImage>> getDataFetchSequence() {
      synchronized(this){}

      Producer var2;
      try {
         if(this.mDataFetchSequence == null) {
            Object var3 = this.mProducerFactory.newDataFetchProducer();
            if(VERSION.SDK_INT < 18 && !this.mWebpSupportEnabled) {
               var3 = this.mProducerFactory.newWebpTranscodeProducer((Producer)var3);
            }

            ProducerFactory var10000 = this.mProducerFactory;
            Object var5 = ProducerFactory.newAddImageTransformMetaDataProducer((Producer)var3);
            if(!this.mDownsampleEnabled) {
               var5 = this.mProducerFactory.newResizeAndRotateProducer((Producer)var5);
            }

            this.mDataFetchSequence = this.newBitmapCacheGetToDecodeSequence((Producer)var5);
         }

         var2 = this.mDataFetchSequence;
      } finally {
         ;
      }

      return var2;
   }

   private Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> var1) {
      synchronized(this){}

      Producer var3;
      try {
         if(!this.mCloseableImagePrefetchSequences.containsKey(var1)) {
            ProducerFactory var10000 = this.mProducerFactory;
            SwallowResultProducer var5 = ProducerFactory.newSwallowResultProducer(var1);
            this.mCloseableImagePrefetchSequences.put(var1, var5);
         }

         var3 = (Producer)this.mCloseableImagePrefetchSequences.get(var1);
      } finally {
         ;
      }

      return var3;
   }

   private Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence() {
      synchronized(this){}

      Producer var2;
      try {
         if(this.mLocalAssetFetchSequence == null) {
            this.mLocalAssetFetchSequence = this.newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalAssetFetchProducer());
         }

         var2 = this.mLocalAssetFetchSequence;
      } finally {
         ;
      }

      return var2;
   }

   private Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence() {
      synchronized(this){}

      Producer var2;
      try {
         if(this.mLocalContentUriFetchSequence == null) {
            this.mLocalContentUriFetchSequence = this.newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newContentUriFetchProducer());
         }

         var2 = this.mLocalContentUriFetchSequence;
      } finally {
         ;
      }

      return var2;
   }

   private Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence() {
      synchronized(this){}

      Producer var2;
      try {
         if(this.mLocalImageFileFetchSequence == null) {
            this.mLocalImageFileFetchSequence = this.newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalFileFetchProducer());
         }

         var2 = this.mLocalImageFileFetchSequence;
      } finally {
         ;
      }

      return var2;
   }

   private Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence() {
      synchronized(this){}

      Producer var2;
      try {
         if(this.mLocalResourceFetchSequence == null) {
            this.mLocalResourceFetchSequence = this.newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalResourceFetchProducer());
         }

         var2 = this.mLocalResourceFetchSequence;
      } finally {
         ;
      }

      return var2;
   }

   private Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence() {
      synchronized(this){}

      Producer var2;
      try {
         if(this.mLocalVideoFileFetchSequence == null) {
            this.mLocalVideoFileFetchSequence = this.newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalVideoThumbnailProducer());
         }

         var2 = this.mLocalVideoFileFetchSequence;
      } finally {
         ;
      }

      return var2;
   }

   private Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence() {
      synchronized(this){}

      Producer var2;
      try {
         if(this.mNetworkFetchSequence == null) {
            this.mNetworkFetchSequence = this.newBitmapCacheGetToDecodeSequence(this.getCommonNetworkFetchToEncodedMemorySequence());
         }

         var2 = this.mNetworkFetchSequence;
      } finally {
         ;
      }

      return var2;
   }

   private Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence() {
      synchronized(this){}

      Producer var2;
      try {
         if(this.mNetworkFetchToEncodedMemoryPrefetchSequence == null) {
            ProducerFactory var10000 = this.mProducerFactory;
            this.mNetworkFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(this.getBackgroundNetworkFetchToEncodedMemorySequence());
         }

         var2 = this.mNetworkFetchToEncodedMemoryPrefetchSequence;
      } finally {
         ;
      }

      return var2;
   }

   private Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> var1) {
      synchronized(this){}

      Producer var3;
      try {
         if(!this.mPostprocessorSequences.containsKey(var1)) {
            PostprocessorProducer var4 = this.mProducerFactory.newPostprocessorProducer(var1);
            PostprocessedBitmapMemoryCacheProducer var5 = this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer(var4);
            this.mPostprocessorSequences.put(var1, var5);
         }

         var3 = (Producer)this.mPostprocessorSequences.get(var1);
      } finally {
         ;
      }

      return var3;
   }

   private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> var1) {
      BitmapMemoryCacheProducer var2 = this.mProducerFactory.newBitmapMemoryCacheProducer(var1);
      BitmapMemoryCacheKeyMultiplexProducer var3 = this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(var2);
      ThreadHandoffProducer var4 = this.mProducerFactory.newBackgroundThreadHandoffProducer(var3, this.mThreadHandoffProducerQueue);
      return this.mProducerFactory.newBitmapMemoryCacheGetProducer(var4);
   }

   private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> var1) {
      return this.newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(var1));
   }

   private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> var1) {
      return this.newBitmapCacheGetToDecodeSequence(this.newLocalTransformationsSequence(this.newEncodedCacheMultiplexToTranscodeSequence(var1)));
   }

   private Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> var1) {
      if(VERSION.SDK_INT < 18 && !this.mWebpSupportEnabled) {
         var1 = this.mProducerFactory.newWebpTranscodeProducer((Producer)var1);
      }

      DiskCacheProducer var2 = this.mProducerFactory.newDiskCacheProducer((Producer)var1);
      EncodedMemoryCacheProducer var3 = this.mProducerFactory.newEncodedMemoryCacheProducer(var2);
      return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(var3);
   }

   private Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> var1) {
      ProducerFactory var10000 = this.mProducerFactory;
      Object var3 = ProducerFactory.newAddImageTransformMetaDataProducer(var1);
      if(!this.mDownsampleEnabled) {
         var3 = this.mProducerFactory.newResizeAndRotateProducer((Producer)var3);
      }

      ThrottlingProducer var4 = this.mProducerFactory.newThrottlingProducer(5, (Producer)var3);
      Object var5 = this.mProducerFactory.newLocalExifThumbnailProducer();
      if(!this.mDownsampleEnabled) {
         var5 = this.mProducerFactory.newResizeAndRotateProducer((Producer)var5);
      }

      var10000 = this.mProducerFactory;
      return ProducerFactory.newBranchOnSeparateImagesProducer((Producer)var5, var4);
   }

   private static void validateEncodedImageRequest(ImageRequest var0) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(UriUtil.isNetworkUri(var0.getSourceUri()));
      boolean var2;
      if(var0.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
   }

   public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest var1) {
      return this.getDecodedImagePrefetchSequence(this.getBasicDecodedImageSequence(var1));
   }

   public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest var1) {
      Producer var2 = this.getBasicDecodedImageSequence(var1);
      if(var1.getPostprocessor() != null) {
         var2 = this.getPostprocessorSequence(var2);
      }

      return var2;
   }

   public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest var1) {
      validateEncodedImageRequest(var1);
      return this.getNetworkFetchToEncodedMemoryPrefetchSequence();
   }

   public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest param1) {
      // $FF: Couldn't be decompiled
   }
}
