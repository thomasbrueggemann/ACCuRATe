package com.goodrx.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.goodrx.model.News;
import com.goodrx.utils.recyclerview.BaseRecyclerViewAdapter;
import com.goodrx.utils.recyclerview.BaseViewHolder;

public class NewsListAdapter extends BaseRecyclerViewAdapter<News> {
   public NewsListAdapter(Context var1, News[] var2) {
      super(var1, var2);
   }

   public BaseViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new NewsListAdapter.NewsViewHolder(this.mInflater.inflate(2130968733, var1, false));
   }

   class NewsViewHolder extends BaseViewHolder implements OnClickListener {
      TextView txtSubtitle;
      TextView txtTitle;

      public NewsViewHolder(View var2) {
         super(var2);
         var2.setOnClickListener(this);
      }

      protected void onBind(int var1) {
         News var2 = ((News[])NewsListAdapter.this.mDataArray)[var1];
         this.txtTitle.setText(var2.getTitle());
         this.txtSubtitle.setText(Html.fromHtml(var2.getContentSnippet()));
         if(var2.isSelected()) {
            this.itemView.setBackgroundColor(ContextCompat.getColor(NewsListAdapter.this.mContext, 2131755162));
         } else {
            TypedValue var3 = new TypedValue();
            NewsListAdapter.this.mContext.getTheme().resolveAttribute(16843534, var3, true);
            this.itemView.setBackgroundResource(var3.resourceId);
         }
      }

      public void onClick(View var1) {
         int var2 = this.getAdapterPosition();
         NewsListAdapter.this.onItemClickedListener(var2, ((News[])NewsListAdapter.this.mDataArray)[var2], var1);
      }
   }
}
