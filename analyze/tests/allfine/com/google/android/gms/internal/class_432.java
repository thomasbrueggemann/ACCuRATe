package com.google.android.gms.internal;

import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_386;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fv;
import com.google.android.gms.internal.gk;
import com.google.android.gms.internal.gv;
import java.util.Map;
import java.util.concurrent.Future;

// $FF: renamed from: com.google.android.gms.internal.ft
@ez
public final class class_432 {
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private class_381 field_1603;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1604 = new Object();
    // $FF: renamed from: uq java.lang.String
    private String field_1605;
    // $FF: renamed from: ur com.google.android.gms.internal.gk
    private gk<fv> field_1606 = new class_386();
    // $FF: renamed from: us com.google.android.gms.internal.by
    public final class_9 field_1607 = new class_9() {
        // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
        public void method_24(gv param1, Map<String, String> param2) {
            // $FF: Couldn't be decompiled
        }
    };
    // $FF: renamed from: ut com.google.android.gms.internal.by
    public final class_9 field_1608 = new class_9() {
        // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
        public void method_24(gv param1, Map<String, String> param2) {
            // $FF: Couldn't be decompiled
        }
    };

    public class_432(String var1) {
        this.field_1605 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ft) java.lang.Object
    // $FF: synthetic method
    static Object method_2744(class_432 var0) {
        return var0.field_1604;
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ft) com.google.android.gms.internal.gk
    // $FF: synthetic method
    static class_386 method_2745(class_432 var0) {
        return var0.field_1606;
    }

    // $FF: renamed from: c (com.google.android.gms.internal.ft) java.lang.String
    // $FF: synthetic method
    static String method_2746(class_432 var0) {
        return var0.field_1605;
    }

    // $FF: renamed from: b (com.google.android.gms.internal.gv) void
    public void method_2747(class_381 var1) {
        this.field_1603 = var1;
    }

    // $FF: renamed from: cK () java.util.concurrent.Future
    public Future<fv> method_2748() {
        return this.field_1606;
    }
}
