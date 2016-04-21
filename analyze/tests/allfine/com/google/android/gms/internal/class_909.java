package com.google.android.gms.internal;

import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_905;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

// $FF: renamed from: com.google.android.gms.internal.pg
public final class class_909 {
    private final int awI;
    private final byte[] buffer;
    private int position;

    private class_909(byte[] var1, int var2, int var3) {
        this.buffer = var1;
        this.position = var2;
        this.awI = var2 + var3;
    }

    // $FF: renamed from: D (long) int
    public static int method_4670(long var0) {
        return method_4672(var0);
    }

    // $FF: renamed from: E (long) int
    public static int method_4671(long var0) {
        return method_4672(method_4673(var0));
    }

    // $FF: renamed from: G (long) int
    public static int method_4672(long var0) {
        return (-128L & var0) == 0L?1:((-16384L & var0) == 0L?2:((-2097152L & var0) == 0L?3:((-268435456L & var0) == 0L?4:((-34359738368L & var0) == 0L?5:((-4398046511104L & var0) == 0L?6:((-562949953421312L & var0) == 0L?7:((-72057594037927936L & var0) == 0L?8:((Long.MIN_VALUE & var0) == 0L?9:10))))))));
    }

    // $FF: renamed from: I (long) long
    public static long method_4673(long var0) {
        return var0 << 1 ^ var0 >> 63;
    }

    // $FF: renamed from: V (boolean) int
    public static int method_4674(boolean var0) {
        return 1;
    }

    // $FF: renamed from: b (int, double) int
    public static int method_4675(int var0, double var1) {
        return method_4693(var0) + method_4688(var1);
    }

    // $FF: renamed from: b (int, com.google.android.gms.internal.pn) int
    public static int method_4676(int var0, class_307 var1) {
        return 2 * method_4693(var0) + method_4683(var1);
    }

    // $FF: renamed from: b (int, byte[]) int
    public static int method_4677(int var0, byte[] var1) {
        return method_4693(var0) + method_4696(var1);
    }

    // $FF: renamed from: b (byte[], int, int) com.google.android.gms.internal.pg
    public static class_909 method_4678(byte[] var0, int var1, int var2) {
        return new class_909(var0, var1, var2);
    }

    // $FF: renamed from: c (int, float) int
    public static int method_4679(int var0, float var1) {
        return method_4693(var0) + method_4685(var1);
    }

    // $FF: renamed from: c (int, com.google.android.gms.internal.pn) int
    public static int method_4680(int var0, class_307 var1) {
        return method_4693(var0) + method_4687(var1);
    }

    // $FF: renamed from: c (int, boolean) int
    public static int method_4681(int var0, boolean var1) {
        return method_4693(var0) + method_4674(var1);
    }

    // $FF: renamed from: d (int, long) int
    public static int method_4682(int var0, long var1) {
        return method_4693(var0) + method_4670(var1);
    }

    // $FF: renamed from: d (com.google.android.gms.internal.pn) int
    public static int method_4683(class_307 var0) {
        return var0.method_2116();
    }

    // $FF: renamed from: di (java.lang.String) int
    public static int method_4684(String var0) {
        int var3;
        int var4;
        try {
            byte[] var2 = var0.getBytes("UTF-8");
            var3 = method_4689(var2.length);
            var4 = var2.length;
        } catch (UnsupportedEncodingException var5) {
            throw new RuntimeException("UTF-8 not supported.");
        }

        return var4 + var3;
    }

    // $FF: renamed from: e (float) int
    public static int method_4685(float var0) {
        return 4;
    }

    // $FF: renamed from: e (int, long) int
    public static int method_4686(int var0, long var1) {
        return method_4693(var0) + method_4671(var1);
    }

    // $FF: renamed from: e (com.google.android.gms.internal.pn) int
    public static int method_4687(class_307 var0) {
        int var1 = var0.method_2116();
        return var1 + method_4689(var1);
    }

    // $FF: renamed from: f (double) int
    public static int method_4688(double var0) {
        return 8;
    }

    // $FF: renamed from: gB (int) int
    public static int method_4689(int var0) {
        return (var0 & -128) == 0?1:((var0 & -16384) == 0?2:((-2097152 & var0) == 0?3:((-268435456 & var0) == 0?4:5)));
    }

    // $FF: renamed from: gD (int) int
    public static int method_4690(int var0) {
        return var0 << 1 ^ var0 >> 31;
    }

    // $FF: renamed from: gw (int) int
    public static int method_4691(int var0) {
        return var0 >= 0?method_4689(var0):10;
    }

    // $FF: renamed from: gx (int) int
    public static int method_4692(int var0) {
        return method_4689(method_4690(var0));
    }

    // $FF: renamed from: gz (int) int
    public static int method_4693(int var0) {
        return method_4689(class_905.method_4638(var0, 0));
    }

    // $FF: renamed from: j (int, java.lang.String) int
    public static int method_4694(int var0, String var1) {
        return method_4693(var0) + method_4684(var1);
    }

    // $FF: renamed from: q (byte[]) com.google.android.gms.internal.pg
    public static class_909 method_4695(byte[] var0) {
        return method_4678(var0, 0, var0.length);
    }

    // $FF: renamed from: s (byte[]) int
    public static int method_4696(byte[] var0) {
        return method_4689(var0.length) + var0.length;
    }

    // $FF: renamed from: u (int, int) int
    public static int method_4697(int var0, int var1) {
        return method_4693(var0) + method_4691(var1);
    }

    // $FF: renamed from: v (int, int) int
    public static int method_4698(int var0, int var1) {
        return method_4693(var0) + method_4692(var1);
    }

    // $FF: renamed from: B (long) void
    public void method_4699(long var1) throws IOException {
        this.method_4701(var1);
    }

    // $FF: renamed from: C (long) void
    public void method_4700(long var1) throws IOException {
        this.method_4701(method_4673(var1));
    }

    // $FF: renamed from: F (long) void
    public void method_4701(long var1) throws IOException {
        while((-128L & var1) != 0L) {
            this.method_4723(128 | 127 & (int)var1);
            var1 >>>= 7;
        }

        this.method_4723((int)var1);
    }

    // $FF: renamed from: H (long) void
    public void method_4702(long var1) throws IOException {
        this.method_4723(255 & (int)var1);
        this.method_4723(255 & (int)(var1 >> 8));
        this.method_4723(255 & (int)(var1 >> 16));
        this.method_4723(255 & (int)(var1 >> 24));
        this.method_4723(255 & (int)(var1 >> 32));
        this.method_4723(255 & (int)(var1 >> 40));
        this.method_4723(255 & (int)(var1 >> 48));
        this.method_4723(255 & (int)(var1 >> 56));
    }

    // $FF: renamed from: U (boolean) void
    public void method_4703(boolean var1) throws IOException {
        byte var2;
        if(var1) {
            var2 = 1;
        } else {
            var2 = 0;
        }

        this.method_4723(var2);
    }

    // $FF: renamed from: a (int, double) void
    public void method_4704(int var1, double var2) throws IOException {
        this.method_4730(var1, 1);
        this.method_4718(var2);
    }

    // $FF: renamed from: a (int, com.google.android.gms.internal.pn) void
    public void method_4705(int var1, class_307 var2) throws IOException {
        this.method_4730(var1, 2);
        this.method_4714(var2);
    }

    // $FF: renamed from: a (int, byte[]) void
    public void method_4706(int var1, byte[] var2) throws IOException {
        this.method_4730(var1, 2);
        this.method_4726(var2);
    }

    // $FF: renamed from: b (byte) void
    public void method_4707(byte var1) throws IOException {
        if(this.position == this.awI) {
            throw new class_909.class_1493(this.position, this.awI);
        } else {
            byte[] var2 = this.buffer;
            int var3 = this.position;
            this.position = var3 + 1;
            var2[var3] = var1;
        }
    }

    // $FF: renamed from: b (int, float) void
    public void method_4708(int var1, float var2) throws IOException {
        this.method_4730(var1, 5);
        this.method_4716(var2);
    }

    // $FF: renamed from: b (int, long) void
    public void method_4709(int var1, long var2) throws IOException {
        this.method_4730(var1, 0);
        this.method_4699(var2);
    }

    // $FF: renamed from: b (int, java.lang.String) void
    public void method_4710(int var1, String var2) throws IOException {
        this.method_4730(var1, 2);
        this.method_4717(var2);
    }

    // $FF: renamed from: b (int, boolean) void
    public void method_4711(int var1, boolean var2) throws IOException {
        this.method_4730(var1, 0);
        this.method_4703(var2);
    }

    // $FF: renamed from: b (com.google.android.gms.internal.pn) void
    public void method_4712(class_307 var1) throws IOException {
        var1.method_2112(this);
    }

    // $FF: renamed from: c (int, long) void
    public void method_4713(int var1, long var2) throws IOException {
        this.method_4730(var1, 0);
        this.method_4700(var2);
    }

    // $FF: renamed from: c (com.google.android.gms.internal.pn) void
    public void method_4714(class_307 var1) throws IOException {
        this.method_4719(var1.method_2115());
        var1.method_2112(this);
    }

    // $FF: renamed from: c (byte[], int, int) void
    public void method_4715(byte[] var1, int var2, int var3) throws IOException {
        if(this.awI - this.position >= var3) {
            System.arraycopy(var1, var2, this.buffer, this.position, var3);
            this.position += var3;
        } else {
            throw new class_909.class_1493(this.position, this.awI);
        }
    }

    // $FF: renamed from: d (float) void
    public void method_4716(float var1) throws IOException {
        this.method_4720(Float.floatToIntBits(var1));
    }

    // $FF: renamed from: dh (java.lang.String) void
    public void method_4717(String var1) throws IOException {
        byte[] var2 = var1.getBytes("UTF-8");
        this.method_4719(var2.length);
        this.method_4729(var2);
    }

    // $FF: renamed from: e (double) void
    public void method_4718(double var1) throws IOException {
        this.method_4702(Double.doubleToLongBits(var1));
    }

    // $FF: renamed from: gA (int) void
    public void method_4719(int var1) throws IOException {
        while((var1 & -128) != 0) {
            this.method_4723(128 | var1 & 127);
            var1 >>>= 7;
        }

        this.method_4723(var1);
    }

    // $FF: renamed from: gC (int) void
    public void method_4720(int var1) throws IOException {
        this.method_4723(var1 & 255);
        this.method_4723(255 & var1 >> 8);
        this.method_4723(255 & var1 >> 16);
        this.method_4723(255 & var1 >> 24);
    }

    // $FF: renamed from: gu (int) void
    public void method_4721(int var1) throws IOException {
        if(var1 >= 0) {
            this.method_4719(var1);
        } else {
            this.method_4701((long)var1);
        }
    }

    // $FF: renamed from: gv (int) void
    public void method_4722(int var1) throws IOException {
        this.method_4719(method_4690(var1));
    }

    // $FF: renamed from: gy (int) void
    public void method_4723(int var1) throws IOException {
        this.method_4707((byte)var1);
    }

    // $FF: renamed from: qx () int
    public int method_4724() {
        return this.awI - this.position;
    }

    // $FF: renamed from: qy () void
    public void method_4725() {
        if(this.method_4724() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    // $FF: renamed from: r (byte[]) void
    public void method_4726(byte[] var1) throws IOException {
        this.method_4719(var1.length);
        this.method_4729(var1);
    }

    // $FF: renamed from: s (int, int) void
    public void method_4727(int var1, int var2) throws IOException {
        this.method_4730(var1, 0);
        this.method_4721(var2);
    }

    // $FF: renamed from: t (int, int) void
    public void method_4728(int var1, int var2) throws IOException {
        this.method_4730(var1, 0);
        this.method_4722(var2);
    }

    // $FF: renamed from: t (byte[]) void
    public void method_4729(byte[] var1) throws IOException {
        this.method_4715(var1, 0, var1.length);
    }

    // $FF: renamed from: w (int, int) void
    public void method_4730(int var1, int var2) throws IOException {
        this.method_4719(class_905.method_4638(var1, var2));
    }

    public static class class_1493 extends IOException {
        class_1493(int var1, int var2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + var1 + " limit " + var2 + ").");
        }
    }
}
