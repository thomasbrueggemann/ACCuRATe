package com.google.ads.mediation;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;

@Deprecated
public interface MediationBannerListener {
    void onClick(MediationBannerAdapter<?, ?> var1);

    void onDismissScreen(MediationBannerAdapter<?, ?> var1);

    void onFailedToReceiveAd(MediationBannerAdapter<?, ?> var1, AdRequest.ErrorCode var2);

    void onLeaveApplication(MediationBannerAdapter<?, ?> var1);

    void onPresentScreen(MediationBannerAdapter<?, ?> var1);

    void onReceivedAd(MediationBannerAdapter<?, ?> var1);
}
