package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.f
class class_570 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3083;
    private final Context mContext;

    static {
        field_3083 = class_530.field_2570.toString();
    }

    public class_570(Context var1) {
        super(field_3083, new String[0]);
        this.mContext = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        return class_634.method_3561(this.mContext.getPackageName());
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
