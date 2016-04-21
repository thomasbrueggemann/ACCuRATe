package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.m
class class_564 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3075;
    private static final String VALUE;

    static {
        field_3075 = class_530.field_2481.toString();
        VALUE = class_529.field_2473.toString();
    }

    public class_564() {
        String var1 = field_3075;
        String[] var2 = new String[] {VALUE};
        super(var1, var2);
    }

    // $FF: renamed from: nQ () java.lang.String
    public static String method_3417() {
        return field_3075;
    }

    // $FF: renamed from: nR () java.lang.String
    public static String method_3418() {
        return VALUE;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        return (class_53.class_1172)var1.get(VALUE);
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
