package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.gs
@ez
public final class class_378 {
    // $FF: renamed from: S (java.lang.String) void
    public static void method_2457(String var0) {
        if(method_2466(3)) {
            Log.d("Ads", var0);
        }

    }

    // $FF: renamed from: T (java.lang.String) void
    public static void method_2458(String var0) {
        if(method_2466(6)) {
            Log.e("Ads", var0);
        }

    }

    // $FF: renamed from: U (java.lang.String) void
    public static void method_2459(String var0) {
        if(method_2466(4)) {
            Log.i("Ads", var0);
        }

    }

    // $FF: renamed from: V (java.lang.String) void
    public static void method_2460(String var0) {
        if(method_2466(2)) {
            Log.v("Ads", var0);
        }

    }

    // $FF: renamed from: W (java.lang.String) void
    public static void method_2461(String var0) {
        if(method_2466(5)) {
            Log.w("Ads", var0);
        }

    }

    // $FF: renamed from: a (java.lang.String, java.lang.Throwable) void
    public static void method_2462(String var0, Throwable var1) {
        if(method_2466(3)) {
            Log.d("Ads", var0, var1);
        }

    }

    // $FF: renamed from: b (java.lang.String, java.lang.Throwable) void
    public static void method_2463(String var0, Throwable var1) {
        if(method_2466(6)) {
            Log.e("Ads", var0, var1);
        }

    }

    // $FF: renamed from: c (java.lang.String, java.lang.Throwable) void
    public static void method_2464(String var0, Throwable var1) {
        if(method_2466(4)) {
            Log.i("Ads", var0, var1);
        }

    }

    // $FF: renamed from: d (java.lang.String, java.lang.Throwable) void
    public static void method_2465(String var0, Throwable var1) {
        if(method_2466(5)) {
            Log.w("Ads", var0, var1);
        }

    }

    // $FF: renamed from: u (int) boolean
    public static boolean method_2466(int var0) {
        return (var0 >= 5 || Log.isLoggable("Ads", var0)) && var0 != 2;
    }
}
