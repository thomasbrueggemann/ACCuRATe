package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.class_14;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.class_334;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.ii
public abstract class class_328 {
    // $FF: renamed from: Go com.google.android.gms.internal.ip
    protected final class_332 field_1091;
    // $FF: renamed from: Gp java.lang.String
    private final String field_1092;
    // $FF: renamed from: Gq com.google.android.gms.internal.ir
    private class_14 field_1093;

    protected class_328(String var1, String var2, String var3) {
        class_334.method_2301(var1);
        this.field_1092 = var1;
        this.field_1091 = new class_332(var2);
        if(!TextUtils.isEmpty(var3)) {
            this.field_1091.method_2283(var3);
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.ir) void
    public final void method_2246(class_14 var1) {
        this.field_1093 = var1;
        if(this.field_1093 == null) {
            this.method_2250();
        }

    }

    // $FF: renamed from: a (java.lang.String, long, java.lang.String) void
    protected final void method_2247(String var1, long var2, String var4) throws IOException {
        this.field_1091.method_2281("Sending text message: %s to: %s", new Object[] {var1, var4});
        this.field_1093.method_92(this.field_1092, var1, var2, var4);
    }

    // $FF: renamed from: aD (java.lang.String) void
    public void method_2248(String var1) {
    }

    // $FF: renamed from: b (long, int) void
    public void method_2249(long var1, int var3) {
    }

    // $FF: renamed from: fA () void
    public void method_2250() {
    }

    // $FF: renamed from: fz () long
    protected final long method_2251() {
        return this.field_1093.method_93();
    }

    public final String getNamespace() {
        return this.field_1092;
    }
}
