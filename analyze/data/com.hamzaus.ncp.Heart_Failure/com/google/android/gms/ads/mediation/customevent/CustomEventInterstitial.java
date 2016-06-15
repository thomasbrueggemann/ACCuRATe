package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;

public interface CustomEventInterstitial extends CustomEvent {
   void requestInterstitialAd(Context var1, CustomEventInterstitialListener var2, String var3, MediationAdRequest var4, Bundle var5);

   void showInterstitial();
}
