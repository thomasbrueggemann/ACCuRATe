package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventBanner;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.android.gms.internal.class_378;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    // $FF: renamed from: n android.view.View
    private View field_2089;
    // $FF: renamed from: xf com.google.android.gms.ads.mediation.customevent.CustomEventBanner
    private CustomEventBanner field_2090;
    // $FF: renamed from: xg com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial
    private CustomEventInterstitial field_2091;

    // $FF: renamed from: a (java.lang.String) java.lang.Object
    private static <T> T method_3010(String var0) {
        try {
            Object var2 = Class.forName(var0).newInstance();
            return var2;
        } catch (Throwable var3) {
            class_378.method_2461("Could not instantiate custom event adapter: " + var0 + ". " + var3.getMessage());
            return null;
        }
    }

    // $FF: renamed from: a (android.view.View) void
    private void method_3011(View var1) {
        this.field_2089 = var1;
    }

    public View getBannerView() {
        return this.field_2089;
    }

    public void onDestroy() {
        if(this.field_2090 != null) {
            this.field_2090.onDestroy();
        }

        if(this.field_2091 != null) {
            this.field_2091.onDestroy();
        }

    }

    public void onPause() {
        if(this.field_2090 != null) {
            this.field_2090.onPause();
        }

        if(this.field_2091 != null) {
            this.field_2091.onPause();
        }

    }

    public void onResume() {
        if(this.field_2090 != null) {
            this.field_2090.onResume();
        }

        if(this.field_2091 != null) {
            this.field_2091.onResume();
        }

    }

    public void requestBannerAd(Context var1, MediationBannerListener var2, Bundle var3, AdSize var4, MediationAdRequest var5, Bundle var6) {
        this.field_2090 = (CustomEventBanner)method_3010(var3.getString("class_name"));
        if(this.field_2090 == null) {
            var2.onAdFailedToLoad(this, 0);
        } else {
            Bundle var7;
            if(var6 == null) {
                var7 = null;
            } else {
                var7 = var6.getBundle(var3.getString("class_name"));
            }

            this.field_2090.requestBannerAd(var1, new CustomEventAdapter.class_1265(this, var2), var3.getString("parameter"), var4, var5, var7);
        }
    }

    public void requestInterstitialAd(Context var1, MediationInterstitialListener var2, Bundle var3, MediationAdRequest var4, Bundle var5) {
        this.field_2091 = (CustomEventInterstitial)method_3010(var3.getString("class_name"));
        if(this.field_2091 == null) {
            var2.onAdFailedToLoad(this, 0);
        } else {
            Bundle var6;
            if(var5 == null) {
                var6 = null;
            } else {
                var6 = var5.getBundle(var3.getString("class_name"));
            }

            this.field_2091.requestInterstitialAd(var1, new CustomEventAdapter.class_1266(this, var2), var3.getString("parameter"), var4, var6);
        }
    }

    public void showInterstitial() {
        this.field_2091.showInterstitial();
    }

    private static final class class_1265 implements CustomEventBannerListener {
        // $FF: renamed from: l com.google.android.gms.ads.mediation.MediationBannerListener
        private final MediationBannerListener field_3605;
        // $FF: renamed from: xh com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
        private final CustomEventAdapter field_3606;

        public class_1265(CustomEventAdapter var1, MediationBannerListener var2) {
            this.field_3606 = var1;
            this.field_3605 = var2;
        }

        public void onAdClicked() {
            class_378.method_2457("Custom event adapter called onAdClicked.");
            this.field_3605.onAdClicked(this.field_3606);
        }

        public void onAdClosed() {
            class_378.method_2457("Custom event adapter called onAdClosed.");
            this.field_3605.onAdClosed(this.field_3606);
        }

        public void onAdFailedToLoad(int var1) {
            class_378.method_2457("Custom event adapter called onAdFailedToLoad.");
            this.field_3605.onAdFailedToLoad(this.field_3606, var1);
        }

        public void onAdLeftApplication() {
            class_378.method_2457("Custom event adapter called onAdLeftApplication.");
            this.field_3605.onAdLeftApplication(this.field_3606);
        }

        public void onAdLoaded(View var1) {
            class_378.method_2457("Custom event adapter called onAdLoaded.");
            this.field_3606.method_3011(var1);
            this.field_3605.onAdLoaded(this.field_3606);
        }

        public void onAdOpened() {
            class_378.method_2457("Custom event adapter called onAdOpened.");
            this.field_3605.onAdOpened(this.field_3606);
        }
    }

    private class class_1266 implements CustomEventInterstitialListener {
        // $FF: renamed from: m com.google.android.gms.ads.mediation.MediationInterstitialListener
        private final MediationInterstitialListener field_3618;
        // $FF: renamed from: xh com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
        private final CustomEventAdapter field_3619;

        public class_1266(CustomEventAdapter var2, MediationInterstitialListener var3) {
            this.field_3619 = var2;
            this.field_3618 = var3;
        }

        public void onAdClicked() {
            class_378.method_2457("Custom event adapter called onAdClicked.");
            this.field_3618.onAdClicked(this.field_3619);
        }

        public void onAdClosed() {
            class_378.method_2457("Custom event adapter called onAdClosed.");
            this.field_3618.onAdClosed(this.field_3619);
        }

        public void onAdFailedToLoad(int var1) {
            class_378.method_2457("Custom event adapter called onFailedToReceiveAd.");
            this.field_3618.onAdFailedToLoad(this.field_3619, var1);
        }

        public void onAdLeftApplication() {
            class_378.method_2457("Custom event adapter called onAdLeftApplication.");
            this.field_3618.onAdLeftApplication(this.field_3619);
        }

        public void onAdLoaded() {
            class_378.method_2457("Custom event adapter called onReceivedAd.");
            this.field_3618.onAdLoaded(CustomEventAdapter.this);
        }

        public void onAdOpened() {
            class_378.method_2457("Custom event adapter called onAdOpened.");
            this.field_3618.onAdOpened(this.field_3619);
        }
    }
}
