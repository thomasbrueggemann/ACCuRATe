package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegate;
import android.support.v7.app.ActionBarImplICS;
import android.support.v7.internal.view.ActionModeWrapper;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.view.accessibility.AccessibilityEvent;

class ActionBarActivityDelegateICS extends ActionBarActivityDelegate {
   Menu mMenu;

   ActionBarActivityDelegateICS(ActionBarActivity var1) {
      super(var1);
   }

   public void addContentView(View var1, LayoutParams var2) {
      this.mActivity.superAddContentView(var1, var2);
   }

   ActionModeWrapper.CallbackWrapper createActionModeCallbackWrapper(Context var1, ActionMode.Callback var2) {
      return new ActionModeWrapper.CallbackWrapper(var1, var2);
   }

   ActionModeWrapper createActionModeWrapper(Context var1, android.view.ActionMode var2) {
      return new ActionModeWrapper(var1, var2);
   }

   public ActionBar createSupportActionBar() {
      return new ActionBarImplICS(this.mActivity, this.mActivity);
   }

   Callback createWindowCallbackWrapper(Callback var1) {
      return new ActionBarActivityDelegateICS.WindowCallbackWrapper(var1);
   }

   int getHomeAsUpIndicatorAttrId() {
      return 16843531;
   }

   public void onActionModeFinished(android.view.ActionMode var1) {
      this.mActivity.onSupportActionModeFinished(this.createActionModeWrapper(this.getActionBarThemedContext(), var1));
   }

   public void onActionModeStarted(android.view.ActionMode var1) {
      this.mActivity.onSupportActionModeStarted(this.createActionModeWrapper(this.getActionBarThemedContext(), var1));
   }

   public boolean onBackPressed() {
      return false;
   }

   public void onConfigurationChanged(Configuration var1) {
   }

   public void onContentChanged() {
      this.mActivity.onSupportContentChanged();
   }

   public void onCreate(Bundle var1) {
      if("splitActionBarWhenNarrow".equals(this.getUiOptionsFromMetadata())) {
         this.mActivity.getWindow().setUiOptions(1, 1);
      }

      super.onCreate(var1);
      if(this.mHasActionBar) {
         this.mActivity.requestWindowFeature(8);
      }

      if(this.mOverlayActionBar) {
         this.mActivity.requestWindowFeature(9);
      }

      Window var2 = this.mActivity.getWindow();
      var2.setCallback(this.createWindowCallbackWrapper(var2.getCallback()));
   }

   public boolean onCreatePanelMenu(int var1, Menu var2) {
      if(var1 != 0 && var1 != 8) {
         return this.mActivity.superOnCreatePanelMenu(var1, var2);
      } else {
         if(this.mMenu == null) {
            this.mMenu = MenuWrapperFactory.createMenuWrapper(var2);
         }

         return this.mActivity.superOnCreatePanelMenu(var1, this.mMenu);
      }
   }

   public View onCreatePanelView(int var1) {
      return null;
   }

   public boolean onMenuItemSelected(int var1, MenuItem var2) {
      if(var1 == 0) {
         var2 = MenuWrapperFactory.createMenuItemWrapper(var2);
      }

      return this.mActivity.superOnMenuItemSelected(var1, var2);
   }

   public void onPostResume() {
   }

   public boolean onPreparePanel(int var1, View var2, Menu var3) {
      return var1 != 0 && var1 != 8?this.mActivity.superOnPreparePanel(var1, var2, var3):this.mActivity.superOnPreparePanel(var1, var2, this.mMenu);
   }

   public void onStop() {
   }

   public void onTitleChanged(CharSequence var1) {
   }

   public void setContentView(int var1) {
      this.mActivity.superSetContentView(var1);
   }

   public void setContentView(View var1) {
      this.mActivity.superSetContentView(var1);
   }

   public void setContentView(View var1, LayoutParams var2) {
      this.mActivity.superSetContentView(var1, var2);
   }

   void setSupportProgress(int var1) {
      this.mActivity.setProgress(var1);
   }

   void setSupportProgressBarIndeterminate(boolean var1) {
      this.mActivity.setProgressBarIndeterminate(var1);
   }

   void setSupportProgressBarIndeterminateVisibility(boolean var1) {
      this.mActivity.setProgressBarIndeterminateVisibility(var1);
   }

   void setSupportProgressBarVisibility(boolean var1) {
      this.mActivity.setProgressBarVisibility(var1);
   }

   public ActionMode startSupportActionMode(ActionMode.Callback var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("ActionMode callback can not be null.");
      } else {
         Context var2 = this.getActionBarThemedContext();
         ActionModeWrapper.CallbackWrapper var3 = this.createActionModeCallbackWrapper(var2, var1);
         android.view.ActionMode var4 = this.mActivity.startActionMode(var3);
         ActionModeWrapper var5 = null;
         if(var4 != null) {
            var5 = this.createActionModeWrapper(var2, var4);
            var3.setLastStartedActionMode(var5);
         }

         return var5;
      }
   }

   public void supportInvalidateOptionsMenu() {
      this.mMenu = null;
   }

   public boolean supportRequestWindowFeature(int var1) {
      return this.mActivity.requestWindowFeature(var1);
   }

   class WindowCallbackWrapper implements Callback {
      final Callback mWrapped;

      public WindowCallbackWrapper(Callback var2) {
         this.mWrapped = var2;
      }

      public boolean dispatchGenericMotionEvent(MotionEvent var1) {
         return this.mWrapped.dispatchGenericMotionEvent(var1);
      }

      public boolean dispatchKeyEvent(KeyEvent var1) {
         return this.mWrapped.dispatchKeyEvent(var1);
      }

      public boolean dispatchKeyShortcutEvent(KeyEvent var1) {
         return this.mWrapped.dispatchKeyShortcutEvent(var1);
      }

      public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
         return this.mWrapped.dispatchPopulateAccessibilityEvent(var1);
      }

      public boolean dispatchTouchEvent(MotionEvent var1) {
         return this.mWrapped.dispatchTouchEvent(var1);
      }

      public boolean dispatchTrackballEvent(MotionEvent var1) {
         return this.mWrapped.dispatchTrackballEvent(var1);
      }

      public void onActionModeFinished(android.view.ActionMode var1) {
         this.mWrapped.onActionModeFinished(var1);
         ActionBarActivityDelegateICS.this.onActionModeFinished(var1);
      }

      public void onActionModeStarted(android.view.ActionMode var1) {
         this.mWrapped.onActionModeStarted(var1);
         ActionBarActivityDelegateICS.this.onActionModeStarted(var1);
      }

      public void onAttachedToWindow() {
         this.mWrapped.onAttachedToWindow();
      }

      public void onContentChanged() {
         this.mWrapped.onContentChanged();
      }

      public boolean onCreatePanelMenu(int var1, Menu var2) {
         return this.mWrapped.onCreatePanelMenu(var1, var2);
      }

      public View onCreatePanelView(int var1) {
         return this.mWrapped.onCreatePanelView(var1);
      }

      public void onDetachedFromWindow() {
         this.mWrapped.onDetachedFromWindow();
      }

      public boolean onMenuItemSelected(int var1, MenuItem var2) {
         return this.mWrapped.onMenuItemSelected(var1, var2);
      }

      public boolean onMenuOpened(int var1, Menu var2) {
         return this.mWrapped.onMenuOpened(var1, var2);
      }

      public void onPanelClosed(int var1, Menu var2) {
         this.mWrapped.onPanelClosed(var1, var2);
      }

      public boolean onPreparePanel(int var1, View var2, Menu var3) {
         return this.mWrapped.onPreparePanel(var1, var2, var3);
      }

      public boolean onSearchRequested() {
         return this.mWrapped.onSearchRequested();
      }

      public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams var1) {
         this.mWrapped.onWindowAttributesChanged(var1);
      }

      public void onWindowFocusChanged(boolean var1) {
         this.mWrapped.onWindowFocusChanged(var1);
      }

      public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1) {
         return this.mWrapped.onWindowStartingActionMode(var1);
      }
   }
}
