package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_602;
import com.google.android.gms.tagmanager.dh;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.am
class class_604 extends class_602 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3114;

    static {
        field_3114 = class_530.field_2555.toString();
    }

    public class_604() {
        super(field_3114);
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.dh, com.google.android.gms.tagmanager.dh, java.util.Map) boolean
    protected boolean method_3447(dh var1, dh var2, Map<String, class_53.class_1172> var3) {
        return var1.method_3568(var2) > 0;
    }
}
