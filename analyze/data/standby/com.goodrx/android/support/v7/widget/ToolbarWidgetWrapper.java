package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView.OnItemSelectedListener;

public class ToolbarWidgetWrapper implements DecorToolbar {
   private static final int AFFECTS_LOGO_MASK = 3;
   private static final long DEFAULT_FADE_DURATION_MS = 200L;
   private static final String TAG = "ToolbarWidgetWrapper";
   private ActionMenuPresenter mActionMenuPresenter;
   private View mCustomView;
   private int mDefaultNavigationContentDescription;
   private Drawable mDefaultNavigationIcon;
   private int mDisplayOpts;
   private final AppCompatDrawableManager mDrawableManager;
   private CharSequence mHomeDescription;
   private Drawable mIcon;
   private Drawable mLogo;
   private boolean mMenuPrepared;
   private Drawable mNavIcon;
   private int mNavigationMode;
   private Spinner mSpinner;
   private CharSequence mSubtitle;
   private View mTabView;
   private CharSequence mTitle;
   private boolean mTitleSet;
   private Toolbar mToolbar;
   private Callback mWindowCallback;

   public ToolbarWidgetWrapper(Toolbar var1, boolean var2) {
      this(var1, var2, class_22.string.abc_action_bar_up_description, class_22.drawable.abc_ic_ab_back_material);
   }

   public ToolbarWidgetWrapper(Toolbar var1, boolean var2, int var3, int var4) {
      this.mNavigationMode = 0;
      this.mDefaultNavigationContentDescription = 0;
      this.mToolbar = var1;
      this.mTitle = var1.getTitle();
      this.mSubtitle = var1.getSubtitle();
      boolean var5;
      if(this.mTitle != null) {
         var5 = true;
      } else {
         var5 = false;
      }

      this.mTitleSet = var5;
      this.mNavIcon = var1.getNavigationIcon();
      if(var2) {
         TintTypedArray var8 = TintTypedArray.obtainStyledAttributes(var1.getContext(), (AttributeSet)null, class_22.styleable.ActionBar, class_22.attr.actionBarStyle, 0);
         CharSequence var9 = var8.getText(class_22.styleable.ActionBar_title);
         if(!TextUtils.isEmpty(var9)) {
            this.setTitle(var9);
         }

         CharSequence var10 = var8.getText(class_22.styleable.ActionBar_subtitle);
         if(!TextUtils.isEmpty(var10)) {
            this.setSubtitle(var10);
         }

         Drawable var11 = var8.getDrawable(class_22.styleable.ActionBar_logo);
         if(var11 != null) {
            this.setLogo(var11);
         }

         Drawable var12 = var8.getDrawable(class_22.styleable.ActionBar_icon);
         if(this.mNavIcon == null && var12 != null) {
            this.setIcon(var12);
         }

         Drawable var13 = var8.getDrawable(class_22.styleable.ActionBar_homeAsUpIndicator);
         if(var13 != null) {
            this.setNavigationIcon(var13);
         }

         this.setDisplayOptions(var8.getInt(class_22.styleable.ActionBar_displayOptions, 0));
         int var14 = var8.getResourceId(class_22.styleable.ActionBar_customNavigationLayout, 0);
         if(var14 != 0) {
            this.setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(var14, this.mToolbar, false));
            this.setDisplayOptions(16 | this.mDisplayOpts);
         }

         int var15 = var8.getLayoutDimension(class_22.styleable.ActionBar_height, 0);
         if(var15 > 0) {
            LayoutParams var21 = this.mToolbar.getLayoutParams();
            var21.height = var15;
            this.mToolbar.setLayoutParams(var21);
         }

         int var16 = var8.getDimensionPixelOffset(class_22.styleable.ActionBar_contentInsetStart, -1);
         int var17 = var8.getDimensionPixelOffset(class_22.styleable.ActionBar_contentInsetEnd, -1);
         if(var16 >= 0 || var17 >= 0) {
            this.mToolbar.setContentInsetsRelative(Math.max(var16, 0), Math.max(var17, 0));
         }

         int var18 = var8.getResourceId(class_22.styleable.ActionBar_titleTextStyle, 0);
         if(var18 != 0) {
            this.mToolbar.setTitleTextAppearance(this.mToolbar.getContext(), var18);
         }

         int var19 = var8.getResourceId(class_22.styleable.ActionBar_subtitleTextStyle, 0);
         if(var19 != 0) {
            this.mToolbar.setSubtitleTextAppearance(this.mToolbar.getContext(), var19);
         }

         int var20 = var8.getResourceId(class_22.styleable.ActionBar_popupTheme, 0);
         if(var20 != 0) {
            this.mToolbar.setPopupTheme(var20);
         }

         var8.recycle();
      } else {
         this.mDisplayOpts = this.detectDisplayOptions();
      }

      this.mDrawableManager = AppCompatDrawableManager.get();
      this.setDefaultNavigationContentDescription(var3);
      this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
      this.setDefaultNavigationIcon(this.mDrawableManager.getDrawable(this.getContext(), var4));
      Toolbar var6 = this.mToolbar;
      OnClickListener var7 = new OnClickListener() {
         final ActionMenuItem mNavItem;

         {
            this.mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.this.mToolbar.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.mTitle);
         }

         public void onClick(View var1) {
            if(ToolbarWidgetWrapper.this.mWindowCallback != null && ToolbarWidgetWrapper.this.mMenuPrepared) {
               ToolbarWidgetWrapper.this.mWindowCallback.onMenuItemSelected(0, this.mNavItem);
            }

         }
      };
      var6.setNavigationOnClickListener(var7);
   }

   private int detectDisplayOptions() {
      int var1 = 11;
      if(this.mToolbar.getNavigationIcon() != null) {
         var1 |= 4;
      }

      return var1;
   }

   private void ensureSpinner() {
      if(this.mSpinner == null) {
         this.mSpinner = new AppCompatSpinner(this.getContext(), (AttributeSet)null, class_22.attr.actionDropDownStyle);
         Toolbar.LayoutParams var1 = new Toolbar.LayoutParams(-2, -2, 8388627);
         this.mSpinner.setLayoutParams(var1);
      }

   }

   private void setTitleInt(CharSequence var1) {
      this.mTitle = var1;
      if((8 & this.mDisplayOpts) != 0) {
         this.mToolbar.setTitle(var1);
      }

   }

   private void updateHomeAccessibility() {
      if((4 & this.mDisplayOpts) != 0) {
         if(!TextUtils.isEmpty(this.mHomeDescription)) {
            this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
            return;
         }

         this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
      }

   }

   private void updateNavigationIcon() {
      if((4 & this.mDisplayOpts) != 0) {
         Toolbar var1 = this.mToolbar;
         Drawable var2;
         if(this.mNavIcon != null) {
            var2 = this.mNavIcon;
         } else {
            var2 = this.mDefaultNavigationIcon;
         }

         var1.setNavigationIcon(var2);
      }

   }

   private void updateToolbarLogo() {
      int var1 = 2 & this.mDisplayOpts;
      Drawable var2 = null;
      if(var1 != 0) {
         if((1 & this.mDisplayOpts) != 0) {
            if(this.mLogo != null) {
               var2 = this.mLogo;
            } else {
               var2 = this.mIcon;
            }
         } else {
            var2 = this.mIcon;
         }
      }

      this.mToolbar.setLogo(var2);
   }

   public void animateToVisibility(int var1) {
      ViewPropertyAnimatorCompat var2 = this.setupAnimatorToVisibility(var1, 200L);
      if(var2 != null) {
         var2.start();
      }

   }

   public boolean canShowOverflowMenu() {
      return this.mToolbar.canShowOverflowMenu();
   }

   public void collapseActionView() {
      this.mToolbar.collapseActionView();
   }

   public void dismissPopupMenus() {
      this.mToolbar.dismissPopupMenus();
   }

   public Context getContext() {
      return this.mToolbar.getContext();
   }

   public View getCustomView() {
      return this.mCustomView;
   }

   public int getDisplayOptions() {
      return this.mDisplayOpts;
   }

   public int getDropdownItemCount() {
      return this.mSpinner != null?this.mSpinner.getCount():0;
   }

   public int getDropdownSelectedPosition() {
      return this.mSpinner != null?this.mSpinner.getSelectedItemPosition():0;
   }

   public int getHeight() {
      return this.mToolbar.getHeight();
   }

   public Menu getMenu() {
      return this.mToolbar.getMenu();
   }

   public int getNavigationMode() {
      return this.mNavigationMode;
   }

   public CharSequence getSubtitle() {
      return this.mToolbar.getSubtitle();
   }

   public CharSequence getTitle() {
      return this.mToolbar.getTitle();
   }

   public ViewGroup getViewGroup() {
      return this.mToolbar;
   }

   public int getVisibility() {
      return this.mToolbar.getVisibility();
   }

   public boolean hasEmbeddedTabs() {
      return this.mTabView != null;
   }

   public boolean hasExpandedActionView() {
      return this.mToolbar.hasExpandedActionView();
   }

   public boolean hasIcon() {
      return this.mIcon != null;
   }

   public boolean hasLogo() {
      return this.mLogo != null;
   }

   public boolean hideOverflowMenu() {
      return this.mToolbar.hideOverflowMenu();
   }

   public void initIndeterminateProgress() {
      Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
   }

   public void initProgress() {
      Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
   }

   public boolean isOverflowMenuShowPending() {
      return this.mToolbar.isOverflowMenuShowPending();
   }

   public boolean isOverflowMenuShowing() {
      return this.mToolbar.isOverflowMenuShowing();
   }

   public boolean isTitleTruncated() {
      return this.mToolbar.isTitleTruncated();
   }

   public void restoreHierarchyState(SparseArray<Parcelable> var1) {
      this.mToolbar.restoreHierarchyState(var1);
   }

   public void saveHierarchyState(SparseArray<Parcelable> var1) {
      this.mToolbar.saveHierarchyState(var1);
   }

   public void setBackgroundDrawable(Drawable var1) {
      this.mToolbar.setBackgroundDrawable(var1);
   }

   public void setCollapsible(boolean var1) {
      this.mToolbar.setCollapsible(var1);
   }

   public void setCustomView(View var1) {
      if(this.mCustomView != null && (16 & this.mDisplayOpts) != 0) {
         this.mToolbar.removeView(this.mCustomView);
      }

      this.mCustomView = var1;
      if(var1 != null && (16 & this.mDisplayOpts) != 0) {
         this.mToolbar.addView(this.mCustomView);
      }

   }

   public void setDefaultNavigationContentDescription(int var1) {
      if(var1 != this.mDefaultNavigationContentDescription) {
         this.mDefaultNavigationContentDescription = var1;
         if(TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
            this.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            return;
         }
      }

   }

   public void setDefaultNavigationIcon(Drawable var1) {
      if(this.mDefaultNavigationIcon != var1) {
         this.mDefaultNavigationIcon = var1;
         this.updateNavigationIcon();
      }

   }

   public void setDisplayOptions(int var1) {
      int var2 = var1 ^ this.mDisplayOpts;
      this.mDisplayOpts = var1;
      if(var2 != 0) {
         if((var2 & 4) != 0) {
            if((var1 & 4) != 0) {
               this.updateNavigationIcon();
               this.updateHomeAccessibility();
            } else {
               this.mToolbar.setNavigationIcon((Drawable)null);
            }
         }

         if((var2 & 3) != 0) {
            this.updateToolbarLogo();
         }

         if((var2 & 8) != 0) {
            if((var1 & 8) != 0) {
               this.mToolbar.setTitle(this.mTitle);
               this.mToolbar.setSubtitle(this.mSubtitle);
            } else {
               this.mToolbar.setTitle((CharSequence)null);
               this.mToolbar.setSubtitle((CharSequence)null);
            }
         }

         if((var2 & 16) != 0 && this.mCustomView != null) {
            if((var1 & 16) == 0) {
               this.mToolbar.removeView(this.mCustomView);
               return;
            }

            this.mToolbar.addView(this.mCustomView);
         }
      }

   }

   public void setDropdownParams(SpinnerAdapter var1, OnItemSelectedListener var2) {
      this.ensureSpinner();
      this.mSpinner.setAdapter(var1);
      this.mSpinner.setOnItemSelectedListener(var2);
   }

   public void setDropdownSelectedPosition(int var1) {
      if(this.mSpinner == null) {
         throw new IllegalStateException("Can\'t set dropdown selected position without an adapter");
      } else {
         this.mSpinner.setSelection(var1);
      }
   }

   public void setEmbeddedTabView(ScrollingTabContainerView var1) {
      if(this.mTabView != null && this.mTabView.getParent() == this.mToolbar) {
         this.mToolbar.removeView(this.mTabView);
      }

      this.mTabView = var1;
      if(var1 != null && this.mNavigationMode == 2) {
         this.mToolbar.addView(this.mTabView, 0);
         Toolbar.LayoutParams var2 = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
         var2.width = -2;
         var2.height = -2;
         var2.gravity = 8388691;
         var1.setAllowCollapse(true);
      }

   }

   public void setHomeButtonEnabled(boolean var1) {
   }

   public void setIcon(int var1) {
      Drawable var2;
      if(var1 != 0) {
         var2 = this.mDrawableManager.getDrawable(this.getContext(), var1);
      } else {
         var2 = null;
      }

      this.setIcon(var2);
   }

   public void setIcon(Drawable var1) {
      this.mIcon = var1;
      this.updateToolbarLogo();
   }

   public void setLogo(int var1) {
      Drawable var2;
      if(var1 != 0) {
         var2 = this.mDrawableManager.getDrawable(this.getContext(), var1);
      } else {
         var2 = null;
      }

      this.setLogo(var2);
   }

   public void setLogo(Drawable var1) {
      this.mLogo = var1;
      this.updateToolbarLogo();
   }

   public void setMenu(Menu var1, MenuPresenter.Callback var2) {
      if(this.mActionMenuPresenter == null) {
         this.mActionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
         this.mActionMenuPresenter.setId(class_22.class_93.action_menu_presenter);
      }

      this.mActionMenuPresenter.setCallback(var2);
      this.mToolbar.setMenu((MenuBuilder)var1, this.mActionMenuPresenter);
   }

   public void setMenuCallbacks(MenuPresenter.Callback var1, MenuBuilder.Callback var2) {
      this.mToolbar.setMenuCallbacks(var1, var2);
   }

   public void setMenuPrepared() {
      this.mMenuPrepared = true;
   }

   public void setNavigationContentDescription(int var1) {
      String var2;
      if(var1 == 0) {
         var2 = null;
      } else {
         var2 = this.getContext().getString(var1);
      }

      this.setNavigationContentDescription(var2);
   }

   public void setNavigationContentDescription(CharSequence var1) {
      this.mHomeDescription = var1;
      this.updateHomeAccessibility();
   }

   public void setNavigationIcon(int var1) {
      Drawable var2;
      if(var1 != 0) {
         var2 = AppCompatDrawableManager.get().getDrawable(this.getContext(), var1);
      } else {
         var2 = null;
      }

      this.setNavigationIcon(var2);
   }

   public void setNavigationIcon(Drawable var1) {
      this.mNavIcon = var1;
      this.updateNavigationIcon();
   }

   public void setNavigationMode(int var1) {
      int var2 = this.mNavigationMode;
      if(var1 != var2) {
         switch(var2) {
         case 1:
            if(this.mSpinner != null && this.mSpinner.getParent() == this.mToolbar) {
               this.mToolbar.removeView(this.mSpinner);
            }
            break;
         case 2:
            if(this.mTabView != null && this.mTabView.getParent() == this.mToolbar) {
               this.mToolbar.removeView(this.mTabView);
            }
         }

         this.mNavigationMode = var1;
         switch(var1) {
         case 0:
            break;
         case 1:
            this.ensureSpinner();
            this.mToolbar.addView(this.mSpinner, 0);
            break;
         case 2:
            if(this.mTabView != null) {
               this.mToolbar.addView(this.mTabView, 0);
               Toolbar.LayoutParams var3 = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
               var3.width = -2;
               var3.height = -2;
               var3.gravity = 8388691;
               return;
            }
            break;
         default:
            throw new IllegalArgumentException("Invalid navigation mode " + var1);
         }
      }

   }

   public void setSubtitle(CharSequence var1) {
      this.mSubtitle = var1;
      if((8 & this.mDisplayOpts) != 0) {
         this.mToolbar.setSubtitle(var1);
      }

   }

   public void setTitle(CharSequence var1) {
      this.mTitleSet = true;
      this.setTitleInt(var1);
   }

   public void setVisibility(int var1) {
      this.mToolbar.setVisibility(var1);
   }

   public void setWindowCallback(Callback var1) {
      this.mWindowCallback = var1;
   }

   public void setWindowTitle(CharSequence var1) {
      if(!this.mTitleSet) {
         this.setTitleInt(var1);
      }

   }

   public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int var1, long var2) {
      ViewPropertyAnimatorCompat var4 = ViewCompat.animate(this.mToolbar);
      float var5;
      if(var1 == 0) {
         var5 = 1.0F;
      } else {
         var5 = 0.0F;
      }

      return var4.alpha(var5).setDuration(var2).setListener(new ViewPropertyAnimatorListenerAdapter() {
         private boolean mCanceled = false;

         public void onAnimationCancel(View var1x) {
            this.mCanceled = true;
         }

         public void onAnimationEnd(View var1x) {
            if(!this.mCanceled) {
               ToolbarWidgetWrapper.this.mToolbar.setVisibility(var1);
            }

         }

         public void onAnimationStart(View var1x) {
            ToolbarWidgetWrapper.this.mToolbar.setVisibility(0);
         }
      });
   }

   public boolean showOverflowMenu() {
      return this.mToolbar.showOverflowMenu();
   }
}
