package com.goodrx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.SingleChoiceItem;

public class SingleChoiceAdapter extends MyBaseAdapter<SingleChoiceItem> {
   private int selectedIndex;

   public SingleChoiceAdapter(Context var1, SingleChoiceItem[] var2, int var3) {
      super(var1, var2);
      if(var2 != null && var2.length > 0) {
         if(var3 < 0 || var3 > -1 + var2.length) {
            var3 = 0;
         }

         this.selectedIndex = var3;
         var2[var3].setChecked(true);
      }

   }

   public View getView(int var1, View var2, ViewGroup var3) {
      SingleChoiceAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968748, var3, false);
         var4 = new SingleChoiceAdapter.ViewHolder();
         var4.textView = (TextView)var2.findViewById(2131886628);
         var4.imageView = (ImageView)var2.findViewById(2131886629);
         var2.setTag(var4);
      } else {
         var4 = (SingleChoiceAdapter.ViewHolder)var2.getTag();
      }

      var4.textView.setText(((SingleChoiceItem[])this.dataArray)[var1].getName());
      if(((SingleChoiceItem[])this.dataArray)[var1].isChecked()) {
         var4.imageView.setVisibility(0);
         return var2;
      } else {
         var4.imageView.setVisibility(4);
         return var2;
      }
   }

   public void setSelectedIndex(int var1) {
      if(var1 >= 0 && var1 <= -1 + ((SingleChoiceItem[])this.dataArray).length && var1 != this.selectedIndex) {
         ((SingleChoiceItem[])this.dataArray)[this.selectedIndex].setChecked(false);
         ((SingleChoiceItem[])this.dataArray)[var1].setChecked(true);
         this.selectedIndex = var1;
         this.notifyDataSetChanged();
      }
   }

   private static class ViewHolder {
      private ImageView imageView;
      private TextView textView;

      private ViewHolder() {
      }

      // $FF: synthetic method
      ViewHolder(Object var1) {
         this();
      }
   }
}
