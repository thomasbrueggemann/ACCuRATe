package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.edge.EdgePair;
import com.edmodo.cropper.util.AspectRatioUtil;

abstract class HandleHelper {
   private EdgePair mActiveEdges;
   private Edge mHorizontalEdge;
   private Edge mVerticalEdge;

   HandleHelper(Edge var1, Edge var2) {
      this.mHorizontalEdge = var1;
      this.mVerticalEdge = var2;
      this.mActiveEdges = new EdgePair(this.mHorizontalEdge, this.mVerticalEdge);
   }

   private float getAspectRatio(float var1, float var2) {
      float var3;
      if(this.mVerticalEdge == Edge.LEFT) {
         var3 = var1;
      } else {
         var3 = Edge.LEFT.getCoordinate();
      }

      float var4;
      if(this.mHorizontalEdge == Edge.TOP) {
         var4 = var2;
      } else {
         var4 = Edge.TOP.getCoordinate();
      }

      float var5;
      if(this.mVerticalEdge == Edge.RIGHT) {
         var5 = var1;
      } else {
         var5 = Edge.RIGHT.getCoordinate();
      }

      float var6;
      if(this.mHorizontalEdge == Edge.BOTTOM) {
         var6 = var2;
      } else {
         var6 = Edge.BOTTOM.getCoordinate();
      }

      return AspectRatioUtil.calculateAspectRatio(var3, var4, var5, var6);
   }

   EdgePair getActiveEdges() {
      return this.mActiveEdges;
   }

   EdgePair getActiveEdges(float var1, float var2, float var3) {
      if(this.getAspectRatio(var1, var2) > var3) {
         this.mActiveEdges.primary = this.mVerticalEdge;
         this.mActiveEdges.secondary = this.mHorizontalEdge;
      } else {
         this.mActiveEdges.primary = this.mHorizontalEdge;
         this.mActiveEdges.secondary = this.mVerticalEdge;
      }

      return this.mActiveEdges;
   }

   abstract void updateCropWindow(float var1, float var2, float var3, Rect var4, float var5);

   void updateCropWindow(float var1, float var2, Rect var3, float var4) {
      EdgePair var5 = this.getActiveEdges();
      Edge var6 = var5.primary;
      Edge var7 = var5.secondary;
      if(var6 != null) {
         var6.adjustCoordinate(var1, var2, var3, var4, 1.0F);
      }

      if(var7 != null) {
         var7.adjustCoordinate(var1, var2, var3, var4, 1.0F);
      }

   }
}
