package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public interface MediationInterstitialAdapter extends MediationAdapter {
   void requestInterstitialAd(Context var1, MediationInterstitialListener var2, Bundle var3, MediationAdRequest var4, Bundle var5);

   void showInterstitial();
}
