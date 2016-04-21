package com.google.android.gms.analytics;

import com.google.android.gms.analytics.class_938;

// $FF: renamed from: com.google.android.gms.analytics.n
public final class class_928 {
    // $FF: renamed from: A (int) java.lang.String
    public static String method_4791(int var0) {
        return method_4796("&promo", var0);
    }

    // $FF: renamed from: B (int) java.lang.String
    public static String method_4792(int var0) {
        return method_4796("pi", var0);
    }

    // $FF: renamed from: C (int) java.lang.String
    public static String method_4793(int var0) {
        return method_4796("&il", var0);
    }

    // $FF: renamed from: D (int) java.lang.String
    public static String method_4794(int var0) {
        return method_4796("cd", var0);
    }

    // $FF: renamed from: E (int) java.lang.String
    public static String method_4795(int var0) {
        return method_4796("cm", var0);
    }

    // $FF: renamed from: d (java.lang.String, int) java.lang.String
    private static String method_4796(String var0, int var1) {
        if(var1 < 1) {
            class_938.method_4858("index out of range for " + var0 + " (" + var1 + ")");
            return "";
        } else {
            return var0 + var1;
        }
    }

    // $FF: renamed from: x (int) java.lang.String
    static String method_4797(int var0) {
        return method_4796("&cd", var0);
    }

    // $FF: renamed from: y (int) java.lang.String
    static String method_4798(int var0) {
        return method_4796("&cm", var0);
    }

    // $FF: renamed from: z (int) java.lang.String
    public static String method_4799(int var0) {
        return method_4796("&pr", var0);
    }
}
