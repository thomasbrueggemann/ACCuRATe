package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

public class DownsampleUtil {
   private static final int DEFAULT_SAMPLE_SIZE = 1;
   private static final float INTERVAL_ROUNDING = 0.33333334F;
   private static final float MAX_BITMAP_SIZE = 2048.0F;

   @VisibleForTesting
   static float determineDownsampleRatio(ImageRequest var0, EncodedImage var1) {
      Preconditions.checkArgument(EncodedImage.isMetaDataAvailable(var1));
      ResizeOptions var2 = var0.getResizeOptions();
      if(var2 != null && var2.height > 0 && var2.width > 0 && var1.getWidth() != 0 && var1.getHeight() != 0) {
         int var3 = getRotationAngle(var0, var1);
         boolean var4;
         if(var3 != 90 && var3 != 270) {
            var4 = false;
         } else {
            var4 = true;
         }

         int var5;
         if(var4) {
            var5 = var1.getHeight();
         } else {
            var5 = var1.getWidth();
         }

         int var6;
         if(var4) {
            var6 = var1.getWidth();
         } else {
            var6 = var1.getHeight();
         }

         float var7 = (float)var2.width / (float)var5;
         float var8 = (float)var2.height / (float)var6;
         float var9 = Math.max(var7, var8);
         Object[] var10 = new Object[]{Integer.valueOf(var2.width), Integer.valueOf(var2.height), Integer.valueOf(var5), Integer.valueOf(var6), Float.valueOf(var7), Float.valueOf(var8), Float.valueOf(var9), var0.getSourceUri().toString()};
         FLog.method_431("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", var10);
         return var9;
      } else {
         return 1.0F;
      }
   }

   public static int determineSampleSize(ImageRequest var0, EncodedImage var1) {
      int var3;
      if(!EncodedImage.isMetaDataAvailable(var1)) {
         var3 = 1;
      } else {
         float var2 = determineDownsampleRatio(var0, var1);
         if(var1.getImageFormat() == ImageFormat.JPEG) {
            var3 = ratioToSampleSizeJPEG(var2);
         } else {
            var3 = ratioToSampleSize(var2);
         }

         int var4 = Math.max(var1.getHeight(), var1.getWidth());

         while((float)(var4 / var3) > 2048.0F) {
            if(var1.getImageFormat() == ImageFormat.JPEG) {
               var3 *= 2;
            } else {
               ++var3;
            }
         }
      }

      return var3;
   }

   private static int getRotationAngle(ImageRequest var0, EncodedImage var1) {
      if(!var0.getAutoRotateEnabled()) {
         return 0;
      } else {
         int var2;
         boolean var3;
         label18: {
            var2 = var1.getRotationAngle();
            if(var2 != 0 && var2 != 90 && var2 != 180) {
               var3 = false;
               if(var2 != 270) {
                  break label18;
               }
            }

            var3 = true;
         }

         Preconditions.checkArgument(var3);
         return var2;
      }
   }

   @VisibleForTesting
   static int ratioToSampleSize(float var0) {
      if(var0 > 0.6666667F) {
         return 1;
      } else {
         int var1 = 2;

         while(true) {
            double var2 = 1.0D / (Math.pow((double)var1, 2.0D) - (double)var1);
            if(1.0D / (double)var1 + 0.3333333432674408D * var2 <= (double)var0) {
               return var1 - 1;
            }

            ++var1;
         }
      }
   }

   @VisibleForTesting
   static int ratioToSampleSizeJPEG(float var0) {
      int var1;
      if(var0 > 0.6666667F) {
         var1 = 1;
      } else {
         var1 = 2;

         while(true) {
            double var2 = 1.0D / (double)(var1 * 2);
            if(1.0D / (double)(var1 * 2) + 0.3333333432674408D * var2 <= (double)var0) {
               break;
            }

            var1 *= 2;
         }
      }

      return var1;
   }

   @VisibleForTesting
   static int roundToPowerOfTwo(int var0) {
      int var1;
      for(var1 = 1; var1 < var0; var1 *= 2) {
         ;
      }

      return var1;
   }
}
