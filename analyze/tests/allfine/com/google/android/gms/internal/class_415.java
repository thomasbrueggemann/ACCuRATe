package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.internal.class_27;
import com.google.android.gms.internal.class_3;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.er
@ez
public final class class_415 extends class_27.class_1462 {
    // $FF: renamed from: sM com.google.android.gms.internal.aa
    private final class_3 field_1539;
    // $FF: renamed from: sN java.lang.String
    private final String field_1540;
    // $FF: renamed from: sO java.lang.String
    private final String field_1541;

    public class_415(class_3 var1, String var2, String var3) {
        this.field_1539 = var1;
        this.field_1540 = var2;
        this.field_1541 = var3;
    }

    // $FF: renamed from: ar () void
    public void method_153() {
        this.field_1539.method_9();
    }

    // $FF: renamed from: as () void
    public void method_154() {
        this.field_1539.method_10();
    }

    // $FF: renamed from: c (com.google.android.gms.dynamic.d) void
    public void method_155(class_206 var1) {
        if(var1 != null) {
            this.field_1539.method_11((View)class_1046.method_5436(var1));
        }
    }

    // $FF: renamed from: cu () java.lang.String
    public String method_156() {
        return this.field_1540;
    }

    // $FF: renamed from: cv () java.lang.String
    public String method_157() {
        return this.field_1541;
    }
}
