package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.dd
@ey
public final class class_475 implements MediationBannerListener, MediationInterstitialListener {
   // $FF: renamed from: qW com.google.android.gms.internal.da
   private final class_53 field_1622;

   public class_475(class_53 var1) {
      this.field_1622 = var1;
   }

   public void onAdClicked(MediationBannerAdapter var1) {
      class_335.method_2304("onAdClicked must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdClicked.");

      try {
         this.field_1622.onAdClicked();
      } catch (RemoteException var3) {
         class_368.method_2510("Could not call onAdClicked.", var3);
      }
   }

   public void onAdClicked(MediationInterstitialAdapter var1) {
      class_335.method_2304("onAdClicked must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdClicked.");

      try {
         this.field_1622.onAdClicked();
      } catch (RemoteException var3) {
         class_368.method_2510("Could not call onAdClicked.", var3);
      }
   }

   public void onAdClosed(MediationBannerAdapter var1) {
      class_335.method_2304("onAdClosed must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdClosed.");

      try {
         this.field_1622.onAdClosed();
      } catch (RemoteException var3) {
         class_368.method_2510("Could not call onAdClosed.", var3);
      }
   }

   public void onAdClosed(MediationInterstitialAdapter var1) {
      class_335.method_2304("onAdClosed must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdClosed.");

      try {
         this.field_1622.onAdClosed();
      } catch (RemoteException var3) {
         class_368.method_2510("Could not call onAdClosed.", var3);
      }
   }

   public void onAdFailedToLoad(MediationBannerAdapter var1, int var2) {
      class_335.method_2304("onAdFailedToLoad must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdFailedToLoad with error. " + var2);

      try {
         this.field_1622.onAdFailedToLoad(var2);
      } catch (RemoteException var4) {
         class_368.method_2510("Could not call onAdFailedToLoad.", var4);
      }
   }

   public void onAdFailedToLoad(MediationInterstitialAdapter var1, int var2) {
      class_335.method_2304("onAdFailedToLoad must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdFailedToLoad with error " + var2 + ".");

      try {
         this.field_1622.onAdFailedToLoad(var2);
      } catch (RemoteException var4) {
         class_368.method_2510("Could not call onAdFailedToLoad.", var4);
      }
   }

   public void onAdLeftApplication(MediationBannerAdapter var1) {
      class_335.method_2304("onAdLeftApplication must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdLeftApplication.");

      try {
         this.field_1622.onAdLeftApplication();
      } catch (RemoteException var3) {
         class_368.method_2510("Could not call onAdLeftApplication.", var3);
      }
   }

   public void onAdLeftApplication(MediationInterstitialAdapter var1) {
      class_335.method_2304("onAdLeftApplication must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdLeftApplication.");

      try {
         this.field_1622.onAdLeftApplication();
      } catch (RemoteException var3) {
         class_368.method_2510("Could not call onAdLeftApplication.", var3);
      }
   }

   public void onAdLoaded(MediationBannerAdapter var1) {
      class_335.method_2304("onAdLoaded must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdLoaded.");

      try {
         this.field_1622.onAdLoaded();
      } catch (RemoteException var3) {
         class_368.method_2510("Could not call onAdLoaded.", var3);
      }
   }

   public void onAdLoaded(MediationInterstitialAdapter var1) {
      class_335.method_2304("onAdLoaded must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdLoaded.");

      try {
         this.field_1622.onAdLoaded();
      } catch (RemoteException var3) {
         class_368.method_2510("Could not call onAdLoaded.", var3);
      }
   }

   public void onAdOpened(MediationBannerAdapter var1) {
      class_335.method_2304("onAdOpened must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdOpened.");

      try {
         this.field_1622.onAdOpened();
      } catch (RemoteException var3) {
         class_368.method_2510("Could not call onAdOpened.", var3);
      }
   }

   public void onAdOpened(MediationInterstitialAdapter var1) {
      class_335.method_2304("onAdOpened must be called on the main UI thread.");
      class_368.method_2502("Adapter called onAdOpened.");

      try {
         this.field_1622.onAdOpened();
      } catch (RemoteException var3) {
         class_368.method_2510("Could not call onAdOpened.", var3);
      }
   }
}
