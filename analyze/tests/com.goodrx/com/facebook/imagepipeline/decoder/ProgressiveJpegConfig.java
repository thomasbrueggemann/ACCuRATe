package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.QualityInfo;

public interface ProgressiveJpegConfig {
   int getNextScanNumberToDecode(int var1);

   QualityInfo getQualityInfo(int var1);
}
