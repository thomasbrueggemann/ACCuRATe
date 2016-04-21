package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;
import com.google.android.gms.internal.class_32;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.eo
@ez
public class class_419 implements InAppPurchaseResult {
    // $FF: renamed from: sL com.google.android.gms.internal.ek
    private final class_32 field_1548;

    public class_419(class_32 var1) {
        this.field_1548 = var1;
    }

    public void finishPurchase() {
        try {
            this.field_1548.finishPurchase();
        } catch (RemoteException var2) {
            class_378.method_2465("Could not forward finishPurchase to InAppPurchaseResult", var2);
        }
    }

    public String getProductId() {
        try {
            String var2 = this.field_1548.getProductId();
            return var2;
        } catch (RemoteException var3) {
            class_378.method_2465("Could not forward getProductId to InAppPurchaseResult", var3);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            Intent var2 = this.field_1548.getPurchaseData();
            return var2;
        } catch (RemoteException var3) {
            class_378.method_2465("Could not forward getPurchaseData to InAppPurchaseResult", var3);
            return null;
        }
    }

    public int getResultCode() {
        try {
            int var2 = this.field_1548.getResultCode();
            return var2;
        } catch (RemoteException var3) {
            class_378.method_2465("Could not forward getPurchaseData to InAppPurchaseResult", var3);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            boolean var2 = this.field_1548.isVerified();
            return var2;
        } catch (RemoteException var3) {
            class_378.method_2465("Could not forward isVerified to InAppPurchaseResult", var3);
            return false;
        }
    }
}
