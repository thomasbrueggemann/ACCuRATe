package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.class_595;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.dd
abstract class class_596 extends class_595 {
    public class_596(String var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.d$a, com.google.android.gms.internal.d$a, java.util.Map) boolean
    protected boolean method_3445(class_53.class_1172 var1, class_53.class_1172 var2, Map<String, class_53.class_1172> var3) {
        String var4 = class_634.method_3543(var1);
        String var5 = class_634.method_3543(var2);
        return var4 != class_634.method_3555() && var5 != class_634.method_3555()?this.method_3446(var4, var5, var3):false;
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
    protected abstract boolean method_3446(String var1, String var2, Map<String, class_53.class_1172> var3);
}
