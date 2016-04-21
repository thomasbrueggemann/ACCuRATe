package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.u
class class_562 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3073;
    private static final String NAME;
    private static final String aoP;
    private final DataLayer aod;

    static {
        field_3073 = class_530.field_2483.toString();
        NAME = class_529.field_2365.toString();
        aoP = class_529.field_2355.toString();
    }

    public class_562(DataLayer var1) {
        String var2 = field_3073;
        String[] var3 = new String[] {NAME};
        super(var2, var3);
        this.aod = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        Object var2 = this.aod.get(class_634.method_3543((class_53.class_1172)var1.get(NAME)));
        if(var2 == null) {
            class_53.class_1172 var3 = (class_53.class_1172)var1.get(aoP);
            return var3 != null?var3:class_634.method_3556();
        } else {
            return class_634.method_3561(var2);
        }
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return false;
    }
}
