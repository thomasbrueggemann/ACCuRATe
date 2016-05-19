package com.goodrx.adapter;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.goodrx.adapter.MyBaseAdapter;

public class DialogOptionAdapter extends MyBaseAdapter<String> {
   public DialogOptionAdapter(Context var1, String[] var2) {
      super(var1, var2);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      DialogOptionAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968730, var3, false);
         var4 = new DialogOptionAdapter.ViewHolder();
         var4.textView = (TextView)var2.findViewById(2131886583);
         var2.setTag(var4);
      } else {
         var4 = (DialogOptionAdapter.ViewHolder)var2.getTag();
      }

      var4.textView.setText(Html.fromHtml(((String[])this.dataArray)[var1]));
      return var2;
   }

   static class ViewHolder {
      TextView textView;
   }
}
