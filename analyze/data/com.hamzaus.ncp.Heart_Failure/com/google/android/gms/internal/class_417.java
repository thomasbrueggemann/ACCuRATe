package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.class_12;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_418;

// $FF: renamed from: com.google.android.gms.internal.cb
public final class class_417<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
   // $FF: renamed from: nR com.google.android.gms.internal.bw
   private final class_12 field_1838;

   public class_417(class_12 var1) {
      this.field_1838 = var1;
   }

   public void onClick(MediationBannerAdapter<?, ?> var1) {
      class_370.method_2363("Adapter called onClick.");
      if(!class_371.method_2370()) {
         class_370.method_2358("onClick must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdClicked();
               } catch (RemoteException var2) {
                  class_370.method_2361("Could not call onAdClicked.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdClicked();
         } catch (RemoteException var3) {
            class_370.method_2361("Could not call onAdClicked.", var3);
         }
      }
   }

   public void onDismissScreen(MediationBannerAdapter<?, ?> var1) {
      class_370.method_2363("Adapter called onDismissScreen.");
      if(!class_371.method_2370()) {
         class_370.method_2358("onDismissScreen must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdClosed();
               } catch (RemoteException var2) {
                  class_370.method_2361("Could not call onAdClosed.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdClosed();
         } catch (RemoteException var3) {
            class_370.method_2361("Could not call onAdClosed.", var3);
         }
      }
   }

   public void onDismissScreen(MediationInterstitialAdapter<?, ?> var1) {
      class_370.method_2363("Adapter called onDismissScreen.");
      if(!class_371.method_2370()) {
         class_370.method_2358("onDismissScreen must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdClosed();
               } catch (RemoteException var2) {
                  class_370.method_2361("Could not call onAdClosed.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdClosed();
         } catch (RemoteException var3) {
            class_370.method_2361("Could not call onAdClosed.", var3);
         }
      }
   }

   public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> var1, final AdRequest.ErrorCode var2) {
      class_370.method_2363("Adapter called onFailedToReceiveAd with error. " + var2);
      if(!class_371.method_2370()) {
         class_370.method_2358("onFailedToReceiveAd must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdFailedToLoad(class_418.method_2545(var2));
               } catch (RemoteException var2x) {
                  class_370.method_2361("Could not call onAdFailedToLoad.", var2x);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdFailedToLoad(class_418.method_2545(var2));
         } catch (RemoteException var4) {
            class_370.method_2361("Could not call onAdFailedToLoad.", var4);
         }
      }
   }

   public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> var1, final AdRequest.ErrorCode var2) {
      class_370.method_2363("Adapter called onFailedToReceiveAd with error " + var2 + ".");
      if(!class_371.method_2370()) {
         class_370.method_2358("onFailedToReceiveAd must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdFailedToLoad(class_418.method_2545(var2));
               } catch (RemoteException var2x) {
                  class_370.method_2361("Could not call onAdFailedToLoad.", var2x);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdFailedToLoad(class_418.method_2545(var2));
         } catch (RemoteException var4) {
            class_370.method_2361("Could not call onAdFailedToLoad.", var4);
         }
      }
   }

   public void onLeaveApplication(MediationBannerAdapter<?, ?> var1) {
      class_370.method_2363("Adapter called onLeaveApplication.");
      if(!class_371.method_2370()) {
         class_370.method_2358("onLeaveApplication must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdLeftApplication();
               } catch (RemoteException var2) {
                  class_370.method_2361("Could not call onAdLeftApplication.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdLeftApplication();
         } catch (RemoteException var3) {
            class_370.method_2361("Could not call onAdLeftApplication.", var3);
         }
      }
   }

   public void onLeaveApplication(MediationInterstitialAdapter<?, ?> var1) {
      class_370.method_2363("Adapter called onLeaveApplication.");
      if(!class_371.method_2370()) {
         class_370.method_2358("onLeaveApplication must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdLeftApplication();
               } catch (RemoteException var2) {
                  class_370.method_2361("Could not call onAdLeftApplication.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdLeftApplication();
         } catch (RemoteException var3) {
            class_370.method_2361("Could not call onAdLeftApplication.", var3);
         }
      }
   }

   public void onPresentScreen(MediationBannerAdapter<?, ?> var1) {
      class_370.method_2363("Adapter called onPresentScreen.");
      if(!class_371.method_2370()) {
         class_370.method_2358("onPresentScreen must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdOpened();
               } catch (RemoteException var2) {
                  class_370.method_2361("Could not call onAdOpened.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdOpened();
         } catch (RemoteException var3) {
            class_370.method_2361("Could not call onAdOpened.", var3);
         }
      }
   }

   public void onPresentScreen(MediationInterstitialAdapter<?, ?> var1) {
      class_370.method_2363("Adapter called onPresentScreen.");
      if(!class_371.method_2370()) {
         class_370.method_2358("onPresentScreen must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdOpened();
               } catch (RemoteException var2) {
                  class_370.method_2361("Could not call onAdOpened.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdOpened();
         } catch (RemoteException var3) {
            class_370.method_2361("Could not call onAdOpened.", var3);
         }
      }
   }

   public void onReceivedAd(MediationBannerAdapter<?, ?> var1) {
      class_370.method_2363("Adapter called onReceivedAd.");
      if(!class_371.method_2370()) {
         class_370.method_2358("onReceivedAd must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdLoaded();
               } catch (RemoteException var2) {
                  class_370.method_2361("Could not call onAdLoaded.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdLoaded();
         } catch (RemoteException var3) {
            class_370.method_2361("Could not call onAdLoaded.", var3);
         }
      }
   }

   public void onReceivedAd(MediationInterstitialAdapter<?, ?> var1) {
      class_370.method_2363("Adapter called onReceivedAd.");
      if(!class_371.method_2370()) {
         class_370.method_2358("onReceivedAd must be called on the main UI thread.");
         class_371.field_1606.post(new Runnable() {
            public void run() {
               try {
                  class_417.this.field_1838.onAdLoaded();
               } catch (RemoteException var2) {
                  class_370.method_2361("Could not call onAdLoaded.", var2);
               }
            }
         });
      } else {
         try {
            this.field_1838.onAdLoaded();
         } catch (RemoteException var3) {
            class_370.method_2361("Could not call onAdLoaded.", var3);
         }
      }
   }
}
