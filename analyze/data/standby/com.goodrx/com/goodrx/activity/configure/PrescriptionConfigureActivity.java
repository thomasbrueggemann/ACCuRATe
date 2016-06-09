package com.goodrx.activity.configure;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import com.goodrx.activity.configure.ConfigureFragment;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.model.EventBusMessage;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PrescriptionConfigureActivity extends BaseActivityWithPasscode {
   private final String CONFIGURE_TAG = "configure";
   private String appIndexTitle = null;
   private String appURL = "android-app://com.goodrx/http/goodrx.com/drug/";
   private GoogleApiClient mClient;
   private String webURL = "http://m.goodrx.com/";

   public static void launch(Activity var0, String var1, boolean var2) {
      launch(var0, var1, var2, (String)null, (String)null, (Integer)null);
   }

   public static void launch(Activity var0, String var1, boolean var2, String var3, String var4, Integer var5) {
      Intent var6 = new Intent(var0, PrescriptionConfigureActivity.class);
      var6.putExtra("slug", var1);
      var6.putExtra("form_slug", var3);
      var6.putExtra("dosage_slug", var4);
      if(var5 != null) {
         var6.putExtra("quantity", String.valueOf(var5));
      }

      var6.putExtra("match_manufacturer", var2);
      var0.startActivity(var6);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public void changeContentFrame(Fragment var1, int var2, String var3) {
      FragmentTransaction var4 = this.getSupportFragmentManager().beginTransaction();
      var4.setTransition(var2);
      var4.replace(2131886271, var1, var3).commitAllowingStateLoss();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427832);
      this.setContentView(2130968632);
      this.getSupportActionBar().setHomeAsUpIndicator(2130837666);
      Intent var2 = this.getIntent();
      String var3 = var2.getStringExtra("slug");
      String var4 = var2.getStringExtra("form_slug");
      String var5 = var2.getStringExtra("dosage_slug");
      String var6 = var2.getStringExtra("quantity");
      boolean var7 = var2.getBooleanExtra("match_manufacturer", false);
      String var8 = var2.getAction();
      Uri var9 = var2.getData();
      if("android.intent.action.VIEW".equals(var8) && var9 != null) {
         var3 = (String)var9.getPathSegments().get(1);
         var4 = var9.getQueryParameter("form");
         var5 = var9.getQueryParameter("dosage");
         var6 = var9.getQueryParameter("quantity");
         this.shouldOverrideBackAnimation(false);
      }

      this.mClient = (new GoogleApiClient.Builder(this)).addApi(AppIndex.API).build();
      this.changeContentFrame(ConfigureFragment.newInstance(var3, var7, var4, var5, var6), 0, "configure");
   }

   @Subscribe
   public void onEvent(EventBusMessage var1) {
      if(var1.getType().equals("app_index_info") && this.appIndexTitle == null) {
         HashMap var2 = (HashMap)var1.getMessageContent();
         this.appURL = this.appURL + (String)var2.get("drug_slug");
         this.webURL = this.webURL + (String)var2.get("drug_slug");
         this.appIndexTitle = (String)var2.get("appindex_title");
         Log.d("goodrx_appindexing", this.appIndexTitle + "->" + this.appURL);
         Action var4 = Action.newAction("http://schema.org/ViewAction", this.appIndexTitle, Uri.parse(this.webURL), Uri.parse(this.appURL));
         AppIndex.AppIndexApi.start(this.mClient, var4);
      }
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 16908332) {
         MainActivity.launchClearTop(this);
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   protected void onStart() {
      EventBus.getDefault().register(this);
      if(!EventBus.getDefault().isRegistered(this)) {
         EventBus.getDefault().register(this);
      }

      if(!this.mClient.isConnected()) {
         this.mClient.connect();
      }

      super.onStart();
   }

   protected void onStop() {
      EventBus.getDefault().unregister(this);

      try {
         Action var2 = Action.newAction("http://schema.org/ViewAction", this.appIndexTitle, Uri.parse(this.webURL), Uri.parse(this.appURL));
         AppIndex.AppIndexApi.end(this.mClient, var2);
      } catch (Exception var3) {
         ;
      }

      this.mClient.disconnect();
      super.onStop();
   }
}
