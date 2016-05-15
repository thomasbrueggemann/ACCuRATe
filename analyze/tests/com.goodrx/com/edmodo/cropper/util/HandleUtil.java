package com.edmodo.cropper.util;

import android.content.Context;
import android.util.Pair;
import android.util.TypedValue;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.edmodo.cropper.cropwindow.handle.Handle;

public class HandleUtil {
   private static boolean focusCenter() {
      return !CropOverlayView.showGuidelines();
   }

   public static Pair<Float, Float> getOffset(Handle var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      if(var0 == null) {
         return null;
      } else {
         int var7 = null.$SwitchMap$com$edmodo$cropper$cropwindow$handle$Handle[var0.ordinal()];
         float var8 = 0.0F;
         float var9 = 0.0F;
         switch(var7) {
         case 1:
            var8 = var3 - var1;
            var9 = var4 - var2;
            break;
         case 2:
            var8 = var5 - var1;
            var9 = var4 - var2;
            break;
         case 3:
            var8 = var3 - var1;
            var9 = var6 - var2;
            break;
         case 4:
            var8 = var5 - var1;
            var9 = var6 - var2;
            break;
         case 5:
            var8 = var3 - var1;
            var9 = 0.0F;
            break;
         case 6:
            var9 = var4 - var2;
            var8 = 0.0F;
            break;
         case 7:
            var8 = var5 - var1;
            var9 = 0.0F;
            break;
         case 8:
            var9 = var6 - var2;
            var8 = 0.0F;
            break;
         case 9:
            float var10 = (var5 + var3) / 2.0F;
            float var11 = (var4 + var6) / 2.0F;
            var8 = var10 - var1;
            var9 = var11 - var2;
         }

         return new Pair(Float.valueOf(var8), Float.valueOf(var9));
      }
   }

   public static Handle getPressedHandle(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      Handle var8;
      if(isInCornerTargetZone(var0, var1, var2, var3, var6)) {
         var8 = Handle.TOP_LEFT;
      } else {
         if(isInCornerTargetZone(var0, var1, var4, var3, var6)) {
            return Handle.TOP_RIGHT;
         }

         if(isInCornerTargetZone(var0, var1, var2, var5, var6)) {
            return Handle.BOTTOM_LEFT;
         }

         if(isInCornerTargetZone(var0, var1, var4, var5, var6)) {
            return Handle.BOTTOM_RIGHT;
         }

         if(isInCenterTargetZone(var0, var1, var2, var3, var4, var5) && focusCenter()) {
            return Handle.CENTER;
         }

         if(isInHorizontalTargetZone(var0, var1, var2, var4, var3, var6)) {
            return Handle.TOP;
         }

         if(isInHorizontalTargetZone(var0, var1, var2, var4, var5, var6)) {
            return Handle.BOTTOM;
         }

         if(isInVerticalTargetZone(var0, var1, var2, var3, var5, var6)) {
            return Handle.LEFT;
         }

         if(isInVerticalTargetZone(var0, var1, var4, var3, var5, var6)) {
            return Handle.RIGHT;
         }

         boolean var7 = isInCenterTargetZone(var0, var1, var2, var3, var4, var5);
         var8 = null;
         if(var7) {
            boolean var9 = focusCenter();
            var8 = null;
            if(!var9) {
               return Handle.CENTER;
            }
         }
      }

      return var8;
   }

   public static float getTargetRadius(Context var0) {
      return TypedValue.applyDimension(1, 24.0F, var0.getResources().getDisplayMetrics());
   }

   private static boolean isInCenterTargetZone(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 > var2 && var0 < var4 && var1 > var3 && var1 < var5;
   }

   private static boolean isInCornerTargetZone(float var0, float var1, float var2, float var3, float var4) {
      return Math.abs(var0 - var2) <= var4 && Math.abs(var1 - var3) <= var4;
   }

   private static boolean isInHorizontalTargetZone(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 > var2 && var0 < var3 && Math.abs(var1 - var4) <= var5;
   }

   private static boolean isInVerticalTargetZone(float var0, float var1, float var2, float var3, float var4, float var5) {
      return Math.abs(var0 - var2) <= var5 && var1 > var3 && var1 < var4;
   }
}
