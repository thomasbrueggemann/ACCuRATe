package com.google.android.gms.internal;

import com.google.android.gms.internal.class_67;
import com.google.android.gms.internal.class_909;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.p
class class_541 implements class_67 {
    // $FF: renamed from: kY com.google.android.gms.internal.pg
    private class_909 field_2891;
    // $FF: renamed from: kZ byte[]
    private byte[] field_2892;
    // $FF: renamed from: la int
    private final int field_2893;

    public class_541(int var1) {
        this.field_2893 = var1;
        this.reset();
    }

    // $FF: renamed from: A () byte[]
    public byte[] method_321() throws IOException {
        int var1 = this.field_2891.method_4724();
        if(var1 < 0) {
            throw new IOException();
        } else if(var1 == 0) {
            return this.field_2892;
        } else {
            byte[] var2 = new byte[this.field_2892.length - var1];
            System.arraycopy(this.field_2892, 0, var2, 0, var2.length);
            return var2;
        }
    }

    // $FF: renamed from: b (int, long) void
    public void method_322(int var1, long var2) throws IOException {
        this.field_2891.method_4709(var1, var2);
    }

    // $FF: renamed from: b (int, java.lang.String) void
    public void method_323(int var1, String var2) throws IOException {
        this.field_2891.method_4710(var1, var2);
    }

    public void reset() {
        this.field_2892 = new byte[this.field_2893];
        this.field_2891 = class_909.method_4695(this.field_2892);
    }
}
