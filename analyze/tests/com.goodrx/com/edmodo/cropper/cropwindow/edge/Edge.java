package com.edmodo.cropper.cropwindow.edge;

import android.graphics.Rect;
import com.edmodo.cropper.util.AspectRatioUtil;

public enum Edge {
   BOTTOM,
   LEFT,
   RIGHT,
   TOP;

   private float mCoordinate;

   static {
      Edge[] var0 = new Edge[]{LEFT, TOP, RIGHT, BOTTOM};
   }

   private static float adjustBottom(float var0, Rect var1, float var2, float var3) {
      if((float)var1.bottom - var0 < var2) {
         return (float)var1.bottom;
      } else {
         float var4 = Float.NEGATIVE_INFINITY;
         float var5 = Float.NEGATIVE_INFINITY;
         if(var0 <= 40.0F + TOP.getCoordinate()) {
            var4 = 40.0F + TOP.getCoordinate();
         }

         if(var3 * (var0 - TOP.getCoordinate()) <= 40.0F) {
            var5 = TOP.getCoordinate() + 40.0F / var3;
         }

         return Math.max(var0, Math.max(var5, var4));
      }
   }

   private static float adjustLeft(float var0, Rect var1, float var2, float var3) {
      if(var0 - (float)var1.left < var2) {
         return (float)var1.left;
      } else {
         float var4 = Float.POSITIVE_INFINITY;
         float var5 = Float.POSITIVE_INFINITY;
         if(var0 >= RIGHT.getCoordinate() - 40.0F) {
            var4 = RIGHT.getCoordinate() - 40.0F;
         }

         if((RIGHT.getCoordinate() - var0) / var3 <= 40.0F) {
            var5 = RIGHT.getCoordinate() - 40.0F * var3;
         }

         return Math.min(var0, Math.min(var4, var5));
      }
   }

   private static float adjustRight(float var0, Rect var1, float var2, float var3) {
      if((float)var1.right - var0 < var2) {
         return (float)var1.right;
      } else {
         float var4 = Float.NEGATIVE_INFINITY;
         float var5 = Float.NEGATIVE_INFINITY;
         if(var0 <= 40.0F + LEFT.getCoordinate()) {
            var4 = 40.0F + LEFT.getCoordinate();
         }

         if((var0 - LEFT.getCoordinate()) / var3 <= 40.0F) {
            var5 = LEFT.getCoordinate() + 40.0F * var3;
         }

         return Math.max(var0, Math.max(var4, var5));
      }
   }

   private static float adjustTop(float var0, Rect var1, float var2, float var3) {
      if(var0 - (float)var1.top < var2) {
         return (float)var1.top;
      } else {
         float var4 = Float.POSITIVE_INFINITY;
         float var5 = Float.POSITIVE_INFINITY;
         if(var0 >= BOTTOM.getCoordinate() - 40.0F) {
            var5 = BOTTOM.getCoordinate() - 40.0F;
         }

         if(var3 * (BOTTOM.getCoordinate() - var0) <= 40.0F) {
            var4 = BOTTOM.getCoordinate() - 40.0F / var3;
         }

         return Math.min(var0, Math.min(var5, var4));
      }
   }

   public static float getHeight() {
      return BOTTOM.getCoordinate() - TOP.getCoordinate();
   }

   public static float getWidth() {
      return RIGHT.getCoordinate() - LEFT.getCoordinate();
   }

   private boolean isOutOfBounds(float var1, float var2, float var3, float var4, Rect var5) {
      return var1 < (float)var5.top || var2 < (float)var5.left || var3 > (float)var5.bottom || var4 > (float)var5.right;
   }

   public void adjustCoordinate(float var1) {
      float var2 = LEFT.getCoordinate();
      float var3 = TOP.getCoordinate();
      float var4 = RIGHT.getCoordinate();
      float var5 = BOTTOM.getCoordinate();
      switch(null.$SwitchMap$com$edmodo$cropper$cropwindow$edge$Edge[this.ordinal()]) {
      case 1:
         this.mCoordinate = AspectRatioUtil.calculateLeft(var3, var4, var5, var1);
         return;
      case 2:
         this.mCoordinate = AspectRatioUtil.calculateTop(var2, var4, var5, var1);
         return;
      case 3:
         this.mCoordinate = AspectRatioUtil.calculateRight(var2, var3, var5, var1);
         return;
      case 4:
         this.mCoordinate = AspectRatioUtil.calculateBottom(var2, var3, var4, var1);
         return;
      default:
      }
   }

   public void adjustCoordinate(float var1, float var2, Rect var3, float var4, float var5) {
      switch(null.$SwitchMap$com$edmodo$cropper$cropwindow$edge$Edge[this.ordinal()]) {
      case 1:
         this.mCoordinate = adjustLeft(var1, var3, var4, var5);
         return;
      case 2:
         this.mCoordinate = adjustTop(var2, var3, var4, var5);
         return;
      case 3:
         this.mCoordinate = adjustRight(var1, var3, var4, var5);
         return;
      case 4:
         this.mCoordinate = adjustBottom(var2, var3, var4, var5);
         return;
      default:
      }
   }

   public float getCoordinate() {
      return this.mCoordinate;
   }

   public boolean isNewRectangleOutOfBounds(Edge var1, Rect var2, float var3) {
      float var4 = var1.snapOffset(var2);
      switch(null.$SwitchMap$com$edmodo$cropper$cropwindow$edge$Edge[this.ordinal()]) {
      case 1:
         if(var1.equals(TOP)) {
            float var26 = (float)var2.top;
            float var27 = BOTTOM.getCoordinate() - var4;
            float var28 = RIGHT.getCoordinate();
            return this.isOutOfBounds(var26, AspectRatioUtil.calculateLeft(var26, var28, var27, var3), var27, var28, var2);
         }

         if(var1.equals(BOTTOM)) {
            float var23 = (float)var2.bottom;
            float var24 = TOP.getCoordinate() - var4;
            float var25 = RIGHT.getCoordinate();
            return this.isOutOfBounds(var24, AspectRatioUtil.calculateLeft(var24, var25, var23, var3), var23, var25, var2);
         }
         break;
      case 2:
         if(var1.equals(LEFT)) {
            float var20 = (float)var2.left;
            float var21 = RIGHT.getCoordinate() - var4;
            float var22 = BOTTOM.getCoordinate();
            return this.isOutOfBounds(AspectRatioUtil.calculateTop(var20, var21, var22, var3), var20, var22, var21, var2);
         }

         if(var1.equals(RIGHT)) {
            float var17 = (float)var2.right;
            float var18 = LEFT.getCoordinate() - var4;
            float var19 = BOTTOM.getCoordinate();
            return this.isOutOfBounds(AspectRatioUtil.calculateTop(var18, var17, var19, var3), var18, var19, var17, var2);
         }
         break;
      case 3:
         if(var1.equals(TOP)) {
            float var14 = (float)var2.top;
            float var15 = BOTTOM.getCoordinate() - var4;
            float var16 = LEFT.getCoordinate();
            return this.isOutOfBounds(var14, var16, var15, AspectRatioUtil.calculateRight(var16, var14, var15, var3), var2);
         }

         if(var1.equals(BOTTOM)) {
            float var11 = (float)var2.bottom;
            float var12 = TOP.getCoordinate() - var4;
            float var13 = LEFT.getCoordinate();
            return this.isOutOfBounds(var12, var13, var11, AspectRatioUtil.calculateRight(var13, var12, var11, var3), var2);
         }
         break;
      case 4:
         if(var1.equals(LEFT)) {
            float var8 = (float)var2.left;
            float var9 = RIGHT.getCoordinate() - var4;
            float var10 = TOP.getCoordinate();
            return this.isOutOfBounds(var10, var8, AspectRatioUtil.calculateBottom(var8, var10, var9, var3), var9, var2);
         }

         if(var1.equals(RIGHT)) {
            float var5 = (float)var2.right;
            float var6 = LEFT.getCoordinate() - var4;
            float var7 = TOP.getCoordinate();
            return this.isOutOfBounds(var7, var6, AspectRatioUtil.calculateBottom(var6, var7, var5, var3), var5, var2);
         }
      }

      return true;
   }

   public boolean isOutsideMargin(Rect var1, float var2) {
      switch(null.$SwitchMap$com$edmodo$cropper$cropwindow$edge$Edge[this.ordinal()]) {
      case 1:
         if(this.mCoordinate - (float)var1.left < var2) {
            return true;
         }

         return false;
      case 2:
         if(this.mCoordinate - (float)var1.top < var2) {
            return true;
         }

         return false;
      case 3:
         if((float)var1.right - this.mCoordinate < var2) {
            return true;
         }

         return false;
      case 4:
         if((float)var1.bottom - this.mCoordinate < var2) {
            return true;
         }

         return false;
      default:
         return false;
      }
   }

   public void offset(float var1) {
      this.mCoordinate += var1;
   }

   public void setCoordinate(float var1) {
      this.mCoordinate = var1;
   }

   public float snapOffset(Rect var1) {
      float var2 = this.mCoordinate;
      float var3 = var2;
      switch(null.$SwitchMap$com$edmodo$cropper$cropwindow$edge$Edge[this.ordinal()]) {
      case 1:
         var3 = (float)var1.left;
         break;
      case 2:
         var3 = (float)var1.top;
         break;
      case 3:
         var3 = (float)var1.right;
         break;
      case 4:
         var3 = (float)var1.bottom;
      }

      return var3 - var2;
   }

   public float snapToRect(Rect var1) {
      float var2 = this.mCoordinate;
      switch(null.$SwitchMap$com$edmodo$cropper$cropwindow$edge$Edge[this.ordinal()]) {
      case 1:
         this.mCoordinate = (float)var1.left;
         break;
      case 2:
         this.mCoordinate = (float)var1.top;
         break;
      case 3:
         this.mCoordinate = (float)var1.right;
         break;
      case 4:
         this.mCoordinate = (float)var1.bottom;
      }

      return this.mCoordinate - var2;
   }
}
