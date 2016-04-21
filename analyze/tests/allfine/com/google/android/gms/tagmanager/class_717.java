package com.google.android.gms.tagmanager;

// $FF: renamed from: com.google.android.gms.tagmanager.j
class class_717 {
    // $FF: renamed from: cm (java.lang.String) byte[]
    public static byte[] method_3919(String var0) {
        int var1 = var0.length();
        if(var1 % 2 != 0) {
            throw new IllegalArgumentException("purported base16 string has odd number of characters");
        } else {
            byte[] var2 = new byte[var1 / 2];

            for(int var3 = 0; var3 < var1; var3 += 2) {
                int var4 = Character.digit(var0.charAt(var3), 16);
                int var5 = Character.digit(var0.charAt(var3 + 1), 16);
                if(var4 == -1 || var5 == -1) {
                    throw new IllegalArgumentException("purported base16 string has illegal char");
                }

                var2[var3 / 2] = (byte)(var5 + (var4 << 4));
            }

            return var2;
        }
    }

    // $FF: renamed from: d (byte[]) java.lang.String
    public static String method_3920(byte[] var0) {
        StringBuilder var1 = new StringBuilder();
        int var2 = var0.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            byte var4 = var0[var3];
            if((var4 & 240) == 0) {
                var1.append("0");
            }

            var1.append(Integer.toHexString(var4 & 255));
        }

        return var1.toString().toUpperCase();
    }
}
