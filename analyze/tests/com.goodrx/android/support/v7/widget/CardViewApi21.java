package android.support.v7.widget;

import android.content.Context;
import android.support.v7.widget.CardViewDelegate;
import android.support.v7.widget.CardViewImpl;
import android.support.v7.widget.RoundRectDrawable;
import android.support.v7.widget.RoundRectDrawableWithShadow;
import android.view.View;

class CardViewApi21 implements CardViewImpl {
   public float getElevation(CardViewDelegate var1) {
      return ((View)var1).getElevation();
   }

   public float getMaxElevation(CardViewDelegate var1) {
      return ((RoundRectDrawable)((RoundRectDrawable)var1.getBackground())).getPadding();
   }

   public float getMinHeight(CardViewDelegate var1) {
      return 2.0F * this.getRadius(var1);
   }

   public float getMinWidth(CardViewDelegate var1) {
      return 2.0F * this.getRadius(var1);
   }

   public float getRadius(CardViewDelegate var1) {
      return ((RoundRectDrawable)((RoundRectDrawable)var1.getBackground())).getRadius();
   }

   public void initStatic() {
   }

   public void initialize(CardViewDelegate var1, Context var2, int var3, float var4, float var5, float var6) {
      var1.setBackgroundDrawable(new RoundRectDrawable(var3, var4));
      View var7 = (View)var1;
      var7.setClipToOutline(true);
      var7.setElevation(var5);
      this.setMaxElevation(var1, var6);
   }

   public void onCompatPaddingChanged(CardViewDelegate var1) {
      this.setMaxElevation(var1, this.getMaxElevation(var1));
   }

   public void onPreventCornerOverlapChanged(CardViewDelegate var1) {
      this.setMaxElevation(var1, this.getMaxElevation(var1));
   }

   public void setBackgroundColor(CardViewDelegate var1, int var2) {
      ((RoundRectDrawable)((RoundRectDrawable)var1.getBackground())).setColor(var2);
   }

   public void setElevation(CardViewDelegate var1, float var2) {
      ((View)var1).setElevation(var2);
   }

   public void setMaxElevation(CardViewDelegate var1, float var2) {
      ((RoundRectDrawable)((RoundRectDrawable)var1.getBackground())).setPadding(var2, var1.getUseCompatPadding(), var1.getPreventCornerOverlap());
      this.updatePadding(var1);
   }

   public void setRadius(CardViewDelegate var1, float var2) {
      ((RoundRectDrawable)((RoundRectDrawable)var1.getBackground())).setRadius(var2);
   }

   public void updatePadding(CardViewDelegate var1) {
      if(!var1.getUseCompatPadding()) {
         var1.setShadowPadding(0, 0, 0, 0);
      } else {
         float var2 = this.getMaxElevation(var1);
         float var3 = this.getRadius(var1);
         int var4 = (int)Math.ceil((double)RoundRectDrawableWithShadow.calculateHorizontalPadding(var2, var3, var1.getPreventCornerOverlap()));
         int var5 = (int)Math.ceil((double)RoundRectDrawableWithShadow.calculateVerticalPadding(var2, var3, var1.getPreventCornerOverlap()));
         var1.setShadowPadding(var4, var5, var4, var5);
      }
   }
}
