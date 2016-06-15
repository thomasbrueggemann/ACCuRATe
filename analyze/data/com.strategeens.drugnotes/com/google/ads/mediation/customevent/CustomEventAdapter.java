package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventBanner;
import com.google.ads.mediation.customevent.CustomEventBannerListener;
import com.google.ads.mediation.customevent.CustomEventInterstitial;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventServerParameters;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.class_368;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
   // $FF: renamed from: n android.view.View
   private View field_4018;
   // $FF: renamed from: o com.google.ads.mediation.customevent.CustomEventBanner
   private CustomEventBanner field_4019;
   // $FF: renamed from: p com.google.ads.mediation.customevent.CustomEventInterstitial
   private CustomEventInterstitial field_4020;

   // $FF: renamed from: a (java.lang.String) java.lang.Object
   private static <T> T method_5306(String var0) {
      try {
         Object var2 = Class.forName(var0).newInstance();
         return var2;
      } catch (Throwable var3) {
         class_368.method_2506("Could not instantiate custom event adapter: " + var0 + ". " + var3.getMessage());
         return null;
      }
   }

   // $FF: renamed from: a (android.view.View) void
   private void method_5307(View var1) {
      this.field_4018 = var1;
   }

   public void destroy() {
      if(this.field_4019 != null) {
         this.field_4019.destroy();
      }

      if(this.field_4020 != null) {
         this.field_4020.destroy();
      }

   }

   public Class<CustomEventExtras> getAdditionalParametersType() {
      return CustomEventExtras.class;
   }

   public View getBannerView() {
      return this.field_4018;
   }

   public Class<CustomEventServerParameters> getServerParametersType() {
      return CustomEventServerParameters.class;
   }

   public void requestBannerAd(MediationBannerListener var1, Activity var2, CustomEventServerParameters var3, AdSize var4, MediationAdRequest var5, CustomEventExtras var6) {
      this.field_4019 = (CustomEventBanner)method_5306(var3.className);
      if(this.field_4019 == null) {
         var1.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      } else {
         Object var7;
         if(var6 == null) {
            var7 = null;
         } else {
            var7 = var6.getExtra(var3.label);
         }

         this.field_4019.requestBannerAd(new CustomEventAdapter.class_1551(this, var1), var2, var3.label, var3.parameter, var4, var5, var7);
      }
   }

   public void requestInterstitialAd(MediationInterstitialListener var1, Activity var2, CustomEventServerParameters var3, MediationAdRequest var4, CustomEventExtras var5) {
      this.field_4020 = (CustomEventInterstitial)method_5306(var3.className);
      if(this.field_4020 == null) {
         var1.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      } else {
         Object var6;
         if(var5 == null) {
            var6 = null;
         } else {
            var6 = var5.getExtra(var3.label);
         }

         this.field_4020.requestInterstitialAd(new CustomEventAdapter.class_1552(this, var1), var2, var3.label, var3.parameter, var4, var6);
      }
   }

   public void showInterstitial() {
      this.field_4020.showInterstitial();
   }

   private static final class class_1551 implements CustomEventBannerListener {
      // $FF: renamed from: q com.google.ads.mediation.customevent.CustomEventAdapter
      private final CustomEventAdapter field_3145;
      // $FF: renamed from: r com.google.ads.mediation.MediationBannerListener
      private final MediationBannerListener field_3146;

      public class_1551(CustomEventAdapter var1, MediationBannerListener var2) {
         this.field_3145 = var1;
         this.field_3146 = var2;
      }

      public void onClick() {
         class_368.method_2502("Custom event adapter called onFailedToReceiveAd.");
         this.field_3146.onClick(this.field_3145);
      }

      public void onDismissScreen() {
         class_368.method_2502("Custom event adapter called onFailedToReceiveAd.");
         this.field_3146.onDismissScreen(this.field_3145);
      }

      public void onFailedToReceiveAd() {
         class_368.method_2502("Custom event adapter called onFailedToReceiveAd.");
         this.field_3146.onFailedToReceiveAd(this.field_3145, AdRequest.ErrorCode.NO_FILL);
      }

      public void onLeaveApplication() {
         class_368.method_2502("Custom event adapter called onFailedToReceiveAd.");
         this.field_3146.onLeaveApplication(this.field_3145);
      }

      public void onPresentScreen() {
         class_368.method_2502("Custom event adapter called onFailedToReceiveAd.");
         this.field_3146.onPresentScreen(this.field_3145);
      }

      public void onReceivedAd(View var1) {
         class_368.method_2502("Custom event adapter called onReceivedAd.");
         this.field_3145.method_5307(var1);
         this.field_3146.onReceivedAd(this.field_3145);
      }
   }

   private class class_1552 implements CustomEventInterstitialListener {
      // $FF: renamed from: q com.google.ads.mediation.customevent.CustomEventAdapter
      private final CustomEventAdapter field_3152;
      // $FF: renamed from: s com.google.ads.mediation.MediationInterstitialListener
      private final MediationInterstitialListener field_3153;

      public class_1552(CustomEventAdapter var2, MediationInterstitialListener var3) {
         this.field_3152 = var2;
         this.field_3153 = var3;
      }

      public void onDismissScreen() {
         class_368.method_2502("Custom event adapter called onDismissScreen.");
         this.field_3153.onDismissScreen(this.field_3152);
      }

      public void onFailedToReceiveAd() {
         class_368.method_2502("Custom event adapter called onFailedToReceiveAd.");
         this.field_3153.onFailedToReceiveAd(this.field_3152, AdRequest.ErrorCode.NO_FILL);
      }

      public void onLeaveApplication() {
         class_368.method_2502("Custom event adapter called onLeaveApplication.");
         this.field_3153.onLeaveApplication(this.field_3152);
      }

      public void onPresentScreen() {
         class_368.method_2502("Custom event adapter called onPresentScreen.");
         this.field_3153.onPresentScreen(this.field_3152);
      }

      public void onReceivedAd() {
         class_368.method_2502("Custom event adapter called onReceivedAd.");
         this.field_3153.onReceivedAd(CustomEventAdapter.this);
      }
   }
}
