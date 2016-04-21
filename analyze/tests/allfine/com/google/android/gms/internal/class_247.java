package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.internal.class_11;
import com.google.android.gms.internal.class_248;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.bp
@ez
public class class_247 extends class_11.class_1494 implements class_248.class_1288 {
    // $FF: renamed from: mw java.lang.Object
    private final Object field_673 = new Object();
    // $FF: renamed from: pl java.lang.String
    private final String field_674;
    // $FF: renamed from: pm android.graphics.drawable.Drawable
    private final Drawable field_675;
    // $FF: renamed from: pn java.lang.String
    private final String field_676;
    // $FF: renamed from: pp java.lang.String
    private final String field_677;
    // $FF: renamed from: pt com.google.android.gms.internal.bq
    private class_248 field_678;
    // $FF: renamed from: pu android.graphics.drawable.Drawable
    private final Drawable field_679;
    // $FF: renamed from: pv java.lang.String
    private final String field_680;

    public class_247(String var1, Drawable var2, String var3, Drawable var4, String var5, String var6) {
        this.field_674 = var1;
        this.field_675 = var2;
        this.field_676 = var3;
        this.field_679 = var4;
        this.field_677 = var5;
        this.field_680 = var6;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.bq) void
    public void method_832(class_248 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: as () void
    public void method_34() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: bA () com.google.android.gms.dynamic.d
    public class_206 method_35() {
        return class_1046.method_5437(this.field_679);
    }

    // $FF: renamed from: bB () java.lang.String
    public String method_36() {
        return this.field_680;
    }

    // $FF: renamed from: bt () java.lang.String
    public String method_37() {
        return this.field_674;
    }

    // $FF: renamed from: bu () com.google.android.gms.dynamic.d
    public class_206 method_38() {
        return class_1046.method_5437(this.field_675);
    }

    // $FF: renamed from: bw () java.lang.String
    public String method_39() {
        return this.field_677;
    }

    public String getBody() {
        return this.field_676;
    }

    // $FF: renamed from: i (int) void
    public void method_40(int param1) {
        // $FF: Couldn't be decompiled
    }
}
