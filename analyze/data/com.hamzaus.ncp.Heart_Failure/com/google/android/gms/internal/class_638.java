package com.google.android.gms.internal;

import com.google.android.gms.internal.class_605;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.mi
public final class class_638 {
   public static final int[] ana = new int[0];
   public static final long[] anb = new long[0];
   public static final float[] anc = new float[0];
   public static final double[] and = new double[0];
   public static final boolean[] ane = new boolean[0];
   public static final String[] anf = new String[0];
   public static final byte[][] ang = new byte[0][];
   public static final byte[] anh = new byte[0];

   // $FF: renamed from: b (com.google.android.gms.internal.lz, int) int
   public static final int method_3656(class_605 var0, int var1) throws IOException {
      int var2 = 1;
      int var3 = var0.getPosition();
      var0.method_3556(var1);

      while(var0.method_3567() > 0 && var0.method_3570() == var1) {
         var0.method_3556(var1);
         ++var2;
      }

      var0.method_3559(var3);
      return var2;
   }

   // $FF: renamed from: eN (int) int
   static int method_3657(int var0) {
      return var0 & 7;
   }

   // $FF: renamed from: eO (int) int
   public static int method_3658(int var0) {
      return var0 >>> 3;
   }

   // $FF: renamed from: u (int, int) int
   static int method_3659(int var0, int var1) {
      return var1 | var0 << 3;
   }
}
