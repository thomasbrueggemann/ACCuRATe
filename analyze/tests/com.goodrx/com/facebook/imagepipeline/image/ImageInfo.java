package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.image.QualityInfo;

public interface ImageInfo {
   int getHeight();

   QualityInfo getQualityInfo();

   int getWidth();
}
