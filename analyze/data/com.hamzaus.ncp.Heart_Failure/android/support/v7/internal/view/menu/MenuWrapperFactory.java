package android.support.v7.internal.view.menu;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v7.internal.view.menu.MenuItemWrapperICS;
import android.support.v7.internal.view.menu.MenuItemWrapperJB;
import android.support.v7.internal.view.menu.MenuWrapperICS;
import android.support.v7.internal.view.menu.SubMenuWrapperICS;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class MenuWrapperFactory {
   public static MenuItem createMenuItemWrapper(MenuItem var0) {
      if(VERSION.SDK_INT >= 16) {
         var0 = new MenuItemWrapperJB((MenuItem)var0);
      } else if(VERSION.SDK_INT >= 14) {
         return new MenuItemWrapperICS((MenuItem)var0);
      }

      return (MenuItem)var0;
   }

   public static Menu createMenuWrapper(Menu var0) {
      if(VERSION.SDK_INT >= 14) {
         var0 = new MenuWrapperICS((Menu)var0);
      }

      return (Menu)var0;
   }

   public static SupportMenuItem createSupportMenuItemWrapper(MenuItem var0) {
      if(VERSION.SDK_INT >= 16) {
         return new MenuItemWrapperJB(var0);
      } else if(VERSION.SDK_INT >= 14) {
         return new MenuItemWrapperICS(var0);
      } else {
         throw new UnsupportedOperationException();
      }
   }

   public static SupportMenu createSupportMenuWrapper(Menu var0) {
      if(VERSION.SDK_INT >= 14) {
         return new MenuWrapperICS(var0);
      } else {
         throw new UnsupportedOperationException();
      }
   }

   public static SupportSubMenu createSupportSubMenuWrapper(SubMenu var0) {
      if(VERSION.SDK_INT >= 14) {
         return new SubMenuWrapperICS(var0);
      } else {
         throw new UnsupportedOperationException();
      }
   }
}
