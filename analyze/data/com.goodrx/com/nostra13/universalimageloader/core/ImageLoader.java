package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoaderEngine;
import com.nostra13.universalimageloader.core.ImageLoadingInfo;
import com.nostra13.universalimageloader.core.LoadAndDisplayImageTask;
import com.nostra13.universalimageloader.core.ProcessAndDisplayImageTask;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.imageaware.NonViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import com.nostra13.universalimageloader.utils.class_52;
import java.util.concurrent.locks.ReentrantLock;

public class ImageLoader {
   public static final String TAG = ImageLoader.class.getSimpleName();
   private static volatile ImageLoader instance;
   private ImageLoaderConfiguration configuration;
   private ImageLoadingListener defaultListener = new SimpleImageLoadingListener();
   private ImageLoaderEngine engine;

   private void checkConfiguration() {
      if(this.configuration == null) {
         throw new IllegalStateException("ImageLoader must be init with configuration before using");
      }
   }

   private static Handler defineHandler(DisplayImageOptions var0) {
      Handler var1 = var0.getHandler();
      if(var0.isSyncLoading()) {
         var1 = null;
      } else if(var1 == null && Looper.myLooper() == Looper.getMainLooper()) {
         return new Handler();
      }

      return var1;
   }

   public static ImageLoader getInstance() {
      // $FF: Couldn't be decompiled
   }

   public void clearDiskCache() {
      this.checkConfiguration();
      this.configuration.diskCache.clear();
   }

   public void clearMemoryCache() {
      this.checkConfiguration();
      this.configuration.memoryCache.clear();
   }

   public void displayImage(String var1, ImageView var2) {
      this.displayImage(var1, new ImageViewAware(var2), (DisplayImageOptions)null, (ImageLoadingListener)null, (ImageLoadingProgressListener)null);
   }

   public void displayImage(String var1, ImageAware var2, DisplayImageOptions var3, ImageSize var4, ImageLoadingListener var5, ImageLoadingProgressListener var6) {
      this.checkConfiguration();
      if(var2 == null) {
         throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
      } else {
         if(var5 == null) {
            var5 = this.defaultListener;
         }

         if(var3 == null) {
            var3 = this.configuration.defaultDisplayImageOptions;
         }

         if(TextUtils.isEmpty(var1)) {
            this.engine.cancelDisplayTaskFor(var2);
            View var19 = var2.getWrappedView();
            var5.onLoadingStarted(var1, var19);
            if(var3.shouldShowImageForEmptyUri()) {
               var2.setImageDrawable(var3.getImageForEmptyUri(this.configuration.resources));
            } else {
               var2.setImageDrawable((Drawable)null);
            }

            View var21 = var2.getWrappedView();
            var5.onLoadingComplete(var1, var21, (Bitmap)null);
         } else {
            if(var4 == null) {
               var4 = ImageSizeUtils.defineTargetSizeForView(var2, this.configuration.getMaxImageSize());
            }

            String var7 = MemoryCacheUtils.generateKey(var1, var4);
            this.engine.prepareDisplayTaskFor(var2, var7);
            View var8 = var2.getWrappedView();
            var5.onLoadingStarted(var1, var8);
            Bitmap var9 = this.configuration.memoryCache.get(var7);
            if(var9 != null && !var9.isRecycled()) {
               class_52.method_329("Load image from memory cache [%s]", new Object[]{var7});
               if(var3.shouldPostProcess()) {
                  ReentrantLock var16 = this.engine.getLockForUri(var1);
                  ImageLoadingInfo var17 = new ImageLoadingInfo(var1, var2, var4, var7, var3, var5, var6, var16);
                  ProcessAndDisplayImageTask var18 = new ProcessAndDisplayImageTask(this.engine, var9, var17, defineHandler(var3));
                  if(var3.isSyncLoading()) {
                     var18.run();
                  } else {
                     this.engine.submit(var18);
                  }
               } else {
                  var3.getDisplayer().display(var9, var2, LoadedFrom.MEMORY_CACHE);
                  View var15 = var2.getWrappedView();
                  var5.onLoadingComplete(var1, var15, var9);
               }
            } else {
               if(var3.shouldShowImageOnLoading()) {
                  var2.setImageDrawable(var3.getImageOnLoading(this.configuration.resources));
               } else if(var3.isResetViewBeforeLoading()) {
                  var2.setImageDrawable((Drawable)null);
               }

               ReentrantLock var11 = this.engine.getLockForUri(var1);
               ImageLoadingInfo var12 = new ImageLoadingInfo(var1, var2, var4, var7, var3, var5, var6, var11);
               LoadAndDisplayImageTask var13 = new LoadAndDisplayImageTask(this.engine, var12, defineHandler(var3));
               if(var3.isSyncLoading()) {
                  var13.run();
               } else {
                  this.engine.submit(var13);
               }
            }
         }
      }
   }

   public void displayImage(String var1, ImageAware var2, DisplayImageOptions var3, ImageLoadingListener var4, ImageLoadingProgressListener var5) {
      this.displayImage(var1, var2, var3, (ImageSize)null, var4, var5);
   }

   public void init(ImageLoaderConfiguration param1) {
      // $FF: Couldn't be decompiled
   }

   public void loadImage(String var1, ImageSize var2, DisplayImageOptions var3, ImageLoadingListener var4) {
      this.loadImage(var1, var2, var3, var4, (ImageLoadingProgressListener)null);
   }

   public void loadImage(String var1, ImageSize var2, DisplayImageOptions var3, ImageLoadingListener var4, ImageLoadingProgressListener var5) {
      this.checkConfiguration();
      if(var2 == null) {
         var2 = this.configuration.getMaxImageSize();
      }

      if(var3 == null) {
         var3 = this.configuration.defaultDisplayImageOptions;
      }

      this.displayImage(var1, new NonViewAware(var1, var2, ViewScaleType.CROP), var3, var4, var5);
   }

   public void loadImage(String var1, ImageLoadingListener var2) {
      this.loadImage(var1, (ImageSize)null, (DisplayImageOptions)null, var2, (ImageLoadingProgressListener)null);
   }

   public Bitmap loadImageSync(String var1) {
      return this.loadImageSync(var1, (ImageSize)null, (DisplayImageOptions)null);
   }

   public Bitmap loadImageSync(String var1, ImageSize var2, DisplayImageOptions var3) {
      if(var3 == null) {
         var3 = this.configuration.defaultDisplayImageOptions;
      }

      DisplayImageOptions var4 = (new DisplayImageOptions.Builder()).cloneFrom(var3).syncLoading(true).build();
      ImageLoader.SyncImageLoadingListener var5 = new ImageLoader.SyncImageLoadingListener();
      this.loadImage(var1, var2, var4, var5);
      return var5.getLoadedBitmap();
   }

   private static class SyncImageLoadingListener extends SimpleImageLoadingListener {
      private Bitmap loadedImage;

      private SyncImageLoadingListener() {
      }

      // $FF: synthetic method
      SyncImageLoadingListener(Object var1) {
         this();
      }

      public Bitmap getLoadedBitmap() {
         return this.loadedImage;
      }

      public void onLoadingComplete(String var1, View var2, Bitmap var3) {
         this.loadedImage = var3;
      }
   }
}
