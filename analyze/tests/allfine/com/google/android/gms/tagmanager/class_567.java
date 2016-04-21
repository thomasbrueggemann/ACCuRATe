package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import com.google.android.gms.tagmanager.class_718;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.b
class class_567 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3079;
    private final class_718 anS;

    static {
        field_3079 = class_530.field_2568.toString();
    }

    public class_567(Context var1) {
        this(class_718.method_3921(var1));
    }

    class_567(class_718 var1) {
        super(field_3079, new String[0]);
        this.anS = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        String var2 = this.anS.method_3926();
        return var2 == null?class_634.method_3556():class_634.method_3561(var2);
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return false;
    }
}
