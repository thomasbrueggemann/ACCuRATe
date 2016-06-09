package com.facebook.common.util;

public class Hex {
   private static final byte[] DIGITS;
   private static final char[] FIRST_CHAR = new char[256];
   private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
   private static final char[] SECOND_CHAR = new char[256];

   static {
      for(int var0 = 0; var0 < 256; ++var0) {
         FIRST_CHAR[var0] = HEX_DIGITS[15 & var0 >> 4];
         SECOND_CHAR[var0] = HEX_DIGITS[var0 & 15];
      }

      DIGITS = new byte[103];

      for(int var1 = 0; var1 <= 70; ++var1) {
         DIGITS[var1] = -1;
      }

      for(byte var2 = 0; var2 < 10; DIGITS[var2 + 48] = var2++) {
         ;
      }

      for(byte var3 = 0; var3 < 6; ++var3) {
         DIGITS[var3 + 65] = (byte)(var3 + 10);
         DIGITS[var3 + 97] = (byte)(var3 + 10);
      }

   }

   public static String byte2Hex(int var0) {
      if(var0 <= 255 && var0 >= 0) {
         return FIRST_CHAR[var0] + String.valueOf(SECOND_CHAR[var0]);
      } else {
         throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
      }
   }

   public static byte[] decodeHex(String var0) {
      int var1 = var0.length();
      if((var1 & 1) != 0) {
         throw new IllegalArgumentException("Odd number of characters.");
      } else {
         byte[] var2 = new byte[var1 >> 1];
         int var3 = 0;
         int var4 = 0;

         boolean var6;
         while(true) {
            if(var4 >= var1) {
               var6 = false;
               break;
            }

            int var7 = var4 + 1;
            char var8 = var0.charAt(var4);
            if(var8 > 102) {
               var6 = true;
               break;
            }

            byte var9 = DIGITS[var8];
            if(var9 == -1) {
               var6 = true;
               break;
            }

            var4 = var7 + 1;
            char var10 = var0.charAt(var7);
            if(var10 > 102) {
               var6 = true;
               break;
            }

            byte var11 = DIGITS[var10];
            if(var11 == -1) {
               var6 = true;
               break;
            }

            var2[var3] = (byte)(var11 | var9 << 4);
            ++var3;
         }

         if(var6) {
            throw new IllegalArgumentException("Invalid hexadecimal digit: " + var0);
         } else {
            return var2;
         }
      }
   }

   public static String encodeHex(byte[] var0, boolean var1) {
      char[] var2 = new char[2 * var0.length];
      int var3 = 0;

      for(int var4 = 0; var4 < var0.length; ++var4) {
         int var5 = 255 & var0[var4];
         if(var5 == 0 && var1) {
            break;
         }

         int var6 = var3 + 1;
         var2[var3] = FIRST_CHAR[var5];
         var3 = var6 + 1;
         var2[var6] = SECOND_CHAR[var5];
      }

      return new String(var2, 0, var3);
   }

   public static byte[] hexStringToByteArray(String var0) {
      return decodeHex(var0.replaceAll(" ", ""));
   }
}
