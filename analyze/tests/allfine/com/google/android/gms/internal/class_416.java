package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_32;
import com.google.android.gms.internal.class_33;
import com.google.android.gms.internal.class_419;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.eq
@ez
public final class class_416 extends class_33.class_1470 {
    // $FF: renamed from: oD com.google.android.gms.ads.purchase.PlayStorePurchaseListener
    private final PlayStorePurchaseListener field_1542;

    public class_416(PlayStorePurchaseListener var1) {
        this.field_1542 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ek) void
    public void method_161(class_32 var1) {
        this.field_1542.onInAppPurchaseFinished(new class_419(var1));
    }

    public boolean isValidPurchase(String var1) {
        return this.field_1542.isValidPurchase(var1);
    }
}
