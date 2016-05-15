package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.LoadAndDisplayImageTask;
import com.nostra13.universalimageloader.core.ProcessAndDisplayImageTask;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ImageLoaderEngine {
   private final Map<Integer, String> cacheKeysForImageAwares = Collections.synchronizedMap(new HashMap());
   final ImageLoaderConfiguration configuration;
   private final AtomicBoolean networkDenied = new AtomicBoolean(false);
   private final Object pauseLock = new Object();
   private final AtomicBoolean paused = new AtomicBoolean(false);
   private final AtomicBoolean slowNetwork = new AtomicBoolean(false);
   private Executor taskDistributor;
   private Executor taskExecutor;
   private Executor taskExecutorForCachedImages;
   private final Map<String, ReentrantLock> uriLocks = new WeakHashMap();

   ImageLoaderEngine(ImageLoaderConfiguration var1) {
      this.configuration = var1;
      this.taskExecutor = var1.taskExecutor;
      this.taskExecutorForCachedImages = var1.taskExecutorForCachedImages;
      this.taskDistributor = DefaultConfigurationFactory.createTaskDistributor();
   }

   private Executor createTaskExecutor() {
      return DefaultConfigurationFactory.createExecutor(this.configuration.threadPoolSize, this.configuration.threadPriority, this.configuration.tasksProcessingType);
   }

   private void initExecutorsIfNeed() {
      if(!this.configuration.customExecutor && ((ExecutorService)this.taskExecutor).isShutdown()) {
         this.taskExecutor = this.createTaskExecutor();
      }

      if(!this.configuration.customExecutorForCachedImages && ((ExecutorService)this.taskExecutorForCachedImages).isShutdown()) {
         this.taskExecutorForCachedImages = this.createTaskExecutor();
      }

   }

   void cancelDisplayTaskFor(ImageAware var1) {
      this.cacheKeysForImageAwares.remove(Integer.valueOf(var1.getId()));
   }

   void fireCallback(Runnable var1) {
      this.taskDistributor.execute(var1);
   }

   String getLoadingUriForView(ImageAware var1) {
      return (String)this.cacheKeysForImageAwares.get(Integer.valueOf(var1.getId()));
   }

   ReentrantLock getLockForUri(String var1) {
      ReentrantLock var2 = (ReentrantLock)this.uriLocks.get(var1);
      if(var2 == null) {
         var2 = new ReentrantLock();
         this.uriLocks.put(var1, var2);
      }

      return var2;
   }

   AtomicBoolean getPause() {
      return this.paused;
   }

   Object getPauseLock() {
      return this.pauseLock;
   }

   boolean isNetworkDenied() {
      return this.networkDenied.get();
   }

   boolean isSlowNetwork() {
      return this.slowNetwork.get();
   }

   void prepareDisplayTaskFor(ImageAware var1, String var2) {
      this.cacheKeysForImageAwares.put(Integer.valueOf(var1.getId()), var2);
   }

   void submit(final LoadAndDisplayImageTask var1) {
      this.taskDistributor.execute(new Runnable() {
         public void run() {
            File var1x = ImageLoaderEngine.this.configuration.diskCache.get(var1.getLoadingUri());
            boolean var2;
            if(var1x != null && var1x.exists()) {
               var2 = true;
            } else {
               var2 = false;
            }

            ImageLoaderEngine.this.initExecutorsIfNeed();
            if(var2) {
               ImageLoaderEngine.this.taskExecutorForCachedImages.execute(var1);
            } else {
               ImageLoaderEngine.this.taskExecutor.execute(var1);
            }
         }
      });
   }

   void submit(ProcessAndDisplayImageTask var1) {
      this.initExecutorsIfNeed();
      this.taskExecutorForCachedImages.execute(var1);
   }
}
