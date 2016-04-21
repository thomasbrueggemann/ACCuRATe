package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_40;
import com.google.android.gms.internal.class_41;
import com.google.android.gms.internal.class_479;
import com.google.android.gms.internal.class_481;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.cz
@ez
public final class class_458<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends class_41.class_1252 {
    // $FF: renamed from: qG com.google.ads.mediation.MediationAdapter
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> field_1775;
    // $FF: renamed from: qH com.google.ads.mediation.NetworkExtras
    private final NETWORK_EXTRAS field_1776;

    public class_458(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> var1, NETWORK_EXTRAS var2) {
        this.field_1775 = var1;
        this.field_1776 = var2;
    }

    // $FF: renamed from: b (java.lang.String, int, java.lang.String) com.google.ads.mediation.MediationServerParameters
    private SERVER_PARAMETERS method_2842(String param1, int param2, String param3) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.cv) void
    public void method_174(class_206 var1, class_223 var2, String var3, class_40 var4) throws RemoteException {
        this.method_175(var1, var2, var3, (String)null, var4);
    }

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.cv) void
    public void method_175(class_206 var1, class_223 var2, String var3, String var4, class_40 var5) throws RemoteException {
        if(!(this.field_1775 instanceof MediationInterstitialAdapter)) {
            class_378.method_2461("MediationAdapter is not a MediationInterstitialAdapter: " + this.field_1775.getClass().getCanonicalName());
            throw new RemoteException();
        } else {
            class_378.method_2457("Requesting interstitial ad from adapter.");

            try {
                ((MediationInterstitialAdapter)this.field_1775).requestInterstitialAd(new class_481(var5), (Activity)class_1046.method_5436(var1), this.method_2842(var3, var2.field_554, var4), class_479.method_2948(var2), this.field_1776);
            } catch (Throwable var7) {
                class_378.method_2465("Could not request interstitial ad from adapter.", var7);
                throw new RemoteException();
            }
        }
    }

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.cv) void
    public void method_176(class_206 var1, class_242 var2, class_223 var3, String var4, class_40 var5) throws RemoteException {
        this.method_177(var1, var2, var3, var4, (String)null, var5);
    }

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.cv) void
    public void method_177(class_206 var1, class_242 var2, class_223 var3, String var4, String var5, class_40 var6) throws RemoteException {
        if(!(this.field_1775 instanceof MediationBannerAdapter)) {
            class_378.method_2461("MediationAdapter is not a MediationBannerAdapter: " + this.field_1775.getClass().getCanonicalName());
            throw new RemoteException();
        } else {
            class_378.method_2457("Requesting banner ad from adapter.");

            try {
                ((MediationBannerAdapter)this.field_1775).requestBannerAd(new class_481(var6), (Activity)class_1046.method_5436(var1), this.method_2842(var4, var3.field_554, var5), class_479.method_2947(var2), class_479.method_2948(var3), this.field_1776);
            } catch (Throwable var8) {
                class_378.method_2465("Could not request banner ad from adapter.", var8);
                throw new RemoteException();
            }
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.field_1775.destroy();
        } catch (Throwable var2) {
            class_378.method_2465("Could not destroy adapter.", var2);
            throw new RemoteException();
        }
    }

    public class_206 getView() throws RemoteException {
        if(!(this.field_1775 instanceof MediationBannerAdapter)) {
            class_378.method_2461("MediationAdapter is not a MediationBannerAdapter: " + this.field_1775.getClass().getCanonicalName());
            throw new RemoteException();
        } else {
            try {
                class_206 var2 = class_1046.method_5437(((MediationBannerAdapter)this.field_1775).getBannerView());
                return var2;
            } catch (Throwable var3) {
                class_378.method_2465("Could not get banner view from adapter.", var3);
                throw new RemoteException();
            }
        }
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if(!(this.field_1775 instanceof MediationInterstitialAdapter)) {
            class_378.method_2461("MediationAdapter is not a MediationInterstitialAdapter: " + this.field_1775.getClass().getCanonicalName());
            throw new RemoteException();
        } else {
            class_378.method_2457("Showing interstitial from adapter.");

            try {
                ((MediationInterstitialAdapter)this.field_1775).showInterstitial();
            } catch (Throwable var2) {
                class_378.method_2465("Could not show interstitial from adapter.", var2);
                throw new RemoteException();
            }
        }
    }
}
