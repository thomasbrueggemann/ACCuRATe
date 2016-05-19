package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class AppCompatDelegateImplBase extends AppCompatDelegate {
   ActionBar mActionBar;
   final AppCompatCallback mAppCompatCallback;
   final Callback mAppCompatWindowCallback;
   final Context mContext;
   boolean mHasActionBar;
   private boolean mIsDestroyed;
   boolean mIsFloating;
   MenuInflater mMenuInflater;
   final Callback mOriginalWindowCallback;
   boolean mOverlayActionBar;
   boolean mOverlayActionMode;
   boolean mThemeRead;
   private CharSequence mTitle;
   final Window mWindow;
   boolean mWindowNoTitle;

   AppCompatDelegateImplBase(Context var1, Window var2, AppCompatCallback var3) {
      this.mContext = var1;
      this.mWindow = var2;
      this.mAppCompatCallback = var3;
      this.mOriginalWindowCallback = this.mWindow.getCallback();
      if(this.mOriginalWindowCallback instanceof AppCompatDelegateImplBase.AppCompatWindowCallbackBase) {
         throw new IllegalStateException("AppCompat has already installed itself into the Window");
      } else {
         this.mAppCompatWindowCallback = this.wrapWindowCallback(this.mOriginalWindowCallback);
         this.mWindow.setCallback(this.mAppCompatWindowCallback);
      }
   }

   public boolean applyDayNight() {
      return false;
   }

   abstract boolean dispatchKeyEvent(KeyEvent var1);

   final Context getActionBarThemedContext() {
      ActionBar var1 = this.getSupportActionBar();
      Context var2 = null;
      if(var1 != null) {
         var2 = var1.getThemedContext();
      }

      if(var2 == null) {
         var2 = this.mContext;
      }

      return var2;
   }

   public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
      return new AppCompatDelegateImplBase.ActionBarDrawableToggleImpl();
   }

   public MenuInflater getMenuInflater() {
      if(this.mMenuInflater == null) {
         this.initWindowDecorActionBar();
         Context var1;
         if(this.mActionBar != null) {
            var1 = this.mActionBar.getThemedContext();
         } else {
            var1 = this.mContext;
         }

         this.mMenuInflater = new SupportMenuInflater(var1);
      }

      return this.mMenuInflater;
   }

   public ActionBar getSupportActionBar() {
      this.initWindowDecorActionBar();
      return this.mActionBar;
   }

   final CharSequence getTitle() {
      return this.mOriginalWindowCallback instanceof Activity?((Activity)this.mOriginalWindowCallback).getTitle():this.mTitle;
   }

   final Callback getWindowCallback() {
      return this.mWindow.getCallback();
   }

   abstract void initWindowDecorActionBar();

   final boolean isDestroyed() {
      return this.mIsDestroyed;
   }

   public boolean isHandleNativeActionModesEnabled() {
      return false;
   }

   public void onDestroy() {
      this.mIsDestroyed = true;
   }

   abstract boolean onKeyShortcut(int var1, KeyEvent var2);

   abstract boolean onMenuOpened(int var1, Menu var2);

   abstract void onPanelClosed(int var1, Menu var2);

   public void onSaveInstanceState(Bundle var1) {
   }

   abstract void onTitleChanged(CharSequence var1);

   final ActionBar peekSupportActionBar() {
      return this.mActionBar;
   }

   public void setHandleNativeActionModesEnabled(boolean var1) {
   }

   public void setLocalNightMode(int var1) {
   }

   public final void setTitle(CharSequence var1) {
      this.mTitle = var1;
      this.onTitleChanged(var1);
   }

   abstract ActionMode startSupportActionModeFromWindow(ActionMode.Callback var1);

   Callback wrapWindowCallback(Callback var1) {
      return new AppCompatDelegateImplBase.AppCompatWindowCallbackBase(var1);
   }

   private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
      private ActionBarDrawableToggleImpl() {
      }

      // $FF: synthetic method
      ActionBarDrawableToggleImpl(Object var2) {
         this();
      }

      public Context getActionBarThemedContext() {
         return AppCompatDelegateImplBase.this.getActionBarThemedContext();
      }

      public Drawable getThemeUpIndicator() {
         Context var1 = this.getActionBarThemedContext();
         int[] var2 = new int[]{class_22.attr.homeAsUpIndicator};
         TintTypedArray var3 = TintTypedArray.obtainStyledAttributes(var1, (AttributeSet)null, var2);
         Drawable var4 = var3.getDrawable(0);
         var3.recycle();
         return var4;
      }

      public boolean isNavigationVisible() {
         ActionBar var1 = AppCompatDelegateImplBase.this.getSupportActionBar();
         return var1 != null && (4 & var1.getDisplayOptions()) != 0;
      }

      public void setActionBarDescription(int var1) {
         ActionBar var2 = AppCompatDelegateImplBase.this.getSupportActionBar();
         if(var2 != null) {
            var2.setHomeActionContentDescription(var1);
         }

      }

      public void setActionBarUpIndicator(Drawable var1, int var2) {
         ActionBar var3 = AppCompatDelegateImplBase.this.getSupportActionBar();
         if(var3 != null) {
            var3.setHomeAsUpIndicator(var1);
            var3.setHomeActionContentDescription(var2);
         }

      }
   }

   class AppCompatWindowCallbackBase extends WindowCallbackWrapper {
      AppCompatWindowCallbackBase(Callback var2) {
         super(var2);
      }

      public boolean dispatchKeyEvent(KeyEvent var1) {
         return AppCompatDelegateImplBase.this.dispatchKeyEvent(var1) || super.dispatchKeyEvent(var1);
      }

      public boolean dispatchKeyShortcutEvent(KeyEvent var1) {
         return super.dispatchKeyShortcutEvent(var1) || AppCompatDelegateImplBase.this.onKeyShortcut(var1.getKeyCode(), var1);
      }

      public void onContentChanged() {
      }

      public boolean onCreatePanelMenu(int var1, Menu var2) {
         return var1 == 0 && !(var2 instanceof MenuBuilder)?false:super.onCreatePanelMenu(var1, var2);
      }

      public boolean onMenuOpened(int var1, Menu var2) {
         super.onMenuOpened(var1, var2);
         AppCompatDelegateImplBase.this.onMenuOpened(var1, var2);
         return true;
      }

      public void onPanelClosed(int var1, Menu var2) {
         super.onPanelClosed(var1, var2);
         AppCompatDelegateImplBase.this.onPanelClosed(var1, var2);
      }

      public boolean onPreparePanel(int var1, View var2, Menu var3) {
         MenuBuilder var4;
         if(var3 instanceof MenuBuilder) {
            var4 = (MenuBuilder)var3;
         } else {
            var4 = null;
         }

         boolean var5;
         if(var1 == 0 && var4 == null) {
            var5 = false;
         } else {
            if(var4 != null) {
               var4.setOverrideVisibleItems(true);
            }

            var5 = super.onPreparePanel(var1, var2, var3);
            if(var4 != null) {
               var4.setOverrideVisibleItems(false);
               return var5;
            }
         }

         return var5;
      }
   }
}
