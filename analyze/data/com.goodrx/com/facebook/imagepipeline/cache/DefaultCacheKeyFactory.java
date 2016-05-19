package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;

public class DefaultCacheKeyFactory implements CacheKeyFactory {
   private static DefaultCacheKeyFactory sInstance = null;

   public static DefaultCacheKeyFactory getInstance() {
      synchronized(DefaultCacheKeyFactory.class){}

      DefaultCacheKeyFactory var1;
      try {
         if(sInstance == null) {
            sInstance = new DefaultCacheKeyFactory();
         }

         var1 = sInstance;
      } finally {
         ;
      }

      return var1;
   }

   public CacheKey getBitmapCacheKey(ImageRequest var1) {
      return new BitmapMemoryCacheKey(this.getCacheKeySourceUri(var1.getSourceUri()).toString(), var1.getResizeOptions(), var1.getAutoRotateEnabled(), var1.getImageDecodeOptions(), (CacheKey)null, (String)null);
   }

   public Uri getCacheKeySourceUri(Uri var1) {
      return var1;
   }

   public CacheKey getEncodedCacheKey(ImageRequest var1) {
      return new SimpleCacheKey(this.getCacheKeySourceUri(var1.getSourceUri()).toString());
   }

   public CacheKey getPostprocessedBitmapCacheKey(ImageRequest var1) {
      Postprocessor var2 = var1.getPostprocessor();
      CacheKey var3;
      String var4;
      if(var2 != null) {
         var3 = var2.getPostprocessorCacheKey();
         var4 = var2.getClass().getName();
      } else {
         var3 = null;
         var4 = null;
      }

      return new BitmapMemoryCacheKey(this.getCacheKeySourceUri(var1.getSourceUri()).toString(), var1.getResizeOptions(), var1.getAutoRotateEnabled(), var1.getImageDecodeOptions(), var3, var4);
   }
}
