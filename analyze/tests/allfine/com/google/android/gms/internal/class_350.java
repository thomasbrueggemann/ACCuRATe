package com.google.android.gms.internal;

import android.util.Base64;

// $FF: renamed from: com.google.android.gms.internal.js
public final class class_350 {
    // $FF: renamed from: d (byte[]) java.lang.String
    public static String method_2344(byte[] var0) {
        return var0 == null?null:Base64.encodeToString(var0, 0);
    }

    // $FF: renamed from: e (byte[]) java.lang.String
    public static String method_2345(byte[] var0) {
        return var0 == null?null:Base64.encodeToString(var0, 10);
    }
}
