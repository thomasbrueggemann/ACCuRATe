package com.goodrx.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.Condition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ConditionListAdapter extends MyBaseAdapter<Condition> implements SectionIndexer {
   private final int TYPE_HEADER = 1;
   private final int TYPE_NORMAL = 0;
   private HashMap<String, Integer> sectionIndexer;
   private String[] sections;

   public ConditionListAdapter(Context var1) {
      super(var1);
   }

   public int getItemViewType(int var1) {
      return this.sectionIndexer.values().contains(Integer.valueOf(var1))?1:0;
   }

   public int getPositionForSection(int var1) {
      return ((Integer)this.sectionIndexer.get(this.sections[var1])).intValue();
   }

   public int getSectionForPosition(int var1) {
      return 0;
   }

   public Object[] getSections() {
      return this.sections;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      int var4 = this.getItemViewType(var1);
      ConditionListAdapter.ViewHolder var5;
      if(var2 == null) {
         if(var4 == 1) {
            var2 = this.inflater.inflate(2130968718, var3, false);
         } else {
            var2 = this.inflater.inflate(2130968717, var3, false);
         }

         var5 = new ConditionListAdapter.ViewHolder(var2);
         var2.setTag(var5);
      } else {
         var5 = (ConditionListAdapter.ViewHolder)var2.getTag();
      }

      Condition var6 = ((Condition[])this.dataArray)[var1];
      var5.txtName.setText(var6.getDisplay());
      var5.txtCount.setText(String.valueOf(var6.getCount()));
      if(var4 == 1) {
         var5.txtSectorTitle.setText(var6.getDisplay().substring(0, 1).toUpperCase());
      }

      return var2;
   }

   public int getViewTypeCount() {
      return 2;
   }

   public void updateData(Condition[] var1) {
      super.updateData(var1);
      this.sectionIndexer = new HashMap();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         String var5 = var1[var2].getDisplay().substring(0, 1).toUpperCase();
         if(!this.sectionIndexer.containsKey(var5)) {
            this.sectionIndexer.put(var5, Integer.valueOf(var2));
         }
      }

      ArrayList var3 = new ArrayList(this.sectionIndexer.keySet());
      Collections.sort(var3);
      this.sections = new String[var3.size()];
      var3.toArray(this.sections);
   }

   static class ViewHolder {
      TextView txtCount;
      TextView txtName;
      @Nullable
      TextView txtSectorTitle;

      public ViewHolder(View var1) {
         ButterKnife.bind(this, var1);
      }
   }
}
