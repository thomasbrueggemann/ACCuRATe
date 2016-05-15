package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
public class JpegTranscoder {
   public static final int MAX_QUALITY = 100;
   public static final int MAX_SCALE_NUMERATOR = 16;
   public static final int MIN_QUALITY = 0;
   public static final int MIN_SCALE_NUMERATOR = 1;
   public static final int SCALE_DENOMINATOR = 8;

   static {
      ImagePipelineNativeLoader.load();
   }

   public static boolean isRotationAngleAllowed(int var0) {
      return var0 >= 0 && var0 <= 270 && var0 % 90 == 0;
   }

   @DoNotStrip
   private static native void nativeTranscodeJpeg(InputStream var0, OutputStream var1, int var2, int var3, int var4) throws IOException;

   public static void transcodeJpeg(InputStream var0, OutputStream var1, int var2, int var3, int var4) throws IOException {
      boolean var5;
      if(var3 >= 1) {
         var5 = true;
      } else {
         var5 = false;
      }

      Preconditions.checkArgument(var5);
      boolean var6;
      if(var3 <= 16) {
         var6 = true;
      } else {
         var6 = false;
      }

      Preconditions.checkArgument(var6);
      boolean var7;
      if(var4 >= 0) {
         var7 = true;
      } else {
         var7 = false;
      }

      Preconditions.checkArgument(var7);
      boolean var8;
      if(var4 <= 100) {
         var8 = true;
      } else {
         var8 = false;
      }

      boolean var9;
      label30: {
         Preconditions.checkArgument(var8);
         Preconditions.checkArgument(isRotationAngleAllowed(var2));
         if(var3 == 8) {
            var9 = false;
            if(var2 == 0) {
               break label30;
            }
         }

         var9 = true;
      }

      Preconditions.checkArgument(var9, "no transformation requested");
      nativeTranscodeJpeg((InputStream)Preconditions.checkNotNull(var0), (OutputStream)Preconditions.checkNotNull(var1), var2, var3, var4);
   }
}
