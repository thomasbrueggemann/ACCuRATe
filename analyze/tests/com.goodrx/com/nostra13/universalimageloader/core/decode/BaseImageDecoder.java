package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.class_52;
import java.io.IOException;
import java.io.InputStream;

public class BaseImageDecoder implements ImageDecoder {
   protected final boolean loggingEnabled;

   public BaseImageDecoder(boolean var1) {
      this.loggingEnabled = var1;
   }

   private boolean canDefineExifParams(String var1, String var2) {
      return "image/jpeg".equalsIgnoreCase(var2) && ImageDownloader.Scheme.ofUri(var1) == ImageDownloader.Scheme.FILE;
   }

   protected Bitmap considerExactScaleAndOrientatiton(Bitmap var1, ImageDecodingInfo var2, int var3, boolean var4) {
      Matrix var5 = new Matrix();
      ImageScaleType var6 = var2.getImageScaleType();
      if(var6 == ImageScaleType.EXACTLY || var6 == ImageScaleType.EXACTLY_STRETCHED) {
         ImageSize var7 = new ImageSize(var1.getWidth(), var1.getHeight(), var3);
         ImageSize var8 = var2.getTargetSize();
         ViewScaleType var9 = var2.getViewScaleType();
         boolean var10;
         if(var6 == ImageScaleType.EXACTLY_STRETCHED) {
            var10 = true;
         } else {
            var10 = false;
         }

         float var11 = ImageSizeUtils.computeImageScale(var7, var8, var9, var10);
         if(Float.compare(var11, 1.0F) != 0) {
            var5.setScale(var11, var11);
            if(this.loggingEnabled) {
               Object[] var17 = new Object[]{var7, var7.scale(var11), Float.valueOf(var11), var2.getImageKey()};
               class_52.method_329("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", var17);
            }
         }
      }

      if(var4) {
         var5.postScale(-1.0F, 1.0F);
         if(this.loggingEnabled) {
            Object[] var16 = new Object[]{var2.getImageKey()};
            class_52.method_329("Flip image horizontally [%s]", var16);
         }
      }

      if(var3 != 0) {
         var5.postRotate((float)var3);
         if(this.loggingEnabled) {
            Object[] var14 = new Object[]{Integer.valueOf(var3), var2.getImageKey()};
            class_52.method_329("Rotate image on %1$d° [%2$s]", var14);
         }
      }

      Bitmap var12 = Bitmap.createBitmap(var1, 0, 0, var1.getWidth(), var1.getHeight(), var5, true);
      if(var12 != var1) {
         var1.recycle();
      }

      return var12;
   }

   public Bitmap decode(ImageDecodingInfo var1) throws IOException {
      InputStream var2 = this.getImageStream(var1);
      if(var2 == null) {
         Object[] var7 = new Object[]{var1.getImageKey()};
         class_52.method_330("No stream for image [%s]", var7);
         return null;
      } else {
         BaseImageDecoder.ImageFileInfo var4;
         Bitmap var5;
         try {
            var4 = this.defineImageSizeAndRotation(var2, var1);
            var2 = this.resetStream(var2, var1);
            var5 = BitmapFactoryInstrumentation.decodeStream(var2, (Rect)null, this.prepareDecodingOptions(var4.imageSize, var1));
         } finally {
            IoUtils.closeSilently(var2);
         }

         if(var5 == null) {
            Object[] var6 = new Object[]{var1.getImageKey()};
            class_52.method_330("Image can\'t be decoded [%s]", var6);
            return var5;
         } else {
            return this.considerExactScaleAndOrientatiton(var5, var1, var4.exif.rotation, var4.exif.flipHorizontal);
         }
      }
   }

   protected BaseImageDecoder.ExifInfo defineExifOrientation(String var1) {
      boolean var3;
      short var4;
      int var5;
      try {
         var5 = (new ExifInterface(ImageDownloader.Scheme.FILE.crop(var1))).getAttributeInt("Orientation", 1);
      } catch (IOException var6) {
         class_52.method_333("Can\'t read EXIF tags from file [%s]", new Object[]{var1});
         var3 = false;
         var4 = 0;
         return new BaseImageDecoder.ExifInfo(var4, var3);
      }

      var4 = 0;
      var3 = false;
      switch(var5) {
      case 2:
         var3 = true;
      case 1:
         var4 = 0;
         break;
      case 4:
         var3 = true;
      case 3:
         var4 = 180;
         break;
      case 5:
         var3 = true;
      case 8:
         var4 = 270;
         break;
      case 7:
         var3 = true;
      case 6:
         var4 = 90;
      }

      return new BaseImageDecoder.ExifInfo(var4, var3);
   }

   protected BaseImageDecoder.ImageFileInfo defineImageSizeAndRotation(InputStream var1, ImageDecodingInfo var2) throws IOException {
      Options var3 = new Options();
      var3.inJustDecodeBounds = true;
      BitmapFactoryInstrumentation.decodeStream(var1, (Rect)null, var3);
      String var5 = var2.getImageUri();
      BaseImageDecoder.ExifInfo var6;
      if(var2.shouldConsiderExifParams() && this.canDefineExifParams(var5, var3.outMimeType)) {
         var6 = this.defineExifOrientation(var5);
      } else {
         var6 = new BaseImageDecoder.ExifInfo();
      }

      return new BaseImageDecoder.ImageFileInfo(new ImageSize(var3.outWidth, var3.outHeight, var6.rotation), var6);
   }

   protected InputStream getImageStream(ImageDecodingInfo var1) throws IOException {
      return var1.getDownloader().getStream(var1.getImageUri(), var1.getExtraForDownloader());
   }

   protected Options prepareDecodingOptions(ImageSize var1, ImageDecodingInfo var2) {
      ImageScaleType var3 = var2.getImageScaleType();
      int var6;
      if(var3 == ImageScaleType.NONE) {
         var6 = 1;
      } else if(var3 == ImageScaleType.NONE_SAFE) {
         var6 = ImageSizeUtils.computeMinImageSampleSize(var1);
      } else {
         ImageSize var4 = var2.getTargetSize();
         boolean var5;
         if(var3 == ImageScaleType.IN_SAMPLE_POWER_OF_2) {
            var5 = true;
         } else {
            var5 = false;
         }

         var6 = ImageSizeUtils.computeImageSampleSize(var1, var4, var2.getViewScaleType(), var5);
      }

      if(var6 > 1 && this.loggingEnabled) {
         Object[] var8 = new Object[]{var1, var1.scaleDown(var6), Integer.valueOf(var6), var2.getImageKey()};
         class_52.method_329("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", var8);
      }

      Options var7 = var2.getDecodingOptions();
      var7.inSampleSize = var6;
      return var7;
   }

   protected InputStream resetStream(InputStream var1, ImageDecodingInfo var2) throws IOException {
      if(var1.markSupported()) {
         try {
            var1.reset();
            return var1;
         } catch (IOException var4) {
            ;
         }
      }

      IoUtils.closeSilently(var1);
      return this.getImageStream(var2);
   }

   protected static class ExifInfo {
      public final boolean flipHorizontal;
      public final int rotation;

      protected ExifInfo() {
         this.rotation = 0;
         this.flipHorizontal = false;
      }

      protected ExifInfo(int var1, boolean var2) {
         this.rotation = var1;
         this.flipHorizontal = var2;
      }
   }

   protected static class ImageFileInfo {
      public final BaseImageDecoder.ExifInfo exif;
      public final ImageSize imageSize;

      protected ImageFileInfo(ImageSize var1, BaseImageDecoder.ExifInfo var2) {
         this.imageSize = var1;
         this.exif = var2;
      }
   }
}
