package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_40;
import com.google.android.gms.internal.class_41;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.cx
@ez
public final class class_459 extends class_41.class_1252 {
    // $FF: renamed from: qE com.google.android.gms.ads.mediation.MediationAdapter
    private final MediationAdapter field_1777;

    public class_459(MediationAdapter var1) {
        this.field_1777 = var1;
    }

    // $FF: renamed from: a (java.lang.String, int, java.lang.String) android.os.Bundle
    private Bundle method_2843(String param1, int param2, String param3) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.cv) void
    public void method_174(class_206 var1, class_223 var2, String var3, class_40 var4) throws RemoteException {
        this.method_175(var1, var2, var3, (String)null, var4);
    }

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.cv) void
    public void method_175(class_206 param1, class_223 param2, String param3, String param4, class_40 param5) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.cv) void
    public void method_176(class_206 var1, class_242 var2, class_223 var3, String var4, class_40 var5) throws RemoteException {
        this.method_177(var1, var2, var3, var4, (String)null, var5);
    }

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.cv) void
    public void method_177(class_206 param1, class_242 param2, class_223 param3, String param4, String param5, class_40 param6) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    public void destroy() throws RemoteException {
        try {
            this.field_1777.onDestroy();
        } catch (Throwable var2) {
            class_378.method_2465("Could not destroy adapter.", var2);
            throw new RemoteException();
        }
    }

    public class_206 getView() throws RemoteException {
        if(!(this.field_1777 instanceof MediationBannerAdapter)) {
            class_378.method_2461("MediationAdapter is not a MediationBannerAdapter: " + this.field_1777.getClass().getCanonicalName());
            throw new RemoteException();
        } else {
            try {
                class_206 var2 = class_1046.method_5437(((MediationBannerAdapter)this.field_1777).getBannerView());
                return var2;
            } catch (Throwable var3) {
                class_378.method_2465("Could not get banner view from adapter.", var3);
                throw new RemoteException();
            }
        }
    }

    public void pause() throws RemoteException {
        try {
            this.field_1777.onPause();
        } catch (Throwable var2) {
            class_378.method_2465("Could not pause adapter.", var2);
            throw new RemoteException();
        }
    }

    public void resume() throws RemoteException {
        try {
            this.field_1777.onResume();
        } catch (Throwable var2) {
            class_378.method_2465("Could not resume adapter.", var2);
            throw new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if(!(this.field_1777 instanceof MediationInterstitialAdapter)) {
            class_378.method_2461("MediationAdapter is not a MediationInterstitialAdapter: " + this.field_1777.getClass().getCanonicalName());
            throw new RemoteException();
        } else {
            class_378.method_2457("Showing interstitial from adapter.");

            try {
                ((MediationInterstitialAdapter)this.field_1777).showInterstitial();
            } catch (Throwable var2) {
                class_378.method_2465("Could not show interstitial from adapter.", var2);
                throw new RemoteException();
            }
        }
    }
}
