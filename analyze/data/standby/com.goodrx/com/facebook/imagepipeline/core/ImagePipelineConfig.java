package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap.Config;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.core.DefaultExecutorSupplier;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class ImagePipelineConfig {
   @Nullable
   private final AnimatedImageFactory mAnimatedImageFactory;
   private final Config mBitmapConfig;
   private final Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
   private final CacheKeyFactory mCacheKeyFactory;
   private final Context mContext;
   private final boolean mDecodeFileDescriptorEnabled;
   private final boolean mDecodeMemoryFileEnabled;
   private final boolean mDownsampleEnabled;
   private final Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
   private final ExecutorSupplier mExecutorSupplier;
   private final ImageCacheStatsTracker mImageCacheStatsTracker;
   @Nullable
   private final ImageDecoder mImageDecoder;
   private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
   private final DiskCacheConfig mMainDiskCacheConfig;
   private final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
   private final NetworkFetcher mNetworkFetcher;
   @Nullable
   private final PlatformBitmapFactory mPlatformBitmapFactory;
   private final PoolFactory mPoolFactory;
   private final ProgressiveJpegConfig mProgressiveJpegConfig;
   private final Set<RequestListener> mRequestListeners;
   private final boolean mResizeAndRotateEnabledForNetwork;
   private final DiskCacheConfig mSmallImageDiskCacheConfig;
   private final boolean mWebpSupportEnabled;

   private ImagePipelineConfig(ImagePipelineConfig.Builder var1) {
      boolean var2 = true;
      super();
      this.mAnimatedImageFactory = var1.mAnimatedImageFactory;
      Object var3;
      if(var1.mBitmapMemoryCacheParamsSupplier == null) {
         var3 = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager)var1.mContext.getSystemService("activity"));
      } else {
         var3 = var1.mBitmapMemoryCacheParamsSupplier;
      }

      this.mBitmapMemoryCacheParamsSupplier = (Supplier)var3;
      Config var4;
      if(var1.mBitmapConfig == null) {
         var4 = Config.ARGB_8888;
      } else {
         var4 = var1.mBitmapConfig;
      }

      this.mBitmapConfig = var4;
      Object var5;
      if(var1.mCacheKeyFactory == null) {
         var5 = DefaultCacheKeyFactory.getInstance();
      } else {
         var5 = var1.mCacheKeyFactory;
      }

      this.mCacheKeyFactory = (CacheKeyFactory)var5;
      this.mContext = (Context)Preconditions.checkNotNull(var1.mContext);
      boolean var6;
      if(var1.mDownsampleEnabled && var1.mDecodeFileDescriptorEnabled) {
         var6 = var2;
      } else {
         var6 = false;
      }

      this.mDecodeFileDescriptorEnabled = var6;
      this.mDecodeMemoryFileEnabled = var1.mDecodeMemoryFileEnabled;
      this.mDownsampleEnabled = var1.mDownsampleEnabled;
      if(!var1.mWebpSupportEnabled || !WebpSupportStatus.sWebpLibraryPresent) {
         var2 = false;
      }

      this.mWebpSupportEnabled = var2;
      Object var7;
      if(var1.mEncodedMemoryCacheParamsSupplier == null) {
         var7 = new DefaultEncodedMemoryCacheParamsSupplier();
      } else {
         var7 = var1.mEncodedMemoryCacheParamsSupplier;
      }

      this.mEncodedMemoryCacheParamsSupplier = (Supplier)var7;
      Object var8;
      if(var1.mImageCacheStatsTracker == null) {
         var8 = NoOpImageCacheStatsTracker.getInstance();
      } else {
         var8 = var1.mImageCacheStatsTracker;
      }

      this.mImageCacheStatsTracker = (ImageCacheStatsTracker)var8;
      this.mImageDecoder = var1.mImageDecoder;
      Supplier var9;
      if(var1.mIsPrefetchEnabledSupplier == null) {
         var9 = new Supplier() {
            public Boolean get() {
               return Boolean.valueOf(true);
            }
         };
      } else {
         var9 = var1.mIsPrefetchEnabledSupplier;
      }

      this.mIsPrefetchEnabledSupplier = var9;
      DiskCacheConfig var10;
      if(var1.mMainDiskCacheConfig == null) {
         var10 = getDefaultMainDiskCacheConfig(var1.mContext);
      } else {
         var10 = var1.mMainDiskCacheConfig;
      }

      this.mMainDiskCacheConfig = var10;
      Object var11;
      if(var1.mMemoryTrimmableRegistry == null) {
         var11 = NoOpMemoryTrimmableRegistry.getInstance();
      } else {
         var11 = var1.mMemoryTrimmableRegistry;
      }

      this.mMemoryTrimmableRegistry = (MemoryTrimmableRegistry)var11;
      Object var12;
      if(var1.mNetworkFetcher == null) {
         var12 = new HttpUrlConnectionNetworkFetcher();
      } else {
         var12 = var1.mNetworkFetcher;
      }

      this.mNetworkFetcher = (NetworkFetcher)var12;
      this.mPlatformBitmapFactory = var1.mPlatformBitmapFactory;
      PoolFactory var13;
      if(var1.mPoolFactory == null) {
         var13 = new PoolFactory(PoolConfig.newBuilder().build());
      } else {
         var13 = var1.mPoolFactory;
      }

      this.mPoolFactory = var13;
      Object var14;
      if(var1.mProgressiveJpegConfig == null) {
         var14 = new SimpleProgressiveJpegConfig();
      } else {
         var14 = var1.mProgressiveJpegConfig;
      }

      this.mProgressiveJpegConfig = (ProgressiveJpegConfig)var14;
      Object var15;
      if(var1.mRequestListeners == null) {
         var15 = new HashSet();
      } else {
         var15 = var1.mRequestListeners;
      }

      this.mRequestListeners = (Set)var15;
      this.mResizeAndRotateEnabledForNetwork = var1.mResizeAndRotateEnabledForNetwork;
      DiskCacheConfig var16;
      if(var1.mSmallImageDiskCacheConfig == null) {
         var16 = this.mMainDiskCacheConfig;
      } else {
         var16 = var1.mSmallImageDiskCacheConfig;
      }

      this.mSmallImageDiskCacheConfig = var16;
      int var17 = this.mPoolFactory.getFlexByteArrayPoolMaxNumThreads();
      Object var18;
      if(var1.mExecutorSupplier == null) {
         var18 = new DefaultExecutorSupplier(var17);
      } else {
         var18 = var1.mExecutorSupplier;
      }

      this.mExecutorSupplier = (ExecutorSupplier)var18;
   }

   // $FF: synthetic method
   ImagePipelineConfig(ImagePipelineConfig.Builder var1, Object var2) {
      this(var1);
   }

   private static DiskCacheConfig getDefaultMainDiskCacheConfig(Context var0) {
      return DiskCacheConfig.newBuilder(var0).build();
   }

   public static ImagePipelineConfig.Builder newBuilder(Context var0) {
      return new ImagePipelineConfig.Builder(var0, null);
   }

   @Nullable
   public AnimatedImageFactory getAnimatedImageFactory() {
      return this.mAnimatedImageFactory;
   }

   public Config getBitmapConfig() {
      return this.mBitmapConfig;
   }

   public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
      return this.mBitmapMemoryCacheParamsSupplier;
   }

   public CacheKeyFactory getCacheKeyFactory() {
      return this.mCacheKeyFactory;
   }

   public Context getContext() {
      return this.mContext;
   }

   public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
      return this.mEncodedMemoryCacheParamsSupplier;
   }

   public ExecutorSupplier getExecutorSupplier() {
      return this.mExecutorSupplier;
   }

   public ImageCacheStatsTracker getImageCacheStatsTracker() {
      return this.mImageCacheStatsTracker;
   }

   @Nullable
   public ImageDecoder getImageDecoder() {
      return this.mImageDecoder;
   }

   public Supplier<Boolean> getIsPrefetchEnabledSupplier() {
      return this.mIsPrefetchEnabledSupplier;
   }

   public DiskCacheConfig getMainDiskCacheConfig() {
      return this.mMainDiskCacheConfig;
   }

   public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
      return this.mMemoryTrimmableRegistry;
   }

   public NetworkFetcher getNetworkFetcher() {
      return this.mNetworkFetcher;
   }

   @Nullable
   public PlatformBitmapFactory getPlatformBitmapFactory() {
      return this.mPlatformBitmapFactory;
   }

   public PoolFactory getPoolFactory() {
      return this.mPoolFactory;
   }

   public ProgressiveJpegConfig getProgressiveJpegConfig() {
      return this.mProgressiveJpegConfig;
   }

   public Set<RequestListener> getRequestListeners() {
      return Collections.unmodifiableSet(this.mRequestListeners);
   }

   public DiskCacheConfig getSmallImageDiskCacheConfig() {
      return this.mSmallImageDiskCacheConfig;
   }

   public boolean isDecodeFileDescriptorEnabled() {
      return this.mDecodeFileDescriptorEnabled;
   }

   public boolean isDecodeMemoryFileEnabled() {
      return this.mDecodeMemoryFileEnabled;
   }

   public boolean isDownsampleEnabled() {
      return this.mDownsampleEnabled;
   }

   public boolean isResizeAndRotateEnabledForNetwork() {
      return this.mResizeAndRotateEnabledForNetwork;
   }

   public boolean isWebpSupportEnabled() {
      return this.mWebpSupportEnabled;
   }

   public static class Builder {
      private AnimatedImageFactory mAnimatedImageFactory;
      private Config mBitmapConfig;
      private Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
      private CacheKeyFactory mCacheKeyFactory;
      private final Context mContext;
      private boolean mDecodeFileDescriptorEnabled;
      private boolean mDecodeMemoryFileEnabled;
      private boolean mDownsampleEnabled;
      private Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
      private ExecutorSupplier mExecutorSupplier;
      private ImageCacheStatsTracker mImageCacheStatsTracker;
      private ImageDecoder mImageDecoder;
      private Supplier<Boolean> mIsPrefetchEnabledSupplier;
      private DiskCacheConfig mMainDiskCacheConfig;
      private MemoryTrimmableRegistry mMemoryTrimmableRegistry;
      private NetworkFetcher mNetworkFetcher;
      private PlatformBitmapFactory mPlatformBitmapFactory;
      private PoolFactory mPoolFactory;
      private ProgressiveJpegConfig mProgressiveJpegConfig;
      private Set<RequestListener> mRequestListeners;
      private boolean mResizeAndRotateEnabledForNetwork;
      private DiskCacheConfig mSmallImageDiskCacheConfig;
      private boolean mWebpSupportEnabled;

      private Builder(Context var1) {
         this.mDownsampleEnabled = false;
         this.mWebpSupportEnabled = false;
         this.mDecodeFileDescriptorEnabled = this.mDownsampleEnabled;
         this.mResizeAndRotateEnabledForNetwork = true;
         this.mContext = (Context)Preconditions.checkNotNull(var1);
      }

      // $FF: synthetic method
      Builder(Context var1, Object var2) {
         this(var1);
      }

      public ImagePipelineConfig build() {
         return new ImagePipelineConfig(this, null);
      }

      public ImagePipelineConfig.Builder setAnimatedImageFactory(AnimatedImageFactory var1) {
         this.mAnimatedImageFactory = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> var1) {
         this.mBitmapMemoryCacheParamsSupplier = (Supplier)Preconditions.checkNotNull(var1);
         return this;
      }

      public ImagePipelineConfig.Builder setBitmapsConfig(Config var1) {
         this.mBitmapConfig = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setCacheKeyFactory(CacheKeyFactory var1) {
         this.mCacheKeyFactory = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setDecodeFileDescriptorEnabled(boolean var1) {
         this.mDecodeFileDescriptorEnabled = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setDecodeMemoryFileEnabled(boolean var1) {
         this.mDecodeMemoryFileEnabled = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setDownsampleEnabled(boolean var1) {
         this.mDownsampleEnabled = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> var1) {
         this.mEncodedMemoryCacheParamsSupplier = (Supplier)Preconditions.checkNotNull(var1);
         return this;
      }

      public ImagePipelineConfig.Builder setExecutorSupplier(ExecutorSupplier var1) {
         this.mExecutorSupplier = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setImageCacheStatsTracker(ImageCacheStatsTracker var1) {
         this.mImageCacheStatsTracker = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setImageDecoder(ImageDecoder var1) {
         this.mImageDecoder = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> var1) {
         this.mIsPrefetchEnabledSupplier = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setMainDiskCacheConfig(DiskCacheConfig var1) {
         this.mMainDiskCacheConfig = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry var1) {
         this.mMemoryTrimmableRegistry = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setNetworkFetcher(NetworkFetcher var1) {
         this.mNetworkFetcher = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setPlatformBitmapFactory(PlatformBitmapFactory var1) {
         this.mPlatformBitmapFactory = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setPoolFactory(PoolFactory var1) {
         this.mPoolFactory = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setProgressiveJpegConfig(ProgressiveJpegConfig var1) {
         this.mProgressiveJpegConfig = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setRequestListeners(Set<RequestListener> var1) {
         this.mRequestListeners = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setResizeAndRotateEnabledForNetwork(boolean var1) {
         this.mResizeAndRotateEnabledForNetwork = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setSmallImageDiskCacheConfig(DiskCacheConfig var1) {
         this.mSmallImageDiskCacheConfig = var1;
         return this;
      }

      public ImagePipelineConfig.Builder setWebpSupportEnabled(boolean var1) {
         this.mWebpSupportEnabled = var1;
         return this;
      }
   }
}
