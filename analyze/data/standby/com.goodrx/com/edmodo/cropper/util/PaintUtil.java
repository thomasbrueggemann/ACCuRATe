package com.edmodo.cropper.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.TypedValue;

public class PaintUtil {
   public static float getCornerThickness() {
      return 5.0F;
   }

   public static float getLineThickness() {
      return 3.0F;
   }

   public static Paint newBackgroundPaint(Context var0) {
      Paint var1 = new Paint();
      var1.setColor(Color.parseColor("#B0000000"));
      return var1;
   }

   public static Paint newBorderPaint(Context var0) {
      float var1 = TypedValue.applyDimension(1, 3.0F, var0.getResources().getDisplayMetrics());
      Paint var2 = new Paint();
      var2.setColor(Color.parseColor("#AAFFFFFF"));
      var2.setStrokeWidth(var1);
      var2.setStyle(Style.STROKE);
      return var2;
   }

   public static Paint newCornerPaint(Context var0) {
      float var1 = TypedValue.applyDimension(1, 5.0F, var0.getResources().getDisplayMetrics());
      Paint var2 = new Paint();
      var2.setColor(-1);
      var2.setStrokeWidth(var1);
      var2.setStyle(Style.STROKE);
      return var2;
   }

   public static Paint newGuidelinePaint() {
      Paint var0 = new Paint();
      var0.setColor(Color.parseColor("#AAFFFFFF"));
      var0.setStrokeWidth(1.0F);
      return var0;
   }
}
