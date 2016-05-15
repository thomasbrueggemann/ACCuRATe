package com.goodrx.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import com.goodrx.utils.Utils;

public class PasscodePinCircle extends View {
   private boolean activated;
   private int viewHeight;
   private int viewWidth;

   public PasscodePinCircle(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      Paint var2 = new Paint();
      var2.setAntiAlias(true);
      int var3 = Utils.convertDpToPixel(this.getContext(), 2.0D);
      int var4 = Math.min(this.viewWidth, this.viewHeight) / 2 - var3;
      var2.setStyle(Style.STROKE);
      var2.setColor(-16777216);
      var2.setStrokeWidth((float)var3);
      var1.drawCircle((float)(var4 + var3), (float)(var4 + var3), (float)var4, var2);
      var2.setStyle(Style.FILL);
      if(this.activated) {
         var2.setColor(ContextCompat.getColor(this.getContext(), 2131755161));
      } else {
         var2.setColor(-1);
      }

      var1.drawCircle((float)(var4 + var3), (float)(var4 + var3), (float)var4, var2);
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      this.viewWidth = this.getMeasuredWidth();
      this.viewHeight = this.getMeasuredHeight();
   }

   public void setActivate(boolean var1) {
      this.activated = var1;
      this.invalidate();
   }
}
