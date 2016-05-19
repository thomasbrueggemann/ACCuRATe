package com.goodrx.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.goodrx.activity.ConditionActivity;
import com.goodrx.activity.PopularDrugActivity;
import com.goodrx.activity.pillid.PillIdActivity;
import com.goodrx.model.RecentSearch;
import com.goodrx.utils.HistoryRecordOperator;
import com.goodrx.utils.Utils;
import com.goodrx.utils.recyclerview.BaseRecyclerViewAdapter;
import com.goodrx.utils.recyclerview.BaseViewHolder;
import com.goodrx.utils.recyclerview.ItemTouchHelperAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class RecentSearchListAdapter extends BaseRecyclerViewAdapter<RecentSearch> implements ItemTouchHelperAdapter {
   public static final int LIST_ITEM_FOOTER = 2;
   public static final int LIST_ITEM_HEADER = 1;
   public static final int LIST_ITEM_NORMAL;
   protected List<RecentSearch> mRecentList;
   protected View mRootView;

   public RecentSearchListAdapter(Context var1, View var2) {
      super(var1);
      this.mRecentList = HistoryRecordOperator.getAll(var1);
      this.mRootView = var2;
   }

   public RecentSearch getItem(int var1) {
      return var1 >= 0 && var1 <= -1 + this.getItemCount()?(RecentSearch)this.mRecentList.get(var1):null;
   }

   public int getItemCount() {
      return this.mRecentList.size() == 0?1:2 + this.mRecentList.size();
   }

   public int getItemViewType(int var1) {
      if(this.getItemCount() != 1) {
         if(var1 == 0) {
            return 1;
         }

         if(var1 != -1 + this.getItemCount()) {
            return 0;
         }
      }

      return 2;
   }

   public List<RecentSearch> getRecentList() {
      return this.mRecentList;
   }

   public BaseViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return (BaseViewHolder)(var2 == 1?new RecentSearchListAdapter.HeaderViewHolder(this.mInflater.inflate(2130968710, var1, false)):(var2 == 2?new RecentSearchListAdapter.FooterViewHolder(this.mInflater.inflate(2130968697, var1, false)):new RecentSearchListAdapter.ContentViewHolder(this.mInflater.inflate(2130968741, var1, false))));
   }

   public void onDrop(int var1, int var2) {
   }

   public void onItemDismiss(final int var1) {
      int var2 = var1 - 1;
      View var3 = this.mRootView;
      String var4 = this.mContext.getString(2131427808);
      Object[] var5 = new Object[]{((RecentSearch)this.mRecentList.get(var2)).getSearchDisplay()};
      Snackbar var6 = Utils.makeSnackBar(var3, String.format(var4, var5));
      var6.setAction(2131427999, new OnClickListener() {
         public void onClick(View var1x) {
            RecentSearchListAdapter.this.mRecentList = HistoryRecordOperator.getAll(RecentSearchListAdapter.this.mContext);
            if(RecentSearchListAdapter.this.mRecentList.size() == 1) {
               RecentSearchListAdapter.this.notifyItemRangeInserted(0, 2);
            } else {
               RecentSearchListAdapter.this.notifyItemInserted(var1);
            }
         }
      });
      var6.setCallback(new Snackbar.Callback() {
         public void onDismissed(Snackbar var1, int var2) {
            if(var2 != 1 && var2 != 3) {
               HistoryRecordOperator.save(RecentSearchListAdapter.this.mRecentList, RecentSearchListAdapter.this.mContext);
            }

            super.onDismissed(var1, var2);
         }
      });
      var6.show();
      this.mRecentList.remove(var2);
      if(this.mRecentList.size() > 0) {
         this.notifyItemRemoved(var1);
      } else {
         this.notifyItemRangeRemoved(0, 2);
      }
   }

   public boolean onItemMove(int var1, int var2) {
      return false;
   }

   public void remove(int var1) {
      if(var1 >= 0 && var1 <= -1 + this.getItemCount()) {
         this.mRecentList.remove(var1);
         HistoryRecordOperator.save(this.mRecentList, this.mContext);
         this.notifyDataSetChanged();
      }
   }

   public void updateDateSet(List<RecentSearch> var1) {
      this.mRecentList = var1;
      this.notifyDataSetChanged();
   }

   class ContentViewHolder extends BaseViewHolder implements OnClickListener {
      TextView txtName;

      public ContentViewHolder(View var2) {
         super(var2);
         var2.setOnClickListener(this);
      }

      protected void onBind(int var1) {
         int var2 = var1 - 1;
         this.txtName.setText(((RecentSearch)RecentSearchListAdapter.this.mRecentList.get(var2)).getDisplay());
      }

      public void onClick(View var1) {
         int var2 = -1 + this.getAdapterPosition();
         ((RecentSearch)RecentSearchListAdapter.this.mRecentList.get(var2)).onClick((Activity)RecentSearchListAdapter.this.mContext);
      }
   }

   class FooterViewHolder extends BaseViewHolder implements OnClickListener {
      View btnCondition;
      View btnPillId;
      View btnPopularDrug;

      public FooterViewHolder(View var2) {
         super(var2);
         this.btnPopularDrug.setOnClickListener(this);
         this.btnCondition.setOnClickListener(this);
         this.btnPillId.setOnClickListener(this);
      }

      protected void onBind(int var1) {
      }

      public void onClick(View var1) {
         int var2 = var1.getId();
         Activity var3 = (Activity)RecentSearchListAdapter.this.mContext;
         if(var2 == 2131886504) {
            PopularDrugActivity.launch(var3);
         } else {
            if(var2 == 2131886505) {
               ConditionActivity.launch(var3);
               return;
            }

            if(var2 == 2131886506) {
               PillIdActivity.launch(var3, (String)null);
               return;
            }
         }

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
