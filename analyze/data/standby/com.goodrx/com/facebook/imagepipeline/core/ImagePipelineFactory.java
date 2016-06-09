package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheFactory;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImplProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator;
import com.facebook.imagepipeline.bitmaps.GingerbreadBitmapFactory;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ProducerFactory;
import com.facebook.imagepipeline.core.ProducerSequenceFactory;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder;
import com.facebook.imagepipeline.platform.KitKatPurgeableDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class ImagePipelineFactory {
   private static ImagePipelineFactory sInstance = null;
   private AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
   private AnimatedDrawableFactory mAnimatedDrawableFactory;
   private AnimatedDrawableUtil mAnimatedDrawableUtil;
   private AnimatedImageFactory mAnimatedImageFactory;
   private CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
   private MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
   private final ImagePipelineConfig mConfig;
   private CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
   private MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
   private ImageDecoder mImageDecoder;
   private ImagePipeline mImagePipeline;
   private BufferedDiskCache mMainBufferedDiskCache;
   private DiskStorageCache mMainDiskStorageCache;
   private PlatformBitmapFactory mPlatformBitmapFactory;
   private PlatformDecoder mPlatformDecoder;
   private ProducerFactory mProducerFactory;
   private ProducerSequenceFactory mProducerSequenceFactory;
   private BufferedDiskCache mSmallImageBufferedDiskCache;
   private DiskStorageCache mSmallImageDiskStorageCache;
   private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

   public ImagePipelineFactory(ImagePipelineConfig var1) {
      this.mConfig = (ImagePipelineConfig)Preconditions.checkNotNull(var1);
      this.mThreadHandoffProducerQueue = new ThreadHandoffProducerQueue(var1.getExecutorSupplier().forLightweightBackgroundTasks());
   }

   public static AnimatedDrawableFactory buildAnimatedDrawableFactory(final SerialExecutorService var0, final ActivityManager var1, final AnimatedDrawableUtil var2, AnimatedDrawableBackendProvider var3, ScheduledExecutorService var4, final MonotonicClock var5, Resources var6) {
      return new AnimatedDrawableFactory(var3, new AnimatedDrawableCachingBackendImplProvider() {
         public AnimatedDrawableCachingBackendImpl get(AnimatedDrawableBackend var1x, AnimatedDrawableOptions var2x) {
            return new AnimatedDrawableCachingBackendImpl(var0, var1, var2, var5, var1x, var2x);
         }
      }, var2, var4, var6);
   }

   public static AnimatedImageFactory buildAnimatedImageFactory(final AnimatedDrawableUtil var0, PlatformBitmapFactory var1) {
      return new AnimatedImageFactory(new AnimatedDrawableBackendProvider() {
         public AnimatedDrawableBackend get(AnimatedImageResult var1, Rect var2) {
            return new AnimatedDrawableBackendImpl(var0, var1, var2);
         }
      }, var1);
   }

   public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory var0, PlatformDecoder var1) {
      return (PlatformBitmapFactory)(VERSION.SDK_INT >= 21?new ArtBitmapFactory(var0.getBitmapPool()):(VERSION.SDK_INT >= 11?new HoneycombBitmapFactory(new EmptyJpegGenerator(var0.getPooledByteBufferFactory()), var1):new GingerbreadBitmapFactory()));
   }

   public static PlatformDecoder buildPlatformDecoder(PoolFactory var0, boolean var1, boolean var2) {
      return (PlatformDecoder)(VERSION.SDK_INT >= 21?new ArtDecoder(var0.getBitmapPool(), var0.getFlexByteArrayPoolMaxNumThreads()):(var1 && VERSION.SDK_INT < 19?new GingerbreadPurgeableDecoder(var2):new KitKatPurgeableDecoder(var0.getFlexByteArrayPool())));
   }

   private AnimatedDrawableUtil getAnimatedDrawableUtil() {
      if(this.mAnimatedDrawableUtil == null) {
         this.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
      }

      return this.mAnimatedDrawableUtil;
   }

   private AnimatedImageFactory getAnimatedImageFactory() {
      if(this.mAnimatedImageFactory == null) {
         if(this.mConfig.getAnimatedImageFactory() != null) {
            this.mAnimatedImageFactory = this.mConfig.getAnimatedImageFactory();
         } else {
            this.mAnimatedImageFactory = buildAnimatedImageFactory(this.getAnimatedDrawableUtil(), this.getPlatformBitmapFactory());
         }
      }

      return this.mAnimatedImageFactory;
   }

   private ImageDecoder getImageDecoder() {
      if(this.mImageDecoder == null) {
         if(this.mConfig.getImageDecoder() != null) {
            this.mImageDecoder = this.mConfig.getImageDecoder();
         } else {
            this.mImageDecoder = new ImageDecoder(this.getAnimatedImageFactory(), this.getPlatformDecoder(), this.mConfig.getBitmapConfig());
         }
      }

      return this.mImageDecoder;
   }

   public static ImagePipelineFactory getInstance() {
      return (ImagePipelineFactory)Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
   }

   private BufferedDiskCache getMainBufferedDiskCache() {
      if(this.mMainBufferedDiskCache == null) {
         this.mMainBufferedDiskCache = new BufferedDiskCache(this.getMainDiskStorageCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
      }

      return this.mMainBufferedDiskCache;
   }

   private ProducerFactory getProducerFactory() {
      if(this.mProducerFactory == null) {
         this.mProducerFactory = new ProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), this.getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.isDownsampleEnabled(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.getBitmapMemoryCache(), this.getEncodedMemoryCache(), this.getMainBufferedDiskCache(), this.getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), this.getPlatformBitmapFactory(), this.mConfig.isDecodeFileDescriptorEnabled());
      }

      return this.mProducerFactory;
   }

   private ProducerSequenceFactory getProducerSequenceFactory() {
      if(this.mProducerSequenceFactory == null) {
         this.mProducerSequenceFactory = new ProducerSequenceFactory(this.getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.isDownsampleEnabled(), this.mConfig.isWebpSupportEnabled(), this.mThreadHandoffProducerQueue);
      }

      return this.mProducerSequenceFactory;
   }

   private BufferedDiskCache getSmallImageBufferedDiskCache() {
      if(this.mSmallImageBufferedDiskCache == null) {
         this.mSmallImageBufferedDiskCache = new BufferedDiskCache(this.getSmallImageDiskStorageCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
      }

      return this.mSmallImageBufferedDiskCache;
   }

   public static void initialize(Context var0) {
      initialize(ImagePipelineConfig.newBuilder(var0).build());
   }

   public static void initialize(ImagePipelineConfig var0) {
      sInstance = new ImagePipelineFactory(var0);
   }

   public static void shutDown() {
      if(sInstance != null) {
         sInstance.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
         sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
         sInstance = null;
      }

   }

   public AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider() {
      if(this.mAnimatedDrawableBackendProvider == null) {
         this.mAnimatedDrawableBackendProvider = new AnimatedDrawableBackendProvider() {
            public AnimatedDrawableBackend get(AnimatedImageResult var1, Rect var2) {
               return new AnimatedDrawableBackendImpl(ImagePipelineFactory.this.getAnimatedDrawableUtil(), var1, var2);
            }
         };
      }

      return this.mAnimatedDrawableBackendProvider;
   }

   public AnimatedDrawableFactory getAnimatedDrawableFactory() {
      if(this.mAnimatedDrawableFactory == null) {
         this.mAnimatedDrawableFactory = buildAnimatedDrawableFactory(new DefaultSerialExecutorService(this.mConfig.getExecutorSupplier().forDecode()), (ActivityManager)this.mConfig.getContext().getSystemService("activity"), this.getAnimatedDrawableUtil(), this.getAnimatedDrawableBackendProvider(), UiThreadImmediateExecutorService.getInstance(), RealtimeSinceBootClock.get(), this.mConfig.getContext().getResources());
      }

      return this.mAnimatedDrawableFactory;
   }

   public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache() {
      if(this.mBitmapCountingMemoryCache == null) {
         this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry());
      }

      return this.mBitmapCountingMemoryCache;
   }

   public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
      if(this.mBitmapMemoryCache == null) {
         this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get(this.getBitmapCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
      }

      return this.mBitmapMemoryCache;
   }

   public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache() {
      if(this.mEncodedCountingMemoryCache == null) {
         this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry());
      }

      return this.mEncodedCountingMemoryCache;
   }

   public MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
      if(this.mEncodedMemoryCache == null) {
         this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(this.getEncodedCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
      }

      return this.mEncodedMemoryCache;
   }

   public ImagePipeline getImagePipeline() {
      if(this.mImagePipeline == null) {
         this.mImagePipeline = new ImagePipeline(this.getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getIsPrefetchEnabledSupplier(), this.getBitmapMemoryCache(), this.getEncodedMemoryCache(), this.getMainBufferedDiskCache(), this.getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue);
      }

      return this.mImagePipeline;
   }

   public DiskStorageCache getMainDiskStorageCache() {
      if(this.mMainDiskStorageCache == null) {
         this.mMainDiskStorageCache = DiskCacheFactory.newDiskStorageCache(this.mConfig.getMainDiskCacheConfig());
      }

      return this.mMainDiskStorageCache;
   }

   public PlatformBitmapFactory getPlatformBitmapFactory() {
      if(this.mPlatformBitmapFactory == null) {
         this.mPlatformBitmapFactory = buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), this.getPlatformDecoder());
      }

      return this.mPlatformBitmapFactory;
   }

   public PlatformDecoder getPlatformDecoder() {
      if(this.mPlatformDecoder == null) {
         this.mPlatformDecoder = buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.isDecodeMemoryFileEnabled(), this.mConfig.isWebpSupportEnabled());
      }

      return this.mPlatformDecoder;
   }

   public DiskStorageCache getSmallImageDiskStorageCache() {
      if(this.mSmallImageDiskStorageCache == null) {
         this.mSmallImageDiskStorageCache = DiskCacheFactory.newDiskStorageCache(this.mConfig.getSmallImageDiskCacheConfig());
      }

      return this.mSmallImageDiskStorageCache;
   }
}
