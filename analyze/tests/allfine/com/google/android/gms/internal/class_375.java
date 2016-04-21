package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_248;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_41;
import com.google.android.gms.internal.class_437;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_442;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_450;
import com.google.android.gms.internal.class_452;
import com.google.android.gms.internal.class_454;
import com.google.android.gms.internal.class_538;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fz;
import java.util.List;
import java.util.concurrent.Future;

// $FF: renamed from: com.google.android.gms.internal.fn
@ez
public class class_375 extends class_370 {
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1377;
    // $FF: renamed from: sZ com.google.android.gms.internal.fk
    private final class_447 field_1378;
    // $FF: renamed from: tU com.google.android.gms.internal.fo
    private final class_437 field_1379;
    // $FF: renamed from: tV java.util.concurrent.Future
    private Future<fz> field_1380;
    // $FF: renamed from: tm com.google.android.gms.internal.fd$a
    private final class_442.class_1637 field_1381;
    // $FF: renamed from: tn com.google.android.gms.internal.fz$a
    private final class_438.class_1623 field_1382;

    public class_375(Context var1, class_538 var2, class_234 var3, class_438.class_1623 var4, class_442.class_1637 var5) {
        this(var4, var5, new class_437(var1, var2, var3, new class_368(), var4));
    }

    class_375(class_438.class_1623 var1, class_442.class_1637 var2, class_437 var3) {
        this.field_1377 = new Object();
        this.field_1382 = var1;
        this.field_1378 = var1.field_5210;
        this.field_1381 = var2;
        this.field_1379 = var3;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fn) com.google.android.gms.internal.fd$a
    // $FF: synthetic method
    static class_442.class_1637 method_2446(class_375 var0) {
        return var0.field_1381;
    }

    // $FF: renamed from: r (int) com.google.android.gms.internal.fz
    private class_438 method_2447(int var1) {
        return new class_438(this.field_1382.field_5209.field_1722, (class_381)null, (List)null, var1, (List)null, (List)null, this.field_1378.orientation, this.field_1378.field_1694, this.field_1382.field_5209.field_1715, false, (class_450)null, (class_41)null, (String)null, (class_452)null, (class_454)null, this.field_1378.field_1700, this.field_1382.field_5204, this.field_1378.field_1698, this.field_1382.field_5207, this.field_1378.field_1703, this.field_1378.field_1704, this.field_1382.field_5205, (class_248.class_1288)null);
    }

    // $FF: renamed from: co () void
    public void method_2419() {
        // $FF: Couldn't be decompiled
    }

    public void onStop() {
        // $FF: Couldn't be decompiled
    }
}
