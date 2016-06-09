package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import com.nostra13.universalimageloader.utils.class_52;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public final class ImageLoaderConfiguration {
   final boolean customExecutor;
   final boolean customExecutorForCachedImages;
   final ImageDecoder decoder;
   final DisplayImageOptions defaultDisplayImageOptions;
   final DiskCache diskCache;
   final ImageDownloader downloader;
   final int maxImageHeightForDiskCache;
   final int maxImageHeightForMemoryCache;
   final int maxImageWidthForDiskCache;
   final int maxImageWidthForMemoryCache;
   final MemoryCache memoryCache;
   final ImageDownloader networkDeniedDownloader;
   final BitmapProcessor processorForDiskCache;
   final Resources resources;
   final ImageDownloader slowNetworkDownloader;
   final Executor taskExecutor;
   final Executor taskExecutorForCachedImages;
   final QueueProcessingType tasksProcessingType;
   final int threadPoolSize;
   final int threadPriority;

   private ImageLoaderConfiguration(ImageLoaderConfiguration.Builder var1) {
      this.resources = var1.context.getResources();
      this.maxImageWidthForMemoryCache = var1.maxImageWidthForMemoryCache;
      this.maxImageHeightForMemoryCache = var1.maxImageHeightForMemoryCache;
      this.maxImageWidthForDiskCache = var1.maxImageWidthForDiskCache;
      this.maxImageHeightForDiskCache = var1.maxImageHeightForDiskCache;
      this.processorForDiskCache = var1.processorForDiskCache;
      this.taskExecutor = var1.taskExecutor;
      this.taskExecutorForCachedImages = var1.taskExecutorForCachedImages;
      this.threadPoolSize = var1.threadPoolSize;
      this.threadPriority = var1.threadPriority;
      this.tasksProcessingType = var1.tasksProcessingType;
      this.diskCache = var1.diskCache;
      this.memoryCache = var1.memoryCache;
      this.defaultDisplayImageOptions = var1.defaultDisplayImageOptions;
      this.downloader = var1.downloader;
      this.decoder = var1.decoder;
      this.customExecutor = var1.customExecutor;
      this.customExecutorForCachedImages = var1.customExecutorForCachedImages;
      this.networkDeniedDownloader = new ImageLoaderConfiguration.NetworkDeniedImageDownloader(this.downloader);
      this.slowNetworkDownloader = new ImageLoaderConfiguration.SlowNetworkImageDownloader(this.downloader);
      class_52.writeDebugLogs(var1.writeLogs);
   }

   // $FF: synthetic method
   ImageLoaderConfiguration(ImageLoaderConfiguration.Builder var1, Object var2) {
      this(var1);
   }

   ImageSize getMaxImageSize() {
      DisplayMetrics var1 = this.resources.getDisplayMetrics();
      int var2 = this.maxImageWidthForMemoryCache;
      if(var2 <= 0) {
         var2 = var1.widthPixels;
      }

      int var3 = this.maxImageHeightForMemoryCache;
      if(var3 <= 0) {
         var3 = var1.heightPixels;
      }

      return new ImageSize(var2, var3);
   }

   public static class Builder {
      public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE;
      private Context context;
      private boolean customExecutor = false;
      private boolean customExecutorForCachedImages = false;
      private ImageDecoder decoder;
      private DisplayImageOptions defaultDisplayImageOptions;
      private boolean denyCacheImageMultipleSizesInMemory = false;
      private DiskCache diskCache;
      private int diskCacheFileCount;
      private FileNameGenerator diskCacheFileNameGenerator;
      private long diskCacheSize;
      private ImageDownloader downloader;
      private int maxImageHeightForDiskCache = 0;
      private int maxImageHeightForMemoryCache = 0;
      private int maxImageWidthForDiskCache = 0;
      private int maxImageWidthForMemoryCache = 0;
      private MemoryCache memoryCache;
      private int memoryCacheSize;
      private BitmapProcessor processorForDiskCache = null;
      private Executor taskExecutor = null;
      private Executor taskExecutorForCachedImages = null;
      private QueueProcessingType tasksProcessingType;
      private int threadPoolSize = 3;
      private int threadPriority = 3;
      private boolean writeLogs;

      static {
         DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
      }

      public Builder(Context var1) {
         this.tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
         this.memoryCacheSize = 0;
         this.diskCacheSize = 0L;
         this.diskCacheFileCount = 0;
         this.memoryCache = null;
         this.diskCache = null;
         this.diskCacheFileNameGenerator = null;
         this.downloader = null;
         this.defaultDisplayImageOptions = null;
         this.writeLogs = false;
         this.context = var1.getApplicationContext();
      }

      private void initEmptyFieldsWithDefaultValues() {
         if(this.taskExecutor == null) {
            this.taskExecutor = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
         } else {
            this.customExecutor = true;
         }

         if(this.taskExecutorForCachedImages == null) {
            this.taskExecutorForCachedImages = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
         } else {
            this.customExecutorForCachedImages = true;
         }

         if(this.diskCache == null) {
            if(this.diskCacheFileNameGenerator == null) {
               this.diskCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
            }

            this.diskCache = DefaultConfigurationFactory.createDiskCache(this.context, this.diskCacheFileNameGenerator, this.diskCacheSize, this.diskCacheFileCount);
         }

         if(this.memoryCache == null) {
            this.memoryCache = DefaultConfigurationFactory.createMemoryCache(this.context, this.memoryCacheSize);
         }

         if(this.denyCacheImageMultipleSizesInMemory) {
            this.memoryCache = new FuzzyKeyMemoryCache(this.memoryCache, MemoryCacheUtils.createFuzzyKeyComparator());
         }

         if(this.downloader == null) {
            this.downloader = DefaultConfigurationFactory.createImageDownloader(this.context);
         }

         if(this.decoder == null) {
            this.decoder = DefaultConfigurationFactory.createImageDecoder(this.writeLogs);
         }

         if(this.defaultDisplayImageOptions == null) {
            this.defaultDisplayImageOptions = DisplayImageOptions.createSimple();
         }

      }

      public ImageLoaderConfiguration build() {
         this.initEmptyFieldsWithDefaultValues();
         return new ImageLoaderConfiguration(this, null);
      }

      public ImageLoaderConfiguration.Builder defaultDisplayImageOptions(DisplayImageOptions var1) {
         this.defaultDisplayImageOptions = var1;
         return this;
      }

      public ImageLoaderConfiguration.Builder diskCacheSize(int var1) {
         if(var1 <= 0) {
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
         } else {
            if(this.diskCache != null) {
               class_52.method_333("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
            }

            this.diskCacheSize = (long)var1;
            return this;
         }
      }
   }

   private static class NetworkDeniedImageDownloader implements ImageDownloader {
      private final ImageDownloader wrappedDownloader;

      public NetworkDeniedImageDownloader(ImageDownloader var1) {
         this.wrappedDownloader = var1;
      }

      public InputStream getStream(String var1, Object var2) throws IOException {
         switch(null.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(var1).ordinal()]) {
         case 1:
         case 2:
            throw new IllegalStateException();
         default:
            return this.wrappedDownloader.getStream(var1, var2);
         }
      }
   }

   private static class SlowNetworkImageDownloader implements ImageDownloader {
      private final ImageDownloader wrappedDownloader;

      public SlowNetworkImageDownloader(ImageDownloader var1) {
         this.wrappedDownloader = var1;
      }

      public InputStream getStream(String var1, Object var2) throws IOException {
         InputStream var3 = this.wrappedDownloader.getStream(var1, var2);
         switch(null.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(var1).ordinal()]) {
         case 1:
         case 2:
            return new FlushedInputStream(var3);
         default:
            return var3;
         }
      }
   }
}
