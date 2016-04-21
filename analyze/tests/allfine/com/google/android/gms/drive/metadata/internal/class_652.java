package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.b
public class class_652 extends a<Boolean> {
    public class_652(String var1, int var2) {
        super(var1, var2);
    }

    // $FF: renamed from: a (android.os.Bundle, java.lang.Boolean) void
    protected void method_3662(Bundle var1, Boolean var2) {
        var1.putBoolean(this.getName(), var2.booleanValue());
    }

    // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_3645(DataHolder var1, int var2, int var3) {
        return this.method_3663(var1, var2, var3);
    }

    // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Boolean
    protected Boolean method_3663(DataHolder var1, int var2, int var3) {
        return Boolean.valueOf(var1.method_5990(this.getName(), var2, var3));
    }

    // $FF: renamed from: g (android.os.Bundle) java.lang.Object
    // $FF: synthetic method
    protected Object method_3646(Bundle var1) {
        return this.method_3664(var1);
    }

    // $FF: renamed from: h (android.os.Bundle) java.lang.Boolean
    protected Boolean method_3664(Bundle var1) {
        return Boolean.valueOf(var1.getBoolean(this.getName()));
    }
}
