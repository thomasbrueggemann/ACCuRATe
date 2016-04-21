package com.google.android.gms.internal;

import com.google.android.gms.internal.class_455;
import com.google.android.gms.internal.ez;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.cl
@ez
public final class class_450 {
    // $FF: renamed from: pW java.lang.String
    public final String field_1725;
    // $FF: renamed from: pX java.lang.String
    public final String field_1726;
    // $FF: renamed from: pY java.util.List
    public final List<String> field_1727;
    // $FF: renamed from: pZ java.lang.String
    public final String field_1728;
    // $FF: renamed from: qa java.lang.String
    public final String field_1729;
    // $FF: renamed from: qb java.util.List
    public final List<String> field_1730;
    // $FF: renamed from: qc java.lang.String
    public final String field_1731;

    public class_450(JSONObject var1) throws JSONException {
        this.field_1726 = var1.getString("id");
        JSONArray var2 = var1.getJSONArray("adapters");
        ArrayList var3 = new ArrayList(var2.length());

        for(int var4 = 0; var4 < var2.length(); ++var4) {
            var3.add(var2.getString(var4));
        }

        this.field_1727 = Collections.unmodifiableList(var3);
        this.field_1728 = var1.optString("allocation_id", (String)null);
        this.field_1730 = class_455.method_2830(var1, "imp_urls");
        JSONObject var5 = var1.optJSONObject("ad");
        String var6;
        if(var5 != null) {
            var6 = var5.toString();
        } else {
            var6 = null;
        }

        this.field_1725 = var6;
        JSONObject var7 = var1.optJSONObject("data");
        String var8;
        if(var7 != null) {
            var8 = var7.toString();
        } else {
            var8 = null;
        }

        this.field_1731 = var8;
        String var9 = null;
        if(var7 != null) {
            var9 = var7.optString("class_name");
        }

        this.field_1729 = var9;
    }
}
