package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_617;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ax
class class_590 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3102;
    private static final String anT;
    // $FF: renamed from: lB android.content.Context
    private final Context field_3103;

    static {
        field_3102 = class_530.field_2536.toString();
        anT = class_529.field_2291.toString();
    }

    public class_590(Context var1) {
        super(field_3102, new String[0]);
        this.field_3103 = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        String var2;
        if((class_53.class_1172)var1.get(anT) != null) {
            var2 = class_634.method_3543((class_53.class_1172)var1.get(anT));
        } else {
            var2 = null;
        }

        String var3 = class_617.method_3481(this.field_3103, var2);
        return var3 != null?class_634.method_3561(var3):class_634.method_3556();
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
