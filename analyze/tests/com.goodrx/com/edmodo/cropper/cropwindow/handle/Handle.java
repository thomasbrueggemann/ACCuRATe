package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.handle.CenterHandleHelper;
import com.edmodo.cropper.cropwindow.handle.CornerHandleHelper;
import com.edmodo.cropper.cropwindow.handle.HandleHelper;
import com.edmodo.cropper.cropwindow.handle.HorizontalHandleHelper;
import com.edmodo.cropper.cropwindow.handle.VerticalHandleHelper;

public enum Handle {
   BOTTOM,
   BOTTOM_LEFT,
   BOTTOM_RIGHT,
   CENTER,
   LEFT,
   RIGHT,
   TOP,
   TOP_LEFT,
   TOP_RIGHT;

   private HandleHelper mHelper;

   static {
      TOP_LEFT = new Handle("TOP_LEFT", 0, new CornerHandleHelper(Edge.TOP, Edge.LEFT));
      TOP_RIGHT = new Handle("TOP_RIGHT", 1, new CornerHandleHelper(Edge.TOP, Edge.RIGHT));
      BOTTOM_LEFT = new Handle("BOTTOM_LEFT", 2, new CornerHandleHelper(Edge.BOTTOM, Edge.LEFT));
      BOTTOM_RIGHT = new Handle("BOTTOM_RIGHT", 3, new CornerHandleHelper(Edge.BOTTOM, Edge.RIGHT));
      LEFT = new Handle("LEFT", 4, new VerticalHandleHelper(Edge.LEFT));
      TOP = new Handle("TOP", 5, new HorizontalHandleHelper(Edge.TOP));
      RIGHT = new Handle("RIGHT", 6, new VerticalHandleHelper(Edge.RIGHT));
      BOTTOM = new Handle("BOTTOM", 7, new HorizontalHandleHelper(Edge.BOTTOM));
      CENTER = new Handle("CENTER", 8, new CenterHandleHelper());
      Handle[] var0 = new Handle[]{TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, LEFT, TOP, RIGHT, BOTTOM, CENTER};
   }

   private Handle(HandleHelper var3) {
      this.mHelper = var3;
   }

   public void updateCropWindow(float var1, float var2, float var3, Rect var4, float var5) {
      this.mHelper.updateCropWindow(var1, var2, var3, var4, var5);
   }

   public void updateCropWindow(float var1, float var2, Rect var3, float var4) {
      this.mHelper.updateCropWindow(var1, var2, var3, var4);
   }
}
