package com.goodrx.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import com.goodrx.utils.Utils;
import com.goodrx.utils.tracker.GAHelper;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;

public class RatingPromptManager {
   private Context mContext;
   private RatingPromptManager.RatingStatus mRatingStatus;

   public RatingPromptManager(Context var1) {
      this.mContext = var1;
      this.mRatingStatus = this.getLatestRatingStatus();
   }

   private RatingPromptManager.RatingStatus getLatestRatingStatus() {
      this.mRatingStatus = new RatingPromptManager.RatingStatus();
      String var1 = this.getSharedPreference().getString("rating_prompt_status", (String)null);
      if(var1 != null) {
         Gson var2 = new Gson();
         Object var3;
         if(!(var2 instanceof Gson)) {
            var3 = var2.fromJson(var1, RatingPromptManager.RatingStatus.class);
         } else {
            var3 = GsonInstrumentation.fromJson((Gson)var2, var1, RatingPromptManager.RatingStatus.class);
         }

         this.mRatingStatus = (RatingPromptManager.RatingStatus)var3;
      }

      return this.mRatingStatus;
   }

   private SharedPreferences getSharedPreference() {
      return PreferenceManager.getDefaultSharedPreferences(this.mContext);
   }

   private void persist() {
      Editor var1 = this.getSharedPreference().edit();
      Gson var2 = new Gson();
      RatingPromptManager.RatingStatus var3 = this.mRatingStatus;
      String var4;
      if(!(var2 instanceof Gson)) {
         var4 = var2.toJson((Object)var3);
      } else {
         var4 = GsonInstrumentation.toJson((Gson)var2, (Object)var3);
      }

      var1.putString("rating_prompt_status", var4).apply();
   }

   private void showNegativeDialog() {
      (new AlertDialog.Builder(this.mContext)).setTitle(2131427772).setMessage(2131427771).setPositiveButton(2131428036, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            GAHelper.sendGoogleAnalyticsEvent(RatingPromptManager.this.mContext, "Rating Dialogue Box", "Disliked", "Gave Feedback");
            Utils.sendEmail(RatingPromptManager.this.mContext, "info@goodrx.com", "GoodRx Android app Feedback");
         }
      }).setNegativeButton(2131427682, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            GAHelper.sendGoogleAnalyticsEvent(RatingPromptManager.this.mContext, "Rating Dialogue Box", "Disliked", "Didn\'t Give Feedback");
         }
      }).show();
   }

   private void showPositiveDialog() {
      AlertDialog.Builder var1 = new AlertDialog.Builder(this.mContext);
      var1.setMessage(2131427770).setTitle(2131427774).setMessage(2131427773);
      var1.setPositiveButton("Rate this app", new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            GAHelper.sendGoogleAnalyticsEvent(RatingPromptManager.this.mContext, "Rating Dialogue Box", "Loved", "Rate");
            Utils.openAppStore(RatingPromptManager.this.mContext);
         }
      });
      var1.setNegativeButton("Remind me later", new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            GAHelper.sendGoogleAnalyticsEvent(RatingPromptManager.this.mContext, "Rating Dialogue Box", "Loved", "Remind Me Later");
            RatingPromptManager.this.reset();
         }
      });
      var1.setNeutralButton("No thanks", new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            GAHelper.sendGoogleAnalyticsEvent(RatingPromptManager.this.mContext, "Rating Dialogue Box", "Loved", "No Thanks");
         }
      });
      var1.show();
   }

   private void showRatingPrompt() {
      AlertDialog.Builder var1 = new AlertDialog.Builder(this.mContext);
      var1.setMessage(2131427770);
      var1.setPositiveButton(2131428036, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            RatingPromptManager.this.showPositiveDialog();
         }
      });
      var1.setNegativeButton(2131427682, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            RatingPromptManager.this.showNegativeDialog();
         }
      });
      var1.show();
      GAHelper.sendGoogleAnalyticsEvent(this.mContext, "Rating Dialogue Box", "Shown", (String)null);
   }

   public void appOpened() {
      RatingPromptManager.RatingStatus.access$008(this.mRatingStatus);
      this.persist();
      if(this.shouldShowRatingPrompt()) {
         this.showRatingPrompt();
         this.ratingPromptFinished();
      }

   }

   public void ratingPromptFinished() {
      this.mRatingStatus.ratingPromptShowed = true;
      this.persist();
   }

   public void reset() {
      this.mRatingStatus = new RatingPromptManager.RatingStatus();
      this.persist();
   }

   public boolean shouldShowRatingPrompt() {
      long var1 = Utils.getCurrentTimeInMillis();
      return !this.mRatingStatus.ratingPromptShowed && var1 - this.mRatingStatus.installDate > 172800000L && this.mRatingStatus.usageCount > 2;
   }

   private class RatingStatus {
      private long installDate = Utils.getCurrentTimeInMillis();
      private boolean ratingPromptShowed = false;
      private int usageCount = 0;

      // $FF: synthetic method
      static int access$008(RatingPromptManager.RatingStatus var0) {
         int var1 = var0.usageCount;
         var0.usageCount = var1 + 1;
         return var1;
      }
   }
}
