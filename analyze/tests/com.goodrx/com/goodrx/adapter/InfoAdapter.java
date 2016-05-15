package com.goodrx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.goodrx.utils.recyclerview.BaseRecyclerViewAdapter;
import com.goodrx.utils.recyclerview.BaseViewHolder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class InfoAdapter extends BaseRecyclerViewAdapter<String> {
   public static final int LIST_ITEM_HEADER = 1;
   public static final int LIST_ITEM_NORMAL;
   private int mImageCount;
   private int mNewsCount;

   public InfoAdapter(Context var1, String[] var2, int var3, int var4) {
      super(var1, var2);
      this.mNewsCount = var3;
      this.mImageCount = var4;
   }

   private boolean isHeaderShown() {
      return this.mNewsCount + this.mImageCount > 0;
   }

   public int getItemCount() {
      return this.isHeaderShown()?1 + ((String[])this.mDataArray).length:((String[])this.mDataArray).length;
   }

   public int getItemViewType(int var1) {
      boolean var2 = this.isHeaderShown();
      byte var3 = 0;
      if(var2) {
         var3 = 0;
         if(var1 == 0) {
            var3 = 1;
         }
      }

      return var3;
   }

   public BaseViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return (BaseViewHolder)(var2 == 0?new InfoAdapter.InfoViewHolder(this.mInflater.inflate(2130968729, var1, false)):new InfoAdapter.HeadViewHolder(this.mInflater.inflate(2130968707, var1, false)));
   }

   public abstract void onHeaderClicked(int var1);

   class HeadViewHolder extends BaseViewHolder implements OnClickListener {
      TextView txtImageCount;
      TextView txtNewsCount;
      TextView txtTitle;
      View viewImage;
      View viewNews;

      public HeadViewHolder(View var2) {
         super(var2);
         this.viewNews.setOnClickListener(this);
         this.viewImage.setOnClickListener(this);
      }

      protected void onBind(int var1) {
         this.txtImageCount.setText(String.valueOf(InfoAdapter.this.mImageCount));
         this.txtNewsCount.setText(String.valueOf(InfoAdapter.this.mNewsCount));
         if(InfoAdapter.this.mNewsCount == 0) {
            this.viewNews.setVisibility(8);
         }

         if(InfoAdapter.this.mImageCount == 0) {
            this.viewImage.setVisibility(8);
         }

         if(InfoAdapter.this.mNewsCount + InfoAdapter.this.mImageCount != 0 && ((String[])InfoAdapter.this.mDataArray).length != 0) {
            this.txtTitle.setVisibility(0);
         } else {
            this.txtTitle.setVisibility(8);
         }
      }

      public void onClick(View var1) {
         InfoAdapter.this.onHeaderClicked(var1.getId());
      }
   }

   class InfoViewHolder extends BaseViewHolder implements OnClickListener {
      TextView txtTitle;

      public InfoViewHolder(View var2) {
         super(var2);
         var2.setOnClickListener(this);
      }

      public int getIndex(int var1) {
         if(InfoAdapter.this.isHeaderShown()) {
            --var1;
         }

         return var1;
      }

      protected void onBind(int var1) {
         this.txtTitle.setText(((String[])InfoAdapter.this.mDataArray)[this.getIndex(var1)]);
      }

      public void onClick(View var1) {
         int var2 = this.getIndex(this.getAdapterPosition());
         InfoAdapter.this.onItemClickedListener(var2, ((String[])InfoAdapter.this.mDataArray)[var2], var1);
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface ListItemType {
   }
}
