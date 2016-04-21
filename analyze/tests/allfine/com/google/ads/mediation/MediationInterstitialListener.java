package com.google.ads.mediation;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationInterstitialAdapter;

@Deprecated
public interface MediationInterstitialListener {
    void onDismissScreen(MediationInterstitialAdapter<?, ?> var1);

    void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> var1, AdRequest.ErrorCode var2);

    void onLeaveApplication(MediationInterstitialAdapter<?, ?> var1);

    void onPresentScreen(MediationInterstitialAdapter<?, ?> var1);

    void onReceivedAd(MediationInterstitialAdapter<?, ?> var1);
}
