package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_596;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ae
class class_599 extends class_596 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3110;

    static {
        field_3110 = class_530.field_2552.toString();
    }

    public class_599() {
        super(field_3110);
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
    protected boolean method_3446(String var1, String var2, Map<String, class_53.class_1172> var3) {
        return var1.equals(var2);
    }
}
