package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;

public interface PlatformDecoder {
   CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage var1, Config var2);

   CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage var1, Config var2, int var3);
}
