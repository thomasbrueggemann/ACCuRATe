package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_617;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.e
class class_568 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3080;
    private static final String anT;
    private static final String anU;
    // $FF: renamed from: lB android.content.Context
    private final Context field_3081;

    static {
        field_3080 = class_530.field_2505.toString();
        anT = class_529.field_2291.toString();
        anU = class_529.field_2294.toString();
    }

    public class_568(Context var1) {
        String var2 = field_3080;
        String[] var3 = new String[] {anU};
        super(var2, var3);
        this.field_3081 = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        class_53.class_1172 var2 = (class_53.class_1172)var1.get(anU);
        if(var2 == null) {
            return class_634.method_3556();
        } else {
            String var3 = class_634.method_3543(var2);
            class_53.class_1172 var4 = (class_53.class_1172)var1.get(anT);
            String var5;
            if(var4 != null) {
                var5 = class_634.method_3543(var4);
            } else {
                var5 = null;
            }

            String var6 = class_617.method_3482(this.field_3081, var3, var5);
            return var6 != null?class_634.method_3561(var6):class_634.method_3556();
        }
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
