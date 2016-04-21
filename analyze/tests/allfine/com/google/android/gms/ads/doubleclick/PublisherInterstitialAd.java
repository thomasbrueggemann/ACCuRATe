package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.internal.class_237;

public final class PublisherInterstitialAd {
    // $FF: renamed from: lj com.google.android.gms.internal.bi
    private final class_237 field_4627;

    public PublisherInterstitialAd(Context var1) {
        this.field_4627 = new class_237(var1, this);
    }

    public AdListener getAdListener() {
        return this.field_4627.getAdListener();
    }

    public String getAdUnitId() {
        return this.field_4627.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.field_4627.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.field_4627.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.field_4627.isLoaded();
    }

    public void loadAd(PublisherAdRequest var1) {
        this.field_4627.method_1581(var1.method_5357());
    }

    public void setAdListener(AdListener var1) {
        this.field_4627.setAdListener(var1);
    }

    public void setAdUnitId(String var1) {
        this.field_4627.setAdUnitId(var1);
    }

    public void setAppEventListener(AppEventListener var1) {
        this.field_4627.setAppEventListener(var1);
    }

    public void show() {
        this.field_4627.show();
    }
}
