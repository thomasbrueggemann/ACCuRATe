package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegate;
import android.support.v7.app.ActionBarImplBase;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ProgressBarICS;
import android.support.v7.view.ActionMode;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

class ActionBarActivityDelegateBase extends ActionBarActivityDelegate implements MenuPresenter.Callback, MenuBuilder.Callback {
   private static final int[] ACTION_BAR_DRAWABLE_TOGGLE_ATTRS;
   private static final String TAG = "ActionBarActivityDelegateBase";
   private ActionBarView mActionBarView;
   private ActionMode mActionMode;
   private boolean mClosingActionMenu;
   private boolean mFeatureIndeterminateProgress;
   private boolean mFeatureProgress;
   private ListMenuPresenter mListMenuPresenter;
   private MenuBuilder mMenu;
   private Bundle mPanelFrozenActionViewState;
   private boolean mPanelIsPrepared;
   private boolean mPanelRefreshContent;
   private boolean mSubDecorInstalled;
   private CharSequence mTitleToSet;

   static {
      int[] var0 = new int[]{class_639.attr.homeAsUpIndicator};
      ACTION_BAR_DRAWABLE_TOGGLE_ATTRS = var0;
   }

   ActionBarActivityDelegateBase(ActionBarActivity var1) {
      super(var1);
   }

   private void applyFixedSizeWindow() {
      TypedArray var1 = this.mActivity.obtainStyledAttributes(class_639.styleable.ActionBarWindow);
      boolean var2 = var1.hasValue(3);
      TypedValue var3 = null;
      if(var2) {
         var3 = null;
         if(true) {
            var3 = new TypedValue();
         }

         var1.getValue(3, var3);
      }

      boolean var5 = var1.hasValue(5);
      TypedValue var6 = null;
      if(var5) {
         var6 = null;
         if(true) {
            var6 = new TypedValue();
         }

         var1.getValue(5, var6);
      }

      boolean var8 = var1.hasValue(6);
      TypedValue var9 = null;
      if(var8) {
         var9 = null;
         if(true) {
            var9 = new TypedValue();
         }

         var1.getValue(6, var9);
      }

      boolean var11 = var1.hasValue(4);
      TypedValue var12 = null;
      if(var11) {
         var12 = null;
         if(true) {
            var12 = new TypedValue();
         }

         var1.getValue(4, var12);
      }

      DisplayMetrics var14 = this.mActivity.getResources().getDisplayMetrics();
      boolean var15;
      if(var14.widthPixels < var14.heightPixels) {
         var15 = true;
      } else {
         var15 = false;
      }

      int var16 = -1;
      int var17 = -1;
      TypedValue var18;
      if(var15) {
         var18 = var6;
      } else {
         var18 = var3;
      }

      if(var18 != null && var18.type != 0) {
         if(var18.type == 5) {
            var16 = (int)var18.getDimension(var14);
         } else if(var18.type == 6) {
            var16 = (int)var18.getFraction((float)var14.widthPixels, (float)var14.widthPixels);
         }
      }

      TypedValue var19;
      if(var15) {
         var19 = var9;
      } else {
         var19 = var12;
      }

      if(var19 != null && var19.type != 0) {
         if(var19.type == 5) {
            var17 = (int)var19.getDimension(var14);
         } else if(var19.type == 6) {
            var17 = (int)var19.getFraction((float)var14.heightPixels, (float)var14.heightPixels);
         }
      }

      if(var16 != -1 || var17 != -1) {
         this.mActivity.getWindow().setLayout(var16, var17);
      }

      var1.recycle();
   }

   private ProgressBarICS getCircularProgressBar() {
      ProgressBarICS var1 = (ProgressBarICS)this.mActionBarView.findViewById(class_639.class_981.progress_circular);
      if(var1 != null) {
         var1.setVisibility(4);
      }

      return var1;
   }

   private ProgressBarICS getHorizontalProgressBar() {
      ProgressBarICS var1 = (ProgressBarICS)this.mActionBarView.findViewById(class_639.class_981.progress_horizontal);
      if(var1 != null) {
         var1.setVisibility(4);
      }

      return var1;
   }

   private MenuView getListMenuView(Context var1, MenuPresenter.Callback var2) {
      if(this.mMenu == null) {
         return null;
      } else {
         if(this.mListMenuPresenter == null) {
            TypedArray var3 = var1.obtainStyledAttributes(class_639.styleable.Theme);
            int var4 = var3.getResourceId(4, class_639.style.Theme_AppCompat_CompactMenu);
            var3.recycle();
            this.mListMenuPresenter = new ListMenuPresenter(class_639.layout.abc_list_menu_item_layout, var4);
            this.mListMenuPresenter.setCallback(var2);
            this.mMenu.addMenuPresenter(this.mListMenuPresenter);
         } else {
            this.mListMenuPresenter.updateMenuView(false);
         }

         return this.mListMenuPresenter.getMenuView(new FrameLayout(var1));
      }
   }

   private void hideProgressBars(ProgressBarICS var1, ProgressBarICS var2) {
      if(this.mFeatureIndeterminateProgress && var2.getVisibility() == 0) {
         var2.setVisibility(4);
      }

      if(this.mFeatureProgress && var1.getVisibility() == 0) {
         var1.setVisibility(4);
      }

   }

   private boolean initializePanelMenu() {
      this.mMenu = new MenuBuilder(this.getActionBarThemedContext());
      this.mMenu.setCallback(this);
      return true;
   }

   private boolean preparePanel() {
      if(this.mPanelIsPrepared) {
         return true;
      } else {
         if(this.mMenu == null || this.mPanelRefreshContent) {
            if(this.mMenu == null && (!this.initializePanelMenu() || this.mMenu == null)) {
               return false;
            }

            if(this.mActionBarView != null) {
               this.mActionBarView.setMenu(this.mMenu, this);
            }

            this.mMenu.stopDispatchingItemsChanged();
            if(!this.mActivity.superOnCreatePanelMenu(0, this.mMenu)) {
               this.mMenu = null;
               if(this.mActionBarView != null) {
                  this.mActionBarView.setMenu((SupportMenu)null, this);
               }

               return false;
            }

            this.mPanelRefreshContent = false;
         }

         this.mMenu.stopDispatchingItemsChanged();
         if(this.mPanelFrozenActionViewState != null) {
            this.mMenu.restoreActionViewStates(this.mPanelFrozenActionViewState);
            this.mPanelFrozenActionViewState = null;
         }

         if(!this.mActivity.superOnPreparePanel(0, (View)null, this.mMenu)) {
            if(this.mActionBarView != null) {
               this.mActionBarView.setMenu((SupportMenu)null, this);
            }

            this.mMenu.startDispatchingItemsChanged();
            return false;
         } else {
            this.mMenu.startDispatchingItemsChanged();
            this.mPanelIsPrepared = true;
            return true;
         }
      }
   }

   private void reopenMenu(MenuBuilder var1, boolean var2) {
      if(this.mActionBarView != null && this.mActionBarView.isOverflowReserved()) {
         if(this.mActionBarView.isOverflowMenuShowing() && var2) {
            this.mActionBarView.hideOverflowMenu();
         } else {
            if(this.mActionBarView.getVisibility() == 0) {
               this.mActionBarView.showOverflowMenu();
            }

         }
      } else {
         var1.close();
      }
   }

   private void showProgressBars(ProgressBarICS var1, ProgressBarICS var2) {
      if(this.mFeatureIndeterminateProgress && var2.getVisibility() == 4) {
         var2.setVisibility(0);
      }

      if(this.mFeatureProgress && var1.getProgress() < 10000) {
         var1.setVisibility(0);
      }

   }

   private void updateProgressBars(int var1) {
      ProgressBarICS var2 = this.getCircularProgressBar();
      ProgressBarICS var3 = this.getHorizontalProgressBar();
      if(var1 == -1) {
         if(this.mFeatureProgress) {
            int var4 = var3.getProgress();
            byte var5;
            if(!var3.isIndeterminate() && var4 >= 10000) {
               var5 = 4;
            } else {
               var5 = 0;
            }

            var3.setVisibility(var5);
         }

         if(this.mFeatureIndeterminateProgress) {
            var2.setVisibility(0);
         }
      } else if(var1 == -2) {
         if(this.mFeatureProgress) {
            var3.setVisibility(8);
         }

         if(this.mFeatureIndeterminateProgress) {
            var2.setVisibility(8);
            return;
         }
      } else {
         if(var1 == -3) {
            var3.setIndeterminate(true);
            return;
         }

         if(var1 == -4) {
            var3.setIndeterminate(false);
            return;
         }

         if(var1 >= 0 && var1 <= 10000) {
            var3.setProgress(var1 + 0);
            if(var1 < 10000) {
               this.showProgressBars(var3, var2);
               return;
            }

            this.hideProgressBars(var3, var2);
            return;
         }
      }

   }

   public void addContentView(View var1, LayoutParams var2) {
      this.ensureSubDecor();
      ((ViewGroup)this.mActivity.findViewById(16908290)).addView(var1, var2);
      this.mActivity.onSupportContentChanged();
   }

   public ActionBar createSupportActionBar() {
      this.ensureSubDecor();
      return new ActionBarImplBase(this.mActivity, this.mActivity);
   }

   final void ensureSubDecor() {
      if(!this.mSubDecorInstalled) {
         if(this.mHasActionBar) {
            if(this.mOverlayActionBar) {
               this.mActivity.superSetContentView(class_639.layout.abc_action_bar_decor_overlay);
            } else {
               this.mActivity.superSetContentView(class_639.layout.abc_action_bar_decor);
            }

            this.mActionBarView = (ActionBarView)this.mActivity.findViewById(class_639.class_981.action_bar);
            this.mActionBarView.setWindowCallback(this.mActivity);
            if(this.mFeatureProgress) {
               this.mActionBarView.initProgress();
            }

            if(this.mFeatureIndeterminateProgress) {
               this.mActionBarView.initIndeterminateProgress();
            }

            boolean var2 = "splitActionBarWhenNarrow".equals(this.getUiOptionsFromMetadata());
            boolean var4;
            if(var2) {
               var4 = this.mActivity.getResources().getBoolean(class_639.bool.abc_split_action_bar_is_narrow);
            } else {
               TypedArray var3 = this.mActivity.obtainStyledAttributes(class_639.styleable.ActionBarWindow);
               var4 = var3.getBoolean(2, false);
               var3.recycle();
            }

            ActionBarContainer var5 = (ActionBarContainer)this.mActivity.findViewById(class_639.class_981.split_action_bar);
            if(var5 != null) {
               this.mActionBarView.setSplitView(var5);
               this.mActionBarView.setSplitActionBar(var4);
               this.mActionBarView.setSplitWhenNarrow(var2);
               ActionBarContextView var6 = (ActionBarContextView)this.mActivity.findViewById(class_639.class_981.action_context_bar);
               var6.setSplitView(var5);
               var6.setSplitActionBar(var4);
               var6.setSplitWhenNarrow(var2);
            }
         } else {
            this.mActivity.superSetContentView(class_639.layout.abc_simple_decor);
         }

         this.mActivity.findViewById(16908290).setId(-1);
         this.mActivity.findViewById(class_639.class_981.action_bar_activity_content).setId(16908290);
         if(this.mTitleToSet != null) {
            this.mActionBarView.setWindowTitle(this.mTitleToSet);
            this.mTitleToSet = null;
         }

         this.applyFixedSizeWindow();
         this.mSubDecorInstalled = true;
         this.mActivity.getWindow().getDecorView().post(new Runnable() {
            public void run() {
               ActionBarActivityDelegateBase.this.supportInvalidateOptionsMenu();
            }
         });
      }

   }

   int getHomeAsUpIndicatorAttrId() {
      return class_639.attr.homeAsUpIndicator;
   }

   public boolean onBackPressed() {
      if(this.mActionMode != null) {
         this.mActionMode.finish();
         return true;
      } else if(this.mActionBarView != null && this.mActionBarView.hasExpandedActionView()) {
         this.mActionBarView.collapseActionView();
         return true;
      } else {
         return false;
      }
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(!this.mClosingActionMenu) {
         this.mClosingActionMenu = true;
         this.mActivity.closeOptionsMenu();
         this.mActionBarView.dismissPopupMenus();
         this.mClosingActionMenu = false;
      }
   }

   public void onConfigurationChanged(Configuration var1) {
      if(this.mHasActionBar && this.mSubDecorInstalled) {
         ((ActionBarImplBase)this.getSupportActionBar()).onConfigurationChanged(var1);
      }

   }

   public void onContentChanged() {
   }

   public boolean onCreatePanelMenu(int var1, Menu var2) {
      return var1 != 0?this.mActivity.superOnCreatePanelMenu(var1, var2):false;
   }

   public View onCreatePanelView(int var1) {
      View var2 = null;
      if(var1 == 0) {
         boolean var3 = this.preparePanel();
         var2 = null;
         if(var3) {
            var2 = (View)this.getListMenuView(this.mActivity, this);
         }
      }

      return var2;
   }

   public boolean onMenuItemSelected(int var1, MenuItem var2) {
      if(var1 == 0) {
         var2 = MenuWrapperFactory.createMenuItemWrapper(var2);
      }

      return this.mActivity.superOnMenuItemSelected(var1, var2);
   }

   public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
      return this.mActivity.onMenuItemSelected(0, var2);
   }

   public void onMenuModeChange(MenuBuilder var1) {
      this.reopenMenu(var1, true);
   }

   public boolean onOpenSubMenu(MenuBuilder var1) {
      return false;
   }

   public void onPostResume() {
      ActionBarImplBase var1 = (ActionBarImplBase)this.getSupportActionBar();
      if(var1 != null) {
         var1.setShowHideAnimationEnabled(true);
      }

   }

   public boolean onPreparePanel(int var1, View var2, Menu var3) {
      return var1 != 0?this.mActivity.superOnPreparePanel(var1, var2, var3):false;
   }

   public void onStop() {
      ActionBarImplBase var1 = (ActionBarImplBase)this.getSupportActionBar();
      if(var1 != null) {
         var1.setShowHideAnimationEnabled(false);
      }

   }

   public void onTitleChanged(CharSequence var1) {
      if(this.mActionBarView != null) {
         this.mActionBarView.setWindowTitle(var1);
      } else {
         this.mTitleToSet = var1;
      }
   }

   public void setContentView(int var1) {
      this.ensureSubDecor();
      ViewGroup var2 = (ViewGroup)this.mActivity.findViewById(16908290);
      var2.removeAllViews();
      this.mActivity.getLayoutInflater().inflate(var1, var2);
      this.mActivity.onSupportContentChanged();
   }

   public void setContentView(View var1) {
      this.ensureSubDecor();
      ViewGroup var2 = (ViewGroup)this.mActivity.findViewById(16908290);
      var2.removeAllViews();
      var2.addView(var1);
      this.mActivity.onSupportContentChanged();
   }

   public void setContentView(View var1, LayoutParams var2) {
      this.ensureSubDecor();
      ViewGroup var3 = (ViewGroup)this.mActivity.findViewById(16908290);
      var3.removeAllViews();
      var3.addView(var1, var2);
      this.mActivity.onSupportContentChanged();
   }

   void setSupportProgress(int var1) {
      this.updateProgressBars(var1 + 0);
   }

   void setSupportProgressBarIndeterminate(boolean var1) {
      byte var2;
      if(var1) {
         var2 = -3;
      } else {
         var2 = -4;
      }

      this.updateProgressBars(var2);
   }

   void setSupportProgressBarIndeterminateVisibility(boolean var1) {
      byte var2;
      if(var1) {
         var2 = -1;
      } else {
         var2 = -2;
      }

      this.updateProgressBars(var2);
   }

   void setSupportProgressBarVisibility(boolean var1) {
      byte var2;
      if(var1) {
         var2 = -1;
      } else {
         var2 = -2;
      }

      this.updateProgressBars(var2);
   }

   public ActionMode startSupportActionMode(ActionMode.Callback var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("ActionMode callback can not be null.");
      } else {
         if(this.mActionMode != null) {
            this.mActionMode.finish();
         }

         ActionBarActivityDelegateBase.ActionModeCallbackWrapper var2 = new ActionBarActivityDelegateBase.ActionModeCallbackWrapper(var1);
         ActionBarImplBase var3 = (ActionBarImplBase)this.getSupportActionBar();
         if(var3 != null) {
            this.mActionMode = var3.startActionMode(var2);
         }

         if(this.mActionMode != null) {
            this.mActivity.onSupportActionModeStarted(this.mActionMode);
         }

         return this.mActionMode;
      }
   }

   public void supportInvalidateOptionsMenu() {
      if(this.mMenu != null) {
         Bundle var1 = new Bundle();
         this.mMenu.saveActionViewStates(var1);
         if(var1.size() > 0) {
            this.mPanelFrozenActionViewState = var1;
         }

         this.mMenu.stopDispatchingItemsChanged();
         this.mMenu.clear();
      }

      this.mPanelRefreshContent = true;
      if(this.mActionBarView != null) {
         this.mPanelIsPrepared = false;
         this.preparePanel();
      }

   }

   public boolean supportRequestWindowFeature(int var1) {
      switch(var1) {
      case 2:
         this.mFeatureProgress = true;
         return true;
      case 3:
      case 4:
      case 6:
      case 7:
      default:
         return this.mActivity.requestWindowFeature(var1);
      case 5:
         this.mFeatureIndeterminateProgress = true;
         return true;
      case 8:
         this.mHasActionBar = true;
         return true;
      case 9:
         this.mOverlayActionBar = true;
         return true;
      }
   }

   private class ActionModeCallbackWrapper implements ActionMode.Callback {
      private ActionMode.Callback mWrapped;

      public ActionModeCallbackWrapper(ActionMode.Callback var2) {
         this.mWrapped = var2;
      }

      public boolean onActionItemClicked(ActionMode var1, MenuItem var2) {
         return this.mWrapped.onActionItemClicked(var1, var2);
      }

      public boolean onCreateActionMode(ActionMode var1, Menu var2) {
         return this.mWrapped.onCreateActionMode(var1, var2);
      }

      public void onDestroyActionMode(ActionMode var1) {
         this.mWrapped.onDestroyActionMode(var1);
         ActionBarActivityDelegateBase.this.mActivity.onSupportActionModeFinished(var1);
         ActionBarActivityDelegateBase.this.mActionMode = null;
      }

      public boolean onPrepareActionMode(ActionMode var1, Menu var2) {
         return this.mWrapped.onPrepareActionMode(var1, var2);
      }
   }
}
