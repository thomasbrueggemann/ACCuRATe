package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.edge.EdgePair;
import com.edmodo.cropper.cropwindow.handle.HandleHelper;

class CornerHandleHelper extends HandleHelper {
   CornerHandleHelper(Edge var1, Edge var2) {
      super(var1, var2);
   }

   void updateCropWindow(float var1, float var2, float var3, Rect var4, float var5) {
      EdgePair var6 = this.getActiveEdges(var1, var2, var3);
      Edge var7 = var6.primary;
      Edge var8 = var6.secondary;
      var7.adjustCoordinate(var1, var2, var4, var5, var3);
      var8.adjustCoordinate(var3);
      if(var8.isOutsideMargin(var4, var5)) {
         var8.snapToRect(var4);
         var7.adjustCoordinate(var3);
      }

   }
}
