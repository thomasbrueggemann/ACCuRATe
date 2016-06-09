package com.goodrx.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.goodrx.activity.price.NoticeDetailActivity;
import com.goodrx.model.Notice;
import com.goodrx.utils.Utils;
import com.goodrx.utils.recyclerview.BaseRecyclerViewAdapter;
import com.goodrx.utils.recyclerview.BaseViewHolder;

public class NoticeListAdapter extends BaseRecyclerViewAdapter<Notice> {
   public NoticeListAdapter(Context var1, Notice[] var2) {
      super(var1, var2);
   }

   public BaseViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new NoticeListAdapter.NoticeViewHolder(this.mInflater.inflate(2130968733, var1, false));
   }

   class NoticeViewHolder extends BaseViewHolder implements OnClickListener {
      TextView txtSubtitle;
      TextView txtTitle;

      public NoticeViewHolder(View var2) {
         super(var2);
         var2.setOnClickListener(this);
      }

      protected void onBind(int var1) {
         this.txtTitle.setText(((Notice[])NoticeListAdapter.this.mDataArray)[var1].getTitle());
         this.txtSubtitle.setText(((Notice[])NoticeListAdapter.this.mDataArray)[var1].getShort_description());
      }

      public void onClick(View var1) {
         Notice var2 = ((Notice[])NoticeListAdapter.this.mDataArray)[this.getAdapterPosition()];
         String[] var3 = new String[]{var2.getLong_description()};
         if(!Utils.isValidString(var3)) {
            String[] var4 = new String[]{var2.getLink()};
            if(Utils.isValidString(var4)) {
               Utils.openWebIntent((Activity)NoticeListAdapter.this.mContext, var2.getLink());
               return;
            }
         }

         NoticeDetailActivity.launch((Activity)NoticeListAdapter.this.mContext, var2);
      }
   }
}
