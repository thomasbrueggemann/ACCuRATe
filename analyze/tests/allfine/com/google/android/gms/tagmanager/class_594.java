package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Locale;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.bc
class class_594 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3107;

    static {
        field_3107 = class_530.field_2494.toString();
    }

    public class_594() {
        super(field_3107, new String[0]);
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        Locale var2 = Locale.getDefault();
        if(var2 == null) {
            return class_634.method_3556();
        } else {
            String var3 = var2.getLanguage();
            return var3 == null?class_634.method_3556():class_634.method_3561(var3.toLowerCase());
        }
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return false;
    }
}
