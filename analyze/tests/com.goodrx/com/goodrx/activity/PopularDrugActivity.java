package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.activity.configure.PrescriptionConfigureActivity;
import com.goodrx.adapter.PopularDrugListAdapter;
import com.goodrx.model.PopularDrug;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;

public class PopularDrugActivity extends BaseActivityWithPasscode {
   private PopularDrugListAdapter adapter;

   private void getPopularDrugs() {
      final MyProgressBar var1 = (MyProgressBar)this.findViewById(2131886399);
      var1.show();
      GoodRxAPI.getInstance().getPopularDrugs(this, new OnRequestFinishListener() {
         public void onSuccess(PopularDrug[] var1x) {
            PopularDrugActivity.this.adapter.updateData(var1x);
            var1.dismiss();
         }
      });
   }

   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, PopularDrugActivity.class));
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public void initData() {
      super.initData();
      this.getPopularDrugs();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427853);
      this.setContentView(2130968630);
      this.setSupportActionBar((Toolbar)this.findViewById(2131886238));
      this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      this.adapter = new PopularDrugListAdapter(this);
      ListView var2 = (ListView)this.findViewById(2131886318);
      var2.setAdapter(this.adapter);
      var2.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            PopularDrug var6 = (PopularDrug)PopularDrugActivity.this.adapter.getItem(var3);
            PrescriptionConfigureActivity.launch(PopularDrugActivity.this, var6.getSlug(), false);
         }
      });
      this.initData();
   }
}
