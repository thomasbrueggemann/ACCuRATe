package com.google.android.gms.analytics;

import android.text.TextUtils;

// $FF: renamed from: com.google.android.gms.analytics.w
class class_937 {
    // $FF: renamed from: AE java.lang.String
    private String field_4290;
    // $FF: renamed from: AF long
    private final long field_4291;
    // $FF: renamed from: AG long
    private final long field_4292;
    // $FF: renamed from: AH java.lang.String
    private String field_4293 = "https:";

    class_937(String var1, long var2, long var4) {
        this.field_4290 = var1;
        this.field_4291 = var2;
        this.field_4292 = var4;
    }

    // $FF: renamed from: aj (java.lang.String) void
    void method_4852(String var1) {
        this.field_4290 = var1;
    }

    // $FF: renamed from: ak (java.lang.String) void
    void method_4853(String var1) {
        if(var1 != null && !TextUtils.isEmpty(var1.trim()) && var1.toLowerCase().startsWith("http:")) {
            this.field_4293 = "http:";
        }
    }

    // $FF: renamed from: eF () java.lang.String
    String method_4854() {
        return this.field_4290;
    }

    // $FF: renamed from: eG () long
    long method_4855() {
        return this.field_4291;
    }

    // $FF: renamed from: eH () long
    long method_4856() {
        return this.field_4292;
    }

    // $FF: renamed from: eI () java.lang.String
    String method_4857() {
        return this.field_4293;
    }
}
