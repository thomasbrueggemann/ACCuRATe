package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.cf
class class_587 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3099;
    private static final String aql;
    private static final String aqm;

    static {
        field_3099 = class_530.field_2497.toString();
        aql = class_529.field_2415.toString();
        aqm = class_529.field_2414.toString();
    }

    public class_587() {
        super(field_3099, new String[0]);
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        class_53.class_1172 var2 = (class_53.class_1172)var1.get(aql);
        class_53.class_1172 var3 = (class_53.class_1172)var1.get(aqm);
        double var4;
        double var6;
        if(var2 != null && var2 != class_634.method_3556() && var3 != null && var3 != class_634.method_3556()) {
            class_635 var8 = class_634.method_3544(var2);
            class_635 var9 = class_634.method_3544(var3);
            if(var8 != class_634.method_3554() && var9 != class_634.method_3554()) {
                double var10 = var8.doubleValue();
                var4 = var9.doubleValue();
                if(var10 <= var4) {
                    var6 = var10;
                    return class_634.method_3561(Long.valueOf(Math.round(var6 + Math.random() * (var4 - var6))));
                }
            }
        }

        var4 = 2.147483647E9D;
        var6 = 0.0D;
        return class_634.method_3561(Long.valueOf(Math.round(var6 + Math.random() * (var4 - var6))));
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return false;
    }
}
