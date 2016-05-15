package com.goodrx.utils;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.MeasureSpec;
import com.goodrx.utils.MarkerIcon;

public class CircularMarkerIcon extends MarkerIcon {
   private int diameter;

   public CircularMarkerIcon(@NonNull View var1, int var2) {
      super(var1);
      this.diameter = var2;
   }

   protected void measureView() {
      int var1 = MeasureSpec.makeMeasureSpec(this.diameter, 1073741824);
      this.view.measure(var1, var1);
   }
}
