package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.activity.ClassDrugActivity;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.adapter.ConditionClassAdapter;
import com.goodrx.model.ConditionClass;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import org.jsoup.Jsoup;

public class ConditionClassActivity extends BaseActivityWithPasscode {
   private String appIndexTitle = "";
   private String appUrl = "android-app://com.goodrx/http/goodrx.com/condition/";
   private String conditionSlug;
   private ListView listView;
   private GoogleApiClient mClient;
   private TextView txtDescription;
   private String webUrl = "http://m.goodrx.com/";

   public static void launch(Activity var0, String var1) {
      Intent var2 = new Intent(var0, ConditionClassActivity.class);
      var2.putExtra("slug", var1);
      var0.startActivity(var2);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public void getConditionClass(final String var1) {
      final MyProgressBar var2 = (MyProgressBar)this.findViewById(2131886399);
      var2.show();
      GoodRxAPI.getInstance().getConditionClass(this, var1, new OnRequestFinishListener() {
         public void onSuccess(String var1x) {
            JsonObject var2x = (new JsonParser()).parse(var1x).getAsJsonObject();
            String var3 = var2x.getAsJsonPrimitive("display").getAsString();
            ConditionClassActivity.this.getSupportActionBar().setTitle(var3);
            String var4 = var2x.getAsJsonPrimitive("description").getAsString();
            if(var4.contains("\n")) {
               var4 = var4.substring(0, var4.indexOf("\n"));
            }

            ConditionClassActivity.this.txtDescription.setText(Jsoup.parse(var4).text());
            Gson var5 = new Gson();
            String var6 = var2x.getAsJsonArray("drug_classes").toString();
            Object var7;
            if(!(var5 instanceof Gson)) {
               var7 = var5.fromJson(var6, ConditionClass[].class);
            } else {
               var7 = GsonInstrumentation.fromJson((Gson)var5, var6, ConditionClass[].class);
            }

            ConditionClass[] var8 = (ConditionClass[])var7;
            ConditionClassActivity.this.listView.setAdapter(new ConditionClassAdapter(ConditionClassActivity.this, var8));
            ConditionClassActivity.this.mClient.connect();
            ConditionClassActivity.this.appIndexTitle = var3;
            ConditionClassActivity.this.webUrl = ConditionClassActivity.this.webUrl + var1;
            ConditionClassActivity.this.appUrl = ConditionClassActivity.this.appUrl + var1;
            Action var12 = Action.newAction("http://schema.org/ViewAction", ConditionClassActivity.this.appIndexTitle, Uri.parse(ConditionClassActivity.this.webUrl), Uri.parse(ConditionClassActivity.this.appUrl));
            AppIndex.AppIndexApi.start(ConditionClassActivity.this.mClient, var12);
            var2.dismiss();
         }
      });
   }

   public void initData() {
      super.initData();
      this.getConditionClass(this.conditionSlug);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427830);
      this.setContentView(2130968612);
      this.getSupportActionBar().setHomeAsUpIndicator(2130837666);
      Intent var2 = this.getIntent();
      this.conditionSlug = var2.getStringExtra("slug");
      final boolean var3 = var2.getBooleanExtra("rx_flag", false);
      if("android.intent.action.VIEW".equals(var2.getAction()) && var2.getData() != null) {
         this.conditionSlug = (String)var2.getData().getPathSegments().get(1);
         this.shouldOverrideBackAnimation(false);
      }

      this.listView = (ListView)this.findViewById(2131886266);
      View var4 = View.inflate(this, 2130968704, (ViewGroup)null);
      this.txtDescription = (TextView)var4.findViewById(2131886523);
      this.listView.addHeaderView(var4, (Object)null, false);
      this.listView.setHeaderDividersEnabled(false);
      this.listView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3x, long var4) {
            ConditionClass var6 = (ConditionClass)ConditionClassActivity.this.listView.getAdapter().getItem(var3x);
            ClassDrugActivity.launch(ConditionClassActivity.this, var6.getSlug(), var3);
         }
      });
      this.mClient = (new GoogleApiClient.Builder(this)).addApi(AppIndex.API).build();
      this.initData();
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 16908332) {
         MainActivity.launchClearTop(this);
         this.finish();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   protected void onStop() {
      try {
         Action var2 = Action.newAction("http://schema.org/ViewAction", this.appIndexTitle, Uri.parse(this.webUrl), Uri.parse(this.appUrl));
         AppIndex.AppIndexApi.end(this.mClient, var2);
         this.mClient.disconnect();
      } catch (Exception var3) {
         ;
      }

      super.onStop();
   }
}
