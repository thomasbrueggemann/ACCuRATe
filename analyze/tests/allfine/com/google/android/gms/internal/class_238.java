package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.class_202;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_215;
import com.google.android.gms.internal.class_222;
import com.google.android.gms.internal.class_225;
import com.google.android.gms.internal.class_236;
import com.google.android.gms.internal.class_239;
import com.google.android.gms.internal.class_240;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_416;
import com.google.android.gms.internal.class_417;
import com.google.android.gms.internal.class_423;
import com.google.android.gms.internal.class_457;
import com.google.android.gms.internal.class_7;

// $FF: renamed from: com.google.android.gms.internal.bh
public final class class_238 {
    // $FF: renamed from: nR com.google.android.gms.ads.AdListener
    private AdListener field_621;
    // $FF: renamed from: oA java.lang.String
    private String field_622;
    // $FF: renamed from: oB android.view.ViewGroup
    private ViewGroup field_623;
    // $FF: renamed from: oC com.google.android.gms.ads.purchase.InAppPurchaseListener
    private InAppPurchaseListener field_624;
    // $FF: renamed from: oD com.google.android.gms.ads.purchase.PlayStorePurchaseListener
    private PlayStorePurchaseListener field_625;
    // $FF: renamed from: oE com.google.android.gms.ads.doubleclick.b
    private class_202 field_626;
    // $FF: renamed from: oi com.google.android.gms.ads.doubleclick.AppEventListener
    private AppEventListener field_627;
    // $FF: renamed from: oj com.google.android.gms.ads.AdSize[]
    private AdSize[] field_628;
    // $FF: renamed from: ok java.lang.String
    private String field_629;
    // $FF: renamed from: ox com.google.android.gms.internal.cs
    private final class_457 field_630;
    // $FF: renamed from: oy com.google.android.gms.internal.ax
    private final class_215 field_631;
    // $FF: renamed from: oz com.google.android.gms.internal.bd
    private class_7 field_632;

    public class_238(ViewGroup var1) {
        this(var1, (AttributeSet)null, false, class_215.method_1503());
    }

    public class_238(ViewGroup var1, AttributeSet var2, boolean var3) {
        this(var1, var2, var3, class_215.method_1503());
    }

    class_238(ViewGroup var1, AttributeSet var2, boolean var3, class_215 var4) {
        this(var1, var2, var3, var4, (class_7)null);
    }

    class_238(ViewGroup var1, AttributeSet var2, boolean var3, class_215 var4, class_7 var5) {
        this.field_630 = new class_457();
        this.field_623 = var1;
        this.field_631 = var4;
        if(var2 != null) {
            Context var6 = var1.getContext();

            try {
                class_239 var7 = new class_239(var6, var2);
                this.field_628 = var7.method_1588(var3);
                this.field_629 = var7.getAdUnitId();
            } catch (IllegalArgumentException var9) {
                class_377.method_2453(var1, new class_242(var6, AdSize.BANNER), var9.getMessage(), var9.getMessage());
                return;
            }

            if(var1.isInEditMode()) {
                class_377.method_2451(var1, new class_242(var6, this.field_628[0]), "Ads by Google");
                return;
            }
        }

        this.field_632 = var5;
    }

    // $FF: renamed from: bh () void
    private void method_1583() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: bi () void
    private void method_1584() throws RemoteException {
        if((this.field_628 == null || this.field_629 == null) && this.field_632 == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        } else {
            Context var1 = this.field_623.getContext();
            this.field_632 = class_222.method_1523(var1, new class_242(var1, this.field_628), this.field_629, this.field_630);
            if(this.field_621 != null) {
                this.field_632.method_16(new class_225(this.field_621));
            }

            if(this.field_627 != null) {
                this.field_632.method_17(new class_240(this.field_627));
            }

            if(this.field_624 != null) {
                this.field_632.method_18(new class_417(this.field_624));
            }

            if(this.field_625 != null) {
                this.field_632.method_19(new class_416(this.field_625), this.field_622);
            }

            if(this.field_626 != null) {
                this.field_632.method_20(new class_423(this.field_626, (PublisherAdView)this.field_623));
            }

            this.method_1583();
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.bg) void
    public void method_1585(class_236 var1) {
        try {
            if(this.field_632 == null) {
                this.method_1584();
            }

            if(this.field_632.method_22(this.field_631.method_1504(this.field_623.getContext(), var1))) {
                this.field_630.method_2834(var1.method_1576());
            }

        } catch (RemoteException var3) {
            class_378.method_2465("Failed to load ad.", var3);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.ads.AdSize[]) void
    public void method_1586(AdSize... var1) {
        this.field_628 = var1;

        try {
            if(this.field_632 != null) {
                this.field_632.method_15(new class_242(this.field_623.getContext(), this.field_628));
            }
        } catch (RemoteException var3) {
            class_378.method_2465("Failed to set the ad size.", var3);
        }

        this.field_623.requestLayout();
    }

    public void destroy() {
        try {
            if(this.field_632 != null) {
                this.field_632.destroy();
            }

        } catch (RemoteException var2) {
            class_378.method_2465("Failed to destroy AdView.", var2);
        }
    }

    public AdListener getAdListener() {
        return this.field_621;
    }

    public AdSize getAdSize() {
        try {
            if(this.field_632 != null) {
                AdSize var2 = this.field_632.method_14().method_1597();
                return var2;
            }
        } catch (RemoteException var3) {
            class_378.method_2465("Failed to get the current AdSize.", var3);
        }

        return this.field_628 != null?this.field_628[0]:null;
    }

    public AdSize[] getAdSizes() {
        return this.field_628;
    }

    public String getAdUnitId() {
        return this.field_629;
    }

    public AppEventListener getAppEventListener() {
        return this.field_627;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.field_624;
    }

    public String getMediationAdapterClassName() {
        try {
            if(this.field_632 != null) {
                String var2 = this.field_632.getMediationAdapterClassName();
                return var2;
            }
        } catch (RemoteException var3) {
            class_378.method_2465("Failed to get the mediation adapter class name.", var3);
        }

        return null;
    }

    public void pause() {
        try {
            if(this.field_632 != null) {
                this.field_632.pause();
            }

        } catch (RemoteException var2) {
            class_378.method_2465("Failed to call pause.", var2);
        }
    }

    public void recordManualImpression() {
        try {
            if(this.field_632 != null) {
                this.field_632.method_23();
            }

        } catch (RemoteException var2) {
            class_378.method_2465("Failed to record impression.", var2);
        }
    }

    public void resume() {
        try {
            if(this.field_632 != null) {
                this.field_632.resume();
            }

        } catch (RemoteException var2) {
            class_378.method_2465("Failed to call resume.", var2);
        }
    }

    public void setAdListener(AdListener param1) {
        // $FF: Couldn't be decompiled
    }

    public void setAdSizes(AdSize... var1) {
        if(this.field_628 != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        } else {
            this.method_1586(var1);
        }
    }

    public void setAdUnitId(String var1) {
        if(this.field_629 != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        } else {
            this.field_629 = var1;
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
}
