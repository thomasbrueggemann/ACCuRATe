package com.google.android.gms.internal;

import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_450;
import com.google.android.gms.internal.class_455;
import com.google.android.gms.internal.ez;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.cm
@ez
public final class class_452 {
    // $FF: renamed from: qd java.util.List
    public final List<cl> field_1738;
    // $FF: renamed from: qe long
    public final long field_1739;
    // $FF: renamed from: qf java.util.List
    public final List<String> field_1740;
    // $FF: renamed from: qg java.util.List
    public final List<String> field_1741;
    // $FF: renamed from: qh java.util.List
    public final List<String> field_1742;
    // $FF: renamed from: qi java.lang.String
    public final String field_1743;
    // $FF: renamed from: qj long
    public final long field_1744;
    // $FF: renamed from: qk int
    public int field_1745;
    // $FF: renamed from: ql int
    public int field_1746;

    public class_452(String var1) throws JSONException {
        JSONObject var2 = new JSONObject(var1);
        if(class_378.method_2466(2)) {
            class_378.method_2460("Mediation Response JSON: " + var2.toString(2));
        }

        JSONArray var3 = var2.getJSONArray("ad_networks");
        ArrayList var4 = new ArrayList(var3.length());
        int var5 = -1;

        for(int var6 = 0; var6 < var3.length(); ++var6) {
            class_450 var7 = new class_450(var3.getJSONObject(var6));
            var4.add(var7);
            if(var5 < 0 && this.method_2809(var7)) {
                var5 = var6;
            }
        }

        this.field_1745 = var5;
        this.field_1746 = var3.length();
        this.field_1738 = Collections.unmodifiableList(var4);
        this.field_1743 = var2.getString("qdata");
        JSONObject var9 = var2.optJSONObject("settings");
        if(var9 != null) {
            this.field_1739 = var9.optLong("ad_network_timeout_millis", -1L);
            this.field_1740 = class_455.method_2830(var9, "click_urls");
            this.field_1741 = class_455.method_2830(var9, "imp_urls");
            this.field_1742 = class_455.method_2830(var9, "nofill_urls");
            long var10 = var9.optLong("refresh", -1L);
            long var12;
            if(var10 > 0L) {
                var12 = var10 * 1000L;
            } else {
                var12 = -1L;
            }

            this.field_1744 = var12;
        } else {
            this.field_1739 = -1L;
            this.field_1740 = null;
            this.field_1741 = null;
            this.field_1742 = null;
            this.field_1744 = -1L;
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.cl) boolean
    private boolean method_2809(class_450 var1) {
        Iterator var2 = var1.field_1727.iterator();

        do {
            if(!var2.hasNext()) {
                return false;
            }
        } while(!((String)var2.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"));

        return true;
    }
}
