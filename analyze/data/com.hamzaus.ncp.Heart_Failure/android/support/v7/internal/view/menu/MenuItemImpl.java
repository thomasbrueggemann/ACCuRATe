package android.support.v7.internal.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class MenuItemImpl implements SupportMenuItem {
   private static final int CHECKABLE = 1;
   private static final int CHECKED = 2;
   private static final int ENABLED = 16;
   private static final int EXCLUSIVE = 4;
   private static final int HIDDEN = 8;
   private static final int IS_ACTION = 32;
   static final int NO_ICON = 0;
   private static final int SHOW_AS_ACTION_MASK = 3;
   private static final String TAG = "MenuItemImpl";
   private static String sDeleteShortcutLabel;
   private static String sEnterShortcutLabel;
   private static String sPrependShortcutLabel;
   private static String sSpaceShortcutLabel;
   private ActionProvider mActionProvider;
   private View mActionView;
   private final int mCategoryOrder;
   private OnMenuItemClickListener mClickListener;
   private int mFlags = 16;
   private final int mGroup;
   private Drawable mIconDrawable;
   private int mIconResId = 0;
   private final int mId;
   private Intent mIntent;
   private boolean mIsActionViewExpanded = false;
   private Runnable mItemCallback;
   private MenuBuilder mMenu;
   private ContextMenuInfo mMenuInfo;
   private MenuItemCompat.OnActionExpandListener mOnActionExpandListener;
   private final int mOrdering;
   private char mShortcutAlphabeticChar;
   private char mShortcutNumericChar;
   private int mShowAsAction = 0;
   private SubMenuBuilder mSubMenu;
   private CharSequence mTitle;
   private CharSequence mTitleCondensed;

   MenuItemImpl(MenuBuilder var1, int var2, int var3, int var4, int var5, CharSequence var6, int var7) {
      this.mMenu = var1;
      this.mId = var3;
      this.mGroup = var2;
      this.mCategoryOrder = var4;
      this.mOrdering = var5;
      this.mTitle = var6;
      this.mShowAsAction = var7;
   }

   public void actionFormatChanged() {
      this.mMenu.onItemActionRequestChanged(this);
   }

   public boolean collapseActionView() {
      if((8 & this.mShowAsAction) != 0) {
         if(this.mActionView == null) {
            return true;
         }

         if(this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.mMenu.collapseItemActionView(this);
         }
      }

      return false;
   }

   public boolean expandActionView() {
      return (8 & this.mShowAsAction) != 0 && this.mActionView != null && (this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionExpand(this))?this.mMenu.expandItemActionView(this):false;
   }

   public android.view.ActionProvider getActionProvider() {
      throw new UnsupportedOperationException("Implementation should use getSupportActionProvider!");
   }

   public View getActionView() {
      if(this.mActionView != null) {
         return this.mActionView;
      } else if(this.mActionProvider != null) {
         this.mActionView = this.mActionProvider.onCreateActionView(this);
         return this.mActionView;
      } else {
         return null;
      }
   }

   public char getAlphabeticShortcut() {
      return this.mShortcutAlphabeticChar;
   }

   Runnable getCallback() {
      return this.mItemCallback;
   }

   public int getGroupId() {
      return this.mGroup;
   }

   public Drawable getIcon() {
      if(this.mIconDrawable != null) {
         return this.mIconDrawable;
      } else if(this.mIconResId != 0) {
         Drawable var1 = this.mMenu.getResources().getDrawable(this.mIconResId);
         this.mIconResId = 0;
         this.mIconDrawable = var1;
         return var1;
      } else {
         return null;
      }
   }

   public Intent getIntent() {
      return this.mIntent;
   }

   @CapturedViewProperty
   public int getItemId() {
      return this.mId;
   }

   public ContextMenuInfo getMenuInfo() {
      return this.mMenuInfo;
   }

   public char getNumericShortcut() {
      return this.mShortcutNumericChar;
   }

   public int getOrder() {
      return this.mCategoryOrder;
   }

   public int getOrdering() {
      return this.mOrdering;
   }

   char getShortcut() {
      return this.mShortcutAlphabeticChar;
   }

   String getShortcutLabel() {
      char var1 = this.getShortcut();
      if(var1 == 0) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(sPrependShortcutLabel);
         switch(var1) {
         case '\b':
            var2.append(sDeleteShortcutLabel);
            break;
         case '\n':
            var2.append(sEnterShortcutLabel);
            break;
         case ' ':
            var2.append(sSpaceShortcutLabel);
            break;
         default:
            var2.append(var1);
         }

         return var2.toString();
      }
   }

   public SubMenu getSubMenu() {
      return this.mSubMenu;
   }

   public ActionProvider getSupportActionProvider() {
      return this.mActionProvider;
   }

   @CapturedViewProperty
   public CharSequence getTitle() {
      return this.mTitle;
   }

   public CharSequence getTitleCondensed() {
      return this.mTitleCondensed != null?this.mTitleCondensed:this.mTitle;
   }

   CharSequence getTitleForItemView(MenuView.ItemView var1) {
      return var1 != null && var1.prefersCondensedTitle()?this.getTitleCondensed():this.getTitle();
   }

   public boolean hasCollapsibleActionView() {
      return (8 & this.mShowAsAction) != 0 && this.mActionView != null;
   }

   public boolean hasSubMenu() {
      return this.mSubMenu != null;
   }

   public boolean invoke() {
      if((this.mClickListener == null || !this.mClickListener.onMenuItemClick(this)) && !this.mMenu.dispatchMenuItemSelected(this.mMenu.getRootMenu(), this)) {
         if(this.mItemCallback != null) {
            this.mItemCallback.run();
            return true;
         }

         if(this.mIntent != null) {
            try {
               this.mMenu.getContext().startActivity(this.mIntent);
               return true;
            } catch (ActivityNotFoundException var2) {
               Log.e("MenuItemImpl", "Can\'t find activity to handle intent; ignoring", var2);
            }
         }

         if(this.mActionProvider == null || !this.mActionProvider.onPerformDefaultAction()) {
            return false;
         }
      }

      return true;
   }

   public boolean isActionButton() {
      return (32 & this.mFlags) == 32;
   }

   public boolean isActionViewExpanded() {
      return this.mIsActionViewExpanded;
   }

   public boolean isCheckable() {
      return (1 & this.mFlags) == 1;
   }

   public boolean isChecked() {
      return (2 & this.mFlags) == 2;
   }

   public boolean isEnabled() {
      return (16 & this.mFlags) != 0;
   }

   public boolean isExclusiveCheckable() {
      return (4 & this.mFlags) != 0;
   }

   public boolean isVisible() {
      if(this.mActionProvider != null && this.mActionProvider.overridesItemVisibility()) {
         if((8 & this.mFlags) != 0 || !this.mActionProvider.isVisible()) {
            return false;
         }
      } else if((8 & this.mFlags) != 0) {
         return false;
      }

      return true;
   }

   public boolean requestsActionButton() {
      return (1 & this.mShowAsAction) == 1;
   }

   public boolean requiresActionButton() {
      return (2 & this.mShowAsAction) == 2;
   }

   public MenuItem setActionProvider(android.view.ActionProvider var1) {
      throw new UnsupportedOperationException("Implementation should use setSupportActionProvider!");
   }

   public SupportMenuItem setActionView(int var1) {
      Context var2 = this.mMenu.getContext();
      this.setActionView(LayoutInflater.from(var2).inflate(var1, new LinearLayout(var2), false));
      return this;
   }

   public SupportMenuItem setActionView(View var1) {
      this.mActionView = var1;
      this.mActionProvider = null;
      if(var1 != null && var1.getId() == -1 && this.mId > 0) {
         var1.setId(this.mId);
      }

      this.mMenu.onItemActionRequestChanged(this);
      return this;
   }

   public void setActionViewExpanded(boolean var1) {
      this.mIsActionViewExpanded = var1;
      this.mMenu.onItemsChanged(false);
   }

   public MenuItem setAlphabeticShortcut(char var1) {
      if(this.mShortcutAlphabeticChar == var1) {
         return this;
      } else {
         this.mShortcutAlphabeticChar = Character.toLowerCase(var1);
         this.mMenu.onItemsChanged(false);
         return this;
      }
   }

   public MenuItem setCallback(Runnable var1) {
      this.mItemCallback = var1;
      return this;
   }

   public MenuItem setCheckable(boolean var1) {
      int var2 = this.mFlags;
      int var3 = -2 & this.mFlags;
      byte var4;
      if(var1) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      this.mFlags = var4 | var3;
      if(var2 != this.mFlags) {
         this.mMenu.onItemsChanged(false);
      }

      return this;
   }

   public MenuItem setChecked(boolean var1) {
      if((4 & this.mFlags) != 0) {
         this.mMenu.setExclusiveItemChecked(this);
         return this;
      } else {
         this.setCheckedInt(var1);
         return this;
      }
   }

   void setCheckedInt(boolean var1) {
      int var2 = this.mFlags;
      int var3 = -3 & this.mFlags;
      byte var4;
      if(var1) {
         var4 = 2;
      } else {
         var4 = 0;
      }

      this.mFlags = var4 | var3;
      if(var2 != this.mFlags) {
         this.mMenu.onItemsChanged(false);
      }

   }

   public MenuItem setEnabled(boolean var1) {
      if(var1) {
         this.mFlags |= 16;
      } else {
         this.mFlags &= -17;
      }

      this.mMenu.onItemsChanged(false);
      return this;
   }

   public void setExclusiveCheckable(boolean var1) {
      int var2 = -5 & this.mFlags;
      byte var3;
      if(var1) {
         var3 = 4;
      } else {
         var3 = 0;
      }

      this.mFlags = var3 | var2;
   }

   public MenuItem setIcon(int var1) {
      this.mIconDrawable = null;
      this.mIconResId = var1;
      this.mMenu.onItemsChanged(false);
      return this;
   }

   public MenuItem setIcon(Drawable var1) {
      this.mIconResId = 0;
      this.mIconDrawable = var1;
      this.mMenu.onItemsChanged(false);
      return this;
   }

   public MenuItem setIntent(Intent var1) {
      this.mIntent = var1;
      return this;
   }

   public void setIsActionButton(boolean var1) {
      if(var1) {
         this.mFlags |= 32;
      } else {
         this.mFlags &= -33;
      }
   }

   void setMenuInfo(ContextMenuInfo var1) {
      this.mMenuInfo = var1;
   }

   public MenuItem setNumericShortcut(char var1) {
      if(this.mShortcutNumericChar == var1) {
         return this;
      } else {
         this.mShortcutNumericChar = var1;
         this.mMenu.onItemsChanged(false);
         return this;
      }
   }

   public MenuItem setOnActionExpandListener(OnActionExpandListener var1) {
      throw new UnsupportedOperationException("Implementation should use setSupportOnActionExpandListener!");
   }

   public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener var1) {
      this.mClickListener = var1;
      return this;
   }

   public MenuItem setShortcut(char var1, char var2) {
      this.mShortcutNumericChar = var1;
      this.mShortcutAlphabeticChar = Character.toLowerCase(var2);
      this.mMenu.onItemsChanged(false);
      return this;
   }

   public void setShowAsAction(int var1) {
      switch(var1 & 3) {
      case 0:
      case 1:
      case 2:
         this.mShowAsAction = var1;
         this.mMenu.onItemActionRequestChanged(this);
         return;
      default:
         throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
      }
   }

   public SupportMenuItem setShowAsActionFlags(int var1) {
      this.setShowAsAction(var1);
      return this;
   }

   void setSubMenu(SubMenuBuilder var1) {
      this.mSubMenu = var1;
      var1.setHeaderTitle(this.getTitle());
   }

   public SupportMenuItem setSupportActionProvider(ActionProvider var1) {
      if(this.mActionProvider != var1) {
         this.mActionView = null;
         if(this.mActionProvider != null) {
            this.mActionProvider.setVisibilityListener((ActionProvider.VisibilityListener)null);
         }

         this.mActionProvider = var1;
         this.mMenu.onItemsChanged(true);
         if(var1 != null) {
            var1.setVisibilityListener(new ActionProvider.VisibilityListener() {
               public void onActionProviderVisibilityChanged(boolean var1) {
                  MenuItemImpl.this.mMenu.onItemVisibleChanged(MenuItemImpl.this);
               }
            });
            return this;
         }
      }

      return this;
   }

   public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener var1) {
      this.mOnActionExpandListener = var1;
      return this;
   }

   public MenuItem setTitle(int var1) {
      return this.setTitle(this.mMenu.getContext().getString(var1));
   }

   public MenuItem setTitle(CharSequence var1) {
      this.mTitle = var1;
      this.mMenu.onItemsChanged(false);
      if(this.mSubMenu != null) {
         this.mSubMenu.setHeaderTitle(var1);
      }

      return this;
   }

   public MenuItem setTitleCondensed(CharSequence var1) {
      this.mTitleCondensed = var1;
      if(var1 == null) {
         CharSequence var10000 = this.mTitle;
      }

      this.mMenu.onItemsChanged(false);
      return this;
   }

   public MenuItem setVisible(boolean var1) {
      if(this.setVisibleInt(var1)) {
         this.mMenu.onItemVisibleChanged(this);
      }

      return this;
   }

   boolean setVisibleInt(boolean var1) {
      int var2 = this.mFlags;
      int var3 = -9 & this.mFlags;
      byte var4;
      if(var1) {
         var4 = 0;
      } else {
         var4 = 8;
      }

      this.mFlags = var4 | var3;
      int var5 = this.mFlags;
      boolean var6 = false;
      if(var2 != var5) {
         var6 = true;
      }

      return var6;
   }

   public boolean shouldShowIcon() {
      return this.mMenu.getOptionalIconsVisible();
   }

   boolean shouldShowShortcut() {
      return this.mMenu.isShortcutsVisible() && this.getShortcut() != 0;
   }

   public boolean showsTextAsAction() {
      return (4 & this.mShowAsAction) == 4;
   }

   public String toString() {
      return this.mTitle.toString();
   }
}
