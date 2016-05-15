package com.goodrx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.ClassDrug;
import com.goodrx.utils.Utils;
import com.goodrx.widget.VolBar;

public class ClassDrugAdapter extends MyBaseAdapter<ClassDrug> {
   private int maxVol = 1;

   public ClassDrugAdapter(Context var1, ClassDrug[] var2) {
      super(var1, var2);
      if(var2.length > 0) {
         this.maxVol = var2[0].getDistribution_volume();
      }

   }

   public View getView(int var1, View var2, ViewGroup var3) {
      ClassDrugAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968716, var3, false);
         var4 = new ClassDrugAdapter.ViewHolder(var2);
         var2.setTag(var4);
      } else {
         var4 = (ClassDrugAdapter.ViewHolder)var2.getTag();
      }

      ClassDrug var5 = ((ClassDrug[])this.dataArray)[var1];
      int var6 = (int)Math.ceil(5.0D * ((double)var5.getDistribution_volume() / (double)this.maxVol));
      var4.volBar.setVol(var6);
      var4.txtDrugName.setText(var5.getDisplay());
      String var7 = var5.getFair_price();
      if(Utils.isNumber(var7)) {
         double var8 = Double.parseDouble(var7);
         var4.txtDrugPrice.setText("$" + (int)var8);
         return var2;
      } else {
         var4.txtDrugPrice.setText(var7);
         return var2;
      }
   }

   static class ViewHolder {
      TextView txtDrugName;
      TextView txtDrugPrice;
      VolBar volBar;

      public ViewHolder(View var1) {
         ButterKnife.bind(this, var1);
      }
   }
}
