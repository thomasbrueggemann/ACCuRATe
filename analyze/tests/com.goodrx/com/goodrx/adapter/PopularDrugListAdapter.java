package com.goodrx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.PopularDrug;

public class PopularDrugListAdapter extends MyBaseAdapter<PopularDrug> {
   public PopularDrugListAdapter(Context var1) {
      super(var1);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      PopularDrugListAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968735, var3, false);
         var4 = new PopularDrugListAdapter.ViewHolder();
         var4.txtNumber = (TextView)var2.findViewById(2131886598);
         var4.txtName = (TextView)var2.findViewById(2131886599);
         var2.setTag(var4);
      } else {
         var4 = (PopularDrugListAdapter.ViewHolder)var2.getTag();
      }

      var4.txtNumber.setText(String.valueOf(var1 + 1));
      var4.txtName.setText(((PopularDrug[])this.dataArray)[var1].getDisplay());
      return var2;
   }

   private static class ViewHolder {
      TextView txtName;
      TextView txtNumber;

      private ViewHolder() {
      }

      // $FF: synthetic method
      ViewHolder(Object var1) {
         this();
      }
   }
}
