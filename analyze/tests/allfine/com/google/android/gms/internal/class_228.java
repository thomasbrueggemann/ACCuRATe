package com.google.android.gms.internal;

import com.google.android.gms.internal.class_226;
import com.google.android.gms.internal.class_227;
import java.security.MessageDigest;

// $FF: renamed from: com.google.android.gms.internal.ar
public class class_228 extends class_227 {
    // $FF: renamed from: nP java.security.MessageDigest
    private MessageDigest field_564;

    // $FF: renamed from: a (java.lang.String[]) byte[]
    byte[] method_1539(String[] var1) {
        byte[] var2 = new byte[var1.length];

        for(int var3 = 0; var3 < var1.length; ++var3) {
            var2[var3] = (byte)(255 & class_226.method_1535(var1[var3]));
        }

        return var2;
    }

    // $FF: renamed from: l (java.lang.String) byte[]
    public byte[] method_1538(String param1) {
        // $FF: Couldn't be decompiled
    }
}
