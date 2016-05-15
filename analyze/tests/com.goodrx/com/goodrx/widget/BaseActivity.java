package com.goodrx.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.comscore.analytics.comScore;
import com.goodrx.utils.tracker.GAHelper;

public class BaseActivity extends AppCompatActivity {
   protected boolean isActive;
   private boolean overrideAnimation;
   private String screenName;
   private boolean shouldSendScreenViewTracking;

   private void sendGATracking() {
      GAHelper.sendGoogleAnalyticsScreenView(this, this.screenName);
   }

   public void enableScreenViewTracking(int var1) {
      this.enableScreenViewTracking(this.getString(var1));
   }

   public void enableScreenViewTracking(String var1) {
      this.shouldSendScreenViewTracking = true;
      this.screenName = var1;
   }

   public void initData() {
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(var1 == 3 || var1 == 4) {
         this.initData();
      }

   }

   public void onBackPressed() {
      super.onBackPressed();
      if(this.overrideAnimation) {
         this.overridePendingTransition(2131034131, 2131034139);
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.isActive = true;
      this.overrideAnimation = true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 16908332) {
         this.onBackPressed();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   protected void onPause() {
      super.onPause();
      comScore.onExitForeground();
      this.isActive = false;
      if(this.shouldSendScreenViewTracking) {
         GAHelper.pushCloseScreenEvent(this, this.screenName);
      }

   }

   protected void onResume() {
      super.onResume();
      comScore.onEnterForeground();
      this.isActive = true;
      if(this.shouldSendScreenViewTracking) {
         this.sendGATracking();
      }

   }

   public void shouldOverrideBackAnimation(boolean var1) {
      this.overrideAnimation = var1;
   }
}
