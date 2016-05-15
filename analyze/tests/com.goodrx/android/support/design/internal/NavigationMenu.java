package android.support.design.internal;

import android.content.Context;
import android.support.design.internal.NavigationSubMenu;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.SubMenu;

public class NavigationMenu extends MenuBuilder {
   public NavigationMenu(Context var1) {
      super(var1);
   }

   public SubMenu addSubMenu(int var1, int var2, int var3, CharSequence var4) {
      MenuItemImpl var5 = (MenuItemImpl)this.addInternal(var1, var2, var3, var4);
      NavigationSubMenu var6 = new NavigationSubMenu(this.getContext(), this, var5);
      var5.setSubMenu(var6);
      return var6;
   }
}
