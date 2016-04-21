package com.google.android.gms.internal;

import com.google.android.gms.internal.class_908;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.pq
public final class class_905 {
    public static final int[] awW = new int[0];
    public static final long[] awX = new long[0];
    public static final float[] awY = new float[0];
    public static final double[] awZ = new double[0];
    public static final boolean[] axa = new boolean[0];
    public static final String[] axb = new String[0];
    public static final byte[][] axc = new byte[0][];
    public static final byte[] axd = new byte[0];

    // $FF: renamed from: b (com.google.android.gms.internal.pf, int) int
    public static final int method_4635(class_908 var0, int var1) throws IOException {
        int var2 = 1;
        int var3 = var0.getPosition();
        var0.method_4649(var1);

        while(var0.method_4655() == var1) {
            var0.method_4649(var1);
            ++var2;
        }

        var0.method_4652(var3);
        return var2;
    }

    // $FF: renamed from: gH (int) int
    static int method_4636(int var0) {
        return var0 & 7;
    }

    // $FF: renamed from: gI (int) int
    public static int method_4637(int var0) {
        return var0 >>> 3;
    }

    // $FF: renamed from: x (int, int) int
    static int method_4638(int var0, int var1) {
        return var1 | var0 << 3;
    }
}
