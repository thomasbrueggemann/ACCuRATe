package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_596;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// $FF: renamed from: com.google.android.gms.tagmanager.ci
class class_601 extends class_596 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3112;
    private static final String aqp;

    static {
        field_3112 = class_530.field_2548.toString();
        aqp = class_529.field_2392.toString();
    }

    public class_601() {
        super(field_3112);
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
    protected boolean method_3446(String var1, String var2, Map<String, class_53.class_1172> var3) {
        byte var4;
        if(class_634.method_3547((class_53.class_1172)var3.get(aqp)).booleanValue()) {
            var4 = 66;
        } else {
            var4 = 64;
        }

        try {
            boolean var6 = Pattern.compile(var2, var4).matcher(var1).find();
            return var6;
        } catch (PatternSyntaxException var7) {
            return false;
        }
    }
}
