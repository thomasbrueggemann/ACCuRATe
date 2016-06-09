package com.goodrx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.adapter.MyBaseAdapter;

public class ShareDialogListAdapter extends MyBaseAdapter<String> {
   public ShareDialogListAdapter(Context var1) {
      super(var1);
      this.dataArray = new String[2];
      ((String[])this.dataArray)[0] = var1.getString(2131427662);
      ((String[])this.dataArray)[1] = var1.getString(2131427550);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      ShareDialogListAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968747, var3, false);
         var4 = new ShareDialogListAdapter.ViewHolder();
         var4.textView = (TextView)var2.findViewById(2131886627);
         var4.imageView = (ImageView)var2.findViewById(2131886626);
         var2.setTag(var4);
      } else {
         var4 = (ShareDialogListAdapter.ViewHolder)var2.getTag();
      }

      var4.textView.setText(((String[])this.dataArray)[var1]);
      int var5;
      if(var1 == 0) {
         var5 = 2130837768;
      } else {
         var5 = 0;
         if(var1 == 1) {
            var5 = 2130837708;
         }
      }

      var4.imageView.setImageResource(var5);
      return var2;
   }

   private static class ViewHolder {
      ImageView imageView;
      TextView textView;

      private ViewHolder() {
      }

      // $FF: synthetic method
      ViewHolder(Object var1) {
         this();
      }
   }
}
