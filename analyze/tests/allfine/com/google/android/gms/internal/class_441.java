package com.google.android.gms.internal;

import com.google.android.gms.internal.ez;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.fv
@ez
class class_441 {
    // $FF: renamed from: tc int
    private int field_1672;
    // $FF: renamed from: uJ java.util.List
    private final List<String> field_1673;
    // $FF: renamed from: uK java.util.List
    private final List<String> field_1674;
    // $FF: renamed from: uL java.lang.String
    private final String field_1675;
    // $FF: renamed from: uM java.lang.String
    private final String field_1676;
    // $FF: renamed from: uN java.lang.String
    private final String field_1677;
    // $FF: renamed from: uO java.lang.String
    private final String field_1678;
    // $FF: renamed from: uP boolean
    private final boolean field_1679;
    // $FF: renamed from: uQ int
    private final int field_1680;
    // $FF: renamed from: uR java.lang.String
    private String field_1681;

    public class_441(int var1, Map<String, String> var2) {
        this.field_1681 = (String)var2.get("url");
        this.field_1676 = (String)var2.get("base_uri");
        this.field_1677 = (String)var2.get("post_parameters");
        this.field_1679 = parseBoolean((String)var2.get("drt_include"));
        this.field_1675 = (String)var2.get("activation_overlay_url");
        this.field_1674 = this.method_2779((String)var2.get("check_packages"));
        this.field_1680 = this.parseInt((String)var2.get("request_id"));
        this.field_1678 = (String)var2.get("type");
        this.field_1673 = this.method_2779((String)var2.get("errors"));
        this.field_1672 = var1;
    }

    // $FF: renamed from: J (java.lang.String) java.util.List
    private List<String> method_2779(String var1) {
        return var1 == null?null:Arrays.asList(var1.split(","));
    }

    private static boolean parseBoolean(String var0) {
        return var0 != null && (var0.equals("1") || var0.equals("true"));
    }

    private int parseInt(String var1) {
        return var1 == null?0:Integer.parseInt(var1);
    }

    // $FF: renamed from: cL () java.util.List
    public List<String> method_2780() {
        return this.field_1673;
    }

    // $FF: renamed from: cM () java.lang.String
    public String method_2781() {
        return this.field_1677;
    }

    // $FF: renamed from: cN () boolean
    public boolean method_2782() {
        return this.field_1679;
    }

    public int getErrorCode() {
        return this.field_1672;
    }

    public String getType() {
        return this.field_1678;
    }

    public String getUrl() {
        return this.field_1681;
    }

    public void setUrl(String var1) {
        this.field_1681 = var1;
    }
}
