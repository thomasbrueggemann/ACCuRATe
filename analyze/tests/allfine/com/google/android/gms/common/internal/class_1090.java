package com.google.android.gms.common.internal;

import android.os.Looper;
import android.text.TextUtils;

// $FF: renamed from: com.google.android.gms.common.internal.o
public final class class_1090 {
    // $FF: renamed from: I (boolean) void
    public static void method_5674(boolean var0) {
        if(!var0) {
            throw new IllegalStateException();
        }
    }

    // $FF: renamed from: K (boolean) void
    public static void method_5675(boolean var0) {
        if(!var0) {
            throw new IllegalArgumentException();
        }
    }

    // $FF: renamed from: a (boolean, java.lang.Object) void
    public static void method_5676(boolean var0, Object var1) {
        if(!var0) {
            throw new IllegalStateException(String.valueOf(var1));
        }
    }

    // $FF: renamed from: a (boolean, java.lang.String, java.lang.Object[]) void
    public static void method_5677(boolean var0, String var1, Object... var2) {
        if(!var0) {
            throw new IllegalStateException(String.format(var1, var2));
        }
    }

    // $FF: renamed from: aT (java.lang.String) void
    public static void method_5678(String var0) {
        if(Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException(var0);
        }
    }

    // $FF: renamed from: aU (java.lang.String) void
    public static void method_5679(String var0) {
        if(Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(var0);
        }
    }

    // $FF: renamed from: aZ (java.lang.String) java.lang.String
    public static String method_5680(String var0) {
        if(TextUtils.isEmpty(var0)) {
            throw new IllegalArgumentException("Given String is empty or null");
        } else {
            return var0;
        }
    }

    // $FF: renamed from: b (java.lang.Object, java.lang.Object) java.lang.Object
    public static <T> T method_5681(T var0, Object var1) {
        if(var0 == null) {
            throw new NullPointerException(String.valueOf(var1));
        } else {
            return var0;
        }
    }

    // $FF: renamed from: b (java.lang.String, java.lang.Object) java.lang.String
    public static String method_5682(String var0, Object var1) {
        if(TextUtils.isEmpty(var0)) {
            throw new IllegalArgumentException(String.valueOf(var1));
        } else {
            return var0;
        }
    }

    // $FF: renamed from: b (boolean, java.lang.Object) void
    public static void method_5683(boolean var0, Object var1) {
        if(!var0) {
            throw new IllegalArgumentException(String.valueOf(var1));
        }
    }

    // $FF: renamed from: b (boolean, java.lang.String, java.lang.Object[]) void
    public static void method_5684(boolean var0, String var1, Object... var2) {
        if(!var0) {
            throw new IllegalArgumentException(String.format(var1, var2));
        }
    }

    // $FF: renamed from: i (java.lang.Object) java.lang.Object
    public static <T> T method_5685(T var0) {
        if(var0 == null) {
            throw new NullPointerException("null reference");
        } else {
            return var0;
        }
    }
}
