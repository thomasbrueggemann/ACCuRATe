package com.nostra13.universalimageloader.core.assist;

public enum ImageScaleType {
   EXACTLY,
   EXACTLY_STRETCHED,
   IN_SAMPLE_INT,
   IN_SAMPLE_POWER_OF_2,
   NONE,
   NONE_SAFE;

   static {
      ImageScaleType[] var0 = new ImageScaleType[]{NONE, NONE_SAFE, IN_SAMPLE_POWER_OF_2, IN_SAMPLE_INT, EXACTLY, EXACTLY_STRETCHED};
   }
}
