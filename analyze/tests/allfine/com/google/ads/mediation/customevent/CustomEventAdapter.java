package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventBanner;
import com.google.ads.mediation.customevent.CustomEventBannerListener;
import com.google.ads.mediation.customevent.CustomEventInterstitial;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventServerParameters;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.class_378;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    // $FF: renamed from: n android.view.View
    private View field_4814;
    // $FF: renamed from: o com.google.ads.mediation.customevent.CustomEventBanner
    private CustomEventBanner field_4815;
    // $FF: renamed from: p com.google.ads.mediation.customevent.CustomEventInterstitial
    private CustomEventInterstitial field_4816;

    // $FF: renamed from: a (java.lang.String) java.lang.Object
    private static <T> T method_5446(String var0) {
        try {
            Object var2 = Class.forName(var0).newInstance();
            return var2;
        } catch (Throwable var3) {
            class_378.method_2461("Could not instantiate custom event adapter: " + var0 + ". " + var3.getMessage());
            return null;
        }
    }

    // $FF: renamed from: a (android.view.View) void
    private void method_5447(View var1) {
        this.field_4814 = var1;
    }

    public void destroy() {
        if(this.field_4815 != null) {
            this.field_4815.destroy();
        }

        if(this.field_4816 != null) {
            this.field_4816.destroy();
        }

    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.field_4814;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener var1, Activity var2, CustomEventServerParameters var3, AdSize var4, MediationAdRequest var5, CustomEventExtras var6) {
        this.field_4815 = (CustomEventBanner)method_5446(var3.className);
        if(this.field_4815 == null) {
            var1.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            Object var7;
            if(var6 == null) {
                var7 = null;
            } else {
                var7 = var6.getExtra(var3.label);
            }

            this.field_4815.requestBannerAd(new CustomEventAdapter.class_1663(this, var1), var2, var3.label, var3.parameter, var4, var5, var7);
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener var1, Activity var2, CustomEventServerParameters var3, MediationAdRequest var4, CustomEventExtras var5) {
        this.field_4816 = (CustomEventInterstitial)method_5446(var3.className);
        if(this.field_4816 == null) {
            var1.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            Object var6;
            if(var5 == null) {
                var6 = null;
            } else {
                var6 = var5.getExtra(var3.label);
            }

            this.field_4816.requestInterstitialAd(new CustomEventAdapter.class_1664(this, var1), var2, var3.label, var3.parameter, var4, var6);
        }
    }

    public void showInterstitial() {
        this.field_4816.showInterstitial();
    }

    private static final class class_1663 implements CustomEventBannerListener {
        // $FF: renamed from: q com.google.ads.mediation.customevent.CustomEventAdapter
        private final CustomEventAdapter field_3971;
        // $FF: renamed from: r com.google.ads.mediation.MediationBannerListener
        private final MediationBannerListener field_3972;

        public class_1663(CustomEventAdapter var1, MediationBannerListener var2) {
            this.field_3971 = var1;
            this.field_3972 = var2;
        }

        public void onClick() {
            class_378.method_2457("Custom event adapter called onFailedToReceiveAd.");
            this.field_3972.onClick(this.field_3971);
        }

        public void onDismissScreen() {
            class_378.method_2457("Custom event adapter called onFailedToReceiveAd.");
            this.field_3972.onDismissScreen(this.field_3971);
        }

        public void onFailedToReceiveAd() {
            class_378.method_2457("Custom event adapter called onFailedToReceiveAd.");
            this.field_3972.onFailedToReceiveAd(this.field_3971, AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            class_378.method_2457("Custom event adapter called onFailedToReceiveAd.");
            this.field_3972.onLeaveApplication(this.field_3971);
        }

        public void onPresentScreen() {
            class_378.method_2457("Custom event adapter called onFailedToReceiveAd.");
            this.field_3972.onPresentScreen(this.field_3971);
        }

        public void onReceivedAd(View var1) {
            class_378.method_2457("Custom event adapter called onReceivedAd.");
            this.field_3971.method_5447(var1);
            this.field_3972.onReceivedAd(this.field_3971);
        }
    }

    private class class_1664 implements CustomEventInterstitialListener {
        // $FF: renamed from: q com.google.ads.mediation.customevent.CustomEventAdapter
        private final CustomEventAdapter field_3978;
        // $FF: renamed from: s com.google.ads.mediation.MediationInterstitialListener
        private final MediationInterstitialListener field_3979;

        public class_1664(CustomEventAdapter var2, MediationInterstitialListener var3) {
            this.field_3978 = var2;
            this.field_3979 = var3;
        }

        public void onDismissScreen() {
            class_378.method_2457("Custom event adapter called onDismissScreen.");
            this.field_3979.onDismissScreen(this.field_3978);
        }

        public void onFailedToReceiveAd() {
            class_378.method_2457("Custom event adapter called onFailedToReceiveAd.");
            this.field_3979.onFailedToReceiveAd(this.field_3978, AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            class_378.method_2457("Custom event adapter called onLeaveApplication.");
            this.field_3979.onLeaveApplication(this.field_3978);
        }

        public void onPresentScreen() {
            class_378.method_2457("Custom event adapter called onPresentScreen.");
            this.field_3979.onPresentScreen(this.field_3978);
        }

        public void onReceivedAd() {
            class_378.method_2457("Custom event adapter called onReceivedAd.");
            this.field_3979.onReceivedAd(CustomEventAdapter.this);
        }
    }
}
