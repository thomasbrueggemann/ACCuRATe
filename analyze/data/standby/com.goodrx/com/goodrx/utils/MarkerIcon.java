package com.goodrx.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.support.annotation.NonNull;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MarkerIcon {
   protected View view;

   public MarkerIcon(@NonNull View var1) {
      this.view = var1;
   }

   public BitmapDescriptor getBitMapDescriptor() {
      this.view.layout(this.view.getLeft(), this.view.getTop(), this.view.getRight(), this.view.getBottom());
      this.measureView();
      Bitmap var1 = Bitmap.createBitmap(this.view.getMeasuredWidth(), this.view.getMeasuredHeight(), Config.ARGB_8888);
      Canvas var2 = new Canvas(var1);
      this.view.layout(0, 0, this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
      this.view.draw(var2);
      return BitmapDescriptorFactory.fromBitmap(var1);
   }

   public View getView() {
      return this.view;
   }

   protected void measureView() {
      this.view.measure(-2, -2);
   }
}
