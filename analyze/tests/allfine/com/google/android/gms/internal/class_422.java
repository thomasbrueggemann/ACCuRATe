package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.doubleclick.class_201;
import com.google.android.gms.internal.class_27;
import com.google.android.gms.internal.class_29;
import com.google.android.gms.internal.class_421;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.ex
@ez
public final class class_422 extends class_29.class_1466 {
    // $FF: renamed from: oF com.google.android.gms.ads.doubleclick.PublisherInterstitialAd
    private final PublisherInterstitialAd field_1553;
    // $FF: renamed from: oG com.google.android.gms.ads.doubleclick.c
    private final class_201 field_1554;

    public class_422(class_201 var1, PublisherInterstitialAd var2) {
        this.field_1554 = var1;
        this.field_1553 = var2;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.es) void
    public void method_158(class_27 var1) {
        this.field_1554.method_1052(this.field_1553, new class_421(var1));
    }

    // $FF: renamed from: e (java.lang.String, java.lang.String) boolean
    public boolean method_159(String var1, String var2) {
        return this.field_1554.method_1053(this.field_1553, var1, var2);
    }
}
