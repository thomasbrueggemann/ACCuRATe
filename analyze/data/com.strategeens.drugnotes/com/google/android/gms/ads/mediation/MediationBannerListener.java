package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.mediation.MediationBannerAdapter;

public interface MediationBannerListener {
   void onAdClicked(MediationBannerAdapter var1);

   void onAdClosed(MediationBannerAdapter var1);

   void onAdFailedToLoad(MediationBannerAdapter var1, int var2);

   void onAdLeftApplication(MediationBannerAdapter var1);

   void onAdLoaded(MediationBannerAdapter var1);

   void onAdOpened(MediationBannerAdapter var1);
}
