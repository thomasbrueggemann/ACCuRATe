package com.mobileapptracker;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MATUtils {
   public static String bytesToHex(byte[] var0) {
      String var2;
      if(var0 == null) {
         var2 = null;
      } else {
         int var1 = var0.length;
         var2 = "";

         for(int var3 = 0; var3 < var1; ++var3) {
            if((255 & var0[var3]) < 16) {
               var2 = var2 + "0" + Integer.toHexString(255 & var0[var3]);
            } else {
               var2 = var2 + Integer.toHexString(255 & var0[var3]);
            }
         }
      }

      return var2;
   }

   public static boolean getBooleanFromSharedPreferences(Context var0, String var1) {
      synchronized(MATUtils.class){}
      boolean var8 = false;

      boolean var4;
      label40: {
         boolean var5;
         label39: {
            try {
               var8 = true;
               var5 = var0.getSharedPreferences("com.mobileapptracking", 0).getBoolean(var1, false);
               var8 = false;
               break label39;
            } catch (ClassCastException var9) {
               var8 = false;
            } finally {
               if(var8) {
                  ;
               }
            }

            var4 = false;
            break label40;
         }

         var4 = var5;
      }

      return var4;
   }

   public static String getStringFromSharedPreferences(Context var0, String var1) {
      synchronized(MATUtils.class){}
      boolean var8 = false;

      String var4;
      label40: {
         String var5;
         label39: {
            try {
               var8 = true;
               var5 = var0.getSharedPreferences("com.mobileapptracking", 0).getString(var1, "");
               var8 = false;
               break label39;
            } catch (ClassCastException var9) {
               var8 = false;
            } finally {
               if(var8) {
                  ;
               }
            }

            var4 = "";
            break label40;
         }

         var4 = var5;
      }

      return var4;
   }

   public static byte[] hexToBytes(String var0) {
      byte[] var1 = null;
      if(var0 != null) {
         int var2 = var0.length();
         var1 = null;
         if(var2 >= 2) {
            int var3 = var0.length() / 2;
            var1 = new byte[var3];

            for(int var4 = 0; var4 < var3; ++var4) {
               var1[var4] = (byte)Integer.parseInt(var0.substring(var4 * 2, 2 + var4 * 2), 16);
            }
         }
      }

      return var1;
   }

   public static String md5(String var0) {
      if(var0 == null) {
         return "";
      } else {
         try {
            MessageDigest var2 = MessageDigest.getInstance("MD5");
            var2.update(var0.getBytes());
            String var3 = bytesToHex(var2.digest());
            return var3;
         } catch (NoSuchAlgorithmException var4) {
            var4.printStackTrace();
            return "";
         }
      }
   }

   public static String readStream(InputStream var0) throws IOException, UnsupportedEncodingException {
      if(var0 == null) {
         return "";
      } else {
         BufferedReader var1 = new BufferedReader(new InputStreamReader(var0, "UTF-8"));
         StringBuilder var2 = new StringBuilder();

         while(true) {
            String var3 = var1.readLine();
            if(var3 == null) {
               var1.close();
               return var2.toString();
            }

            var2.append(var3).append("\n");
         }
      }
   }

   public static void saveToSharedPreferences(Context var0, String var1, String var2) {
      synchronized(MATUtils.class){}

      try {
         var0.getSharedPreferences("com.mobileapptracking", 0).edit().putString(var1, var2).commit();
      } finally {
         ;
      }

   }

   public static void saveToSharedPreferences(Context var0, String var1, boolean var2) {
      synchronized(MATUtils.class){}

      try {
         var0.getSharedPreferences("com.mobileapptracking", 0).edit().putBoolean(var1, var2).commit();
      } finally {
         ;
      }

   }

   public static String sha1(String var0) {
      if(var0 == null) {
         return "";
      } else {
         try {
            MessageDigest var2 = MessageDigest.getInstance("SHA-1");
            var2.update(var0.getBytes());
            String var3 = bytesToHex(var2.digest());
            return var3;
         } catch (NoSuchAlgorithmException var4) {
            var4.printStackTrace();
            return "";
         }
      }
   }

   public static String sha256(String var0) {
      if(var0 == null) {
         return "";
      } else {
         try {
            MessageDigest var2 = MessageDigest.getInstance("SHA-256");
            var2.update(var0.getBytes());
            String var3 = bytesToHex(var2.digest());
            return var3;
         } catch (NoSuchAlgorithmException var4) {
            var4.printStackTrace();
            return "";
         }
      }
   }
}
