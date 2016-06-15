package com.smartmobilesoftware.util;

import com.smartmobilesoftware.util.Base64DecoderException;

public class Base64 {
   // $FF: synthetic field
   static final boolean $assertionsDisabled = false;
   private static final byte[] ALPHABET;
   private static final byte[] DECODABET;
   public static final boolean DECODE = false;
   public static final boolean ENCODE = true;
   private static final byte EQUALS_SIGN = 61;
   private static final byte EQUALS_SIGN_ENC = -1;
   private static final byte NEW_LINE = 10;
   private static final byte[] WEBSAFE_ALPHABET;
   private static final byte[] WEBSAFE_DECODABET;
   private static final byte WHITE_SPACE_ENC = -5;

   static {
      boolean var0;
      if(!Base64.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
      ALPHABET = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)43, (byte)47};
      WEBSAFE_ALPHABET = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)45, (byte)95};
      DECODABET = new byte[]{(byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-5, (byte)-5, (byte)-9, (byte)-9, (byte)-5, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-5, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)62, (byte)-9, (byte)-9, (byte)-9, (byte)63, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)58, (byte)59, (byte)60, (byte)61, (byte)-9, (byte)-9, (byte)-9, (byte)-1, (byte)-9, (byte)-9, (byte)-9, (byte)0, (byte)1, (byte)2, (byte)3, (byte)4, (byte)5, (byte)6, (byte)7, (byte)8, (byte)9, (byte)10, (byte)11, (byte)12, (byte)13, (byte)14, (byte)15, (byte)16, (byte)17, (byte)18, (byte)19, (byte)20, (byte)21, (byte)22, (byte)23, (byte)24, (byte)25, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)26, (byte)27, (byte)28, (byte)29, (byte)30, (byte)31, (byte)32, (byte)33, (byte)34, (byte)35, (byte)36, (byte)37, (byte)38, (byte)39, (byte)40, (byte)41, (byte)42, (byte)43, (byte)44, (byte)45, (byte)46, (byte)47, (byte)48, (byte)49, (byte)50, (byte)51, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9};
      WEBSAFE_DECODABET = new byte[]{(byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-5, (byte)-5, (byte)-9, (byte)-9, (byte)-5, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-5, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)62, (byte)-9, (byte)-9, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)58, (byte)59, (byte)60, (byte)61, (byte)-9, (byte)-9, (byte)-9, (byte)-1, (byte)-9, (byte)-9, (byte)-9, (byte)0, (byte)1, (byte)2, (byte)3, (byte)4, (byte)5, (byte)6, (byte)7, (byte)8, (byte)9, (byte)10, (byte)11, (byte)12, (byte)13, (byte)14, (byte)15, (byte)16, (byte)17, (byte)18, (byte)19, (byte)20, (byte)21, (byte)22, (byte)23, (byte)24, (byte)25, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)63, (byte)-9, (byte)26, (byte)27, (byte)28, (byte)29, (byte)30, (byte)31, (byte)32, (byte)33, (byte)34, (byte)35, (byte)36, (byte)37, (byte)38, (byte)39, (byte)40, (byte)41, (byte)42, (byte)43, (byte)44, (byte)45, (byte)46, (byte)47, (byte)48, (byte)49, (byte)50, (byte)51, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9};
   }

   public static byte[] decode(String var0) throws Base64DecoderException {
      byte[] var1 = var0.getBytes();
      return decode(var1, 0, var1.length);
   }

   public static byte[] decode(byte[] var0) throws Base64DecoderException {
      return decode(var0, 0, var0.length);
   }

   public static byte[] decode(byte[] var0, int var1, int var2) throws Base64DecoderException {
      return decode(var0, var1, var2, DECODABET);
   }

   public static byte[] decode(byte[] var0, int var1, int var2, byte[] var3) throws Base64DecoderException {
      byte[] var4 = new byte[2 + var2 * 3 / 4];
      int var5 = 0;
      byte[] var6 = new byte[4];
      int var7 = 0;

      int var8;
      int var14;
      for(var8 = 0; var7 < var2; var8 = var14) {
         byte var12 = (byte)(127 & var0[var7 + var1]);
         byte var13 = var3[var12];
         if(var13 < -5) {
            throw new Base64DecoderException("Bad Base64 input character at " + var7 + ": " + var0[var7 + var1] + "(decimal)");
         }

         if(var13 >= -1) {
            if(var12 == 61) {
               int var15 = var2 - var7;
               byte var16 = (byte)(127 & var0[var1 + (var2 - 1)]);
               if(var8 != 0 && var8 != 1) {
                  if(var8 == 3 && var15 > 2 || var8 == 4 && var15 > 1) {
                     throw new Base64DecoderException("padding byte \'=\' falsely signals end of encoded value at offset " + var7);
                  }

                  if(var16 != 61 && var16 != 10) {
                     throw new Base64DecoderException("encoded value has invalid trailing byte");
                  }
                  break;
               }

               throw new Base64DecoderException("invalid padding byte \'=\' at byte offset " + var7);
            }

            var14 = var8 + 1;
            var6[var8] = var12;
            if(var14 == 4) {
               var5 += decode4to3(var6, 0, var4, var5, var3);
               var14 = 0;
            }
         } else {
            var14 = var8;
         }

         ++var7;
      }

      if(var8 != 0) {
         if(var8 == 1) {
            throw new Base64DecoderException("single trailing character at offset " + (var2 - 1));
         }

         int var10000 = var8 + 1;
         var6[var8] = 61;
         var5 += decode4to3(var6, 0, var4, var5, var3);
      }

      byte[] var10 = new byte[var5];
      System.arraycopy(var4, 0, var10, 0, var5);
      return var10;
   }

   private static int decode4to3(byte[] var0, int var1, byte[] var2, int var3, byte[] var4) {
      if(var0[var1 + 2] == 61) {
         var2[var3] = (byte)((var4[var0[var1]] << 24 >>> 6 | var4[var0[var1 + 1]] << 24 >>> 12) >>> 16);
         return 1;
      } else if(var0[var1 + 3] == 61) {
         int var6 = var4[var0[var1]] << 24 >>> 6 | var4[var0[var1 + 1]] << 24 >>> 12 | var4[var0[var1 + 2]] << 24 >>> 18;
         var2[var3] = (byte)(var6 >>> 16);
         var2[var3 + 1] = (byte)(var6 >>> 8);
         return 2;
      } else {
         int var5 = var4[var0[var1]] << 24 >>> 6 | var4[var0[var1 + 1]] << 24 >>> 12 | var4[var0[var1 + 2]] << 24 >>> 18 | var4[var0[var1 + 3]] << 24 >>> 24;
         var2[var3] = (byte)(var5 >> 16);
         var2[var3 + 1] = (byte)(var5 >> 8);
         var2[var3 + 2] = (byte)var5;
         return 3;
      }
   }

   public static byte[] decodeWebSafe(String var0) throws Base64DecoderException {
      byte[] var1 = var0.getBytes();
      return decodeWebSafe(var1, 0, var1.length);
   }

   public static byte[] decodeWebSafe(byte[] var0) throws Base64DecoderException {
      return decodeWebSafe(var0, 0, var0.length);
   }

   public static byte[] decodeWebSafe(byte[] var0, int var1, int var2) throws Base64DecoderException {
      return decode(var0, var1, var2, WEBSAFE_DECODABET);
   }

   public static String encode(byte[] var0) {
      return encode(var0, 0, var0.length, ALPHABET, true);
   }

   public static String encode(byte[] var0, int var1, int var2, byte[] var3, boolean var4) {
      byte[] var5 = encode(var0, var1, var2, var3, Integer.MAX_VALUE);

      int var6;
      for(var6 = var5.length; !var4 && var6 > 0 && var5[var6 - 1] == 61; --var6) {
         ;
      }

      return new String(var5, 0, var6);
   }

   public static byte[] encode(byte[] var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = 4 * ((var2 + 2) / 3);
      byte[] var6 = new byte[var5 + var5 / var4];
      int var7 = 0;
      int var8 = 0;
      int var9 = var2 - 2;

      int var10;
      for(var10 = 0; var7 < var9; var8 += 4) {
         int var12 = var0[var7 + var1] << 24 >>> 8 | var0[var1 + var7 + 1] << 24 >>> 16 | var0[var1 + var7 + 2] << 24 >>> 24;
         var6[var8] = var3[var12 >>> 18];
         var6[var8 + 1] = var3[63 & var12 >>> 12];
         var6[var8 + 2] = var3[63 & var12 >>> 6];
         var6[var8 + 3] = var3[var12 & 63];
         var10 += 4;
         if(var10 == var4) {
            var6[var8 + 4] = 10;
            ++var8;
            var10 = 0;
         }

         var7 += 3;
      }

      if(var7 < var2) {
         encode3to4(var0, var7 + var1, var2 - var7, var6, var8, var3);
         if(var10 + 4 == var4) {
            var6[var8 + 4] = 10;
            ++var8;
         }

         var8 += 4;
      }

      if(!$assertionsDisabled && var8 != var6.length) {
         throw new AssertionError();
      } else {
         return var6;
      }
   }

   private static byte[] encode3to4(byte[] var0, int var1, int var2, byte[] var3, int var4, byte[] var5) {
      int var6;
      if(var2 > 0) {
         var6 = var0[var1] << 24 >>> 8;
      } else {
         var6 = 0;
      }

      int var7;
      if(var2 > 1) {
         var7 = var0[var1 + 1] << 24 >>> 16;
      } else {
         var7 = 0;
      }

      int var8 = var7 | var6;
      int var9 = 0;
      if(var2 > 2) {
         var9 = var0[var1 + 2] << 24 >>> 24;
      }

      int var10 = var8 | var9;
      switch(var2) {
      case 1:
         var3[var4] = var5[var10 >>> 18];
         var3[var4 + 1] = var5[63 & var10 >>> 12];
         var3[var4 + 2] = 61;
         var3[var4 + 3] = 61;
         return var3;
      case 2:
         var3[var4] = var5[var10 >>> 18];
         var3[var4 + 1] = var5[63 & var10 >>> 12];
         var3[var4 + 2] = var5[63 & var10 >>> 6];
         var3[var4 + 3] = 61;
         return var3;
      case 3:
         var3[var4] = var5[var10 >>> 18];
         var3[var4 + 1] = var5[63 & var10 >>> 12];
         var3[var4 + 2] = var5[63 & var10 >>> 6];
         var3[var4 + 3] = var5[var10 & 63];
         return var3;
      default:
         return var3;
      }
   }

   public static String encodeWebSafe(byte[] var0, boolean var1) {
      return encode(var0, 0, var0.length, WEBSAFE_ALPHABET, var1);
   }
}
