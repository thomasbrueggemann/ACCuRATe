package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.class_5;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.at
@ez
public final class class_225 extends class_5.class_1256 {
    // $FF: renamed from: nR com.google.android.gms.ads.AdListener
    private final AdListener field_561;

    public class_225(AdListener var1) {
        this.field_561 = var1;
    }

    public void onAdClosed() {
        this.field_561.onAdClosed();
    }

    public void onAdFailedToLoad(int var1) {
        this.field_561.onAdFailedToLoad(var1);
    }

    public void onAdLeftApplication() {
        this.field_561.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.field_561.onAdLoaded();
    }

    public void onAdOpened() {
        this.field_561.onAdOpened();
    }
}
