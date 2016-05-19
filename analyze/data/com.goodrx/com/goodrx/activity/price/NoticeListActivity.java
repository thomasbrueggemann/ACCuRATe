package com.goodrx.activity.price;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.goodrx.adapter.NoticeListAdapter;
import com.goodrx.model.Notice;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;

public class NoticeListActivity extends BaseActivityWithPasscode {
   public static void launch(Activity var0, Notice[] var1) {
      Intent var2 = new Intent(var0, NoticeListActivity.class);
      Gson var3 = new Gson();
      String var4;
      if(!(var3 instanceof Gson)) {
         var4 = var3.toJson((Object)var1);
      } else {
         var4 = GsonInstrumentation.toJson((Gson)var3, (Object)var1);
      }

      var2.putExtra("notices", var4);
      var0.startActivity(var2);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427849);
      this.setContentView(2130968625);
      this.shouldOverrideBackAnimation(false);
      Gson var2 = new Gson();
      String var3 = this.getIntent().getStringExtra("notices");
      Object var4;
      if(!(var2 instanceof Gson)) {
         var4 = var2.fromJson(var3, Notice[].class);
      } else {
         var4 = GsonInstrumentation.fromJson((Gson)var2, var3, Notice[].class);
      }

      Notice[] var5 = (Notice[])var4;
      RecyclerView var6 = (RecyclerView)this.findViewById(2131886302);
      var6.setAdapter(new NoticeListAdapter(this, var5));
      var6.setLayoutManager(new LinearLayoutManager(this));
   }
}
