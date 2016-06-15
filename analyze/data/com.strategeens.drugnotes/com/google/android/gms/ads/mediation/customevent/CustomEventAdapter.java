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
import com.google.android.gms.internal.class_368;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
   // $FF: renamed from: n android.view.View
   private View field_1766;
   // $FF: renamed from: xu com.google.android.gms.ads.mediation.customevent.CustomEventBanner
   private CustomEventBanner field_1767;
   // $FF: renamed from: xv com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial
   private CustomEventInterstitial field_1768;

   // $FF: renamed from: a (java.lang.String) java.lang.Object
   private static <T> T method_3046(String var0) {
      try {
         Object var2 = Class.forName(var0).newInstance();
         return var2;
      } catch (Throwable var3) {
         class_368.method_2506("Could not instantiate custom event adapter: " + var0 + ". " + var3.getMessage());
         return null;
      }
   }

   // $FF: renamed from: a (android.view.View) void
   private void method_3047(View var1) {
      this.field_1766 = var1;
   }

   public View getBannerView() {
      return this.field_1766;
   }

   public void onDestroy() {
      if(this.field_1767 != null) {
         this.field_1767.onDestroy();
      }

      if(this.field_1768 != null) {
         this.field_1768.onDestroy();
      }

   }

   public void onPause() {
      if(this.field_1767 != null) {
         this.field_1767.onPause();
      }

      if(this.field_1768 != null) {
         this.field_1768.onPause();
      }

   }

   public void onResume() {
      if(this.field_1767 != null) {
         this.field_1767.onResume();
      }

      if(this.field_1768 != null) {
         this.field_1768.onResume();
      }

   }

   public void requestBannerAd(Context var1, MediationBannerListener var2, Bundle var3, AdSize var4, MediationAdRequest var5, Bundle var6) {
      this.field_1767 = (CustomEventBanner)method_3046(var3.getString("class_name"));
      if(this.field_1767 == null) {
         var2.onAdFailedToLoad(this, 0);
      } else {
         Bundle var7;
         if(var6 == null) {
            var7 = null;
         } else {
            var7 = var6.getBundle(var3.getString("class_name"));
         }

         this.field_1767.requestBannerAd(var1, new CustomEventAdapter.class_1177(this, var2), var3.getString("parameter"), var4, var5, var7);
      }
   }

   public void requestInterstitialAd(Context var1, MediationInterstitialListener var2, Bundle var3, MediationAdRequest var4, Bundle var5) {
      this.field_1768 = (CustomEventInterstitial)method_3046(var3.getString("class_name"));
      if(this.field_1768 == null) {
         var2.onAdFailedToLoad(this, 0);
      } else {
         Bundle var6;
         if(var5 == null) {
            var6 = null;
         } else {
            var6 = var5.getBundle(var3.getString("class_name"));
         }

         this.field_1768.requestInterstitialAd(var1, new CustomEventAdapter.class_1178(this, var2), var3.getString("parameter"), var4, var6);
      }
   }

   public void showInterstitial() {
      this.field_1768.showInterstitial();
   }

   private static final class class_1177 implements CustomEventBannerListener {
      // $FF: renamed from: l com.google.android.gms.ads.mediation.MediationBannerListener
      private final MediationBannerListener field_2944;
      // $FF: renamed from: xw com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
      private final CustomEventAdapter field_2945;

      public class_1177(CustomEventAdapter var1, MediationBannerListener var2) {
         this.field_2945 = var1;
         this.field_2944 = var2;
      }

      public void onAdClicked() {
         class_368.method_2502("Custom event adapter called onAdClicked.");
         this.field_2944.onAdClicked(this.field_2945);
      }

      public void onAdClosed() {
         class_368.method_2502("Custom event adapter called onAdClosed.");
         this.field_2944.onAdClosed(this.field_2945);
      }

      public void onAdFailedToLoad(int var1) {
         class_368.method_2502("Custom event adapter called onAdFailedToLoad.");
         this.field_2944.onAdFailedToLoad(this.field_2945, var1);
      }

      public void onAdLeftApplication() {
         class_368.method_2502("Custom event adapter called onAdLeftApplication.");
         this.field_2944.onAdLeftApplication(this.field_2945);
      }

      public void onAdLoaded(View var1) {
         class_368.method_2502("Custom event adapter called onAdLoaded.");
         this.field_2945.method_3047(var1);
         this.field_2944.onAdLoaded(this.field_2945);
      }

      public void onAdOpened() {
         class_368.method_2502("Custom event adapter called onAdOpened.");
         this.field_2944.onAdOpened(this.field_2945);
      }
   }

   private class class_1178 implements CustomEventInterstitialListener {
      // $FF: renamed from: m com.google.android.gms.ads.mediation.MediationInterstitialListener
      private final MediationInterstitialListener field_2946;
      // $FF: renamed from: xw com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
      private final CustomEventAdapter field_2947;

      public class_1178(CustomEventAdapter var2, MediationInterstitialListener var3) {
         this.field_2947 = var2;
         this.field_2946 = var3;
      }

      public void onAdClicked() {
         class_368.method_2502("Custom event adapter called onAdClicked.");
         this.field_2946.onAdClicked(this.field_2947);
      }

      public void onAdClosed() {
         class_368.method_2502("Custom event adapter called onAdClosed.");
         this.field_2946.onAdClosed(this.field_2947);
      }

      public void onAdFailedToLoad(int var1) {
         class_368.method_2502("Custom event adapter called onFailedToReceiveAd.");
         this.field_2946.onAdFailedToLoad(this.field_2947, var1);
      }

      public void onAdLeftApplication() {
         class_368.method_2502("Custom event adapter called onAdLeftApplication.");
         this.field_2946.onAdLeftApplication(this.field_2947);
      }

      public void onAdLoaded() {
         class_368.method_2502("Custom event adapter called onReceivedAd.");
         this.field_2946.onAdLoaded(CustomEventAdapter.this);
      }

      public void onAdOpened() {
         class_368.method_2502("Custom event adapter called onAdOpened.");
         this.field_2946.onAdOpened(this.field_2947);
      }
   }
}
