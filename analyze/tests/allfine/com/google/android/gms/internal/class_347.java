package com.google.android.gms.internal;

import android.content.Context;
import java.util.regex.Pattern;

// $FF: renamed from: com.google.android.gms.internal.jt
public final class class_347 {
    // $FF: renamed from: MR java.util.regex.Pattern
    private static Pattern field_1209 = null;

    // $FF: renamed from: K (android.content.Context) boolean
    public static boolean method_2327(Context var0) {
        return var0.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    // $FF: renamed from: aN (int) int
    public static int method_2328(int var0) {
        return var0 / 1000;
    }

    // $FF: renamed from: aO (int) int
    public static int method_2329(int var0) {
        return var0 % 1000 / 100;
    }

    // $FF: renamed from: aP (int) boolean
    public static boolean method_2330(int var0) {
        return method_2329(var0) == 3;
    }
}
