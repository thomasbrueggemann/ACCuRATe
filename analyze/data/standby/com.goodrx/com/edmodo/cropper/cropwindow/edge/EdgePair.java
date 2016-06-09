package com.edmodo.cropper.cropwindow.edge;

import com.edmodo.cropper.cropwindow.edge.Edge;

public class EdgePair {
   public Edge primary;
   public Edge secondary;

   public EdgePair(Edge var1, Edge var2) {
      this.primary = var1;
      this.secondary = var2;
   }
}
