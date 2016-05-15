package com.goodrx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class MyBaseAdapter<T> extends BaseAdapter {
   protected Context context;
   protected T[] dataArray;
   protected LayoutInflater inflater;

   public MyBaseAdapter(Context var1) {
      this(var1, (Object[])null);
   }

   public MyBaseAdapter(Context var1, T[] var2) {
      this.context = var1;
      this.dataArray = var2;
      this.inflater = LayoutInflater.from(var1);
   }

   public int getCount() {
      return this.dataArray == null?0:this.dataArray.length;
   }

   public T getItem(int var1) {
      return this.dataArray != null && var1 >= 0 && var1 <= -1 + this.dataArray.length?this.dataArray[var1]:null;
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public abstract View getView(int var1, View var2, ViewGroup var3);

   public void updateData(T[] var1) {
      this.dataArray = var1;
      this.notifyDataSetChanged();
   }
}
