package crittercism.android;

import java.io.UnsupportedEncodingException;

// $FF: renamed from: crittercism.android.cr
public final class class_740 {
    // $FF: renamed from: a byte[]
    private static final byte[] field_3496;
    // $FF: renamed from: b byte[]
    private static final byte[] field_3497 = new byte[] {(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)43, (byte)47};
    // $FF: renamed from: c byte[]
    private static final byte[] field_3498;

    static {
        byte[] var1;
        label13: {
            byte[] var2;
            try {
                var2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes("UTF-8");
            } catch (UnsupportedEncodingException var3) {
                var1 = field_3497;
                break label13;
            }

            var1 = var2;
        }

        field_3496 = var1;
        field_3498 = new byte[] {(byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-5, (byte)-5, (byte)-9, (byte)-9, (byte)-5, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-5, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)62, (byte)-9, (byte)-9, (byte)-9, (byte)63, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)58, (byte)59, (byte)60, (byte)61, (byte)-9, (byte)-9, (byte)-9, (byte)-1, (byte)-9, (byte)-9, (byte)-9, (byte)0, (byte)1, (byte)2, (byte)3, (byte)4, (byte)5, (byte)6, (byte)7, (byte)8, (byte)9, (byte)10, (byte)11, (byte)12, (byte)13, (byte)14, (byte)15, (byte)16, (byte)17, (byte)18, (byte)19, (byte)20, (byte)21, (byte)22, (byte)23, (byte)24, (byte)25, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)-9, (byte)26, (byte)27, (byte)28, (byte)29, (byte)30, (byte)31, (byte)32, (byte)33, (byte)34, (byte)35, (byte)36, (byte)37, (byte)38, (byte)39, (byte)40, (byte)41, (byte)42, (byte)43, (byte)44, (byte)45, (byte)46, (byte)47, (byte)48, (byte)49, (byte)50, (byte)51, (byte)-9, (byte)-9, (byte)-9, (byte)-9};
    }

    // $FF: renamed from: a (byte[]) java.lang.String
    public static String method_3985(byte[] var0) {
        return method_3986(var0, var0.length);
    }

    // $FF: renamed from: a (byte[], int) java.lang.String
    private static String method_3986(byte[] var0, int var1) {
        int var2 = var1 * 4 / 3;
        byte var3;
        if(var1 % 3 > 0) {
            var3 = 4;
        } else {
            var3 = 0;
        }

        byte[] var4 = new byte[var3 + var2 + var2 / 76];
        int var5 = var1 - 2;
        int var6 = 0;
        int var7 = 0;

        int var8;
        for(var8 = 0; var8 < var5; var7 += 4) {
            method_3987(var0, var8 + 0, 3, var4, var7);
            var6 += 4;
            if(var6 == 76) {
                var4[var7 + 4] = 10;
                ++var7;
                var6 = 0;
            }

            var8 += 3;
        }

        if(var8 < var1) {
            method_3987(var0, var8 + 0, var1 - var8, var4, var7);
            var7 += 4;
        }

        try {
            String var9 = new String(var4, 0, var7, "UTF-8");
            return var9;
        } catch (UnsupportedEncodingException var11) {
            return new String(var4, 0, var7);
        }
    }

    // $FF: renamed from: a (byte[], int, int, byte[], int) byte[]
    private static byte[] method_3987(byte[] var0, int var1, int var2, byte[] var3, int var4) {
        int var5;
        if(var2 > 0) {
            var5 = var0[var1] << 24 >>> 8;
        } else {
            var5 = 0;
        }

        int var6;
        if(var2 > 1) {
            var6 = var0[var1 + 1] << 24 >>> 16;
        } else {
            var6 = 0;
        }

        int var7 = var6 | var5;
        int var8 = 0;
        if(var2 > 2) {
            var8 = var0[var1 + 2] << 24 >>> 24;
        }

        int var9 = var8 | var7;
        switch(var2) {
            case 1:
                var3[var4] = field_3496[var9 >>> 18];
                var3[var4 + 1] = field_3496[63 & var9 >>> 12];
                var3[var4 + 2] = 61;
                var3[var4 + 3] = 61;
                return var3;
            case 2:
                var3[var4] = field_3496[var9 >>> 18];
                var3[var4 + 1] = field_3496[63 & var9 >>> 12];
                var3[var4 + 2] = field_3496[63 & var9 >>> 6];
                var3[var4 + 3] = 61;
                return var3;
            case 3:
                var3[var4] = field_3496[var9 >>> 18];
                var3[var4 + 1] = field_3496[63 & var9 >>> 12];
                var3[var4 + 2] = field_3496[63 & var9 >>> 6];
                var3[var4 + 3] = field_3496[var9 & 63];
                return var3;
            default:
                return var3;
        }
    }
}
