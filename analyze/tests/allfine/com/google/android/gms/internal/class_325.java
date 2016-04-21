package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import com.google.android.gms.internal.iv;

// $FF: renamed from: com.google.android.gms.internal.iv
public abstract class class_325<T> {
    // $FF: renamed from: JN com.google.android.gms.internal.iv$a
    private static class_325.class_1587 field_1071 = null;
    // $FF: renamed from: mw java.lang.Object
    private static final Object field_1072 = new Object();
    // $FF: renamed from: JO java.lang.String
    protected final String field_1073;
    // $FF: renamed from: JP java.lang.Object
    protected final T field_1074;
    // $FF: renamed from: JQ java.lang.Object
    private T field_1075 = null;

    protected class_325(String var1, T var2) {
        this.field_1073 = var1;
        this.field_1074 = var2;
    }

    // $FF: renamed from: H (android.content.Context) void
    public static void method_2238(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.String, java.lang.Integer) com.google.android.gms.internal.iv
    public static iv<Integer> method_2239(final String var0, final Integer var1) {
        return new class_325(var0, var1) {
        };
    }

    // $FF: renamed from: g (java.lang.String, boolean) com.google.android.gms.internal.iv
    public static iv<Boolean> method_2240(final String var0, boolean var1) {
        return new class_325(var0, Boolean.valueOf(var1)) {
        };
    }

    // $FF: renamed from: m (java.lang.String, java.lang.String) com.google.android.gms.internal.iv
    public static iv<String> method_2241(final String var0, final String var1) {
        return new class_325(var0, var1) {
        };
    }

    public String getKey() {
        return this.field_1073;
    }

    private interface class_1587 {
    }

    private static class class_1588 implements class_325.class_1587 {
        private final ContentResolver mContentResolver;

        public class_1588(ContentResolver var1) {
            this.mContentResolver = var1;
        }
    }
}
