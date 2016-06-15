package android.support.v7.app;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.app.ActionBar.OnMenuVisibilityListener;
import android.app.ActionBar.OnNavigationListener;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ActionBarImplICS extends ActionBar {
   final android.app.ActionBar mActionBar;
   FragmentTransaction mActiveTransaction;
   final Activity mActivity;
   private ArrayList<WeakReference<ActionBarImplICS.OnMenuVisibilityListenerWrapper>> mAddedMenuVisWrappers;
   final ActionBar.Callback mCallback;
   private ImageView mHomeActionView;

   public ActionBarImplICS(Activity var1, ActionBar.Callback var2) {
      this(var1, var2, true);
   }

   ActionBarImplICS(Activity var1, ActionBar.Callback var2, boolean var3) {
      this.mAddedMenuVisWrappers = new ArrayList();
      this.mActivity = var1;
      this.mCallback = var2;
      this.mActionBar = var1.getActionBar();
      if(var3 && (4 & this.getDisplayOptions()) != 0) {
         this.setHomeButtonEnabled(true);
      }

   }

   private ActionBarImplICS.OnMenuVisibilityListenerWrapper findAndRemoveMenuVisWrapper(ActionBar.OnMenuVisibilityListener var1) {
      for(int var2 = 0; var2 < this.mAddedMenuVisWrappers.size(); ++var2) {
         ActionBarImplICS.OnMenuVisibilityListenerWrapper var3 = (ActionBarImplICS.OnMenuVisibilityListenerWrapper)((WeakReference)this.mAddedMenuVisWrappers.get(var2)).get();
         if(var3 == null) {
            ArrayList var5 = this.mAddedMenuVisWrappers;
            int var6 = var2 - 1;
            var5.remove(var2);
            var2 = var6;
         } else if(var3.mWrappedListener == var1) {
            this.mAddedMenuVisWrappers.remove(var2);
            return var3;
         }
      }

      return null;
   }

   public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1) {
      if(var1 != null) {
         ActionBarImplICS.OnMenuVisibilityListenerWrapper var2 = new ActionBarImplICS.OnMenuVisibilityListenerWrapper(var1);
         this.mAddedMenuVisWrappers.add(new WeakReference(var2));
         this.mActionBar.addOnMenuVisibilityListener(var2);
      }

   }

   public void addTab(ActionBar.Tab var1) {
      this.mActionBar.addTab(((ActionBarImplICS.TabWrapper)var1).mWrappedTab);
   }

   public void addTab(ActionBar.Tab var1, int var2) {
      this.mActionBar.addTab(((ActionBarImplICS.TabWrapper)var1).mWrappedTab, var2);
   }

   public void addTab(ActionBar.Tab var1, int var2, boolean var3) {
      this.mActionBar.addTab(((ActionBarImplICS.TabWrapper)var1).mWrappedTab, var2, var3);
   }

   public void addTab(ActionBar.Tab var1, boolean var2) {
      this.mActionBar.addTab(((ActionBarImplICS.TabWrapper)var1).mWrappedTab, var2);
   }

   void commitActiveTransaction() {
      if(this.mActiveTransaction != null && !this.mActiveTransaction.isEmpty()) {
         this.mActiveTransaction.commit();
      }

      this.mActiveTransaction = null;
   }

   FragmentTransaction getActiveTransaction() {
      if(this.mActiveTransaction == null) {
         this.mActiveTransaction = this.mCallback.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
      }

      return this.mActiveTransaction;
   }

   public View getCustomView() {
      return this.mActionBar.getCustomView();
   }

   public int getDisplayOptions() {
      return this.mActionBar.getDisplayOptions();
   }

   public int getHeight() {
      return this.mActionBar.getHeight();
   }

   ImageView getHomeActionView() {
      if(this.mHomeActionView == null) {
         View var1 = this.mActivity.findViewById(16908332);
         if(var1 == null) {
            return null;
         }

         ViewGroup var2 = (ViewGroup)var1.getParent();
         if(var2.getChildCount() != 2) {
            return null;
         }

         View var3 = var2.getChildAt(0);
         View var4 = var2.getChildAt(1);
         View var5;
         if(var3.getId() == 16908332) {
            var5 = var4;
         } else {
            var5 = var3;
         }

         if(var5 instanceof ImageView) {
            this.mHomeActionView = (ImageView)var5;
         }
      }

      return this.mHomeActionView;
   }

   public int getNavigationItemCount() {
      return this.mActionBar.getNavigationItemCount();
   }

   public int getNavigationMode() {
      return this.mActionBar.getNavigationMode();
   }

   public int getSelectedNavigationIndex() {
      return this.mActionBar.getSelectedNavigationIndex();
   }

   public ActionBar.Tab getSelectedTab() {
      return (ActionBar.Tab)this.mActionBar.getSelectedTab().getTag();
   }

   public CharSequence getSubtitle() {
      return this.mActionBar.getSubtitle();
   }

   public ActionBar.Tab getTabAt(int var1) {
      return (ActionBar.Tab)this.mActionBar.getTabAt(var1).getTag();
   }

   public int getTabCount() {
      return this.mActionBar.getTabCount();
   }

   Drawable getThemeDefaultUpIndicator() {
      TypedArray var1 = this.mActivity.obtainStyledAttributes(new int[]{16843531});
      Drawable var2 = var1.getDrawable(0);
      var1.recycle();
      return var2;
   }

   public Context getThemedContext() {
      return this.mActionBar.getThemedContext();
   }

   public CharSequence getTitle() {
      return this.mActionBar.getTitle();
   }

   public void hide() {
      this.mActionBar.hide();
   }

   public boolean isShowing() {
      return this.mActionBar.isShowing();
   }

   public ActionBar.Tab newTab() {
      Tab var1 = this.mActionBar.newTab();
      ActionBarImplICS.TabWrapper var2 = new ActionBarImplICS.TabWrapper(var1);
      var1.setTag(var2);
      return var2;
   }

   public void removeAllTabs() {
      this.mActionBar.removeAllTabs();
   }

   public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1) {
      ActionBarImplICS.OnMenuVisibilityListenerWrapper var2 = this.findAndRemoveMenuVisWrapper(var1);
      this.mActionBar.removeOnMenuVisibilityListener(var2);
   }

   public void removeTab(ActionBar.Tab var1) {
      this.mActionBar.removeTab(((ActionBarImplICS.TabWrapper)var1).mWrappedTab);
   }

   public void removeTabAt(int var1) {
      this.mActionBar.removeTabAt(var1);
   }

   public void selectTab(ActionBar.Tab var1) {
      this.mActionBar.selectTab(((ActionBarImplICS.TabWrapper)var1).mWrappedTab);
   }

   public void setBackgroundDrawable(Drawable var1) {
      this.mActionBar.setBackgroundDrawable(var1);
   }

   public void setCustomView(int var1) {
      this.mActionBar.setCustomView(var1);
   }

   public void setCustomView(View var1) {
      this.mActionBar.setCustomView(var1);
   }

   public void setCustomView(View var1, ActionBar.LayoutParams var2) {
      LayoutParams var3 = new LayoutParams(var2);
      var3.gravity = var2.gravity;
      this.mActionBar.setCustomView(var1, var3);
   }

   public void setDisplayHomeAsUpEnabled(boolean var1) {
      this.mActionBar.setDisplayHomeAsUpEnabled(var1);
   }

   public void setDisplayOptions(int var1) {
      this.mActionBar.setDisplayOptions(var1);
   }

   public void setDisplayOptions(int var1, int var2) {
      this.mActionBar.setDisplayOptions(var1, var2);
   }

   public void setDisplayShowCustomEnabled(boolean var1) {
      this.mActionBar.setDisplayShowCustomEnabled(var1);
   }

   public void setDisplayShowHomeEnabled(boolean var1) {
      this.mActionBar.setDisplayShowHomeEnabled(var1);
   }

   public void setDisplayShowTitleEnabled(boolean var1) {
      this.mActionBar.setDisplayShowTitleEnabled(var1);
   }

   public void setDisplayUseLogoEnabled(boolean var1) {
      this.mActionBar.setDisplayUseLogoEnabled(var1);
   }

   public void setHomeAsUpIndicator(int var1) {
      ImageView var2 = this.getHomeActionView();
      if(var2 != null) {
         if(var1 == 0) {
            var2.setImageDrawable(this.getThemeDefaultUpIndicator());
            return;
         }

         var2.setImageResource(var1);
      }

   }

   public void setHomeAsUpIndicator(Drawable var1) {
      ImageView var2 = this.getHomeActionView();
      if(var2 != null) {
         if(var1 == null) {
            var1 = this.getThemeDefaultUpIndicator();
         }

         var2.setImageDrawable(var1);
      }

   }

   public void setHomeButtonEnabled(boolean var1) {
      this.mActionBar.setHomeButtonEnabled(var1);
   }

   public void setIcon(int var1) {
      this.mActionBar.setIcon(var1);
   }

   public void setIcon(Drawable var1) {
      this.mActionBar.setIcon(var1);
   }

   public void setListNavigationCallbacks(SpinnerAdapter var1, ActionBar.OnNavigationListener var2) {
      android.app.ActionBar var3 = this.mActionBar;
      ActionBarImplICS.OnNavigationListenerWrapper var4;
      if(var2 != null) {
         var4 = new ActionBarImplICS.OnNavigationListenerWrapper(var2);
      } else {
         var4 = null;
      }

      var3.setListNavigationCallbacks(var1, var4);
   }

   public void setLogo(int var1) {
      this.mActionBar.setLogo(var1);
   }

   public void setLogo(Drawable var1) {
      this.mActionBar.setLogo(var1);
   }

   public void setNavigationMode(int var1) {
      this.mActionBar.setNavigationMode(var1);
   }

   public void setSelectedNavigationItem(int var1) {
      this.mActionBar.setSelectedNavigationItem(var1);
   }

   public void setSplitBackgroundDrawable(Drawable var1) {
      this.mActionBar.setSplitBackgroundDrawable(var1);
   }

   public void setStackedBackgroundDrawable(Drawable var1) {
      this.mActionBar.setStackedBackgroundDrawable(var1);
   }

   public void setSubtitle(int var1) {
      this.mActionBar.setSubtitle(var1);
   }

   public void setSubtitle(CharSequence var1) {
      this.mActionBar.setSubtitle(var1);
   }

   public void setTitle(int var1) {
      this.mActionBar.setTitle(var1);
   }

   public void setTitle(CharSequence var1) {
      this.mActionBar.setTitle(var1);
   }

   public void show() {
      this.mActionBar.show();
   }

   static class OnMenuVisibilityListenerWrapper implements OnMenuVisibilityListener {
      final ActionBar.OnMenuVisibilityListener mWrappedListener;

      public OnMenuVisibilityListenerWrapper(ActionBar.OnMenuVisibilityListener var1) {
         this.mWrappedListener = var1;
      }

      public void onMenuVisibilityChanged(boolean var1) {
         this.mWrappedListener.onMenuVisibilityChanged(var1);
      }
   }

   static class OnNavigationListenerWrapper implements OnNavigationListener {
      private final ActionBar.OnNavigationListener mWrappedListener;

      public OnNavigationListenerWrapper(ActionBar.OnNavigationListener var1) {
         this.mWrappedListener = var1;
      }

      public boolean onNavigationItemSelected(int var1, long var2) {
         return this.mWrappedListener.onNavigationItemSelected(var1, var2);
      }
   }

   class TabWrapper extends ActionBar.Tab implements TabListener {
      private CharSequence mContentDescription;
      private ActionBar.TabListener mTabListener;
      private Object mTag;
      final Tab mWrappedTab;

      public TabWrapper(Tab var2) {
         this.mWrappedTab = var2;
      }

      public CharSequence getContentDescription() {
         return this.mContentDescription;
      }

      public View getCustomView() {
         return this.mWrappedTab.getCustomView();
      }

      public Drawable getIcon() {
         return this.mWrappedTab.getIcon();
      }

      public int getPosition() {
         return this.mWrappedTab.getPosition();
      }

      public Object getTag() {
         return this.mTag;
      }

      public CharSequence getText() {
         return this.mWrappedTab.getText();
      }

      public void onTabReselected(Tab var1, android.app.FragmentTransaction var2) {
         ActionBar.TabListener var3 = this.mTabListener;
         FragmentTransaction var4;
         if(var2 != null) {
            var4 = ActionBarImplICS.this.getActiveTransaction();
         } else {
            var4 = null;
         }

         var3.onTabReselected(this, var4);
         ActionBarImplICS.this.commitActiveTransaction();
      }

      public void onTabSelected(Tab var1, android.app.FragmentTransaction var2) {
         ActionBar.TabListener var3 = this.mTabListener;
         FragmentTransaction var4;
         if(var2 != null) {
            var4 = ActionBarImplICS.this.getActiveTransaction();
         } else {
            var4 = null;
         }

         var3.onTabSelected(this, var4);
         ActionBarImplICS.this.commitActiveTransaction();
      }

      public void onTabUnselected(Tab var1, android.app.FragmentTransaction var2) {
         ActionBar.TabListener var3 = this.mTabListener;
         FragmentTransaction var4;
         if(var2 != null) {
            var4 = ActionBarImplICS.this.getActiveTransaction();
         } else {
            var4 = null;
         }

         var3.onTabUnselected(this, var4);
      }

      public void select() {
         this.mWrappedTab.select();
      }

      public ActionBar.Tab setContentDescription(int var1) {
         this.mContentDescription = ActionBarImplICS.this.mActivity.getText(var1);
         return this;
      }

      public ActionBar.Tab setContentDescription(CharSequence var1) {
         this.mContentDescription = var1;
         return this;
      }

      public ActionBar.Tab setCustomView(int var1) {
         this.mWrappedTab.setCustomView(var1);
         return this;
      }

      public ActionBar.Tab setCustomView(View var1) {
         this.mWrappedTab.setCustomView(var1);
         return this;
      }

      public ActionBar.Tab setIcon(int var1) {
         this.mWrappedTab.setIcon(var1);
         return this;
      }

      public ActionBar.Tab setIcon(Drawable var1) {
         this.mWrappedTab.setIcon(var1);
         return this;
      }

      public ActionBar.Tab setTabListener(ActionBar.TabListener var1) {
         this.mTabListener = var1;
         Tab var2 = this.mWrappedTab;
         ActionBarImplICS.TabWrapper var3;
         if(var1 != null) {
            var3 = this;
         } else {
            var3 = null;
         }

         var2.setTabListener(var3);
         return this;
      }

      public ActionBar.Tab setTag(Object var1) {
         this.mTag = var1;
         return this;
      }

      public ActionBar.Tab setText(int var1) {
         this.mWrappedTab.setText(var1);
         return this;
      }

      public ActionBar.Tab setText(CharSequence var1) {
         this.mWrappedTab.setText(var1);
         return this;
      }
   }
}
