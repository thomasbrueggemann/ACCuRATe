package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.view.ActionMode;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ActionBarImplBase extends ActionBar {
   private static final int CONTEXT_DISPLAY_NORMAL = 0;
   private static final int CONTEXT_DISPLAY_SPLIT = 1;
   private static final int INVALID_POSITION = -1;
   ActionBarImplBase.ActionModeImpl mActionMode;
   private ActionBarView mActionView;
   private ActionBarActivity mActivity;
   private ActionBar.Callback mCallback;
   private ActionBarContainer mContainerView;
   private View mContentView;
   private Context mContext;
   private int mContextDisplayMode;
   private ActionBarContextView mContextView;
   private int mCurWindowVisibility = 0;
   ActionMode mDeferredDestroyActionMode;
   ActionMode.Callback mDeferredModeDestroyCallback;
   private Dialog mDialog;
   private boolean mDisplayHomeAsUpSet;
   final Handler mHandler = new Handler();
   private boolean mHasEmbeddedTabs;
   private boolean mHiddenByApp;
   private boolean mHiddenBySystem;
   private boolean mLastMenuVisibility;
   private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
   private boolean mNowShowing = true;
   private ActionBarOverlayLayout mOverlayLayout;
   private int mSavedTabPosition = -1;
   private ActionBarImplBase.TabImpl mSelectedTab;
   private boolean mShowHideAnimationEnabled;
   private boolean mShowingForMode;
   private ActionBarContainer mSplitView;
   private ScrollingTabContainerView mTabScrollView;
   Runnable mTabSelector;
   private ArrayList<ActionBarImplBase.TabImpl> mTabs = new ArrayList();
   private Context mThemedContext;
   private ViewGroup mTopVisibilityView;

   public ActionBarImplBase(ActionBarActivity var1, ActionBar.Callback var2) {
      this.mActivity = var1;
      this.mContext = var1;
      this.mCallback = var2;
      this.init(this.mActivity);
   }

   private static boolean checkShowingFlags(boolean var0, boolean var1, boolean var2) {
      return var2 || !var0 && !var1;
   }

   private void cleanupTabs() {
      if(this.mSelectedTab != null) {
         this.selectTab((ActionBar.Tab)null);
      }

      this.mTabs.clear();
      if(this.mTabScrollView != null) {
         this.mTabScrollView.removeAllTabs();
      }

      this.mSavedTabPosition = -1;
   }

   private void configureTab(ActionBar.Tab var1, int var2) {
      ActionBarImplBase.TabImpl var3 = (ActionBarImplBase.TabImpl)var1;
      if(var3.getCallback() == null) {
         throw new IllegalStateException("Action Bar Tab must have a Callback");
      } else {
         var3.setPosition(var2);
         this.mTabs.add(var2, var3);
         int var4 = this.mTabs.size();

         for(int var5 = var2 + 1; var5 < var4; ++var5) {
            ((ActionBarImplBase.TabImpl)this.mTabs.get(var5)).setPosition(var5);
         }

      }
   }

   private void ensureTabsExist() {
      if(this.mTabScrollView == null) {
         ScrollingTabContainerView var1 = new ScrollingTabContainerView(this.mContext);
         if(this.mHasEmbeddedTabs) {
            var1.setVisibility(0);
            this.mActionView.setEmbeddedTabView(var1);
         } else {
            if(this.getNavigationMode() == 2) {
               var1.setVisibility(0);
            } else {
               var1.setVisibility(8);
            }

            this.mContainerView.setTabContainer(var1);
         }

         this.mTabScrollView = var1;
      }
   }

   private void init(ActionBarActivity var1) {
      this.mOverlayLayout = (ActionBarOverlayLayout)var1.findViewById(class_639.class_981.action_bar_overlay_layout);
      if(this.mOverlayLayout != null) {
         this.mOverlayLayout.setActionBar(this);
      }

      this.mActionView = (ActionBarView)var1.findViewById(class_639.class_981.action_bar);
      this.mContextView = (ActionBarContextView)var1.findViewById(class_639.class_981.action_context_bar);
      this.mContainerView = (ActionBarContainer)var1.findViewById(class_639.class_981.action_bar_container);
      this.mTopVisibilityView = (ViewGroup)var1.findViewById(class_639.class_981.top_action_bar);
      if(this.mTopVisibilityView == null) {
         this.mTopVisibilityView = this.mContainerView;
      }

      this.mSplitView = (ActionBarContainer)var1.findViewById(class_639.class_981.split_action_bar);
      if(this.mActionView != null && this.mContextView != null && this.mContainerView != null) {
         this.mActionView.setContextView(this.mContextView);
         byte var2;
         if(this.mActionView.isSplitActionBar()) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         this.mContextDisplayMode = var2;
         boolean var3;
         if((4 & this.mActionView.getDisplayOptions()) != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var3) {
            this.mDisplayHomeAsUpSet = true;
         }

         ActionBarPolicy var4;
         boolean var5;
         label33: {
            var4 = ActionBarPolicy.get(this.mContext);
            if(!var4.enableHomeButtonByDefault()) {
               var5 = false;
               if(!var3) {
                  break label33;
               }
            }

            var5 = true;
         }

         this.setHomeButtonEnabled(var5);
         this.setHasEmbeddedTabs(var4.hasEmbeddedTabs());
         this.setTitle(this.mActivity.getTitle());
      } else {
         throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
      }
   }

   private void setHasEmbeddedTabs(boolean var1) {
      boolean var2 = true;
      this.mHasEmbeddedTabs = var1;
      if(!this.mHasEmbeddedTabs) {
         this.mActionView.setEmbeddedTabView((ScrollingTabContainerView)null);
         this.mContainerView.setTabContainer(this.mTabScrollView);
      } else {
         this.mContainerView.setTabContainer((ScrollingTabContainerView)null);
         this.mActionView.setEmbeddedTabView(this.mTabScrollView);
      }

      boolean var3;
      if(this.getNavigationMode() == 2) {
         var3 = var2;
      } else {
         var3 = false;
      }

      if(this.mTabScrollView != null) {
         if(var3) {
            this.mTabScrollView.setVisibility(0);
         } else {
            this.mTabScrollView.setVisibility(8);
         }
      }

      ActionBarView var4 = this.mActionView;
      if(this.mHasEmbeddedTabs || !var3) {
         var2 = false;
      }

      var4.setCollapsable(var2);
   }

   private void updateVisibility(boolean var1) {
      if(checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
         if(!this.mNowShowing) {
            this.mNowShowing = true;
            this.doShow(var1);
         }
      } else if(this.mNowShowing) {
         this.mNowShowing = false;
         this.doHide(var1);
         return;
      }

   }

   public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1) {
      this.mMenuVisibilityListeners.add(var1);
   }

   public void addTab(ActionBar.Tab var1) {
      this.addTab(var1, this.mTabs.isEmpty());
   }

   public void addTab(ActionBar.Tab var1, int var2) {
      this.addTab(var1, var2, this.mTabs.isEmpty());
   }

   public void addTab(ActionBar.Tab var1, int var2, boolean var3) {
      this.ensureTabsExist();
      this.mTabScrollView.addTab(var1, var2, var3);
      this.configureTab(var1, var2);
      if(var3) {
         this.selectTab(var1);
      }

   }

   public void addTab(ActionBar.Tab var1, boolean var2) {
      this.ensureTabsExist();
      this.mTabScrollView.addTab(var1, var2);
      this.configureTab(var1, this.mTabs.size());
      if(var2) {
         this.selectTab(var1);
      }

   }

   void animateToMode(boolean var1) {
      byte var2 = 8;
      if(var1) {
         this.showForActionMode();
      } else {
         this.hideForActionMode();
      }

      ActionBarView var3 = this.mActionView;
      byte var4;
      if(var1) {
         var4 = 4;
      } else {
         var4 = 0;
      }

      var3.animateToVisibility(var4);
      ActionBarContextView var5 = this.mContextView;
      byte var6;
      if(var1) {
         var6 = 0;
      } else {
         var6 = var2;
      }

      var5.animateToVisibility(var6);
      if(this.mTabScrollView != null && !this.mActionView.hasEmbeddedTabs() && this.mActionView.isCollapsed()) {
         ScrollingTabContainerView var7 = this.mTabScrollView;
         if(!var1) {
            var2 = 0;
         }

         var7.setVisibility(var2);
      }

   }

   public void doHide(boolean var1) {
      this.mTopVisibilityView.clearAnimation();
      if(this.mTopVisibilityView.getVisibility() != 8) {
         boolean var2;
         if(!this.isShowHideAnimationEnabled() && !var1) {
            var2 = false;
         } else {
            var2 = true;
         }

         if(var2) {
            Animation var4 = AnimationUtils.loadAnimation(this.mContext, class_639.anim.abc_slide_out_top);
            this.mTopVisibilityView.startAnimation(var4);
         }

         this.mTopVisibilityView.setVisibility(8);
         if(this.mSplitView != null && this.mSplitView.getVisibility() != 8) {
            if(var2) {
               Animation var3 = AnimationUtils.loadAnimation(this.mContext, class_639.anim.abc_slide_out_bottom);
               this.mSplitView.startAnimation(var3);
            }

            this.mSplitView.setVisibility(8);
            return;
         }
      }

   }

   public void doShow(boolean var1) {
      this.mTopVisibilityView.clearAnimation();
      if(this.mTopVisibilityView.getVisibility() != 0) {
         boolean var2;
         if(!this.isShowHideAnimationEnabled() && !var1) {
            var2 = false;
         } else {
            var2 = true;
         }

         if(var2) {
            Animation var4 = AnimationUtils.loadAnimation(this.mContext, class_639.anim.abc_slide_in_top);
            this.mTopVisibilityView.startAnimation(var4);
         }

         this.mTopVisibilityView.setVisibility(0);
         if(this.mSplitView != null && this.mSplitView.getVisibility() != 0) {
            if(var2) {
               Animation var3 = AnimationUtils.loadAnimation(this.mContext, class_639.anim.abc_slide_in_bottom);
               this.mSplitView.startAnimation(var3);
            }

            this.mSplitView.setVisibility(0);
            return;
         }
      }

   }

   public View getCustomView() {
      return this.mActionView.getCustomNavigationView();
   }

   public int getDisplayOptions() {
      return this.mActionView.getDisplayOptions();
   }

   public int getHeight() {
      return this.mContainerView.getHeight();
   }

   public int getNavigationItemCount() {
      switch(this.mActionView.getNavigationMode()) {
      case 1:
         SpinnerAdapter var1 = this.mActionView.getDropdownAdapter();
         if(var1 != null) {
            return var1.getCount();
         }
      default:
         return 0;
      case 2:
         return this.mTabs.size();
      }
   }

   public int getNavigationMode() {
      return this.mActionView.getNavigationMode();
   }

   public int getSelectedNavigationIndex() {
      switch(this.mActionView.getNavigationMode()) {
      case 1:
         return this.mActionView.getDropdownSelectedPosition();
      case 2:
         if(this.mSelectedTab != null) {
            return this.mSelectedTab.getPosition();
         }
      default:
         return -1;
      }
   }

   public ActionBar.Tab getSelectedTab() {
      return this.mSelectedTab;
   }

   public CharSequence getSubtitle() {
      return this.mActionView.getSubtitle();
   }

   public ActionBar.Tab getTabAt(int var1) {
      return (ActionBar.Tab)this.mTabs.get(var1);
   }

   public int getTabCount() {
      return this.mTabs.size();
   }

   public Context getThemedContext() {
      if(this.mThemedContext == null) {
         TypedValue var1 = new TypedValue();
         this.mContext.getTheme().resolveAttribute(class_639.attr.actionBarWidgetTheme, var1, true);
         int var3 = var1.resourceId;
         if(var3 != 0) {
            this.mThemedContext = new ContextThemeWrapper(this.mContext, var3);
         } else {
            this.mThemedContext = this.mContext;
         }
      }

      return this.mThemedContext;
   }

   public CharSequence getTitle() {
      return this.mActionView.getTitle();
   }

   public boolean hasNonEmbeddedTabs() {
      return !this.mHasEmbeddedTabs && this.getNavigationMode() == 2;
   }

   public void hide() {
      if(!this.mHiddenByApp) {
         this.mHiddenByApp = true;
         this.updateVisibility(false);
      }

   }

   void hideForActionMode() {
      if(this.mShowingForMode) {
         this.mShowingForMode = false;
         this.updateVisibility(false);
      }

   }

   boolean isShowHideAnimationEnabled() {
      return this.mShowHideAnimationEnabled;
   }

   public boolean isShowing() {
      return this.mNowShowing;
   }

   public ActionBar.Tab newTab() {
      return new ActionBarImplBase.TabImpl();
   }

   public void onConfigurationChanged(Configuration var1) {
      this.setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
   }

   public void removeAllTabs() {
      this.cleanupTabs();
   }

   public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1) {
      this.mMenuVisibilityListeners.remove(var1);
   }

   public void removeTab(ActionBar.Tab var1) {
      this.removeTabAt(var1.getPosition());
   }

   public void removeTabAt(int var1) {
      if(this.mTabScrollView != null) {
         int var2;
         if(this.mSelectedTab != null) {
            var2 = this.mSelectedTab.getPosition();
         } else {
            var2 = this.mSavedTabPosition;
         }

         this.mTabScrollView.removeTabAt(var1);
         ActionBarImplBase.TabImpl var3 = (ActionBarImplBase.TabImpl)this.mTabs.remove(var1);
         if(var3 != null) {
            var3.setPosition(-1);
         }

         int var4 = this.mTabs.size();

         for(int var5 = var1; var5 < var4; ++var5) {
            ((ActionBarImplBase.TabImpl)this.mTabs.get(var5)).setPosition(var5);
         }

         if(var2 == var1) {
            ActionBarImplBase.TabImpl var6;
            if(this.mTabs.isEmpty()) {
               var6 = null;
            } else {
               var6 = (ActionBarImplBase.TabImpl)this.mTabs.get(Math.max(0, var1 - 1));
            }

            this.selectTab(var6);
            return;
         }
      }

   }

   public void selectTab(ActionBar.Tab var1) {
      int var2 = -1;
      if(this.getNavigationMode() != 2) {
         if(var1 != null) {
            var2 = var1.getPosition();
         }

         this.mSavedTabPosition = var2;
      } else {
         FragmentTransaction var3 = this.mActivity.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
         if(this.mSelectedTab == var1) {
            if(this.mSelectedTab != null) {
               this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, var3);
               this.mTabScrollView.animateToTab(var1.getPosition());
            }
         } else {
            ScrollingTabContainerView var4 = this.mTabScrollView;
            if(var1 != null) {
               var2 = var1.getPosition();
            }

            var4.setTabSelected(var2);
            if(this.mSelectedTab != null) {
               this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, var3);
            }

            this.mSelectedTab = (ActionBarImplBase.TabImpl)var1;
            if(this.mSelectedTab != null) {
               this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, var3);
            }
         }

         if(!var3.isEmpty()) {
            var3.commit();
            return;
         }
      }

   }

   public void setBackgroundDrawable(Drawable var1) {
      this.mContainerView.setPrimaryBackground(var1);
   }

   public void setCustomView(int var1) {
      this.setCustomView(LayoutInflater.from(this.getThemedContext()).inflate(var1, this.mActionView, false));
   }

   public void setCustomView(View var1) {
      this.mActionView.setCustomNavigationView(var1);
   }

   public void setCustomView(View var1, ActionBar.LayoutParams var2) {
      var1.setLayoutParams(var2);
      this.mActionView.setCustomNavigationView(var1);
   }

   public void setDisplayHomeAsUpEnabled(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 4;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 4);
   }

   public void setDisplayOptions(int var1) {
      if((var1 & 4) != 0) {
         this.mDisplayHomeAsUpSet = true;
      }

      this.mActionView.setDisplayOptions(var1);
   }

   public void setDisplayOptions(int var1, int var2) {
      int var3 = this.mActionView.getDisplayOptions();
      if((var2 & 4) != 0) {
         this.mDisplayHomeAsUpSet = true;
      }

      this.mActionView.setDisplayOptions(var1 & var2 | var3 & ~var2);
   }

   public void setDisplayShowCustomEnabled(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 16;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 16);
   }

   public void setDisplayShowHomeEnabled(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 2;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 2);
   }

   public void setDisplayShowTitleEnabled(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 8;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 8);
   }

   public void setDisplayUseLogoEnabled(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 1);
   }

   public void setHomeAsUpIndicator(int var1) {
      this.mActionView.setHomeAsUpIndicator(var1);
   }

   public void setHomeAsUpIndicator(Drawable var1) {
      this.mActionView.setHomeAsUpIndicator(var1);
   }

   public void setHomeButtonEnabled(boolean var1) {
      this.mActionView.setHomeButtonEnabled(var1);
   }

   public void setIcon(int var1) {
      this.mActionView.setIcon(var1);
   }

   public void setIcon(Drawable var1) {
      this.mActionView.setIcon(var1);
   }

   public void setListNavigationCallbacks(SpinnerAdapter var1, ActionBar.OnNavigationListener var2) {
      this.mActionView.setDropdownAdapter(var1);
      this.mActionView.setCallback(var2);
   }

   public void setLogo(int var1) {
      this.mActionView.setLogo(var1);
   }

   public void setLogo(Drawable var1) {
      this.mActionView.setLogo(var1);
   }

   public void setNavigationMode(int var1) {
      switch(this.mActionView.getNavigationMode()) {
      case 2:
         this.mSavedTabPosition = this.getSelectedNavigationIndex();
         this.selectTab((ActionBar.Tab)null);
         this.mTabScrollView.setVisibility(8);
      default:
         this.mActionView.setNavigationMode(var1);
         switch(var1) {
         case 2:
            this.ensureTabsExist();
            this.mTabScrollView.setVisibility(0);
            if(this.mSavedTabPosition != -1) {
               this.setSelectedNavigationItem(this.mSavedTabPosition);
               this.mSavedTabPosition = -1;
            }
         default:
            ActionBarView var2 = this.mActionView;
            boolean var3 = false;
            if(var1 == 2) {
               boolean var4 = this.mHasEmbeddedTabs;
               var3 = false;
               if(!var4) {
                  var3 = true;
               }
            }

            var2.setCollapsable(var3);
         }
      }
   }

   public void setSelectedNavigationItem(int var1) {
      switch(this.mActionView.getNavigationMode()) {
      case 1:
         this.mActionView.setDropdownSelectedPosition(var1);
         return;
      case 2:
         this.selectTab((ActionBar.Tab)this.mTabs.get(var1));
         return;
      default:
         throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
      }
   }

   public void setShowHideAnimationEnabled(boolean var1) {
      this.mShowHideAnimationEnabled = var1;
      if(!var1) {
         this.mTopVisibilityView.clearAnimation();
         if(this.mSplitView != null) {
            this.mSplitView.clearAnimation();
         }
      }

   }

   public void setSplitBackgroundDrawable(Drawable var1) {
      this.mContainerView.setSplitBackground(var1);
   }

   public void setStackedBackgroundDrawable(Drawable var1) {
      this.mContainerView.setStackedBackground(var1);
   }

   public void setSubtitle(int var1) {
      this.setSubtitle(this.mContext.getString(var1));
   }

   public void setSubtitle(CharSequence var1) {
      this.mActionView.setSubtitle(var1);
   }

   public void setTitle(int var1) {
      this.setTitle(this.mContext.getString(var1));
   }

   public void setTitle(CharSequence var1) {
      this.mActionView.setTitle(var1);
   }

   public void show() {
      if(this.mHiddenByApp) {
         this.mHiddenByApp = false;
         this.updateVisibility(false);
      }

   }

   void showForActionMode() {
      if(!this.mShowingForMode) {
         this.mShowingForMode = true;
         this.updateVisibility(false);
      }

   }

   public ActionMode startActionMode(ActionMode.Callback var1) {
      if(this.mActionMode != null) {
         this.mActionMode.finish();
      }

      this.mContextView.killMode();
      ActionBarImplBase.ActionModeImpl var2 = new ActionBarImplBase.ActionModeImpl(var1);
      if(var2.dispatchOnCreate()) {
         var2.invalidate();
         this.mContextView.initForMode(var2);
         this.animateToMode(true);
         if(this.mSplitView != null && this.mContextDisplayMode == 1 && this.mSplitView.getVisibility() != 0) {
            this.mSplitView.setVisibility(0);
         }

         this.mContextView.sendAccessibilityEvent(32);
         this.mActionMode = var2;
         return var2;
      } else {
         return null;
      }
   }

   class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
      private ActionMode.Callback mCallback;
      private WeakReference<View> mCustomView;
      private MenuBuilder mMenu;

      public ActionModeImpl(ActionMode.Callback var2) {
         this.mCallback = var2;
         this.mMenu = (new MenuBuilder(ActionBarImplBase.this.getThemedContext())).setDefaultShowAsAction(1);
         this.mMenu.setCallback(this);
      }

      public boolean dispatchOnCreate() {
         this.mMenu.stopDispatchingItemsChanged();

         boolean var2;
         try {
            var2 = this.mCallback.onCreateActionMode(this, this.mMenu);
         } finally {
            this.mMenu.startDispatchingItemsChanged();
         }

         return var2;
      }

      public void finish() {
         if(ActionBarImplBase.this.mActionMode == this) {
            if(!ActionBarImplBase.checkShowingFlags(ActionBarImplBase.this.mHiddenByApp, ActionBarImplBase.this.mHiddenBySystem, false)) {
               ActionBarImplBase.this.mDeferredDestroyActionMode = this;
               ActionBarImplBase.this.mDeferredModeDestroyCallback = this.mCallback;
            } else {
               this.mCallback.onDestroyActionMode(this);
            }

            this.mCallback = null;
            ActionBarImplBase.this.animateToMode(false);
            ActionBarImplBase.this.mContextView.closeMode();
            ActionBarImplBase.this.mActionView.sendAccessibilityEvent(32);
            ActionBarImplBase.this.mActionMode = null;
         }
      }

      public View getCustomView() {
         return this.mCustomView != null?(View)this.mCustomView.get():null;
      }

      public Menu getMenu() {
         return this.mMenu;
      }

      public MenuInflater getMenuInflater() {
         return new SupportMenuInflater(ActionBarImplBase.this.getThemedContext());
      }

      public CharSequence getSubtitle() {
         return ActionBarImplBase.this.mContextView.getSubtitle();
      }

      public CharSequence getTitle() {
         return ActionBarImplBase.this.mContextView.getTitle();
      }

      public void invalidate() {
         this.mMenu.stopDispatchingItemsChanged();

         try {
            this.mCallback.onPrepareActionMode(this, this.mMenu);
         } finally {
            this.mMenu.startDispatchingItemsChanged();
         }

      }

      public boolean isTitleOptional() {
         return ActionBarImplBase.this.mContextView.isTitleOptional();
      }

      public void onCloseMenu(MenuBuilder var1, boolean var2) {
      }

      public void onCloseSubMenu(SubMenuBuilder var1) {
      }

      public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
         return this.mCallback != null?this.mCallback.onActionItemClicked(this, var2):false;
      }

      public void onMenuModeChange(MenuBuilder var1) {
         if(this.mCallback != null) {
            this.invalidate();
            ActionBarImplBase.this.mContextView.showOverflowMenu();
         }
      }

      public void onMenuModeChange(Menu var1) {
         if(this.mCallback != null) {
            this.invalidate();
            ActionBarImplBase.this.mContextView.showOverflowMenu();
         }
      }

      public boolean onSubMenuSelected(SubMenuBuilder var1) {
         boolean var2 = true;
         if(this.mCallback == null) {
            var2 = false;
         } else if(!var1.hasVisibleItems()) {
            return var2;
         }

         return var2;
      }

      public void setCustomView(View var1) {
         ActionBarImplBase.this.mContextView.setCustomView(var1);
         this.mCustomView = new WeakReference(var1);
      }

      public void setSubtitle(int var1) {
         this.setSubtitle(ActionBarImplBase.this.mContext.getResources().getString(var1));
      }

      public void setSubtitle(CharSequence var1) {
         ActionBarImplBase.this.mContextView.setSubtitle(var1);
      }

      public void setTitle(int var1) {
         this.setTitle(ActionBarImplBase.this.mContext.getResources().getString(var1));
      }

      public void setTitle(CharSequence var1) {
         ActionBarImplBase.this.mContextView.setTitle(var1);
      }

      public void setTitleOptionalHint(boolean var1) {
         super.setTitleOptionalHint(var1);
         ActionBarImplBase.this.mContextView.setTitleOptional(var1);
      }
   }

   public class TabImpl extends ActionBar.Tab {
      private ActionBar.TabListener mCallback;
      private CharSequence mContentDesc;
      private View mCustomView;
      private Drawable mIcon;
      private int mPosition = -1;
      private Object mTag;
      private CharSequence mText;

      public ActionBar.TabListener getCallback() {
         return this.mCallback;
      }

      public CharSequence getContentDescription() {
         return this.mContentDesc;
      }

      public View getCustomView() {
         return this.mCustomView;
      }

      public Drawable getIcon() {
         return this.mIcon;
      }

      public int getPosition() {
         return this.mPosition;
      }

      public Object getTag() {
         return this.mTag;
      }

      public CharSequence getText() {
         return this.mText;
      }

      public void select() {
         ActionBarImplBase.this.selectTab(this);
      }

      public ActionBar.Tab setContentDescription(int var1) {
         return this.setContentDescription(ActionBarImplBase.this.mContext.getResources().getText(var1));
      }

      public ActionBar.Tab setContentDescription(CharSequence var1) {
         this.mContentDesc = var1;
         if(this.mPosition >= 0) {
            ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
         }

         return this;
      }

      public ActionBar.Tab setCustomView(int var1) {
         return this.setCustomView(LayoutInflater.from(ActionBarImplBase.this.getThemedContext()).inflate(var1, (ViewGroup)null));
      }

      public ActionBar.Tab setCustomView(View var1) {
         this.mCustomView = var1;
         if(this.mPosition >= 0) {
            ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
         }

         return this;
      }

      public ActionBar.Tab setIcon(int var1) {
         return this.setIcon(ActionBarImplBase.this.mContext.getResources().getDrawable(var1));
      }

      public ActionBar.Tab setIcon(Drawable var1) {
         this.mIcon = var1;
         if(this.mPosition >= 0) {
            ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
         }

         return this;
      }

      public void setPosition(int var1) {
         this.mPosition = var1;
      }

      public ActionBar.Tab setTabListener(ActionBar.TabListener var1) {
         this.mCallback = var1;
         return this;
      }

      public ActionBar.Tab setTag(Object var1) {
         this.mTag = var1;
         return this;
      }

      public ActionBar.Tab setText(int var1) {
         return this.setText(ActionBarImplBase.this.mContext.getResources().getText(var1));
      }

      public ActionBar.Tab setText(CharSequence var1) {
         this.mText = var1;
         if(this.mPosition >= 0) {
            ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
         }

         return this;
      }
   }
}
