package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.cd
abstract class class_595 extends class_560 {
    private static final String apf;
    private static final String aqb;

    static {
        apf = class_529.field_2308.toString();
        aqb = class_529.field_2309.toString();
    }

    public class_595(String var1) {
        String[] var2 = new String[] {apf, aqb};
        super(var1, var2);
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        Iterator var2 = var1.values().iterator();

        while(var2.hasNext()) {
            if((class_53.class_1172)var2.next() == class_634.method_3556()) {
                return class_634.method_3561(Boolean.valueOf(false));
            }
        }

        class_53.class_1172 var3 = (class_53.class_1172)var1.get(apf);
        class_53.class_1172 var4 = (class_53.class_1172)var1.get(aqb);
        boolean var5;
        if(var3 != null && var4 != null) {
            var5 = this.method_3445(var3, var4, var1);
        } else {
            var5 = false;
        }

        return class_634.method_3561(Boolean.valueOf(var5));
    }

    // $FF: renamed from: a (com.google.android.gms.internal.d$a, com.google.android.gms.internal.d$a, java.util.Map) boolean
    protected abstract boolean method_3445(class_53.class_1172 var1, class_53.class_1172 var2, Map<String, class_53.class_1172> var3);

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
