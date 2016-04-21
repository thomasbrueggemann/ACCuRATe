package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.analytics.aa
class class_952 {
    // $FF: renamed from: AU java.util.Map
    private final Map<String, Integer> field_4465 = new HashMap();
    // $FF: renamed from: AV java.util.Map
    private final Map<String, String> field_4466 = new HashMap();
    // $FF: renamed from: AW boolean
    private final boolean field_4467;
    // $FF: renamed from: AX java.lang.String
    private final String field_4468;

    class_952(String var1, boolean var2) {
        this.field_4467 = var2;
        this.field_4468 = var1;
    }

    // $FF: renamed from: e (java.lang.String, int) void
    void method_5017(String var1, int var2) {
        if(this.field_4467) {
            Integer var3 = (Integer)this.field_4465.get(var1);
            if(var3 == null) {
                var3 = Integer.valueOf(0);
            }

            this.field_4465.put(var1, Integer.valueOf(var2 + var3.intValue()));
        }
    }

    // $FF: renamed from: eL () java.lang.String
    String method_5018() {
        if(!this.field_4467) {
            return "";
        } else {
            StringBuilder var1 = new StringBuilder();
            var1.append(this.field_4468);
            Iterator var3 = this.field_4465.keySet().iterator();

            while(var3.hasNext()) {
                String var7 = (String)var3.next();
                var1.append("&").append(var7).append("=").append(this.field_4465.get(var7));
            }

            Iterator var4 = this.field_4466.keySet().iterator();

            while(var4.hasNext()) {
                String var5 = (String)var4.next();
                var1.append("&").append(var5).append("=").append((String)this.field_4466.get(var5));
            }

            return var1.toString();
        }
    }
}
