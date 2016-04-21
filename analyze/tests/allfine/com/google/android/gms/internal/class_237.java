package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.doubleclick.class_201;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_215;
import com.google.android.gms.internal.class_222;
import com.google.android.gms.internal.class_225;
import com.google.android.gms.internal.class_236;
import com.google.android.gms.internal.class_240;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_416;
import com.google.android.gms.internal.class_417;
import com.google.android.gms.internal.class_422;
import com.google.android.gms.internal.class_457;
import com.google.android.gms.internal.class_7;

// $FF: renamed from: com.google.android.gms.internal.bi
public class class_237 {
    private final Context mContext;
    // $FF: renamed from: nR com.google.android.gms.ads.AdListener
    private AdListener field_610;
    // $FF: renamed from: oA java.lang.String
    private String field_611;
    // $FF: renamed from: oC com.google.android.gms.ads.purchase.InAppPurchaseListener
    private InAppPurchaseListener field_612;
    // $FF: renamed from: oD com.google.android.gms.ads.purchase.PlayStorePurchaseListener
    private PlayStorePurchaseListener field_613;
    // $FF: renamed from: oF com.google.android.gms.ads.doubleclick.PublisherInterstitialAd
    private PublisherInterstitialAd field_614;
    // $FF: renamed from: oG com.google.android.gms.ads.doubleclick.c
    private class_201 field_615;
    // $FF: renamed from: oi com.google.android.gms.ads.doubleclick.AppEventListener
    private AppEventListener field_616;
    // $FF: renamed from: ok java.lang.String
    private String field_617;
    // $FF: renamed from: ox com.google.android.gms.internal.cs
    private final class_457 field_618;
    // $FF: renamed from: oy com.google.android.gms.internal.ax
    private final class_215 field_619;
    // $FF: renamed from: oz com.google.android.gms.internal.bd
    private class_7 field_620;

    public class_237(Context var1) {
        this(var1, class_215.method_1503(), (PublisherInterstitialAd)null);
    }

    public class_237(Context var1, PublisherInterstitialAd var2) {
        this(var1, class_215.method_1503(), var2);
    }

    public class_237(Context var1, class_215 var2, PublisherInterstitialAd var3) {
        this.field_618 = new class_457();
        this.mContext = var1;
        this.field_619 = var2;
        this.field_614 = var3;
    }

    // $FF: renamed from: v (java.lang.String) void
    private void method_1579(String var1) throws RemoteException {
        if(this.field_617 == null) {
            this.method_1580(var1);
        }

        this.field_620 = class_222.method_1523(this.mContext, new class_242(), this.field_617, this.field_618);
        if(this.field_610 != null) {
            this.field_620.method_16(new class_225(this.field_610));
        }

        if(this.field_616 != null) {
            this.field_620.method_17(new class_240(this.field_616));
        }

        if(this.field_612 != null) {
            this.field_620.method_18(new class_417(this.field_612));
        }

        if(this.field_613 != null) {
            this.field_620.method_19(new class_416(this.field_613), this.field_611);
        }

        if(this.field_615 != null) {
            this.field_620.method_21(new class_422(this.field_615, this.field_614));
        }

    }

    // $FF: renamed from: w (java.lang.String) void
    private void method_1580(String var1) {
        if(this.field_620 == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + var1 + " is called.");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.bg) void
    public void method_1581(class_236 var1) {
        try {
            if(this.field_620 == null) {
                this.method_1579("loadAd");
            }

            if(this.field_620.method_22(this.field_619.method_1504(this.mContext, var1))) {
                this.field_618.method_2834(var1.method_1576());
            }

        } catch (RemoteException var3) {
            class_378.method_2465("Failed to load ad.", var3);
        }
    }

    public AdListener getAdListener() {
        return this.field_610;
    }

    public String getAdUnitId() {
        return this.field_617;
    }

    public AppEventListener getAppEventListener() {
        return this.field_616;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.field_612;
    }

    public String getMediationAdapterClassName() {
        try {
            if(this.field_620 != null) {
                String var2 = this.field_620.getMediationAdapterClassName();
                return var2;
            }
        } catch (RemoteException var3) {
            class_378.method_2465("Failed to get the mediation adapter class name.", var3);
        }

        return null;
    }

    public boolean isLoaded() {
        try {
            if(this.field_620 == null) {
                return false;
            } else {
                boolean var2 = this.field_620.isReady();
                return var2;
            }
        } catch (RemoteException var3) {
            class_378.method_2465("Failed to check if ad is ready.", var3);
            return false;
        }
    }

    public void setAdListener(AdListener param1) {
        // $FF: Couldn't be decompiled
    }

    public void setAdUnitId(String var1) {
        if(this.field_617 != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        } else {
            this.field_617 = var1;
        }
    }

    public void setAppEventListener(AppEventListener param1) {
        // $FF: Couldn't be decompiled
    }

    public void setInAppPurchaseListener(InAppPurchaseListener param1) {
        // $FF: Couldn't be decompiled
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    public void show() {
        try {
            this.method_1580("show");
            this.field_620.showInterstitial();
        } catch (RemoteException var2) {
            class_378.method_2465("Failed to show interstitial.", var2);
        }
    }
}
