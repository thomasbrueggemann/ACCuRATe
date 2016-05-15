package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.activity.ConditionClassActivity;
import com.goodrx.activity.RxEditActivity;
import com.goodrx.adapter.RecentSearchForAddAdapter;
import com.goodrx.adapter.SearchResultListAdapter;
import com.goodrx.model.SearchResult;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MySearchView.MySearchView;
import com.goodrx.widget.MySearchView.OnCollapseListener;
import com.goodrx.widget.MySearchView.OnSearchListener;

public class AddRxActivity extends BaseActivityWithPasscode {
   private SearchResultListAdapter adapter;
   private ListView lvResult;
   private View noResultOverlay;
   private OnSearchListener onSearchListener;
   private RecentSearchForAddAdapter recentSearchAdapter;
   private RecyclerView rvRecentSearch;
   private View viewAddDescription;

   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, AddRxActivity.class));
   }

   private void search(final String var1) {
      GoodRxAPI.getInstance().search(this, var1, true, new OnRequestFinishListener() {
         public void onSuccess(SearchResult[] var1x) {
            if(var1x != null && var1x.length != 0) {
               AddRxActivity.this.noResultOverlay.setVisibility(8);
            } else {
               AddRxActivity.this.noResultOverlay.setVisibility(0);
            }

            AddRxActivity.this.adapter.setSearchContent(var1);
            AddRxActivity.this.adapter.updateData(var1x);
         }
      });
   }

   private void updateDefaultView() {
      if(this.recentSearchAdapter.getItemCount() > 0) {
         this.rvRecentSearch.setVisibility(0);
         this.viewAddDescription.setVisibility(8);
         this.lvResult.setVisibility(8);
      } else {
         this.rvRecentSearch.setVisibility(8);
         this.viewAddDescription.setVisibility(0);
         this.lvResult.setVisibility(0);
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427860);
      this.setContentView(2130968603);
      this.shouldOverrideBackAnimation(false);
      this.setSupportActionBar((Toolbar)this.findViewById(2131886238));
      this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      this.getSupportActionBar().setHomeAsUpIndicator(2130837662);
      this.viewAddDescription = this.findViewById(2131886239);
      this.noResultOverlay = this.findViewById(2131886644);
      this.lvResult = (ListView)this.findViewById(2131886241);
      this.adapter = new SearchResultListAdapter(this);
      this.lvResult.setAdapter(this.adapter);
      this.lvResult.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            SearchResult var6 = (SearchResult)AddRxActivity.this.adapter.getItem(var3);
            Intent var7;
            if(var6.isCondition()) {
               var7 = new Intent(AddRxActivity.this, ConditionClassActivity.class);
               var7.putExtra("display", var6.getDisplay());
               var7.putExtra("slug", var6.getSlug());
               var7.putExtra("rx_flag", true);
            } else {
               var7 = new Intent(AddRxActivity.this, RxEditActivity.class);
               var7.putExtra("slug", var6.getSlug());
               var7.putExtra("form_slug", var6.getForm_slug());
            }

            AddRxActivity.this.startActivity(var7);
            AddRxActivity.this.overridePendingTransition(2131034132, 2131034138);
         }
      });
      this.onSearchListener = new OnSearchListener() {
         public void onSearch(String var1) {
            if(var1 != null && var1.length() != 0) {
               AddRxActivity.this.viewAddDescription.setVisibility(8);
               AddRxActivity.this.rvRecentSearch.setVisibility(8);
               AddRxActivity.this.lvResult.setVisibility(0);
               AddRxActivity.this.search(var1);
            } else {
               AddRxActivity.this.adapter.updateData(new SearchResult[0]);
               AddRxActivity.this.updateDefaultView();
            }
         }
      };
      this.recentSearchAdapter = new RecentSearchForAddAdapter(this);
      this.rvRecentSearch = (RecyclerView)this.findViewById(2131886240);
      this.rvRecentSearch.setAdapter(this.recentSearchAdapter);
      this.rvRecentSearch.setLayoutManager(new LinearLayoutManager(this));
      this.updateDefaultView();
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131951616, var1);
      MenuItem var2 = var1.findItem(2131886784);
      MySearchView var3 = (MySearchView)MenuItemCompat.getActionView(var2);
      var3.setQueryHint(this.getResources().getString(2131427409));
      var3.setDelay(300);
      var3.requestFocus();
      var3.setOnSearchListener(this.onSearchListener);
      var3.setOnCollapseListener(new OnCollapseListener() {
         public void onCollapse() {
            super.onCollapse();
            AddRxActivity.this.finish();
         }
      });
      var2.expandActionView();
      return true;
   }
}
