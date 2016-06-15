package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.appcompat.class_639;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.SpinnerAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class ActionBar {
   public static final int DISPLAY_HOME_AS_UP = 4;
   public static final int DISPLAY_SHOW_CUSTOM = 16;
   public static final int DISPLAY_SHOW_HOME = 2;
   public static final int DISPLAY_SHOW_TITLE = 8;
   public static final int DISPLAY_USE_LOGO = 1;
   public static final int NAVIGATION_MODE_LIST = 1;
   public static final int NAVIGATION_MODE_STANDARD = 0;
   public static final int NAVIGATION_MODE_TABS = 2;

   public abstract void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1);

   public abstract void addTab(ActionBar.Tab var1);

   public abstract void addTab(ActionBar.Tab var1, int var2);

   public abstract void addTab(ActionBar.Tab var1, int var2, boolean var3);

   public abstract void addTab(ActionBar.Tab var1, boolean var2);

   public abstract View getCustomView();

   public abstract int getDisplayOptions();

   public abstract int getHeight();

   public abstract int getNavigationItemCount();

   public abstract int getNavigationMode();

   public abstract int getSelectedNavigationIndex();

   @Nullable
   public abstract ActionBar.Tab getSelectedTab();

   @Nullable
   public abstract CharSequence getSubtitle();

   public abstract ActionBar.Tab getTabAt(int var1);

   public abstract int getTabCount();

   public Context getThemedContext() {
      return null;
   }

   @Nullable
   public abstract CharSequence getTitle();

   public abstract void hide();

   public abstract boolean isShowing();

   public abstract ActionBar.Tab newTab();

   public abstract void removeAllTabs();

   public abstract void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1);

   public abstract void removeTab(ActionBar.Tab var1);

   public abstract void removeTabAt(int var1);

   public abstract void selectTab(ActionBar.Tab var1);

   public abstract void setBackgroundDrawable(Drawable var1);

   public abstract void setCustomView(int var1);

   public abstract void setCustomView(View var1);

   public abstract void setCustomView(View var1, ActionBar.LayoutParams var2);

   public abstract void setDisplayHomeAsUpEnabled(boolean var1);

   public abstract void setDisplayOptions(int var1);

   public abstract void setDisplayOptions(int var1, int var2);

   public abstract void setDisplayShowCustomEnabled(boolean var1);

   public abstract void setDisplayShowHomeEnabled(boolean var1);

   public abstract void setDisplayShowTitleEnabled(boolean var1);

   public abstract void setDisplayUseLogoEnabled(boolean var1);

   public void setHomeActionContentDescription(int var1) {
   }

   public void setHomeActionContentDescription(@Nullable CharSequence var1) {
   }

   public void setHomeAsUpIndicator(int var1) {
   }

   public void setHomeAsUpIndicator(@Nullable Drawable var1) {
   }

   public void setHomeButtonEnabled(boolean var1) {
   }

   public abstract void setIcon(int var1);

   public abstract void setIcon(Drawable var1);

   public abstract void setListNavigationCallbacks(SpinnerAdapter var1, ActionBar.OnNavigationListener var2);

   public abstract void setLogo(int var1);

   public abstract void setLogo(Drawable var1);

   public abstract void setNavigationMode(int var1);

   public abstract void setSelectedNavigationItem(int var1);

   public void setSplitBackgroundDrawable(Drawable var1) {
   }

   public void setStackedBackgroundDrawable(Drawable var1) {
   }

   public abstract void setSubtitle(int var1);

   public abstract void setSubtitle(@Nullable CharSequence var1);

   public abstract void setTitle(int var1);

   public abstract void setTitle(CharSequence var1);

   public abstract void show();

   interface Callback {
      FragmentManager getSupportFragmentManager();
   }

   @Retention(RetentionPolicy.SOURCE)
   @IntDef(
      flag = true,
      value = {1L, 2L, 4L, 8L, 16L}
   )
   private @interface DisplayOptions {
   }

   public static class LayoutParams extends MarginLayoutParams {
      public int gravity;

      public LayoutParams(int var1) {
         this(-2, -1, var1);
      }

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.gravity = -1;
         this.gravity = 19;
      }

      public LayoutParams(int var1, int var2, int var3) {
         super(var1, var2);
         this.gravity = -1;
         this.gravity = var3;
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         this.gravity = -1;
         TypedArray var3 = var1.obtainStyledAttributes(var2, class_639.styleable.ActionBarLayout);
         this.gravity = var3.getInt(0, -1);
         var3.recycle();
      }

      public LayoutParams(ActionBar.LayoutParams var1) {
         super(var1);
         this.gravity = -1;
         this.gravity = var1.gravity;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
         this.gravity = -1;
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   @IntDef({0L, 1L, 2L})
   private @interface NavigationMode {
   }

   public interface OnMenuVisibilityListener {
      void onMenuVisibilityChanged(boolean var1);
   }

   public interface OnNavigationListener {
      boolean onNavigationItemSelected(int var1, long var2);
   }

   public abstract static class Tab {
      public static final int INVALID_POSITION = -1;

      public abstract CharSequence getContentDescription();

      public abstract View getCustomView();

      public abstract Drawable getIcon();

      public abstract int getPosition();

      public abstract Object getTag();

      public abstract CharSequence getText();

      public abstract void select();

      public abstract ActionBar.Tab setContentDescription(int var1);

      public abstract ActionBar.Tab setContentDescription(CharSequence var1);

      public abstract ActionBar.Tab setCustomView(int var1);

      public abstract ActionBar.Tab setCustomView(View var1);

      public abstract ActionBar.Tab setIcon(int var1);

      public abstract ActionBar.Tab setIcon(Drawable var1);

      public abstract ActionBar.Tab setTabListener(ActionBar.TabListener var1);

      public abstract ActionBar.Tab setTag(Object var1);

      public abstract ActionBar.Tab setText(int var1);

      public abstract ActionBar.Tab setText(CharSequence var1);
   }

   public interface TabListener {
      void onTabReselected(ActionBar.Tab var1, FragmentTransaction var2);

      void onTabSelected(ActionBar.Tab var1, FragmentTransaction var2);

      void onTabUnselected(ActionBar.Tab var1, FragmentTransaction var2);
   }
}
