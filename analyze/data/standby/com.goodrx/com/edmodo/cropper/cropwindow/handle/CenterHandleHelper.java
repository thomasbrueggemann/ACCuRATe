package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.handle.HandleHelper;

class CenterHandleHelper extends HandleHelper {
   CenterHandleHelper() {
      super((Edge)null, (Edge)null);
   }

   void updateCropWindow(float var1, float var2, float var3, Rect var4, float var5) {
      this.updateCropWindow(var1, var2, var4, var5);
   }

   void updateCropWindow(float var1, float var2, Rect var3, float var4) {
      float var5 = Edge.LEFT.getCoordinate();
      float var6 = Edge.TOP.getCoordinate();
      float var7 = Edge.RIGHT.getCoordinate();
      float var8 = Edge.BOTTOM.getCoordinate();
      float var9 = (var5 + var7) / 2.0F;
      float var10 = (var6 + var8) / 2.0F;
      float var11 = var1 - var9;
      float var12 = var2 - var10;
      Edge.LEFT.offset(var11);
      Edge.TOP.offset(var12);
      Edge.RIGHT.offset(var11);
      Edge.BOTTOM.offset(var12);
      if(Edge.LEFT.isOutsideMargin(var3, var4)) {
         float var16 = Edge.LEFT.snapToRect(var3);
         Edge.RIGHT.offset(var16);
      } else if(Edge.RIGHT.isOutsideMargin(var3, var4)) {
         float var13 = Edge.RIGHT.snapToRect(var3);
         Edge.LEFT.offset(var13);
      }

      if(Edge.TOP.isOutsideMargin(var3, var4)) {
         float var15 = Edge.TOP.snapToRect(var3);
         Edge.BOTTOM.offset(var15);
      } else if(Edge.BOTTOM.isOutsideMargin(var3, var4)) {
         float var14 = Edge.BOTTOM.snapToRect(var3);
         Edge.TOP.offset(var14);
         return;
      }

   }
}
