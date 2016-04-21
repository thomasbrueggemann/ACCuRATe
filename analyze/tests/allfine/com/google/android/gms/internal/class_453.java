package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_39;
import com.google.android.gms.internal.class_41;
import com.google.android.gms.internal.class_450;
import com.google.android.gms.internal.class_452;
import com.google.android.gms.internal.class_454;
import com.google.android.gms.internal.class_456;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.cp
@ez
public final class class_453 implements class_456.class_1638 {
    // $FF: renamed from: lq com.google.android.gms.internal.ct
    private final class_39 field_1747;
    private final Context mContext;
    // $FF: renamed from: ml com.google.android.gms.internal.av
    private final class_223 field_1748;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1749 = new Object();
    // $FF: renamed from: qo java.lang.String
    private final String field_1750;
    // $FF: renamed from: qp long
    private final long field_1751;
    // $FF: renamed from: qq com.google.android.gms.internal.cl
    private final class_450 field_1752;
    // $FF: renamed from: qr com.google.android.gms.internal.ay
    private final class_242 field_1753;
    // $FF: renamed from: qs com.google.android.gms.internal.gt
    private final class_379 field_1754;
    // $FF: renamed from: qt com.google.android.gms.internal.cu
    private class_41 field_1755;
    // $FF: renamed from: qu int
    private int field_1756 = -2;

    public class_453(Context var1, String var2, class_39 var3, class_452 var4, class_450 var5, class_223 var6, class_242 var7, class_379 var8) {
        this.mContext = var1;
        this.field_1747 = var3;
        this.field_1752 = var5;
        if("com.google.ads.mediation.customevent.CustomEventAdapter".equals(var2)) {
            this.field_1750 = this.method_2821();
        } else {
            this.field_1750 = var2;
        }

        long var9;
        if(var4.field_1739 != -1L) {
            var9 = var4.field_1739;
        } else {
            var9 = 10000L;
        }

        this.field_1751 = var9;
        this.field_1748 = var6;
        this.field_1753 = var7;
        this.field_1754 = var8;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.cp, com.google.android.gms.internal.cu) com.google.android.gms.internal.cu
    // $FF: synthetic method
    static class_41 method_2814(class_453 var0, class_41 var1) {
        var0.field_1755 = var1;
        return var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.cp) java.lang.Object
    // $FF: synthetic method
    static Object method_2815(class_453 var0) {
        return var0.field_1749;
    }

    // $FF: renamed from: a (long, long, long, long) void
    private void method_2816(long var1, long var3, long var5, long var7) {
        while(this.field_1756 == -2) {
            this.method_2820(var1, var3, var5, var7);
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.co) void
    private void method_2817(class_454 var1) {
        try {
            if(this.field_1754.field_1389 < 4100000) {
                if(this.field_1753.field_637) {
                    this.field_1755.method_174(class_1046.method_5437(this.mContext), this.field_1748, this.field_1752.field_1731, var1);
                } else {
                    this.field_1755.method_176(class_1046.method_5437(this.mContext), this.field_1753, this.field_1748, this.field_1752.field_1731, var1);
                }
            } else if(this.field_1753.field_637) {
                this.field_1755.method_175(class_1046.method_5437(this.mContext), this.field_1748, this.field_1752.field_1731, this.field_1752.field_1725, var1);
            } else {
                this.field_1755.method_177(class_1046.method_5437(this.mContext), this.field_1753, this.field_1748, this.field_1752.field_1731, this.field_1752.field_1725, var1);
            }
        } catch (RemoteException var3) {
            class_378.method_2465("Could not request ad from mediation adapter.", var3);
            this.method_874(5);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.cp, com.google.android.gms.internal.co) void
    // $FF: synthetic method
    static void method_2818(class_453 var0, class_454 var1) {
        var0.method_2817(var1);
    }

    // $FF: renamed from: b (com.google.android.gms.internal.cp) int
    // $FF: synthetic method
    static int method_2819(class_453 var0) {
        return var0.field_1756;
    }

    // $FF: renamed from: b (long, long, long, long) void
    private void method_2820(long var1, long var3, long var5, long var7) {
        long var9 = SystemClock.elapsedRealtime();
        long var11 = var3 - (var9 - var1);
        long var13 = var7 - (var9 - var5);
        if(var11 > 0L && var13 > 0L) {
            try {
                this.field_1749.wait(Math.min(var11, var13));
            } catch (InterruptedException var16) {
                this.field_1756 = -1;
            }
        } else {
            class_378.method_2459("Timed out waiting for adapter.");
            this.field_1756 = 3;
        }
    }

    // $FF: renamed from: bE () java.lang.String
    private String method_2821() {
        try {
            if(!TextUtils.isEmpty(this.field_1752.field_1729)) {
                if(this.field_1747.method_173(this.field_1752.field_1729)) {
                    return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
                }

                return "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException var2) {
            class_378.method_2461("Fail to determine the custom event\'s version, assuming the old one.");
        }

        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    // $FF: renamed from: bF () com.google.android.gms.internal.cu
    private class_41 method_2822() {
        class_378.method_2459("Instantiating mediation adapter: " + this.field_1750);

        try {
            class_41 var2 = this.field_1747.method_172(this.field_1750);
            return var2;
        } catch (RemoteException var3) {
            class_378.method_2462("Could not instantiate mediation adapter: " + this.field_1750, var3);
            return null;
        }
    }

    // $FF: renamed from: c (com.google.android.gms.internal.cp) com.google.android.gms.internal.cu
    // $FF: synthetic method
    static class_41 method_2823(class_453 var0) {
        return var0.method_2822();
    }

    // $FF: renamed from: d (com.google.android.gms.internal.cp) com.google.android.gms.internal.cu
    // $FF: synthetic method
    static class_41 method_2824(class_453 var0) {
        return var0.field_1755;
    }

    // $FF: renamed from: b (long, long) com.google.android.gms.internal.cq
    public class_456 method_2825(long param1, long param3) {
        // $FF: Couldn't be decompiled
    }

    public void cancel() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: j (int) void
    public void method_874(int param1) {
        // $FF: Couldn't be decompiled
    }
}
