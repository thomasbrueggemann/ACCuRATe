package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;

public class ActionMenuItem implements SupportMenuItem {
   private static final int CHECKABLE = 1;
   private static final int CHECKED = 2;
   private static final int ENABLED = 16;
   private static final int EXCLUSIVE = 4;
   private static final int HIDDEN = 8;
   private static final int NO_ICON;
   private final int mCategoryOrder;
   private OnMenuItemClickListener mClickListener;
   private Context mContext;
   private int mFlags = 16;
   private final int mGroup;
   private Drawable mIconDrawable;
   private int mIconResId = 0;
   private final int mId;
   private Intent mIntent;
   private final int mOrdering;
   private char mShortcutAlphabeticChar;
   private char mShortcutNumericChar;
   private CharSequence mTitle;
   private CharSequence mTitleCondensed;

   public ActionMenuItem(Context var1, int var2, int var3, int var4, int var5, CharSequence var6) {
      this.mContext = var1;
      this.mId = var3;
      this.mGroup = var2;
      this.mCategoryOrder = var4;
      this.mOrdering = var5;
      this.mTitle = var6;
   }

   public boolean collapseActionView() {
      return false;
   }

   public boolean expandActionView() {
      return false;
   }

   public ActionProvider getActionProvider() {
      throw new UnsupportedOperationException();
   }

   public View getActionView() {
      return null;
   }

   public char getAlphabeticShortcut() {
      return this.mShortcutAlphabeticChar;
   }

   public int getGroupId() {
      return this.mGroup;
   }

   public Drawable getIcon() {
      return this.mIconDrawable;
   }

   public Intent getIntent() {
      return this.mIntent;
   }

   public int getItemId() {
      return this.mId;
   }

   public ContextMenuInfo getMenuInfo() {
      return null;
   }

   public char getNumericShortcut() {
      return this.mShortcutNumericChar;
   }

   public int getOrder() {
      return this.mOrdering;
   }

   public SubMenu getSubMenu() {
      return null;
   }

   public android.support.v4.view.ActionProvider getSupportActionProvider() {
      return null;
   }

   public CharSequence getTitle() {
      return this.mTitle;
   }

   public CharSequence getTitleCondensed() {
      return this.mTitleCondensed != null?this.mTitleCondensed:this.mTitle;
   }

   public boolean hasSubMenu() {
      return false;
   }

   public boolean invoke() {
      if(this.mClickListener != null && this.mClickListener.onMenuItemClick(this)) {
         return true;
      } else if(this.mIntent != null) {
         this.mContext.startActivity(this.mIntent);
         return true;
      } else {
         return false;
      }
   }

   public boolean isActionViewExpanded() {
      return false;
   }

   public boolean isCheckable() {
      return (1 & this.mFlags) != 0;
   }

   public boolean isChecked() {
      return (2 & this.mFlags) != 0;
   }

   public boolean isEnabled() {
      return (16 & this.mFlags) != 0;
   }

   public boolean isVisible() {
      return (8 & this.mFlags) == 0;
   }

   public MenuItem setActionProvider(ActionProvider var1) {
      throw new UnsupportedOperationException();
   }

   public SupportMenuItem setActionView(int var1) {
      throw new UnsupportedOperationException();
   }

   public SupportMenuItem setActionView(View var1) {
      throw new UnsupportedOperationException();
   }

   public MenuItem setAlphabeticShortcut(char var1) {
      this.mShortcutAlphabeticChar = var1;
      return this;
   }

   public MenuItem setCheckable(boolean var1) {
      int var2 = -2 & this.mFlags;
      byte var3;
      if(var1) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      this.mFlags = var3 | var2;
      return this;
   }

   public MenuItem setChecked(boolean var1) {
      int var2 = -3 & this.mFlags;
      byte var3;
      if(var1) {
         var3 = 2;
      } else {
         var3 = 0;
      }

      this.mFlags = var3 | var2;
      return this;
   }

   public MenuItem setEnabled(boolean var1) {
      int var2 = -17 & this.mFlags;
      byte var3;
      if(var1) {
         var3 = 16;
      } else {
         var3 = 0;
      }

      this.mFlags = var3 | var2;
      return this;
   }

   public ActionMenuItem setExclusiveCheckable(boolean var1) {
      int var2 = -5 & this.mFlags;
      byte var3;
      if(var1) {
         var3 = 4;
      } else {
         var3 = 0;
      }

      this.mFlags = var3 | var2;
      return this;
   }

   public MenuItem setIcon(int var1) {
      this.mIconResId = var1;
      this.mIconDrawable = ContextCompat.getDrawable(this.mContext, var1);
      return this;
   }

   public MenuItem setIcon(Drawable var1) {
      this.mIconDrawable = var1;
      this.mIconResId = 0;
      return this;
   }

   public MenuItem setIntent(Intent var1) {
      this.mIntent = var1;
      return this;
   }

   public MenuItem setNumericShortcut(char var1) {
      this.mShortcutNumericChar = var1;
      return this;
   }

   public MenuItem setOnActionExpandListener(OnActionExpandListener var1) {
      throw new UnsupportedOperationException();
   }

   public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener var1) {
      this.mClickListener = var1;
      return this;
   }

   public MenuItem setShortcut(char var1, char var2) {
      this.mShortcutNumericChar = var1;
      this.mShortcutAlphabeticChar = var2;
      return this;
   }

   public void setShowAsAction(int var1) {
   }

   public SupportMenuItem setShowAsActionFlags(int var1) {
      this.setShowAsAction(var1);
      return this;
   }

   public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider var1) {
      throw new UnsupportedOperationException();
   }

   public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener var1) {
      return this;
   }

   public MenuItem setTitle(int var1) {
      this.mTitle = this.mContext.getResources().getString(var1);
      return this;
   }

   public MenuItem setTitle(CharSequence var1) {
      this.mTitle = var1;
      return this;
   }

   public MenuItem setTitleCondensed(CharSequence var1) {
      this.mTitleCondensed = var1;
      return this;
   }

   public MenuItem setVisible(boolean var1) {
      int var2 = 8 & this.mFlags;
      byte var3;
      if(var1) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      this.mFlags = var3 | var2;
      return this;
   }
}
