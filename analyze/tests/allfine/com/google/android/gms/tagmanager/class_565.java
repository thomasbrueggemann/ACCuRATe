package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.p
class class_565 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3076;
    // $FF: renamed from: Sx java.lang.String
    private final String field_3077;

    static {
        field_3076 = class_530.field_2484.toString();
    }

    public class_565(String var1) {
        super(field_3076, new String[0]);
        this.field_3077 = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        return this.field_3077 == null?class_634.method_3556():class_634.method_3561(this.field_3077);
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
