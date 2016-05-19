package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Closeables;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.GifFormatChecker;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.io.InputStream;

public class ImageDecoder {
   private final AnimatedImageFactory mAnimatedImageFactory;
   private final Config mBitmapConfig;
   private final PlatformDecoder mPlatformDecoder;

   public ImageDecoder(AnimatedImageFactory var1, PlatformDecoder var2, Config var3) {
      this.mAnimatedImageFactory = var1;
      this.mBitmapConfig = var3;
      this.mPlatformDecoder = var2;
   }

   public CloseableImage decodeAnimatedWebp(EncodedImage var1, ImageDecodeOptions var2) {
      return this.mAnimatedImageFactory.decodeWebP(var1, var2, this.mBitmapConfig);
   }

   public CloseableImage decodeGif(EncodedImage var1, ImageDecodeOptions var2) {
      InputStream var3 = var1.getInputStream();
      if(var3 == null) {
         return null;
      } else {
         CloseableImage var6;
         try {
            if(!GifFormatChecker.isAnimated(var3)) {
               CloseableStaticBitmap var5 = this.decodeStaticImage(var1);
               return var5;
            }

            var6 = this.mAnimatedImageFactory.decodeGif(var1, var2, this.mBitmapConfig);
         } finally {
            Closeables.closeQuietly(var3);
         }

         return var6;
      }
   }

   public CloseableImage decodeImage(EncodedImage var1, int var2, QualityInfo var3, ImageDecodeOptions var4) {
      ImageFormat var5 = var1.getImageFormat();
      if(var5 == null || var5 == ImageFormat.UNKNOWN) {
         var5 = ImageFormatChecker.getImageFormat_WrapIOException(var1.getInputStream());
      }

      switch(null.$SwitchMap$com$facebook$imageformat$ImageFormat[var5.ordinal()]) {
      case 1:
         throw new IllegalArgumentException("unknown image format");
      case 2:
         return this.decodeJpeg(var1, var2, var3);
      case 3:
         return this.decodeGif(var1, var4);
      case 4:
         return this.decodeAnimatedWebp(var1, var4);
      default:
         return this.decodeStaticImage(var1);
      }
   }

   public CloseableStaticBitmap decodeJpeg(EncodedImage var1, int var2, QualityInfo var3) {
      CloseableReference var4 = this.mPlatformDecoder.decodeJPEGFromEncodedImage(var1, this.mBitmapConfig, var2);

      CloseableStaticBitmap var5;
      try {
         var5 = new CloseableStaticBitmap(var4, var3, var1.getRotationAngle());
      } finally {
         var4.close();
      }

      return var5;
   }

   public CloseableStaticBitmap decodeStaticImage(EncodedImage var1) {
      CloseableReference var2 = this.mPlatformDecoder.decodeFromEncodedImage(var1, this.mBitmapConfig);

      CloseableStaticBitmap var3;
      try {
         var3 = new CloseableStaticBitmap(var2, ImmutableQualityInfo.FULL_QUALITY, var1.getRotationAngle());
      } finally {
         var2.close();
      }

      return var3;
   }
}
