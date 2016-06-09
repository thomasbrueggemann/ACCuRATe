package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.handle.HandleHelper;
import com.edmodo.cropper.util.AspectRatioUtil;

class HorizontalHandleHelper extends HandleHelper {
   private Edge mEdge;

   HorizontalHandleHelper(Edge var1) {
      super(var1, (Edge)null);
      this.mEdge = var1;
   }

   void updateCropWindow(float var1, float var2, float var3, Rect var4, float var5) {
      this.mEdge.adjustCoordinate(var1, var2, var4, var5, var3);
      float var6 = Edge.LEFT.getCoordinate();
      float var7 = Edge.TOP.getCoordinate();
      float var8 = Edge.RIGHT.getCoordinate();
      float var9 = (AspectRatioUtil.calculateWidth(var7, Edge.BOTTOM.getCoordinate(), var3) - (var8 - var6)) / 2.0F;
      float var10 = var6 - var9;
      float var11 = var8 + var9;
      Edge.LEFT.setCoordinate(var10);
      Edge.RIGHT.setCoordinate(var11);
      if(Edge.LEFT.isOutsideMargin(var4, var5) && !this.mEdge.isNewRectangleOutOfBounds(Edge.LEFT, var4, var3)) {
         float var13 = Edge.LEFT.snapToRect(var4);
         Edge.RIGHT.offset(-var13);
         this.mEdge.adjustCoordinate(var3);
      }

      if(Edge.RIGHT.isOutsideMargin(var4, var5) && !this.mEdge.isNewRectangleOutOfBounds(Edge.RIGHT, var4, var3)) {
         float var12 = Edge.RIGHT.snapToRect(var4);
         Edge.LEFT.offset(-var12);
         this.mEdge.adjustCoordinate(var3);
      }

   }
}
