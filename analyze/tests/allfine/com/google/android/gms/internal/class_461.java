package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_40;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.cy
@ez
public final class class_461 implements MediationBannerListener, MediationInterstitialListener {
    // $FF: renamed from: qF com.google.android.gms.internal.cv
    private final class_40 field_1787;

    public class_461(class_40 var1) {
        this.field_1787 = var1;
    }

    public void onAdClicked(MediationBannerAdapter var1) {
        class_1090.method_5678("onAdClicked must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdClicked.");

        try {
            this.field_1787.onAdClicked();
        } catch (RemoteException var3) {
            class_378.method_2465("Could not call onAdClicked.", var3);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter var1) {
        class_1090.method_5678("onAdClicked must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdClicked.");

        try {
            this.field_1787.onAdClicked();
        } catch (RemoteException var3) {
            class_378.method_2465("Could not call onAdClicked.", var3);
        }
    }

    public void onAdClosed(MediationBannerAdapter var1) {
        class_1090.method_5678("onAdClosed must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdClosed.");

        try {
            this.field_1787.onAdClosed();
        } catch (RemoteException var3) {
            class_378.method_2465("Could not call onAdClosed.", var3);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter var1) {
        class_1090.method_5678("onAdClosed must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdClosed.");

        try {
            this.field_1787.onAdClosed();
        } catch (RemoteException var3) {
            class_378.method_2465("Could not call onAdClosed.", var3);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter var1, int var2) {
        class_1090.method_5678("onAdFailedToLoad must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdFailedToLoad with error. " + var2);

        try {
            this.field_1787.onAdFailedToLoad(var2);
        } catch (RemoteException var4) {
            class_378.method_2465("Could not call onAdFailedToLoad.", var4);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter var1, int var2) {
        class_1090.method_5678("onAdFailedToLoad must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdFailedToLoad with error " + var2 + ".");

        try {
            this.field_1787.onAdFailedToLoad(var2);
        } catch (RemoteException var4) {
            class_378.method_2465("Could not call onAdFailedToLoad.", var4);
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter var1) {
        class_1090.method_5678("onAdLeftApplication must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdLeftApplication.");

        try {
            this.field_1787.onAdLeftApplication();
        } catch (RemoteException var3) {
            class_378.method_2465("Could not call onAdLeftApplication.", var3);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter var1) {
        class_1090.method_5678("onAdLeftApplication must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdLeftApplication.");

        try {
            this.field_1787.onAdLeftApplication();
        } catch (RemoteException var3) {
            class_378.method_2465("Could not call onAdLeftApplication.", var3);
        }
    }

    public void onAdLoaded(MediationBannerAdapter var1) {
        class_1090.method_5678("onAdLoaded must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdLoaded.");

        try {
            this.field_1787.onAdLoaded();
        } catch (RemoteException var3) {
            class_378.method_2465("Could not call onAdLoaded.", var3);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter var1) {
        class_1090.method_5678("onAdLoaded must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdLoaded.");

        try {
            this.field_1787.onAdLoaded();
        } catch (RemoteException var3) {
            class_378.method_2465("Could not call onAdLoaded.", var3);
        }
    }

    public void onAdOpened(MediationBannerAdapter var1) {
        class_1090.method_5678("onAdOpened must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdOpened.");

        try {
            this.field_1787.onAdOpened();
        } catch (RemoteException var3) {
            class_378.method_2465("Could not call onAdOpened.", var3);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter var1) {
        class_1090.method_5678("onAdOpened must be called on the main UI thread.");
        class_378.method_2457("Adapter called onAdOpened.");

        try {
            this.field_1787.onAdOpened();
        } catch (RemoteException var3) {
            class_378.method_2465("Could not call onAdOpened.", var3);
        }
    }
}
