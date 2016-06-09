package com.koushikdutta.async.http.libcore;

import java.nio.ByteOrder;

public final class Memory {
   public static native void memmove(Object var0, int var1, Object var2, int var3, long var4);

   public static native byte peekByte(int var0);

   public static native void peekByteArray(int var0, byte[] var1, int var2, int var3);

   public static native void peekCharArray(int var0, char[] var1, int var2, int var3, boolean var4);

   public static native void peekDoubleArray(int var0, double[] var1, int var2, int var3, boolean var4);

   public static native void peekFloatArray(int var0, float[] var1, int var2, int var3, boolean var4);

   public static native int peekInt(int var0, boolean var1);

   public static int peekInt(byte[] var0, int var1, ByteOrder var2) {
      if(var2 == ByteOrder.BIG_ENDIAN) {
         int var8 = var1 + 1;
         int var9 = (255 & var0[var1]) << 24;
         int var10 = var8 + 1;
         int var11 = var9 | (255 & var0[var8]) << 16;
         int var12 = var10 + 1;
         return var11 | (255 & var0[var10]) << 8 | (255 & var0[var12]) << 0;
      } else {
         int var3 = var1 + 1;
         int var4 = (255 & var0[var1]) << 0;
         int var5 = var3 + 1;
         int var6 = var4 | (255 & var0[var3]) << 8;
         int var7 = var5 + 1;
         return var6 | (255 & var0[var5]) << 16 | (255 & var0[var7]) << 24;
      }
   }

   public static native void peekIntArray(int var0, int[] var1, int var2, int var3, boolean var4);

   public static native long peekLong(int var0, boolean var1);

   public static long peekLong(byte[] var0, int var1, ByteOrder var2) {
      if(var2 == ByteOrder.BIG_ENDIAN) {
         int var16 = var1 + 1;
         int var17 = (255 & var0[var1]) << 24;
         int var18 = var16 + 1;
         int var19 = var17 | (255 & var0[var16]) << 16;
         int var20 = var18 + 1;
         int var21 = var19 | (255 & var0[var18]) << 8;
         int var22 = var20 + 1;
         int var23 = var21 | (255 & var0[var20]) << 0;
         int var24 = var22 + 1;
         int var25 = (255 & var0[var22]) << 24;
         int var26 = var24 + 1;
         int var27 = var25 | (255 & var0[var24]) << 16;
         int var28 = var26 + 1;
         int var29 = var27 | (255 & var0[var26]) << 8 | (255 & var0[var28]) << 0;
         return (long)var23 << 32 | 4294967295L & (long)var29;
      } else {
         int var3 = var1 + 1;
         int var4 = (255 & var0[var1]) << 0;
         int var5 = var3 + 1;
         int var6 = var4 | (255 & var0[var3]) << 8;
         int var7 = var5 + 1;
         int var8 = var6 | (255 & var0[var5]) << 16;
         int var9 = var7 + 1;
         int var10 = var8 | (255 & var0[var7]) << 24;
         int var11 = var9 + 1;
         int var12 = (255 & var0[var9]) << 0;
         int var13 = var11 + 1;
         int var14 = var12 | (255 & var0[var11]) << 8;
         int var15 = var13 + 1;
         return (long)(var14 | (255 & var0[var13]) << 16 | (255 & var0[var15]) << 24) << 32 | 4294967295L & (long)var10;
      }
   }

   public static native void peekLongArray(int var0, long[] var1, int var2, int var3, boolean var4);

   public static native short peekShort(int var0, boolean var1);

   public static short peekShort(byte[] var0, int var1, ByteOrder var2) {
      return var2 == ByteOrder.BIG_ENDIAN?(short)(var0[var1] << 8 | 255 & var0[var1 + 1]):(short)(var0[var1 + 1] << 8 | 255 & var0[var1]);
   }

   public static native void peekShortArray(int var0, short[] var1, int var2, int var3, boolean var4);

   public static native void pokeByte(int var0, byte var1);

   public static native void pokeByteArray(int var0, byte[] var1, int var2, int var3);

   public static native void pokeCharArray(int var0, char[] var1, int var2, int var3, boolean var4);

   public static native void pokeDoubleArray(int var0, double[] var1, int var2, int var3, boolean var4);

   public static native void pokeFloatArray(int var0, float[] var1, int var2, int var3, boolean var4);

   public static native void pokeInt(int var0, int var1, boolean var2);

   public static void pokeInt(byte[] var0, int var1, int var2, ByteOrder var3) {
      if(var3 == ByteOrder.BIG_ENDIAN) {
         int var7 = var1 + 1;
         var0[var1] = (byte)(255 & var2 >> 24);
         int var8 = var7 + 1;
         var0[var7] = (byte)(255 & var2 >> 16);
         int var9 = var8 + 1;
         var0[var8] = (byte)(255 & var2 >> 8);
         var0[var9] = (byte)(255 & var2 >> 0);
      } else {
         int var4 = var1 + 1;
         var0[var1] = (byte)(255 & var2 >> 0);
         int var5 = var4 + 1;
         var0[var4] = (byte)(255 & var2 >> 8);
         int var6 = var5 + 1;
         var0[var5] = (byte)(255 & var2 >> 16);
         var0[var6] = (byte)(255 & var2 >> 24);
      }
   }

   public static native void pokeIntArray(int var0, int[] var1, int var2, int var3, boolean var4);

   public static native void pokeLong(int var0, long var1, boolean var3);

   public static void pokeLong(byte[] var0, int var1, long var2, ByteOrder var4) {
      if(var4 == ByteOrder.BIG_ENDIAN) {
         int var14 = (int)(var2 >> 32);
         int var15 = var1 + 1;
         var0[var1] = (byte)(255 & var14 >> 24);
         int var16 = var15 + 1;
         var0[var15] = (byte)(255 & var14 >> 16);
         int var17 = var16 + 1;
         var0[var16] = (byte)(255 & var14 >> 8);
         int var18 = var17 + 1;
         var0[var17] = (byte)(255 & var14 >> 0);
         int var19 = (int)var2;
         int var20 = var18 + 1;
         var0[var18] = (byte)(255 & var19 >> 24);
         int var21 = var20 + 1;
         var0[var20] = (byte)(255 & var19 >> 16);
         int var22 = var21 + 1;
         var0[var21] = (byte)(255 & var19 >> 8);
         var0[var22] = (byte)(255 & var19 >> 0);
      } else {
         int var5 = (int)var2;
         int var6 = var1 + 1;
         var0[var1] = (byte)(255 & var5 >> 0);
         int var7 = var6 + 1;
         var0[var6] = (byte)(255 & var5 >> 8);
         int var8 = var7 + 1;
         var0[var7] = (byte)(255 & var5 >> 16);
         int var9 = var8 + 1;
         var0[var8] = (byte)(255 & var5 >> 24);
         int var10 = (int)(var2 >> 32);
         int var11 = var9 + 1;
         var0[var9] = (byte)(255 & var10 >> 0);
         int var12 = var11 + 1;
         var0[var11] = (byte)(255 & var10 >> 8);
         int var13 = var12 + 1;
         var0[var12] = (byte)(255 & var10 >> 16);
         var0[var13] = (byte)(255 & var10 >> 24);
      }
   }

   public static native void pokeLongArray(int var0, long[] var1, int var2, int var3, boolean var4);

   public static native void pokeShort(int var0, short var1, boolean var2);

   public static void pokeShort(byte[] var0, int var1, short var2, ByteOrder var3) {
      if(var3 == ByteOrder.BIG_ENDIAN) {
         int var5 = var1 + 1;
         var0[var1] = (byte)(255 & var2 >> 8);
         var0[var5] = (byte)(255 & var2 >> 0);
      } else {
         int var4 = var1 + 1;
         var0[var1] = (byte)(255 & var2 >> 0);
         var0[var4] = (byte)(255 & var2 >> 8);
      }
   }

   public static native void pokeShortArray(int var0, short[] var1, int var2, int var3, boolean var4);

   public static native void unsafeBulkGet(Object var0, int var1, int var2, byte[] var3, int var4, int var5, boolean var6);

   public static native void unsafeBulkPut(byte[] var0, int var1, int var2, Object var3, int var4, int var5, boolean var6);
}
