package com.goodrx.utils.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
   public BaseViewHolder(View var1) {
      super(var1);
      ButterKnife.bind(this, var1);
   }

   protected abstract void onBind(int var1);
}
