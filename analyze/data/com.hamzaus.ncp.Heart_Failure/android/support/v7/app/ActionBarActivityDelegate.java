package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateApi20;
import android.support.v7.app.ActionBarActivityDelegateBase;
import android.support.v7.app.ActionBarActivityDelegateHC;
import android.support.v7.app.ActionBarActivityDelegateICS;
import android.support.v7.app.ActionBarActivityDelegateJB;
import android.support.v7.app.ActionBarActivityDelegateJBMR2;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

abstract class ActionBarActivityDelegate {
   static final String METADATA_UI_OPTIONS = "android.support.UI_OPTIONS";
   private static final String TAG = "ActionBarActivityDelegate";
   static final String UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = "splitActionBarWhenNarrow";
   private ActionBar mActionBar;
   final ActionBarActivity mActivity;
   private boolean mEnableDefaultActionBarUp;
   boolean mHasActionBar;
   private MenuInflater mMenuInflater;
   boolean mOverlayActionBar;

   ActionBarActivityDelegate(ActionBarActivity var1) {
      this.mActivity = var1;
   }

   static ActionBarActivityDelegate createDelegate(ActionBarActivity var0) {
      return (ActionBarActivityDelegate)(VERSION.SDK_INT >= 20?new ActionBarActivityDelegateApi20(var0):(VERSION.SDK_INT >= 18?new ActionBarActivityDelegateJBMR2(var0):(VERSION.SDK_INT >= 16?new ActionBarActivityDelegateJB(var0):(VERSION.SDK_INT >= 14?new ActionBarActivityDelegateICS(var0):(VERSION.SDK_INT >= 11?new ActionBarActivityDelegateHC(var0):new ActionBarActivityDelegateBase(var0))))));
   }

   abstract void addContentView(View var1, LayoutParams var2);

   abstract ActionBar createSupportActionBar();

   protected final Context getActionBarThemedContext() {
      Object var1 = this.mActivity;
      ActionBar var2 = this.getSupportActionBar();
      if(var2 != null) {
         var1 = var2.getThemedContext();
      }

      return (Context)var1;
   }

   final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
      return new ActionBarActivityDelegate.ActionBarDrawableToggleImpl();
   }

   abstract int getHomeAsUpIndicatorAttrId();

   MenuInflater getMenuInflater() {
      if(this.mMenuInflater == null) {
         this.mMenuInflater = new SupportMenuInflater(this.getActionBarThemedContext());
      }

      return this.mMenuInflater;
   }

   final ActionBar getSupportActionBar() {
      if(!this.mHasActionBar && !this.mOverlayActionBar) {
         this.mActionBar = null;
      } else if(this.mActionBar == null) {
         this.mActionBar = this.createSupportActionBar();
         if(this.mEnableDefaultActionBarUp) {
            this.mActionBar.setDisplayHomeAsUpEnabled(true);
         }
      }

      return this.mActionBar;
   }

   protected final String getUiOptionsFromMetadata() {
      // $FF: Couldn't be decompiled
   }

   abstract boolean onBackPressed();

   abstract void onConfigurationChanged(Configuration var1);

   abstract void onContentChanged();

   void onCreate(Bundle var1) {
      TypedArray var2 = this.mActivity.obtainStyledAttributes(class_639.styleable.ActionBarWindow);
      if(!var2.hasValue(0)) {
         var2.recycle();
         throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      } else {
         this.mHasActionBar = var2.getBoolean(0, false);
         this.mOverlayActionBar = var2.getBoolean(1, false);
         var2.recycle();
         if(NavUtils.getParentActivityName(this.mActivity) != null) {
            if(this.mActionBar != null) {
               this.mActionBar.setDisplayHomeAsUpEnabled(true);
               return;
            }

            this.mEnableDefaultActionBarUp = true;
         }

      }
   }

   abstract boolean onCreatePanelMenu(int var1, Menu var2);

   abstract View onCreatePanelView(int var1);

   abstract boolean onMenuItemSelected(int var1, MenuItem var2);

   abstract void onPostResume();

   boolean onPrepareOptionsPanel(View var1, Menu var2) {
      return VERSION.SDK_INT < 16?this.mActivity.onPrepareOptionsMenu(var2):this.mActivity.superOnPrepareOptionsPanel(var1, var2);
   }

   abstract boolean onPreparePanel(int var1, View var2, Menu var3);

   abstract void onStop();

   abstract void onTitleChanged(CharSequence var1);

   abstract void setContentView(int var1);

   abstract void setContentView(View var1);

   abstract void setContentView(View var1, LayoutParams var2);

   abstract void setSupportProgress(int var1);

   abstract void setSupportProgressBarIndeterminate(boolean var1);

   abstract void setSupportProgressBarIndeterminateVisibility(boolean var1);

   abstract void setSupportProgressBarVisibility(boolean var1);

   abstract ActionMode startSupportActionMode(ActionMode.Callback var1);

   abstract void supportInvalidateOptionsMenu();

   abstract boolean supportRequestWindowFeature(int var1);

   private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
      private ActionBarDrawableToggleImpl() {
      }

      // $FF: synthetic method
      ActionBarDrawableToggleImpl(Object var2) {
         this();
      }

      public Drawable getThemeUpIndicator() {
         ActionBarActivity var1 = ActionBarActivityDelegate.this.mActivity;
         int[] var2 = new int[]{ActionBarActivityDelegate.this.getHomeAsUpIndicatorAttrId()};
         TypedArray var3 = var1.obtainStyledAttributes(var2);
         Drawable var4 = var3.getDrawable(0);
         var3.recycle();
         return var4;
      }

      public void setActionBarDescription(int var1) {
         ActionBar var2 = ActionBarActivityDelegate.this.getSupportActionBar();
         if(var2 != null) {
            var2.setHomeActionContentDescription(var1);
         }

      }

      public void setActionBarUpIndicator(Drawable var1, int var2) {
         ActionBar var3 = ActionBarActivityDelegate.this.getSupportActionBar();
         if(var3 != null) {
            var3.setHomeAsUpIndicator(var1);
            var3.setHomeActionContentDescription(var2);
         }

      }
   }
}
