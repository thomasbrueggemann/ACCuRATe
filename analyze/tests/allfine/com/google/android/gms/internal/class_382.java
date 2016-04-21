package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.gh
@ez
public final class class_382 {
    // $FF: renamed from: a (android.content.Context, boolean) void
    public static void method_2494(Context var0, boolean var1) {
        Editor var2 = method_2495(var0).edit();
        var2.putBoolean("use_https", var1);
        var2.commit();
    }

    // $FF: renamed from: n (android.content.Context) android.content.SharedPreferences
    private static SharedPreferences method_2495(Context var0) {
        return var0.getSharedPreferences("admob", 0);
    }

    // $FF: renamed from: o (android.content.Context) boolean
    public static boolean method_2496(Context var0) {
        return method_2495(var0).getBoolean("use_https", true);
    }
}
