package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ca
class class_585 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3097;

    static {
        field_3097 = class_530.field_2495.toString();
    }

    public class_585() {
        super(field_3097, new String[0]);
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        return class_634.method_3561(VERSION.RELEASE);
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
