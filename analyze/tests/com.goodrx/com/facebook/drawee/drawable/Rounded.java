package com.facebook.drawee.drawable;

public interface Rounded {
   int getBorderColor();

   float getBorderWidth();

   float getPadding();

   float[] getRadii();

   boolean isCircle();

   void setBorder(int var1, float var2);

   void setCircle(boolean var1);

   void setPadding(float var1);

   void setRadii(float[] var1);

   void setRadius(float var1);
}
