package com.google.android.gms.internal;

import com.google.android.gms.internal.class_2;
import com.google.android.gms.internal.class_207;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.ez;
import java.util.HashMap;

// $FF: renamed from: com.google.android.gms.internal.z
@ez
class class_537 implements class_2 {
    // $FF: renamed from: mi com.google.android.gms.internal.gv
    private class_381 field_2875;

    public class_537(class_381 var1) {
        this.field_2875 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.af, boolean) void
    public void method_8(class_207 var1, boolean var2) {
        HashMap var3 = new HashMap();
        String var4;
        if(var2) {
            var4 = "1";
        } else {
            var4 = "0";
        }

        var3.put("isVisible", var4);
        this.field_2875.method_2479("onAdVisibilityChanged", var3);
    }
}
