package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.DisplayBitmapTask;
import com.nostra13.universalimageloader.core.ImageLoaderEngine;
import com.nostra13.universalimageloader.core.ImageLoadingInfo;
import com.nostra13.universalimageloader.core.LoadAndDisplayImageTask;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.utils.class_52;

final class ProcessAndDisplayImageTask implements Runnable {
   private final Bitmap bitmap;
   private final ImageLoaderEngine engine;
   private final Handler handler;
   private final ImageLoadingInfo imageLoadingInfo;

   public ProcessAndDisplayImageTask(ImageLoaderEngine var1, Bitmap var2, ImageLoadingInfo var3, Handler var4) {
      this.engine = var1;
      this.bitmap = var2;
      this.imageLoadingInfo = var3;
      this.handler = var4;
   }

   public void run() {
      Object[] var1 = new Object[]{this.imageLoadingInfo.memoryCacheKey};
      class_52.method_329("PostProcess image before displaying [%s]", var1);
      LoadAndDisplayImageTask.runTask(new DisplayBitmapTask(this.imageLoadingInfo.options.getPostProcessor().process(this.bitmap), this.imageLoadingInfo, this.engine, LoadedFrom.MEMORY_CACHE), this.imageLoadingInfo.options.isSyncLoading(), this.handler, this.engine);
   }
}
