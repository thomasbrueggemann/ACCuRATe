package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.f
public class class_646 extends a<Integer> {
    public class_646(String var1, int var2) {
        super(var1, var2);
    }

    // $FF: renamed from: a (android.os.Bundle, java.lang.Integer) void
    protected void method_3647(Bundle var1, Integer var2) {
        var1.putInt(this.getName(), var2.intValue());
    }

    // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_3645(DataHolder var1, int var2, int var3) {
        return this.method_3648(var1, var2, var3);
    }

    // $FF: renamed from: g (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Integer
    protected Integer method_3648(DataHolder var1, int var2, int var3) {
        return Integer.valueOf(var1.method_5988(this.getName(), var2, var3));
    }

    // $FF: renamed from: g (android.os.Bundle) java.lang.Object
    // $FF: synthetic method
    protected Object method_3646(Bundle var1) {
        return this.method_3649(var1);
    }

    // $FF: renamed from: j (android.os.Bundle) java.lang.Integer
    protected Integer method_3649(Bundle var1) {
        return Integer.valueOf(var1.getInt(this.getName()));
    }
}
