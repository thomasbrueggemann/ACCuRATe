package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.class_34;
import com.google.android.gms.internal.class_35;
import com.google.android.gms.internal.class_418;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.em
@ez
public final class class_417 extends class_35.class_1474 {
    // $FF: renamed from: oC com.google.android.gms.ads.purchase.InAppPurchaseListener
    private final InAppPurchaseListener field_1543;

    public class_417(InAppPurchaseListener var1) {
        this.field_1543 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.eg) void
    public void method_162(class_34 var1) {
        this.field_1543.onInAppPurchaseRequested(new class_418(var1));
    }
}
