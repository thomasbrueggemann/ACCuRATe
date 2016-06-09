package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Ints;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ImageFormatChecker {
   private static final byte[] BMP_HEADER = asciiBytes("BM");
   private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
   private static final byte[] GIF_HEADER_87A = asciiBytes("GIF87a");
   private static final byte[] GIF_HEADER_89A = asciiBytes("GIF89a");
   private static final int GIF_HEADER_LENGTH = 6;
   private static final byte[] JPEG_HEADER = new byte[]{(byte)-1, (byte)-40, (byte)-1};
   private static final int MAX_HEADER_LENGTH = 0;
   private static final byte[] PNG_HEADER = new byte[]{(byte)-119, (byte)80, (byte)78, (byte)71, (byte)13, (byte)10, (byte)26, (byte)10};
   private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;

   static {
      int[] var0 = new int[]{21, 20, JPEG_HEADER.length, PNG_HEADER.length, 6, BMP_HEADER.length};
      MAX_HEADER_LENGTH = Ints.max(var0);
   }

   private static byte[] asciiBytes(String var0) {
      Preconditions.checkNotNull(var0);

      try {
         byte[] var3 = var0.getBytes("ASCII");
         return var3;
      } catch (UnsupportedEncodingException var4) {
         throw new RuntimeException("ASCII not found!", var4);
      }
   }

   private static ImageFormat doGetImageFormat(byte[] var0, int var1) {
      Preconditions.checkNotNull(var0);
      return WebpSupportStatus.isWebpHeader(var0, 0, var1)?getWebpFormat(var0, var1):(isJpegHeader(var0, var1)?ImageFormat.JPEG:(isPngHeader(var0, var1)?ImageFormat.PNG:(isGifHeader(var0, var1)?ImageFormat.GIF:(isBmpHeader(var0, var1)?ImageFormat.BMP:ImageFormat.UNKNOWN))));
   }

   public static ImageFormat getImageFormat(InputStream var0) throws IOException {
      Preconditions.checkNotNull(var0);
      byte[] var2 = new byte[MAX_HEADER_LENGTH];
      return doGetImageFormat(var2, readHeaderFromStream(var0, var2));
   }

   public static ImageFormat getImageFormat(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static ImageFormat getImageFormat_WrapIOException(InputStream var0) {
      try {
         ImageFormat var2 = getImageFormat(var0);
         return var2;
      } catch (IOException var3) {
         throw Throwables.propagate(var3);
      }
   }

   private static ImageFormat getWebpFormat(byte[] var0, int var1) {
      Preconditions.checkArgument(WebpSupportStatus.isWebpHeader(var0, 0, var1));
      return WebpSupportStatus.isSimpleWebpHeader(var0, 0)?ImageFormat.WEBP_SIMPLE:(WebpSupportStatus.isLosslessWebpHeader(var0, 0)?ImageFormat.WEBP_LOSSLESS:(WebpSupportStatus.isExtendedWebpHeader(var0, 0, var1)?(WebpSupportStatus.isAnimatedWebpHeader(var0, 0)?ImageFormat.WEBP_ANIMATED:(WebpSupportStatus.isExtendedWebpHeaderWithAlpha(var0, 0)?ImageFormat.WEBP_EXTENDED_WITH_ALPHA:ImageFormat.WEBP_EXTENDED)):ImageFormat.UNKNOWN));
   }

   private static boolean isBmpHeader(byte[] var0, int var1) {
      return var1 < BMP_HEADER.length?false:matchBytePattern(var0, 0, BMP_HEADER);
   }

   private static boolean isGifHeader(byte[] var0, int var1) {
      return var1 >= 6 && (matchBytePattern(var0, 0, GIF_HEADER_87A) || matchBytePattern(var0, 0, GIF_HEADER_89A));
   }

   private static boolean isJpegHeader(byte[] var0, int var1) {
      int var2 = JPEG_HEADER.length;
      boolean var3 = false;
      if(var1 >= var2) {
         boolean var4 = matchBytePattern(var0, 0, JPEG_HEADER);
         var3 = false;
         if(var4) {
            var3 = true;
         }
      }

      return var3;
   }

   private static boolean isPngHeader(byte[] var0, int var1) {
      int var2 = PNG_HEADER.length;
      boolean var3 = false;
      if(var1 >= var2) {
         boolean var4 = matchBytePattern(var0, 0, PNG_HEADER);
         var3 = false;
         if(var4) {
            var3 = true;
         }
      }

      return var3;
   }

   private static boolean matchBytePattern(byte[] var0, int var1, byte[] var2) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var2);
      boolean var5;
      if(var1 >= 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      Preconditions.checkArgument(var5);
      if(var1 + var2.length <= var0.length) {
         int var6 = 0;

         while(true) {
            if(var6 >= var2.length) {
               return true;
            }

            if(var0[var6 + var1] != var2[var6]) {
               break;
            }

            ++var6;
         }
      }

      return false;
   }

   private static int readHeaderFromStream(InputStream var0, byte[] var1) throws IOException {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      boolean var4;
      if(var1.length >= MAX_HEADER_LENGTH) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      if(var0.markSupported()) {
         int var6;
         try {
            var0.mark(MAX_HEADER_LENGTH);
            var6 = ByteStreams.read(var0, var1, 0, MAX_HEADER_LENGTH);
         } finally {
            var0.reset();
         }

         return var6;
      } else {
         return ByteStreams.read(var0, var1, 0, MAX_HEADER_LENGTH);
      }
   }
}
