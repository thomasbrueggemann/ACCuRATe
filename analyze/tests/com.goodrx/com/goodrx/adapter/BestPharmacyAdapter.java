package com.goodrx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.activity.BestPharmacyAddressFormater;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.BestPharmacy;
import com.goodrx.utils.Utils;

public class BestPharmacyAdapter extends MyBaseAdapter<BestPharmacy> {
   public BestPharmacyAdapter(Context var1) {
      super(var1);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      BestPharmacyAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968713, var3, false);
         var4 = new BestPharmacyAdapter.ViewHolder(var2);
         var2.setTag(var4);
      } else {
         var4 = (BestPharmacyAdapter.ViewHolder)var2.getTag();
      }

      BestPharmacy var5 = ((BestPharmacy[])this.dataArray)[var1];
      var4.txtNumber.setText(String.valueOf(var1 + 2));
      var4.txtName.setText(var5.getName());
      var4.txtPrice.setText(Utils.formatPrice(Double.valueOf(var5.getTotal_price())));
      BestPharmacyAddressFormater.format(var4.txtAddress, var5);
      return var2;
   }

   static class ViewHolder {
      TextView txtAddress;
      TextView txtName;
      TextView txtNumber;
      TextView txtPrice;

      public ViewHolder(View var1) {
         ButterKnife.bind(this, var1);
      }
   }
}
