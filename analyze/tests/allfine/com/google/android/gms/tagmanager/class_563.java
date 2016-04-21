package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_634;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.s
class class_563 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3074;
    private static final String anV;
    private static final String aoE;
    private final class_563.class_1783 aoF;

    static {
        field_3074 = class_530.field_2492.toString();
        aoE = class_529.field_2333.toString();
        anV = class_529.field_2297.toString();
    }

    public class_563(class_563.class_1783 var1) {
        String var2 = field_3074;
        String[] var3 = new String[] {aoE};
        super(var2, var3);
        this.aoF = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        String var2 = class_634.method_3543((class_53.class_1172)var1.get(aoE));
        HashMap var3 = new HashMap();
        class_53.class_1172 var4 = (class_53.class_1172)var1.get(anV);
        if(var4 != null) {
            Object var7 = class_634.method_3548(var4);
            if(!(var7 instanceof Map)) {
                class_612.method_3459("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return class_634.method_3556();
            }

            Iterator var8 = ((Map)var7).entrySet().iterator();

            while(var8.hasNext()) {
                Entry var9 = (Entry)var8.next();
                var3.put(var9.getKey().toString(), var9.getValue());
            }
        }

        try {
            class_53.class_1172 var6 = class_634.method_3561(this.aoF.method_1057(var2, var3));
            return var6;
        } catch (Exception var10) {
            class_612.method_3459("Custom macro/tag " + var2 + " threw exception " + var10.getMessage());
            return class_634.method_3556();
        }
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return false;
    }

    public interface class_1783 {
        // $FF: renamed from: b (java.lang.String, java.util.Map) java.lang.Object
        Object method_1057(String var1, Map<String, Object> var2);
    }
}
