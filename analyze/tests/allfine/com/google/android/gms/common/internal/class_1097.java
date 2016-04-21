package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

// $FF: renamed from: com.google.android.gms.common.internal.a
public final class class_1097 {
    // $FF: renamed from: I (boolean) void
    public static void method_5710(boolean var0) {
        if(!var0) {
            throw new IllegalStateException();
        }
    }

    // $FF: renamed from: a (boolean, java.lang.Object) void
    public static void method_5711(boolean var0, Object var1) {
        if(!var0) {
            throw new IllegalStateException(String.valueOf(var1));
        }
    }

    // $FF: renamed from: aT (java.lang.String) void
    public static void method_5712(String var0) {
        if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(var0);
        }
    }

    // $FF: renamed from: aU (java.lang.String) void
    public static void method_5713(String var0) {
        if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
            Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(var0);
        }
    }

    // $FF: renamed from: f (java.lang.Object) void
    public static void method_5714(Object var0) {
        if(var0 == null) {
            throw new IllegalArgumentException("null reference");
        }
    }
}
