package com.rjfun.cordova.admob;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.util.Log;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.rjfun.cordova.ad.GenericAdPlugin;
import com.rjfun.cordova.admob.AdMobMediation;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class AdMobPlugin extends GenericAdPlugin {
    private static final String LOGTAG = "AdMobPlugin";
    private static final String OPT_ADCOLONY = "AdColony";
    public static final String OPT_AD_EXTRAS = "adExtras";
    private static final String OPT_FACEBOOK = "Facebook";
    private static final String OPT_FLURRY = "Flurry";
    private static final String OPT_INMOBI = "InMobi";
    private static final String OPT_MMEDIA = "mMedia";
    private static final String OPT_MOBFOX = "MobFox";
    private static final String TEST_BANNER_ID = "ca-app-pub-6869992474017983/4748283957";
    private static final String TEST_INTERSTITIAL_ID = "ca-app-pub-6869992474017983/6225017153";
    private JSONObject adExtras;
    private AdSize adSize;
    private HashMap<String, AdMobMediation> mediations;

    public AdMobPlugin() {
        this.adSize = AdSize.SMART_BANNER;
        this.adExtras = null;
        this.mediations = new HashMap();
    }

    public static AdSize adSizeFromString(String var0) {
        return "BANNER".equals(var0)?AdSize.BANNER:("SMART_BANNER".equals(var0)?AdSize.SMART_BANNER:("MEDIUM_RECTANGLE".equals(var0)?AdSize.MEDIUM_RECTANGLE:("FULL_BANNER".equals(var0)?AdSize.FULL_BANNER:("LEADERBOARD".equals(var0)?AdSize.LEADERBOARD:("SKYSCRAPER".equals(var0)?AdSize.WIDE_SKYSCRAPER:null)))));
    }

    @SuppressLint({"DefaultLocale"})
    private AdRequest buildAdRequest() {
        Activity var1 = this.getActivity();
        AdRequest.Builder var2 = new AdRequest.Builder();
        if(this.isTesting) {
            var2 = var2.addTestDevice(this.md5(Secure.getString(var1.getContentResolver(), "android_id")).toUpperCase()).addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        }

        if(this.adExtras != null) {
            Bundle var3 = new Bundle();
            var3.putInt("cordova", 1);
            Iterator var4 = this.adExtras.keys();

            while(var4.hasNext()) {
                String var8 = (String)var4.next();

                try {
                    var3.putString(var8, this.adExtras.get(var8).toString());
                } catch (JSONException var11) {
                    Object[] var10 = new Object[] {var11.getMessage()};
                    Log.w("AdMobPlugin", String.format("Caught JSON Exception: %s", var10));
                }
            }

            var2 = var2.addNetworkExtras(new AdMobExtras(var3));
        }

        Iterator var5 = this.mediations.keySet().iterator();

        while(var5.hasNext()) {
            String var6 = (String)var5.next();
            AdMobMediation var7 = (AdMobMediation)this.mediations.get(var6);
            if(var7 != null) {
                var2 = var7.joinAdRequest(var2);
            }
        }

        return var2.build();
    }

    protected View __createAdView(String var1) {
        if(var1.charAt(0) == 47) {
            PublisherAdView var2 = new PublisherAdView(this.getActivity());
            var2.setAdUnitId(var1);
            AdSize[] var3 = new AdSize[] {this.adSize};
            var2.setAdSizes(var3);
            var2.setAdListener(new AdMobPlugin.BannerListener());
            return var2;
        } else {
            AdView var4 = new AdView(this.getActivity());
            var4.setAdUnitId(var1);
            var4.setAdSize(this.adSize);
            var4.setAdListener(new AdMobPlugin.BannerListener());
            return var4;
        }
    }

    protected Object __createInterstitial(String var1) {
        InterstitialAd var2 = new InterstitialAd(this.getActivity());
        var2.setAdUnitId(var1);
        var2.setAdListener(new AdMobPlugin.InterstitialListener());
        return var2;
    }

    protected void __destroyAdView(View var1) {
        if(var1 != null) {
            if(var1 instanceof PublisherAdView) {
                PublisherAdView var3 = (PublisherAdView)var1;
                var3.setAdListener((AdListener)null);
                var3.destroy();
            } else {
                AdView var2 = (AdView)var1;
                var2.setAdListener((AdListener)null);
                var2.destroy();
            }
        }
    }

    protected void __destroyInterstitial(Object var1) {
        if(var1 != null && var1 instanceof InterstitialAd) {
            ((InterstitialAd)var1).setAdListener((AdListener)null);
        }
    }

    protected int __getAdViewHeight(View var1) {
        return this.getAdViewSize(var1).getHeightInPixels(this.getActivity());
    }

    protected int __getAdViewWidth(View var1) {
        return this.getAdViewSize(var1).getWidthInPixels(this.getActivity());
    }

    protected String __getProductShortName() {
        return "AdMob";
    }

    protected String __getTestBannerId() {
        return "ca-app-pub-6869992474017983/4748283957";
    }

    protected String __getTestInterstitialId() {
        return "ca-app-pub-6869992474017983/6225017153";
    }

    protected void __loadAdView(View var1) {
        if(var1 instanceof PublisherAdView) {
            ((PublisherAdView)var1).loadAd((new PublisherAdRequest.Builder()).build());
        } else {
            ((AdView)var1).loadAd(this.buildAdRequest());
        }
    }

    protected void __loadInterstitial(Object var1) {
        if(var1 != null && var1 instanceof InterstitialAd) {
            ((InterstitialAd)var1).loadAd(this.buildAdRequest());
        }
    }

    protected void __pauseAdView(View var1) {
        if(var1 != null) {
            if(var1 instanceof PublisherAdView) {
                ((PublisherAdView)var1).pause();
            } else {
                ((AdView)var1).pause();
            }
        }
    }

    protected void __resumeAdView(View var1) {
        if(var1 != null) {
            if(var1 instanceof PublisherAdView) {
                ((PublisherAdView)var1).resume();
            } else {
                ((AdView)var1).resume();
            }
        }
    }

    protected void __showInterstitial(Object var1) {
        if(var1 != null && var1 instanceof InterstitialAd) {
            InterstitialAd var2 = (InterstitialAd)var1;
            if(var2.isLoaded()) {
                var2.show();
                return;
            }
        }

    }

    protected AdSize getAdViewSize(View var1) {
        return var1 instanceof PublisherAdView?((PublisherAdView)var1).getAdSize():((AdView)var1).getAdSize();
    }

    public String getErrorReason(int var1) {
        switch(var1) {
            case 0:
                return "Internal error";
            case 1:
                return "Invalid request";
            case 2:
                return "Network Error";
            case 3:
                return "No fill";
            default:
                return "";
        }
    }

    public void onDestroy() {
        Iterator var1 = this.mediations.keySet().iterator();

        while(var1.hasNext()) {
            String var2 = (String)var1.next();
            AdMobMediation var3 = (AdMobMediation)this.mediations.get(var2);
            if(var3 != null) {
                var3.onDestroy();
            }
        }

        super.onDestroy();
    }

    public void onPause(boolean var1) {
        Iterator var2 = this.mediations.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            AdMobMediation var4 = (AdMobMediation)this.mediations.get(var3);
            if(var4 != null) {
                var4.onPause();
            }
        }

        super.onPause(var1);
    }

    public void onResume(boolean var1) {
        super.onResume(var1);
        Iterator var2 = this.mediations.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            AdMobMediation var4 = (AdMobMediation)this.mediations.get(var3);
            if(var4 != null) {
                var4.onResume();
            }
        }

    }

    protected void pluginInitialize() {
        super.pluginInitialize();
    }

    public void setOptions(JSONObject var1) {
        super.setOptions(var1);
        if(var1.has("adSize")) {
            this.adSize = adSizeFromString(var1.optString("adSize"));
        }

        if(this.adSize == null) {
            this.adSize = new AdSize(this.adWidth, this.adHeight);
        }

        if(var1.has("adExtras")) {
            this.adExtras = var1.optJSONObject("adExtras");
        }

    }

    private class BannerListener extends AdListener {
        private BannerListener() {
        }

        // $FF: synthetic method
        BannerListener(Object var2) {
            this();
        }

        public void onAdClosed() {
            AdMobPlugin.this.fireEvent("AdMobPlugin", "onBannerDismiss", (String)null);
            AdMobPlugin.this.fireAdEvent("onAdDismiss", "banner");
        }

        @SuppressLint({"DefaultLocale"})
        public void onAdFailedToLoad(int var1) {
            Object[] var2 = new Object[] {Integer.valueOf(var1), AdMobPlugin.this.getErrorReason(var1)};
            String var3 = String.format("{ \'error\': %d, \'reason\':\'%s\' }", var2);
            AdMobPlugin.this.fireEvent("AdMobPlugin", "onBannerFailedReceive", var3);
            AdMobPlugin.this.fireAdErrorEvent("onAdFailLoad", var1, AdMobPlugin.this.getErrorReason(var1), "banner");
        }

        public void onAdLeftApplication() {
            AdMobPlugin.this.fireEvent("AdMobPlugin", "onBannerLeaveApp", (String)null);
            AdMobPlugin.this.fireAdEvent("onAdLeaveApp", "banner");
        }

        public void onAdLoaded() {
            if(!AdMobPlugin.this.bannerVisible && AdMobPlugin.this.autoShowBanner) {
                AdMobPlugin.this.showBanner(AdMobPlugin.this.adPosition, AdMobPlugin.this.posX, AdMobPlugin.this.posY);
            }

            AdMobPlugin.this.fireEvent("AdMobPlugin", "onBannerReceive", (String)null);
            AdMobPlugin.this.fireAdEvent("onAdLoaded", "banner");
        }

        public void onAdOpened() {
            AdMobPlugin.this.fireEvent("AdMobPlugin", "onBannerPresent", (String)null);
            AdMobPlugin.this.fireAdEvent("onAdPresent", "banner");
        }
    }

    private class InterstitialListener extends AdListener {
        private InterstitialListener() {
        }

        // $FF: synthetic method
        InterstitialListener(Object var2) {
            this();
        }

        public void onAdClosed() {
            AdMobPlugin.this.fireEvent("AdMobPlugin", "onInterstitialDismiss", (String)null);
            AdMobPlugin.this.fireAdEvent("onAdDismiss", "interstitial");
            AdMobPlugin.this.removeInterstitial();
        }

        @SuppressLint({"DefaultLocale"})
        public void onAdFailedToLoad(int var1) {
            Object[] var2 = new Object[] {Integer.valueOf(var1), AdMobPlugin.this.getErrorReason(var1)};
            String var3 = String.format("{ \'error\': %d, \'reason\':\'%s\' }", var2);
            AdMobPlugin.this.fireEvent("AdMobPlugin", "onInterstitialFailedReceive", var3);
            AdMobPlugin.this.fireAdErrorEvent("onAdFailLoad", var1, AdMobPlugin.this.getErrorReason(var1), "interstitial");
        }

        public void onAdLeftApplication() {
            AdMobPlugin.this.fireEvent("AdMobPlugin", "onInterstitialLeaveApp", (String)null);
            AdMobPlugin.this.fireAdEvent("onAdLeaveApp", "interstitial");
        }

        public void onAdLoaded() {
            if(AdMobPlugin.this.autoShowInterstitial) {
                AdMobPlugin.this.showInterstitial();
            }

            AdMobPlugin.this.fireEvent("AdMobPlugin", "onInterstitialReceive", (String)null);
            AdMobPlugin.this.fireAdEvent("onAdLoaded", "interstitial");
        }

        public void onAdOpened() {
            AdMobPlugin.this.fireEvent("AdMobPlugin", "onInterstitialPresent", (String)null);
            AdMobPlugin.this.fireAdEvent("onAdPresent", "interstitial");
        }
    }
}
