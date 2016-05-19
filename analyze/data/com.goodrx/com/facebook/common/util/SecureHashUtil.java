package com.facebook.common.util;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureHashUtil {
   static final byte[] HEX_CHAR_TABLE = new byte[]{(byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102};

   public static String convertToHex(byte[] var0) throws UnsupportedEncodingException {
      StringBuilder var1 = new StringBuilder(var0.length);
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = 255 & var0[var3];
         var1.append((char)HEX_CHAR_TABLE[var4 >>> 4]);
         var1.append((char)HEX_CHAR_TABLE[var4 & 15]);
      }

      return var1.toString();
   }

   public static String makeMD5Hash(String var0) {
      try {
         String var2 = makeMD5Hash(var0.getBytes("utf-8"));
         return var2;
      } catch (UnsupportedEncodingException var3) {
         throw new RuntimeException(var3);
      }
   }

   public static String makeMD5Hash(byte[] var0) {
      try {
         MessageDigest var3 = MessageDigest.getInstance("MD5");
         var3.update(var0, 0, var0.length);
         String var4 = convertToHex(var3.digest());
         return var4;
      } catch (NoSuchAlgorithmException var5) {
         throw new RuntimeException(var5);
      } catch (UnsupportedEncodingException var6) {
         throw new RuntimeException(var6);
      }
   }

   public static String makeSHA1Hash(String var0) {
      try {
         String var2 = makeSHA1Hash(var0.getBytes("utf-8"));
         return var2;
      } catch (UnsupportedEncodingException var3) {
         throw new RuntimeException(var3);
      }
   }

   public static String makeSHA1Hash(byte[] var0) {
      try {
         MessageDigest var3 = MessageDigest.getInstance("SHA-1");
         var3.update(var0, 0, var0.length);
         String var4 = convertToHex(var3.digest());
         return var4;
      } catch (NoSuchAlgorithmException var5) {
         throw new RuntimeException(var5);
      } catch (UnsupportedEncodingException var6) {
         throw new RuntimeException(var6);
      }
   }

   public static String makeSHA1HashBase64(byte[] var0) {
      try {
         MessageDigest var2 = MessageDigest.getInstance("SHA-1");
         var2.update(var0, 0, var0.length);
         String var3 = Base64.encodeToString(var2.digest(), 11);
         return var3;
      } catch (NoSuchAlgorithmException var4) {
         throw new RuntimeException(var4);
      }
   }
}
