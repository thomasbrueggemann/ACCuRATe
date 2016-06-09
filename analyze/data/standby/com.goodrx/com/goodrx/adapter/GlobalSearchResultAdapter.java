package com.goodrx.adapter;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.ClassDrug;
import com.goodrx.model.ConditionClass;
import com.goodrx.model.GlobalSearchHeaderItem;
import com.goodrx.model.GlobalSearchableItem;
import com.goodrx.model.ImprintResult;
import com.goodrx.model.MyRx;
import com.goodrx.model.RecentSearch;
import com.goodrx.model.SearchResult;

public class GlobalSearchResultAdapter extends MyBaseAdapter<GlobalSearchableItem> {
   public String searchContent;

   public GlobalSearchResultAdapter(Context var1) {
      super(var1);
   }

   public int getItemViewType(int var1) {
      return ((GlobalSearchableItem[])this.dataArray)[var1].getSearchType().equals(GlobalSearchHeaderItem.class.getName())?(var1 == 0?2:1):0;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      GlobalSearchResultAdapter.ViewHolder var4;
      if(var2 == null) {
         if(this.getItemViewType(var1) == 0) {
            var2 = this.inflater.inflate(2130968721, var3, false);
         } else {
            if(this.getItemViewType(var1) == 2) {
               var2 = this.inflater.inflate(2130968722, var3, false);
            } else {
               var2 = this.inflater.inflate(2130968723, var3, false);
            }

            var2.setEnabled(false);
            var2.setClickable(false);
         }

         var4 = new GlobalSearchResultAdapter.ViewHolder();
         var4.txtDisplay = (TextView)var2.findViewById(2131886567);
         var4.imageView = (ImageView)var2.findViewById(2131886566);
         var2.setTag(var4);
      } else {
         var4 = (GlobalSearchResultAdapter.ViewHolder)var2.getTag();
      }

      String var5 = ((GlobalSearchableItem[])this.dataArray)[var1].getSearchDisplay();
      if(this.searchContent != null && var5.toLowerCase().startsWith(this.searchContent)) {
         String var7 = var5.substring(0, this.searchContent.length());
         String var8 = var5.substring(this.searchContent.length());
         var4.txtDisplay.setText(Html.fromHtml(var7 + "<b>" + var8 + "</b>"));
      } else {
         var4.txtDisplay.setText(var5);
      }

      String var6 = ((GlobalSearchableItem[])this.dataArray)[var1].getSearchType();
      if(var6.equals(MyRx.class.getName())) {
         var4.imageView.setImageResource(2130837710);
      } else {
         if(var6.equals(SearchResult.class.getName())) {
            var4.imageView.setImageResource(2130837752);
            return var2;
         }

         if(var6.equals(ConditionClass.class.getName()) || var6.equals(ClassDrug.class.getName())) {
            var4.imageView.setImageResource(2130837697);
            return var2;
         }

         if(var6.equals(ImprintResult.class.getName())) {
            var4.imageView.setImageResource(2130837717);
            return var2;
         }

         if(var6.equals(RecentSearch.class.getName())) {
            var4.imageView.setImageResource(2130837762);
            return var2;
         }
      }

      return var2;
   }

   public int getViewTypeCount() {
      return 3;
   }

   public void setSearchContent(String var1) {
      this.searchContent = var1;
   }

   static class ViewHolder {
      ImageView imageView;
      TextView txtDisplay;
   }
}
