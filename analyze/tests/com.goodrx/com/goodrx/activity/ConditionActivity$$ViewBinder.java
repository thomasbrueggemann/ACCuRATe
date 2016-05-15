package com.goodrx.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import butterknife.ButterKnife;
import com.goodrx.activity.ConditionActivity;

public class ConditionActivity$$ViewBinder<T extends ConditionActivity> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, final T var2, Object var3) {
      View var4 = (View)var1.findRequiredView(var3, 2131886263, "field \'lvConditions\' and method \'onConditionItemClicked\'");
      var2.lvConditions = (ListView)var1.castView(var4, 2131886263, "field \'lvConditions\'");
      ((AdapterView)var4).setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2x, int var3, long var4) {
            var2.onConditionItemClicked(var3);
         }
      });
      var2.searchResultView = (View)var1.findRequiredView(var3, 2131886264, "field \'searchResultView\'");
      var2.noResultOverlay = (View)var1.findRequiredView(var3, 2131886644, "field \'noResultOverlay\'");
      ((AdapterView)((View)var1.findRequiredView(var3, 2131886265, "method \'onSearchResultItemClicked\'"))).setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2x, int var3, long var4) {
            var2.onSearchResultItemClicked(var3);
         }
      });
   }

   public void unbind(T var1) {
      var1.lvConditions = null;
      var1.searchResultView = null;
      var1.noResultOverlay = null;
   }
}
