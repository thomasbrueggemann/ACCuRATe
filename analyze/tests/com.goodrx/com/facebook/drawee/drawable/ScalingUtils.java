package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

public class ScalingUtils {
   public static Matrix getTransform(Matrix var0, Rect var1, int var2, int var3, float var4, float var5, ScalingUtils.ScaleType var6) {
      int var7 = var1.width();
      int var8 = var1.height();
      float var9 = (float)var7 / (float)var2;
      float var10 = (float)var8 / (float)var3;
      switch(null.$SwitchMap$com$facebook$drawee$drawable$ScalingUtils$ScaleType[var6.ordinal()]) {
      case 1:
         float var39 = (float)var1.left;
         float var40 = (float)var1.top;
         var0.setScale(var9, var10);
         var0.postTranslate((float)((int)(0.5F + var39)), (float)((int)(0.5F + var40)));
         return var0;
      case 2:
         float var35 = Math.min(var9, var10);
         float var36 = (float)var1.left;
         float var37 = (float)var1.top;
         var0.setScale(var35, var35);
         var0.postTranslate((float)((int)(0.5F + var36)), (float)((int)(0.5F + var37)));
         return var0;
      case 3:
         float var31 = Math.min(var9, var10);
         float var32 = (float)var1.left + 0.5F * ((float)var7 - var31 * (float)var2);
         float var33 = (float)var1.top + 0.5F * ((float)var8 - var31 * (float)var3);
         var0.setScale(var31, var31);
         var0.postTranslate((float)((int)(0.5F + var32)), (float)((int)(0.5F + var33)));
         return var0;
      case 4:
         float var27 = Math.min(var9, var10);
         float var28 = (float)var1.left + ((float)var7 - var27 * (float)var2);
         float var29 = (float)var1.top + ((float)var8 - var27 * (float)var3);
         var0.setScale(var27, var27);
         var0.postTranslate((float)((int)(0.5F + var28)), (float)((int)(0.5F + var29)));
         return var0;
      case 5:
         float var25 = (float)var1.left + 0.5F * (float)(var7 - var2);
         float var26 = (float)var1.top + 0.5F * (float)(var8 - var3);
         var0.setTranslate((float)((int)(0.5F + var25)), (float)((int)(0.5F + var26)));
         return var0;
      case 6:
         float var21 = Math.min(Math.min(var9, var10), 1.0F);
         float var22 = (float)var1.left + 0.5F * ((float)var7 - var21 * (float)var2);
         float var23 = (float)var1.top + 0.5F * ((float)var8 - var21 * (float)var3);
         var0.setScale(var21, var21);
         var0.postTranslate((float)((int)(0.5F + var22)), (float)((int)(0.5F + var23)));
         return var0;
      case 7:
         float var17;
         float var19;
         float var18;
         if(var10 > var9) {
            var17 = var10;
            var18 = (float)var1.left + 0.5F * ((float)var7 - var10 * (float)var2);
            var19 = (float)var1.top;
         } else {
            var17 = var9;
            var18 = (float)var1.left;
            var19 = (float)var1.top + 0.5F * ((float)var8 - var9 * (float)var3);
         }

         var0.setScale(var17, var17);
         var0.postTranslate((float)((int)(0.5F + var18)), (float)((int)(0.5F + var19)));
         return var0;
      case 8:
         float var11;
         float var12;
         float var14;
         if(var10 > var9) {
            var11 = var10;
            float var16 = 0.5F * (float)var7 - var4 * var10 * (float)var2;
            var12 = (float)var1.left + Math.max(Math.min(var16, 0.0F), (float)var7 - var10 * (float)var2);
            var14 = (float)var1.top;
         } else {
            var11 = var9;
            var12 = (float)var1.left;
            float var13 = 0.5F * (float)var8 - var5 * var9 * (float)var3;
            var14 = (float)var1.top + Math.max(Math.min(var13, 0.0F), (float)var8 - var9 * (float)var3);
         }

         var0.setScale(var11, var11);
         var0.postTranslate((float)((int)(0.5F + var12)), (float)((int)(0.5F + var14)));
         return var0;
      default:
         throw new UnsupportedOperationException("Unsupported scale type: " + var6);
      }
   }

   public static enum ScaleType {
      CENTER,
      CENTER_CROP,
      CENTER_INSIDE,
      FIT_CENTER,
      FIT_END,
      FIT_START,
      FIT_XY,
      FOCUS_CROP;

      static {
         ScalingUtils.ScaleType[] var0 = new ScalingUtils.ScaleType[]{FIT_XY, FIT_START, FIT_CENTER, FIT_END, CENTER, CENTER_INSIDE, CENTER_CROP, FOCUS_CROP};
      }
   }
}
