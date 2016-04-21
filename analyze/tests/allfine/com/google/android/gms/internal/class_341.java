package com.google.android.gms.internal;

// $FF: renamed from: com.google.android.gms.internal.kb
public class class_341 {
    // $FF: renamed from: a (byte[], int, int, int) int
    public static int method_2315(byte[] var0, int var1, int var2, int var3) {
        int var4 = var1 + (var2 & -4);

        int var5;
        for(var5 = var3; var1 < var4; var1 += 4) {
            int var13 = -862048943 * (255 & var0[var1] | (255 & var0[var1 + 1]) << 8 | (255 & var0[var1 + 2]) << 16 | var0[var1 + 3] << 24);
            int var14 = var5 ^ 461845907 * (var13 << 15 | var13 >>> 17);
            var5 = -430675100 + 5 * (var14 << 13 | var14 >>> 19);
        }

        int var6 = var2 & 3;
        int var7 = 0;
        int var9;
        switch(var6) {
            case 3:
                var7 = (255 & var0[var4 + 2]) << 16;
            case 2:
                var7 |= (255 & var0[var4 + 1]) << 8;
            case 1:
                int var8 = -862048943 * (var7 | 255 & var0[var4]);
                var9 = var5 ^ 461845907 * (var8 << 15 | var8 >>> 17);
                break;
            default:
                var9 = var5;
        }

        int var10 = var9 ^ var2;
        int var11 = -2048144789 * (var10 ^ var10 >>> 16);
        int var12 = -1028477387 * (var11 ^ var11 >>> 13);
        return var12 ^ var12 >>> 16;
    }
}
