package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_40;
import com.google.android.gms.internal.class_479;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.da
@ez
public final class class_481<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    // $FF: renamed from: qF com.google.android.gms.internal.cv
    private final class_40 field_1917;

    public class_481(class_40 var1) {
        this.field_1917 = var1;
    }

    public void onClick(MediationBannerAdapter<?, ?> var1) {
        class_378.method_2457("Adapter called onClick.");
        if(!class_377.method_2455()) {
            class_378.method_2461("onClick must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdClicked();
                    } catch (RemoteException var2) {
                        class_378.method_2465("Could not call onAdClicked.", var2);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdClicked();
            } catch (RemoteException var3) {
                class_378.method_2465("Could not call onAdClicked.", var3);
            }
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> var1) {
        class_378.method_2457("Adapter called onDismissScreen.");
        if(!class_377.method_2455()) {
            class_378.method_2461("onDismissScreen must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdClosed();
                    } catch (RemoteException var2) {
                        class_378.method_2465("Could not call onAdClosed.", var2);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdClosed();
            } catch (RemoteException var3) {
                class_378.method_2465("Could not call onAdClosed.", var3);
            }
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> var1) {
        class_378.method_2457("Adapter called onDismissScreen.");
        if(!class_377.method_2455()) {
            class_378.method_2461("onDismissScreen must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdClosed();
                    } catch (RemoteException var2) {
                        class_378.method_2465("Could not call onAdClosed.", var2);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdClosed();
            } catch (RemoteException var3) {
                class_378.method_2465("Could not call onAdClosed.", var3);
            }
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> var1, final AdRequest.ErrorCode var2) {
        class_378.method_2457("Adapter called onFailedToReceiveAd with error. " + var2);
        if(!class_377.method_2455()) {
            class_378.method_2461("onFailedToReceiveAd must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdFailedToLoad(class_479.method_2946(var2));
                    } catch (RemoteException var2x) {
                        class_378.method_2465("Could not call onAdFailedToLoad.", var2x);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdFailedToLoad(class_479.method_2946(var2));
            } catch (RemoteException var4) {
                class_378.method_2465("Could not call onAdFailedToLoad.", var4);
            }
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> var1, final AdRequest.ErrorCode var2) {
        class_378.method_2457("Adapter called onFailedToReceiveAd with error " + var2 + ".");
        if(!class_377.method_2455()) {
            class_378.method_2461("onFailedToReceiveAd must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdFailedToLoad(class_479.method_2946(var2));
                    } catch (RemoteException var2x) {
                        class_378.method_2465("Could not call onAdFailedToLoad.", var2x);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdFailedToLoad(class_479.method_2946(var2));
            } catch (RemoteException var4) {
                class_378.method_2465("Could not call onAdFailedToLoad.", var4);
            }
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> var1) {
        class_378.method_2457("Adapter called onLeaveApplication.");
        if(!class_377.method_2455()) {
            class_378.method_2461("onLeaveApplication must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdLeftApplication();
                    } catch (RemoteException var2) {
                        class_378.method_2465("Could not call onAdLeftApplication.", var2);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdLeftApplication();
            } catch (RemoteException var3) {
                class_378.method_2465("Could not call onAdLeftApplication.", var3);
            }
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> var1) {
        class_378.method_2457("Adapter called onLeaveApplication.");
        if(!class_377.method_2455()) {
            class_378.method_2461("onLeaveApplication must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdLeftApplication();
                    } catch (RemoteException var2) {
                        class_378.method_2465("Could not call onAdLeftApplication.", var2);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdLeftApplication();
            } catch (RemoteException var3) {
                class_378.method_2465("Could not call onAdLeftApplication.", var3);
            }
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> var1) {
        class_378.method_2457("Adapter called onPresentScreen.");
        if(!class_377.method_2455()) {
            class_378.method_2461("onPresentScreen must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdOpened();
                    } catch (RemoteException var2) {
                        class_378.method_2465("Could not call onAdOpened.", var2);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdOpened();
            } catch (RemoteException var3) {
                class_378.method_2465("Could not call onAdOpened.", var3);
            }
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> var1) {
        class_378.method_2457("Adapter called onPresentScreen.");
        if(!class_377.method_2455()) {
            class_378.method_2461("onPresentScreen must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdOpened();
                    } catch (RemoteException var2) {
                        class_378.method_2465("Could not call onAdOpened.", var2);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdOpened();
            } catch (RemoteException var3) {
                class_378.method_2465("Could not call onAdOpened.", var3);
            }
        }
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> var1) {
        class_378.method_2457("Adapter called onReceivedAd.");
        if(!class_377.method_2455()) {
            class_378.method_2461("onReceivedAd must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdLoaded();
                    } catch (RemoteException var2) {
                        class_378.method_2465("Could not call onAdLoaded.", var2);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdLoaded();
            } catch (RemoteException var3) {
                class_378.method_2465("Could not call onAdLoaded.", var3);
            }
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> var1) {
        class_378.method_2457("Adapter called onReceivedAd.");
        if(!class_377.method_2455()) {
            class_378.method_2461("onReceivedAd must be called on the main UI thread.");
            class_377.field_1386.post(new Runnable() {
                public void run() {
                    try {
                        class_481.this.field_1917.onAdLoaded();
                    } catch (RemoteException var2) {
                        class_378.method_2465("Could not call onAdLoaded.", var2);
                    }
                }
            });
        } else {
            try {
                this.field_1917.onAdLoaded();
            } catch (RemoteException var3) {
                class_378.method_2465("Could not call onAdLoaded.", var3);
            }
        }
    }
}
