package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
   private MenuItemImpl mItem;
   private MenuBuilder mParentMenu;

   public SubMenuBuilder(Context var1, MenuBuilder var2, MenuItemImpl var3) {
      super(var1);
      this.mParentMenu = var2;
      this.mItem = var3;
   }

   public boolean collapseItemActionView(MenuItemImpl var1) {
      return this.mParentMenu.collapseItemActionView(var1);
   }

   boolean dispatchMenuItemSelected(MenuBuilder var1, MenuItem var2) {
      return super.dispatchMenuItemSelected(var1, var2) || this.mParentMenu.dispatchMenuItemSelected(var1, var2);
   }

   public boolean expandItemActionView(MenuItemImpl var1) {
      return this.mParentMenu.expandItemActionView(var1);
   }

   public String getActionViewStatesKey() {
      int var1;
      if(this.mItem != null) {
         var1 = this.mItem.getItemId();
      } else {
         var1 = 0;
      }

      return var1 == 0?null:super.getActionViewStatesKey() + ":" + var1;
   }

   public MenuItem getItem() {
      return this.mItem;
   }

   public Menu getParentMenu() {
      return this.mParentMenu;
   }

   public MenuBuilder getRootMenu() {
      return this.mParentMenu;
   }

   public boolean isQwertyMode() {
      return this.mParentMenu.isQwertyMode();
   }

   public boolean isShortcutsVisible() {
      return this.mParentMenu.isShortcutsVisible();
   }

   public void setCallback(MenuBuilder.Callback var1) {
      this.mParentMenu.setCallback(var1);
   }

   public SubMenu setHeaderIcon(int var1) {
      super.setHeaderIconInt(ContextCompat.getDrawable(this.getContext(), var1));
      return this;
   }

   public SubMenu setHeaderIcon(Drawable var1) {
      super.setHeaderIconInt(var1);
      return this;
   }

   public SubMenu setHeaderTitle(int var1) {
      super.setHeaderTitleInt(this.getContext().getResources().getString(var1));
      return this;
   }

   public SubMenu setHeaderTitle(CharSequence var1) {
      super.setHeaderTitleInt(var1);
      return this;
   }

   public SubMenu setHeaderView(View var1) {
      super.setHeaderViewInt(var1);
      return this;
   }

   public SubMenu setIcon(int var1) {
      this.mItem.setIcon(var1);
      return this;
   }

   public SubMenu setIcon(Drawable var1) {
      this.mItem.setIcon(var1);
      return this;
   }

   public void setQwertyMode(boolean var1) {
      this.mParentMenu.setQwertyMode(var1);
   }

   public void setShortcutsVisible(boolean var1) {
      this.mParentMenu.setShortcutsVisible(var1);
   }
}
