package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.internal.class_166;

public final class PublisherInterstitialAd {
   // $FF: renamed from: kw com.google.android.gms.internal.aw
   private final class_166 field_3742;

   public PublisherInterstitialAd(Context var1) {
      this.field_3742 = new class_166(var1);
   }

   public AdListener getAdListener() {
      return this.field_3742.getAdListener();
   }

   public String getAdUnitId() {
      return this.field_3742.getAdUnitId();
   }

   public AppEventListener getAppEventListener() {
      return this.field_3742.getAppEventListener();
   }

   public boolean isLoaded() {
      return this.field_3742.isLoaded();
   }

   public void loadAd(PublisherAdRequest var1) {
      this.field_3742.method_1252(var1.method_4100());
   }

   public void setAdListener(AdListener var1) {
      this.field_3742.setAdListener(var1);
   }

   public void setAdUnitId(String var1) {
      this.field_3742.setAdUnitId(var1);
   }

   public void setAppEventListener(AppEventListener var1) {
      this.field_3742.setAppEventListener(var1);
   }

   public void show() {
      this.field_3742.show();
   }
}
