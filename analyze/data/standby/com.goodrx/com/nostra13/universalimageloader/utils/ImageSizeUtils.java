package com.nostra13.universalimageloader.utils;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public final class ImageSizeUtils {
   private static ImageSize maxBitmapSize;

   static {
      int[] var0 = new int[1];
      GLES10.glGetIntegerv(3379, var0, 0);
      int var1 = Math.max(var0[0], 2048);
      maxBitmapSize = new ImageSize(var1, var1);
   }

   public static int computeImageSampleSize(ImageSize var0, ImageSize var1, ViewScaleType var2, boolean var3) {
      int var4;
      int var5;
      int var8;
      var4 = var0.getWidth();
      var5 = var0.getHeight();
      int var6 = var1.getWidth();
      int var7 = var1.getHeight();
      var8 = 1;
      label39:
      switch(null.$SwitchMap$com$nostra13$universalimageloader$core$assist$ViewScaleType[var2.ordinal()]) {
      case 1:
         if(var3) {
            int var11 = var4 / 2;
            int var12 = var5 / 2;

            while(true) {
               if(var11 / var8 <= var6 && var12 / var8 <= var7) {
                  break label39;
               }

               var8 *= 2;
            }
         } else {
            var8 = Math.max(var4 / var6, var5 / var7);
            break;
         }
      case 2:
         if(var3) {
            int var9 = var4 / 2;

            for(int var10 = var5 / 2; var9 / var8 > var6 && var10 / var8 > var7; var8 *= 2) {
               ;
            }
         } else {
            var8 = Math.min(var4 / var6, var5 / var7);
         }
      }

      if(var8 < 1) {
         var8 = 1;
      }

      return considerMaxTextureSize(var4, var5, var8, var3);
   }

   public static float computeImageScale(ImageSize var0, ImageSize var1, ViewScaleType var2, boolean var3) {
      int var4 = var0.getWidth();
      int var5 = var0.getHeight();
      int var6 = var1.getWidth();
      int var7 = var1.getHeight();
      float var8 = (float)var4 / (float)var6;
      float var9 = (float)var5 / (float)var7;
      int var10;
      int var11;
      if((var2 != ViewScaleType.FIT_INSIDE || var8 < var9) && (var2 != ViewScaleType.CROP || var8 >= var9)) {
         var10 = (int)((float)var4 / var9);
         var11 = var7;
      } else {
         var10 = var6;
         var11 = (int)((float)var5 / var8);
      }

      float var12 = 1.0F;
      if(!var3 && var10 < var4 && var11 < var5 || var3 && var10 != var4 && var11 != var5) {
         var12 = (float)var10 / (float)var4;
      }

      return var12;
   }

   public static int computeMinImageSampleSize(ImageSize var0) {
      int var1 = var0.getWidth();
      int var2 = var0.getHeight();
      int var3 = maxBitmapSize.getWidth();
      int var4 = maxBitmapSize.getHeight();
      return Math.max((int)Math.ceil((double)((float)var1 / (float)var3)), (int)Math.ceil((double)((float)var2 / (float)var4)));
   }

   private static int considerMaxTextureSize(int var0, int var1, int var2, boolean var3) {
      int var4 = maxBitmapSize.getWidth();
      int var5 = maxBitmapSize.getHeight();

      while(var0 / var2 > var4 || var1 / var2 > var5) {
         if(var3) {
            var2 *= 2;
         } else {
            ++var2;
         }
      }

      return var2;
   }

   public static ImageSize defineTargetSizeForView(ImageAware var0, ImageSize var1) {
      int var2 = var0.getWidth();
      if(var2 <= 0) {
         var2 = var1.getWidth();
      }

      int var3 = var0.getHeight();
      if(var3 <= 0) {
         var3 = var1.getHeight();
      }

      return new ImageSize(var2, var3);
   }
}
