package com.appsflyer;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Map;

public class HashUtils {
   private static String byteToHex(byte[] var0) {
      Formatter var1 = new Formatter();
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         byte var5 = var0[var3];
         Object[] var6 = new Object[]{Byte.valueOf(var5)};
         var1.format("%02x", var6);
      }

      String var4 = var1.toString();
      var1.close();
      return var4;
   }

   public static String toSHA1(String var0) {
      try {
         MessageDigest var3 = MessageDigest.getInstance("SHA-1");
         var3.reset();
         var3.update(var0.getBytes("UTF-8"));
         String var4 = byteToHex(var3.digest());
         return var4;
      } catch (NoSuchAlgorithmException var5) {
         var5.printStackTrace();
         return null;
      } catch (UnsupportedEncodingException var6) {
         var6.printStackTrace();
         return null;
      }
   }

   public String getHashCode(Map<String, String> var1) {
      String var2 = (String)var1.get("appsflyerKey");
      String var3 = (String)var1.get("af_timestamp");
      String var4 = (String)var1.get("uid");
      return toSHA1(var2.substring(0, 7) + var4.substring(0, 7) + var3.substring(-7 + var3.length()));
   }
}
