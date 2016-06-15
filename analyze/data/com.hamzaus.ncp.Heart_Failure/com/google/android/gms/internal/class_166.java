package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_158;
import com.google.android.gms.internal.class_168;
import com.google.android.gms.internal.class_170;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_175;
import com.google.android.gms.internal.class_181;
import com.google.android.gms.internal.class_195;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_426;
import com.google.android.gms.internal.class_441;
import com.google.android.gms.internal.class_6;

// $FF: renamed from: com.google.android.gms.internal.aw
public final class class_166 {
   // $FF: renamed from: lO com.google.android.gms.ads.AdListener
   private AdListener field_521;
   // $FF: renamed from: mA com.google.android.gms.ads.purchase.PlayStorePurchaseListener
   private PlayStorePurchaseListener field_522;
   private final Context mContext;
   // $FF: renamed from: mf com.google.android.gms.ads.doubleclick.AppEventListener
   private AppEventListener field_523;
   // $FF: renamed from: mh java.lang.String
   private String field_524;
   // $FF: renamed from: mu com.google.android.gms.internal.bt
   private final class_195 field_525;
   // $FF: renamed from: mv com.google.android.gms.internal.al
   private final class_175 field_526;
   // $FF: renamed from: mw com.google.android.gms.internal.ar
   private class_6 field_527;
   // $FF: renamed from: mx java.lang.String
   private String field_528;
   // $FF: renamed from: mz com.google.android.gms.ads.purchase.InAppPurchaseListener
   private InAppPurchaseListener field_529;

   public class_166(Context var1) {
      this(var1, class_175.method_1274());
   }

   public class_166(Context var1, class_175 var2) {
      this.field_525 = new class_195();
      this.mContext = var1;
      this.field_526 = var2;
   }

   // $FF: renamed from: k (java.lang.String) void
   private void method_1250(String var1) throws RemoteException {
      if(this.field_524 == null) {
         this.method_1251(var1);
      }

      this.field_527 = class_181.method_1292(this.mContext, new class_172(), this.field_524, this.field_525);
      if(this.field_521 != null) {
         this.field_527.method_11(new class_158(this.field_521));
      }

      if(this.field_523 != null) {
         this.field_527.method_12(new class_170(this.field_523));
      }

      if(this.field_529 != null) {
         this.field_527.method_13(new class_441(this.field_529));
      }

      if(this.field_522 != null) {
         this.field_527.method_14(new class_426(this.field_522), this.field_528);
      }

   }

   // $FF: renamed from: l (java.lang.String) void
   private void method_1251(String var1) {
      if(this.field_527 == null) {
         throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + var1 + " is called.");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.au) void
   public void method_1252(class_168 var1) {
      try {
         if(this.field_527 == null) {
            this.method_1250("loadAd");
         }

         if(this.field_527.method_15(this.field_526.method_1275(this.mContext, var1))) {
            this.field_525.method_1312(var1.method_1254());
         }

      } catch (RemoteException var3) {
         class_370.method_2361("Failed to load ad.", var3);
      }
   }

   public AdListener getAdListener() {
      return this.field_521;
   }

   public String getAdUnitId() {
      return this.field_524;
   }

   public AppEventListener getAppEventListener() {
      return this.field_523;
   }

   public InAppPurchaseListener getInAppPurchaseListener() {
      return this.field_529;
   }

   public boolean isLoaded() {
      try {
         if(this.field_527 == null) {
            return false;
         } else {
            boolean var2 = this.field_527.isReady();
            return var2;
         }
      } catch (RemoteException var3) {
         class_370.method_2361("Failed to check if ad is ready.", var3);
         return false;
      }
   }

   public void setAdListener(AdListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setAdUnitId(String var1) {
      if(this.field_524 != null) {
         throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
      } else {
         this.field_524 = var1;
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
         this.method_1251("show");
         this.field_527.showInterstitial();
      } catch (RemoteException var2) {
         class_370.method_2361("Failed to show interstitial.", var2);
      }
   }
}
