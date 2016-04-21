package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_237;

public final class InterstitialAd {
    // $FF: renamed from: lj com.google.android.gms.internal.bi
    private final class_237 field_4895;

    public InterstitialAd(Context var1) {
        this.field_4895 = new class_237(var1);
    }

    public AdListener getAdListener() {
        return this.field_4895.getAdListener();
    }

    public String getAdUnitId() {
        return this.field_4895.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.field_4895.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.field_4895.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.field_4895.isLoaded();
    }

    public void loadAd(AdRequest var1) {
        this.field_4895.method_1581(var1.method_5843());
    }

    public void setAdListener(AdListener var1) {
        this.field_4895.setAdListener(var1);
    }

    public void setAdUnitId(String var1) {
        this.field_4895.setAdUnitId(var1);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener var1) {
        this.field_4895.setInAppPurchaseListener(var1);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener var1, String var2) {
        this.field_4895.setPlayStorePurchaseParams(var1, var2);
    }

    public void show() {
        this.field_4895.show();
    }
}
