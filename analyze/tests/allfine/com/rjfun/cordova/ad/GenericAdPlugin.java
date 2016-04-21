package com.rjfun.cordova.ad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.rjfun.cordova.ext.CordovaPluginExt;
import java.util.Random;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class GenericAdPlugin extends CordovaPluginExt {
    public static final String ACTION_CREATE_BANNER = "createBanner";
    public static final String ACTION_HIDE_BANNER = "hideBanner";
    public static final String ACTION_PREPARE_INTERSTITIAL = "prepareInterstitial";
    public static final String ACTION_REMOVE_BANNER = "removeBanner";
    public static final String ACTION_SET_OPTIONS = "setOptions";
    public static final String ACTION_SHOW_BANNER = "showBanner";
    public static final String ACTION_SHOW_BANNER_AT_XY = "showBannerAtXY";
    public static final String ACTION_SHOW_INTERSTITIAL = "showInterstitial";
    public static final String ADSIZE_BANNER = "BANNER";
    public static final String ADSIZE_CUSTOM = "CUSTOM";
    public static final String ADSIZE_FULL_BANNER = "FULL_BANNER";
    public static final String ADSIZE_LEADERBOARD = "LEADERBOARD";
    public static final String ADSIZE_MEDIUM_RECTANGLE = "MEDIUM_RECTANGLE";
    public static final String ADSIZE_SKYSCRAPER = "SKYSCRAPER";
    public static final String ADSIZE_SMART_BANNER = "SMART_BANNER";
    public static final String ADTYPE_BANNER = "banner";
    public static final String ADTYPE_INTERSTITIAL = "interstitial";
    public static final String ADTYPE_NATIVE = "native";
    public static final int BOTTOM_CENTER = 8;
    public static final int BOTTOM_LEFT = 7;
    public static final int BOTTOM_RIGHT = 9;
    public static final int CENTER = 5;
    public static final String EVENT_AD_DISMISS = "onAdDismiss";
    public static final String EVENT_AD_FAILLOAD = "onAdFailLoad";
    public static final String EVENT_AD_LEAVEAPP = "onAdLeaveApp";
    public static final String EVENT_AD_LOADED = "onAdLoaded";
    public static final String EVENT_AD_PRESENT = "onAdPresent";
    public static final String EVENT_AD_WILLDISMISS = "onAdWillDismiss";
    public static final String EVENT_AD_WILLPRESENT = "onAdWillPresent";
    public static final String EVENT_BANNER_DISMISS = "onBannerDismiss";
    public static final String EVENT_BANNER_FAILRECEIVE = "onBannerFailedReceive";
    public static final String EVENT_BANNER_LEAVEAPP = "onBannerLeaveApp";
    public static final String EVENT_BANNER_PRESENT = "onBannerPresent";
    public static final String EVENT_BANNER_RECEIVE = "onBannerReceive";
    public static final String EVENT_BANNER_WILLDISMISS = "onBannerWillDismiss";
    public static final String EVENT_BANNER_WILLPRESENT = "onBannerWillPresent";
    public static final String EVENT_INTERSTITIAL_DISMISS = "onInterstitialDismiss";
    public static final String EVENT_INTERSTITIAL_FAILRECEIVE = "onInterstitialFailedReceive";
    public static final String EVENT_INTERSTITIAL_LEAVEAPP = "onInterstitialLeaveApp";
    public static final String EVENT_INTERSTITIAL_PRESENT = "onInterstitialPresent";
    public static final String EVENT_INTERSTITIAL_RECEIVE = "onInterstitialReceive";
    public static final String EVENT_INTERSTITIAL_WILLDISMISS = "onInterstitialWillDismiss";
    public static final String EVENT_INTERSTITIAL_WILLPRESENT = "onInterstitialWillPresent";
    public static final int LEFT = 4;
    private static final String LOGTAG = "GenericAdPlugin";
    public static final int NO_CHANGE = 0;
    public static final String OPT_ADID = "adId";
    public static final String OPT_AD_SIZE = "adSize";
    public static final String OPT_AUTO_SHOW = "autoShow";
    public static final String OPT_BANNER_ID = "bannerId";
    public static final String OPT_HEIGHT = "height";
    public static final String OPT_INTERSTITIAL_ID = "interstitialId";
    public static final String OPT_IS_TESTING = "isTesting";
    public static final String OPT_LICENSE = "license";
    public static final String OPT_LOG_VERBOSE = "logVerbose";
    public static final String OPT_ORIENTATION_RENEW = "orientationRenew";
    public static final String OPT_OVERLAP = "overlap";
    public static final String OPT_POSITION = "position";
    public static final String OPT_WIDTH = "width";
    public static final String OPT_X = "x";
    public static final String OPT_Y = "y";
    public static final int POS_XY = 10;
    public static final int RIGHT = 6;
    protected static final int TEST_TRAFFIC = 2;
    public static final int TOP_CENTER = 2;
    public static final int TOP_LEFT = 1;
    public static final int TOP_RIGHT = 3;
    protected int adHeight;
    protected int adPosition;
    protected View adView;
    protected RelativeLayout adViewLayout;
    protected int adWidth;
    protected boolean autoShowBanner;
    protected boolean autoShowInterstitial;
    protected String bannerId = "";
    protected boolean bannerVisible;
    protected String interstialId = "";
    protected Object interstitialAd;
    protected boolean isTesting;
    protected boolean licenseValidated;
    protected boolean logVerbose;
    protected OrientationEventListener orientation;
    protected boolean orientationRenew;
    protected boolean overlap;
    protected int posX;
    protected int posY;
    protected boolean testTraffic;
    protected int widthOfView;

    public GenericAdPlugin() {
        boolean var1;
        if((new Random()).nextInt(100) <= 2) {
            var1 = true;
        } else {
            var1 = false;
        }

        this.testTraffic = var1;
        this.licenseValidated = false;
        this.isTesting = false;
        this.logVerbose = false;
        this.adWidth = 0;
        this.adHeight = 0;
        this.overlap = false;
        this.orientationRenew = true;
        this.adPosition = 8;
        this.posX = 0;
        this.posY = 0;
        this.autoShowBanner = true;
        this.autoShowInterstitial = false;
        this.orientation = null;
        this.widthOfView = 0;
        this.adViewLayout = null;
        this.adView = null;
        this.interstitialAd = null;
        this.bannerVisible = false;
    }

    @SuppressLint({"DefaultLocale"})
    private void validateLicense(String var1) {
        byte var2 = 1;
        String[] var3 = var1.split("/");
        if(var3.length >= 2) {
            String var6 = var3[0];
            String var7 = var3[var2];
            String var8 = this.md5("licensed to " + var6 + " by floatinghotpot");
            String var9 = this.md5(this.__getProductShortName().toLowerCase() + " licensed to " + var6 + " by floatinghotpot");
            if(!var7.equalsIgnoreCase(var8) && !var7.equalsIgnoreCase(var9)) {
                var2 = 0;
            }

            this.licenseValidated = (boolean)var2;
            if(this.licenseValidated) {
                this.testTraffic = false;
            }
        }

        String var4;
        if(this.licenseValidated) {
            var4 = "valid";
        } else {
            var4 = "invalid";
        }

        Log.w("GenericAdPlugin", var4 + " license");
    }

    protected abstract View __createAdView(String var1);

    protected abstract Object __createInterstitial(String var1);

    protected abstract void __destroyAdView(View var1);

    protected abstract void __destroyInterstitial(Object var1);

    protected abstract int __getAdViewHeight(View var1);

    protected abstract int __getAdViewWidth(View var1);

    protected abstract String __getProductShortName();

    protected abstract String __getTestBannerId();

    protected abstract String __getTestInterstitialId();

    protected abstract void __loadAdView(View var1);

    protected abstract void __loadInterstitial(Object var1);

    protected abstract void __pauseAdView(View var1);

    protected abstract void __resumeAdView(View var1);

    protected abstract void __showInterstitial(Object var1);

    public void checkOrientationChange() {
        int var1 = this.getView().getWidth();
        if(var1 != this.widthOfView) {
            this.widthOfView = var1;
            this.onViewOrientationChanged();
        }
    }

    public boolean createBanner(final String var1, boolean var2) {
        Log.d("GenericAdPlugin", "createBanner: " + var1 + ", " + var2);
        this.autoShowBanner = var2;
        if(var1 != null && var1.length() > 0) {
            this.bannerId = var1;
        } else {
            var1 = this.bannerId;
        }

        if(this.testTraffic) {
            var1 = this.__getTestBannerId();
        }

        final Activity var5 = this.getActivity();
        var5.runOnUiThread(new Runnable() {
            public void run() {
                if(GenericAdPlugin.this.adView == null) {
                    GenericAdPlugin.this.adView = GenericAdPlugin.this.__createAdView(var1);
                }

                if(GenericAdPlugin.this.adView.getParent() != null) {
                    ((ViewGroup)GenericAdPlugin.this.adView.getParent()).removeView(GenericAdPlugin.this.adView);
                }

                if(GenericAdPlugin.this.adViewLayout == null) {
                    GenericAdPlugin.this.adViewLayout = new RelativeLayout(var5);
                    LayoutParams var1x = new LayoutParams(-1, -1);
                    ((ViewGroup)GenericAdPlugin.this.getView().getRootView()).addView(GenericAdPlugin.this.adViewLayout, var1x);
                    GenericAdPlugin.this.adViewLayout.bringToFront();
                }

                GenericAdPlugin.this.bannerVisible = false;
                GenericAdPlugin.this.__loadAdView(GenericAdPlugin.this.adView);
                if(GenericAdPlugin.this.autoShowBanner) {
                    GenericAdPlugin.this.showBanner(GenericAdPlugin.this.adPosition, GenericAdPlugin.this.posX, GenericAdPlugin.this.posY);
                }

            }
        });
        return true;
    }

    public boolean execute(String var1, JSONArray var2, CallbackContext var3) throws JSONException {
        PluginResult var5;
        if("setOptions".equals(var1)) {
            this.setOptions(var2.optJSONObject(0));
            var5 = new PluginResult(PluginResult.Status.field_2155);
        } else if("createBanner".equals(var1)) {
            JSONObject var11 = var2.optJSONObject(0);
            if(var11.length() > 1) {
                this.setOptions(var11);
            }

            String var12 = var11.optString("adId");
            boolean var13;
            if(var11.has("autoShow")) {
                var13 = var11.optBoolean("autoShow");
            } else {
                var13 = true;
            }

            PluginResult.Status var14;
            if(this.createBanner(var12, var13)) {
                var14 = PluginResult.Status.field_2155;
            } else {
                var14 = PluginResult.Status.ERROR;
            }

            var5 = new PluginResult(var14);
        } else if("removeBanner".equals(var1)) {
            this.removeBanner();
            var5 = new PluginResult(PluginResult.Status.field_2155);
        } else if("hideBanner".equals(var1)) {
            this.hideBanner();
            var5 = new PluginResult(PluginResult.Status.field_2155);
        } else if("showBanner".equals(var1)) {
            this.showBanner(var2.optInt(0), 0, 0);
            var5 = new PluginResult(PluginResult.Status.field_2155);
        } else if("showBannerAtXY".equals(var1)) {
            JSONObject var10 = var2.optJSONObject(0);
            this.showBanner(10, var10.optInt("x"), var10.optInt("y"));
            var5 = new PluginResult(PluginResult.Status.field_2155);
        } else if("prepareInterstitial".equals(var1)) {
            JSONObject var6 = var2.optJSONObject(0);
            if(var6.length() > 1) {
                this.setOptions(var6);
            }

            String var7 = var6.optString("adId");
            boolean var8;
            if(var6.has("autoShow")) {
                var8 = var6.optBoolean("autoShow");
            } else {
                var8 = false;
            }

            PluginResult.Status var9;
            if(this.prepareInterstitial(var7, var8)) {
                var9 = PluginResult.Status.field_2155;
            } else {
                var9 = PluginResult.Status.ERROR;
            }

            var5 = new PluginResult(var9);
        } else if("showInterstitial".equals(var1)) {
            this.showInterstitial();
            var5 = new PluginResult(PluginResult.Status.field_2155);
        } else {
            Log.w("GenericAdPlugin", String.format("Invalid action passed: %s", new Object[] {var1}));
            var5 = new PluginResult(PluginResult.Status.INVALID_ACTION);
        }

        if(var5 != null) {
            this.sendPluginResult(var5, var3);
        }

        return true;
    }

    @SuppressLint({"DefaultLocale"})
    protected void fireAdErrorEvent(String var1, int var2, String var3, String var4) {
        String var5 = this.__getProductShortName();
        Object[] var6 = new Object[] {var5, var4, var1, Integer.valueOf(var2), var3};
        this.fireEvent(var5, var1, String.format("{\'adNetwork\':\'%s\',\'adType\':\'%s\',\'adEvent\':\'%s\',\'error\':%d,\'reason\':\'%s\'}", var6));
    }

    protected void fireAdEvent(String var1, String var2) {
        String var3 = this.__getProductShortName();
        this.fireEvent(var3, var1, String.format("{\'adNetwork\':\'%s\',\'adType\':\'%s\',\'adEvent\':\'%s\'}", new Object[] {var3, var2, var1}));
    }

    public void fireEvent(String var1, String var2, String var3) {
        if(this.isTesting) {
            Log.d("GenericAdPlugin", var1 + ", " + var2 + ", " + var3);
        }

        super.fireEvent(var1, var2, var3);
    }

    public void hideBanner() {
        Log.d("GenericAdPlugin", "hideBanner");
        if(this.adView != null) {
            this.autoShowBanner = false;
            this.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    GenericAdPlugin.this.adView.setVisibility(8);
                    GenericAdPlugin.this.__pauseAdView(GenericAdPlugin.this.adView);
                    GenericAdPlugin.this.bannerVisible = false;
                }
            });
        }
    }

    public final String md5(String param1) {
        // $FF: Couldn't be decompiled
    }

    public void onDestroy() {
        if(this.adView != null) {
            this.__destroyAdView(this.adView);
            this.adView = null;
        }

        if(this.interstitialAd != null) {
            this.__destroyInterstitial(this.interstitialAd);
            this.interstitialAd = null;
        }

        if(this.adViewLayout != null) {
            ViewGroup var1 = (ViewGroup)this.adViewLayout.getParent();
            if(var1 != null) {
                var1.removeView(this.adViewLayout);
            }

            this.adViewLayout = null;
        }

        super.onDestroy();
    }

    public void onPause(boolean var1) {
        if(this.adView != null) {
            this.__pauseAdView(this.adView);
        }

        super.onPause(var1);
    }

    public void onResume(boolean var1) {
        super.onResume(var1);
        if(this.adView != null) {
            this.__resumeAdView(this.adView);
        }

    }

    public void onViewOrientationChanged() {
        if(this.isTesting) {
            Log.d("GenericAdPlugin", "Orientation Changed");
        }

        if(this.adView != null && this.bannerVisible) {
            if(!this.orientationRenew) {
                if(this.isTesting) {
                    Log.d("GenericAdPlugin", "adjust banner position");
                }

                this.showBanner(this.adPosition, this.posX, this.posY);
                return;
            }

            if(this.isTesting) {
                Log.d("GenericAdPlugin", "renew banner on orientation change");
            }

            this.removeBanner();
            this.createBanner(this.bannerId, true);
        }

    }

    protected void pluginInitialize() {
        super.pluginInitialize();
        if((new Random()).nextInt(100) <= 2) {
            this.testTraffic = true;
        }

        this.orientation = new GenericAdPlugin.OrientationEventWatcher(this.getActivity());
        this.orientation.enable();
    }

    public boolean prepareInterstitial(final String var1, boolean var2) {
        Log.d("GenericAdPlugin", "prepareInterstitial: " + var1 + ", " + var2);
        this.autoShowInterstitial = var2;
        if(var1 != null && var1.length() > 0) {
            this.interstialId = var1;
        } else {
            var1 = this.interstialId;
        }

        if(this.testTraffic) {
            var1 = this.__getTestInterstitialId();
        }

        this.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                if(GenericAdPlugin.this.interstitialAd != null) {
                    GenericAdPlugin.this.__destroyInterstitial(GenericAdPlugin.this.interstitialAd);
                    GenericAdPlugin.this.interstitialAd = null;
                }

                if(GenericAdPlugin.this.interstitialAd == null) {
                    GenericAdPlugin.this.interstitialAd = GenericAdPlugin.this.__createInterstitial(var1);
                    GenericAdPlugin.this.__loadInterstitial(GenericAdPlugin.this.interstitialAd);
                }

            }
        });
        return false;
    }

    public void removeBanner() {
        Log.d("GenericAdPlugin", "removeBanner");
        this.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                if(GenericAdPlugin.this.adView != null) {
                    ViewGroup var1 = (ViewGroup)GenericAdPlugin.this.adView.getParent();
                    if(var1 != null) {
                        var1.removeView(GenericAdPlugin.this.adView);
                    }

                    GenericAdPlugin.this.__destroyAdView(GenericAdPlugin.this.adView);
                    GenericAdPlugin.this.adView = null;
                }

                GenericAdPlugin.this.bannerVisible = false;
            }
        });
    }

    public void removeInterstitial() {
        if(this.interstitialAd != null) {
            this.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    GenericAdPlugin.this.__destroyInterstitial(GenericAdPlugin.this.interstitialAd);
                }
            });
            this.interstitialAd = null;
        }

    }

    public void setOptions(JSONObject var1) {
        if(var1 != null) {
            if(var1.has("license")) {
                this.validateLicense(var1.optString("license"));
            }

            if(var1.has("isTesting")) {
                this.isTesting = var1.optBoolean("isTesting");
            }

            if(var1.has("logVerbose")) {
                this.logVerbose = var1.optBoolean("logVerbose");
            }

            if(var1.has("width")) {
                this.adWidth = var1.optInt("width");
            }

            if(var1.has("height")) {
                this.adHeight = var1.optInt("height");
            }

            if(var1.has("overlap")) {
                this.overlap = var1.optBoolean("overlap");
            }

            if(var1.has("orientationRenew")) {
                this.orientationRenew = var1.optBoolean("orientationRenew");
            }

            if(var1.has("position")) {
                this.adPosition = var1.optInt("position");
            }

            if(var1.has("x")) {
                this.posX = var1.optInt("x");
            }

            if(var1.has("y")) {
                this.posY = var1.optInt("y");
            }

            if(var1.has("bannerId")) {
                this.bannerId = var1.optString("bannerId");
            }

            if(var1.has("interstitialId")) {
                this.interstialId = var1.optString("interstitialId");
            }
        }

    }

    public void showBanner(final int var1, final int var2, final int var3) {
        Log.d("GenericAdPlugin", "showBanner");
        if(this.adView == null) {
            Log.e("GenericAdPlugin", "banner is null, call createBanner() first.");
        } else {
            this.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    View var1x = GenericAdPlugin.this.getView();
                    if(GenericAdPlugin.this.adView.getParent() != null) {
                        ((ViewGroup)GenericAdPlugin.this.adView.getParent()).removeView(GenericAdPlugin.this.adView);
                    }

                    int var2x = GenericAdPlugin.this.__getAdViewWidth(GenericAdPlugin.this.adView);
                    int var3x = GenericAdPlugin.this.__getAdViewHeight(GenericAdPlugin.this.adView);
                    if(GenericAdPlugin.this.overlap) {
                        int var5 = GenericAdPlugin.this.posX;
                        int var6 = GenericAdPlugin.this.posY;
                        int var7 = var1x.getWidth();
                        int var8 = var1x.getHeight();
                        if(var1 >= 1 && var1 <= 9) {
                            switch((-1 + var1) % 3) {
                                case 0:
                                    var5 = 0;
                                    break;
                                case 1:
                                    var5 = (var7 - var2x) / 2;
                                    break;
                                case 2:
                                    var5 = var7 - var2x;
                            }

                            switch((-1 + var1) / 3) {
                                case 0:
                                    var6 = 0;
                                    break;
                                case 1:
                                    var6 = (var8 - var3x) / 2;
                                    break;
                                case 2:
                                    var6 = var8 - var3x;
                            }
                        } else if(var1 == 10) {
                            var5 = var2;
                            var6 = var3;
                        }

                        View var9 = var1x.getRootView();
                        int[] var10 = new int[2];
                        int[] var11 = new int[2];
                        var9.getLocationOnScreen(var10);
                        var1x.getLocationOnScreen(var11);
                        int var12 = var5 + (var11[0] - var10[0]);
                        int var13 = var6 + (var11[1] - var10[1]);
                        Object[] var14 = new Object[] {Integer.valueOf(var12), Integer.valueOf(var13), Integer.valueOf(var2x), Integer.valueOf(var3x)};
                        Log.d("GenericAdPlugin", String.format("show banner: (%d,%d), (%d x %d)", var14));
                        LayoutParams var16 = new LayoutParams(var2x, var3x);
                        var16.leftMargin = var12;
                        var16.topMargin = var13;
                        GenericAdPlugin.this.adViewLayout.addView(GenericAdPlugin.this.adView, var16);
                    } else {
                        ViewGroup var4 = (ViewGroup)var1x.getParent();
                        if(var1 <= 3) {
                            var4.addView(GenericAdPlugin.this.adView, 0);
                        } else {
                            var4.addView(GenericAdPlugin.this.adView);
                        }
                    }

                    GenericAdPlugin.this.adView.setVisibility(0);
                    GenericAdPlugin.this.__resumeAdView(GenericAdPlugin.this.adView);
                    GenericAdPlugin.this.bannerVisible = true;
                }
            });
        }
    }

    public void showInterstitial() {
        Log.d("GenericAdPlugin", "showInterstitial");
        if(this.interstitialAd == null) {
            this.autoShowInterstitial = true;
            this.prepareInterstitial(this.interstialId, true);
        }

        this.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                GenericAdPlugin.this.__showInterstitial(GenericAdPlugin.this.interstitialAd);
            }
        });
    }

    private class OrientationEventWatcher extends OrientationEventListener {
        public OrientationEventWatcher(Context var2) {
            super(var2);
        }

        public void onOrientationChanged(int var1) {
            GenericAdPlugin.this.checkOrientationChange();
        }
    }
}
