package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.internal.class_193;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.dynamic.class_216;
import com.google.android.gms.dynamic.g;

// $FF: renamed from: com.google.android.gms.common.internal.p
public final class class_217 extends g<m> {
    // $FF: renamed from: Mi com.google.android.gms.common.internal.p
    private static final class_217 field_546 = new class_217();

    private class_217() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    // $FF: renamed from: b (android.content.Context, int, int) android.view.View
    public static View method_1507(Context var0, int var1, int var2) throws class_216.class_1677 {
        return field_546.method_1508(var0, var1, var2);
    }

    // $FF: renamed from: c (android.content.Context, int, int) android.view.View
    private View method_1508(Context var1, int var2, int var3) throws class_216.class_1677 {
        try {
            class_206 var5 = class_1046.method_5437(var1);
            View var6 = (View)class_1046.method_5436(((class_193)this.L(var1)).method_996(var5, var2, var3));
            return var6;
        } catch (Exception var7) {
            throw new class_216.class_1677("Could not get button with size " + var2 + " and color " + var3, var7);
        }
    }

    // $FF: renamed from: S (android.os.IBinder) com.google.android.gms.common.internal.m
    public class_193 method_1509(IBinder var1) {
        return class_193.class_1630.method_5083(var1);
    }

    // $FF: renamed from: d (android.os.IBinder) java.lang.Object
    // $FF: synthetic method
    public Object method_1506(IBinder var1) {
        return this.method_1509(var1);
    }
}
