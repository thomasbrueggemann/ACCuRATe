package com.goodrx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.ImprintResult;

public class ImprintAdapter extends MyBaseAdapter<ImprintResult> {
   public ImprintAdapter(Context var1) {
      super(var1);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      ImprintAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968728, var3, false);
         var4 = new ImprintAdapter.ViewHolder();
         var4.txtImprint = (TextView)var2.findViewById(2131886581);
         var2.setTag(var4);
      } else {
         var4 = (ImprintAdapter.ViewHolder)var2.getTag();
      }

      var4.txtImprint.setText(((ImprintResult[])this.dataArray)[var1].getDisplay());
      return var2;
   }

   private static class ViewHolder {
      TextView txtImprint;

      private ViewHolder() {
      }

      // $FF: synthetic method
      ViewHolder(Object var1) {
         this();
      }
   }
}
