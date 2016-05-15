package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DiskCacheProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.NullProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.WebpTranscodeProducer;

public class ProducerFactory {
   private AssetManager mAssetManager;
   private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
   private final ByteArrayPool mByteArrayPool;
   private final CacheKeyFactory mCacheKeyFactory;
   private ContentResolver mContentResolver;
   private final boolean mDecodeFileDescriptorEnabled;
   private final BufferedDiskCache mDefaultBufferedDiskCache;
   private final boolean mDownsampleEnabled;
   private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
   private final ExecutorSupplier mExecutorSupplier;
   private final ImageDecoder mImageDecoder;
   private final PlatformBitmapFactory mPlatformBitmapFactory;
   private final PooledByteBufferFactory mPooledByteBufferFactory;
   private final ProgressiveJpegConfig mProgressiveJpegConfig;
   private final boolean mResizeAndRotateEnabledForNetwork;
   private Resources mResources;
   private final BufferedDiskCache mSmallImageBufferedDiskCache;

   public ProducerFactory(Context var1, ByteArrayPool var2, ImageDecoder var3, ProgressiveJpegConfig var4, boolean var5, boolean var6, ExecutorSupplier var7, PooledByteBufferFactory var8, MemoryCache<CacheKey, CloseableImage> var9, MemoryCache<CacheKey, PooledByteBuffer> var10, BufferedDiskCache var11, BufferedDiskCache var12, CacheKeyFactory var13, PlatformBitmapFactory var14, boolean var15) {
      this.mContentResolver = var1.getApplicationContext().getContentResolver();
      this.mResources = var1.getApplicationContext().getResources();
      this.mAssetManager = var1.getApplicationContext().getAssets();
      this.mByteArrayPool = var2;
      this.mImageDecoder = var3;
      this.mProgressiveJpegConfig = var4;
      this.mDownsampleEnabled = var5;
      this.mResizeAndRotateEnabledForNetwork = var6;
      this.mExecutorSupplier = var7;
      this.mPooledByteBufferFactory = var8;
      this.mBitmapMemoryCache = var9;
      this.mEncodedMemoryCache = var10;
      this.mDefaultBufferedDiskCache = var11;
      this.mSmallImageBufferedDiskCache = var12;
      this.mCacheKeyFactory = var13;
      this.mPlatformBitmapFactory = var14;
      this.mDecodeFileDescriptorEnabled = var15;
   }

   public static AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer(Producer<EncodedImage> var0) {
      return new AddImageTransformMetaDataProducer(var0);
   }

   public static BranchOnSeparateImagesProducer newBranchOnSeparateImagesProducer(Producer<EncodedImage> var0, Producer<EncodedImage> var1) {
      return new BranchOnSeparateImagesProducer(var0, var1);
   }

   public static <T> NullProducer<T> newNullProducer() {
      return new NullProducer();
   }

   public static <T> SwallowResultProducer<T> newSwallowResultProducer(Producer<T> var0) {
      return new SwallowResultProducer(var0);
   }

   public <T> ThreadHandoffProducer<T> newBackgroundThreadHandoffProducer(Producer<T> var1, ThreadHandoffProducerQueue var2) {
      return new ThreadHandoffProducer(var1, var2);
   }

   public BitmapMemoryCacheGetProducer newBitmapMemoryCacheGetProducer(Producer<CloseableReference<CloseableImage>> var1) {
      return new BitmapMemoryCacheGetProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, var1);
   }

   public BitmapMemoryCacheKeyMultiplexProducer newBitmapMemoryCacheKeyMultiplexProducer(Producer<CloseableReference<CloseableImage>> var1) {
      return new BitmapMemoryCacheKeyMultiplexProducer(this.mCacheKeyFactory, var1);
   }

   public BitmapMemoryCacheProducer newBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> var1) {
      return new BitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, var1);
   }

   public LocalContentUriFetchProducer newContentUriFetchProducer() {
      return new LocalContentUriFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver, this.mDecodeFileDescriptorEnabled);
   }

   public DataFetchProducer newDataFetchProducer() {
      return new DataFetchProducer(this.mPooledByteBufferFactory, this.mDecodeFileDescriptorEnabled);
   }

   public DecodeProducer newDecodeProducer(Producer<EncodedImage> var1) {
      return new DecodeProducer(this.mByteArrayPool, this.mExecutorSupplier.forDecode(), this.mImageDecoder, this.mProgressiveJpegConfig, this.mDownsampleEnabled, this.mResizeAndRotateEnabledForNetwork, var1);
   }

   public DiskCacheProducer newDiskCacheProducer(Producer<EncodedImage> var1) {
      return new DiskCacheProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, var1);
   }

   public EncodedCacheKeyMultiplexProducer newEncodedCacheKeyMultiplexProducer(Producer<EncodedImage> var1) {
      return new EncodedCacheKeyMultiplexProducer(this.mCacheKeyFactory, var1);
   }

   public EncodedMemoryCacheProducer newEncodedMemoryCacheProducer(Producer<EncodedImage> var1) {
      return new EncodedMemoryCacheProducer(this.mEncodedMemoryCache, this.mCacheKeyFactory, var1);
   }

   public LocalAssetFetchProducer newLocalAssetFetchProducer() {
      return new LocalAssetFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mAssetManager, this.mDecodeFileDescriptorEnabled);
   }

   public LocalExifThumbnailProducer newLocalExifThumbnailProducer() {
      return new LocalExifThumbnailProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
   }

   public LocalFileFetchProducer newLocalFileFetchProducer() {
      return new LocalFileFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mDecodeFileDescriptorEnabled);
   }

   public LocalResourceFetchProducer newLocalResourceFetchProducer() {
      return new LocalResourceFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mResources, this.mDecodeFileDescriptorEnabled);
   }

   public LocalVideoThumbnailProducer newLocalVideoThumbnailProducer() {
      return new LocalVideoThumbnailProducer(this.mExecutorSupplier.forLocalStorageRead());
   }

   public NetworkFetchProducer newNetworkFetchProducer(NetworkFetcher var1) {
      return new NetworkFetchProducer(this.mPooledByteBufferFactory, this.mByteArrayPool, var1);
   }

   public PostprocessedBitmapMemoryCacheProducer newPostprocessorBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> var1) {
      return new PostprocessedBitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, var1);
   }

   public PostprocessorProducer newPostprocessorProducer(Producer<CloseableReference<CloseableImage>> var1) {
      return new PostprocessorProducer(var1, this.mPlatformBitmapFactory, this.mExecutorSupplier.forBackgroundTasks());
   }

   public ResizeAndRotateProducer newResizeAndRotateProducer(Producer<EncodedImage> var1) {
      return new ResizeAndRotateProducer(this.mExecutorSupplier.forBackgroundTasks(), this.mPooledByteBufferFactory, var1);
   }

   public <T> ThrottlingProducer<T> newThrottlingProducer(int var1, Producer<T> var2) {
      return new ThrottlingProducer(var1, this.mExecutorSupplier.forLightweightBackgroundTasks(), var2);
   }

   public WebpTranscodeProducer newWebpTranscodeProducer(Producer<EncodedImage> var1) {
      return new WebpTranscodeProducer(this.mExecutorSupplier.forBackgroundTasks(), this.mPooledByteBufferFactory, var1);
   }
}
