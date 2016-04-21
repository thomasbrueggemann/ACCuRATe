package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_374;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_39;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_538;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.fd
@ez
public final class class_442 {
    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.u, com.google.android.gms.internal.fz$a, com.google.android.gms.internal.gv, com.google.android.gms.internal.ct, com.google.android.gms.internal.fd$a) com.google.android.gms.internal.gg
    public static class_370 method_2783(Context var0, class_538 var1, class_438.class_1623 var2, class_381 var3, class_39 var4, class_442.class_1637 var5) {
        Object var6;
        if(var2.field_5210.field_1709) {
            var6 = new class_375(var0, var1, new class_234(), var2, var5);
        } else {
            var6 = new class_374(var0, var2, var3, var4, var5);
        }

        ((class_370)var6).start();
        return (class_370)var6;
    }

    public interface class_1637 {
        // $FF: renamed from: a (com.google.android.gms.internal.fz) void
        void method_758(class_438 var1);
    }
}
