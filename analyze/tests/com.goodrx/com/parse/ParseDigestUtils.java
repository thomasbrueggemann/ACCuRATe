package com.parse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class ParseDigestUtils {
   private static final char[] hexArray = "0123456789abcdef".toCharArray();

   public static String md5(String var0) {
      MessageDigest var2;
      try {
         var2 = MessageDigest.getInstance("MD5");
      } catch (NoSuchAlgorithmException var3) {
         throw new RuntimeException(var3);
      }

      var2.update(var0.getBytes());
      return toHex(var2.digest());
   }

   private static String toHex(byte[] var0) {
      char[] var1 = new char[2 * var0.length];

      for(int var2 = 0; var2 < var0.length; ++var2) {
         int var3 = 255 & var0[var2];
         var1[var2 * 2] = hexArray[var3 >>> 4];
         var1[1 + var2 * 2] = hexArray[var3 & 15];
      }

      return new String(var1);
   }
}
