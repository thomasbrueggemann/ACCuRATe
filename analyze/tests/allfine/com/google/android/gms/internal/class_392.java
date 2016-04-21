package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.ez;
import java.math.BigInteger;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.gf
@ez
public final class class_392 {
    // $FF: renamed from: uf java.lang.Object
    private static final Object field_1460 = new Object();
    // $FF: renamed from: we java.lang.String
    private static String field_1461;

    // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String) java.lang.String
    public static String method_2594(Context param0, String param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (android.content.Context, java.lang.String, java.lang.String) void
    private static void method_2595(Context var0, String var1, String var2) {
        ClassLoader var4;
        Class var5;
        try {
            var4 = var0.createPackageContext(var2, 3).getClassLoader();
            var5 = Class.forName("com.google.ads.mediation.MediationAdapter", false, var4);
        } catch (Throwable var10) {
            field_1461 = "err";
            return;
        }

        BigInteger var6 = new BigInteger(new byte[1]);
        String[] var7 = var1.split(",");
        BigInteger var8 = var6;

        for(int var9 = 0; var9 < var7.length; ++var9) {
            if(class_383.method_2517(var4, var5, var7[var9])) {
                var8 = var8.setBit(var9);
            }
        }

        field_1461 = String.format(Locale.US, "%X", new Object[] {var8});
    }

    // $FF: renamed from: di () java.lang.String
    public static String method_2596() {
        // $FF: Couldn't be decompiled
    }
}
