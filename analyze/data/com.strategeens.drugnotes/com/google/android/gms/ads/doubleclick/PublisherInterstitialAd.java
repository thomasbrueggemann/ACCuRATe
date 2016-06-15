package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.internal.class_232;

public final class PublisherInterstitialAd {
   // $FF: renamed from: lm com.google.android.gms.internal.bi
   private final class_232 field_3885;

   public PublisherInterstitialAd(Context var1) {
      this.field_3885 = new class_232(var1, this);
   }

   public AdListener getAdListener() {
      return this.field_3885.getAdListener();
   }

   public String getAdUnitId() {
      return this.field_3885.getAdUnitId();
   }

   public AppEventListener getAppEventListener() {
      return this.field_3885.getAppEventListener();
   }

   public String getMediationAdapterClassName() {
      return this.field_3885.getMediationAdapterClassName();
   }

   public boolean isLoaded() {
      return this.field_3885.isLoaded();
   }

   public void loadAd(PublisherAdRequest var1) {
      this.field_3885.method_1587(var1.method_5211());
   }

   public void setAdListener(AdListener var1) {
      this.field_3885.setAdListener(var1);
   }

   public void setAdUnitId(String var1) {
      this.field_3885.setAdUnitId(var1);
   }

   public void setAppEventListener(AppEventListener var1) {
      this.field_3885.setAppEventListener(var1);
   }

   public void show() {
      this.field_3885.show();
   }
}
