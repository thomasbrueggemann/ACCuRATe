package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.activity.RxEditActivity;
import com.goodrx.activity.configure.PrescriptionConfigureActivity;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.adapter.ClassDrugAdapter;
import com.goodrx.model.ClassDrug;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;

public class ClassDrugActivity extends BaseActivityWithPasscode {
   private String appIndexingDescription;
   private String appIndexingTitle;
   private String appUrl = "android-app://com.goodrx/http/goodrx.com/class/";
   private String classSlug;
   private ListView listView;
   private GoogleApiClient mClient;
   private TextView txtDescription;
   private String webUrl = "http://m.goodrx.com/class/";

   private Action getViewAction() {
      Thing var1 = (new Thing.Builder()).setName(this.appIndexingTitle).setDescription(this.appIndexingDescription).setUrl(Uri.parse(this.appUrl)).build();
      return (new Action.Builder("http://schema.org/ViewAction")).setObject(var1).setActionStatus("http://schema.org/CompletedActionStatus").build();
   }

   public static void launch(Activity var0, String var1, boolean var2) {
      Intent var3 = new Intent(var0, ClassDrugActivity.class);
      var3.putExtra("class_slug", var1);
      var3.putExtra("rx_flag", var2);
      var0.startActivity(var3);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public void getClassDrugs(final String var1) {
      final MyProgressBar var2 = (MyProgressBar)this.findViewById(2131886399);
      var2.show();
      GoodRxAPI.getInstance().getClassDrugs(this, var1, new OnRequestFinishListener() {
         public void onSuccess(String var1x) {
            JsonObject var2x = (new JsonParser()).parse(var1x).getAsJsonObject();
            String var3 = var2x.getAsJsonPrimitive("description").getAsString();
            String var4 = var2x.getAsJsonPrimitive("display").getAsString();
            ClassDrugActivity.this.txtDescription.setText(var3);
            ClassDrugActivity.this.getSupportActionBar().setTitle(var4);
            Gson var5 = new Gson();
            JsonArray var6 = var2x.getAsJsonArray("drugs");
            Object var7;
            if(!(var5 instanceof Gson)) {
               var7 = var5.fromJson((JsonElement)var6, (Class)ClassDrug[].class);
            } else {
               var7 = GsonInstrumentation.fromJson((Gson)var5, (JsonElement)var6, (Class)ClassDrug[].class);
            }

            ClassDrug[] var8 = (ClassDrug[])var7;
            ClassDrugActivity.this.listView.setAdapter(new ClassDrugAdapter(ClassDrugActivity.this, var8));
            var2.dismiss();
            ClassDrugActivity.this.webUrl = ClassDrugActivity.this.webUrl + var1;
            ClassDrugActivity.this.appUrl = ClassDrugActivity.this.appUrl + var1;
            ClassDrugActivity.this.appIndexingTitle = var4;
            ClassDrugActivity.this.appIndexingDescription = var3;
            AppIndex.AppIndexApi.start(ClassDrugActivity.this.mClient, ClassDrugActivity.this.getViewAction());
         }
      });
   }

   public void initData() {
      super.initData();
      this.getClassDrugs(this.classSlug);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427829);
      this.setContentView(2130968608);
      this.getSupportActionBar().setHomeAsUpIndicator(2130837666);
      this.mClient = (new GoogleApiClient.Builder(this)).addApi(AppIndex.API).build();
      Intent var2 = this.getIntent();
      this.classSlug = var2.getStringExtra("class_slug");
      final boolean var3 = var2.getBooleanExtra("rx_flag", false);
      if("android.intent.action.VIEW".equals(var2.getAction()) && var2.getData() != null) {
         this.classSlug = (String)var2.getData().getPathSegments().get(1);
         this.shouldOverrideBackAnimation(false);
      }

      View var4 = View.inflate(this, 2130968703, (ViewGroup)null);
      this.txtDescription = (TextView)var4.findViewById(2131886521);
      this.listView = (ListView)this.findViewById(2131886257);
      this.listView.addHeaderView(var4, (Object)null, false);
      this.listView.setHeaderDividersEnabled(false);
      this.listView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3x, long var4) {
            ClassDrug var6 = (ClassDrug)ClassDrugActivity.this.listView.getAdapter().getItem(var3x);
            Intent var7;
            if(!var3) {
               var7 = new Intent(ClassDrugActivity.this, PrescriptionConfigureActivity.class);
               var7.putExtra("slug", var6.getSlug());
               var7.putExtra("calling_activity", ClassDrugActivity.class.getName());
            } else {
               var7 = new Intent(ClassDrugActivity.this, RxEditActivity.class);
               var7.putExtra("slug", var6.getSlug());
            }

            ClassDrugActivity.this.startActivity(var7);
            ClassDrugActivity.this.overridePendingTransition(2131034132, 2131034138);
         }
      });
      ((TextView)var4.findViewById(2131886522)).setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            View var2 = View.inflate(ClassDrugActivity.this, 2130968669, (ViewGroup)null);
            ((TextView)var2.findViewById(2131886421)).setText(2131427590);
            AlertDialog.Builder var3 = DialogHelper.dialogWithCustomViewBuilder(ClassDrugActivity.this, 2131427605, var2);
            var3.setPositiveButton(2131427709, (android.content.DialogInterface.OnClickListener)null);
            DialogHelper.showDialog(var3);
         }
      });
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

   protected void onStart() {
      this.mClient.connect();
      super.onStart();
   }

   protected void onStop() {
      try {
         AppIndex.AppIndexApi.end(this.mClient, this.getViewAction());
         this.mClient.disconnect();
      } catch (Exception var2) {
         ;
      }

      super.onStop();
   }
}
