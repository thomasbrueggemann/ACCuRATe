package com.goodrx.utils.recyclerview;

public interface ItemTouchHelperAdapter {
   void onDrop(int var1, int var2);

   void onItemDismiss(int var1);

   boolean onItemMove(int var1, int var2);
}
