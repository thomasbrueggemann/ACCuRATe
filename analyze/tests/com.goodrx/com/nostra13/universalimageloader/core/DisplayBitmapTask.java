package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.ImageLoaderEngine;
import com.nostra13.universalimageloader.core.ImageLoadingInfo;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.utils.class_52;

final class DisplayBitmapTask implements Runnable {
   private final Bitmap bitmap;
   private final BitmapDisplayer displayer;
   private final ImageLoaderEngine engine;
   private final ImageAware imageAware;
   private final String imageUri;
   private final ImageLoadingListener listener;
   private final LoadedFrom loadedFrom;
   private final String memoryCacheKey;

   public DisplayBitmapTask(Bitmap var1, ImageLoadingInfo var2, ImageLoaderEngine var3, LoadedFrom var4) {
      this.bitmap = var1;
      this.imageUri = var2.uri;
      this.imageAware = var2.imageAware;
      this.memoryCacheKey = var2.memoryCacheKey;
      this.displayer = var2.options.getDisplayer();
      this.listener = var2.listener;
      this.engine = var3;
      this.loadedFrom = var4;
   }

   private boolean isViewWasReused() {
      String var1 = this.engine.getLoadingUriForView(this.imageAware);
      return !this.memoryCacheKey.equals(var1);
   }

   public void run() {
      if(this.imageAware.isCollected()) {
         Object[] var3 = new Object[]{this.memoryCacheKey};
         class_52.method_329("ImageAware was collected by GC. Task is cancelled. [%s]", var3);
         this.listener.onLoadingCancelled(this.imageUri, this.imageAware.getWrappedView());
      } else if(this.isViewWasReused()) {
         Object[] var2 = new Object[]{this.memoryCacheKey};
         class_52.method_329("ImageAware is reused for another image. Task is cancelled. [%s]", var2);
         this.listener.onLoadingCancelled(this.imageUri, this.imageAware.getWrappedView());
      } else {
         Object[] var1 = new Object[]{this.loadedFrom, this.memoryCacheKey};
         class_52.method_329("Display image in ImageAware (loaded from %1$s) [%2$s]", var1);
         this.displayer.display(this.bitmap, this.imageAware, this.loadedFrom);
         this.engine.cancelDisplayTaskFor(this.imageAware);
         this.listener.onLoadingComplete(this.imageUri, this.imageAware.getWrappedView(), this.bitmap);
      }
   }
}
