package com.goodrx.utils.recyclerview;

import android.graphics.Canvas;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.goodrx.utils.recyclerview.ItemTouchHelperAdapter;
import com.goodrx.utils.recyclerview.ItemTouchHelperViewHolder;

public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {
   public static final float ALPHA_FULL = 1.0F;
   private Integer mFrom = null;
   private boolean mIsLongPressDragEnabled;
   private boolean mIsSwipeEnabled;
   private final ItemTouchHelperAdapter mItemTouchHelperAdapter;
   private Integer mTo = null;

   public ItemTouchHelperCallback(ItemTouchHelperAdapter var1, boolean var2, boolean var3) {
      this.mItemTouchHelperAdapter = var1;
      this.mIsLongPressDragEnabled = var2;
      this.mIsSwipeEnabled = var3;
   }

   public void clearView(RecyclerView var1, RecyclerView.ViewHolder var2) {
      super.clearView(var1, var2);
      var2.itemView.setAlpha(1.0F);
      if(var2 instanceof ItemTouchHelperViewHolder) {
         ((ItemTouchHelperViewHolder)var2).onItemClear();
      }

      if(this.mFrom != null && this.mTo != null) {
         this.mItemTouchHelperAdapter.onDrop(this.mFrom.intValue(), this.mTo.intValue());
      }

      this.mFrom = null;
      this.mTo = null;
   }

   public int getMovementFlags(RecyclerView var1, RecyclerView.ViewHolder var2) {
      return var2.getItemViewType() != 0?0:(var1.getLayoutManager() instanceof GridLayoutManager?makeMovementFlags(15, 0):makeMovementFlags(3, 48));
   }

   public boolean isItemViewSwipeEnabled() {
      return this.mIsSwipeEnabled;
   }

   public boolean isLongPressDragEnabled() {
      return this.mIsLongPressDragEnabled;
   }

   public void onChildDraw(Canvas var1, RecyclerView var2, RecyclerView.ViewHolder var3, float var4, float var5, int var6, boolean var7) {
      if(var6 == 1) {
         float var8 = 1.0F - Math.abs(var4) / (float)var3.itemView.getWidth();
         var3.itemView.setAlpha(var8);
         var3.itemView.setTranslationX(var4);
      } else {
         super.onChildDraw(var1, var2, var3, var4, var5, var6, var7);
      }
   }

   public boolean onMove(RecyclerView var1, RecyclerView.ViewHolder var2, RecyclerView.ViewHolder var3) {
      if(var2.getItemViewType() != var3.getItemViewType()) {
         return false;
      } else {
         if(this.mFrom == null) {
            this.mFrom = Integer.valueOf(var2.getAdapterPosition());
         }

         this.mTo = Integer.valueOf(var3.getAdapterPosition());
         this.mItemTouchHelperAdapter.onItemMove(var2.getAdapterPosition(), var3.getAdapterPosition());
         return true;
      }
   }

   public void onSelectedChanged(RecyclerView.ViewHolder var1, int var2) {
      if(var2 != 0 && var1 instanceof ItemTouchHelperViewHolder) {
         ((ItemTouchHelperViewHolder)var1).onItemSelected();
      }

      super.onSelectedChanged(var1, var2);
   }

   public void onSwiped(RecyclerView.ViewHolder var1, int var2) {
      this.mItemTouchHelperAdapter.onItemDismiss(var1.getAdapterPosition());
   }
}
