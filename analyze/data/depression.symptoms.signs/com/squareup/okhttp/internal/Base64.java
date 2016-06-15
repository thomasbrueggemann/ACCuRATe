package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.Util;
import java.io.UnsupportedEncodingException;

public final class Base64 {
   private static final byte[] MAP = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)43, (byte)47};

   public static byte[] decode(byte[] var0) {
      return decode(var0, var0.length);
   }

   public static byte[] decode(byte[] var0, int var1) {
      int var2 = 3 * (var1 / 4);
      if(var2 == 0) {
         return Util.EMPTY_BYTE_ARRAY;
      } else {
         byte[] var3 = new byte[var2];
         int var4 = 0;

         while(true) {
            byte var5 = var0[var1 - 1];
            if(var5 != 10 && var5 != 13 && var5 != 32 && var5 != 9) {
               if(var5 != 61) {
                  int var6 = 0;
                  int var7 = 0;
                  int var8 = 0;

                  int var9;
                  int var14;
                  for(var9 = 0; var8 < var1; var9 = var14) {
                     byte var13 = var0[var8];
                     if(var13 != 10 && var13 != 13 && var13 != 32) {
                        if(var13 == 9) {
                           var14 = var9;
                        } else {
                           int var15;
                           if(var13 >= 65 && var13 <= 90) {
                              var15 = var13 - 65;
                           } else if(var13 >= 97 && var13 <= 122) {
                              var15 = var13 - 71;
                           } else if(var13 >= 48 && var13 <= 57) {
                              var15 = var13 + 4;
                           } else if(var13 == 43) {
                              var15 = 62;
                           } else {
                              if(var13 != 47) {
                                 return null;
                              }

                              var15 = 63;
                           }

                           var7 = var7 << 6 | (byte)var15;
                           if(var6 % 4 == 3) {
                              int var16 = var9 + 1;
                              var3[var9] = (byte)(var7 >> 16);
                              int var17 = var16 + 1;
                              var3[var16] = (byte)(var7 >> 8);
                              var14 = var17 + 1;
                              var3[var17] = (byte)var7;
                           } else {
                              var14 = var9;
                           }

                           ++var6;
                        }
                     } else {
                        var14 = var9;
                     }

                     ++var8;
                  }

                  int var10;
                  label57: {
                     if(var4 > 0) {
                        int var12 = var7 << var4 * 6;
                        var10 = var9 + 1;
                        var3[var9] = (byte)(var12 >> 16);
                        if(var4 != 1) {
                           break label57;
                        }

                        var9 = var10 + 1;
                        var3[var10] = (byte)(var12 >> 8);
                     }

                     var10 = var9;
                  }

                  byte[] var11 = new byte[var10];
                  System.arraycopy(var3, 0, var11, 0, var10);
                  return var11;
               }

               ++var4;
            }

            --var1;
         }
      }
   }

   public static String encode(byte[] var0) {
      byte[] var1 = new byte[4 * (2 + var0.length) / 3];
      int var2 = var0.length - var0.length % 3;
      int var3 = 0;

      int var4;
      for(var4 = 0; var3 < var2; var3 += 3) {
         int var15 = var4 + 1;
         var1[var4] = MAP[(255 & var0[var3]) >> 2];
         int var16 = var15 + 1;
         var1[var15] = MAP[(3 & var0[var3]) << 4 | (255 & var0[var3 + 1]) >> 4];
         int var17 = var16 + 1;
         var1[var16] = MAP[(15 & var0[var3 + 1]) << 2 | (255 & var0[var3 + 2]) >> 6];
         var4 = var17 + 1;
         var1[var17] = MAP[63 & var0[var3 + 2]];
      }

      int var8;
      switch(var0.length % 3) {
      case 1:
         int var11 = var4 + 1;
         var1[var4] = MAP[(255 & var0[var2]) >> 2];
         int var12 = var11 + 1;
         var1[var11] = MAP[(3 & var0[var2]) << 4];
         int var13 = var12 + 1;
         var1[var12] = 61;
         int var14 = var13 + 1;
         var1[var13] = 61;
         var8 = var14;
         break;
      case 2:
         int var5 = var4 + 1;
         var1[var4] = MAP[(255 & var0[var2]) >> 2];
         int var6 = var5 + 1;
         var1[var5] = MAP[(3 & var0[var2]) << 4 | (255 & var0[var2 + 1]) >> 4];
         int var7 = var6 + 1;
         var1[var6] = MAP[(15 & var0[var2 + 1]) << 2];
         var4 = var7 + 1;
         var1[var7] = 61;
      default:
         var8 = var4;
      }

      try {
         String var9 = new String(var1, 0, var8, "US-ASCII");
         return var9;
      } catch (UnsupportedEncodingException var18) {
         throw new AssertionError(var18);
      }
   }
}
