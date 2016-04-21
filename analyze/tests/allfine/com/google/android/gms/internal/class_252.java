package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.bm
@ez
public final class class_252 {
    // $FF: renamed from: oU java.lang.String
    private String field_697 = null;
    // $FF: renamed from: oV java.lang.String
    private String field_698 = null;
    // $FF: renamed from: oW java.lang.String
    private String field_699 = null;

    public class_252() {
        this.field_697 = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
        this.field_698 = null;
        this.field_699 = null;
    }

    public class_252(String var1, String var2, String var3) {
        if(TextUtils.isEmpty(var1)) {
            this.field_697 = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
        } else {
            this.field_697 = var1;
        }

        this.field_698 = var2;
        this.field_699 = var3;
    }

    // $FF: renamed from: bp () java.lang.String
    public String method_1614() {
        return this.field_697;
    }

    // $FF: renamed from: bq () java.lang.String
    public String method_1615() {
        return this.field_698;
    }

    // $FF: renamed from: br () java.lang.String
    public String method_1616() {
        return this.field_699;
    }
}
