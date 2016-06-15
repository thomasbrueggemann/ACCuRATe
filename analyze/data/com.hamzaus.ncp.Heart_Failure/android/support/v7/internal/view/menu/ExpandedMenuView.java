package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, OnItemClickListener {
   private int mAnimations;
   private MenuBuilder mMenu;

   public ExpandedMenuView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.setOnItemClickListener(this);
   }

   public int getWindowAnimations() {
      return this.mAnimations;
   }

   public void initialize(MenuBuilder var1) {
      this.mMenu = var1;
   }

   public boolean invokeItem(MenuItemImpl var1) {
      return this.mMenu.performItemAction(var1, 0);
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.setChildrenDrawingCacheEnabled(false);
   }

   public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
      this.invokeItem((MenuItemImpl)this.getAdapter().getItem(var3));
   }
}
