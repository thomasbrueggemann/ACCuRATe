package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

// $FF: renamed from: com.google.android.gms.internal.ip
public class class_332 {
    // $FF: renamed from: GX boolean
    private static boolean field_1121 = false;
    // $FF: renamed from: GY boolean
    private boolean field_1122;
    // $FF: renamed from: GZ boolean
    private boolean field_1123;
    // $FF: renamed from: Ha java.lang.String
    private String field_1124;
    private final String mTag;

    public class_332(String var1) {
        this(var1, method_2280());
    }

    public class_332(String var1, boolean var2) {
        this.mTag = var1;
        this.field_1122 = var2;
        this.field_1123 = false;
    }

    // $FF: renamed from: e (java.lang.String, java.lang.Object[]) java.lang.String
    private String method_2279(String var1, Object... var2) {
        if(var2.length != 0) {
            var1 = String.format(var1, var2);
        }

        if(!TextUtils.isEmpty(this.field_1124)) {
            var1 = this.field_1124 + var1;
        }

        return var1;
    }

    // $FF: renamed from: fS () boolean
    public static boolean method_2280() {
        return field_1121;
    }

    // $FF: renamed from: a (java.lang.String, java.lang.Object[]) void
    public void method_2281(String var1, Object... var2) {
        if(this.method_2288()) {
            Log.v(this.mTag, this.method_2279(var1, var2));
        }

    }

    // $FF: renamed from: a (java.lang.Throwable, java.lang.String, java.lang.Object[]) void
    public void method_2282(Throwable var1, String var2, Object... var3) {
        if(this.method_2287() || field_1121) {
            Log.d(this.mTag, this.method_2279(var2, var3), var1);
        }

    }

    // $FF: renamed from: aK (java.lang.String) void
    public void method_2283(String var1) {
        String var2;
        if(TextUtils.isEmpty(var1)) {
            var2 = null;
        } else {
            var2 = String.format("[%s] ", new Object[] {var1});
        }

        this.field_1124 = var2;
    }

    // $FF: renamed from: b (java.lang.String, java.lang.Object[]) void
    public void method_2284(String var1, Object... var2) {
        if(this.method_2287() || field_1121) {
            Log.d(this.mTag, this.method_2279(var1, var2));
        }

    }

    // $FF: renamed from: c (java.lang.String, java.lang.Object[]) void
    public void method_2285(String var1, Object... var2) {
        Log.i(this.mTag, this.method_2279(var1, var2));
    }

    // $FF: renamed from: d (java.lang.String, java.lang.Object[]) void
    public void method_2286(String var1, Object... var2) {
        Log.w(this.mTag, this.method_2279(var1, var2));
    }

    // $FF: renamed from: fQ () boolean
    public boolean method_2287() {
        return this.field_1122;
    }

    // $FF: renamed from: fR () boolean
    public boolean method_2288() {
        return this.field_1123;
    }
}
