package com.goodrx.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.goodrx.model.BestPharmacy;
import com.goodrx.utils.tracker.GAHelper;
import com.goodrx.widget.CouponDialogFragment;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;

public class BestPharmacyCouponDialogFragment extends CouponDialogFragment {
   private static final String BEST_PHARMACY = "best_pharmacy";
   private static final String BLOCK_LOGO = "block_logo";
   private static final String COUNT = "count";
   private BestPharmacy bestPharmacy;
   private boolean blockLogo;
   private int count;

   public static BestPharmacyCouponDialogFragment newInstance(BestPharmacy var0, int var1, boolean var2) {
      BestPharmacyCouponDialogFragment var3 = new BestPharmacyCouponDialogFragment();
      Bundle var4 = new Bundle();
      Gson var5 = new Gson();
      String var6;
      if(!(var5 instanceof Gson)) {
         var6 = var5.toJson((Object)var0);
      } else {
         var6 = GsonInstrumentation.toJson((Gson)var5, (Object)var0);
      }

      var4.putString("best_pharmacy", var6);
      var4.putInt("count", var1);
      var4.putBoolean("block_logo", var2);
      var3.setArguments(var4);
      return var3;
   }

   protected void initArguments() {
      Gson var1 = new Gson();
      String var2 = this.getArguments().getString("best_pharmacy");
      Object var3;
      if(!(var1 instanceof Gson)) {
         var3 = var1.fromJson(var2, BestPharmacy.class);
      } else {
         var3 = GsonInstrumentation.fromJson((Gson)var1, var2, BestPharmacy.class);
      }

      this.bestPharmacy = (BestPharmacy)var3;
      this.count = this.getArguments().getInt("count");
      this.blockLogo = this.getArguments().getBoolean("block_logo");
   }

   protected void sendGAEvent(Context var1) {
      GAHelper.sendGoogleAnalyticsScreenView(var1, 2131427833);
      GAHelper.sendGoogleAnalyticsEvent(var1, var1.getString(2131427468), var1.getString(2131427405), "My Rx");
   }

   protected void updateUI(View var1) {
      this.btnShare.setVisibility(8);
      this.btnCopy.setVisibility(8);
      this.couponObject = this.bestPharmacy.getAccount().convertToCouponObject();
      if(this.blockLogo) {
         TextView var8 = this.txtTitle;
         String var9 = this.getString(2131427533);
         Object[] var10 = new Object[1];
         Resources var11 = this.getResources();
         int var12 = this.count;
         Object[] var13 = new Object[]{Integer.valueOf(this.count)};
         var10[0] = var11.getQuantityString(2131361812, var12, var13);
         var8.setText(String.format(var9, var10));
      } else {
         TextView var2 = this.txtTitle;
         String var3 = this.getString(2131427504);
         Object[] var4 = new Object[1];
         Resources var5 = this.getResources();
         int var6 = this.count;
         Object[] var7 = new Object[]{Integer.valueOf(this.count)};
         var4[0] = var5.getQuantityString(2131361812, var6, var7);
         var2.setText(String.format(var3, var4));
      }
   }
}
