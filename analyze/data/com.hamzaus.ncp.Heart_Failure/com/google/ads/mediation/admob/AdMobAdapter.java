package com.google.ads.mediation.admob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.class_371;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
   // $FF: renamed from: i com.google.android.gms.ads.AdView
   private AdView field_3143;
   // $FF: renamed from: j com.google.android.gms.ads.InterstitialAd
   private InterstitialAd field_3144;

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.ads.mediation.MediationAdRequest, android.os.Bundle, android.os.Bundle) com.google.android.gms.ads.AdRequest
   private static AdRequest method_3340(Context var0, MediationAdRequest var1, Bundle var2, Bundle var3) {
      AdRequest.Builder var4 = new AdRequest.Builder();
      Date var5 = var1.getBirthday();
      if(var5 != null) {
         var4.setBirthday(var5);
      }

      int var6 = var1.getGender();
      if(var6 != 0) {
         var4.setGender(var6);
      }

      Set var7 = var1.getKeywords();
      if(var7 != null) {
         Iterator var12 = var7.iterator();

         while(var12.hasNext()) {
            var4.addKeyword((String)var12.next());
         }
      }

      if(var1.isTesting()) {
         var4.addTestDevice(class_371.method_2371(var0));
      }

      if(var3.getInt("tagForChildDirectedTreatment") != -1) {
         boolean var9;
         if(var3.getInt("tagForChildDirectedTreatment") == 1) {
            var9 = true;
         } else {
            var9 = false;
         }

         var4.tagForChildDirectedTreatment(var9);
      }

      if(var2 == null) {
         var2 = new Bundle();
      }

      var2.putInt("gw", 1);
      var2.putString("mad_hac", var3.getString("mad_hac"));
      if(!TextUtils.isEmpty(var3.getString("adJson"))) {
         var2.putString("_ad", var3.getString("adJson"));
      }

      var2.putBoolean("_noRefresh", true);
      var4.addNetworkExtrasBundle(AdMobAdapter.class, var2);
      return var4.build();
   }

   public View getBannerView() {
      return this.field_3143;
   }

   public void onDestroy() {
      if(this.field_3143 != null) {
         this.field_3143.destroy();
         this.field_3143 = null;
      }

      if(this.field_3144 != null) {
         this.field_3144 = null;
      }

   }

   public void onPause() {
      if(this.field_3143 != null) {
         this.field_3143.pause();
      }

   }

   public void onResume() {
      if(this.field_3143 != null) {
         this.field_3143.resume();
      }

   }

   public void requestBannerAd(Context var1, MediationBannerListener var2, Bundle var3, AdSize var4, MediationAdRequest var5, Bundle var6) {
      this.field_3143 = new AdView(var1);
      this.field_3143.setAdSize(new AdSize(var4.getWidth(), var4.getHeight()));
      this.field_3143.setAdUnitId(var3.getString("pubid"));
      this.field_3143.setAdListener(new AdMobAdapter.class_895(this, var2));
      this.field_3143.loadAd(method_3340(var1, var5, var6, var3));
   }

   public void requestInterstitialAd(Context var1, MediationInterstitialListener var2, Bundle var3, MediationAdRequest var4, Bundle var5) {
      this.field_3144 = new InterstitialAd(var1);
      this.field_3144.setAdUnitId(var3.getString("pubid"));
      this.field_3144.setAdListener(new AdMobAdapter.class_884(this, var2));
      this.field_3144.loadAd(method_3340(var1, var4, var5, var3));
   }

   public void showInterstitial() {
      this.field_3144.show();
   }

   private static final class class_895 extends AdListener {
      // $FF: renamed from: k com.google.ads.mediation.admob.AdMobAdapter
      private final AdMobAdapter field_2099;
      // $FF: renamed from: l com.google.android.gms.ads.mediation.MediationBannerListener
      private final MediationBannerListener field_2100;

      public class_895(AdMobAdapter var1, MediationBannerListener var2) {
         this.field_2099 = var1;
         this.field_2100 = var2;
      }

      public void onAdClosed() {
         this.field_2100.onAdClosed(this.field_2099);
      }

      public void onAdFailedToLoad(int var1) {
         this.field_2100.onAdFailedToLoad(this.field_2099, var1);
      }

      public void onAdLeftApplication() {
         this.field_2100.onAdLeftApplication(this.field_2099);
      }

      public void onAdLoaded() {
         this.field_2100.onAdLoaded(this.field_2099);
      }

      public void onAdOpened() {
         this.field_2100.onAdClicked(this.field_2099);
         this.field_2100.onAdOpened(this.field_2099);
      }
   }

   private static final class class_884 extends AdListener {
      // $FF: renamed from: k com.google.ads.mediation.admob.AdMobAdapter
      private final AdMobAdapter field_2101;
      // $FF: renamed from: m com.google.android.gms.ads.mediation.MediationInterstitialListener
      private final MediationInterstitialListener field_2102;

      public class_884(AdMobAdapter var1, MediationInterstitialListener var2) {
         this.field_2101 = var1;
         this.field_2102 = var2;
      }

      public void onAdClosed() {
         this.field_2102.onAdClosed(this.field_2101);
      }

      public void onAdFailedToLoad(int var1) {
         this.field_2102.onAdFailedToLoad(this.field_2101, var1);
      }

      public void onAdLeftApplication() {
         this.field_2102.onAdLeftApplication(this.field_2101);
      }

      public void onAdLoaded() {
         this.field_2102.onAdLoaded(this.field_2101);
      }

      public void onAdOpened() {
         this.field_2102.onAdOpened(this.field_2101);
      }
   }
}
