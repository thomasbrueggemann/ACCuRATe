package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import java.util.concurrent.locks.ReentrantLock;

final class ImageLoadingInfo {
   final ImageAware imageAware;
   final ImageLoadingListener listener;
   final ReentrantLock loadFromUriLock;
   final String memoryCacheKey;
   final DisplayImageOptions options;
   final ImageLoadingProgressListener progressListener;
   final ImageSize targetSize;
   final String uri;

   public ImageLoadingInfo(String var1, ImageAware var2, ImageSize var3, String var4, DisplayImageOptions var5, ImageLoadingListener var6, ImageLoadingProgressListener var7, ReentrantLock var8) {
      this.uri = var1;
      this.imageAware = var2;
      this.targetSize = var3;
      this.options = var5;
      this.listener = var6;
      this.progressListener = var7;
      this.loadFromUriLock = var8;
      this.memoryCacheKey = var4;
   }
}
