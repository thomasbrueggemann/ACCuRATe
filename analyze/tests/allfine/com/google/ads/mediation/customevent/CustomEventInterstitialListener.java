package com.google.ads.mediation.customevent;

import com.google.ads.mediation.customevent.CustomEventListener;

@Deprecated
public interface CustomEventInterstitialListener extends CustomEventListener {
    void onReceivedAd();
}
