package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.class_595;
import com.google.android.gms.tagmanager.class_634;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.dh;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.by
abstract class class_602 extends class_595 {
    public class_602(String var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.d$a, com.google.android.gms.internal.d$a, java.util.Map) boolean
    protected boolean method_3445(class_53.class_1172 var1, class_53.class_1172 var2, Map<String, class_53.class_1172> var3) {
        class_635 var4 = class_634.method_3544(var1);
        class_635 var5 = class_634.method_3544(var2);
        return var4 != class_634.method_3554() && var5 != class_634.method_3554()?this.method_3447(var4, var5, var3):false;
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.dh, com.google.android.gms.tagmanager.dh, java.util.Map) boolean
    protected abstract boolean method_3447(dh var1, dh var2, Map<String, class_53.class_1172> var3);
}
