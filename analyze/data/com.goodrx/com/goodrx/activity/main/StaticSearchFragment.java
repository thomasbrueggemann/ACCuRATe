package com.goodrx.activity.main;

import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import com.goodrx.activity.main.SearchResultFragment;
import com.goodrx.widget.MySearchView.MySearchView;
import com.goodrx.widget.MySearchView.OnCollapseListener;
import com.goodrx.widget.MySearchView.OnSearchListener;

public class StaticSearchFragment extends SearchResultFragment {
   public static StaticSearchFragment newInstance() {
      return new StaticSearchFragment();
   }

   public void onPrepareOptionsMenu(Menu var1) {
      MenuItem var2 = var1.findItem(2131886786);
      MySearchView var3 = (MySearchView)MenuItemCompat.getActionView(var2);
      var3.setDelay(300);
      var3.setQueryHint(this.getResources().getString(2131427878));
      var2.expandActionView();
      var3.setOnCollapseListener(new OnCollapseListener() {
         public void onCollapse() {
            if(StaticSearchFragment.this.isAdded()) {
               StaticSearchFragment.this.getActivity().onBackPressed();
               StaticSearchFragment.this.getActivity().overridePendingTransition(2131034136, 2131034136);
            }
         }
      });
      var3.setOnSearchListener(new OnSearchListener() {
         public void onSearch(String var1) {
            StaticSearchFragment.this.setSearchContent(var1);
         }
      });
   }
}
