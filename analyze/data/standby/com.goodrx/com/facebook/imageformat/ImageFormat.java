package com.facebook.imageformat;

public enum ImageFormat {
   BMP,
   GIF,
   JPEG,
   PNG,
   UNKNOWN,
   WEBP_ANIMATED,
   WEBP_EXTENDED,
   WEBP_EXTENDED_WITH_ALPHA,
   WEBP_LOSSLESS,
   WEBP_SIMPLE;

   static {
      ImageFormat[] var0 = new ImageFormat[]{WEBP_SIMPLE, WEBP_LOSSLESS, WEBP_EXTENDED, WEBP_EXTENDED_WITH_ALPHA, WEBP_ANIMATED, JPEG, PNG, GIF, BMP, UNKNOWN};
   }

   public static String getFileExtension(ImageFormat var0) throws UnsupportedOperationException {
      switch(null.$SwitchMap$com$facebook$imageformat$ImageFormat[var0.ordinal()]) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
         return "webp";
      case 6:
         return "jpeg";
      case 7:
         return "png";
      case 8:
         return "gif";
      case 9:
         return "bmp";
      default:
         throw new UnsupportedOperationException("Unknown image format " + var0.name());
      }
   }

   public static boolean isWebpFormat(ImageFormat var0) {
      return var0 == WEBP_SIMPLE || var0 == WEBP_LOSSLESS || var0 == WEBP_EXTENDED || var0 == WEBP_EXTENDED_WITH_ALPHA || var0 == WEBP_ANIMATED;
   }
}
