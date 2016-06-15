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
import com.google.android.gms.internal.class_370;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
   // $FF: renamed from: n android.view.View
   private View field_3943;
   // $FF: renamed from: o com.google.ads.mediation.customevent.CustomEventBanner
   private CustomEventBanner field_3944;
   // $FF: renamed from: p com.google.ads.mediation.customevent.CustomEventInterstitial
   private CustomEventInterstitial field_3945;

   // $FF: renamed from: a (java.lang.String) java.lang.Object
   private static <T> T method_4226(String var0) {
      try {
         Object var2 = Class.forName(var0).newInstance();
         return var2;
      } catch (Throwable var3) {
         class_370.method_2358("Could not instantiate custom event adapter: " + var0 + ". " + var3.getMessage());
         return null;
      }
   }

   // $FF: renamed from: a (android.view.View) void
   private void method_4227(View var1) {
      this.field_3943 = var1;
   }

   public void destroy() {
      if(this.field_3944 != null) {
         this.field_3944.destroy();
      }

      if(this.field_3945 != null) {
         this.field_3945.destroy();
      }

   }

   public Class<CustomEventExtras> getAdditionalParametersType() {
      return CustomEventExtras.class;
   }

   public View getBannerView() {
      return this.field_3943;
   }

   public Class<CustomEventServerParameters> getServerParametersType() {
      return CustomEventServerParameters.class;
   }

   public void requestBannerAd(MediationBannerListener var1, Activity var2, CustomEventServerParameters var3, AdSize var4, MediationAdRequest var5, CustomEventExtras var6) {
      this.field_3944 = (CustomEventBanner)method_4226(var3.className);
      if(this.field_3944 == null) {
         var1.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      } else {
         Object var7;
         if(var6 == null) {
            var7 = null;
         } else {
            var7 = var6.getExtra(var3.label);
         }

         this.field_3944.requestBannerAd(new CustomEventAdapter.class_1191(this, var1), var2, var3.label, var3.parameter, var4, var5, var7);
      }
   }

   public void requestInterstitialAd(MediationInterstitialListener var1, Activity var2, CustomEventServerParameters var3, MediationAdRequest var4, CustomEventExtras var5) {
      this.field_3945 = (CustomEventInterstitial)method_4226(var3.className);
      if(this.field_3945 == null) {
         var1.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      } else {
         Object var6;
         if(var5 == null) {
            var6 = null;
         } else {
            var6 = var5.getExtra(var3.label);
         }

         this.field_3945.requestInterstitialAd(new CustomEventAdapter.class_1192(this, var1), var2, var3.label, var3.parameter, var4, var6);
      }
   }

   public void showInterstitial() {
      this.field_3945.showInterstitial();
   }

   private static final class class_1191 implements CustomEventBannerListener {
      // $FF: renamed from: q com.google.ads.mediation.customevent.CustomEventAdapter
      private final CustomEventAdapter field_3176;
      // $FF: renamed from: r com.google.ads.mediation.MediationBannerListener
      private final MediationBannerListener field_3177;

      public class_1191(CustomEventAdapter var1, MediationBannerListener var2) {
         this.field_3176 = var1;
         this.field_3177 = var2;
      }

      public void onClick() {
         class_370.method_2363("Custom event adapter called onFailedToReceiveAd.");
         this.field_3177.onClick(this.field_3176);
      }

      public void onDismissScreen() {
         class_370.method_2363("Custom event adapter called onFailedToReceiveAd.");
         this.field_3177.onDismissScreen(this.field_3176);
      }

      public void onFailedToReceiveAd() {
         class_370.method_2363("Custom event adapter called onFailedToReceiveAd.");
         this.field_3177.onFailedToReceiveAd(this.field_3176, AdRequest.ErrorCode.NO_FILL);
      }

      public void onLeaveApplication() {
         class_370.method_2363("Custom event adapter called onFailedToReceiveAd.");
         this.field_3177.onLeaveApplication(this.field_3176);
      }

      public void onPresentScreen() {
         class_370.method_2363("Custom event adapter called onFailedToReceiveAd.");
         this.field_3177.onPresentScreen(this.field_3176);
      }

      public void onReceivedAd(View var1) {
         class_370.method_2363("Custom event adapter called onReceivedAd.");
         this.field_3176.method_4227(var1);
         this.field_3177.onReceivedAd(this.field_3176);
      }
   }

   private class class_1192 implements CustomEventInterstitialListener {
      // $FF: renamed from: q com.google.ads.mediation.customevent.CustomEventAdapter
      private final CustomEventAdapter field_3201;
      // $FF: renamed from: s com.google.ads.mediation.MediationInterstitialListener
      private final MediationInterstitialListener field_3202;

      public class_1192(CustomEventAdapter var2, MediationInterstitialListener var3) {
         this.field_3201 = var2;
         this.field_3202 = var3;
      }

      public void onDismissScreen() {
         class_370.method_2363("Custom event adapter called onDismissScreen.");
         this.field_3202.onDismissScreen(this.field_3201);
      }

      public void onFailedToReceiveAd() {
         class_370.method_2363("Custom event adapter called onFailedToReceiveAd.");
         this.field_3202.onFailedToReceiveAd(this.field_3201, AdRequest.ErrorCode.NO_FILL);
      }

      public void onLeaveApplication() {
         class_370.method_2363("Custom event adapter called onLeaveApplication.");
         this.field_3202.onLeaveApplication(this.field_3201);
      }

      public void onPresentScreen() {
         class_370.method_2363("Custom event adapter called onPresentScreen.");
         this.field_3202.onPresentScreen(this.field_3201);
      }

      public void onReceivedAd() {
         class_370.method_2363("Custom event adapter called onReceivedAd.");
         this.field_3202.onReceivedAd(CustomEventAdapter.this);
      }
   }
}
