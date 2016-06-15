package com.google.ads.mediation.customevent;

import android.app.Activity;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.customevent.CustomEvent;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;

@Deprecated
public interface CustomEventInterstitial extends CustomEvent {
   void requestInterstitialAd(CustomEventInterstitialListener var1, Activity var2, String var3, String var4, MediationAdRequest var5, Object var6);

   void showInterstitial();
}
