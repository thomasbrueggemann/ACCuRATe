package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.aa
class class_573 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3086;

    static {
        field_3086 = class_530.field_2486.toString();
    }

    public class_573() {
        super(field_3086, new String[0]);
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        String var2 = Build.MANUFACTURER;
        String var3 = Build.MODEL;
        if(!var3.startsWith(var2) && !var2.equals("unknown")) {
            var3 = var2 + " " + var3;
        }

        return class_634.method_3561(var3);
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}