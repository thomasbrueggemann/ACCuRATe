package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.class_231;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.class_449;
import com.google.android.gms.internal.class_452;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.ez;
import org.json.JSONException;

// $FF: renamed from: com.google.android.gms.internal.fb
@ez
public class class_373 extends class_370 implements class_449.class_1624 {
    private final Context mContext;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1358 = new Object();
    // $FF: renamed from: pR com.google.android.gms.internal.cm
    private class_452 field_1359;
    // $FF: renamed from: sU com.google.android.gms.internal.fa$a
    private final class_444.class_1496 field_1360;
    // $FF: renamed from: sV java.lang.Object
    private final Object field_1361 = new Object();
    // $FF: renamed from: sW com.google.android.gms.internal.fi$a
    private final class_448.class_1629 field_1362;
    // $FF: renamed from: sX com.google.android.gms.internal.k
    private final class_548 field_1363;
    // $FF: renamed from: sY com.google.android.gms.internal.gg
    private class_370 field_1364;
    // $FF: renamed from: sZ com.google.android.gms.internal.fk
    private class_447 field_1365;

    public class_373(Context var1, class_448.class_1629 var2, class_548 var3, class_444.class_1496 var4) {
        this.field_1360 = var4;
        this.mContext = var1;
        this.field_1362 = var2;
        this.field_1363 = var3;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fi) com.google.android.gms.internal.ay
    private class_242 method_2430(class_448 var1) throws class_373.class_1492 {
        if(this.field_1365.field_1702 == null) {
            throw new class_373.class_1492("The ad response must specify one of the supported ad sizes.", 0);
        } else {
            String[] var2 = this.field_1365.field_1702.split("x");
            if(var2.length != 2) {
                throw new class_373.class_1492("Could not parse the ad size from the ad response: " + this.field_1365.field_1702, 0);
            } else {
                int var4;
                int var5;
                try {
                    var4 = Integer.parseInt(var2[0]);
                    var5 = Integer.parseInt(var2[1]);
                } catch (NumberFormatException var13) {
                    throw new class_373.class_1492("Could not parse the ad size from the ad response: " + this.field_1365.field_1702, 0);
                }

                class_242[] var6 = var1.field_1713.field_638;
                int var7 = var6.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    class_242 var9 = var6[var8];
                    float var10 = this.mContext.getResources().getDisplayMetrics().density;
                    int var11;
                    if(var9.width == -1) {
                        var11 = (int)((float)var9.widthPixels / var10);
                    } else {
                        var11 = var9.width;
                    }

                    int var12;
                    if(var9.height == -2) {
                        var12 = (int)((float)var9.heightPixels / var10);
                    } else {
                        var12 = var9.height;
                    }

                    if(var4 == var11 && var5 == var12) {
                        return new class_242(var9, var1.field_1713.field_638);
                    }
                }

                throw new class_373.class_1492("The ad size from the ad response was not one of the requested sizes: " + this.field_1365.field_1702, 0);
            }
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fb) java.lang.Object
    // $FF: synthetic method
    static Object method_2431(class_373 var0) {
        return var0.field_1358;
    }

    // $FF: renamed from: b (com.google.android.gms.internal.fb) com.google.android.gms.internal.fa$a
    // $FF: synthetic method
    static class_444.class_1496 method_2432(class_373 var0) {
        return var0.field_1360;
    }

    // $FF: renamed from: c (long) boolean
    private boolean method_2433(long var1) throws class_373.class_1492 {
        long var3 = 60000L - (SystemClock.elapsedRealtime() - var1);
        if(var3 <= 0L) {
            return false;
        } else {
            try {
                this.field_1358.wait(var3);
                return true;
            } catch (InterruptedException var6) {
                throw new class_373.class_1492("Ad request cancelled.", -1);
            }
        }
    }

    // $FF: renamed from: cx () void
    private void method_2434() throws class_373.class_1492 {
        if(this.field_1365.errorCode != -3) {
            if(TextUtils.isEmpty(this.field_1365.field_1697)) {
                throw new class_373.class_1492("No fill from ad server.", 3);
            }

            class_389.method_2551(this.mContext, this.field_1365.field_1696);
            if(this.field_1365.field_1699) {
                try {
                    this.field_1359 = new class_452(this.field_1365.field_1697);
                    return;
                } catch (JSONException var2) {
                    throw new class_373.class_1492("Could not parse mediation config: " + this.field_1365.field_1697, 0);
                }
            }
        }

    }

    // $FF: renamed from: e (long) void
    private void method_2435(long param1) throws class_373.class_1492 {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: r (boolean) void
    private void method_2436(boolean var1) {
        class_389.method_2555().method_2579(var1);
        class_231 var2 = class_389.method_2555().method_2578(this.mContext);
        if(var2 != null && !var2.isAlive()) {
            class_378.method_2457("start fetching content...");
            var2.method_1549();
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.fk) void
    public void method_888(class_447 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: co () void
    public void method_2419() {
        // $FF: Couldn't be decompiled
    }

    public void onStop() {
        // $FF: Couldn't be decompiled
    }

    @ez
    private static final class class_1492 extends Exception {
        // $FF: renamed from: tc int
        private final int field_3219;

        public class_1492(String var1, int var2) {
            super(var1);
            this.field_3219 = var2;
        }

        public int getErrorCode() {
            return this.field_3219;
        }
    }
}
