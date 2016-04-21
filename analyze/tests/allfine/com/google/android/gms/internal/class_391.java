package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.gc
@ez
public class class_391 {
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1453 = new Object();
    // $FF: renamed from: vL java.lang.String
    private final String field_1454;
    // $FF: renamed from: vX int
    private int field_1455 = 0;
    // $FF: renamed from: vY long
    private long field_1456 = -1L;
    // $FF: renamed from: vZ long
    private long field_1457 = -1L;
    // $FF: renamed from: wa int
    private int field_1458 = 0;
    // $FF: renamed from: wb int
    private int field_1459 = -1;

    public class_391(String var1) {
        this.field_1454 = var1;
    }

    // $FF: renamed from: m (android.content.Context) boolean
    public static boolean method_2588(Context var0) {
        int var1 = var0.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if(var1 == 0) {
            class_378.method_2459("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } else {
            ComponentName var2 = new ComponentName(var0.getPackageName(), "com.google.android.gms.ads.AdActivity");

            try {
                if(var1 == var0.getPackageManager().getActivityInfo(var2, 0).theme) {
                    return true;
                } else {
                    class_378.method_2459("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                    return false;
                }
            } catch (NameNotFoundException var4) {
                class_378.method_2461("Fail to fetch AdActivity theme");
                class_378.method_2459("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                return false;
            }
        }
    }

    // $FF: renamed from: b (android.content.Context, java.lang.String) android.os.Bundle
    public Bundle method_2589(Context param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (com.google.android.gms.internal.av, long) void
    public void method_2590(class_223 param1, long param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cO () void
    public void method_2591() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cP () void
    public void method_2592() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dh () long
    public long method_2593() {
        return this.field_1457;
    }
}
