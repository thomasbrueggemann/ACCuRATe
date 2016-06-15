package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_474;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.df
@ey
public final class class_473<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
   // $FF: renamed from: qW com.google.android.gms.internal.da
   private final class_53 field_1621;

   public class_473(class_53 var1) {
      this.field_1621 = var1;
   }

   public void onClick(MediationBannerAdapter<?, ?> var1) {
      class_368.method_2502("Adapter called onClick.");
      if(!class_367.method_2500()) {
         class_368.method_2506("onClick must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdClicked();
               } catch (RemoteException var2) {
                  class_368.method_2510("Could not call onAdClicked.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdClicked();
         } catch (RemoteException var3) {
            class_368.method_2510("Could not call onAdClicked.", var3);
         }
      }
   }

   public void onDismissScreen(MediationBannerAdapter<?, ?> var1) {
      class_368.method_2502("Adapter called onDismissScreen.");
      if(!class_367.method_2500()) {
         class_368.method_2506("onDismissScreen must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdClosed();
               } catch (RemoteException var2) {
                  class_368.method_2510("Could not call onAdClosed.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdClosed();
         } catch (RemoteException var3) {
            class_368.method_2510("Could not call onAdClosed.", var3);
         }
      }
   }

   public void onDismissScreen(MediationInterstitialAdapter<?, ?> var1) {
      class_368.method_2502("Adapter called onDismissScreen.");
      if(!class_367.method_2500()) {
         class_368.method_2506("onDismissScreen must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdClosed();
               } catch (RemoteException var2) {
                  class_368.method_2510("Could not call onAdClosed.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdClosed();
         } catch (RemoteException var3) {
            class_368.method_2510("Could not call onAdClosed.", var3);
         }
      }
   }

   public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> var1, final AdRequest.ErrorCode var2) {
      class_368.method_2502("Adapter called onFailedToReceiveAd with error. " + var2);
      if(!class_367.method_2500()) {
         class_368.method_2506("onFailedToReceiveAd must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdFailedToLoad(class_474.method_3006(var2));
               } catch (RemoteException var2x) {
                  class_368.method_2510("Could not call onAdFailedToLoad.", var2x);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdFailedToLoad(class_474.method_3006(var2));
         } catch (RemoteException var4) {
            class_368.method_2510("Could not call onAdFailedToLoad.", var4);
         }
      }
   }

   public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> var1, final AdRequest.ErrorCode var2) {
      class_368.method_2502("Adapter called onFailedToReceiveAd with error " + var2 + ".");
      if(!class_367.method_2500()) {
         class_368.method_2506("onFailedToReceiveAd must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdFailedToLoad(class_474.method_3006(var2));
               } catch (RemoteException var2x) {
                  class_368.method_2510("Could not call onAdFailedToLoad.", var2x);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdFailedToLoad(class_474.method_3006(var2));
         } catch (RemoteException var4) {
            class_368.method_2510("Could not call onAdFailedToLoad.", var4);
         }
      }
   }

   public void onLeaveApplication(MediationBannerAdapter<?, ?> var1) {
      class_368.method_2502("Adapter called onLeaveApplication.");
      if(!class_367.method_2500()) {
         class_368.method_2506("onLeaveApplication must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdLeftApplication();
               } catch (RemoteException var2) {
                  class_368.method_2510("Could not call onAdLeftApplication.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdLeftApplication();
         } catch (RemoteException var3) {
            class_368.method_2510("Could not call onAdLeftApplication.", var3);
         }
      }
   }

   public void onLeaveApplication(MediationInterstitialAdapter<?, ?> var1) {
      class_368.method_2502("Adapter called onLeaveApplication.");
      if(!class_367.method_2500()) {
         class_368.method_2506("onLeaveApplication must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdLeftApplication();
               } catch (RemoteException var2) {
                  class_368.method_2510("Could not call onAdLeftApplication.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdLeftApplication();
         } catch (RemoteException var3) {
            class_368.method_2510("Could not call onAdLeftApplication.", var3);
         }
      }
   }

   public void onPresentScreen(MediationBannerAdapter<?, ?> var1) {
      class_368.method_2502("Adapter called onPresentScreen.");
      if(!class_367.method_2500()) {
         class_368.method_2506("onPresentScreen must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdOpened();
               } catch (RemoteException var2) {
                  class_368.method_2510("Could not call onAdOpened.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdOpened();
         } catch (RemoteException var3) {
            class_368.method_2510("Could not call onAdOpened.", var3);
         }
      }
   }

   public void onPresentScreen(MediationInterstitialAdapter<?, ?> var1) {
      class_368.method_2502("Adapter called onPresentScreen.");
      if(!class_367.method_2500()) {
         class_368.method_2506("onPresentScreen must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdOpened();
               } catch (RemoteException var2) {
                  class_368.method_2510("Could not call onAdOpened.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdOpened();
         } catch (RemoteException var3) {
            class_368.method_2510("Could not call onAdOpened.", var3);
         }
      }
   }

   public void onReceivedAd(MediationBannerAdapter<?, ?> var1) {
      class_368.method_2502("Adapter called onReceivedAd.");
      if(!class_367.method_2500()) {
         class_368.method_2506("onReceivedAd must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdLoaded();
               } catch (RemoteException var2) {
                  class_368.method_2510("Could not call onAdLoaded.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdLoaded();
         } catch (RemoteException var3) {
            class_368.method_2510("Could not call onAdLoaded.", var3);
         }
      }
   }

   public void onReceivedAd(MediationInterstitialAdapter<?, ?> var1) {
      class_368.method_2502("Adapter called onReceivedAd.");
      if(!class_367.method_2500()) {
         class_368.method_2506("onReceivedAd must be called on the main UI thread.");
         class_367.field_1120.post(new Runnable() {
            public void run() {
               try {
                  class_473.this.field_1621.onAdLoaded();
               } catch (RemoteException var2) {
                  class_368.method_2510("Could not call onAdLoaded.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1621.onAdLoaded();
         } catch (RemoteException var3) {
            class_368.method_2510("Could not call onAdLoaded.", var3);
         }
      }
   }
}
