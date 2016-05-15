package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.activity.ImageDetailActivity;
import com.goodrx.adapter.ImagesListAdapter;
import com.goodrx.model.ImageResult;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;

public class ImagesActivity extends BaseActivityWithPasscode {
   private ImagesListAdapter adapter;
   private int currentPage;
   private String dosageSlug;
   private String drugSlug;
   private View emptyView;
   private View footerView;
   private String formSlug;
   private ListView listView;

   // $FF: synthetic method
   static int access$304(ImagesActivity var0) {
      int var1 = 1 + var0.currentPage;
      var0.currentPage = var1;
      return var1;
   }

   public static void launch(Activity var0, String var1, String var2, String var3) {
      Intent var4 = new Intent(var0, ImagesActivity.class);
      var4.putExtra("slug", var1);
      var4.putExtra("form", var2);
      var4.putExtra("dosage", var3);
      var0.startActivity(var4);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public void getImage(String var1, String var2, String var3, Integer var4) {
      final MyProgressBar var5 = (MyProgressBar)this.findViewById(2131886399);
      var5.show();
      GoodRxAPI.getInstance().getImageRaw(this, var1, var2, var3, var4, new OnRequestFinishListener() {
         public void onFailure(int var1, String var2) {
            super.onFailure(var1, var2);
            var5.dismiss();
            ImagesActivity.this.emptyView.setVisibility(0);
            ImagesActivity.this.listView.setVisibility(8);
         }

         public void onSuccess(String var1) {
            var5.dismiss();
            JsonObject var2 = (new JsonParser()).parse(var1).getAsJsonObject();
            Gson var3 = new Gson();
            JsonArray var4 = var2.getAsJsonArray("image_results");
            Object var5x;
            if(!(var3 instanceof Gson)) {
               var5x = var3.fromJson((JsonElement)var4, (Class)ImageResult[].class);
            } else {
               var5x = GsonInstrumentation.fromJson((Gson)var3, (JsonElement)var4, (Class)ImageResult[].class);
            }

            ImageResult[] var6 = (ImageResult[])var5x;
            ImagesActivity.this.adapter.append(var6);
            int var7 = var2.getAsJsonObject("pager").getAsJsonPrimitive("page_count").getAsInt();
            ImagesActivity.this.listView.removeFooterView(ImagesActivity.this.footerView);
            if(ImagesActivity.this.currentPage < var7) {
               ImagesActivity.this.listView.addFooterView(ImagesActivity.this.footerView);
            }

         }
      });
   }

   public void initData() {
      super.initData();
      this.getImage(this.drugSlug, this.formSlug, this.dosageSlug, (Integer)null);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427840);
      this.getSupportActionBar().setTitle(2131427620);
      this.setContentView(2130968619);
      Intent var2 = this.getIntent();
      this.drugSlug = var2.getStringExtra("slug");
      this.formSlug = var2.getStringExtra("form");
      this.dosageSlug = var2.getStringExtra("dosage");
      String var3 = var2.getAction();
      Uri var4 = var2.getData();
      if("android.intent.action.VIEW".equals(var3) && var4 != null) {
         this.drugSlug = (String)var4.getPathSegments().get(0);
         this.shouldOverrideBackAnimation(false);
      }

      this.currentPage = 1;
      this.footerView = View.inflate(this, 2130968699, (ViewGroup)null);
      this.footerView.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            ImagesActivity.this.getImage(ImagesActivity.this.drugSlug, ImagesActivity.this.formSlug, ImagesActivity.this.dosageSlug, Integer.valueOf(ImagesActivity.access$304(ImagesActivity.this)));
         }
      });
      this.emptyView = this.findViewById(2131886295);
      this.listView = (ListView)this.findViewById(2131886294);
      this.listView.addFooterView(this.footerView);
      this.adapter = new ImagesListAdapter(this);
      this.listView.setAdapter(this.adapter);
      this.listView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            ImageResult var6 = (ImageResult)ImagesActivity.this.adapter.getItem(var3);
            ImageDetailActivity.launch(ImagesActivity.this, var6);
         }
      });
      this.initData();
   }
}
