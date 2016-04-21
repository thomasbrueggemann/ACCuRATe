package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_579;
import com.google.android.gms.tagmanager.class_634;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.w
class class_580 extends class_579 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3092;
    private static final String VALUE;
    private static final String apa;
    private final DataLayer aod;

    static {
        field_3092 = class_530.field_2540.toString();
        VALUE = class_529.field_2473.toString();
        apa = class_529.field_2287.toString();
    }

    public class_580(DataLayer var1) {
        String var2 = field_3092;
        String[] var3 = new String[] {VALUE};
        super(var2, var3);
        this.aod = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.d$a) void
    private void method_3420(class_53.class_1172 var1) {
        if(var1 != null && var1 != class_634.method_3550()) {
            String var2 = class_634.method_3543(var1);
            if(var2 != class_634.method_3555()) {
                this.aod.method_5146(var2);
                return;
            }
        }

    }

    // $FF: renamed from: b (com.google.android.gms.internal.d$a) void
    private void method_3421(class_53.class_1172 var1) {
        if(var1 != null && var1 != class_634.method_3550()) {
            Object var2 = class_634.method_3548(var1);
            if(var2 instanceof List) {
                Iterator var3 = ((List)var2).iterator();

                while(var3.hasNext()) {
                    Object var4 = var3.next();
                    if(var4 instanceof Map) {
                        Map var5 = (Map)var4;
                        this.aod.push(var5);
                    }
                }
            }
        }

    }

    // $FF: renamed from: E (java.util.Map) void
    public void method_3419(Map<String, class_53.class_1172> var1) {
        this.method_3421((class_53.class_1172)var1.get(VALUE));
        this.method_3420((class_53.class_1172)var1.get(apa));
    }
}
