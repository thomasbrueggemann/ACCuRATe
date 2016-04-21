package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.bl
class class_593 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3106;
    private final Context mContext;

    static {
        field_3106 = class_530.field_2538.toString();
    }

    public class_593(Context var1) {
        super(field_3106, new String[0]);
        this.mContext = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        String var2 = this.method_3444(this.mContext);
        return var2 == null?class_634.method_3556():class_634.method_3561(var2);
    }

    // $FF: renamed from: Y (android.content.Context) java.lang.String
    protected String method_3444(Context var1) {
        return Secure.getString(var1.getContentResolver(), "android_id");
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
