package com.goodrx.adapter;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.SearchResult;
import java.util.ArrayList;

public class SearchResultListAdapter extends MyBaseAdapter<SearchResult> {
   public String searchContent;

   public SearchResultListAdapter(Context var1) {
      super(var1);
   }

   private SearchResult[] filterDrugs(SearchResult[] var1) {
      ArrayList var2 = new ArrayList();
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         SearchResult var5 = var1[var4];
         if(!var5.isCondition() && !var5.isDrug_class()) {
            var2.add(var5);
         }
      }

      return (SearchResult[])var2.toArray(new SearchResult[var2.size()]);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      SearchResultListAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968746, var3, false);
         var4 = new SearchResultListAdapter.ViewHolder();
         var4.txtName = (TextView)var2.findViewById(2131886567);
         var4.imgNextIndicator = (ImageView)var2.findViewById(2131886625);
         var2.setTag(var4);
      } else {
         var4 = (SearchResultListAdapter.ViewHolder)var2.getTag();
      }

      SearchResult var5 = ((SearchResult[])this.dataArray)[var1];
      var4.txtName.setText(var5.getDisplay());
      if(!var5.isCondition() && !var5.isDrug_class()) {
         var4.imgNextIndicator.setVisibility(8);
         if(this.searchContent != null && var5.getDisplay().toLowerCase().startsWith(this.searchContent)) {
            String var6 = var5.getDisplay().substring(0, this.searchContent.length());
            String var7 = var5.getDisplay().substring(this.searchContent.length());
            var4.txtName.setText(Html.fromHtml(var6 + "<b>" + var7 + "</b>"));
            return var2;
         }
      } else {
         var4.imgNextIndicator.setVisibility(0);
         if(this.searchContent != null) {
            var4.txtName.setText(Html.fromHtml("<b>" + var5.getDisplay() + "</b> <i>(" + this.context.getResources().getString(2131427426) + ")</i>"));
         }
      }

      return var2;
   }

   public void setSearchContent(String var1) {
      this.searchContent = var1.toLowerCase();
   }

   public void updateData(SearchResult[] var1) {
      this.updateData(var1, false);
   }

   public void updateData(SearchResult[] var1, boolean var2) {
      if(var2) {
         var1 = this.filterDrugs(var1);
      }

      this.dataArray = var1;
      this.notifyDataSetChanged();
   }

   private static class ViewHolder {
      ImageView imgNextIndicator;
      TextView txtName;

      private ViewHolder() {
      }

      // $FF: synthetic method
      ViewHolder(Object var1) {
         this();
      }
   }
}
