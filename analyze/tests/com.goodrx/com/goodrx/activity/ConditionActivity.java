package com.goodrx.activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.goodrx.activity.ConditionClassActivity;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.adapter.ConditionListAdapter;
import com.goodrx.adapter.SearchResultListAdapter;
import com.goodrx.model.Condition;
import com.goodrx.model.SearchResult;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.goodrx.widget.MySearchView.MySearchView;
import com.goodrx.widget.MySearchView.OnCollapseListener;
import com.goodrx.widget.MySearchView.OnSearchListener;
import java.util.ArrayList;

public class ConditionActivity extends BaseActivityWithPasscode {
   private SearchResultListAdapter adapterConditionSearch;
   private ConditionListAdapter adapterConditions;
   ListView lvConditions;
   View noResultOverlay;
   View searchResultView;

   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, ConditionActivity.class));
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public void endSearch() {
      this.searchResultView.setVisibility(8);
      this.lvConditions.setVisibility(0);
   }

   public void getConditions() {
      final MyProgressBar var1 = (MyProgressBar)this.findViewById(2131886399);
      var1.show();
      GoodRxAPI.getInstance().getConditions(this, new OnRequestFinishListener() {
         public void onSuccess(Condition[] var1x) {
            ConditionActivity.this.adapterConditions.updateData(var1x);
            var1.dismiss();
         }
      });
   }

   public void initData() {
      super.initData();
      this.getConditions();
   }

   void onConditionItemClicked(int var1) {
      ConditionClassActivity.launch(this, ((Condition)this.adapterConditions.getItem(var1)).getSlug());
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427831);
      this.setContentView(2130968611);
      ButterKnife.bind(this);
      this.getSupportActionBar().setHomeAsUpIndicator(2130837666);
      this.adapterConditions = new ConditionListAdapter(this);
      this.lvConditions.setAdapter(this.adapterConditions);
      this.lvConditions.setFastScrollEnabled(true);
      this.adapterConditionSearch = new SearchResultListAdapter(this);
      ((ListView)this.findViewById(2131886265)).setAdapter(this.adapterConditionSearch);
      this.initData();
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131951620, var1);
      SearchManager var2 = (SearchManager)this.getSystemService("search");
      MySearchView var3 = (MySearchView)MenuItemCompat.getActionView(var1.findItem(2131886786));
      var3.setSearchableInfo(var2.getSearchableInfo(this.getComponentName()));
      var3.setQueryHint(this.getResources().getString(2131427876));
      var3.setDelay(300);
      var3.setOnSearchListener(new OnSearchListener() {
         public void onSearch(String var1) {
            if(var1.length() == 0) {
               ConditionActivity.this.endSearch();
            } else {
               ConditionActivity.this.startSearch();
               ConditionActivity.this.search(var1);
            }
         }
      });
      var3.setOnCollapseListener(new OnCollapseListener() {
         public void onCollapse() {
            ConditionActivity.this.endSearch();
         }

         public void onExpand() {
         }
      });
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 16908332) {
         MainActivity.launchClearTop(this);
         this.finish();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   void onSearchResultItemClicked(int var1) {
      ConditionClassActivity.launch(this, ((SearchResult)this.adapterConditionSearch.getItem(var1)).getSlug());
   }

   public void search(String var1) {
      GoodRxAPI.getInstance().search(this, var1, false, new OnRequestFinishListener() {
         public void onSuccess(SearchResult[] var1) {
            ArrayList var2 = new ArrayList();
            int var3 = var1.length;

            for(int var4 = 0; var4 < var3; ++var4) {
               SearchResult var5 = var1[var4];
               if(var5.isCondition()) {
                  var2.add(var5);
               }
            }

            if(var2.size() == 0) {
               ConditionActivity.this.noResultOverlay.setVisibility(0);
            } else {
               ConditionActivity.this.noResultOverlay.setVisibility(8);
               ConditionActivity.this.adapterConditionSearch.updateData((SearchResult[])var2.toArray(new SearchResult[var2.size()]));
            }
         }
      });
   }

   public void startSearch() {
      this.lvConditions.setVisibility(8);
      this.searchResultView.setVisibility(0);
   }
}
