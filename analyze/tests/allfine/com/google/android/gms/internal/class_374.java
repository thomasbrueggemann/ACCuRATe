package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_364;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_39;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_442;
import com.google.android.gms.internal.class_443;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.class_451;
import com.google.android.gms.internal.class_452;
import com.google.android.gms.internal.class_456;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.fe
@ez
public class class_374 extends class_370 implements class_364.class_1738 {
    // $FF: renamed from: lq com.google.android.gms.internal.ct
    private final class_39 field_1366;
    private final Context mContext;
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private final class_381 field_1367;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1368 = new Object();
    // $FF: renamed from: pR com.google.android.gms.internal.cm
    private class_452 field_1369;
    // $FF: renamed from: sV java.lang.Object
    private final Object field_1370 = new Object();
    // $FF: renamed from: sZ com.google.android.gms.internal.fk
    private class_447 field_1371;
    // $FF: renamed from: tm com.google.android.gms.internal.fd$a
    private final class_442.class_1637 field_1372;
    // $FF: renamed from: tn com.google.android.gms.internal.fz$a
    private final class_438.class_1623 field_1373;
    // $FF: renamed from: to boolean
    private boolean field_1374 = false;
    // $FF: renamed from: tp com.google.android.gms.internal.ck
    private class_451 field_1375;
    // $FF: renamed from: tq com.google.android.gms.internal.cq
    private class_456 field_1376;

    public class_374(Context var1, class_438.class_1623 var2, class_381 var3, class_39 var4, class_442.class_1637 var5) {
        this.mContext = var1;
        this.field_1373 = var2;
        this.field_1371 = var2.field_5210;
        this.field_1367 = var3;
        this.field_1366 = var4;
        this.field_1372 = var5;
        this.field_1369 = var2.field_5206;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fe) java.lang.Object
    // $FF: synthetic method
    static Object method_2437(class_374 var0) {
        return var0.field_1368;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fi, long) void
    private void method_2438(class_448 param1, long param2) throws class_374.class_1639 {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (com.google.android.gms.internal.fe) com.google.android.gms.internal.fd$a
    // $FF: synthetic method
    static class_442.class_1637 method_2439(class_374 var0) {
        return var0.field_1372;
    }

    // $FF: renamed from: c (com.google.android.gms.internal.fe) com.google.android.gms.internal.fk
    // $FF: synthetic method
    static class_447 method_2440(class_374 var0) {
        return var0.field_1371;
    }

    // $FF: renamed from: c (long) boolean
    private boolean method_2441(long var1) throws class_374.class_1639 {
        long var3 = 60000L - (SystemClock.elapsedRealtime() - var1);
        if(var3 <= 0L) {
            return false;
        } else {
            try {
                this.field_1368.wait(var3);
                return true;
            } catch (InterruptedException var6) {
                throw new class_374.class_1639("Ad request cancelled.", -1);
            }
        }
    }

    // $FF: renamed from: d (com.google.android.gms.internal.fe) com.google.android.gms.internal.gv
    // $FF: synthetic method
    static class_381 method_2442(class_374 var0) {
        return var0.field_1367;
    }

    // $FF: renamed from: f (long) void
    private void method_2443(long var1) throws class_374.class_1639 {
        class_377.field_1386.post(new Runnable() {
            public void run() {
                // $FF: Couldn't be decompiled
            }
        });
        this.method_2444(var1);
    }

    // $FF: renamed from: h (long) void
    private void method_2444(long var1) throws class_374.class_1639 {
        do {
            if(!this.method_2441(var1)) {
                throw new class_374.class_1639("Timed out waiting for WebView to finish loading.", 2);
            }
        } while(!this.field_1374);

    }

    // $FF: renamed from: a (com.google.android.gms.internal.gv) void
    public void method_831(class_381 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: co () void
    public void method_2419() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: g (long) void
    protected void method_2445(long var1) throws class_374.class_1639 {
        class_242 var3 = this.field_1367.method_2475();
        int var4;
        int var5;
        if(var3.field_637) {
            var4 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            var5 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            var4 = var3.widthPixels;
            var5 = var3.heightPixels;
        }

        final class_443 var6 = new class_443(this, this.field_1367, var4, var5);
        class_377.field_1386.post(new Runnable() {
            public void run() {
                // $FF: Couldn't be decompiled
            }
        });
        this.method_2444(var1);
        if(var6.method_2793()) {
            class_378.method_2457("Ad-Network indicated no fill with passback URL.");
            throw new class_374.class_1639("AdNetwork sent passback url", 3);
        } else if(!var6.method_2794()) {
            throw new class_374.class_1639("AdNetwork timed out", 2);
        }
    }

    public void onStop() {
        // $FF: Couldn't be decompiled
    }

    private static final class class_1639 extends Exception {
        // $FF: renamed from: tc int
        private final int field_3909;

        public class_1639(String var1, int var2) {
            super(var1);
            this.field_3909 = var2;
        }

        public int getErrorCode() {
            return this.field_3909;
        }
    }
}
