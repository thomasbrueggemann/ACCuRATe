package com.edmodo.cropper.util;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;

public class ImageViewUtil {
   public static Rect getBitmapRectCenterInside(int var0, int var1, int var2, int var3) {
      return getBitmapRectCenterInsideHelper(var0, var1, var2, var3);
   }

   public static Rect getBitmapRectCenterInside(Bitmap var0, View var1) {
      return getBitmapRectCenterInsideHelper(var0.getWidth(), var0.getHeight(), var1.getWidth(), var1.getHeight());
   }

   private static Rect getBitmapRectCenterInsideHelper(int var0, int var1, int var2, int var3) {
      double var4 = Double.POSITIVE_INFINITY;
      double var6 = Double.POSITIVE_INFINITY;
      if(var2 < var0) {
         var4 = (double)var2 / (double)var0;
      }

      if(var3 < var1) {
         var6 = (double)var3 / (double)var1;
      }

      double var8;
      double var10;
      if(var4 == Double.POSITIVE_INFINITY && var6 == Double.POSITIVE_INFINITY) {
         var8 = (double)var1;
         var10 = (double)var0;
      } else if(var4 <= var6) {
         var10 = (double)var2;
         var8 = var10 * (double)var1 / (double)var0;
      } else {
         var8 = (double)var3;
         var10 = var8 * (double)var0 / (double)var1;
      }

      int var12;
      int var13;
      if(var10 == (double)var2) {
         var12 = 0;
         var13 = (int)Math.round(((double)var3 - var8) / 2.0D);
      } else if(var8 == (double)var3) {
         var12 = (int)Math.round(((double)var2 - var10) / 2.0D);
         var13 = 0;
      } else {
         var12 = (int)Math.round(((double)var2 - var10) / 2.0D);
         var13 = (int)Math.round(((double)var3 - var8) / 2.0D);
      }

      return new Rect(var12, var13, var12 + (int)Math.ceil(var10), var13 + (int)Math.ceil(var8));
   }
}
