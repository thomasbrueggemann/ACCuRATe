package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import com.facebook.imageutils.StreamProcessor;
import java.io.IOException;
import java.io.InputStream;

class TiffUtil {
   private static final Class<?> TAG = TiffUtil.class;
   public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
   public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
   public static final int TIFF_TAG_ORIENTATION = 274;
   public static final int TIFF_TYPE_SHORT = 3;

   public static int getAutoRotateAngleFromOrientation(int var0) {
      switch(var0) {
      case 2:
      case 4:
      case 5:
      case 7:
      default:
         FLog.method_401(TAG, "Unsupported orientation");
      case 1:
         return 0;
      case 3:
         return 180;
      case 6:
         return 90;
      case 8:
         return 270;
      }
   }

   private static int getOrientationFromTiffEntry(InputStream var0, int var1, boolean var2) throws IOException {
      if(var1 >= 10 && StreamProcessor.readPackedInt(var0, 2, var2) == 3 && StreamProcessor.readPackedInt(var0, 4, var2) == 1) {
         int var3 = StreamProcessor.readPackedInt(var0, 2, var2);
         StreamProcessor.readPackedInt(var0, 2, var2);
         return var3;
      } else {
         return 0;
      }
   }

   private static int moveToTiffEntryWithTag(InputStream var0, int var1, boolean var2, int var3) throws IOException {
      if(var1 >= 14) {
         int var4 = StreamProcessor.readPackedInt(var0, 2, var2);
         int var5 = var1 - 2;
         int var6 = var4;

         while(true) {
            int var7 = var6 - 1;
            if(var6 <= 0 || var5 < 12) {
               break;
            }

            int var8 = StreamProcessor.readPackedInt(var0, 2, var2);
            int var9 = var5 - 2;
            if(var8 == var3) {
               return var9;
            }

            var0.skip(10L);
            var5 = var9 - 10;
            var6 = var7;
         }
      }

      return 0;
   }

   public static int readOrientationFromTIFF(InputStream var0, int var1) throws IOException {
      TiffUtil.TiffHeader var2 = new TiffUtil.TiffHeader();
      int var3 = readTiffHeader(var0, var1, var2);
      int var4 = -8 + var2.firstIfdOffset;
      if(var3 != 0 && var4 <= var3) {
         var0.skip((long)var4);
         return getOrientationFromTiffEntry(var0, moveToTiffEntryWithTag(var0, var3 - var4, var2.isLittleEndian, 274), var2.isLittleEndian);
      } else {
         return 0;
      }
   }

   private static int readTiffHeader(InputStream var0, int var1, TiffUtil.TiffHeader var2) throws IOException {
      if(var1 <= 8) {
         return 0;
      } else {
         var2.byteOrder = StreamProcessor.readPackedInt(var0, 4, false);
         int var3 = var1 - 4;
         if(var2.byteOrder != 1229531648 && var2.byteOrder != 1296891946) {
            FLog.method_393(TAG, "Invalid TIFF header");
            return 0;
         } else {
            boolean var4;
            if(var2.byteOrder == 1229531648) {
               var4 = true;
            } else {
               var4 = false;
            }

            var2.isLittleEndian = var4;
            var2.firstIfdOffset = StreamProcessor.readPackedInt(var0, 4, var2.isLittleEndian);
            int var5 = var3 - 4;
            if(var2.firstIfdOffset >= 8 && -8 + var2.firstIfdOffset <= var5) {
               return var5;
            } else {
               FLog.method_393(TAG, "Invalid offset");
               return 0;
            }
         }
      }
   }

   private static class TiffHeader {
      int byteOrder;
      int firstIfdOffset;
      boolean isLittleEndian;

      private TiffHeader() {
      }

      // $FF: synthetic method
      TiffHeader(Object var1) {
         this();
      }
   }
}
