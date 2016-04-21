package com.google.android.gms.internal;

// $FF: renamed from: com.google.android.gms.internal.pe
public class class_910 {
    private final byte[] aww = new byte[256];
    private int awx;
    private int awy;

    public class_910(byte[] var1) {
        for(int var2 = 0; var2 < 256; ++var2) {
            this.aww[var2] = (byte)var2;
        }

        int var3 = 0;

        for(int var4 = 0; var4 < 256; ++var4) {
            var3 = 255 & var3 + this.aww[var4] + var1[var4 % var1.length];
            byte var5 = this.aww[var4];
            this.aww[var4] = this.aww[var3];
            this.aww[var3] = var5;
        }

        this.awx = 0;
        this.awy = 0;
    }

    // $FF: renamed from: o (byte[]) void
    public void method_4731(byte[] var1) {
        int var2 = this.awx;
        int var3 = this.awy;

        for(int var4 = 0; var4 < var1.length; ++var4) {
            var2 = 255 & var2 + 1;
            var3 = 255 & var3 + this.aww[var2];
            byte var5 = this.aww[var2];
            this.aww[var2] = this.aww[var3];
            this.aww[var3] = var5;
            var1[var4] ^= this.aww[255 & this.aww[var2] + this.aww[var3]];
        }

        this.awx = var2;
        this.awy = var3;
    }
}
