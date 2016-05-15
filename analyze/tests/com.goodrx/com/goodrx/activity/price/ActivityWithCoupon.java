package com.goodrx.activity.price;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.model.DrugObject;
import com.goodrx.model.EventBusMessage;
import com.goodrx.model.MyRx;
import com.goodrx.model.PharmacyObject;
import com.goodrx.model.Price;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.tracker.GAHelper;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.CouponDialogFragment;
import com.goodrx.widget.MultipleButtonDialogView;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class ActivityWithCoupon extends BaseActivityWithPasscode implements OnDismissListener {
   private final String CUSTOMER_SERVICE_NUMBER_DEFAULT = "888-799-2553";
   private final double DISTANCE_RADIUS_MILE = 0.3D;
   private final String GOODRX_INFO_EMAIL = "info@goodrx.com";
   private String couponJsonString;
   protected String drugId;
   protected MyProgressBar myProgressBar;
   protected int quantity;
   private int viewId;

   private void addRx(String var1, int var2, String var3) {
      this.myProgressBar.show();
      GoodRxAPI.getInstance().addRx(this, var1, var2, var3, (String)null, new OnRequestFinishListener() {
         public void onFailure(int var1, String var2) {
            super.onFailure(var1, var2);
            ActivityWithCoupon.this.myProgressBar.dismiss();
         }

         public void onSuccess(String var1) {
            ActivityWithCoupon.this.refreshRx();
         }
      });
   }

   private void feedbackNotYet() {
      this.showFeedbackDialog("No worries!", "We\'ll check in with you later.\n\nHave any feedback for us?", new String[]{"Send feedback", "<b>Dismiss</b>"}, new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            if(var3 == 0) {
               ActivityWithCoupon.this.sendEmailTo("info@goodrx.com");
            }

         }
      });
   }

   private void feedbackStart() {
      this.showFeedbackDialog("Coupon Feedback", "How was your experience using this coupon?", new String[]{"Great! I saved a bunch", "I had an issue at the pharmacy", "I\'m not at the pharmacy yet", "<b>Dismiss</b>"}, new OnItemClickListener() {
         String action = ActivityWithCoupon.this.getString(2131427403);
         String categary = ActivityWithCoupon.this.getString(2131427467);

         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            if(var3 == 0) {
               ActivityWithCoupon.this.feedbackSuccess();
               GAHelper.sendGoogleAnalyticsEvent(ActivityWithCoupon.this, this.categary, this.action, ActivityWithCoupon.this.getString(2131427636));
            } else {
               if(var3 == 1) {
                  ActivityWithCoupon.this.feedbackTrouble();
                  GAHelper.sendGoogleAnalyticsEvent(ActivityWithCoupon.this, this.categary, this.action, ActivityWithCoupon.this.getString(2131427637));
                  return;
               }

               if(var3 == 2) {
                  ActivityWithCoupon.this.feedbackNotYet();
                  GAHelper.sendGoogleAnalyticsEvent(ActivityWithCoupon.this, this.categary, this.action, ActivityWithCoupon.this.getString(2131427638));
                  return;
               }

               if(var3 == 3) {
                  GAHelper.sendGoogleAnalyticsEvent(ActivityWithCoupon.this, this.categary, this.action, ActivityWithCoupon.this.getString(2131427634));
                  return;
               }
            }

         }
      });
   }

   private void feedbackSuccess() {
      this.showFeedbackDialog("Awesome!", "We\'re happy to hear it.\n\nIf you have any other feedback, please let us know.", new String[]{"Send feedback", "<b>Dismiss</b>"}, new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            if(var3 == 0) {
               ActivityWithCoupon.this.sendEmailTo("info@goodrx.com");
            }

         }
      });
   }

   private void feedbackTrouble() {
      this.showFeedbackDialog("Sorry!", "We\'d like to help.\n\nPlease call Customer Care for assistance with your coupon.", new String[]{"Call Customer Care", "Send feedback to GoodRx", "<b>Dismiss</b>"}, new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            if(var3 == 0) {
               String var6 = (new JsonParser()).parse(ActivityWithCoupon.this.couponJsonString).getAsJsonObject().getAsJsonObject("coupon_object").getAsJsonPrimitive("customer_phone").getAsString();
               String var7;
               if(var6 != null && var6.length() != 0) {
                  var7 = Utils.changePhoneNumberToUriFormat(var6);
               } else {
                  var7 = "888-799-2553";
               }

               Utils.openDialPanel(ActivityWithCoupon.this, var7);
            } else if(var3 == 1) {
               ActivityWithCoupon.this.sendEmailTo("info@goodrx.com");
               return;
            }

         }
      });
   }

   private void refreshRx() {
      GoodRxAPI.getInstance().getRx(this, new OnRequestFinishListener() {
         public void onSuccess(MyRx[] var1) {
            ActivityWithCoupon.this.myProgressBar.dismiss();
            MyRxUtils.saveRx(ActivityWithCoupon.this, var1);
            ActivityWithCoupon.this.showAddSuccefulDialog();
            EventBus.getDefault().post("addRxSuccess");
         }
      });
   }

   private void sendEmailTo(String var1) {
      Intent var2 = new Intent("android.intent.action.SENDTO");
      var2.setType("text/plain");
      var2.putExtra("android.intent.extra.SUBJECT", "");
      var2.putExtra("android.intent.extra.TEXT", "");
      var2.setData(Uri.parse("mailto:" + var1));
      var2.addFlags(268435456);
      this.startActivity(var2);
   }

   private boolean shouldShowFeedback() {
      if(this.couponJsonString != null) {
         JsonObject var1 = (new JsonParser()).parse(this.couponJsonString).getAsJsonObject().getAsJsonObject("pharmacy_object");
         Gson var2 = new Gson();
         Object var3;
         if(!(var2 instanceof Gson)) {
            var3 = var2.fromJson((JsonElement)var1, (Class)PharmacyObject.class);
         } else {
            var3 = GsonInstrumentation.fromJson((Gson)var2, (JsonElement)var1, (Class)PharmacyObject.class);
         }

         PharmacyObject var4 = (PharmacyObject)var3;
         if(var4.getClosest_location() != null && var4.getClosest_location().doubleValue() <= 0.3D) {
            SharedPreferences var5 = this.getSharedPreferences("goodrx", 0);
            long var6 = var5.getLong("coupon_feedback_last_active_time", 0L);
            int var8 = var5.getInt("showup_times", 0);
            int var9;
            if((new DateTime(DateTimeZone.getDefault())).getMillis() - var6 > 3600000L) {
               var5.edit().putLong("coupon_feedback_last_active_time", (new DateTime(DateTimeZone.getDefault())).getMillis()).apply();
               var9 = 1;
            } else {
               var9 = var8 + 1;
            }

            var5.edit().putInt("showup_times", var9).apply();
            boolean var10;
            if(var9 <= 3) {
               var10 = true;
            } else {
               var10 = false;
            }

            return var10;
         }
      }

      return false;
   }

   private void showFeedbackDialog(String var1, String var2, String[] var3, final OnItemClickListener var4) {
      AlertDialog.Builder var5 = new AlertDialog.Builder(this);
      MultipleButtonDialogView var6 = new MultipleButtonDialogView(this, var1, var2, var3);
      var5.setView(var6);
      final AlertDialog var8 = var5.create();
      var6.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4x) {
            var8.dismiss();
            var4.onItemClick(var1, var2, var3, var4x);
         }
      });
      var8.show();
      var8.setCanceledOnTouchOutside(false);
   }

   public void getCouponInfo(Price var1) {
      this.myProgressBar.show();
      GoodRxAPI.getInstance().getCouponInfo(this, this.drugId, this.quantity, var1.getPharmacy_object().getId(), var1.getCoupon_network(), new OnRequestFinishListener() {
         public void onSuccess(String var1) {
            ActivityWithCoupon.this.myProgressBar.dismiss();
            ActivityWithCoupon.this.couponJsonString = var1;
            ActivityWithCoupon.this.showCouponView(ActivityWithCoupon.this.couponJsonString);
         }
      });
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(this.viewId);
      this.myProgressBar = (MyProgressBar)this.findViewById(2131886399);
      this.setSupportActionBar((Toolbar)this.findViewById(2131886238));
      ActionBar var2 = this.getSupportActionBar();
      var2.setDisplayShowTitleEnabled(true);
      var2.setDisplayHomeAsUpEnabled(true);
      var2.setHomeAsUpIndicator(2130837662);
   }

   public void onDismiss(DialogInterface var1) {
      if(this.shouldShowFeedback()) {
         this.feedbackStart();
      } else if(!MyRxUtils.containsRx(this, this.drugId)) {
         this.showAddRxDialog();
         return;
      }

   }

   @Subscribe
   public void onEvent(EventBusMessage<Price> var1) {
      if(var1.getType().equals("priceClicked")) {
         Price var2 = (Price)var1.getMessageContent();
         String var3 = var2.getType();
         byte var4 = -1;
         switch(var3.hashCode()) {
         case -1354573786:
            if(var3.equals("coupon")) {
               var4 = 0;
            }
            break;
         case 273184065:
            if(var3.equals("discount")) {
               var4 = 1;
            }
            break;
         case 1588692301:
            if(var3.equals("affiliate")) {
               var4 = 2;
            }
         }

         switch(var4) {
         case 0:
            this.getCouponInfo(var2);
            return;
         case 1:
            this.showMembershipDialog(var2);
            return;
         case 2:
            this.showPillPackDialog(var2);
            return;
         default:
            this.showCashDialog(var2);
         }
      } else if(var1.getType().equals("showCoupon")) {
         this.getCouponInfo((Price)var1.getMessageContent());
         return;
      }

   }

   protected void onPause() {
      EventBus.getDefault().unregister(this);
      super.onPause();
   }

   protected void onResume() {
      super.onResume();
      EventBus.getDefault().register(this);
   }

   protected void setView(int var1) {
      this.viewId = var1;
   }

   public void showAddRxDialog() {
      View var1 = View.inflate(this, 2130968665, (ViewGroup)null);
      Button var2 = (Button)var1.findViewById(2131886411);
      AlertDialog.Builder var3 = DialogHelper.dialogWithCustomViewBuilder(this, 2131427423, var1);
      var3.setNegativeButton(2131427701, (OnClickListener)null);
      final AlertDialog var5 = var3.create();
      var2.setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1) {
            var5.dismiss();
            JsonObject var2 = (new JsonParser()).parse(ActivityWithCoupon.this.couponJsonString).getAsJsonObject().getAsJsonObject("pharmacy_object");
            Gson var3 = new Gson();
            Object var4;
            if(!(var3 instanceof Gson)) {
               var4 = var3.fromJson((JsonElement)var2, (Class)PharmacyObject.class);
            } else {
               var4 = GsonInstrumentation.fromJson((Gson)var3, (JsonElement)var2, (Class)PharmacyObject.class);
            }

            PharmacyObject var5x = (PharmacyObject)var4;
            ActivityWithCoupon.this.addRx(ActivityWithCoupon.this.drugId, ActivityWithCoupon.this.quantity, var5x.getId());
            GAHelper.sendGoogleAnalyticsEvent(ActivityWithCoupon.this, ActivityWithCoupon.this.getString(2131427469), ActivityWithCoupon.this.getString(2131427571), ActivityWithCoupon.this.getString(2131427576));
         }
      });
      var5.show();
   }

   public void showAddSuccefulDialog() {
      JsonObject var1 = (new JsonParser()).parse(this.couponJsonString).getAsJsonObject().getAsJsonObject("drug_object");
      Gson var2 = new Gson();
      Object var3;
      if(!(var2 instanceof Gson)) {
         var3 = var2.fromJson((JsonElement)var1, (Class)DrugObject.class);
      } else {
         var3 = GsonInstrumentation.fromJson((Gson)var2, (JsonElement)var1, (Class)DrugObject.class);
      }

      DrugObject var4 = (DrugObject)var3;
      AlertDialog.Builder var5 = new AlertDialog.Builder(this);
      var5.setTitle(2131427415);
      String var7 = this.getString(2131427414);
      Object[] var8 = new Object[]{var4.getDisplay()};
      var5.setMessage(Html.fromHtml(String.format(var7, var8)));
      var5.setPositiveButton(2131427709, (OnClickListener)null);
      DialogHelper.showDialog(var5);
   }

   protected void showCashDialog(final Price var1) {
      View var2 = View.inflate(this, 2130968666, (ViewGroup)null);
      TextView var3 = (TextView)var2.findViewById(2131886415);
      TextView var4 = (TextView)var2.findViewById(2131886416);
      var3.setText(Utils.formatPrice(Double.valueOf(var1.getPrice())));
      var4.setText(Html.fromHtml(var1.getPharmacy_object().getInfo()));
      TextView var5 = (TextView)var2.findViewById(2131886412);
      TextView var6 = (TextView)var2.findViewById(2131886414);
      var5.setText(var1.getType_display());
      var6.setText(var1.getType_display());
      AlertDialog.Builder var7 = new AlertDialog.Builder(this);
      var7.setView(var2);
      final AlertDialog var9 = var7.create();
      var2.findViewById(2131886413).setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1) {
            var9.dismiss();
         }
      });
      TextView var10 = (TextView)var2.findViewById(2131886417);
      if(var1.getUrl() == null) {
         var10.setText(this.getString(2131427709));
         var10.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View var1) {
               var9.dismiss();
            }
         });
      } else {
         String var11 = this.getString(2131428019);
         Object[] var12 = new Object[]{var1.getPharmacy_object().getName()};
         var10.setText(String.format(var11, var12));
         var10.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View var1x) {
               DialogHelper.openExternalWebsite(ActivityWithCoupon.this, var1.getUrl()).show();
            }
         });
      }

      var9.show();
   }

   public void showCouponView(String var1) {
      if(this.isActive) {
         CouponDialogFragment.newInstance(var1, this.drugId, this.quantity).show(this.getSupportFragmentManager(), "dialog");
      }
   }

   protected void showMembershipDialog(final Price var1) {
      View var2 = View.inflate(this, 2130968672, (ViewGroup)null);
      TextView var3 = (TextView)var2.findViewById(2131886433);
      TextView var4 = (TextView)var2.findViewById(2131886434);
      TextView var5 = (TextView)var2.findViewById(2131886435);
      if(var1.getDiscount_program_cost() != null) {
         var3.setText(Utils.formatPrice(var1.getDiscount_program_cost()));
      }

      var4.setText(Utils.formatPrice(Double.valueOf(var1.getPrice())));
      var5.setText(Html.fromHtml(var1.getDiscount_program_description()));
      AlertDialog.Builder var6 = new AlertDialog.Builder(this);
      var6.setView(var2);
      final AlertDialog var8 = var6.create();
      var2.findViewById(2131886413).setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1) {
            var8.dismiss();
         }
      });
      var2.findViewById(2131886417).setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1x) {
            DialogHelper.openExternalWebsite(ActivityWithCoupon.this, var1.getDiscount_program_url()).show();
         }
      });
      var8.show();
   }

   protected void showPillPackDialog(final Price var1) {
      View var2 = View.inflate(this, 2130968674, (ViewGroup)null);
      ((TextView)var2.findViewById(2131886415)).setText(Utils.formatPrice(Double.valueOf(var1.getPrice())));
      AlertDialog.Builder var3 = new AlertDialog.Builder(this);
      var3.setView(var2);
      final AlertDialog var5 = var3.create();
      var2.findViewById(2131886413).setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1) {
            var5.dismiss();
         }
      });
      TextView var6 = (TextView)var2.findViewById(2131886417);
      String var7 = this.getString(2131428019);
      Object[] var8 = new Object[]{var1.getPharmacy_object().getName()};
      var6.setText(String.format(var7, var8));
      var6.setOnClickListener(new android.view.View.OnClickListener() {
         public void onClick(View var1x) {
            DialogHelper.openExternalWebsite(ActivityWithCoupon.this, var1.getUrl()).show();
         }
      });
      var5.show();
   }
}
