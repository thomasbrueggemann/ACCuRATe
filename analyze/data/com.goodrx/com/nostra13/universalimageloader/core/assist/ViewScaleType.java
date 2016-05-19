package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;

public enum ViewScaleType {
   CROP,
   FIT_INSIDE;

   static {
      ViewScaleType[] var0 = new ViewScaleType[]{FIT_INSIDE, CROP};
   }

   public static ViewScaleType fromImageView(ImageView var0) {
      switch(null.$SwitchMap$android$widget$ImageView$ScaleType[var0.getScaleType().ordinal()]) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
         return FIT_INSIDE;
      default:
         return CROP;
      }
   }
}
