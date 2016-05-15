package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzab;

public final class PublisherAdView extends ViewGroup {
   private final zzab zzoJ;

   public AdListener getAdListener() {
      return this.zzoJ.getAdListener();
   }

   public AdSize getAdSize() {
      return this.zzoJ.getAdSize();
   }

   public AdSize[] getAdSizes() {
      return this.zzoJ.getAdSizes();
   }

   public String getAdUnitId() {
      return this.zzoJ.getAdUnitId();
   }

   public AppEventListener getAppEventListener() {
      return this.zzoJ.getAppEventListener();
   }

   public String getMediationAdapterClassName() {
      return this.zzoJ.getMediationAdapterClassName();
   }

   public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
      return this.zzoJ.getOnCustomRenderedAdLoadedListener();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      View var6 = this.getChildAt(0);
      if(var6 != null && var6.getVisibility() != 8) {
         int var7 = var6.getMeasuredWidth();
         int var8 = var6.getMeasuredHeight();
         int var9 = (var4 - var2 - var7) / 2;
         int var10 = (var5 - var3 - var8) / 2;
         var6.layout(var9, var10, var7 + var9, var8 + var10);
      }

   }

   protected void onMeasure(int var1, int var2) {
      View var3 = this.getChildAt(0);
      int var5;
      int var6;
      if(var3 != null && var3.getVisibility() != 8) {
         this.measureChild(var3, var1, var2);
         var6 = var3.getMeasuredWidth();
         var5 = var3.getMeasuredHeight();
      } else {
         AdSize var4 = this.getAdSize();
         if(var4 != null) {
            Context var9 = this.getContext();
            var6 = var4.getWidthInPixels(var9);
            var5 = var4.getHeightInPixels(var9);
         } else {
            var5 = 0;
            var6 = 0;
         }
      }

      int var7 = Math.max(var6, this.getSuggestedMinimumWidth());
      int var8 = Math.max(var5, this.getSuggestedMinimumHeight());
      this.setMeasuredDimension(View.resolveSize(var7, var1), View.resolveSize(var8, var2));
   }

   public void setAdListener(AdListener var1) {
      this.zzoJ.setAdListener(var1);
   }

   public void setAdSizes(AdSize... var1) {
      if(var1 != null && var1.length >= 1) {
         this.zzoJ.zza(var1);
      } else {
         throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
      }
   }

   public void setAdUnitId(String var1) {
      this.zzoJ.setAdUnitId(var1);
   }

   public void setAppEventListener(AppEventListener var1) {
      this.zzoJ.setAppEventListener(var1);
   }

   public void setCorrelator(Correlator var1) {
      this.zzoJ.setCorrelator(var1);
   }

   public void setManualImpressionsEnabled(boolean var1) {
      this.zzoJ.setManualImpressionsEnabled(var1);
   }

   public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener var1) {
      this.zzoJ.setOnCustomRenderedAdLoadedListener(var1);
   }
}
