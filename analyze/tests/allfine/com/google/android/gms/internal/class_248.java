package com.google.android.gms.internal;

import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_538;
import com.google.android.gms.internal.ez;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.bq
@ez
public class class_248 {
    // $FF: renamed from: pw com.google.android.gms.internal.u
    private class_538 field_681;
    // $FF: renamed from: px com.google.android.gms.internal.ah
    private class_0 field_682;
    // $FF: renamed from: py org.json.JSONObject
    private JSONObject field_683;

    public class_248(class_538 var1, class_0 var2, JSONObject var3) {
        this.field_681 = var1;
        this.field_682 = var2;
        this.field_683 = var3;
    }

    // $FF: renamed from: as () void
    public void method_1602() {
        this.field_681.method_23();
    }

    // $FF: renamed from: b (java.lang.String, int) void
    public void method_1603(String var1, int var2) {
        try {
            JSONObject var3 = new JSONObject();
            var3.put("asset", var2);
            var3.put("template", var1);
            JSONObject var7 = new JSONObject();
            var7.put("ad", this.field_683);
            var7.put("click", var3);
            this.field_682.method_3("google.afma.nativeAds.handleClick", var7);
        } catch (JSONException var8) {
            class_378.method_2463("Unable to create click JSON.", var8);
        }
    }

    public interface class_1288 {
        // $FF: renamed from: a (com.google.android.gms.internal.bq) void
        void method_832(class_248 var1);
    }
}
