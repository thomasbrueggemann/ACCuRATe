package com.google.android.gms.internal;

import com.google.android.gms.internal.class_899;
import com.google.android.gms.internal.class_901;
import com.google.android.gms.internal.class_908;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.pn;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.pn
public abstract class class_307 {
    protected volatile int awU = -1;

    // $FF: renamed from: a (com.google.android.gms.internal.pn, byte[]) com.google.android.gms.internal.pn
    public static final <T extends pn> T method_2108(T var0, byte[] var1) throws class_899 {
        return method_2110(var0, var1, 0, var1.length);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pn, byte[], int, int) void
    public static final void method_2109(class_307 var0, byte[] var1, int var2, int var3) {
        try {
            class_909 var5 = class_909.method_4678(var1, var2, var3);
            var0.method_2112(var5);
            var5.method_4725();
        } catch (IOException var6) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var6);
        }
    }

    // $FF: renamed from: b (com.google.android.gms.internal.pn, byte[], int, int) com.google.android.gms.internal.pn
    public static final <T extends pn> T method_2110(T var0, byte[] var1, int var2, int var3) throws class_899 {
        try {
            class_908 var6 = class_908.method_4642(var1, var2, var3);
            var0.method_2113(var6);
            var6.method_4648(0);
            return var0;
        } catch (class_899 var7) {
            throw var7;
        } catch (IOException var8) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    // $FF: renamed from: f (com.google.android.gms.internal.pn) byte[]
    public static final byte[] method_2111(class_307 var0) {
        byte[] var1 = new byte[var0.method_2116()];
        method_2109(var0, var1, 0, var1.length);
        return var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pg) void
    public void method_2112(class_909 var1) throws IOException {
    }

    // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
    public abstract class_307 method_2113(class_908 var1) throws IOException;

    // $FF: renamed from: c () int
    protected int method_2114() {
        return 0;
    }

    // $FF: renamed from: qH () int
    public int method_2115() {
        if(this.awU < 0) {
            this.method_2116();
        }

        return this.awU;
    }

    // $FF: renamed from: qI () int
    public int method_2116() {
        int var1 = this.method_2114();
        this.awU = var1;
        return var1;
    }

    public String toString() {
        return class_901.method_4611(this);
    }
}
