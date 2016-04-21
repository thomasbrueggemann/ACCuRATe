package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.ez;
import java.util.LinkedList;

// $FF: renamed from: com.google.android.gms.internal.ga
@ez
public class class_390 {
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1441;
    // $FF: renamed from: uC boolean
    private boolean field_1442;
    // $FF: renamed from: vA java.lang.String
    private final String field_1443;
    // $FF: renamed from: vB long
    private long field_1444;
    // $FF: renamed from: vC long
    private long field_1445;
    // $FF: renamed from: vD long
    private long field_1446;
    // $FF: renamed from: vE long
    private long field_1447;
    // $FF: renamed from: vF long
    private long field_1448;
    // $FF: renamed from: vG long
    private long field_1449;
    // $FF: renamed from: vx com.google.android.gms.internal.gb
    private final class_389 field_1450;
    // $FF: renamed from: vy java.util.LinkedList
    private final LinkedList<class_390.class_1736> field_1451;
    // $FF: renamed from: vz java.lang.String
    private final String field_1452;

    public class_390(class_389 var1, String var2, String var3) {
        this.field_1441 = new Object();
        this.field_1444 = -1L;
        this.field_1445 = -1L;
        this.field_1442 = false;
        this.field_1446 = -1L;
        this.field_1447 = 0L;
        this.field_1448 = -1L;
        this.field_1449 = -1L;
        this.field_1450 = var1;
        this.field_1452 = var2;
        this.field_1443 = var3;
        this.field_1451 = new LinkedList();
    }

    public class_390(String var1, String var2) {
        this(class_389.method_2555(), var1, var2);
    }

    // $FF: renamed from: cO () void
    public void method_2580() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cP () void
    public void method_2581() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cQ () void
    public void method_2582() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: e (com.google.android.gms.internal.av) void
    public void method_2583(class_223 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: j (long) void
    public void method_2584(long param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: k (long) void
    public void method_2585(long param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: t (boolean) void
    public void method_2586(boolean param1) {
        // $FF: Couldn't be decompiled
    }

    public Bundle toBundle() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: u (boolean) void
    public void method_2587(boolean param1) {
        // $FF: Couldn't be decompiled
    }

    @ez
    private static final class class_1736 {
        // $FF: renamed from: vH long
        private long field_4370 = -1L;
        // $FF: renamed from: vI long
        private long field_4371 = -1L;

        // $FF: renamed from: cR () long
        public long method_4952() {
            return this.field_4371;
        }

        // $FF: renamed from: cS () void
        public void method_4953() {
            this.field_4371 = SystemClock.elapsedRealtime();
        }

        // $FF: renamed from: cT () void
        public void method_4954() {
            this.field_4370 = SystemClock.elapsedRealtime();
        }

        public Bundle toBundle() {
            Bundle var1 = new Bundle();
            var1.putLong("topen", this.field_4370);
            var1.putLong("tclose", this.field_4371);
            return var1;
        }
    }
}
