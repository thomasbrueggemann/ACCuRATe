package com.goodrx.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.goodrx.activity.RxEditActivity;
import com.goodrx.model.MyRx;
import com.goodrx.model.RecentSearch;
import com.goodrx.utils.HistoryRecordOperator;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.recyclerview.BaseRecyclerViewAdapter;
import com.goodrx.utils.recyclerview.BaseViewHolder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RecentSearchForAddAdapter extends BaseRecyclerViewAdapter<RecentSearch> {
   public static final int LIST_ITEM_HEADER = 1;
   public static final int LIST_ITEM_NORMAL;
   protected List<RecentSearch> mRecentList;

   public RecentSearchForAddAdapter(Context var1) {
      super(var1);
      this.mRecentList = this.filterOutAddedDrugs(var1, HistoryRecordOperator.getAll(var1));
   }

   private List<RecentSearch> filterOutAddedDrugs(Context var1, List<RecentSearch> var2) {
      HashSet var3 = new HashSet();
      MyRx[] var4 = MyRxUtils.getRx(var1);
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         var3.add(var4[var6].getSlug().getDrug());
      }

      ArrayList var7 = new ArrayList();
      Iterator var8 = var2.iterator();

      while(var8.hasNext()) {
         RecentSearch var9 = (RecentSearch)var8.next();
         if(!var3.contains(var9.getSlug())) {
            var7.add(var9);
         }
      }

      return var7;
   }

   public int getItemCount() {
      return this.mRecentList.size() == 0?0:1 + this.mRecentList.size();
   }

   public int getItemViewType(int var1) {
      return var1 == 0?1:0;
   }

   public BaseViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return (BaseViewHolder)(var2 == 1?new RecentSearchForAddAdapter.HeaderViewHolder(this.mInflater.inflate(2130968700, var1, false)):new RecentSearchForAddAdapter.ContentViewHolder(this.mInflater.inflate(2130968742, var1, false)));
   }

   class ContentViewHolder extends BaseViewHolder implements OnClickListener {
      TextView txtName;

      public ContentViewHolder(View var2) {
         super(var2);
         var2.setOnClickListener(this);
      }

      protected void onBind(int var1) {
         int var2 = var1 - 1;
         this.txtName.setText(((RecentSearch)RecentSearchForAddAdapter.this.mRecentList.get(var2)).getDisplay());
      }

      public void onClick(View var1) {
         Activity var2 = (Activity)RecentSearchForAddAdapter.this.mContext;
         int var3 = -1 + this.getAdapterPosition();
         RecentSearch var4 = (RecentSearch)RecentSearchForAddAdapter.this.mRecentList.get(var3);
         Intent var5 = new Intent(var2, RxEditActivity.class);
         var5.putExtra("slug", var4.getSlug());
         var5.putExtra("form_slug", var4.getFormSlug());
         var2.startActivity(var5);
         var2.overridePendingTransition(2131034132, 2131034138);
      }
   }

   private class HeaderViewHolder extends BaseViewHolder {
      public HeaderViewHolder(View var2) {
         super(var2);
      }

      protected void onBind(int var1) {
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface ListItemType {
   }
}
