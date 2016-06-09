package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.adapter.SingleChoiceAdapter;
import com.goodrx.model.Pharmacy;
import com.goodrx.model.SingleChoiceItem;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.BaseActivityWithPasscode;

public class PreferredPharmacySelectorActivity extends BaseActivityWithPasscode {
   private ListView lvPharmacy;
   private Pharmacy[] pharmacyList;

   private void getPharmacyList() {
      GoodRxAPI.getInstance().getPharmacyList(this, new OnRequestFinishListener() {
         public void onSuccess(Pharmacy[] var1) {
            PreferredPharmacySelectorActivity.this.pharmacyList = var1;
            SingleChoiceItem[] var3 = new SingleChoiceItem[1 + var1.length];
            var3[0] = new SingleChoiceItem("None");

            for(int var4 = 0; var4 < var1.length; ++var4) {
               var3[var4 + 1] = new SingleChoiceItem(var1[var4].getName());
            }

            SingleChoiceAdapter var5 = new SingleChoiceAdapter(PreferredPharmacySelectorActivity.this, var3, 0);
            PreferredPharmacySelectorActivity.this.lvPharmacy.setAdapter(var5);
         }
      });
   }

   public static void launch(Activity var0, String var1) {
      Intent var2 = new Intent(var0, PreferredPharmacySelectorActivity.class);
      var2.putExtra("selected_pharmacy", var1);
      var0.startActivity(var2);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427854);
      this.setContentView(2130968631);
      this.lvPharmacy = (ListView)this.findViewById(2131886319);
      this.lvPharmacy.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            Utils.showToast(PreferredPharmacySelectorActivity.this, PreferredPharmacySelectorActivity.this.pharmacyList[var3 - 1].getName());
            PreferredPharmacySelectorActivity.this.finish();
         }
      });
      this.getPharmacyList();
   }
}
