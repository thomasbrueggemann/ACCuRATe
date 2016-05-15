package com.facebook.imagepipeline.nativecode;

import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface WebpTranscoder {
   boolean isWebpNativelySupported(ImageFormat var1);

   void transcodeWebpToJpeg(InputStream var1, OutputStream var2, int var3) throws IOException;

   void transcodeWebpToPng(InputStream var1, OutputStream var2) throws IOException;
}
