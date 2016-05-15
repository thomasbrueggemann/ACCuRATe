package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoaderEngine;
import com.nostra13.universalimageloader.core.ImageLoadingInfo;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.class_52;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

final class LoadAndDisplayImageTask implements IoUtils.CopyListener, Runnable {
   private final ImageLoaderConfiguration configuration;
   private final ImageDecoder decoder;
   private final ImageDownloader downloader;
   private final ImageLoaderEngine engine;
   private final Handler handler;
   final ImageAware imageAware;
   private final ImageLoadingInfo imageLoadingInfo;
   final ImageLoadingListener listener;
   private LoadedFrom loadedFrom;
   private final String memoryCacheKey;
   private final ImageDownloader networkDeniedDownloader;
   final DisplayImageOptions options;
   final ImageLoadingProgressListener progressListener;
   private final ImageDownloader slowNetworkDownloader;
   private final boolean syncLoading;
   private final ImageSize targetSize;
   final String uri;

   public LoadAndDisplayImageTask(ImageLoaderEngine var1, ImageLoadingInfo var2, Handler var3) {
      this.loadedFrom = LoadedFrom.NETWORK;
      this.engine = var1;
      this.imageLoadingInfo = var2;
      this.handler = var3;
      this.configuration = var1.configuration;
      this.downloader = this.configuration.downloader;
      this.networkDeniedDownloader = this.configuration.networkDeniedDownloader;
      this.slowNetworkDownloader = this.configuration.slowNetworkDownloader;
      this.decoder = this.configuration.decoder;
      this.uri = var2.uri;
      this.memoryCacheKey = var2.memoryCacheKey;
      this.imageAware = var2.imageAware;
      this.targetSize = var2.targetSize;
      this.options = var2.options;
      this.listener = var2.listener;
      this.progressListener = var2.progressListener;
      this.syncLoading = this.options.isSyncLoading();
   }

   private void checkTaskInterrupted() throws LoadAndDisplayImageTask.TaskCancelledException {
      if(this.isTaskInterrupted()) {
         throw new LoadAndDisplayImageTask.TaskCancelledException();
      }
   }

   private void checkTaskNotActual() throws LoadAndDisplayImageTask.TaskCancelledException {
      this.checkViewCollected();
      this.checkViewReused();
   }

   private void checkViewCollected() throws LoadAndDisplayImageTask.TaskCancelledException {
      if(this.isViewCollected()) {
         throw new LoadAndDisplayImageTask.TaskCancelledException();
      }
   }

   private void checkViewReused() throws LoadAndDisplayImageTask.TaskCancelledException {
      if(this.isViewReused()) {
         throw new LoadAndDisplayImageTask.TaskCancelledException();
      }
   }

   private Bitmap decodeImage(String var1) throws IOException {
      ViewScaleType var2 = this.imageAware.getScaleType();
      ImageDecodingInfo var3 = new ImageDecodingInfo(this.memoryCacheKey, var1, this.uri, this.targetSize, var2, this.getDownloader(), this.options);
      return this.decoder.decode(var3);
   }

   private boolean delayIfNeed() {
      if(this.options.shouldDelayBeforeLoading()) {
         Object[] var1 = new Object[]{Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey};
         class_52.method_329("Delay %d ms before loading...  [%s]", var1);

         try {
            Thread.sleep((long)this.options.getDelayBeforeLoading());
         } catch (InterruptedException var4) {
            Object[] var3 = new Object[]{this.memoryCacheKey};
            class_52.method_330("Task was interrupted [%s]", var3);
            return true;
         }

         return this.isTaskNotActual();
      } else {
         return false;
      }
   }

   private boolean downloadImage() throws IOException {
      InputStream var1 = this.getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
      if(var1 == null) {
         Object[] var4 = new Object[]{this.memoryCacheKey};
         class_52.method_330("No stream for image [%s]", var4);
         return false;
      } else {
         boolean var3;
         try {
            var3 = this.configuration.diskCache.save(this.uri, var1, this);
         } finally {
            IoUtils.closeSilently(var1);
         }

         return var3;
      }
   }

   private void fireCancelEvent() {
      if(!this.syncLoading && !this.isTaskInterrupted()) {
         runTask(new Runnable() {
            public void run() {
               LoadAndDisplayImageTask.this.listener.onLoadingCancelled(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView());
            }
         }, false, this.handler, this.engine);
      }
   }

   private void fireFailEvent(final FailReason.FailType var1, final Throwable var2) {
      if(!this.syncLoading && !this.isTaskInterrupted() && !this.isTaskNotActual()) {
         runTask(new Runnable() {
            public void run() {
               if(LoadAndDisplayImageTask.this.options.shouldShowImageOnFail()) {
                  LoadAndDisplayImageTask.this.imageAware.setImageDrawable(LoadAndDisplayImageTask.this.options.getImageOnFail(LoadAndDisplayImageTask.this.configuration.resources));
               }

               LoadAndDisplayImageTask.this.listener.onLoadingFailed(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView(), new FailReason(var1, var2));
            }
         }, false, this.handler, this.engine);
      }
   }

   private boolean fireProgressEvent(final int var1, final int var2) {
      if(!this.isTaskInterrupted() && !this.isTaskNotActual()) {
         if(this.progressListener != null) {
            runTask(new Runnable() {
               public void run() {
                  LoadAndDisplayImageTask.this.progressListener.onProgressUpdate(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView(), var1, var2);
               }
            }, false, this.handler, this.engine);
         }

         return true;
      } else {
         return false;
      }
   }

   private ImageDownloader getDownloader() {
      return this.engine.isNetworkDenied()?this.networkDeniedDownloader:(this.engine.isSlowNetwork()?this.slowNetworkDownloader:this.downloader);
   }

   private boolean isTaskInterrupted() {
      if(Thread.interrupted()) {
         Object[] var1 = new Object[]{this.memoryCacheKey};
         class_52.method_329("Task was interrupted [%s]", var1);
         return true;
      } else {
         return false;
      }
   }

   private boolean isTaskNotActual() {
      return this.isViewCollected() || this.isViewReused();
   }

   private boolean isViewCollected() {
      if(this.imageAware.isCollected()) {
         Object[] var1 = new Object[]{this.memoryCacheKey};
         class_52.method_329("ImageAware was collected by GC. Task is cancelled. [%s]", var1);
         return true;
      } else {
         return false;
      }
   }

   private boolean isViewReused() {
      String var1 = this.engine.getLoadingUriForView(this.imageAware);
      boolean var2;
      if(!this.memoryCacheKey.equals(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(var2) {
         Object[] var3 = new Object[]{this.memoryCacheKey};
         class_52.method_329("ImageAware is reused for another image. Task is cancelled. [%s]", var3);
         return true;
      } else {
         return false;
      }
   }

   private boolean resizeAndSaveImage(int var1, int var2) throws IOException {
      File var3 = this.configuration.diskCache.get(this.uri);
      boolean var4 = false;
      if(var3 != null) {
         boolean var5 = var3.exists();
         var4 = false;
         if(var5) {
            ImageSize var6 = new ImageSize(var1, var2);
            DisplayImageOptions var7 = (new DisplayImageOptions.Builder()).cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
            ImageDecodingInfo var8 = new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(var3.getAbsolutePath()), this.uri, var6, ViewScaleType.FIT_INSIDE, this.getDownloader(), var7);
            Bitmap var9 = this.decoder.decode(var8);
            if(var9 != null && this.configuration.processorForDiskCache != null) {
               Object[] var10 = new Object[]{this.memoryCacheKey};
               class_52.method_329("Process image before cache on disk [%s]", var10);
               var9 = this.configuration.processorForDiskCache.process(var9);
               if(var9 == null) {
                  Object[] var11 = new Object[]{this.memoryCacheKey};
                  class_52.method_330("Bitmap processor for disk cache returned null [%s]", var11);
               }
            }

            var4 = false;
            if(var9 != null) {
               var4 = this.configuration.diskCache.save(this.uri, var9);
               var9.recycle();
            }
         }
      }

      return var4;
   }

   static void runTask(Runnable var0, boolean var1, Handler var2, ImageLoaderEngine var3) {
      if(var1) {
         var0.run();
      } else if(var2 == null) {
         var3.fireCallback(var0);
      } else {
         var2.post(var0);
      }
   }

   private boolean tryCacheImageOnDisk() throws LoadAndDisplayImageTask.TaskCancelledException {
      // $FF: Couldn't be decompiled
   }

   private Bitmap tryLoadBitmap() throws LoadAndDisplayImageTask.TaskCancelledException {
      // $FF: Couldn't be decompiled
   }

   private boolean waitIfPaused() {
      // $FF: Couldn't be decompiled
   }

   String getLoadingUri() {
      return this.uri;
   }

   public boolean onBytesCopied(int var1, int var2) {
      return this.syncLoading || this.fireProgressEvent(var1, var2);
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }

   class TaskCancelledException extends Exception {
   }
}
