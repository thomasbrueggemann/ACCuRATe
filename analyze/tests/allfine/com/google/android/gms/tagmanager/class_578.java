package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.dk
class class_578 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3091;
    private static final String apf;

    static {
        field_3091 = class_530.field_2542.toString();
        apf = class_529.field_2308.toString();
    }

    public class_578() {
        String var1 = field_3091;
        String[] var2 = new String[] {apf};
        super(var1, var2);
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        return class_634.method_3561(class_634.method_3543((class_53.class_1172)var1.get(apf)).toUpperCase());
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
