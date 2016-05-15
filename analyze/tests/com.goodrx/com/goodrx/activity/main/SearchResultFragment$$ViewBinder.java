package com.goodrx.activity.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.goodrx.activity.main.SearchResultFragment;

public class SearchResultFragment$$ViewBinder<T extends SearchResultFragment> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.rvRecentSearch = (RecyclerView)var1.castView((View)var1.findRequiredView(var3, 2131886240, "field \'rvRecentSearch\'"), 2131886240, "field \'rvRecentSearch\'");
      var2.lvSearchResult = (ListView)var1.castView((View)var1.findRequiredView(var3, 2131886470, "field \'lvSearchResult\'"), 2131886470, "field \'lvSearchResult\'");
      var2.lvPopularDrugs = (ListView)var1.castView((View)var1.findRequiredView(var3, 2131886318, "field \'lvPopularDrugs\'"), 2131886318, "field \'lvPopularDrugs\'");
      var2.noResultOverlay = (View)var1.findRequiredView(var3, 2131886644, "field \'noResultOverlay\'");
   }

   public void unbind(T var1) {
      var1.rvRecentSearch = null;
      var1.lvSearchResult = null;
      var1.lvPopularDrugs = null;
      var1.noResultOverlay = null;
   }
}
