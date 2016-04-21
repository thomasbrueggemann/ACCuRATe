package com.google.android.gms.internal;

import android.util.Base64;
import com.google.android.gms.internal.class_66;

// $FF: renamed from: com.google.android.gms.internal.e
class class_532 implements class_66 {
    // $FF: renamed from: a (byte[], boolean) java.lang.String
    public String method_319(byte[] var1, boolean var2) {
        byte var3;
        if(var2) {
            var3 = 11;
        } else {
            var3 = 2;
        }

        return Base64.encodeToString(var1, var3);
    }

    // $FF: renamed from: a (java.lang.String, boolean) byte[]
    public byte[] method_320(String var1, boolean var2) throws IllegalArgumentException {
        byte var3;
        if(var2) {
            var3 = 11;
        } else {
            var3 = 2;
        }

        return Base64.decode(var1, var3);
    }
}
