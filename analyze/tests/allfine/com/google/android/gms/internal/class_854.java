package com.google.android.gms.internal;

import android.os.Build.VERSION;

// $FF: renamed from: com.google.android.gms.internal.kc
public final class class_854 {
    // $FF: renamed from: aR (int) boolean
    private static boolean method_4492(int var0) {
        return VERSION.SDK_INT >= var0;
    }

    // $FF: renamed from: hB () boolean
    public static boolean method_4493() {
        return method_4492(11);
    }

    // $FF: renamed from: hC () boolean
    public static boolean method_4494() {
        return method_4492(12);
    }

    // $FF: renamed from: hD () boolean
    public static boolean method_4495() {
        return method_4492(13);
    }

    // $FF: renamed from: hE () boolean
    public static boolean method_4496() {
        return method_4492(14);
    }

    // $FF: renamed from: hF () boolean
    public static boolean method_4497() {
        return method_4492(16);
    }

    // $FF: renamed from: hG () boolean
    public static boolean method_4498() {
        return method_4492(17);
    }

    // $FF: renamed from: hH () boolean
    @Deprecated
    public static boolean method_4499() {
        return method_4500();
    }

    // $FF: renamed from: hI () boolean
    public static boolean method_4500() {
        return method_4492(19);
    }
}
