package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.class_12;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_370;

// $FF: renamed from: com.google.android.gms.internal.bz
public final class class_416 implements MediationBannerListener, MediationInterstitialListener {
   // $FF: renamed from: nR com.google.android.gms.internal.bw
   private final class_12 field_1831;

   public class_416(class_12 var1) {
      this.field_1831 = var1;
   }

   public void onAdClicked(MediationBannerAdapter var1) {
      class_347.method_2164("onAdClicked must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdClicked.");

      try {
         this.field_1831.onAdClicked();
      } catch (RemoteException var3) {
         class_370.method_2361("Could not call onAdClicked.", var3);
      }
   }

   public void onAdClicked(MediationInterstitialAdapter var1) {
      class_347.method_2164("onAdClicked must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdClicked.");

      try {
         this.field_1831.onAdClicked();
      } catch (RemoteException var3) {
         class_370.method_2361("Could not call onAdClicked.", var3);
      }
   }

   public void onAdClosed(MediationBannerAdapter var1) {
      class_347.method_2164("onAdClosed must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdClosed.");

      try {
         this.field_1831.onAdClosed();
      } catch (RemoteException var3) {
         class_370.method_2361("Could not call onAdClosed.", var3);
      }
   }

   public void onAdClosed(MediationInterstitialAdapter var1) {
      class_347.method_2164("onAdClosed must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdClosed.");

      try {
         this.field_1831.onAdClosed();
      } catch (RemoteException var3) {
         class_370.method_2361("Could not call onAdClosed.", var3);
      }
   }

   public void onAdFailedToLoad(MediationBannerAdapter var1, int var2) {
      class_347.method_2164("onAdFailedToLoad must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdFailedToLoad with error. " + var2);

      try {
         this.field_1831.onAdFailedToLoad(var2);
      } catch (RemoteException var4) {
         class_370.method_2361("Could not call onAdFailedToLoad.", var4);
      }
   }

   public void onAdFailedToLoad(MediationInterstitialAdapter var1, int var2) {
      class_347.method_2164("onAdFailedToLoad must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdFailedToLoad with error " + var2 + ".");

      try {
         this.field_1831.onAdFailedToLoad(var2);
      } catch (RemoteException var4) {
         class_370.method_2361("Could not call onAdFailedToLoad.", var4);
      }
   }

   public void onAdLeftApplication(MediationBannerAdapter var1) {
      class_347.method_2164("onAdLeftApplication must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdLeftApplication.");

      try {
         this.field_1831.onAdLeftApplication();
      } catch (RemoteException var3) {
         class_370.method_2361("Could not call onAdLeftApplication.", var3);
      }
   }

   public void onAdLeftApplication(MediationInterstitialAdapter var1) {
      class_347.method_2164("onAdLeftApplication must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdLeftApplication.");

      try {
         this.field_1831.onAdLeftApplication();
      } catch (RemoteException var3) {
         class_370.method_2361("Could not call onAdLeftApplication.", var3);
      }
   }

   public void onAdLoaded(MediationBannerAdapter var1) {
      class_347.method_2164("onAdLoaded must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdLoaded.");

      try {
         this.field_1831.onAdLoaded();
      } catch (RemoteException var3) {
         class_370.method_2361("Could not call onAdLoaded.", var3);
      }
   }

   public void onAdLoaded(MediationInterstitialAdapter var1) {
      class_347.method_2164("onAdLoaded must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdLoaded.");

      try {
         this.field_1831.onAdLoaded();
      } catch (RemoteException var3) {
         class_370.method_2361("Could not call onAdLoaded.", var3);
      }
   }

   public void onAdOpened(MediationBannerAdapter var1) {
      class_347.method_2164("onAdOpened must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdOpened.");

      try {
         this.field_1831.onAdOpened();
      } catch (RemoteException var3) {
         class_370.method_2361("Could not call onAdOpened.", var3);
      }
   }

   public void onAdOpened(MediationInterstitialAdapter var1) {
      class_347.method_2164("onAdOpened must be called on the main UI thread.");
      class_370.method_2363("Adapter called onAdOpened.");

      try {
         this.field_1831.onAdOpened();
      } catch (RemoteException var3) {
         class_370.method_2361("Could not call onAdOpened.", var3);
      }
   }
}
