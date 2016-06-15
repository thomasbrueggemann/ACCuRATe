package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventBanner;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.android.gms.internal.class_370;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
   // $FF: renamed from: n android.view.View
   private View field_2085;
   // $FF: renamed from: sT com.google.android.gms.ads.mediation.customevent.CustomEventBanner
   private CustomEventBanner field_2086;
   // $FF: renamed from: sU com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial
   private CustomEventInterstitial field_2087;

   // $FF: renamed from: a (java.lang.String) java.lang.Object
   private static <T> T method_2686(String var0) {
      try {
         Object var2 = Class.forName(var0).newInstance();
         return var2;
      } catch (Throwable var3) {
         class_370.method_2358("Could not instantiate custom event adapter: " + var0 + ". " + var3.getMessage());
         return null;
      }
   }

   // $FF: renamed from: a (android.view.View) void
   private void method_2687(View var1) {
      this.field_2085 = var1;
   }

   public View getBannerView() {
      return this.field_2085;
   }

   public void onDestroy() {
      if(this.field_2086 != null) {
         this.field_2086.onDestroy();
      }

      if(this.field_2087 != null) {
         this.field_2087.onDestroy();
      }

   }

   public void onPause() {
      if(this.field_2086 != null) {
         this.field_2086.onPause();
      }

      if(this.field_2087 != null) {
         this.field_2087.onPause();
      }

   }

   public void onResume() {
      if(this.field_2086 != null) {
         this.field_2086.onResume();
      }

      if(this.field_2087 != null) {
         this.field_2087.onResume();
      }

   }

   public void requestBannerAd(Context var1, MediationBannerListener var2, Bundle var3, AdSize var4, MediationAdRequest var5, Bundle var6) {
      this.field_2086 = (CustomEventBanner)method_2686(var3.getString("class_name"));
      if(this.field_2086 == null) {
         var2.onAdFailedToLoad(this, 0);
      } else {
         Bundle var7;
         if(var6 == null) {
            var7 = null;
         } else {
            var7 = var6.getBundle(var3.getString("class_name"));
         }

         this.field_2086.requestBannerAd(var1, new CustomEventAdapter.class_868(this, var2), var3.getString("parameter"), var4, var5, var7);
      }
   }

   public void requestInterstitialAd(Context var1, MediationInterstitialListener var2, Bundle var3, MediationAdRequest var4, Bundle var5) {
      this.field_2087 = (CustomEventInterstitial)method_2686(var3.getString("class_name"));
      if(this.field_2087 == null) {
         var2.onAdFailedToLoad(this, 0);
      } else {
         Bundle var6;
         if(var5 == null) {
            var6 = null;
         } else {
            var6 = var5.getBundle(var3.getString("class_name"));
         }

         this.field_2087.requestInterstitialAd(var1, new CustomEventAdapter.class_869(this, var2), var3.getString("parameter"), var4, var6);
      }
   }

   public void showInterstitial() {
      this.field_2087.showInterstitial();
   }

   private static final class class_868 implements CustomEventBannerListener {
      // $FF: renamed from: l com.google.android.gms.ads.mediation.MediationBannerListener
      private final MediationBannerListener field_3083;
      // $FF: renamed from: sV com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
      private final CustomEventAdapter field_3084;

      public class_868(CustomEventAdapter var1, MediationBannerListener var2) {
         this.field_3084 = var1;
         this.field_3083 = var2;
      }

      public void onAdClicked() {
         class_370.method_2363("Custom event adapter called onAdClicked.");
         this.field_3083.onAdClicked(this.field_3084);
      }

      public void onAdClosed() {
         class_370.method_2363("Custom event adapter called onAdClosed.");
         this.field_3083.onAdClosed(this.field_3084);
      }

      public void onAdFailedToLoad(int var1) {
         class_370.method_2363("Custom event adapter called onAdFailedToLoad.");
         this.field_3083.onAdFailedToLoad(this.field_3084, var1);
      }

      public void onAdLeftApplication() {
         class_370.method_2363("Custom event adapter called onAdLeftApplication.");
         this.field_3083.onAdLeftApplication(this.field_3084);
      }

      public void onAdLoaded(View var1) {
         class_370.method_2363("Custom event adapter called onAdLoaded.");
         this.field_3084.method_2687(var1);
         this.field_3083.onAdLoaded(this.field_3084);
      }

      public void onAdOpened() {
         class_370.method_2363("Custom event adapter called onAdOpened.");
         this.field_3083.onAdOpened(this.field_3084);
      }
   }

   private class class_869 implements CustomEventInterstitialListener {
      // $FF: renamed from: m com.google.android.gms.ads.mediation.MediationInterstitialListener
      private final MediationInterstitialListener field_3085;
      // $FF: renamed from: sV com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
      private final CustomEventAdapter field_3086;

      public class_869(CustomEventAdapter var2, MediationInterstitialListener var3) {
         this.field_3086 = var2;
         this.field_3085 = var3;
      }

      public void onAdClicked() {
         class_370.method_2363("Custom event adapter called onAdClicked.");
         this.field_3085.onAdClicked(this.field_3086);
      }

      public void onAdClosed() {
         class_370.method_2363("Custom event adapter called onAdClosed.");
         this.field_3085.onAdClosed(this.field_3086);
      }

      public void onAdFailedToLoad(int var1) {
         class_370.method_2363("Custom event adapter called onFailedToReceiveAd.");
         this.field_3085.onAdFailedToLoad(this.field_3086, var1);
      }

      public void onAdLeftApplication() {
         class_370.method_2363("Custom event adapter called onAdLeftApplication.");
         this.field_3085.onAdLeftApplication(this.field_3086);
      }

      public void onAdLoaded() {
         class_370.method_2363("Custom event adapter called onReceivedAd.");
         this.field_3085.onAdLoaded(CustomEventAdapter.this);
      }

      public void onAdOpened() {
         class_370.method_2363("Custom event adapter called onAdOpened.");
         this.field_3085.onAdOpened(this.field_3086);
      }
   }
}
