package com.goodrx.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.ConditionClass;

public class ConditionClassAdapter extends MyBaseAdapter<ConditionClass> {
   public ConditionClassAdapter(Context var1, ConditionClass[] var2) {
      super(var1, var2);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      ConditionClassAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968719, var3, false);
         var4 = new ConditionClassAdapter.ViewHolder(var2);
         var2.setTag(var4);
      } else {
         var4 = (ConditionClassAdapter.ViewHolder)var2.getTag();
      }

      var4.txtName.setText(((ConditionClass[])this.dataArray)[var1].getDisplay());
      int var5 = ((ConditionClass[])this.dataArray)[var1].getCount();
      TextView var6 = var4.txtCount;
      Resources var7 = this.context.getResources();
      Object[] var8 = new Object[]{Integer.valueOf(var5)};
      var6.setText(var7.getQuantityString(2131361812, var5, var8));
      return var2;
   }

   static class ViewHolder {
      TextView txtCount;
      TextView txtName;

      public ViewHolder(View var1) {
         ButterKnife.bind(this, var1);
      }
   }
}
