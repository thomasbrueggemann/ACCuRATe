package com.google.android.gms.internal;

import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gv;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ca
@ez
public class class_462 implements class_9 {
    // $FF: renamed from: pJ com.google.android.gms.internal.cb
    private final class_43 field_1791;

    public class_462(class_43 var1) {
        this.field_1791 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
    public void method_24(gv var1, Map<String, String> var2) {
        boolean var3 = "1".equals(var2.get("transparentBackground"));
        this.field_1791.method_179(var3);
    }
}
