package com.google.android.gms.internal;

import com.google.android.gms.internal.class_827;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.qz
public final class class_822 {
   public static final int[] azj = new int[0];
   public static final long[] azk = new long[0];
   public static final float[] azl = new float[0];
   public static final double[] azm = new double[0];
   public static final boolean[] azn = new boolean[0];
   public static final String[] azo = new String[0];
   public static final byte[][] azp = new byte[0][];
   public static final byte[] azq = new byte[0];

   // $FF: renamed from: b (com.google.android.gms.internal.qo, int) int
   public static final int method_4484(class_827 var0, int var1) throws IOException {
      int var2 = 1;
      int var3 = var0.getPosition();
      var0.method_4566(var1);

      while(var0.method_4585() == var1) {
         var0.method_4566(var1);
         ++var2;
      }

      var0.method_4569(var3);
      return var2;
   }

   // $FF: renamed from: hk (int) int
   static int method_4485(int var0) {
      return var0 & 7;
   }

   // $FF: renamed from: hl (int) int
   public static int method_4486(int var0) {
      return var0 >>> 3;
   }

   // $FF: renamed from: y (int, int) int
   static int method_4487(int var0, int var1) {
      return var1 | var0 << 3;
   }
}
