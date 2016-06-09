package com.comscore.utils;

public class Base64Coder {
   // $FF: renamed from: a char[]
   private static char[] field_134 = new char[64];
   // $FF: renamed from: b byte[]
   private static byte[] field_135;

   static {
      char var0 = 65;

      int var1;
      int var16;
      for(var1 = 0; var0 <= 90; var1 = var16) {
         char[] var15 = field_134;
         var16 = var1 + 1;
         var15[var1] = var0++;
      }

      int var14;
      for(char var2 = 97; var2 <= 122; var1 = var14) {
         char[] var13 = field_134;
         var14 = var1 + 1;
         var13[var1] = var2++;
      }

      int var12;
      for(char var3 = 48; var3 <= 57; var1 = var12) {
         char[] var11 = field_134;
         var12 = var1 + 1;
         var11[var1] = var3++;
      }

      char[] var4 = field_134;
      int var5 = var1 + 1;
      var4[var1] = 43;
      char[] var6 = field_134;
      int var10000 = var5 + 1;
      var6[var5] = 47;
      field_135 = new byte[128];
      int var8 = 0;

      while(true) {
         int var9 = field_135.length;
         int var10 = 0;
         if(var8 >= var9) {
            while(var10 < 64) {
               field_135[field_134[var10]] = (byte)var10;
               ++var10;
            }

            return;
         }

         field_135[var8] = -1;
         ++var8;
      }
   }

   public static byte[] decode(String var0) {
      return decode(var0.toCharArray());
   }

   public static byte[] decode(char[] var0) {
      int var1 = 0;
      int var2 = var0.length;
      if(var2 % 4 != 0) {
         throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
      } else {
         int var3;
         for(var3 = var2; var3 > 0 && var0[var3 - 1] == 61; --var3) {
            ;
         }

         int var4 = var3 * 3 / 4;
         byte[] var5 = new byte[var4];
         int var6 = 0;

         while(var1 < var3) {
            int var7 = var1 + 1;
            char var8 = var0[var1];
            int var9 = var7 + 1;
            char var10 = var0[var7];
            char var11;
            if(var9 < var3) {
               int var25 = var9 + 1;
               var11 = var0[var9];
               var9 = var25;
            } else {
               var11 = 65;
            }

            int var12;
            char var13;
            if(var9 < var3) {
               int var24 = var9 + 1;
               var13 = var0[var9];
               var12 = var24;
            } else {
               var12 = var9;
               var13 = 65;
            }

            if(var8 <= 127 && var10 <= 127 && var11 <= 127 && var13 <= 127) {
               byte var14 = field_135[var8];
               byte var15 = field_135[var10];
               byte var16 = field_135[var11];
               byte var17 = field_135[var13];
               if(var14 >= 0 && var15 >= 0 && var16 >= 0 && var17 >= 0) {
                  int var18 = var14 << 2 | var15 >>> 4;
                  int var19 = (var15 & 15) << 4 | var16 >>> 2;
                  int var20 = var17 | (var16 & 3) << 6;
                  int var21 = var6 + 1;
                  var5[var6] = (byte)var18;
                  int var22;
                  if(var21 < var4) {
                     var22 = var21 + 1;
                     var5[var21] = (byte)var19;
                  } else {
                     var22 = var21;
                  }

                  int var23;
                  if(var22 < var4) {
                     var23 = var22 + 1;
                     var5[var22] = (byte)var20;
                  } else {
                     var23 = var22;
                  }

                  var6 = var23;
                  var1 = var12;
                  continue;
               }

               throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }

            throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
         }

         return var5;
      }
   }

   public static String decodeString(String var0) {
      return new String(decode(var0));
   }

   public static char[] encode(byte[] var0) {
      return encode(var0, var0.length);
   }

   public static char[] encode(byte[] var0, int var1) {
      int var2 = (2 + var1 * 4) / 3;
      char[] var3 = new char[4 * ((var1 + 2) / 3)];
      int var4 = 0;

      int var17;
      for(int var5 = 0; var5 < var1; var4 = var17 + 1) {
         int var6 = var5 + 1;
         int var7 = 255 & var0[var5];
         int var8;
         if(var6 < var1) {
            int var19 = var6 + 1;
            var8 = 255 & var0[var6];
            var6 = var19;
         } else {
            var8 = 0;
         }

         int var9;
         if(var6 < var1) {
            var5 = var6 + 1;
            var9 = 255 & var0[var6];
         } else {
            var5 = var6;
            var9 = 0;
         }

         int var10 = var7 >>> 2;
         int var11 = (var7 & 3) << 4 | var8 >>> 4;
         int var12 = (var8 & 15) << 2 | var9 >>> 6;
         int var13 = var9 & 63;
         int var14 = var4 + 1;
         var3[var4] = field_134[var10];
         int var15 = var14 + 1;
         var3[var14] = field_134[var11];
         char var16;
         if(var15 < var2) {
            var16 = field_134[var12];
         } else {
            var16 = 61;
         }

         var3[var15] = var16;
         var17 = var15 + 1;
         char var18;
         if(var17 < var2) {
            var18 = field_134[var13];
         } else {
            var18 = 61;
         }

         var3[var17] = var18;
      }

      return var3;
   }

   public static String encodeString(String var0) {
      return new String(encode(var0.getBytes()));
   }
}
