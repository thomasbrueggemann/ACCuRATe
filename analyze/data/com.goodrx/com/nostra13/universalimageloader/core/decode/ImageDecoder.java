package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import java.io.IOException;

public interface ImageDecoder {
   Bitmap decode(ImageDecodingInfo var1) throws IOException;
}
