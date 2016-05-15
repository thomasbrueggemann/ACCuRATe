package com.google.ads.conversiontracking;

// $FF: renamed from: com.google.ads.conversiontracking.s
public final class class_87 {
   // $FF: renamed from: a char[]
   private static final char[] field_606 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
   // $FF: renamed from: b char[]
   private static final char[] field_607 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
   // $FF: renamed from: c byte[]
   private static final byte[] field_608 = new byte[]{(byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-5, (byte)-5, (byte)-9, (byte)-9, (byte)-5, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-5, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)62, (byte)-9, (byte)-9, (byte)-9, (byte)63, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)58, (byte)59, (byte)60, (byte)61, (byte)-9, (byte)-9, (byte)-9, (byte)-1, (byte)-9, (byte)-9, (byte)-9, (byte)0, (byte)1, (byte)2, (byte)3, (byte)4, (byte)5, (byte)6, (byte)7, (byte)8, (byte)9, (byte)10, (byte)11, (byte)12, (byte)13, (byte)14, (byte)15, (byte)16, (byte)17, (byte)18, (byte)19, (byte)20, (byte)21, (byte)22, (byte)23, (byte)24, (byte)25, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)26, (byte)27, (byte)28, (byte)29, (byte)30, (byte)31, (byte)32, (byte)33, (byte)34, (byte)35, (byte)36, (byte)37, (byte)38, (byte)39, (byte)40, (byte)41, (byte)42, (byte)43, (byte)44, (byte)45, (byte)46, (byte)47, (byte)48, (byte)49, (byte)50, (byte)51, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9};
   // $FF: renamed from: d byte[]
   private static final byte[] field_609 = new byte[]{(byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-5, (byte)-5, (byte)-9, (byte)-9, (byte)-5, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-5, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)62, (byte)-9, (byte)-9, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)58, (byte)59, (byte)60, (byte)61, (byte)-9, (byte)-9, (byte)-9, (byte)-1, (byte)-9, (byte)-9, (byte)-9, (byte)0, (byte)1, (byte)2, (byte)3, (byte)4, (byte)5, (byte)6, (byte)7, (byte)8, (byte)9, (byte)10, (byte)11, (byte)12, (byte)13, (byte)14, (byte)15, (byte)16, (byte)17, (byte)18, (byte)19, (byte)20, (byte)21, (byte)22, (byte)23, (byte)24, (byte)25, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)63, (byte)-9, (byte)26, (byte)27, (byte)28, (byte)29, (byte)30, (byte)31, (byte)32, (byte)33, (byte)34, (byte)35, (byte)36, (byte)37, (byte)38, (byte)39, (byte)40, (byte)41, (byte)42, (byte)43, (byte)44, (byte)45, (byte)46, (byte)47, (byte)48, (byte)49, (byte)50, (byte)51, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9};

   // $FF: renamed from: a (byte[], int, int, char[], boolean) java.lang.String
   public static String method_567(byte[] var0, int var1, int var2, char[] var3, boolean var4) {
      char[] var5 = method_569(var0, var1, var2, var3, Integer.MAX_VALUE);

      int var6;
      for(var6 = var5.length; !var4 && var6 > 0 && var5[var6 - 1] == 61; --var6) {
         ;
      }

      return new String(var5, 0, var6);
   }

   // $FF: renamed from: a (byte[], boolean) java.lang.String
   @Deprecated
   public static String method_568(byte[] var0, boolean var1) {
      return method_567(var0, 0, var0.length, field_607, var1);
   }

   // $FF: renamed from: a (byte[], int, int, char[], int) char[]
   static char[] method_569(byte[] var0, int var1, int var2, char[] var3, int var4) {
      int var5 = 4 * ((var2 + 2) / 3);
      char[] var6 = new char[var5 + var5 / var4];
      int var7 = var2 - 2;
      int var8 = 0;
      int var9 = 0;

      int var10;
      int var14;
      for(var10 = 0; var10 < var7; var8 = var14) {
         int var13 = var0[var10 + var1] << 24 >>> 8 | var0[var1 + var10 + 1] << 24 >>> 16 | var0[var1 + var10 + 2] << 24 >>> 24;
         var6[var9] = var3[var13 >>> 18];
         var6[var9 + 1] = var3[63 & var13 >>> 12];
         var6[var9 + 2] = var3[63 & var13 >>> 6];
         var6[var9 + 3] = var3[var13 & 63];
         var14 = var8 + 4;
         if(var14 == var4) {
            var6[var9 + 4] = 10;
            ++var9;
            var14 = 0;
         }

         var10 += 3;
         var9 += 4;
      }

      if(var10 < var2) {
         method_570(var0, var10 + var1, var2 - var10, var6, var9, var3);
         if(var8 + 4 == var4) {
            var6[var9 + 4] = 10;
            ++var9;
         }

         int var10000 = var9 + 4;
      }

      return var6;
   }

   // $FF: renamed from: a (byte[], int, int, char[], int, char[]) char[]
   private static char[] method_570(byte[] var0, int var1, int var2, char[] var3, int var4, char[] var5) {
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

      int var10 = var9 | var8;
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
}
