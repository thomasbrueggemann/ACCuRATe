package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_169;

public final class AdView extends ViewGroup {
   // $FF: renamed from: kv com.google.android.gms.internal.av
   private final class_169 field_4060;

   public AdView(Context var1) {
      super(var1);
      this.field_4060 = new class_169(this);
   }

   public AdView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.field_4060 = new class_169(this, var2, false);
   }

   public AdView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.field_4060 = new class_169(this, var2, false);
   }

   public void destroy() {
      this.field_4060.destroy();
   }

   public AdListener getAdListener() {
      return this.field_4060.getAdListener();
   }

   public AdSize getAdSize() {
      return this.field_4060.getAdSize();
   }

   public String getAdUnitId() {
      return this.field_4060.getAdUnitId();
   }

   public InAppPurchaseListener getInAppPurchaseListener() {
      return this.field_4060.getInAppPurchaseListener();
   }

   public void loadAd(AdRequest var1) {
      this.field_4060.method_1259(var1.method_4466());
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
      AdSize var4 = this.getAdSize();
      int var5;
      int var6;
      if(var3 != null && var3.getVisibility() != 8) {
         this.measureChild(var3, var1, var2);
         var6 = var3.getMeasuredWidth();
         var5 = var3.getMeasuredHeight();
      } else if(var4 != null) {
         Context var9 = this.getContext();
         var6 = var4.getWidthInPixels(var9);
         var5 = var4.getHeightInPixels(var9);
      } else {
         var5 = 0;
         var6 = 0;
      }

      int var7 = Math.max(var6, this.getSuggestedMinimumWidth());
      int var8 = Math.max(var5, this.getSuggestedMinimumHeight());
      this.setMeasuredDimension(View.resolveSize(var7, var1), View.resolveSize(var8, var2));
   }

   public void pause() {
      this.field_4060.pause();
   }

   public void resume() {
      this.field_4060.resume();
   }

   public void setAdListener(AdListener var1) {
      this.field_4060.setAdListener(var1);
   }

   public void setAdSize(AdSize var1) {
      this.field_4060.setAdSizes(new AdSize[]{var1});
   }

   public void setAdUnitId(String var1) {
      this.field_4060.setAdUnitId(var1);
   }

   public void setInAppPurchaseListener(InAppPurchaseListener var1) {
      this.field_4060.setInAppPurchaseListener(var1);
   }

   public void setPlayStorePurchaseParams(PlayStorePurchaseListener var1, String var2) {
      this.field_4060.setPlayStorePurchaseParams(var1, var2);
   }
}
