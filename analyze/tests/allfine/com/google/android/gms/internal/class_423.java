package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.class_202;
import com.google.android.gms.internal.class_26;
import com.google.android.gms.internal.class_27;
import com.google.android.gms.internal.class_421;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.ew
@ez
public final class class_423 extends class_26.class_1181 {
    // $FF: renamed from: oE com.google.android.gms.ads.doubleclick.b
    private final class_202 field_1555;
    // $FF: renamed from: sQ com.google.android.gms.ads.doubleclick.PublisherAdView
    private final PublisherAdView field_1556;

    public class_423(class_202 var1, PublisherAdView var2) {
        this.field_1555 = var1;
        this.field_1556 = var2;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.es) void
    public void method_151(class_27 var1) {
        this.field_1555.method_1054(this.field_1556, new class_421(var1));
    }

    // $FF: renamed from: e (java.lang.String, java.lang.String) boolean
    public boolean method_152(String var1, String var2) {
        return this.field_1555.method_1055(this.field_1556, var1, var2);
    }
}
