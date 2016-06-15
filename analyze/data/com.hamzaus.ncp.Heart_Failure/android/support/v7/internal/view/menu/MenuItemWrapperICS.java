package android.support.v7.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.internal.view.menu.BaseMenuWrapper;
import android.support.v7.internal.view.menu.BaseWrapper;
import android.support.v7.view.CollapsibleActionView;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class MenuItemWrapperICS extends BaseMenuWrapper<MenuItem> implements SupportMenuItem {
   static final String LOG_TAG = "MenuItemWrapper";
   private final boolean mEmulateProviderVisibilityOverride;
   private boolean mLastRequestVisible;
   private Method mSetExclusiveCheckableMethod;

   MenuItemWrapperICS(MenuItem var1) {
      this(var1, true);
   }

   MenuItemWrapperICS(MenuItem var1, boolean var2) {
      super(var1);
      this.mLastRequestVisible = var1.isVisible();
      this.mEmulateProviderVisibilityOverride = var2;
   }

   final boolean checkActionProviderOverrideVisibility() {
      boolean var1 = this.mLastRequestVisible;
      boolean var2 = false;
      if(var1) {
         ActionProvider var3 = this.getSupportActionProvider();
         var2 = false;
         if(var3 != null) {
            boolean var4 = var3.overridesItemVisibility();
            var2 = false;
            if(var4) {
               boolean var5 = var3.isVisible();
               var2 = false;
               if(!var5) {
                  this.wrappedSetVisible(false);
                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   public boolean collapseActionView() {
      return ((MenuItem)this.mWrappedObject).collapseActionView();
   }

   MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(ActionProvider var1) {
      return new MenuItemWrapperICS.ActionProviderWrapper(var1);
   }

   public boolean expandActionView() {
      return ((MenuItem)this.mWrappedObject).expandActionView();
   }

   public android.view.ActionProvider getActionProvider() {
      return ((MenuItem)this.mWrappedObject).getActionProvider();
   }

   public View getActionView() {
      View var1 = ((MenuItem)this.mWrappedObject).getActionView();
      if(var1 instanceof MenuItemWrapperICS.CollapsibleActionViewWrapper) {
         var1 = ((MenuItemWrapperICS.CollapsibleActionViewWrapper)var1).getWrappedView();
      }

      return var1;
   }

   public char getAlphabeticShortcut() {
      return ((MenuItem)this.mWrappedObject).getAlphabeticShortcut();
   }

   public int getGroupId() {
      return ((MenuItem)this.mWrappedObject).getGroupId();
   }

   public Drawable getIcon() {
      return ((MenuItem)this.mWrappedObject).getIcon();
   }

   public Intent getIntent() {
      return ((MenuItem)this.mWrappedObject).getIntent();
   }

   public int getItemId() {
      return ((MenuItem)this.mWrappedObject).getItemId();
   }

   public ContextMenuInfo getMenuInfo() {
      return ((MenuItem)this.mWrappedObject).getMenuInfo();
   }

   public char getNumericShortcut() {
      return ((MenuItem)this.mWrappedObject).getNumericShortcut();
   }

   public int getOrder() {
      return ((MenuItem)this.mWrappedObject).getOrder();
   }

   public SubMenu getSubMenu() {
      return this.getSubMenuWrapper(((MenuItem)this.mWrappedObject).getSubMenu());
   }

   public ActionProvider getSupportActionProvider() {
      MenuItemWrapperICS.ActionProviderWrapper var1 = (MenuItemWrapperICS.ActionProviderWrapper)((MenuItem)this.mWrappedObject).getActionProvider();
      return var1 != null?var1.mInner:null;
   }

   public CharSequence getTitle() {
      return ((MenuItem)this.mWrappedObject).getTitle();
   }

   public CharSequence getTitleCondensed() {
      return ((MenuItem)this.mWrappedObject).getTitleCondensed();
   }

   public boolean hasSubMenu() {
      return ((MenuItem)this.mWrappedObject).hasSubMenu();
   }

   public boolean isActionViewExpanded() {
      return ((MenuItem)this.mWrappedObject).isActionViewExpanded();
   }

   public boolean isCheckable() {
      return ((MenuItem)this.mWrappedObject).isCheckable();
   }

   public boolean isChecked() {
      return ((MenuItem)this.mWrappedObject).isChecked();
   }

   public boolean isEnabled() {
      return ((MenuItem)this.mWrappedObject).isEnabled();
   }

   public boolean isVisible() {
      return ((MenuItem)this.mWrappedObject).isVisible();
   }

   public MenuItem setActionProvider(android.view.ActionProvider var1) {
      ((MenuItem)this.mWrappedObject).setActionProvider(var1);
      if(var1 != null && this.mEmulateProviderVisibilityOverride) {
         this.checkActionProviderOverrideVisibility();
      }

      return this;
   }

   public MenuItem setActionView(int var1) {
      ((MenuItem)this.mWrappedObject).setActionView(var1);
      View var3 = ((MenuItem)this.mWrappedObject).getActionView();
      if(var3 instanceof CollapsibleActionView) {
         ((MenuItem)this.mWrappedObject).setActionView(new MenuItemWrapperICS.CollapsibleActionViewWrapper(var3));
      }

      return this;
   }

   public MenuItem setActionView(View var1) {
      if(var1 instanceof CollapsibleActionView) {
         var1 = new MenuItemWrapperICS.CollapsibleActionViewWrapper((View)var1);
      }

      ((MenuItem)this.mWrappedObject).setActionView((View)var1);
      return this;
   }

   public MenuItem setAlphabeticShortcut(char var1) {
      ((MenuItem)this.mWrappedObject).setAlphabeticShortcut(var1);
      return this;
   }

   public MenuItem setCheckable(boolean var1) {
      ((MenuItem)this.mWrappedObject).setCheckable(var1);
      return this;
   }

   public MenuItem setChecked(boolean var1) {
      ((MenuItem)this.mWrappedObject).setChecked(var1);
      return this;
   }

   public MenuItem setEnabled(boolean var1) {
      ((MenuItem)this.mWrappedObject).setEnabled(var1);
      return this;
   }

   public void setExclusiveCheckable(boolean var1) {
      try {
         if(this.mSetExclusiveCheckableMethod == null) {
            Class var8 = ((MenuItem)this.mWrappedObject).getClass();
            Class[] var9 = new Class[]{Boolean.TYPE};
            this.mSetExclusiveCheckableMethod = var8.getDeclaredMethod("setExclusiveCheckable", var9);
         }

         Method var4 = this.mSetExclusiveCheckableMethod;
         Object var5 = this.mWrappedObject;
         Object[] var6 = new Object[]{Boolean.valueOf(var1)};
         var4.invoke(var5, var6);
      } catch (Exception var10) {
         Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", var10);
      }
   }

   public MenuItem setIcon(int var1) {
      ((MenuItem)this.mWrappedObject).setIcon(var1);
      return this;
   }

   public MenuItem setIcon(Drawable var1) {
      ((MenuItem)this.mWrappedObject).setIcon(var1);
      return this;
   }

   public MenuItem setIntent(Intent var1) {
      ((MenuItem)this.mWrappedObject).setIntent(var1);
      return this;
   }

   public MenuItem setNumericShortcut(char var1) {
      ((MenuItem)this.mWrappedObject).setNumericShortcut(var1);
      return this;
   }

   public MenuItem setOnActionExpandListener(OnActionExpandListener var1) {
      ((MenuItem)this.mWrappedObject).setOnActionExpandListener(var1);
      return this;
   }

   public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener var1) {
      MenuItem var2 = (MenuItem)this.mWrappedObject;
      MenuItemWrapperICS.OnMenuItemClickListenerWrapper var3;
      if(var1 != null) {
         var3 = new MenuItemWrapperICS.OnMenuItemClickListenerWrapper(var1);
      } else {
         var3 = null;
      }

      var2.setOnMenuItemClickListener(var3);
      return this;
   }

   public MenuItem setShortcut(char var1, char var2) {
      ((MenuItem)this.mWrappedObject).setShortcut(var1, var2);
      return this;
   }

   public void setShowAsAction(int var1) {
      ((MenuItem)this.mWrappedObject).setShowAsAction(var1);
   }

   public MenuItem setShowAsActionFlags(int var1) {
      ((MenuItem)this.mWrappedObject).setShowAsActionFlags(var1);
      return this;
   }

   public SupportMenuItem setSupportActionProvider(ActionProvider var1) {
      MenuItem var2 = (MenuItem)this.mWrappedObject;
      MenuItemWrapperICS.ActionProviderWrapper var3;
      if(var1 != null) {
         var3 = this.createActionProviderWrapper(var1);
      } else {
         var3 = null;
      }

      var2.setActionProvider(var3);
      return this;
   }

   public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener var1) {
      MenuItem var2 = (MenuItem)this.mWrappedObject;
      MenuItemWrapperICS.OnActionExpandListenerWrapper var3;
      if(var1 != null) {
         var3 = new MenuItemWrapperICS.OnActionExpandListenerWrapper(var1);
      } else {
         var3 = null;
      }

      var2.setOnActionExpandListener(var3);
      return null;
   }

   public MenuItem setTitle(int var1) {
      ((MenuItem)this.mWrappedObject).setTitle(var1);
      return this;
   }

   public MenuItem setTitle(CharSequence var1) {
      ((MenuItem)this.mWrappedObject).setTitle(var1);
      return this;
   }

   public MenuItem setTitleCondensed(CharSequence var1) {
      ((MenuItem)this.mWrappedObject).setTitleCondensed(var1);
      return this;
   }

   public MenuItem setVisible(boolean var1) {
      if(this.mEmulateProviderVisibilityOverride) {
         this.mLastRequestVisible = var1;
         if(this.checkActionProviderOverrideVisibility()) {
            return this;
         }
      }

      return this.wrappedSetVisible(var1);
   }

   final MenuItem wrappedSetVisible(boolean var1) {
      return ((MenuItem)this.mWrappedObject).setVisible(var1);
   }

   class ActionProviderWrapper extends android.view.ActionProvider {
      final ActionProvider mInner;

      public ActionProviderWrapper(ActionProvider var2) {
         super(var2.getContext());
         this.mInner = var2;
         if(MenuItemWrapperICS.this.mEmulateProviderVisibilityOverride) {
            this.mInner.setVisibilityListener(new ActionProvider.VisibilityListener() {
               public void onActionProviderVisibilityChanged(boolean var1) {
                  if(ActionProviderWrapper.this.mInner.overridesItemVisibility() && MenuItemWrapperICS.this.mLastRequestVisible) {
                     MenuItemWrapperICS.this.wrappedSetVisible(var1);
                  }

               }
            });
         }

      }

      public boolean hasSubMenu() {
         return this.mInner.hasSubMenu();
      }

      public View onCreateActionView() {
         if(MenuItemWrapperICS.this.mEmulateProviderVisibilityOverride) {
            MenuItemWrapperICS.this.checkActionProviderOverrideVisibility();
         }

         return this.mInner.onCreateActionView();
      }

      public boolean onPerformDefaultAction() {
         return this.mInner.onPerformDefaultAction();
      }

      public void onPrepareSubMenu(SubMenu var1) {
         this.mInner.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(var1));
      }
   }

   static class CollapsibleActionViewWrapper extends FrameLayout implements android.view.CollapsibleActionView {
      final CollapsibleActionView mWrappedView;

      CollapsibleActionViewWrapper(View var1) {
         super(var1.getContext());
         this.mWrappedView = (CollapsibleActionView)var1;
         this.addView(var1);
      }

      View getWrappedView() {
         return (View)this.mWrappedView;
      }

      public void onActionViewCollapsed() {
         this.mWrappedView.onActionViewCollapsed();
      }

      public void onActionViewExpanded() {
         this.mWrappedView.onActionViewExpanded();
      }
   }

   private class OnActionExpandListenerWrapper extends BaseWrapper<MenuItemCompat.OnActionExpandListener> implements OnActionExpandListener {
      OnActionExpandListenerWrapper(MenuItemCompat.OnActionExpandListener var2) {
         super(var2);
      }

      public boolean onMenuItemActionCollapse(MenuItem var1) {
         return ((MenuItemCompat.OnActionExpandListener)this.mWrappedObject).onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(var1));
      }

      public boolean onMenuItemActionExpand(MenuItem var1) {
         return ((MenuItemCompat.OnActionExpandListener)this.mWrappedObject).onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(var1));
      }
   }

   private class OnMenuItemClickListenerWrapper extends BaseWrapper<OnMenuItemClickListener> implements OnMenuItemClickListener {
      OnMenuItemClickListenerWrapper(OnMenuItemClickListener var2) {
         super(var2);
      }

      public boolean onMenuItemClick(MenuItem var1) {
         return ((OnMenuItemClickListener)this.mWrappedObject).onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(var1));
      }
   }
}
