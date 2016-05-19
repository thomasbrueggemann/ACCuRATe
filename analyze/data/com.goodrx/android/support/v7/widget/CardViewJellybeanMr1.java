package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.CardViewEclairMr1;
import android.support.v7.widget.RoundRectDrawableWithShadow;

class CardViewJellybeanMr1 extends CardViewEclairMr1 {
   public void initStatic() {
      RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper() {
         public void drawRoundRect(Canvas var1, RectF var2, float var3, Paint var4) {
            var1.drawRoundRect(var2, var3, var3, var4);
         }
      };
   }
}
