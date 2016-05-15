package com.nostra13.universalimageloader.core;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.nostra13.universalimageloader.utils.class_52;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultConfigurationFactory {
   public static BitmapDisplayer createBitmapDisplayer() {
      return new SimpleBitmapDisplayer();
   }

   public static DiskCache createDiskCache(Context var0, FileNameGenerator var1, long var2, int var4) {
      File var5 = createReserveDiskCacheDir(var0);
      if(var2 > 0L || var4 > 0) {
         File var6 = StorageUtils.getIndividualCacheDirectory(var0);

         try {
            LruDiskCache var7 = new LruDiskCache(var6, var5, var1, var2, var4);
            return var7;
         } catch (IOException var9) {
            class_52.method_331(var9);
         }
      }

      return new UnlimitedDiskCache(StorageUtils.getCacheDirectory(var0), var5, var1);
   }

   public static Executor createExecutor(int var0, int var1, QueueProcessingType var2) {
      boolean var3;
      if(var2 == QueueProcessingType.LIFO) {
         var3 = true;
      } else {
         var3 = false;
      }

      Object var4;
      if(var3) {
         var4 = new LIFOLinkedBlockingDeque();
      } else {
         var4 = new LinkedBlockingQueue();
      }

      BlockingQueue var5 = (BlockingQueue)var4;
      return new ThreadPoolExecutor(var0, var0, 0L, TimeUnit.MILLISECONDS, var5, createThreadFactory(var1, "uil-pool-"));
   }

   public static FileNameGenerator createFileNameGenerator() {
      return new HashCodeFileNameGenerator();
   }

   public static ImageDecoder createImageDecoder(boolean var0) {
      return new BaseImageDecoder(var0);
   }

   public static ImageDownloader createImageDownloader(Context var0) {
      return new BaseImageDownloader(var0);
   }

   public static MemoryCache createMemoryCache(Context var0, int var1) {
      if(var1 == 0) {
         ActivityManager var2 = (ActivityManager)var0.getSystemService("activity");
         int var3 = var2.getMemoryClass();
         if(hasHoneycomb() && isLargeHeap(var0)) {
            var3 = getLargeMemoryClass(var2);
         }

         var1 = 1048576 * var3 / 8;
      }

      return new LruMemoryCache(var1);
   }

   private static File createReserveDiskCacheDir(Context var0) {
      File var1 = StorageUtils.getCacheDirectory(var0, false);
      File var2 = new File(var1, "uil-images");
      if(var2.exists() || var2.mkdir()) {
         var1 = var2;
      }

      return var1;
   }

   public static Executor createTaskDistributor() {
      return Executors.newCachedThreadPool(createThreadFactory(5, "uil-pool-d-"));
   }

   private static ThreadFactory createThreadFactory(int var0, String var1) {
      return new DefaultConfigurationFactory.DefaultThreadFactory(var0, var1);
   }

   @TargetApi(11)
   private static int getLargeMemoryClass(ActivityManager var0) {
      return var0.getLargeMemoryClass();
   }

   private static boolean hasHoneycomb() {
      return VERSION.SDK_INT >= 11;
   }

   @TargetApi(11)
   private static boolean isLargeHeap(Context var0) {
      return (1048576 & var0.getApplicationInfo().flags) != 0;
   }

   private static class DefaultThreadFactory implements ThreadFactory {
      private static final AtomicInteger poolNumber = new AtomicInteger(1);
      private final ThreadGroup group;
      private final String namePrefix;
      private final AtomicInteger threadNumber = new AtomicInteger(1);
      private final int threadPriority;

      DefaultThreadFactory(int var1, String var2) {
         this.threadPriority = var1;
         this.group = Thread.currentThread().getThreadGroup();
         this.namePrefix = var2 + poolNumber.getAndIncrement() + "-thread-";
      }

      public Thread newThread(Runnable var1) {
         Thread var2 = new Thread(this.group, var1, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
         if(var2.isDaemon()) {
            var2.setDaemon(false);
         }

         var2.setPriority(this.threadPriority);
         return var2;
      }
   }
}
