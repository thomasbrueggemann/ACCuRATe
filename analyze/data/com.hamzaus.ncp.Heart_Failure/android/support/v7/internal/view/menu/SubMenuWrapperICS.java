package android.support.v7.internal.view.menu;

import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v7.internal.view.menu.MenuWrapperICS;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class SubMenuWrapperICS extends MenuWrapperICS implements SupportSubMenu {
   SubMenuWrapperICS(SubMenu var1) {
      super(var1);
   }

   public void clearHeader() {
      ((SubMenu)this.mWrappedObject).clearHeader();
   }

   public MenuItem getItem() {
      return this.getMenuItemWrapper(((SubMenu)this.mWrappedObject).getItem());
   }

   public SubMenu getWrappedObject() {
      return (SubMenu)this.mWrappedObject;
   }

   public SubMenu setHeaderIcon(int var1) {
      ((SubMenu)this.mWrappedObject).setHeaderIcon(var1);
      return this;
   }

   public SubMenu setHeaderIcon(Drawable var1) {
      ((SubMenu)this.mWrappedObject).setHeaderIcon(var1);
      return this;
   }

   public SubMenu setHeaderTitle(int var1) {
      ((SubMenu)this.mWrappedObject).setHeaderTitle(var1);
      return this;
   }

   public SubMenu setHeaderTitle(CharSequence var1) {
      ((SubMenu)this.mWrappedObject).setHeaderTitle(var1);
      return this;
   }

   public SubMenu setHeaderView(View var1) {
      ((SubMenu)this.mWrappedObject).setHeaderView(var1);
      return this;
   }

   public SubMenu setIcon(int var1) {
      ((SubMenu)this.mWrappedObject).setIcon(var1);
      return this;
   }

   public SubMenu setIcon(Drawable var1) {
      ((SubMenu)this.mWrappedObject).setIcon(var1);
      return this;
   }
}
