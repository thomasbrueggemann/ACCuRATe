package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.doubleclick.class_194;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_210;
import com.google.android.gms.internal.class_217;
import com.google.android.gms.internal.class_220;
import com.google.android.gms.internal.class_231;
import com.google.android.gms.internal.class_235;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_239;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_405;
import com.google.android.gms.internal.class_410;
import com.google.android.gms.internal.class_450;
import com.google.android.gms.internal.class_6;

// $FF: renamed from: com.google.android.gms.internal.bi
public class class_232 {
   private final Context mContext;
   // $FF: renamed from: oH com.google.android.gms.internal.cx
   private final class_450 field_417;
   // $FF: renamed from: oI com.google.android.gms.internal.ax
   private final class_210 field_418;
   // $FF: renamed from: oJ com.google.android.gms.internal.bd
   private class_6 field_419;
   // $FF: renamed from: oK java.lang.String
   private String field_420;
   // $FF: renamed from: oM com.google.android.gms.ads.purchase.InAppPurchaseListener
   private InAppPurchaseListener field_421;
   // $FF: renamed from: oN com.google.android.gms.ads.purchase.PlayStorePurchaseListener
   private PlayStorePurchaseListener field_422;
   // $FF: renamed from: oO com.google.android.gms.ads.doubleclick.b
   private class_194 field_423;
   // $FF: renamed from: oP com.google.android.gms.ads.doubleclick.PublisherInterstitialAd
   private PublisherInterstitialAd field_424;
   // $FF: renamed from: ob com.google.android.gms.ads.AdListener
   private AdListener field_425;
   // $FF: renamed from: os com.google.android.gms.ads.doubleclick.AppEventListener
   private AppEventListener field_426;
   // $FF: renamed from: ou java.lang.String
   private String field_427;

   public class_232(Context var1) {
      this(var1, class_210.method_1508(), (PublisherInterstitialAd)null);
   }

   public class_232(Context var1, PublisherInterstitialAd var2) {
      this(var1, class_210.method_1508(), var2);
   }

   public class_232(Context var1, class_210 var2, PublisherInterstitialAd var3) {
      this.field_417 = new class_450();
      this.mContext = var1;
      this.field_418 = var2;
      this.field_424 = var3;
   }

   // $FF: renamed from: v (java.lang.String) void
   private void method_1585(String var1) throws RemoteException {
      if(this.field_427 == null) {
         this.method_1586(var1);
      }

      this.field_419 = class_217.method_1528(this.mContext, new class_237(), this.field_427, this.field_417);
      if(this.field_425 != null) {
         this.field_419.method_11(new class_220(this.field_425));
      }

      if(this.field_426 != null) {
         this.field_419.method_12(new class_235(this.field_426));
      }

      if(this.field_421 != null) {
         this.field_419.method_14(new class_405(this.field_421));
      }

      if(this.field_422 != null) {
         this.field_419.method_15(new class_410(this.field_422), this.field_420);
      }

      if(this.field_423 != null) {
         this.field_419.method_13(new class_239(this.field_423));
      }

   }

   // $FF: renamed from: w (java.lang.String) void
   private void method_1586(String var1) {
      if(this.field_419 == null) {
         throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + var1 + " is called.");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.bg) void
   public void method_1587(class_231 var1) {
      try {
         if(this.field_419 == null) {
            this.method_1585("loadAd");
         }

         if(this.field_419.method_16(this.field_418.method_1509(this.mContext, var1))) {
            this.field_417.method_2915(var1.method_1582());
         }

      } catch (RemoteException var3) {
         class_368.method_2510("Failed to load ad.", var3);
      }
   }

   public AdListener getAdListener() {
      return this.field_425;
   }

   public String getAdUnitId() {
      return this.field_427;
   }

   public AppEventListener getAppEventListener() {
      return this.field_426;
   }

   public InAppPurchaseListener getInAppPurchaseListener() {
      return this.field_421;
   }

   public String getMediationAdapterClassName() {
      try {
         if(this.field_419 != null) {
            String var2 = this.field_419.getMediationAdapterClassName();
            return var2;
         }
      } catch (RemoteException var3) {
         class_368.method_2510("Failed to get the mediation adapter class name.", var3);
      }

      return null;
   }

   public boolean isLoaded() {
      try {
         if(this.field_419 == null) {
            return false;
         } else {
            boolean var2 = this.field_419.isReady();
            return var2;
         }
      } catch (RemoteException var3) {
         class_368.method_2510("Failed to check if ad is ready.", var3);
         return false;
      }
   }

   public void setAdListener(AdListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setAdUnitId(String var1) {
      if(this.field_427 != null) {
         throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
      } else {
         this.field_427 = var1;
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
         this.method_1586("show");
         this.field_419.showInterstitial();
      } catch (RemoteException var2) {
         class_368.method_2510("Failed to show interstitial.", var2);
      }
   }
}
