package android.support.v7.widget;

import android.graphics.drawable.Drawable;

interface CardViewDelegate {
   Drawable getBackground();

   boolean getPreventCornerOverlap();

   float getRadius();

   boolean getUseCompatPadding();

   void setBackgroundDrawable(Drawable var1);

   void setMinWidthHeightInternal(int var1, int var2);

   void setShadowPadding(int var1, int var2, int var3, int var4);
}
