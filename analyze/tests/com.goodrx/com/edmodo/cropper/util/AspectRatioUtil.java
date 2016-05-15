package com.edmodo.cropper.util;

import android.graphics.Rect;

public class AspectRatioUtil {
   public static float calculateAspectRatio(float var0, float var1, float var2, float var3) {
      return (var2 - var0) / (var3 - var1);
   }

   public static float calculateAspectRatio(Rect var0) {
      return (float)var0.width() / (float)var0.height();
   }

   public static float calculateBottom(float var0, float var1, float var2, float var3) {
      return var1 + (var2 - var0) / var3;
   }

   public static float calculateHeight(float var0, float var1, float var2) {
      return (var1 - var0) / var2;
   }

   public static float calculateLeft(float var0, float var1, float var2, float var3) {
      return var1 - var3 * (var2 - var0);
   }

   public static float calculateRight(float var0, float var1, float var2, float var3) {
      return var0 + var3 * (var2 - var1);
   }

   public static float calculateTop(float var0, float var1, float var2, float var3) {
      return var2 - (var1 - var0) / var3;
   }

   public static float calculateWidth(float var0, float var1, float var2) {
      return var2 * (var1 - var0);
   }
}
