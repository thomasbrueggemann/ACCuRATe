package com.goodrx.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.goodrx.activity.StoreDetailActivity;
import com.goodrx.model.BestPharmacy;
import com.goodrx.model.PharmacyLocationObject;
import com.goodrx.utils.Utils;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.BestPharmacyCouponDialogFragment;
import com.goodrx.widget.BestPharmacyDetailHeader;
import com.goodrx.widget.BestPharmacyDetailItem;
import com.goodrx.widget.BestPharmacyLocationView;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BestPharmacyDetailActivity extends BaseActivityWithPasscode {
   private BestPharmacyDetailActivity.OnBestPharmacyItemClickListener bestPharmacyItemClickListener;
   private int couponDrugCount;
   private LinearLayout layoutBestPharmacyPrice;
   private View layoutNameHidden;
   private LinearLayout layoutRoot;
   private BestPharmacy pharmacy;
   private TextView txtLocation;
   private TextView txtPrice;
   private String[] types;

   private boolean shouldBlockLogo() {
      String var1 = this.pharmacy.getName();
      return var1.equalsIgnoreCase("walmart") || var1.toLowerCase().contains("sam");
   }

   public String getTitle(String var1) {
      return var1.equals(this.types[0])?this.getString(2131427722):(var1.equals(this.types[1])?this.getString(2131427723):(var1.equals(this.types[2])?this.getString(2131427724):(var1.equals(this.types[3])?this.getString(2131427693):(var1.equals(this.types[4])?this.getString(2131428006):""))));
   }

   public void initComponents() {
      this.layoutRoot = (LinearLayout)this.findViewById(2131886245);
      this.layoutBestPharmacyPrice = (LinearLayout)this.findViewById(2131886246);
      this.txtLocation = (TextView)this.findViewById(2131886248);
      this.txtPrice = (TextView)this.findViewById(2131886247);
      this.layoutNameHidden = this.findViewById(2131886249);
      this.bestPharmacyItemClickListener = new BestPharmacyDetailActivity.OnBestPharmacyItemClickListener(null);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427826);
      this.setContentView(2130968605);
      String var2 = this.getIntent().getStringExtra("pharmacy_json");
      Gson var3 = new Gson();
      Object var4;
      if(!(var3 instanceof Gson)) {
         var4 = var3.fromJson(var2, BestPharmacy.class);
      } else {
         var4 = GsonInstrumentation.fromJson((Gson)var3, var2, BestPharmacy.class);
      }

      this.pharmacy = (BestPharmacy)var4;
      this.types = new String[]{"Cash Price", "Membership", "Co-Pay", "No price information", "Coupon"};
      this.setSupportActionBar((Toolbar)this.findViewById(2131886238));
      ActionBar var5 = this.getSupportActionBar();
      var5.setDisplayShowTitleEnabled(true);
      var5.setDisplayHomeAsUpEnabled(true);
      var5.setHomeAsUpIndicator(2130837662);
      this.initComponents();
      this.updateUI();
   }

   public void showCouponView(int var1) {
      if(this.isActive) {
         BestPharmacyCouponDialogFragment.newInstance(this.pharmacy, var1, this.shouldBlockLogo()).show(this.getSupportFragmentManager(), "dialog");
      }
   }

   public void updateUI() {
      this.getSupportActionBar().setTitle(this.pharmacy.getName());
      TextView var1 = this.txtLocation;
      String var2 = this.getResources().getQuantityString(2131361818, this.pharmacy.getPharmacy_info().length);
      Object[] var3 = new Object[]{this.pharmacy.getName()};
      var1.setText(String.format(var2, var3));
      this.txtPrice.setText(Utils.formatPrice(Double.valueOf(this.pharmacy.getTotal_price())));
      HashMap var4 = new HashMap();
      String[] var5 = this.types;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         var4.put(var5[var7], new ArrayList());
      }

      BestPharmacy.Entry[] var8 = this.pharmacy.getEntries();
      int var9 = var8.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         BestPharmacy.Entry var25 = var8[var10];
         ((ArrayList)var4.get(var25.getType())).add(var25);
      }

      String[] var11 = this.types;
      int var12 = var11.length;

      for(int var13 = 0; var13 < var12; ++var13) {
         String var18 = var11[var13];
         ArrayList var19 = (ArrayList)var4.get(var18);
         if(var19.size() != 0) {
            BestPharmacyDetailHeader var20 = new BestPharmacyDetailHeader(this);
            var20.setTitle(this.getTitle(var18));
            if(var18.equals(this.types[4])) {
               var20.setButtonAvailable(true);
               if(this.shouldBlockLogo()) {
                  var20.setButtonText(this.getString(2131428012));
               } else {
                  var20.setButtonText(this.getString(2131428011));
               }

               this.couponDrugCount = var19.size();
               var20.setOnButtonClickListener(new OnClickListener() {
                  public void onClick(View var1) {
                     BestPharmacyDetailActivity.this.showCouponView(BestPharmacyDetailActivity.this.couponDrugCount);
                  }
               });
            }

            this.layoutBestPharmacyPrice.addView(var20);

            BestPharmacyDetailItem var24;
            for(Iterator var21 = var19.iterator(); var21.hasNext(); this.layoutBestPharmacyPrice.addView(var24)) {
               BestPharmacy.Entry var23 = (BestPharmacy.Entry)var21.next();
               var24 = new BestPharmacyDetailItem(this);
               var24.setDrugName(var23.getDisplay(this));
               var24.setAmount(var23.getAmount());
               if(var18.equals(this.types[3])) {
                  var24.hidePrice(true);
               } else {
                  var24.setPrice(var23.getPrice());
               }

               var24.setType(var18);
               if(var18.equals(this.types[4])) {
                  var24.setOnClickListener(this.bestPharmacyItemClickListener);
               }
            }

            LayoutInflater.from(this).inflate(2130968676, this.layoutBestPharmacyPrice, true);
         }
      }

      final PharmacyLocationObject[] var14 = this.pharmacy.getPharmacy_info();

      for(final int var15 = 0; var15 < var14.length; ++var15) {
         BestPharmacyLocationView var16 = new BestPharmacyLocationView(this, var15, var14[var15].getAddress(), var14[var15].getDistance()) {
            public void onClicked(int var1) {
               BestPharmacyDetailActivity.this.overridePendingTransition(2131034132, 2131034138);
               StoreDetailActivity.launch(BestPharmacyDetailActivity.this, var14[var1], (String)null);
            }
         };
         this.layoutRoot.addView(var16);
      }

      if(var14.length > 0) {
         LayoutInflater.from(this).inflate(2130968676, this.layoutRoot, true);
      }

      if(this.pharmacy.getType().equals("nabp")) {
         this.txtLocation.setVisibility(8);
         this.layoutNameHidden.setVisibility(0);
      }

   }

   private class OnBestPharmacyItemClickListener implements OnClickListener {
      private OnBestPharmacyItemClickListener() {
      }

      // $FF: synthetic method
      OnBestPharmacyItemClickListener(Object var2) {
         this();
      }

      public void onClick(View var1) {
         BestPharmacyDetailActivity.this.showCouponView(BestPharmacyDetailActivity.this.couponDrugCount);
      }
   }
}
