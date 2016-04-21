package crittercism.android;

import android.util.Log;
import crittercism.android.class_742;
import crittercism.android.class_808;

// $FF: renamed from: crittercism.android.dx
public final class class_764 {
    // $FF: renamed from: a crittercism.android.dx$a
    public static class_764.class_1388 field_3598;
    // $FF: renamed from: b crittercism.android.ec
    private static class_808 field_3599;

    static {
        field_3598 = class_764.class_1388.field_5231;
    }

    // $FF: renamed from: a () void
    public static void method_4015() {
    }

    // $FF: renamed from: a (crittercism.android.ec) void
    public static void method_4016(class_808 var0) {
        field_3599 = var0;
    }

    // $FF: renamed from: a (java.lang.String) void
    public static void method_4017(String var0) {
        Log.i("Crittercism", var0);
    }

    // $FF: renamed from: a (java.lang.String, java.lang.Throwable) void
    public static void method_4018(String var0, Throwable var1) {
        Log.e("Crittercism", var0, var1);
    }

    // $FF: renamed from: a (java.lang.Throwable) void
    public static void method_4019(Throwable var0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b () void
    public static void method_4020() {
    }

    // $FF: renamed from: b (java.lang.String) void
    public static void method_4021(String var0) {
        Log.e("Crittercism", var0);
    }

    // $FF: renamed from: b (java.lang.String, java.lang.Throwable) void
    public static void method_4022(String var0, Throwable var1) {
        Log.w("Crittercism", var0, var1);
    }

    // $FF: renamed from: c () void
    public static void method_4023() {
    }

    // $FF: renamed from: c (java.lang.String) void
    public static void method_4024(String var0) {
        Log.w("Crittercism", var0);
    }

    public static enum class_1388 {
        // $FF: renamed from: a crittercism.android.dx$a
        field_5231,
        // $FF: renamed from: b crittercism.android.dx$a
        field_5232,
        // $FF: renamed from: c crittercism.android.dx$a
        field_5233;

        static {
            class_764.class_1388[] var0 = new class_764.class_1388[]{field_5231, field_5232, field_5233};
        }
    }
}
