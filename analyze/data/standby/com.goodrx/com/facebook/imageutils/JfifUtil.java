package com.facebook.imageutils;

import com.facebook.common.internal.Preconditions;
import com.facebook.imageutils.StreamProcessor;
import com.facebook.imageutils.TiffUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JfifUtil {
   public static final int APP1_EXIF_MAGIC = 1165519206;
   public static final int MARKER_APP1 = 225;
   public static final int MARKER_EOI = 217;
   public static final int MARKER_ESCAPE_BYTE = 0;
   public static final int MARKER_FIRST_BYTE = 255;
   public static final int MARKER_RST0 = 208;
   public static final int MARKER_RST7 = 215;
   public static final int MARKER_SOFn = 192;
   public static final int MARKER_SOI = 216;
   public static final int MARKER_SOS = 218;
   public static final int MARKER_TEM = 1;

   public static int getAutoRotateAngleFromOrientation(int var0) {
      return TiffUtil.getAutoRotateAngleFromOrientation(var0);
   }

   public static int getOrientation(InputStream param0) {
      // $FF: Couldn't be decompiled
   }

   public static int getOrientation(byte[] var0) {
      return getOrientation((InputStream)(new ByteArrayInputStream(var0)));
   }

   private static boolean isSOFn(int var0) {
      switch(var0) {
      case 192:
      case 193:
      case 194:
      case 195:
      case 197:
      case 198:
      case 199:
      case 201:
      case 202:
      case 203:
      case 205:
      case 206:
      case 207:
         return true;
      case 196:
      case 200:
      case 204:
      default:
         return false;
      }
   }

   private static int moveToAPP1EXIF(InputStream var0) throws IOException {
      if(moveToMarker(var0, 225)) {
         int var1 = -2 + StreamProcessor.readPackedInt(var0, 2, false);
         if(var1 > 6) {
            int var2 = StreamProcessor.readPackedInt(var0, 4, false);
            int var3 = var1 - 4;
            int var4 = StreamProcessor.readPackedInt(var0, 2, false);
            int var5 = var3 - 2;
            if(var2 == 1165519206 && var4 == 0) {
               return var5;
            }
         }
      }

      return 0;
   }

   public static boolean moveToMarker(InputStream var0, int var1) throws IOException {
      Preconditions.checkNotNull(var0);

      while(StreamProcessor.readPackedInt(var0, 1, false) == 255) {
         int var3;
         for(var3 = 255; var3 == 255; var3 = StreamProcessor.readPackedInt(var0, 1, false)) {
            ;
         }

         if((var1 != 192 || !isSOFn(var3)) && var3 != var1) {
            if(var3 == 216 || var3 == 1) {
               continue;
            }

            if(var3 != 217 && var3 != 218) {
               var0.skip((long)(-2 + StreamProcessor.readPackedInt(var0, 2, false)));
               continue;
            }

            return false;
         }

         return true;
      }

      return false;
   }
}
