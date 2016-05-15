package com.nostra13.universalimageloader.core.decode;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

public class ImageDecodingInfo {
   private final boolean considerExifParams;
   private final Options decodingOptions;
   private final ImageDownloader downloader;
   private final Object extraForDownloader;
   private final String imageKey;
   private final ImageScaleType imageScaleType;
   private final String imageUri;
   private final String originalImageUri;
   private final ImageSize targetSize;
   private final ViewScaleType viewScaleType;

   public ImageDecodingInfo(String var1, String var2, String var3, ImageSize var4, ViewScaleType var5, ImageDownloader var6, DisplayImageOptions var7) {
      this.imageKey = var1;
      this.imageUri = var2;
      this.originalImageUri = var3;
      this.targetSize = var4;
      this.imageScaleType = var7.getImageScaleType();
      this.viewScaleType = var5;
      this.downloader = var6;
      this.extraForDownloader = var7.getExtraForDownloader();
      this.considerExifParams = var7.isConsiderExifParams();
      this.decodingOptions = new Options();
      this.copyOptions(var7.getDecodingOptions(), this.decodingOptions);
   }

   private void copyOptions(Options var1, Options var2) {
      var2.inDensity = var1.inDensity;
      var2.inDither = var1.inDither;
      var2.inInputShareable = var1.inInputShareable;
      var2.inJustDecodeBounds = var1.inJustDecodeBounds;
      var2.inPreferredConfig = var1.inPreferredConfig;
      var2.inPurgeable = var1.inPurgeable;
      var2.inSampleSize = var1.inSampleSize;
      var2.inScaled = var1.inScaled;
      var2.inScreenDensity = var1.inScreenDensity;
      var2.inTargetDensity = var1.inTargetDensity;
      var2.inTempStorage = var1.inTempStorage;
      if(VERSION.SDK_INT >= 10) {
         this.copyOptions10(var1, var2);
      }

      if(VERSION.SDK_INT >= 11) {
         this.copyOptions11(var1, var2);
      }

   }

   @TargetApi(10)
   private void copyOptions10(Options var1, Options var2) {
      var2.inPreferQualityOverSpeed = var1.inPreferQualityOverSpeed;
   }

   @TargetApi(11)
   private void copyOptions11(Options var1, Options var2) {
      var2.inBitmap = var1.inBitmap;
      var2.inMutable = var1.inMutable;
   }

   public Options getDecodingOptions() {
      return this.decodingOptions;
   }

   public ImageDownloader getDownloader() {
      return this.downloader;
   }

   public Object getExtraForDownloader() {
      return this.extraForDownloader;
   }

   public String getImageKey() {
      return this.imageKey;
   }

   public ImageScaleType getImageScaleType() {
      return this.imageScaleType;
   }

   public String getImageUri() {
      return this.imageUri;
   }

   public ImageSize getTargetSize() {
      return this.targetSize;
   }

   public ViewScaleType getViewScaleType() {
      return this.viewScaleType;
   }

   public boolean shouldConsiderExifParams() {
      return this.considerExifParams;
   }
}
