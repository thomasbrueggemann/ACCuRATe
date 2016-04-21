package com.google.android.gms.tagmanager;

import android.text.TextUtils;

// $FF: renamed from: com.google.android.gms.tagmanager.ap
class class_615 {
    // $FF: renamed from: AF long
    private final long field_3126;
    // $FF: renamed from: AG long
    private final long field_3127;
    private final long apm;
    private String apn;

    class_615(long var1, long var3, long var5) {
        this.field_3126 = var1;
        this.field_3127 = var3;
        this.apm = var5;
    }

    // $FF: renamed from: ak (java.lang.String) void
    void method_3472(String var1) {
        if(var1 != null && !TextUtils.isEmpty(var1.trim())) {
            this.apn = var1;
        }
    }

    // $FF: renamed from: eG () long
    long method_3473() {
        return this.field_3126;
    }

    // $FF: renamed from: ot () long
    long method_3474() {
        return this.apm;
    }

    // $FF: renamed from: ou () java.lang.String
    String method_3475() {
        return this.apn;
    }
}
