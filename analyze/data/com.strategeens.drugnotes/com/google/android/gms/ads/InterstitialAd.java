package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_232;

public final class InterstitialAd {
   // $FF: renamed from: lm com.google.android.gms.internal.bi
   private final class_232 field_4119;

   public InterstitialAd(Context var1) {
      this.field_4119 = new class_232(var1);
   }

   public AdListener getAdListener() {
      return this.field_4119.getAdListener();
   }

   public String getAdUnitId() {
      return this.field_4119.getAdUnitId();
   }

   public InAppPurchaseListener getInAppPurchaseListener() {
      return this.field_4119.getInAppPurchaseListener();
   }

   public String getMediationAdapterClassName() {
      return this.field_4119.getMediationAdapterClassName();
   }

   public boolean isLoaded() {
      return this.field_4119.isLoaded();
   }

   public void loadAd(AdRequest var1) {
      this.field_4119.method_1587(var1.method_5693());
   }

   public void setAdListener(AdListener var1) {
      this.field_4119.setAdListener(var1);
   }

   public void setAdUnitId(String var1) {
      this.field_4119.setAdUnitId(var1);
   }

   public void setInAppPurchaseListener(InAppPurchaseListener var1) {
      this.field_4119.setInAppPurchaseListener(var1);
   }

   public void setPlayStorePurchaseParams(PlayStorePurchaseListener var1, String var2) {
      this.field_4119.setPlayStorePurchaseParams(var1, var2);
   }

   public void show() {
      this.field_4119.show();
   }
}
