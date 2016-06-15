package android.support.v7.internal.view.menu;

import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.internal.view.menu.BaseWrapper;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.HashMap;
import java.util.Iterator;

abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
   private HashMap<MenuItem, SupportMenuItem> mMenuItems;
   private HashMap<SubMenu, SubMenu> mSubMenus;

   BaseMenuWrapper(T var1) {
      super(var1);
   }

   final SupportMenuItem getMenuItemWrapper(MenuItem var1) {
      if(var1 != null) {
         if(this.mMenuItems == null) {
            this.mMenuItems = new HashMap();
         }

         SupportMenuItem var2 = (SupportMenuItem)this.mMenuItems.get(var1);
         if(var2 == null) {
            var2 = MenuWrapperFactory.createSupportMenuItemWrapper(var1);
            this.mMenuItems.put(var1, var2);
         }

         return var2;
      } else {
         return null;
      }
   }

   final SubMenu getSubMenuWrapper(SubMenu var1) {
      if(var1 != null) {
         if(this.mSubMenus == null) {
            this.mSubMenus = new HashMap();
         }

         Object var2 = (SubMenu)this.mSubMenus.get(var1);
         if(var2 == null) {
            var2 = MenuWrapperFactory.createSupportSubMenuWrapper(var1);
            this.mSubMenus.put(var1, var2);
         }

         return (SubMenu)var2;
      } else {
         return null;
      }
   }

   final void internalClear() {
      if(this.mMenuItems != null) {
         this.mMenuItems.clear();
      }

      if(this.mSubMenus != null) {
         this.mSubMenus.clear();
      }

   }

   final void internalRemoveGroup(int var1) {
      if(this.mMenuItems != null) {
         Iterator var2 = this.mMenuItems.keySet().iterator();

         while(var2.hasNext()) {
            if(var1 == ((MenuItem)var2.next()).getGroupId()) {
               var2.remove();
            }
         }
      }

   }

   final void internalRemoveItem(int var1) {
      if(this.mMenuItems != null) {
         Iterator var2 = this.mMenuItems.keySet().iterator();

         while(var2.hasNext()) {
            if(var1 == ((MenuItem)var2.next()).getItemId()) {
               var2.remove();
               return;
            }
         }
      }

   }
}
