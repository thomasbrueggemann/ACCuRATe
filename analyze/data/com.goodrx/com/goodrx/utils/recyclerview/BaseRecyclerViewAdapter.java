package com.goodrx.utils.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.goodrx.utils.recyclerview.BaseViewHolder;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
   protected Context mContext;
   protected T[] mDataArray;
   protected LayoutInflater mInflater;

   public BaseRecyclerViewAdapter(Context var1) {
      this(var1, (Object[])null);
   }

   public BaseRecyclerViewAdapter(Context var1, T[] var2) {
      this.mDataArray = var2;
      this.mContext = var1;
      this.mInflater = LayoutInflater.from(var1);
   }

   public int getItemCount() {
      return this.mDataArray.length;
   }

   public void onBindViewHolder(BaseViewHolder var1, int var2) {
      var1.onBind(var2);
   }

   public void onItemClickedListener(int var1, T var2, View var3) {
   }

   public void updateData(T[] var1) {
      this.mDataArray = var1;
      this.notifyDataSetChanged();
   }
}
