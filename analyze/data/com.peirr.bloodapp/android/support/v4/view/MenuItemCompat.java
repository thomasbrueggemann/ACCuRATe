package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompatHoneycomb;
import android.support.v4.view.MenuItemCompatIcs;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MenuItemCompat {
   static final MenuItemCompat.MenuVersionImpl IMPL;
   public static final int SHOW_AS_ACTION_ALWAYS = 2;
   public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
   public static final int SHOW_AS_ACTION_IF_ROOM = 1;
   public static final int SHOW_AS_ACTION_NEVER = 0;
   public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
   private static final String TAG = "MenuItemCompat";

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 14) {
         IMPL = new MenuItemCompat.IcsMenuVersionImpl();
      } else if(var0 >= 11) {
         IMPL = new MenuItemCompat.HoneycombMenuVersionImpl();
      } else {
         IMPL = new MenuItemCompat.BaseMenuVersionImpl();
      }
   }

   public static boolean collapseActionView(MenuItem var0) {
      return var0 instanceof SupportMenuItem?((SupportMenuItem)var0).collapseActionView():IMPL.collapseActionView(var0);
   }

   public static boolean expandActionView(MenuItem var0) {
      return var0 instanceof SupportMenuItem?((SupportMenuItem)var0).expandActionView():IMPL.expandActionView(var0);
   }

   public static ActionProvider getActionProvider(MenuItem var0) {
      if(var0 instanceof SupportMenuItem) {
         return ((SupportMenuItem)var0).getSupportActionProvider();
      } else {
         Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
         return null;
      }
   }

   public static View getActionView(MenuItem var0) {
      return var0 instanceof SupportMenuItem?((SupportMenuItem)var0).getActionView():IMPL.getActionView(var0);
   }

   public static boolean isActionViewExpanded(MenuItem var0) {
      return var0 instanceof SupportMenuItem?((SupportMenuItem)var0).isActionViewExpanded():IMPL.isActionViewExpanded(var0);
   }

   public static MenuItem setActionProvider(MenuItem var0, ActionProvider var1) {
      if(var0 instanceof SupportMenuItem) {
         return ((SupportMenuItem)var0).setSupportActionProvider(var1);
      } else {
         Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
         return var0;
      }
   }

   public static MenuItem setActionView(MenuItem var0, int var1) {
      return var0 instanceof SupportMenuItem?((SupportMenuItem)var0).setActionView(var1):IMPL.setActionView(var0, var1);
   }

   public static MenuItem setActionView(MenuItem var0, View var1) {
      return var0 instanceof SupportMenuItem?((SupportMenuItem)var0).setActionView(var1):IMPL.setActionView(var0, var1);
   }

   public static MenuItem setOnActionExpandListener(MenuItem var0, MenuItemCompat.OnActionExpandListener var1) {
      return (MenuItem)(var0 instanceof SupportMenuItem?((SupportMenuItem)var0).setSupportOnActionExpandListener(var1):IMPL.setOnActionExpandListener(var0, var1));
   }

   public static void setShowAsAction(MenuItem var0, int var1) {
      if(var0 instanceof SupportMenuItem) {
         ((SupportMenuItem)var0).setShowAsAction(var1);
      } else {
         IMPL.setShowAsAction(var0, var1);
      }
   }

   static class BaseMenuVersionImpl implements MenuItemCompat.MenuVersionImpl {
      public boolean collapseActionView(MenuItem var1) {
         return false;
      }

      public boolean expandActionView(MenuItem var1) {
         return false;
      }

      public View getActionView(MenuItem var1) {
         return null;
      }

      public boolean isActionViewExpanded(MenuItem var1) {
         return false;
      }

      public MenuItem setActionView(MenuItem var1, int var2) {
         return var1;
      }

      public MenuItem setActionView(MenuItem var1, View var2) {
         return var1;
      }

      public MenuItem setOnActionExpandListener(MenuItem var1, MenuItemCompat.OnActionExpandListener var2) {
         return var1;
      }

      public void setShowAsAction(MenuItem var1, int var2) {
      }
   }

   static class HoneycombMenuVersionImpl implements MenuItemCompat.MenuVersionImpl {
      public boolean collapseActionView(MenuItem var1) {
         return false;
      }

      public boolean expandActionView(MenuItem var1) {
         return false;
      }

      public View getActionView(MenuItem var1) {
         return MenuItemCompatHoneycomb.getActionView(var1);
      }

      public boolean isActionViewExpanded(MenuItem var1) {
         return false;
      }

      public MenuItem setActionView(MenuItem var1, int var2) {
         return MenuItemCompatHoneycomb.setActionView(var1, var2);
      }

      public MenuItem setActionView(MenuItem var1, View var2) {
         return MenuItemCompatHoneycomb.setActionView(var1, var2);
      }

      public MenuItem setOnActionExpandListener(MenuItem var1, MenuItemCompat.OnActionExpandListener var2) {
         return var1;
      }

      public void setShowAsAction(MenuItem var1, int var2) {
         MenuItemCompatHoneycomb.setShowAsAction(var1, var2);
      }
   }

   static class IcsMenuVersionImpl extends MenuItemCompat.HoneycombMenuVersionImpl {
      public boolean collapseActionView(MenuItem var1) {
         return MenuItemCompatIcs.collapseActionView(var1);
      }

      public boolean expandActionView(MenuItem var1) {
         return MenuItemCompatIcs.expandActionView(var1);
      }

      public boolean isActionViewExpanded(MenuItem var1) {
         return MenuItemCompatIcs.isActionViewExpanded(var1);
      }

      public MenuItem setOnActionExpandListener(MenuItem var1, final MenuItemCompat.OnActionExpandListener var2) {
         return var2 == null?MenuItemCompatIcs.setOnActionExpandListener(var1, (MenuItemCompatIcs.SupportActionExpandProxy)null):MenuItemCompatIcs.setOnActionExpandListener(var1, new MenuItemCompatIcs.SupportActionExpandProxy() {
            public boolean onMenuItemActionCollapse(MenuItem var1) {
               return var2.onMenuItemActionCollapse(var1);
            }

            public boolean onMenuItemActionExpand(MenuItem var1) {
               return var2.onMenuItemActionExpand(var1);
            }
         });
      }
   }

   interface MenuVersionImpl {
      boolean collapseActionView(MenuItem var1);

      boolean expandActionView(MenuItem var1);

      View getActionView(MenuItem var1);

      boolean isActionViewExpanded(MenuItem var1);

      MenuItem setActionView(MenuItem var1, int var2);

      MenuItem setActionView(MenuItem var1, View var2);

      MenuItem setOnActionExpandListener(MenuItem var1, MenuItemCompat.OnActionExpandListener var2);

      void setShowAsAction(MenuItem var1, int var2);
   }

   public interface OnActionExpandListener {
      boolean onMenuItemActionCollapse(MenuItem var1);

      boolean onMenuItemActionExpand(MenuItem var1);
   }
}
