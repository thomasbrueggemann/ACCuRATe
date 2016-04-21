package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.dg
abstract class class_579 extends class_560 {
    public class_579(String var1, String... var2) {
        super(var1, var2);
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        this.method_3419(var1);
        return class_634.method_3556();
    }

    // $FF: renamed from: E (java.util.Map) void
    public abstract void method_3419(Map<String, class_53.class_1172> var1);

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return false;
    }
}
