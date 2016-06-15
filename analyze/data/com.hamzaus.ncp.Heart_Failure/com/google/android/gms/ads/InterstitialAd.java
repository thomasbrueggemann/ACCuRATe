package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_166;

public final class InterstitialAd {
   // $FF: renamed from: kw com.google.android.gms.internal.aw
   private final class_166 field_4012;

   public InterstitialAd(Context var1) {
      this.field_4012 = new class_166(var1);
   }

   public AdListener getAdListener() {
      return this.field_4012.getAdListener();
   }

   public String getAdUnitId() {
      return this.field_4012.getAdUnitId();
   }

   public InAppPurchaseListener getInAppPurchaseListener() {
      return this.field_4012.getInAppPurchaseListener();
   }

   public boolean isLoaded() {
      return this.field_4012.isLoaded();
   }

   public void loadAd(AdRequest var1) {
      this.field_4012.method_1252(var1.method_4466());
   }

   public void setAdListener(AdListener var1) {
      this.field_4012.setAdListener(var1);
   }

   public void setAdUnitId(String var1) {
      this.field_4012.setAdUnitId(var1);
   }

   public void setInAppPurchaseListener(InAppPurchaseListener var1) {
      this.field_4012.setInAppPurchaseListener(var1);
   }

   public void setPlayStorePurchaseParams(PlayStorePurchaseListener var1, String var2) {
      this.field_4012.setPlayStorePurchaseParams(var1, var2);
   }

   public void show() {
      this.field_4012.show();
   }
}
