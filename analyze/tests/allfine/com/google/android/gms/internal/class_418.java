package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;
import com.google.android.gms.internal.class_34;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.ep
@ez
public class class_418 implements InAppPurchase {
    // $FF: renamed from: sx com.google.android.gms.internal.eg
    private final class_34 field_1544;

    public class_418(class_34 var1) {
        this.field_1544 = var1;
    }

    public String getProductId() {
        try {
            String var2 = this.field_1544.getProductId();
            return var2;
        } catch (RemoteException var3) {
            class_378.method_2465("Could not forward getProductId to InAppPurchase", var3);
            return null;
        }
    }

    public void recordPlayBillingResolution(int var1) {
        try {
            this.field_1544.recordPlayBillingResolution(var1);
        } catch (RemoteException var3) {
            class_378.method_2465("Could not forward recordPlayBillingResolution to InAppPurchase", var3);
        }
    }

    public void recordResolution(int var1) {
        try {
            this.field_1544.recordResolution(var1);
        } catch (RemoteException var3) {
            class_378.method_2465("Could not forward recordResolution to InAppPurchase", var3);
        }
    }
}
