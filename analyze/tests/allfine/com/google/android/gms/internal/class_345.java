package com.google.android.gms.internal;

import android.database.CharArrayBuffer;

// $FF: renamed from: com.google.android.gms.internal.jv
public final class class_345 {
    // $FF: renamed from: b (java.lang.String, android.database.CharArrayBuffer) void
    public static void method_2325(String var0, CharArrayBuffer var1) {
        if(var1.data != null && var1.data.length >= var0.length()) {
            var0.getChars(0, var0.length(), var1.data, 0);
        } else {
            var1.data = var0.toCharArray();
        }

        var1.sizeCopied = var0.length();
    }
}
