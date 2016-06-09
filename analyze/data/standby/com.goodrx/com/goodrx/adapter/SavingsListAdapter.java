package com.goodrx.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.model.SavingsTip;
import com.goodrx.utils.recyclerview.BaseRecyclerViewAdapter;
import com.goodrx.utils.recyclerview.BaseViewHolder;

public class SavingsListAdapter extends BaseRecyclerViewAdapter<SavingsTip> {
   public SavingsListAdapter(Context var1, SavingsTip[] var2) {
      super(var1, var2);
   }

   public BaseViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new SavingsListAdapter.SavingsTipViewHolder(this.mInflater.inflate(2130968745, var1, false));
   }

   class SavingsTipViewHolder extends BaseViewHolder implements OnClickListener {
      ImageView imgLogo;
      TextView txtDescription;
      TextView txtTitle;

      public SavingsTipViewHolder(View var2) {
         super(var2);
         var2.setOnClickListener(this);
      }

      protected void onBind(int var1) {
         SavingsTip var2 = ((SavingsTip[])SavingsListAdapter.this.mDataArray)[var1];
         this.txtTitle.setText(var2.getTitle());
         this.txtDescription.setText(var2.getShort_description());
         if(var2.isHighlight()) {
            this.itemView.setBackgroundResource(2131755162);
         } else {
            TypedValue var3 = new TypedValue();
            SavingsListAdapter.this.mContext.getTheme().resolveAttribute(16843534, var3, true);
            this.itemView.setBackgroundResource(var3.resourceId);
         }

         this.imgLogo.setImageURI(Uri.parse(var2.getIconFullUrl()));
      }

      public void onClick(View var1) {
         int var2 = this.getAdapterPosition();
         SavingsListAdapter.this.onItemClickedListener(var2, ((SavingsTip[])SavingsListAdapter.this.mDataArray)[var2], var1);
      }
   }
}
