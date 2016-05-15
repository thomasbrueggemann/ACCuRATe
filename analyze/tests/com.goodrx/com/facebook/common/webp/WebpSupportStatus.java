package com.facebook.common.webp;

import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Base64;
import com.facebook.common.webp.WebpBitmapFactory;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import java.io.UnsupportedEncodingException;

public class WebpSupportStatus {
   private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
   private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
   private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
   private static final byte[] WEBP_NAME_BYTES;
   private static final byte[] WEBP_RIFF_BYTES;
   private static final byte[] WEBP_VP8L_BYTES;
   private static final byte[] WEBP_VP8X_BYTES;
   private static final byte[] WEBP_VP8_BYTES;
   public static final boolean sIsExtendedWebpSupported;
   public static final boolean sIsSimpleWebpSupported;
   public static final boolean sIsWebpSupportRequired;
   public static WebpBitmapFactory sWebpBitmapFactory;
   public static boolean sWebpLibraryPresent;

   static {
      boolean var0 = true;
      boolean var1;
      if(VERSION.SDK_INT <= 17) {
         var1 = var0;
      } else {
         var1 = false;
      }

      sIsWebpSupportRequired = var1;
      if(VERSION.SDK_INT < 14) {
         var0 = false;
      }

      sIsSimpleWebpSupported = var0;
      sIsExtendedWebpSupported = isExtendedWebpSupported();
      sWebpBitmapFactory = null;
      sWebpLibraryPresent = false;

      try {
         sWebpBitmapFactory = (WebpBitmapFactory)Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
         sWebpLibraryPresent = true;
      } catch (Throwable var3) {
         sWebpLibraryPresent = false;
      }

      WEBP_RIFF_BYTES = asciiBytes("RIFF");
      WEBP_NAME_BYTES = asciiBytes("WEBP");
      WEBP_VP8_BYTES = asciiBytes("VP8 ");
      WEBP_VP8L_BYTES = asciiBytes("VP8L");
      WEBP_VP8X_BYTES = asciiBytes("VP8X");
   }

   private static byte[] asciiBytes(String var0) {
      try {
         byte[] var2 = var0.getBytes("ASCII");
         return var2;
      } catch (UnsupportedEncodingException var3) {
         throw new RuntimeException("ASCII not found!", var3);
      }
   }

   public static boolean isAnimatedWebpHeader(byte[] var0, int var1) {
      boolean var2 = matchBytePattern(var0, var1 + 12, WEBP_VP8X_BYTES);
      boolean var3;
      if((2 & var0[var1 + 20]) == 2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var2 && var3;
   }

   public static boolean isExtendedWebpHeader(byte[] var0, int var1, int var2) {
      return var2 >= 21 && matchBytePattern(var0, var1 + 12, WEBP_VP8X_BYTES);
   }

   public static boolean isExtendedWebpHeaderWithAlpha(byte[] var0, int var1) {
      boolean var2 = matchBytePattern(var0, var1 + 12, WEBP_VP8X_BYTES);
      boolean var3;
      if((16 & var0[var1 + 20]) == 16) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var2 && var3;
   }

   private static boolean isExtendedWebpSupported() {
      if(VERSION.SDK_INT >= 17) {
         if(VERSION.SDK_INT == 17) {
            byte[] var0 = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
            Options var1 = new Options();
            var1.inJustDecodeBounds = true;
            BitmapFactoryInstrumentation.decodeByteArray(var0, 0, var0.length, var1);
            if(var1.outHeight != 1 || var1.outWidth != 1) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean isLosslessWebpHeader(byte[] var0, int var1) {
      return matchBytePattern(var0, var1 + 12, WEBP_VP8L_BYTES);
   }

   public static boolean isSimpleWebpHeader(byte[] var0, int var1) {
      return matchBytePattern(var0, var1 + 12, WEBP_VP8_BYTES);
   }

   public static boolean isWebpHeader(byte[] var0, int var1, int var2) {
      return var2 >= 20 && matchBytePattern(var0, var1, WEBP_RIFF_BYTES) && matchBytePattern(var0, var1 + 8, WEBP_NAME_BYTES);
   }

   public static boolean isWebpPlatformSupported(byte[] var0, int var1, int var2) {
      boolean var4;
      if(isSimpleWebpHeader(var0, var1)) {
         var4 = sIsSimpleWebpSupported;
      } else {
         if(isLosslessWebpHeader(var0, var1)) {
            return sIsExtendedWebpSupported;
         }

         boolean var3 = isExtendedWebpHeader(var0, var1, var2);
         var4 = false;
         if(var3) {
            boolean var5 = isAnimatedWebpHeader(var0, var1);
            var4 = false;
            if(!var5) {
               return sIsExtendedWebpSupported;
            }
         }
      }

      return var4;
   }

   private static boolean matchBytePattern(byte[] var0, int var1, byte[] var2) {
      if(var2 != null && var0 != null && var1 + var2.length <= var0.length) {
         int var3 = 0;

         while(true) {
            if(var3 >= var2.length) {
               return true;
            }

            if(var0[var3 + var1] != var2[var3]) {
               break;
            }

            ++var3;
         }
      }

      return false;
   }
}
