package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class PopupMenu implements MenuBuilder.Callback, MenuPresenter.Callback {
   private View mAnchor;
   private Context mContext;
   private PopupMenu.OnDismissListener mDismissListener;
   private MenuBuilder mMenu;
   private PopupMenu.OnMenuItemClickListener mMenuItemClickListener;
   private MenuPopupHelper mPopup;

   public PopupMenu(Context var1, View var2) {
      this.mContext = var1;
      this.mMenu = new MenuBuilder(var1);
      this.mMenu.setCallback(this);
      this.mAnchor = var2;
      this.mPopup = new MenuPopupHelper(var1, this.mMenu, var2);
      this.mPopup.setCallback(this);
   }

   public void dismiss() {
      this.mPopup.dismiss();
   }

   public Menu getMenu() {
      return this.mMenu;
   }

   public MenuInflater getMenuInflater() {
      return new SupportMenuInflater(this.mContext);
   }

   public void inflate(int var1) {
      this.getMenuInflater().inflate(var1, this.mMenu);
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(this.mDismissListener != null) {
         this.mDismissListener.onDismiss(this);
      }

   }

   public void onCloseSubMenu(SubMenuBuilder var1) {
   }

   public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
      return this.mMenuItemClickListener != null?this.mMenuItemClickListener.onMenuItemClick(var2):false;
   }

   public void onMenuModeChange(MenuBuilder var1) {
   }

   public boolean onOpenSubMenu(MenuBuilder var1) {
      boolean var2 = true;
      if(var1 == null) {
         var2 = false;
      } else if(var1.hasVisibleItems()) {
         (new MenuPopupHelper(this.mContext, var1, this.mAnchor)).show();
         return var2;
      }

      return var2;
   }

   public void setOnDismissListener(PopupMenu.OnDismissListener var1) {
      this.mDismissListener = var1;
   }

   public void setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener var1) {
      this.mMenuItemClickListener = var1;
   }

   public void show() {
      this.mPopup.show();
   }

   public interface OnDismissListener {
      void onDismiss(PopupMenu var1);
   }

   public interface OnMenuItemClickListener {
      boolean onMenuItemClick(MenuItem var1);
   }
}
