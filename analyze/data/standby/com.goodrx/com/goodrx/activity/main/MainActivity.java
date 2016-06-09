package com.goodrx.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.criteo.events.AppLaunchEvent;
import com.criteo.events.EventService;
import com.criteo.events.HomeViewEvent;
import com.goodrx.activity.SettingsActivity;
import com.goodrx.activity.main.MyRxFragment;
import com.goodrx.activity.main.WelcomeSearchFragment;
import com.goodrx.model.EventBusMessage;
import com.goodrx.receiver.ReminderAlarmReceiver;
import com.goodrx.utils.Const;
import com.goodrx.utils.InstallInfo;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.RatingPromptManager;
import com.goodrx.utils.Utils;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.google.gson.Gson;
import com.mobileapptracker.MobileAppTracker;
import com.newrelic.agent.android.NewRelic;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class MainActivity extends BaseActivityWithPasscode {
   private MainActivity.MainFragmentStatus fragmentStatus;
   private MobileAppTracker mobileAppTracker;
   private String parsePushData;

   private void initTracking() {
      NewRelic.withApplicationToken("AAf35461566208e270dacc87cd4ee63f54888015a6").start(this);
      Utils.sendTVSquredTrackingEvent(this, "home", "");
      this.mobileAppTracker = MobileAppTracker.init(this.getApplicationContext(), "189963", "8f00f8d44d8acb94a72f8925d3297982");
      this.mobileAppTracker.setAndroidId(Secure.getString(this.getContentResolver(), "android_id"));
      EventService var1 = new EventService(this.getApplicationContext());
      var1.send(new AppLaunchEvent());
      var1.send(new HomeViewEvent());
      AppsFlyerLib.getInstance().startTracking(this, Const.APPSFYLER_DEV_KEY);
      if(!InstallInfo.isValid(this)) {
         this.updateInstallInfo();
         InstallInfo.setValid(this, true);
      }

   }

   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, MainActivity.class));
   }

   public static void launch(Activity var0, MainActivity.MainFragmentStatus var1) {
      Intent var2 = new Intent(var0, MainActivity.class);
      Gson var3 = new Gson();
      String var4;
      if(!(var3 instanceof Gson)) {
         var4 = var3.toJson((Object)var1);
      } else {
         var4 = GsonInstrumentation.toJson((Gson)var3, (Object)var1);
      }

      var2.putExtra("init_status", var4);
      var0.startActivity(var2);
   }

   public static void launchClearTop(Activity var0) {
      Intent var1 = new Intent(var0, MainActivity.class);
      var1.setFlags(335544320);
      var0.startActivity(var1);
      var0.overridePendingTransition(2131034131, 2131034139);
   }

   private void saveInstallConversionData(Map<String, String> var1) {
      String var2 = (String)var1.get("af_status");
      if(var2 != null) {
         String var3 = (String)var1.get("campaign");
         if(var3 == null) {
            var3 = "";
         }

         InstallInfo.setCampaign(this, var3);
         if(var2.equalsIgnoreCase("organic")) {
            InstallInfo.setMediaSource(this, var2);
         } else {
            if(!var2.equalsIgnoreCase("non-organic")) {
               return;
            }

            InstallInfo.setMediaSource(this, (String)var1.get("media_source"));
         }

         InstallInfo.setInstallTime(this, (new DateTime(DateTimeZone.getDefault())).getMillis());
      }
   }

   private void updateInstallInfo() {
      AppsFlyerLib.getInstance().registerConversionListener(this, new AppsFlyerConversionListener() {
         public void onAppOpenAttribution(Map<String, String> var1) {
            MainActivity.this.saveInstallConversionData(var1);
         }

         public void onAttributionFailure(String var1) {
         }

         public void onInstallConversionDataLoaded(Map<String, String> var1) {
            MainActivity.this.saveInstallConversionData(var1);
         }

         public void onInstallConversionFailure(String var1) {
         }
      });
   }

   public void changeContentFrame(MainActivity.MainFragmentStatus var1, int var2) {
      if(this.fragmentStatus != var1) {
         this.fragmentStatus = var1;
         Object var4;
         if(var1 == MainActivity.MainFragmentStatus.MY_RX) {
            var4 = MyRxFragment.newInstance(this.parsePushData);
         } else {
            MainActivity.MainFragmentStatus var3 = MainActivity.MainFragmentStatus.WELCOME;
            var4 = null;
            if(var1 == var3) {
               var4 = WelcomeSearchFragment.newInstance();
            }
         }

         if(var4 != null) {
            FragmentTransaction var5 = this.getSupportFragmentManager().beginTransaction();
            var5.setTransition(var2);
            var5.replace(2131886271, (Fragment)var4, var1.toString()).commitAllowingStateLoss();
            return;
         }
      }

   }

   public void initData() {
      super.initData();
      MainActivity.MainFragmentStatus var1 = this.fragmentStatus;
      this.fragmentStatus = null;
      this.changeContentFrame(var1, 0);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968621);
      this.shouldOverrideBackAnimation(false);
      Intent var2 = this.getIntent();
      if(var2.hasExtra("com.parse.Data")) {
         this.parsePushData = var2.getStringExtra("com.parse.Data");
      }

      this.fragmentStatus = MainActivity.MainFragmentStatus.MY_RX;
      if(MyRxUtils.getRx(this).length == 0) {
         this.fragmentStatus = MainActivity.MainFragmentStatus.WELCOME;
      }

      if(var2.hasExtra("init_status")) {
         Gson var3 = new Gson();
         String var4 = var2.getStringExtra("init_status");
         Object var5;
         if(!(var3 instanceof Gson)) {
            var5 = var3.fromJson(var4, MainActivity.MainFragmentStatus.class);
         } else {
            var5 = GsonInstrumentation.fromJson((Gson)var3, var4, MainActivity.MainFragmentStatus.class);
         }

         this.fragmentStatus = (MainActivity.MainFragmentStatus)var5;
      }

      this.initData();
      ReminderAlarmReceiver.getInstance().scheduleAlarm(this);
      this.initTracking();
      (new RatingPromptManager(this)).appOpened();
   }

   @Subscribe
   public void onEvent(EventBusMessage<MainActivity.MainFragmentStatus> var1) {
      if(var1.getType().equals("changeContent")) {
         this.changeContentFrame((MainActivity.MainFragmentStatus)var1.getMessageContent(), 4097);
      }

   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 16908332) {
         SettingsActivity.launch(this);
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   protected void onPause() {
      super.onPause();
      EventBus.getDefault().unregister(this);
   }

   protected void onResume() {
      super.onResume();
      EventBus.getDefault().register(this);
      this.mobileAppTracker.setReferralSources(this);
      this.mobileAppTracker.measureSession();
   }

   public static enum MainFragmentStatus {
      MY_RX,
      WELCOME;

      static {
         MainActivity.MainFragmentStatus[] var0 = new MainActivity.MainFragmentStatus[]{MY_RX, WELCOME};
      }
   }
}
