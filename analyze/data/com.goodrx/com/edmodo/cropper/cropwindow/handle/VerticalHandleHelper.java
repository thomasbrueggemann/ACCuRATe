package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.handle.HandleHelper;
import com.edmodo.cropper.util.AspectRatioUtil;

class VerticalHandleHelper extends HandleHelper {
   private Edge mEdge;

   VerticalHandleHelper(Edge var1) {
      super((Edge)null, var1);
      this.mEdge = var1;
   }

   void updateCropWindow(float var1, float var2, float var3, Rect var4, float var5) {
      this.mEdge.adjustCoordinate(var1, var2, var4, var5, var3);
      float var6 = Edge.LEFT.getCoordinate();
      float var7 = Edge.TOP.getCoordinate();
      float var8 = Edge.RIGHT.getCoordinate();
      float var9 = Edge.BOTTOM.getCoordinate();
      float var10 = (AspectRatioUtil.calculateHeight(var6, var8, var3) - (var9 - var7)) / 2.0F;
      float var11 = var7 - var10;
      float var12 = var9 + var10;
      Edge.TOP.setCoordinate(var11);
      Edge.BOTTOM.setCoordinate(var12);
      if(Edge.TOP.isOutsideMargin(var4, var5) && !this.mEdge.isNewRectangleOutOfBounds(Edge.TOP, var4, var3)) {
         float var14 = Edge.TOP.snapToRect(var4);
         Edge.BOTTOM.offset(-var14);
         this.mEdge.adjustCoordinate(var3);
      }

      if(Edge.BOTTOM.isOutsideMargin(var4, var5) && !this.mEdge.isNewRectangleOutOfBounds(Edge.BOTTOM, var4, var3)) {
         float var13 = Edge.BOTTOM.snapToRect(var4);
         Edge.TOP.offset(-var13);
         this.mEdge.adjustCoordinate(var3);
      }

   }
}
