package com.google.android.gms.internal;

import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.ez;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.ad
@ez
public final class class_212 {
    // $FF: renamed from: ms java.lang.String
    private final String field_526;
    // $FF: renamed from: mt org.json.JSONObject
    private final JSONObject field_527;
    // $FF: renamed from: mu java.lang.String
    private final String field_528;
    // $FF: renamed from: mv java.lang.String
    private final String field_529;

    public class_212(String var1, class_379 var2, String var3, JSONObject var4) {
        this.field_529 = var2.field_1387;
        this.field_527 = var4;
        this.field_528 = var1;
        this.field_526 = var3;
    }

    // $FF: renamed from: aA () java.lang.String
    public String method_1482() {
        return this.field_529;
    }

    // $FF: renamed from: aB () org.json.JSONObject
    public JSONObject method_1483() {
        return this.field_527;
    }

    // $FF: renamed from: aC () java.lang.String
    public String method_1484() {
        return this.field_528;
    }

    // $FF: renamed from: az () java.lang.String
    public String method_1485() {
        return this.field_526;
    }
}
