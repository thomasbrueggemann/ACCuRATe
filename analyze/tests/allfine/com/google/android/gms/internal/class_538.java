package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.internal.class_12;
import com.google.android.gms.internal.class_13;
import com.google.android.gms.internal.class_207;
import com.google.android.gms.internal.class_208;
import com.google.android.gms.internal.class_21;
import com.google.android.gms.internal.class_213;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_231;
import com.google.android.gms.internal.class_232;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_247;
import com.google.android.gms.internal.class_248;
import com.google.android.gms.internal.class_26;
import com.google.android.gms.internal.class_29;
import com.google.android.gms.internal.class_3;
import com.google.android.gms.internal.class_33;
import com.google.android.gms.internal.class_35;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_38;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_388;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.class_39;
import com.google.android.gms.internal.class_390;
import com.google.android.gms.internal.class_393;
import com.google.android.gms.internal.class_4;
import com.google.android.gms.internal.class_41;
import com.google.android.gms.internal.class_415;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_429;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_442;
import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.class_450;
import com.google.android.gms.internal.class_454;
import com.google.android.gms.internal.class_455;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_469;
import com.google.android.gms.internal.class_473;
import com.google.android.gms.internal.class_475;
import com.google.android.gms.internal.class_476;
import com.google.android.gms.internal.class_48;
import com.google.android.gms.internal.class_487;
import com.google.android.gms.internal.class_5;
import com.google.android.gms.internal.class_536;
import com.google.android.gms.internal.class_537;
import com.google.android.gms.internal.class_539;
import com.google.android.gms.internal.class_540;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.class_63;
import com.google.android.gms.internal.class_7;
import com.google.android.gms.internal.class_8;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.ga;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.u
@ez
public class class_538 extends class_7.class_1579 implements class_3, class_8, class_42, class_43, class_38, class_46, class_48, class_444.class_1496, class_442.class_1637, class_21, class_63 {
    // $FF: renamed from: lp com.google.android.gms.internal.av
    private class_223 field_2876;
    // $FF: renamed from: lq com.google.android.gms.internal.ct
    private final class_39 field_2877;
    // $FF: renamed from: lr com.google.android.gms.internal.u$b
    private final class_538.class_1339 field_2878;
    // $FF: renamed from: ls com.google.android.gms.internal.ab
    private final class_213 field_2879;
    // $FF: renamed from: lt com.google.android.gms.internal.ae
    private final class_208 field_2880;
    // $FF: renamed from: lu boolean
    private boolean field_2881;
    // $FF: renamed from: lv android.content.ComponentCallbacks
    private final ComponentCallbacks field_2882;

    public class_538(Context var1, class_242 var2, String var3, class_39 var4, class_379 var5) {
        this(new class_538.class_1339(var1, var2, var3, var5), var4, (class_213)null);
    }

    class_538(class_538.class_1339 var1, class_39 var2, class_213 var3) {
        this.field_2882 = new ComponentCallbacks() {
            public void onConfigurationChanged(Configuration var1) {
                if(class_538.this.field_2878 != null && class_538.this.field_2878.field_2250 != null && class_538.this.field_2878.field_2250.field_1633 != null) {
                    class_538.this.field_2878.field_2250.field_1633.method_2482();
                }

            }

            public void onLowMemory() {
            }
        };
        this.field_2878 = var1;
        this.field_2877 = var2;
        if(var3 == null) {
            var3 = new class_213(this);
        }

        this.field_2879 = var3;
        this.field_2880 = new class_208();
        class_383.method_2530(this.field_2878.field_2243);
        class_389.method_2550(this.field_2878.field_2243, this.field_2878.field_2245);
        this.method_3275();
    }

    // $FF: renamed from: Z () void
    private void method_3275() {
        if(VERSION.SDK_INT >= 14 && this.field_2878 != null && this.field_2878.field_2243 != null) {
            this.field_2878.field_2243.registerComponentCallbacks(this.field_2882);
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.av, android.os.Bundle) com.google.android.gms.internal.fi$a
    private class_448.class_1629 method_3276(class_223 var1, Bundle var2) {
        ApplicationInfo var3 = this.field_2878.field_2243.getApplicationInfo();

        PackageInfo var5;
        label31: {
            PackageInfo var23;
            try {
                var23 = this.field_2878.field_2243.getPackageManager().getPackageInfo(var3.packageName, 0);
            } catch (NameNotFoundException var24) {
                var5 = null;
                break label31;
            }

            var5 = var23;
        }

        boolean var6 = this.field_2878.field_2249.field_637;
        Bundle var7 = null;
        if(!var6) {
            ViewParent var10 = this.field_2878.field_2267.getParent();
            var7 = null;
            if(var10 != null) {
                int[] var11 = new int[2];
                this.field_2878.field_2267.getLocationOnScreen(var11);
                int var12 = var11[0];
                int var13 = var11[1];
                DisplayMetrics var14 = this.field_2878.field_2243.getResources().getDisplayMetrics();
                int var15 = this.field_2878.field_2267.getWidth();
                int var16 = this.field_2878.field_2267.getHeight();
                boolean var17 = this.field_2878.field_2267.isShown();
                byte var18 = 0;
                if(var17) {
                    int var19 = var12 + var15;
                    var18 = 0;
                    if(var19 > 0) {
                        int var20 = var13 + var16;
                        var18 = 0;
                        if(var20 > 0) {
                            int var21 = var14.widthPixels;
                            var18 = 0;
                            if(var12 <= var21) {
                                int var22 = var14.heightPixels;
                                var18 = 0;
                                if(var13 <= var22) {
                                    var18 = 1;
                                }
                            }
                        }
                    }
                }

                var7 = new Bundle(5);
                var7.putInt("x", var12);
                var7.putInt("y", var13);
                var7.putInt("width", var15);
                var7.putInt("height", var16);
                var7.putInt("visible", var18);
            }
        }

        String var8 = class_389.method_2556();
        this.field_2878.field_2252 = new class_390(var8, this.field_2878.field_2242);
        this.field_2878.field_2252.method_2583(var1);
        Bundle var9 = class_389.method_2549(this.field_2878.field_2243, this, var8);
        return new class_448.class_1629(var7, var1, this.field_2878.field_2249, this.field_2878.field_2242, var3, var5, var8, class_389.field_1421, this.field_2878.field_2245, var9, this.field_2878.field_2260, var2, class_389.method_2559());
    }

    // $FF: renamed from: a (com.google.android.gms.internal.v) com.google.android.gms.internal.gv
    private class_381 method_3277(class_539 var1) {
        if(this.field_2878.field_2249.field_637) {
            class_381 var4 = class_381.method_2470(this.field_2878.field_2243, this.field_2878.field_2249, false, false, this.field_2878.field_2244, this.field_2878.field_2245);
            var4.method_2486().method_2398(this, (class_46)null, this, this, true, this, this, var1);
            return var4;
        } else {
            View var2 = this.field_2878.field_2267.getNextView();
            class_381 var3;
            if(var2 instanceof class_381) {
                var3 = (class_381)var2;
                var3.method_2476(this.field_2878.field_2243, this.field_2878.field_2249);
            } else {
                if(var2 != null) {
                    this.field_2878.field_2267.removeView(var2);
                }

                var3 = class_381.method_2470(this.field_2878.field_2243, this.field_2878.field_2249, false, false, this.field_2878.field_2244, this.field_2878.field_2245);
                if(this.field_2878.field_2249.field_638 == null) {
                    this.method_3289(var3);
                }
            }

            var3.method_2486().method_2399(this, this, this, this, false, this, var1);
            return var3;
        }
    }

    // $FF: renamed from: a (int) void
    private void method_3279(int var1) {
        class_378.method_2461("Failed to load ad: " + var1);
        if(this.field_2878.field_2246 != null) {
            try {
                this.field_2878.field_2246.onAdFailedToLoad(var1);
            } catch (RemoteException var3) {
                class_378.method_2465("Could not call AdListener.onAdFailedToLoad().", var3);
                return;
            }
        }

    }

    // $FF: renamed from: aa () void
    private void method_3280() {
        if(VERSION.SDK_INT >= 14 && this.field_2878 != null && this.field_2878.field_2243 != null) {
            this.field_2878.field_2243.unregisterComponentCallbacks(this.field_2882);
        }

    }

    // $FF: renamed from: ak () void
    private void method_3281() {
        class_378.method_2459("Ad closing.");
        if(this.field_2878.field_2246 != null) {
            try {
                this.field_2878.field_2246.onAdClosed();
            } catch (RemoteException var2) {
                class_378.method_2465("Could not call AdListener.onAdClosed().", var2);
                return;
            }
        }

    }

    // $FF: renamed from: al () void
    private void method_3282() {
        class_378.method_2459("Ad leaving application.");
        if(this.field_2878.field_2246 != null) {
            try {
                this.field_2878.field_2246.onAdLeftApplication();
            } catch (RemoteException var2) {
                class_378.method_2465("Could not call AdListener.onAdLeftApplication().", var2);
                return;
            }
        }

    }

    // $FF: renamed from: am () void
    private void method_3283() {
        class_378.method_2459("Ad opening.");
        if(this.field_2878.field_2246 != null) {
            try {
                this.field_2878.field_2246.onAdOpened();
            } catch (RemoteException var2) {
                class_378.method_2465("Could not call AdListener.onAdOpened().", var2);
                return;
            }
        }

    }

    // $FF: renamed from: an () void
    private void method_3284() {
        class_378.method_2459("Ad finished loading.");
        if(this.field_2878.field_2246 != null) {
            try {
                this.field_2878.field_2246.onAdLoaded();
            } catch (RemoteException var2) {
                class_378.method_2465("Could not call AdListener.onAdLoaded().", var2);
                return;
            }
        }

    }

    // $FF: renamed from: ao () void
    private void method_3285() {
        try {
            if(this.field_2878.field_2250.field_1646 instanceof class_246 && this.field_2878.field_2258 != null) {
                this.field_2878.field_2258.method_41((class_246)this.field_2878.field_2250.field_1646);
            }

        } catch (RemoteException var2) {
            class_378.method_2465("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", var2);
        }
    }

    // $FF: renamed from: ap () void
    private void method_3286() {
        try {
            if(this.field_2878.field_2250.field_1646 instanceof class_247 && this.field_2878.field_2259 != null) {
                this.field_2878.field_2259.method_42((class_247)this.field_2878.field_2250.field_1646);
            }

        } catch (RemoteException var2) {
            class_378.method_2465("Could not call OnContentAdLoadedListener.onContentAdLoaded().", var2);
        }
    }

    // $FF: renamed from: at () void
    private void method_3287() {
        if(this.field_2878.field_2250 != null) {
            if(this.field_2878.field_2264 == 0) {
                this.field_2878.field_2250.field_1633.destroy();
            }

            this.field_2878.field_2250 = null;
            this.field_2878.field_2265 = false;
        }

    }

    // $FF: renamed from: b (com.google.android.gms.internal.fz) boolean
    private boolean method_3288(class_438 var1) {
        if(var1.field_1636) {
            View var5;
            try {
                var5 = (View)class_1046.method_5436(var1.field_1632.getView());
            } catch (RemoteException var10) {
                class_378.method_2465("Could not get View from mediation adapter.", var10);
                return false;
            }

            View var6 = this.field_2878.field_2267.getNextView();
            if(var6 != null) {
                this.field_2878.field_2267.removeView(var6);
            }

            try {
                this.method_3289(var5);
            } catch (Throwable var9) {
                class_378.method_2465("Could not add mediation view to view hierarchy.", var9);
                return false;
            }
        } else if(var1.field_1643 != null) {
            var1.field_1633.method_2477(var1.field_1643);
            this.field_2878.field_2267.removeAllViews();
            this.field_2878.field_2267.setMinimumWidth(var1.field_1643.widthPixels);
            this.field_2878.field_2267.setMinimumHeight(var1.field_1643.heightPixels);
            this.method_3289(var1.field_1633);
        }

        if(this.field_2878.field_2267.getChildCount() > 1) {
            this.field_2878.field_2267.showNext();
        }

        if(this.field_2878.field_2250 != null) {
            View var2 = this.field_2878.field_2267.getNextView();
            if(var2 instanceof class_381) {
                ((class_381)var2).method_2476(this.field_2878.field_2243, this.field_2878.field_2249);
            } else if(var2 != null) {
                this.field_2878.field_2267.removeView(var2);
            }

            if(this.field_2878.field_2250.field_1632 != null) {
                try {
                    this.field_2878.field_2250.field_1632.destroy();
                } catch (RemoteException var8) {
                    class_378.method_2461("Could not destroy previous mediation adapter.");
                }
            }
        }

        this.field_2878.field_2267.setVisibility(0);
        return true;
    }

    // $FF: renamed from: c (android.view.View) void
    private void method_3289(View var1) {
        LayoutParams var2 = new LayoutParams(-2, -2);
        this.field_2878.field_2267.addView(var1, var2);
    }

    // $FF: renamed from: c (boolean) void
    private void method_3290(boolean var1) {
        if(this.field_2878.field_2250 == null) {
            class_378.method_2461("Ad state was null when trying to ping impression URLs.");
        } else {
            class_378.method_2457("Pinging Impression URLs.");
            this.field_2878.field_2252.method_2580();
            if(this.field_2878.field_2250.field_1629 != null) {
                class_383.method_2508(this.field_2878.field_2243, this.field_2878.field_2245.field_1387, this.field_2878.field_2250.field_1629);
            }

            if(this.field_2878.field_2250.field_1642 != null && this.field_2878.field_2250.field_1642.field_1741 != null) {
                class_455.method_2831(this.field_2878.field_2243, this.field_2878.field_2245.field_1387, this.field_2878.field_2250, this.field_2878.field_2242, var1, this.field_2878.field_2250.field_1642.field_1741);
            }

            if(this.field_2878.field_2250.field_1631 != null && this.field_2878.field_2250.field_1631.field_1730 != null) {
                class_455.method_2831(this.field_2878.field_2243, this.field_2878.field_2245.field_1387, this.field_2878.field_2250, this.field_2878.field_2242, var1, this.field_2878.field_2250.field_1631.field_1730);
                return;
            }
        }

    }

    // $FF: renamed from: X () com.google.android.gms.dynamic.d
    public class_206 method_13() {
        class_1090.method_5678("getAdFrame must be called on the main UI thread.");
        return class_1046.method_5437(this.field_2878.field_2267);
    }

    // $FF: renamed from: Y () com.google.android.gms.internal.ay
    public class_242 method_14() {
        class_1090.method_5678("getAdSize must be called on the main UI thread.");
        return this.field_2878.field_2249;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.an) android.os.Bundle
    Bundle method_3291(class_231 var1) {
        if(var1 != null) {
            if(var1.method_1552()) {
                var1.wakeup();
            }

            class_232 var2 = var1.method_1550();
            String var3;
            if(var2 != null) {
                var3 = var2.method_1559();
                class_378.method_2457("In AdManger: loadAd, " + var2.toString());
            } else {
                var3 = null;
            }

            if(var3 != null) {
                Bundle var4 = new Bundle(1);
                var4.putString("fingerprint", var3);
                return var4;
            }
        }

        return null;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ay) void
    public void method_15(class_242 var1) {
        class_1090.method_5678("setAdSize must be called on the main UI thread.");
        this.field_2878.field_2249 = var1;
        if(this.field_2878.field_2250 != null && this.field_2878.field_2264 == 0) {
            this.field_2878.field_2250.field_1633.method_2477(var1);
        }

        if(this.field_2878.field_2267.getChildCount() > 1) {
            this.field_2878.field_2267.removeView(this.field_2878.field_2267.getNextView());
        }

        this.field_2878.field_2267.setMinimumWidth(var1.widthPixels);
        this.field_2878.field_2267.setMinimumHeight(var1.heightPixels);
        this.field_2878.field_2267.requestLayout();
    }

    // $FF: renamed from: a (com.google.android.gms.internal.bc) void
    public void method_16(class_5 var1) {
        class_1090.method_5678("setAdListener must be called on the main UI thread.");
        this.field_2878.field_2246 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.bf) void
    public void method_17(class_4 var1) {
        class_1090.method_5678("setAppEventListener must be called on the main UI thread.");
        this.field_2878.field_2253 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.eh) void
    public void method_18(class_35 var1) {
        class_1090.method_5678("setInAppPurchaseListener must be called on the main UI thread.");
        this.field_2878.field_2255 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.el, java.lang.String) void
    public void method_19(class_33 var1, String var2) {
        class_1090.method_5678("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.field_2878.field_2261 = new class_429(var2);
        this.field_2878.field_2254 = var1;
        if(!class_389.method_2558() && var1 != null) {
            (new class_371(this.field_2878.field_2243, this.field_2878.field_2254, this.field_2878.field_2261)).start();
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.et) void
    public void method_20(class_26 var1) {
        class_1090.method_5678("setRawHtmlPublisherAdViewListener must be called on the main UI thread.");
        this.field_2878.field_2256 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.eu) void
    public void method_21(class_29 var1) {
        class_1090.method_5678("setRawHtmlPublisherInterstitialAdListener must be called on the main UI thread.");
        this.field_2878.field_2257 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fz$a) void
    public void method_374(class_438.class_1623 var1) {
        this.field_2878.field_2247 = null;
        this.field_2878.field_2251 = var1;
        this.method_3292((List)null);
        class_381 var3;
        if(!var1.field_5210.field_1709) {
            final class_539 var2 = new class_539();
            var3 = this.method_3277(var2);
            var2.method_3296(new class_539.class_1578(var1, var3));
            var3.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View var1, MotionEvent var2x) {
                    var2.method_3297();
                    return false;
                }
            });
            var3.setOnClickListener(new OnClickListener() {
                public void onClick(View var1) {
                    var2.method_3297();
                }
            });
        } else {
            var3 = null;
        }

        if(var1.field_5204 != null) {
            this.field_2878.field_2249 = var1.field_5204;
        }

        if(var1.errorCode != -2) {
            this.method_758(new class_438(var1, var3, (class_450)null, (class_41)null, (String)null, (class_454)null, (class_248.class_1288)null));
        } else {
            if(!var1.field_5210.field_1699 && var1.field_5210.field_1708) {
                String var7 = var1.field_5210.field_1695;
                String var8 = null;
                if(var7 != null) {
                    var8 = Uri.parse(var1.field_5210.field_1695).buildUpon().query((String)null).build().toString();
                }

                class_415 var9 = new class_415(this, var8, var1.field_5210.field_1697);

                try {
                    if(this.field_2878.field_2256 != null && !this.field_2878.field_2249.field_637 && this.field_2878.field_2256.method_152(var8, var1.field_5210.field_1697)) {
                        this.field_2878.field_2264 = 1;
                        this.field_2878.field_2256.method_151(var9);
                        return;
                    }
                } catch (RemoteException var13) {
                    class_378.method_2465("Could not call the rawHtmlPublisherAdViewListener.", var13);
                }

                try {
                    if(this.field_2878.field_2257 != null && this.field_2878.field_2249.field_637 && this.field_2878.field_2257.method_159(var8, var1.field_5210.field_1697)) {
                        this.field_2878.field_2264 = 1;
                        this.field_2878.field_2257.method_158(var9);
                        return;
                    }
                } catch (RemoteException var12) {
                    class_378.method_2465("Could not call the RawHtmlPublisherInterstitialAdListener.", var12);
                }
            }

            this.field_2878.field_2264 = 0;
            class_538.class_1339 var4 = this.field_2878;
            Context var5 = this.field_2878.field_2243;
            class_39 var6 = this.field_2877;
            var4.field_2248 = class_442.method_2783(var5, this, var1, var3, var6, this);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fz) void
    public void method_758(class_438 var1) {
        this.field_2878.field_2248 = null;
        boolean var2;
        if(var1.field_1646 != null) {
            var2 = true;
        } else {
            var2 = false;
        }

        if(var1.errorCode != -2 && var1.errorCode != 3) {
            class_389.method_2552(this.field_2878.method_3186());
        }

        if(var1.errorCode != -1) {
            if(this.method_3293(var1, var2)) {
                class_378.method_2457("Ad refresh scheduled.");
            }

            if(var1.errorCode == 3 && var1.field_1642 != null && var1.field_1642.field_1742 != null) {
                class_378.method_2457("Pinging no fill URLs.");
                class_455.method_2831(this.field_2878.field_2243, this.field_2878.field_2245.field_1387, var1, this.field_2878.field_2242, false, var1.field_1642.field_1742);
            }

            if(var1.errorCode != -2) {
                this.method_3279(var1.errorCode);
                return;
            }

            if(!this.field_2878.field_2249.field_637 && !var2 && this.field_2878.field_2264 == 0) {
                if(!this.method_3288(var1)) {
                    this.method_3279(0);
                    return;
                }

                if(this.field_2878.field_2267 != null) {
                    this.field_2878.field_2267.field_2268.method_2547(var1.field_1639);
                }
            }

            if(this.field_2878.field_2250 != null && this.field_2878.field_2250.field_1627 != null) {
                this.field_2878.field_2250.field_1627.method_2828((class_38)null);
            }

            if(var1.field_1627 != null) {
                var1.field_1627.method_2828(this);
            }

            this.field_2880.method_1095(this.field_2878.field_2250);
            this.field_2878.field_2250 = var1;
            this.field_2878.field_2252.method_2584(var1.field_1644);
            this.field_2878.field_2252.method_2585(var1.field_1645);
            this.field_2878.field_2252.method_2586(this.field_2878.field_2249.field_637);
            this.field_2878.field_2252.method_2587(var1.field_1636);
            if(!this.field_2878.field_2249.field_637 && !var2 && this.field_2878.field_2264 == 0) {
                this.method_3290(false);
            }

            if(this.field_2878.field_2262 == null) {
                this.field_2878.field_2262 = new class_393(this.field_2878.field_2242);
            }

            int var3;
            int var4;
            if(var1.field_1642 != null) {
                var4 = var1.field_1642.field_1745;
                var3 = var1.field_1642.field_1746;
            } else {
                var3 = 0;
                var4 = 0;
            }

            this.field_2878.field_2262.method_2597(var4, var3);
            if(this.field_2878.field_2264 == 0) {
                if(!this.field_2878.field_2249.field_637 && var1.field_1633 != null && (var1.field_1633.method_2486().method_2406() || var1.field_1641 != null)) {
                    class_207 var7 = this.field_2880.method_1093(this.field_2878.field_2249, this.field_2878.field_2250);
                    if(var1.field_1633.method_2486().method_2406() && var7 != null) {
                        var7.method_1072(new class_537(var1.field_1633));
                    }
                }

                if(this.field_2878.field_2250.field_1633 != null) {
                    this.field_2878.field_2250.field_1633.method_2482();
                    this.field_2878.field_2250.field_1633.method_2486().method_2407();
                }

                if(var2) {
                    class_248.class_1288 var6 = var1.field_1646;
                    if(var6 instanceof class_247 && this.field_2878.field_2259 != null) {
                        this.method_3286();
                    } else {
                        if(!(var6 instanceof class_246) || this.field_2878.field_2258 == null) {
                            class_378.method_2461("No matching listener for retrieved native ad template.");
                            this.method_3279(0);
                            return;
                        }

                        this.method_3285();
                    }
                }

                this.method_3284();
                return;
            }

            if(this.field_2878.field_2263 != null && var1.field_1641 != null) {
                this.field_2880.method_1092(this.field_2878.field_2243, this.field_2878.field_2249, this.field_2878.field_2250, this.field_2878.field_2263, this.field_2878.field_2245);
                return;
            }
        }

    }

    // $FF: renamed from: a (java.lang.String, java.util.ArrayList) void
    public void method_178(String var1, ArrayList<String> var2) {
        class_476 var3 = new class_476(var1, var2, this.field_2878.field_2243, this.field_2878.field_2245.field_1387);
        if(this.field_2878.field_2255 != null) {
            try {
                this.field_2878.field_2255.method_162(var3);
            } catch (RemoteException var7) {
                class_378.method_2461("Could not start In-App purchase.");
            }
        } else {
            class_378.method_2461("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.field_2878.field_2243) != 0) {
                class_378.method_2461("Google Play Service unavailable, cannot launch default purchase flow.");
            } else if(this.field_2878.field_2254 == null) {
                class_378.method_2461("PlayStorePurchaseListener is not set.");
            } else if(this.field_2878.field_2261 == null) {
                class_378.method_2461("PlayStorePurchaseVerifier is not initialized.");
            } else {
                label30: {
                    boolean var6;
                    try {
                        var6 = this.field_2878.field_2254.isValidPurchase(var1);
                    } catch (RemoteException var8) {
                        class_378.method_2461("Could not start In-App purchase.");
                        break label30;
                    }

                    if(!var6) {
                        return;
                    }
                }

                class_475.method_2886(this.field_2878.field_2243, this.field_2878.field_2245.field_1390, new class_473(var3, this.field_2878.field_2254, this.field_2878.field_2261, this.field_2878.field_2243));
            }
        }
    }

    // $FF: renamed from: a (java.util.HashSet) void
    public void method_138(HashSet<ga> var1) {
        this.field_2878.method_3185(var1);
    }

    // $FF: renamed from: a (java.util.List) void
    public void method_3292(List<String> var1) {
        class_1090.method_5678("setNativeTemplates must be called on the main UI thread.");
        this.field_2878.field_2260 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.av) boolean
    public boolean method_22(class_223 var1) {
        class_1090.method_5678("loadAd must be called on the main UI thread.");
        if(this.field_2878.field_2247 == null && this.field_2878.field_2248 == null) {
            if(this.field_2878.field_2249.field_637 && this.field_2878.field_2250 != null) {
                class_378.method_2461("An interstitial is already loading. Aborting.");
                return false;
            }

            if(this.method_3294()) {
                class_378.method_2459("Starting ad request.");
                if(!var1.field_553) {
                    class_378.method_2459("Use AdRequest.Builder.addTestDevice(\"" + class_377.method_2456(this.field_2878.field_2243) + "\") to get test ads on this device.");
                }

                Bundle var2 = this.method_3291(class_389.method_2555().method_2578(this.field_2878.field_2243));
                this.field_2879.cancel();
                this.field_2878.field_2264 = 0;
                class_448.class_1629 var3 = this.method_3276(var1, var2);
                this.field_2878.field_2247 = class_444.method_2797(this.field_2878.field_2243, var3, this.field_2878.field_2244, this);
                return true;
            }
        } else {
            if(this.field_2876 != null) {
                class_378.method_2461("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }

            this.field_2876 = var1;
        }

        return false;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fz, boolean) boolean
    boolean method_3293(class_438 var1, boolean var2) {
        boolean var3 = false;
        class_223 var4;
        if(this.field_2876 != null) {
            var4 = this.field_2876;
            this.field_2876 = null;
        } else {
            var4 = var1.field_1640;
            Bundle var5 = var4.extras;
            var3 = false;
            if(var5 != null) {
                var3 = var4.extras.getBoolean("_noRefresh", false);
            }
        }

        boolean var6 = var3 | var2;
        if(this.field_2878.field_2249.field_637) {
            if(this.field_2878.field_2264 == 0) {
                class_383.method_2513(var1.field_1633);
            }
        } else if(!var6 && this.field_2878.field_2264 == 0) {
            if(var1.field_1630 > 0L) {
                this.field_2879.method_1488(var4, var1.field_1630);
            } else if(var1.field_1642 != null && var1.field_1642.field_1744 > 0L) {
                this.field_2879.method_1488(var4, var1.field_1642.field_1744);
            } else if(!var1.field_1636 && var1.errorCode == 2) {
                this.field_2879.method_1490(var4);
            }
        }

        return this.field_2879.method_1489();
    }

    // $FF: renamed from: ab () void
    public void method_185() {
        this.method_3282();
    }

    // $FF: renamed from: ac () void
    public void method_182() {
        this.field_2880.method_1095(this.field_2878.field_2250);
        if(this.field_2878.field_2249.field_637) {
            this.method_3287();
        }

        this.field_2881 = false;
        this.method_3281();
        this.field_2878.field_2252.method_2582();
    }

    // $FF: renamed from: ad () void
    public void method_183() {
        if(this.field_2878.field_2249.field_637) {
            this.method_3290(false);
        }

        this.field_2881 = true;
        this.method_3283();
    }

    // $FF: renamed from: ae () void
    public void method_167() {
        this.onAdClicked();
    }

    // $FF: renamed from: af () void
    public void method_168() {
        this.method_182();
    }

    // $FF: renamed from: ag () void
    public void method_169() {
        this.method_185();
    }

    // $FF: renamed from: ah () void
    public void method_170() {
        this.method_183();
    }

    // $FF: renamed from: ai () void
    public void method_171() {
        if(this.field_2878.field_2250 != null) {
            class_378.method_2461("Mediation adapter " + this.field_2878.field_2250.field_1626 + " refreshed, but mediation adapters should never refresh.");
        }

        this.method_3290(true);
        this.method_3284();
    }

    // $FF: renamed from: aj () void
    public void method_23() {
        class_1090.method_5678("recordManualImpression must be called on the main UI thread.");
        if(this.field_2878.field_2250 == null) {
            class_378.method_2461("Ad state was null when trying to ping manual tracking URLs.");
        } else {
            class_378.method_2457("Pinging manual tracking URLs.");
            if(this.field_2878.field_2250.field_1638 != null) {
                class_383.method_2508(this.field_2878.field_2243, this.field_2878.field_2245.field_1387, this.field_2878.field_2250.field_1638);
                return;
            }
        }

    }

    // $FF: renamed from: aq () boolean
    public boolean method_3294() {
        boolean var1 = true;
        if(!class_383.method_2516(this.field_2878.field_2243.getPackageManager(), this.field_2878.field_2243.getPackageName(), "android.permission.INTERNET")) {
            if(!this.field_2878.field_2249.field_637) {
                class_377.method_2453(this.field_2878.field_2267, this.field_2878.field_2249, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }

            var1 = false;
        }

        if(!class_383.method_2529(this.field_2878.field_2243)) {
            if(!this.field_2878.field_2249.field_637) {
                class_377.method_2453(this.field_2878.field_2267, this.field_2878.field_2249, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }

            var1 = false;
        }

        if(!var1 && !this.field_2878.field_2249.field_637) {
            this.field_2878.field_2267.setVisibility(0);
        }

        return var1;
    }

    // $FF: renamed from: ar () void
    public void method_9() {
        if(this.field_2878.field_2250 == null) {
            class_378.method_2461("Ad state was null when trying to ping click URLs.");
        } else {
            class_378.method_2457("Pinging click URLs.");
            this.field_2878.field_2252.method_2581();
            if(this.field_2878.field_2250.field_1628 != null) {
                class_383.method_2508(this.field_2878.field_2243, this.field_2878.field_2245.field_1387, this.field_2878.field_2250.field_1628);
            }

            if(this.field_2878.field_2250.field_1642 != null && this.field_2878.field_2250.field_1642.field_1740 != null) {
                class_455.method_2831(this.field_2878.field_2243, this.field_2878.field_2245.field_1387, this.field_2878.field_2250, this.field_2878.field_2242, false, this.field_2878.field_2250.field_1642.field_1740);
                return;
            }
        }

    }

    // $FF: renamed from: as () void
    public void method_10() {
        this.method_3290(false);
    }

    // $FF: renamed from: b (android.view.View) void
    public void method_11(View var1) {
        this.field_2878.field_2263 = var1;
        this.method_758(new class_438(this.field_2878.field_2251, (class_381)null, (class_450)null, (class_41)null, (String)null, (class_454)null, (class_248.class_1288)null));
    }

    // $FF: renamed from: b (com.google.android.gms.internal.av) void
    public void method_3295(class_223 var1) {
        ViewParent var2 = this.field_2878.field_2267.getParent();
        if(var2 instanceof View && ((View)var2).isShown() && class_383.method_2523() && !this.field_2881) {
            this.method_22(var1);
        } else {
            class_378.method_2459("Ad is not visible. Not refreshing ad.");
            this.field_2879.method_1490(var1);
        }
    }

    // $FF: renamed from: b (boolean) void
    public void method_179(boolean var1) {
        this.field_2878.field_2265 = var1;
    }

    public void destroy() {
        class_1090.method_5678("destroy must be called on the main UI thread.");
        this.method_3280();
        this.field_2878.field_2246 = null;
        this.field_2878.field_2253 = null;
        this.field_2878.field_2254 = null;
        this.field_2878.field_2255 = null;
        this.field_2878.field_2256 = null;
        this.field_2878.field_2257 = null;
        this.field_2879.cancel();
        this.field_2880.stop();
        this.stopLoading();
        if(this.field_2878.field_2267 != null) {
            this.field_2878.field_2267.removeAllViews();
        }

        if(this.field_2878.field_2250 != null && this.field_2878.field_2250.field_1633 != null) {
            this.field_2878.field_2250.field_1633.destroy();
        }

        if(this.field_2878.field_2250 != null && this.field_2878.field_2250.field_1632 != null) {
            try {
                this.field_2878.field_2250.field_1632.destroy();
            } catch (RemoteException var2) {
                class_378.method_2461("Could not destroy mediation adapter.");
                return;
            }
        }

    }

    public String getMediationAdapterClassName() {
        return this.field_2878.field_2250 != null?this.field_2878.field_2250.field_1626:null;
    }

    public boolean isReady() {
        class_1090.method_5678("isLoaded must be called on the main UI thread.");
        return this.field_2878.field_2247 == null && this.field_2878.field_2248 == null && this.field_2878.field_2250 != null;
    }

    public void onAdClicked() {
        this.method_9();
    }

    public void onAppEvent(String var1, String var2) {
        if(this.field_2878.field_2253 != null) {
            try {
                this.field_2878.field_2253.onAppEvent(var1, var2);
            } catch (RemoteException var4) {
                class_378.method_2465("Could not call the AppEventListener.", var4);
                return;
            }
        }

    }

    public void pause() {
        class_1090.method_5678("pause must be called on the main UI thread.");
        if(this.field_2878.field_2250 != null && this.field_2878.field_2264 == 0) {
            class_383.method_2513(this.field_2878.field_2250.field_1633);
        }

        if(this.field_2878.field_2250 != null && this.field_2878.field_2250.field_1632 != null) {
            try {
                this.field_2878.field_2250.field_1632.pause();
            } catch (RemoteException var2) {
                class_378.method_2461("Could not pause mediation adapter.");
            }
        }

        this.field_2880.pause();
        this.field_2879.pause();
    }

    public void resume() {
        class_1090.method_5678("resume must be called on the main UI thread.");
        if(this.field_2878.field_2250 != null && this.field_2878.field_2264 == 0) {
            class_383.method_2518(this.field_2878.field_2250.field_1633);
        }

        if(this.field_2878.field_2250 != null && this.field_2878.field_2250.field_1632 != null) {
            try {
                this.field_2878.field_2250.field_1632.resume();
            } catch (RemoteException var2) {
                class_378.method_2461("Could not resume mediation adapter.");
            }
        }

        this.field_2879.resume();
        this.field_2880.resume();
    }

    public void showInterstitial() {
        class_1090.method_5678("showInterstitial must be called on the main UI thread.");
        if(!this.field_2878.field_2249.field_637) {
            class_378.method_2461("Cannot call showInterstitial on a banner ad.");
        } else {
            if(this.field_2878.field_2250 == null) {
                class_378.method_2461("The interstitial has not loaded.");
                return;
            }

            if(this.field_2878.field_2264 != 1) {
                if(this.field_2878.field_2250.field_1633.method_2490()) {
                    class_378.method_2461("The interstitial is already showing.");
                    return;
                }

                this.field_2878.field_2250.field_1633.method_2493(true);
                if(this.field_2878.field_2250.field_1633.method_2486().method_2406() || this.field_2878.field_2250.field_1641 != null) {
                    class_207 var1 = this.field_2880.method_1093(this.field_2878.field_2249, this.field_2878.field_2250);
                    if(this.field_2878.field_2250.field_1633.method_2486().method_2406() && var1 != null) {
                        var1.method_1072(new class_537(this.field_2878.field_2250.field_1633));
                    }
                }

                if(this.field_2878.field_2250.field_1636) {
                    try {
                        this.field_2878.field_2250.field_1632.showInterstitial();
                        return;
                    } catch (RemoteException var11) {
                        class_378.method_2465("Could not show interstitial.", var11);
                        this.method_3287();
                        return;
                    }
                }

                class_536 var2 = new class_536(this.field_2878.field_2265, false);
                if(this.field_2878.field_2243 instanceof Activity) {
                    Window var4 = ((Activity)this.field_2878.field_2243).getWindow();
                    Rect var5 = new Rect();
                    Rect var6 = new Rect();
                    var4.getDecorView().getGlobalVisibleRect(var5);
                    var4.getDecorView().getWindowVisibleDisplayFrame(var6);
                    if(var5.bottom != 0 && var6.bottom != 0) {
                        boolean var8 = this.field_2878.field_2265;
                        boolean var9;
                        if(var5.top == var6.top) {
                            var9 = true;
                        } else {
                            var9 = false;
                        }

                        var2 = new class_536(var8, var9);
                    }
                }

                class_469 var3 = new class_469(this, this, this, this.field_2878.field_2250.field_1633, this.field_2878.field_2250.orientation, this.field_2878.field_2245, this.field_2878.field_2250.field_1639, var2);
                class_487.method_2977(this.field_2878.field_2243, var3);
                return;
            }
        }

    }

    public void stopLoading() {
        class_1090.method_5678("stopLoading must be called on the main UI thread.");
        if(this.field_2878.field_2250 != null && this.field_2878.field_2264 == 0) {
            this.field_2878.field_2250.field_1633.stopLoading();
            this.field_2878.field_2250 = null;
        }

        if(this.field_2878.field_2247 != null) {
            this.field_2878.field_2247.cancel();
        }

        if(this.field_2878.field_2248 != null) {
            this.field_2878.field_2248.cancel();
        }

    }

    @ez
    private static final class class_1340 extends ViewSwitcher {
        // $FF: renamed from: ly com.google.android.gms.internal.gm
        private final class_388 field_2268;

        public class_1340(Context var1) {
            super(var1);
            this.field_2268 = new class_388(var1);
        }

        public boolean onInterceptTouchEvent(MotionEvent var1) {
            this.field_2268.method_2548(var1);
            return false;
        }
    }

    @ez
    static class class_1339 {
        // $FF: renamed from: lA java.lang.String
        public final String field_2242;
        // $FF: renamed from: lB android.content.Context
        public final Context field_2243;
        // $FF: renamed from: lC com.google.android.gms.internal.k
        public final class_548 field_2244;
        // $FF: renamed from: lD com.google.android.gms.internal.gt
        public final class_379 field_2245;
        // $FF: renamed from: lE com.google.android.gms.internal.bc
        public class_5 field_2246;
        // $FF: renamed from: lF com.google.android.gms.internal.gg
        public class_370 field_2247;
        // $FF: renamed from: lG com.google.android.gms.internal.gg
        public class_370 field_2248;
        // $FF: renamed from: lH com.google.android.gms.internal.ay
        public class_242 field_2249;
        // $FF: renamed from: lI com.google.android.gms.internal.fz
        public class_438 field_2250;
        // $FF: renamed from: lJ com.google.android.gms.internal.fz$a
        public class_438.class_1623 field_2251;
        // $FF: renamed from: lK com.google.android.gms.internal.ga
        public class_390 field_2252;
        // $FF: renamed from: lL com.google.android.gms.internal.bf
        public class_4 field_2253;
        // $FF: renamed from: lM com.google.android.gms.internal.el
        public class_33 field_2254;
        // $FF: renamed from: lN com.google.android.gms.internal.eh
        public class_35 field_2255;
        // $FF: renamed from: lO com.google.android.gms.internal.et
        public class_26 field_2256;
        // $FF: renamed from: lP com.google.android.gms.internal.eu
        public class_29 field_2257;
        // $FF: renamed from: lQ com.google.android.gms.internal.bt
        public class_12 field_2258;
        // $FF: renamed from: lR com.google.android.gms.internal.bu
        public class_13 field_2259;
        // $FF: renamed from: lS java.util.List
        public List<String> field_2260;
        // $FF: renamed from: lT com.google.android.gms.internal.ee
        public class_429 field_2261;
        // $FF: renamed from: lU com.google.android.gms.internal.ge
        public class_393 field_2262 = null;
        // $FF: renamed from: lV android.view.View
        public View field_2263 = null;
        // $FF: renamed from: lW int
        public int field_2264 = 0;
        // $FF: renamed from: lX boolean
        public boolean field_2265 = false;
        // $FF: renamed from: lY java.util.HashSet
        private HashSet<ga> field_2266 = null;
        // $FF: renamed from: lz com.google.android.gms.internal.u$a
        public final class_538.class_1340 field_2267;

        public class_1339(Context var1, class_242 var2, String var3, class_379 var4) {
            if(var2.field_637) {
                this.field_2267 = null;
            } else {
                this.field_2267 = new class_538.class_1340(var1);
                this.field_2267.setMinimumWidth(var2.widthPixels);
                this.field_2267.setMinimumHeight(var2.heightPixels);
                this.field_2267.setVisibility(4);
            }

            this.field_2249 = var2;
            this.field_2242 = var3;
            this.field_2243 = var1;
            this.field_2245 = var4;
            this.field_2244 = new class_548(new class_540(this));
        }

        // $FF: renamed from: a (java.util.HashSet) void
        public void method_3185(HashSet<ga> var1) {
            this.field_2266 = var1;
        }

        // $FF: renamed from: au () java.util.HashSet
        public HashSet<ga> method_3186() {
            return this.field_2266;
        }
    }
}
