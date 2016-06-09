package com.goodrx.activity;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import butterknife.ButterKnife;
import com.goodrx.activity.AboutActivity;
import com.goodrx.activity.CreateAccountActivity;
import com.goodrx.activity.HtmlDisplayerActivity;
import com.goodrx.activity.SignInActivity;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.activity.passcode.PasscodeSettingActivity;
import com.goodrx.utils.AccountInfoUtils;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.HistoryRecordOperator;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.PasscodeManager;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.utils.tracker.GAHelper;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.goodrx.widget.SettingItemWithSwitch;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class SettingsActivity extends BaseActivityWithPasscode {
   private final long[] durations = new long[]{1000L, 60000L, 300000L, 1800000L, 3600000L, 14400000L};
   MyProgressBar myProgressBar;
   SettingItemWithSwitch scPasscode;
   TextView txtEmail;
   TextView txtpasscodeValidDuration;
   View viewAccountInfo;
   View viewNotLogin;
   View viewPasscodeDetail;

   private void deleteData() {
      MyRxUtils.clear(this);
      LocationUtils.clear(this);
      HistoryRecordOperator.deleteAll(this);
   }

   private void getNewToken() {
      this.myProgressBar.show();
      GoodRxAPI.getInstance().getNewToken(this, new OnRequestFinishListener() {
         public void onSuccess(String var1) {
            SettingsActivity.this.myProgressBar.dismiss();
            JsonObject var2 = (new JsonParser()).parse(var1).getAsJsonObject();
            String var3 = var2.getAsJsonPrimitive("token").getAsString();
            String var4 = var2.getAsJsonPrimitive("token_id").getAsString();
            AccountInfoUtils.save(SettingsActivity.this, var3, var4, (String)null);
            SettingsActivity.this.deleteData();
            SettingsActivity.this.setEmail((String)null);
            SettingsActivity.this.openMainActivity((String)null);
         }
      });
   }

   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, SettingsActivity.class));
      var0.overridePendingTransition(2131034130, 2131034140);
   }

   private void openMainActivity(String var1) {
      Intent var2 = new Intent(this, MainActivity.class);
      MyRxUtils.setRxUpdateFlag(this);
      var2.setFlags(67108864);
      if(var1 != null) {
         var2.putExtra("init_status", var1);
      }

      this.startActivity(var2);
      this.finish();
   }

   private void updatePasscodeUI(boolean var1) {
      if(var1) {
         this.scPasscode.setChecked(true);
         this.viewPasscodeDetail.setVisibility(0);
      } else {
         this.scPasscode.setChecked(false);
         this.viewPasscodeDetail.setVisibility(8);
      }
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(var1 != 6 && var1 != 7) {
         if(var1 == 18 && var2 != -1) {
            this.scPasscode.setChecked(false);
            return;
         }
      } else if(var2 == -1) {
         this.setEmail(AccountInfoUtils.getEmail(this));
         Gson var4 = new Gson();
         MainActivity.MainFragmentStatus var5 = MainActivity.MainFragmentStatus.MY_RX;
         String var6;
         if(!(var4 instanceof Gson)) {
            var6 = var4.toJson((Object)var5);
         } else {
            var6 = GsonInstrumentation.toJson((Gson)var4, (Object)var5);
         }

         this.openMainActivity(var6);
         return;
      }

   }

   public void onBackPressed() {
      super.onBackPressed();
      this.overridePendingTransition(2131034141, 2131034137);
   }

   void onClick(View var1) {
      int var2 = var1.getId();
      if(var2 == 2131886734) {
         this.startActivityForResult(new Intent(this, CreateAccountActivity.class), 6);
         this.overridePendingTransition(2131034132, 2131034138);
      } else {
         if(var2 == 2131886354) {
            this.startActivityForResult(new Intent(this, SignInActivity.class), 7);
            this.overridePendingTransition(2131034132, 2131034138);
            return;
         }

         if(var2 == 2131886738) {
            GAHelper.sendGoogleAnalyticsEvent(this, this.getString(2131427466), this.getString(2131427586), (String)null);
            this.getNewToken();
            return;
         }

         if(var2 == 2131886732) {
            ((TextView)View.inflate(this, 2130968669, (ViewGroup)null).findViewById(2131886421)).setText(2131427803);
            AlertDialog.Builder var8 = new AlertDialog.Builder(this);
            var8.setTitle(2131427804);
            var8.setMessage(2131427803);
            var8.setPositiveButton(2131427801, new OnClickListener() {
               public void onClick(DialogInterface var1, int var2) {
                  SettingsActivity.this.getNewToken();
               }
            });
            var8.setNegativeButton(2131427459, (OnClickListener)null);
            DialogHelper.showDialog(var8);
            return;
         }

         if(var2 == 2131886729) {
            final String[] var5 = this.getResources().getStringArray(2131820544);
            long var6 = PasscodeManager.getInstance().getValidDuration(this);
            DialogHelper.createSingleChoiceDialog(this, 2131427437, var5, ArrayUtils.indexOf(this.durations, var6), new OnItemClickListener() {
               public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
                  SettingsActivity.this.txtpasscodeValidDuration.setText(var5[var3]);
                  PasscodeManager.getInstance().setValidDuration(SettingsActivity.this, SettingsActivity.this.durations[var3]);
               }
            }).show();
            return;
         }

         if(var2 == 2131886731) {
            Intent var3 = new Intent(this, PasscodeSettingActivity.class);
            var3.putExtra("require_pin", true);
            this.startActivity(var3);
            return;
         }

         if(var2 == 2131886720) {
            HtmlDisplayerActivity.launch(this, this.getString(2131427611), "https://www.goodrx.com/mobile-api/v3/static-content/faq", false);
            return;
         }

         if(var2 == 2131886721) {
            AboutActivity.launch(this);
            return;
         }

         if(var2 == 2131886722) {
            HtmlDisplayerActivity.launch(this, this.getString(2131427767), "https://www.goodrx.com/mobile-api/v3/static-content/privacy", false);
            return;
         }

         if(var2 == 2131886723) {
            HtmlDisplayerActivity.launch(this, this.getString(2131427918), "https://www.goodrx.com/mobile-api/v3/static-content/terms", false);
            return;
         }
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427867);
      this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
      this.setContentView(2130968641);
      ButterKnife.bind(this);
      this.setEmail(AccountInfoUtils.getEmail(this));
      SettingItemWithSwitch var2 = (SettingItemWithSwitch)this.findViewById(2131886724);
      SettingItemWithSwitch var3 = (SettingItemWithSwitch)this.findViewById(2131886725);
      SettingItemWithSwitch var4 = (SettingItemWithSwitch)this.findViewById(2131886726);
      var2.setChecked(MyRxUtils.isNotificationEnabled(this));
      var3.setChecked(MyRxUtils.isPriceAlertEnabled(this));
      var4.setChecked(MyRxUtils.isSavingsAlertEnabled(this));
      var2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
         public void onCheckedChanged(CompoundButton var1, boolean var2) {
            MyRxUtils.setNotificationEnabled(SettingsActivity.this, var2);
         }
      });
      var3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
         public void onCheckedChanged(CompoundButton var1, boolean var2) {
            MyRxUtils.setPriceAlertEnabled(SettingsActivity.this, var2);
         }
      });
      var4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
         public void onCheckedChanged(CompoundButton var1, boolean var2) {
            MyRxUtils.setSavingsAlertEnabled(SettingsActivity.this, var2);
         }
      });
      this.updatePasscodeUI(PasscodeManager.getInstance().isPassCodeFeatureEnabled(this));
      this.scPasscode.setOnCheckedChangeListener(new OnCheckedChangeListener() {
         public void onCheckedChanged(CompoundButton var1, boolean var2) {
            if(var2) {
               if(VERSION.SDK_INT >= 23) {
                  if(((KeyguardManager)SettingsActivity.this.getSystemService("keyguard")).isKeyguardSecure()) {
                     PasscodeManager.getInstance().setPassCodeFeatureEnabled(SettingsActivity.this, true);
                     PasscodeManager.getInstance().setPasscode(SettingsActivity.this, (List)null);
                     AlertDialog.Builder var5 = new AlertDialog.Builder(SettingsActivity.this);
                     var5.setMessage(2131427719);
                     var5.setPositiveButton(2131427709, (OnClickListener)null);
                     var5.show();
                  } else {
                     Intent var4 = new Intent(SettingsActivity.this, PasscodeSettingActivity.class);
                     SettingsActivity.this.startActivityForResult(var4, 18);
                  }
               } else {
                  Intent var3 = new Intent(SettingsActivity.this, PasscodeSettingActivity.class);
                  SettingsActivity.this.startActivityForResult(var3, 18);
               }
            }

            PasscodeManager.getInstance().setPassCodeFeatureEnabled(SettingsActivity.this, var2);
            SettingsActivity.this.updatePasscodeUI(var2);
         }
      });
      long var5 = PasscodeManager.getInstance().getValidDuration(this);
      int var7 = Math.max(ArrayUtils.indexOf(this.durations, var5), 0);
      this.txtpasscodeValidDuration.setText(this.getResources().getStringArray(2131820544)[var7]);
      ((TextView)this.findViewById(2131886719)).setText(String.format(this.getString(2131428009), new Object[]{"5.0.4"}));
      DateTime var8 = new DateTime(DateTimeZone.getDefault());
      TextView var9 = (TextView)this.findViewById(2131886718);
      String var10 = this.getString(2131427495);
      Object[] var11 = new Object[]{Integer.valueOf(var8.getYear())};
      var9.setText(String.format(var10, var11));
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131951619, var1);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 2131886788) {
         this.onBackPressed();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   public void setEmail(String var1) {
      if(var1 != null) {
         this.viewNotLogin.setVisibility(8);
         this.viewAccountInfo.setVisibility(0);
         this.txtEmail.setText(var1);
      } else {
         this.viewNotLogin.setVisibility(0);
         this.viewAccountInfo.setVisibility(8);
      }
   }
}
