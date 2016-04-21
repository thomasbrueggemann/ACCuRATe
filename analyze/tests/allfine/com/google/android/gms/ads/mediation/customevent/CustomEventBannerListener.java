package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import com.google.android.gms.ads.mediation.customevent.CustomEventListener;

public interface CustomEventBannerListener extends CustomEventListener {
    void onAdLoaded(View var1);
}
