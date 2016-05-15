package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsm;
import java.io.IOException;

public final class zzsx {
   public static final boolean[] zzbuA = new boolean[0];
   public static final String[] zzbuB = new String[0];
   public static final byte[][] zzbuC = new byte[0][];
   public static final byte[] zzbuD = new byte[0];
   public static final int[] zzbuw = new int[0];
   public static final long[] zzbux = new long[0];
   public static final float[] zzbuy = new float[0];
   public static final double[] zzbuz = new double[0];

   static int zzF(int var0, int var1) {
      return var1 | var0 << 3;
   }

   public static boolean zzb(zzsm var0, int var1) throws IOException {
      return var0.zzmo(var1);
   }

   public static final int zzc(zzsm var0, int var1) throws IOException {
      int var2 = 1;
      int var3 = var0.getPosition();
      var0.zzmo(var1);

      while(var0.zzIX() == var1) {
         var0.zzmo(var1);
         ++var2;
      }

      var0.zzms(var3);
      return var2;
   }

   static int zzmI(int var0) {
      return var0 & 7;
   }

   public static int zzmJ(int var0) {
      return var0 >>> 3;
   }
}
