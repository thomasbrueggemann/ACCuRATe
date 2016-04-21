package com.google.android.gms.analytics;

import android.app.Activity;
import com.google.android.gms.analytics.class_176;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.analytics.ai
class class_954 implements class_176 {
    // $FF: renamed from: BC java.lang.String
    String field_4470;
    // $FF: renamed from: BD double
    double field_4471 = -1.0D;
    // $FF: renamed from: BE int
    int field_4472 = -1;
    // $FF: renamed from: BF int
    int field_4473 = -1;
    // $FF: renamed from: BG int
    int field_4474 = -1;
    // $FF: renamed from: BH int
    int field_4475 = -1;
    // $FF: renamed from: BI java.util.Map
    Map<String, String> field_4476 = new HashMap();

    // $FF: renamed from: am (java.lang.String) java.lang.String
    public String method_5028(String var1) {
        String var2 = (String)this.field_4476.get(var1);
        return var2 != null?var2:var1;
    }

    // $FF: renamed from: eZ () boolean
    public boolean method_5029() {
        return this.field_4470 != null;
    }

    // $FF: renamed from: fa () java.lang.String
    public String method_5030() {
        return this.field_4470;
    }

    // $FF: renamed from: fb () boolean
    public boolean method_5031() {
        return this.field_4471 >= 0.0D;
    }

    // $FF: renamed from: fc () double
    public double method_5032() {
        return this.field_4471;
    }

    // $FF: renamed from: fd () boolean
    public boolean method_5033() {
        return this.field_4472 >= 0;
    }

    // $FF: renamed from: fe () boolean
    public boolean method_5034() {
        return this.field_4473 != -1;
    }

    // $FF: renamed from: ff () boolean
    public boolean method_5035() {
        return this.field_4473 == 1;
    }

    // $FF: renamed from: fg () boolean
    public boolean method_5036() {
        return this.field_4474 != -1;
    }

    // $FF: renamed from: fh () boolean
    public boolean method_5037() {
        return this.field_4474 == 1;
    }

    // $FF: renamed from: fi () boolean
    public boolean method_5038() {
        return this.field_4475 == 1;
    }

    public int getSessionTimeout() {
        return this.field_4472;
    }

    // $FF: renamed from: k (android.app.Activity) java.lang.String
    public String method_5039(Activity var1) {
        return this.method_5028(var1.getClass().getCanonicalName());
    }
}
