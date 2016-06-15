package android.support.v7.internal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.AbsActionBarView;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.AdapterViewICS;
import android.support.v7.internal.widget.ProgressBarICS;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.internal.widget.SpinnerICS;
import android.support.v7.view.CollapsibleActionView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class ActionBarView extends AbsActionBarView {
   private static final int DEFAULT_CUSTOM_GRAVITY = 19;
   public static final int DISPLAY_DEFAULT = 0;
   private static final int DISPLAY_RELAYOUT_MASK = 31;
   private static final String TAG = "ActionBarView";
   private ActionBar.OnNavigationListener mCallback;
   private Context mContext;
   private ActionBarContextView mContextView;
   private View mCustomNavView;
   private int mDisplayOptions = -1;
   View mExpandedActionView;
   private final OnClickListener mExpandedActionViewUpListener = new OnClickListener() {
      public void onClick(View var1) {
         MenuItemImpl var2 = ActionBarView.this.mExpandedMenuPresenter.mCurrentExpandedItem;
         if(var2 != null) {
            var2.collapseActionView();
         }

      }
   };
   private ActionBarView.HomeView mExpandedHomeLayout;
   private ActionBarView.ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
   private ActionBarView.HomeView mHomeLayout;
   private Drawable mIcon;
   private boolean mIncludeTabs;
   private int mIndeterminateProgressStyle;
   private ProgressBarICS mIndeterminateProgressView;
   private boolean mIsCollapsable;
   private boolean mIsCollapsed;
   private int mItemPadding;
   private LinearLayout mListNavLayout;
   private Drawable mLogo;
   private ActionMenuItem mLogoNavItem;
   private final AdapterViewICS.OnItemSelectedListener mNavItemSelectedListener = new AdapterViewICS.OnItemSelectedListener() {
      public void onItemSelected(AdapterViewICS<?> var1, View var2, int var3, long var4) {
         if(ActionBarView.this.mCallback != null) {
            ActionBarView.this.mCallback.onNavigationItemSelected(var3, var4);
         }

      }

      public void onNothingSelected(AdapterViewICS<?> var1) {
      }
   };
   private int mNavigationMode;
   private MenuBuilder mOptionsMenu;
   private int mProgressBarPadding;
   private int mProgressStyle;
   private ProgressBarICS mProgressView;
   private SpinnerICS mSpinner;
   private SpinnerAdapter mSpinnerAdapter;
   private CharSequence mSubtitle;
   private int mSubtitleStyleRes;
   private TextView mSubtitleView;
   private ScrollingTabContainerView mTabScrollView;
   private Runnable mTabSelector;
   private CharSequence mTitle;
   private LinearLayout mTitleLayout;
   private int mTitleStyleRes;
   private View mTitleUpView;
   private TextView mTitleView;
   private final OnClickListener mUpClickListener = new OnClickListener() {
      public void onClick(View var1) {
         ActionBarView.this.mWindowCallback.onMenuItemSelected(0, ActionBarView.this.mLogoNavItem);
      }
   };
   private boolean mUserTitle;
   Callback mWindowCallback;

   public ActionBarView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mContext = var1;
      this.setBackgroundResource(0);
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_639.styleable.ActionBar, class_639.attr.actionBarStyle, 0);
      ApplicationInfo var4 = var1.getApplicationInfo();
      PackageManager var5 = var1.getPackageManager();
      this.mNavigationMode = var3.getInt(2, 0);
      this.mTitle = var3.getText(0);
      this.mSubtitle = var3.getText(4);
      this.mLogo = var3.getDrawable(8);
      if(this.mLogo == null && VERSION.SDK_INT >= 9) {
         if(var1 instanceof Activity) {
            try {
               this.mLogo = var5.getActivityLogo(((Activity)var1).getComponentName());
            } catch (NameNotFoundException var13) {
               Log.e("ActionBarView", "Activity component name not found!", var13);
            }
         }

         if(this.mLogo == null) {
            this.mLogo = var4.loadLogo(var5);
         }
      }

      this.mIcon = var3.getDrawable(7);
      if(this.mIcon == null) {
         if(var1 instanceof Activity) {
            try {
               this.mIcon = var5.getActivityIcon(((Activity)var1).getComponentName());
            } catch (NameNotFoundException var12) {
               Log.e("ActionBarView", "Activity component name not found!", var12);
            }
         }

         if(this.mIcon == null) {
            this.mIcon = var4.loadIcon(var5);
         }
      }

      LayoutInflater var6 = LayoutInflater.from(var1);
      int var7 = var3.getResourceId(14, class_639.layout.abc_action_bar_home);
      this.mHomeLayout = (ActionBarView.HomeView)var6.inflate(var7, this, false);
      this.mExpandedHomeLayout = (ActionBarView.HomeView)var6.inflate(var7, this, false);
      this.mExpandedHomeLayout.setUp(true);
      this.mExpandedHomeLayout.setOnClickListener(this.mExpandedActionViewUpListener);
      this.mExpandedHomeLayout.setContentDescription(this.getResources().getText(class_639.string.abc_action_bar_up_description));
      this.mTitleStyleRes = var3.getResourceId(5, 0);
      this.mSubtitleStyleRes = var3.getResourceId(6, 0);
      this.mProgressStyle = var3.getResourceId(15, 0);
      this.mIndeterminateProgressStyle = var3.getResourceId(16, 0);
      this.mProgressBarPadding = var3.getDimensionPixelOffset(17, 0);
      this.mItemPadding = var3.getDimensionPixelOffset(18, 0);
      this.setDisplayOptions(var3.getInt(3, 0));
      int var8 = var3.getResourceId(13, 0);
      if(var8 != 0) {
         this.mCustomNavView = var6.inflate(var8, this, false);
         this.mNavigationMode = 0;
         this.setDisplayOptions(16 | this.mDisplayOptions);
      }

      this.mContentHeight = var3.getLayoutDimension(1, 0);
      var3.recycle();
      this.mLogoNavItem = new ActionMenuItem(var1, 0, 16908332, 0, 0, this.mTitle);
      this.mHomeLayout.setOnClickListener(this.mUpClickListener);
      this.mHomeLayout.setClickable(true);
      this.mHomeLayout.setFocusable(true);
   }

   private void configPresenters(MenuBuilder var1) {
      if(var1 != null) {
         var1.addMenuPresenter(this.mActionMenuPresenter);
         var1.addMenuPresenter(this.mExpandedMenuPresenter);
      } else {
         this.mActionMenuPresenter.initForMenu(this.mContext, (MenuBuilder)null);
         this.mExpandedMenuPresenter.initForMenu(this.mContext, (MenuBuilder)null);
      }

      this.mActionMenuPresenter.updateMenuView(true);
      this.mExpandedMenuPresenter.updateMenuView(true);
   }

   private void initTitle() {
      boolean var1 = true;
      if(this.mTitleLayout == null) {
         this.mTitleLayout = (LinearLayout)LayoutInflater.from(this.getContext()).inflate(class_639.layout.abc_action_bar_title_item, this, false);
         this.mTitleView = (TextView)this.mTitleLayout.findViewById(class_639.class_981.action_bar_title);
         this.mSubtitleView = (TextView)this.mTitleLayout.findViewById(class_639.class_981.action_bar_subtitle);
         this.mTitleUpView = this.mTitleLayout.findViewById(class_639.class_981.field_2687);
         this.mTitleLayout.setOnClickListener(this.mUpClickListener);
         if(this.mTitleStyleRes != 0) {
            this.mTitleView.setTextAppearance(this.mContext, this.mTitleStyleRes);
         }

         if(this.mTitle != null) {
            this.mTitleView.setText(this.mTitle);
         }

         if(this.mSubtitleStyleRes != 0) {
            this.mSubtitleView.setTextAppearance(this.mContext, this.mSubtitleStyleRes);
         }

         if(this.mSubtitle != null) {
            this.mSubtitleView.setText(this.mSubtitle);
            this.mSubtitleView.setVisibility(0);
         }

         boolean var2;
         if((4 & this.mDisplayOptions) != 0) {
            var2 = var1;
         } else {
            var2 = false;
         }

         boolean var3;
         if((2 & this.mDisplayOptions) != 0) {
            var3 = var1;
         } else {
            var3 = false;
         }

         View var4 = this.mTitleUpView;
         byte var5;
         if(!var3) {
            if(var2) {
               var5 = 0;
            } else {
               var5 = 4;
            }
         } else {
            var5 = 8;
         }

         var4.setVisibility(var5);
         LinearLayout var6 = this.mTitleLayout;
         if(!var2 || var3) {
            var1 = false;
         }

         var6.setEnabled(var1);
      }

      this.addView(this.mTitleLayout);
      if(this.mExpandedActionView != null || TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSubtitle)) {
         this.mTitleLayout.setVisibility(8);
      }

   }

   private void setTitleImpl(CharSequence var1) {
      this.mTitle = var1;
      if(this.mTitleView != null) {
         this.mTitleView.setText(var1);
         boolean var3;
         if(this.mExpandedActionView != null || (8 & this.mDisplayOptions) == 0 || TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSubtitle)) {
            var3 = false;
         } else {
            var3 = true;
         }

         LinearLayout var4 = this.mTitleLayout;
         byte var5 = 0;
         if(!var3) {
            var5 = 8;
         }

         var4.setVisibility(var5);
      }

      if(this.mLogoNavItem != null) {
         this.mLogoNavItem.setTitle(var1);
      }

   }

   public void collapseActionView() {
      MenuItemImpl var1;
      if(this.mExpandedMenuPresenter == null) {
         var1 = null;
      } else {
         var1 = this.mExpandedMenuPresenter.mCurrentExpandedItem;
      }

      if(var1 != null) {
         var1.collapseActionView();
      }

   }

   protected LayoutParams generateDefaultLayoutParams() {
      return new ActionBar.LayoutParams(19);
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      return new ActionBar.LayoutParams(this.getContext(), var1);
   }

   public LayoutParams generateLayoutParams(LayoutParams var1) {
      if(var1 == null) {
         var1 = this.generateDefaultLayoutParams();
      }

      return var1;
   }

   public View getCustomNavigationView() {
      return this.mCustomNavView;
   }

   public int getDisplayOptions() {
      return this.mDisplayOptions;
   }

   public SpinnerAdapter getDropdownAdapter() {
      return this.mSpinnerAdapter;
   }

   public int getDropdownSelectedPosition() {
      return this.mSpinner.getSelectedItemPosition();
   }

   public int getNavigationMode() {
      return this.mNavigationMode;
   }

   public CharSequence getSubtitle() {
      return this.mSubtitle;
   }

   public CharSequence getTitle() {
      return this.mTitle;
   }

   public boolean hasEmbeddedTabs() {
      return this.mIncludeTabs;
   }

   public boolean hasExpandedActionView() {
      return this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null;
   }

   public void initIndeterminateProgress() {
      this.mIndeterminateProgressView = new ProgressBarICS(this.mContext, (AttributeSet)null, 0, this.mIndeterminateProgressStyle);
      this.mIndeterminateProgressView.setId(class_639.class_981.progress_circular);
      this.mIndeterminateProgressView.setVisibility(8);
      this.addView(this.mIndeterminateProgressView);
   }

   public void initProgress() {
      this.mProgressView = new ProgressBarICS(this.mContext, (AttributeSet)null, 0, this.mProgressStyle);
      this.mProgressView.setId(class_639.class_981.progress_horizontal);
      this.mProgressView.setMax(10000);
      this.mProgressView.setVisibility(8);
      this.addView(this.mProgressView);
   }

   public boolean isCollapsed() {
      return this.mIsCollapsed;
   }

   public boolean isSplitActionBar() {
      return this.mSplitActionBar;
   }

   protected void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.mTitleView = null;
      this.mSubtitleView = null;
      this.mTitleUpView = null;
      if(this.mTitleLayout != null && this.mTitleLayout.getParent() == this) {
         this.removeView(this.mTitleLayout);
      }

      this.mTitleLayout = null;
      if((8 & this.mDisplayOptions) != 0) {
         this.initTitle();
      }

      if(this.mTabScrollView != null && this.mIncludeTabs) {
         LayoutParams var2 = this.mTabScrollView.getLayoutParams();
         if(var2 != null) {
            var2.width = -2;
            var2.height = -1;
         }

         this.mTabScrollView.setAllowCollapse(true);
      }

      if(this.mProgressView != null) {
         this.removeView(this.mProgressView);
         this.initProgress();
      }

      if(this.mIndeterminateProgressView != null) {
         this.removeView(this.mIndeterminateProgressView);
         this.initIndeterminateProgress();
      }

   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.removeCallbacks(this.mTabSelector);
      if(this.mActionMenuPresenter != null) {
         this.mActionMenuPresenter.hideOverflowMenu();
         this.mActionMenuPresenter.hideSubMenus();
      }

   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.addView(this.mHomeLayout);
      if(this.mCustomNavView != null && (16 & this.mDisplayOptions) != 0) {
         ViewParent var1 = this.mCustomNavView.getParent();
         if(var1 != this) {
            if(var1 instanceof ViewGroup) {
               ((ViewGroup)var1).removeView(this.mCustomNavView);
            }

            this.addView(this.mCustomNavView);
         }
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var6 = this.getPaddingLeft();
      int var7 = this.getPaddingTop();
      int var8 = var5 - var3 - this.getPaddingTop() - this.getPaddingBottom();
      if(var8 > 0) {
         ActionBarView.HomeView var9;
         if(this.mExpandedActionView != null) {
            var9 = this.mExpandedHomeLayout;
         } else {
            var9 = this.mHomeLayout;
         }

         if(var9.getVisibility() != 8) {
            int var34 = var9.getLeftOffset();
            var6 += var34 + this.positionChild(var9, var6 + var34, var7, var8);
         }

         if(this.mExpandedActionView == null) {
            boolean var33;
            if(this.mTitleLayout != null && this.mTitleLayout.getVisibility() != 8 && (8 & this.mDisplayOptions) != 0) {
               var33 = true;
            } else {
               var33 = false;
            }

            if(var33) {
               var6 += this.positionChild(this.mTitleLayout, var6, var7, var8);
            }

            switch(this.mNavigationMode) {
            case 0:
            default:
               break;
            case 1:
               if(this.mListNavLayout != null) {
                  if(var33) {
                     var6 += this.mItemPadding;
                  }

                  var6 += this.positionChild(this.mListNavLayout, var6, var7, var8) + this.mItemPadding;
               }
               break;
            case 2:
               if(this.mTabScrollView != null) {
                  if(var33) {
                     var6 += this.mItemPadding;
                  }

                  var6 += this.positionChild(this.mTabScrollView, var6, var7, var8) + this.mItemPadding;
               }
            }
         }

         int var10 = var4 - var2 - this.getPaddingRight();
         if(this.mMenuView != null && this.mMenuView.getParent() == this) {
            this.positionChildInverse(this.mMenuView, var10, var7, var8);
            var10 -= this.mMenuView.getMeasuredWidth();
         }

         if(this.mIndeterminateProgressView != null && this.mIndeterminateProgressView.getVisibility() != 8) {
            this.positionChildInverse(this.mIndeterminateProgressView, var10, var7, var8);
            var10 -= this.mIndeterminateProgressView.getMeasuredWidth();
         }

         View var12;
         if(this.mExpandedActionView != null) {
            var12 = this.mExpandedActionView;
         } else {
            int var11 = 16 & this.mDisplayOptions;
            var12 = null;
            if(var11 != 0) {
               View var13 = this.mCustomNavView;
               var12 = null;
               if(var13 != null) {
                  var12 = this.mCustomNavView;
               }
            }
         }

         if(var12 != null) {
            LayoutParams var15 = var12.getLayoutParams();
            ActionBar.LayoutParams var16;
            if(var15 instanceof ActionBar.LayoutParams) {
               var16 = (ActionBar.LayoutParams)var15;
            } else {
               var16 = null;
            }

            int var17;
            if(var16 != null) {
               var17 = var16.gravity;
            } else {
               var17 = 19;
            }

            int var18 = var12.getMeasuredWidth();
            int var19 = 0;
            int var20 = 0;
            if(var16 != null) {
               var6 += var16.leftMargin;
               var10 -= var16.rightMargin;
               var20 = var16.topMargin;
               var19 = var16.bottomMargin;
            }

            int var21 = var17 & 7;
            if(var21 == 1) {
               int var30 = (this.getWidth() - var18) / 2;
               if(var30 < var6) {
                  var21 = 3;
               } else if(var30 + var18 > var10) {
                  var21 = 5;
               }
            } else if(var17 == -1) {
               var21 = 3;
            }

            int var22 = 0;
            switch(var21) {
            case 1:
               var22 = (this.getWidth() - var18) / 2;
            case 2:
            case 4:
            default:
               break;
            case 3:
               var22 = var6;
               break;
            case 5:
               var22 = var10 - var18;
            }

            int var23 = var17 & 112;
            if(var17 == -1) {
               var23 = 16;
            }

            int var24 = 0;
            switch(var23) {
            case 16:
               int var29 = this.getPaddingTop();
               var24 = (this.getHeight() - this.getPaddingBottom() - var29 - var12.getMeasuredHeight()) / 2;
               break;
            case 48:
               var24 = var20 + this.getPaddingTop();
               break;
            case 80:
               var24 = this.getHeight() - this.getPaddingBottom() - var12.getMeasuredHeight() - var19;
            }

            int var25 = var12.getMeasuredWidth();
            int var26 = var22 + var25;
            int var27 = var24 + var12.getMeasuredHeight();
            var12.layout(var22, var24, var26, var27);
            int var10000 = var6 + var25;
         }

         if(this.mProgressView != null) {
            this.mProgressView.bringToFront();
            int var14 = this.mProgressView.getMeasuredHeight() / 2;
            this.mProgressView.layout(this.mProgressBarPadding, -var14, this.mProgressBarPadding + this.mProgressView.getMeasuredWidth(), var14);
            return;
         }
      }

   }

   protected void onMeasure(int var1, int var2) {
      int var3 = this.getChildCount();
      if(this.mIsCollapsable) {
         int var46 = 0;

         for(int var47 = 0; var47 < var3; ++var47) {
            View var48 = this.getChildAt(var47);
            if(var48.getVisibility() != 8 && (var48 != this.mMenuView || this.mMenuView.getChildCount() != 0)) {
               ++var46;
            }
         }

         if(var46 == 0) {
            this.setMeasuredDimension(0, 0);
            this.mIsCollapsed = true;
            return;
         }
      }

      this.mIsCollapsed = false;
      if(MeasureSpec.getMode(var1) != 1073741824) {
         throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"MATCH_PARENT\" (or fill_parent)");
      } else if(MeasureSpec.getMode(var2) != Integer.MIN_VALUE) {
         throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
      } else {
         int var4 = MeasureSpec.getSize(var1);
         int var5;
         if(this.mContentHeight > 0) {
            var5 = this.mContentHeight;
         } else {
            var5 = MeasureSpec.getSize(var2);
         }

         int var6 = this.getPaddingTop() + this.getPaddingBottom();
         int var7 = this.getPaddingLeft();
         int var8 = this.getPaddingRight();
         int var9 = var5 - var6;
         int var10 = MeasureSpec.makeMeasureSpec(var9, Integer.MIN_VALUE);
         int var11 = var4 - var7 - var8;
         int var12 = var11 / 2;
         int var13 = var12;
         ActionBarView.HomeView var14;
         if(this.mExpandedActionView != null) {
            var14 = this.mExpandedHomeLayout;
         } else {
            var14 = this.mHomeLayout;
         }

         if(var14.getVisibility() != 8) {
            LayoutParams var42 = var14.getLayoutParams();
            int var43;
            if(var42.width < 0) {
               var43 = MeasureSpec.makeMeasureSpec(var11, Integer.MIN_VALUE);
            } else {
               var43 = MeasureSpec.makeMeasureSpec(var42.width, 1073741824);
            }

            int var44 = MeasureSpec.makeMeasureSpec(var9, 1073741824);
            var14.measure(var43, var44);
            int var45 = var14.getMeasuredWidth() + var14.getLeftOffset();
            var11 = Math.max(0, var11 - var45);
            var12 = Math.max(0, var11 - var45);
         }

         if(this.mMenuView != null && this.mMenuView.getParent() == this) {
            var11 = this.measureChildView(this.mMenuView, var11, var10, 0);
            var13 = Math.max(0, var12 - this.mMenuView.getMeasuredWidth());
         }

         if(this.mIndeterminateProgressView != null && this.mIndeterminateProgressView.getVisibility() != 8) {
            var11 = this.measureChildView(this.mIndeterminateProgressView, var11, var10, 0);
            var13 = Math.max(0, var13 - this.mIndeterminateProgressView.getMeasuredWidth());
         }

         boolean var15;
         if(this.mTitleLayout != null && this.mTitleLayout.getVisibility() != 8 && (8 & this.mDisplayOptions) != 0) {
            var15 = true;
         } else {
            var15 = false;
         }

         if(this.mExpandedActionView == null) {
            switch(this.mNavigationMode) {
            case 1:
               if(this.mListNavLayout != null) {
                  int var38;
                  if(var15) {
                     var38 = 2 * this.mItemPadding;
                  } else {
                     var38 = this.mItemPadding;
                  }

                  int var39 = Math.max(0, var11 - var38);
                  int var40 = Math.max(0, var12 - var38);
                  this.mListNavLayout.measure(MeasureSpec.makeMeasureSpec(var39, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(var9, 1073741824));
                  int var41 = this.mListNavLayout.getMeasuredWidth();
                  var11 = Math.max(0, var39 - var41);
                  var12 = Math.max(0, var40 - var41);
               }
               break;
            case 2:
               if(this.mTabScrollView != null) {
                  int var34;
                  if(var15) {
                     var34 = 2 * this.mItemPadding;
                  } else {
                     var34 = this.mItemPadding;
                  }

                  int var35 = Math.max(0, var11 - var34);
                  int var36 = Math.max(0, var12 - var34);
                  this.mTabScrollView.measure(MeasureSpec.makeMeasureSpec(var35, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(var9, 1073741824));
                  int var37 = this.mTabScrollView.getMeasuredWidth();
                  var11 = Math.max(0, var35 - var37);
                  var12 = Math.max(0, var36 - var37);
               }
            }
         }

         View var17;
         if(this.mExpandedActionView != null) {
            var17 = this.mExpandedActionView;
         } else {
            int var16 = 16 & this.mDisplayOptions;
            var17 = null;
            if(var16 != 0) {
               View var18 = this.mCustomNavView;
               var17 = null;
               if(var18 != null) {
                  var17 = this.mCustomNavView;
               }
            }
         }

         if(var17 != null) {
            LayoutParams var24 = this.generateLayoutParams(var17.getLayoutParams());
            ActionBar.LayoutParams var25;
            if(var24 instanceof ActionBar.LayoutParams) {
               var25 = (ActionBar.LayoutParams)var24;
            } else {
               var25 = null;
            }

            int var26 = 0;
            int var27 = 0;
            if(var25 != null) {
               var26 = var25.leftMargin + var25.rightMargin;
               var27 = var25.topMargin + var25.bottomMargin;
            }

            int var28;
            if(this.mContentHeight <= 0) {
               var28 = Integer.MIN_VALUE;
            } else if(var24.height != -2) {
               var28 = 1073741824;
            } else {
               var28 = Integer.MIN_VALUE;
            }

            if(var24.height >= 0) {
               var9 = Math.min(var24.height, var9);
            }

            int var29 = Math.max(0, var9 - var27);
            int var30;
            if(var24.width != -2) {
               var30 = 1073741824;
            } else {
               var30 = Integer.MIN_VALUE;
            }

            int var31;
            if(var24.width >= 0) {
               var31 = Math.min(var24.width, var11);
            } else {
               var31 = var11;
            }

            int var32 = Math.max(0, var31 - var26);
            int var33;
            if(var25 != null) {
               var33 = var25.gravity;
            } else {
               var33 = 19;
            }

            if((var33 & 7) == 1 && var24.width == -1) {
               var32 = 2 * Math.min(var12, var13);
            }

            var17.measure(MeasureSpec.makeMeasureSpec(var32, var30), MeasureSpec.makeMeasureSpec(var29, var28));
            var11 -= var26 + var17.getMeasuredWidth();
         }

         if(this.mExpandedActionView == null && var15) {
            this.measureChildView(this.mTitleLayout, var11, MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824), 0);
            Math.max(0, var12 - this.mTitleLayout.getMeasuredWidth());
         }

         if(this.mContentHeight > 0) {
            this.setMeasuredDimension(var4, var5);
         } else {
            int var19 = 0;

            for(int var20 = 0; var20 < var3; ++var20) {
               int var21 = var6 + this.getChildAt(var20).getMeasuredHeight();
               if(var21 > var19) {
                  var19 = var21;
               }
            }

            this.setMeasuredDimension(var4, var19);
         }

         if(this.mContextView != null) {
            this.mContextView.setContentHeight(this.getMeasuredHeight());
         }

         if(this.mProgressView != null && this.mProgressView.getVisibility() != 8) {
            this.mProgressView.measure(MeasureSpec.makeMeasureSpec(var4 - 2 * this.mProgressBarPadding, 1073741824), MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), Integer.MIN_VALUE));
         }
      }
   }

   public void onRestoreInstanceState(Parcelable var1) {
      ActionBarView.SavedState var2 = (ActionBarView.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      if(var2.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && this.mOptionsMenu != null) {
         SupportMenuItem var3 = (SupportMenuItem)this.mOptionsMenu.findItem(var2.expandedMenuItemId);
         if(var3 != null) {
            var3.expandActionView();
         }
      }

      if(var2.isOverflowOpen) {
         this.postShowOverflowMenu();
      }

   }

   public Parcelable onSaveInstanceState() {
      ActionBarView.SavedState var1 = new ActionBarView.SavedState(super.onSaveInstanceState());
      if(this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null) {
         var1.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
      }

      var1.isOverflowOpen = this.isOverflowMenuShowing();
      return var1;
   }

   public void setCallback(ActionBar.OnNavigationListener var1) {
      this.mCallback = var1;
   }

   public void setCollapsable(boolean var1) {
      this.mIsCollapsable = var1;
   }

   public void setContextView(ActionBarContextView var1) {
      this.mContextView = var1;
   }

   public void setCustomNavigationView(View var1) {
      boolean var2;
      if((16 & this.mDisplayOptions) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(this.mCustomNavView != null && var2) {
         this.removeView(this.mCustomNavView);
      }

      this.mCustomNavView = var1;
      if(this.mCustomNavView != null && var2) {
         this.addView(this.mCustomNavView);
      }

   }

   public void setDisplayOptions(int var1) {
      byte var2 = 8;
      int var3 = -1;
      boolean var4 = true;
      if(this.mDisplayOptions != var3) {
         var3 = var1 ^ this.mDisplayOptions;
      }

      this.mDisplayOptions = var1;
      if((var3 & 31) != 0) {
         boolean var5;
         if((var1 & 2) != 0) {
            var5 = var4;
         } else {
            var5 = false;
         }

         byte var6;
         if(var5 && this.mExpandedActionView == null) {
            var6 = 0;
         } else {
            var6 = var2;
         }

         this.mHomeLayout.setVisibility(var6);
         if((var3 & 4) != 0) {
            boolean var13;
            if((var1 & 4) != 0) {
               var13 = var4;
            } else {
               var13 = false;
            }

            this.mHomeLayout.setUp(var13);
            if(var13) {
               this.setHomeButtonEnabled(var4);
            }
         }

         if((var3 & 1) != 0) {
            boolean var10;
            if(this.mLogo != null && (var1 & 1) != 0) {
               var10 = var4;
            } else {
               var10 = false;
            }

            ActionBarView.HomeView var11 = this.mHomeLayout;
            Drawable var12;
            if(var10) {
               var12 = this.mLogo;
            } else {
               var12 = this.mIcon;
            }

            var11.setIcon(var12);
         }

         if((var3 & 8) != 0) {
            if((var1 & 8) != 0) {
               this.initTitle();
            } else {
               this.removeView(this.mTitleLayout);
            }
         }

         if(this.mTitleLayout != null && (var3 & 6) != 0) {
            boolean var7;
            if((4 & this.mDisplayOptions) != 0) {
               var7 = var4;
            } else {
               var7 = false;
            }

            View var8 = this.mTitleUpView;
            if(!var5) {
               if(var7) {
                  var2 = 0;
               } else {
                  var2 = 4;
               }
            }

            var8.setVisibility(var2);
            LinearLayout var9 = this.mTitleLayout;
            if(var5 || !var7) {
               var4 = false;
            }

            var9.setEnabled(var4);
         }

         if((var3 & 16) != 0 && this.mCustomNavView != null) {
            if((var1 & 16) != 0) {
               this.addView(this.mCustomNavView);
            } else {
               this.removeView(this.mCustomNavView);
            }
         }

         this.requestLayout();
      } else {
         this.invalidate();
      }

      if(!this.mHomeLayout.isEnabled()) {
         this.mHomeLayout.setContentDescription((CharSequence)null);
      } else if((var1 & 4) != 0) {
         this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(class_639.string.abc_action_bar_up_description));
      } else {
         this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(class_639.string.abc_action_bar_home_description));
      }
   }

   public void setDropdownAdapter(SpinnerAdapter var1) {
      this.mSpinnerAdapter = var1;
      if(this.mSpinner != null) {
         this.mSpinner.setAdapter(var1);
      }

   }

   public void setDropdownSelectedPosition(int var1) {
      this.mSpinner.setSelection(var1);
   }

   public void setEmbeddedTabView(ScrollingTabContainerView var1) {
      if(this.mTabScrollView != null) {
         this.removeView(this.mTabScrollView);
      }

      this.mTabScrollView = var1;
      boolean var2;
      if(var1 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mIncludeTabs = var2;
      if(this.mIncludeTabs && this.mNavigationMode == 2) {
         this.addView(this.mTabScrollView);
         LayoutParams var3 = this.mTabScrollView.getLayoutParams();
         var3.width = -2;
         var3.height = -1;
         var1.setAllowCollapse(true);
      }

   }

   public void setHomeAsUpIndicator(int var1) {
      this.mHomeLayout.setUpIndicator(var1);
   }

   public void setHomeAsUpIndicator(Drawable var1) {
      this.mHomeLayout.setUpIndicator(var1);
   }

   public void setHomeButtonEnabled(boolean var1) {
      this.mHomeLayout.setEnabled(var1);
      this.mHomeLayout.setFocusable(var1);
      if(!var1) {
         this.mHomeLayout.setContentDescription((CharSequence)null);
      } else if((4 & this.mDisplayOptions) != 0) {
         this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(class_639.string.abc_action_bar_up_description));
      } else {
         this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(class_639.string.abc_action_bar_home_description));
      }
   }

   public void setIcon(int var1) {
      this.setIcon(this.mContext.getResources().getDrawable(var1));
   }

   public void setIcon(Drawable var1) {
      this.mIcon = var1;
      if(var1 != null && ((1 & this.mDisplayOptions) == 0 || this.mLogo == null)) {
         this.mHomeLayout.setIcon(var1);
      }

      if(this.mExpandedActionView != null) {
         this.mExpandedHomeLayout.setIcon(this.mIcon.getConstantState().newDrawable(this.getResources()));
      }

   }

   public void setLogo(int var1) {
      this.setLogo(this.mContext.getResources().getDrawable(var1));
   }

   public void setLogo(Drawable var1) {
      this.mLogo = var1;
      if(var1 != null && (1 & this.mDisplayOptions) != 0) {
         this.mHomeLayout.setIcon(var1);
      }

   }

   public void setMenu(SupportMenu var1, MenuPresenter.Callback var2) {
      if(var1 != this.mOptionsMenu) {
         if(this.mOptionsMenu != null) {
            this.mOptionsMenu.removeMenuPresenter(this.mActionMenuPresenter);
            this.mOptionsMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
         }

         MenuBuilder var3 = (MenuBuilder)var1;
         this.mOptionsMenu = var3;
         if(this.mMenuView != null) {
            ViewGroup var8 = (ViewGroup)this.mMenuView.getParent();
            if(var8 != null) {
               var8.removeView(this.mMenuView);
            }
         }

         if(this.mActionMenuPresenter == null) {
            this.mActionMenuPresenter = new ActionMenuPresenter(this.mContext);
            this.mActionMenuPresenter.setCallback(var2);
            this.mActionMenuPresenter.setId(class_639.class_981.action_menu_presenter);
            this.mExpandedMenuPresenter = new ActionBarView.ExpandedActionViewMenuPresenter(null);
         }

         LayoutParams var4 = new LayoutParams(-2, -1);
         ActionMenuView var5;
         if(!this.mSplitActionBar) {
            this.mActionMenuPresenter.setExpandedActionViewsExclusive(this.getResources().getBoolean(class_639.bool.abc_action_bar_expanded_action_views_exclusive));
            this.configPresenters(var3);
            var5 = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
            var5.initialize(var3);
            ViewGroup var7 = (ViewGroup)var5.getParent();
            if(var7 != null && var7 != this) {
               var7.removeView(var5);
            }

            this.addView(var5, var4);
         } else {
            this.mActionMenuPresenter.setExpandedActionViewsExclusive(false);
            this.mActionMenuPresenter.setWidthLimit(this.getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            var4.width = -1;
            this.configPresenters(var3);
            var5 = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
            if(this.mSplitView != null) {
               ViewGroup var6 = (ViewGroup)var5.getParent();
               if(var6 != null && var6 != this.mSplitView) {
                  var6.removeView(var5);
               }

               var5.setVisibility(this.getAnimatedVisibility());
               this.mSplitView.addView(var5, var4);
            } else {
               var5.setLayoutParams(var4);
            }
         }

         this.mMenuView = var5;
      }
   }

   public void setNavigationMode(int var1) {
      int var2 = this.mNavigationMode;
      if(var1 != var2) {
         switch(var2) {
         case 1:
            if(this.mListNavLayout != null) {
               this.removeView(this.mListNavLayout);
            }
            break;
         case 2:
            if(this.mTabScrollView != null && this.mIncludeTabs) {
               this.removeView(this.mTabScrollView);
            }
         }

         switch(var1) {
         case 1:
            if(this.mSpinner == null) {
               this.mSpinner = new SpinnerICS(this.mContext, (AttributeSet)null, class_639.attr.actionDropDownStyle);
               this.mListNavLayout = (LinearLayout)LayoutInflater.from(this.mContext).inflate(class_639.layout.abc_action_bar_view_list_nav_layout, (ViewGroup)null);
               android.widget.LinearLayout.LayoutParams var3 = new android.widget.LinearLayout.LayoutParams(-2, -1);
               var3.gravity = 17;
               this.mListNavLayout.addView(this.mSpinner, var3);
            }

            if(this.mSpinner.getAdapter() != this.mSpinnerAdapter) {
               this.mSpinner.setAdapter(this.mSpinnerAdapter);
            }

            this.mSpinner.setOnItemSelectedListener(this.mNavItemSelectedListener);
            this.addView(this.mListNavLayout);
            break;
         case 2:
            if(this.mTabScrollView != null && this.mIncludeTabs) {
               this.addView(this.mTabScrollView);
            }
         }

         this.mNavigationMode = var1;
         this.requestLayout();
      }

   }

   public void setSplitActionBar(boolean var1) {
      if(this.mSplitActionBar != var1) {
         if(this.mMenuView != null) {
            ViewGroup var4 = (ViewGroup)this.mMenuView.getParent();
            if(var4 != null) {
               var4.removeView(this.mMenuView);
            }

            if(var1) {
               if(this.mSplitView != null) {
                  this.mSplitView.addView(this.mMenuView);
               }

               this.mMenuView.getLayoutParams().width = -1;
            } else {
               this.addView(this.mMenuView);
               this.mMenuView.getLayoutParams().width = -2;
            }

            this.mMenuView.requestLayout();
         }

         if(this.mSplitView != null) {
            ActionBarContainer var2 = this.mSplitView;
            byte var3;
            if(var1) {
               var3 = 0;
            } else {
               var3 = 8;
            }

            var2.setVisibility(var3);
         }

         if(this.mActionMenuPresenter != null) {
            if(!var1) {
               this.mActionMenuPresenter.setExpandedActionViewsExclusive(this.getResources().getBoolean(class_639.bool.abc_action_bar_expanded_action_views_exclusive));
            } else {
               this.mActionMenuPresenter.setExpandedActionViewsExclusive(false);
               this.mActionMenuPresenter.setWidthLimit(this.getContext().getResources().getDisplayMetrics().widthPixels, true);
               this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            }
         }

         super.setSplitActionBar(var1);
      }

   }

   public void setSubtitle(CharSequence var1) {
      this.mSubtitle = var1;
      if(this.mSubtitleView != null) {
         this.mSubtitleView.setText(var1);
         TextView var2 = this.mSubtitleView;
         byte var3;
         if(var1 != null) {
            var3 = 0;
         } else {
            var3 = 8;
         }

         var2.setVisibility(var3);
         boolean var4;
         if(this.mExpandedActionView != null || (8 & this.mDisplayOptions) == 0 || TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSubtitle)) {
            var4 = false;
         } else {
            var4 = true;
         }

         LinearLayout var5 = this.mTitleLayout;
         byte var6 = 0;
         if(!var4) {
            var6 = 8;
         }

         var5.setVisibility(var6);
      }

   }

   public void setTitle(CharSequence var1) {
      this.mUserTitle = true;
      this.setTitleImpl(var1);
   }

   public void setWindowCallback(Callback var1) {
      this.mWindowCallback = var1;
   }

   public void setWindowTitle(CharSequence var1) {
      if(!this.mUserTitle) {
         this.setTitleImpl(var1);
      }

   }

   public boolean shouldDelayChildPressedState() {
      return false;
   }

   private class ExpandedActionViewMenuPresenter implements MenuPresenter {
      MenuItemImpl mCurrentExpandedItem;
      MenuBuilder mMenu;

      private ExpandedActionViewMenuPresenter() {
      }

      // $FF: synthetic method
      ExpandedActionViewMenuPresenter(Object var2) {
         this();
      }

      public boolean collapseItemActionView(MenuBuilder var1, MenuItemImpl var2) {
         if(ActionBarView.this.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)ActionBarView.this.mExpandedActionView).onActionViewCollapsed();
         }

         ActionBarView.this.removeView(ActionBarView.this.mExpandedActionView);
         ActionBarView.this.removeView(ActionBarView.this.mExpandedHomeLayout);
         ActionBarView.this.mExpandedActionView = null;
         if((2 & ActionBarView.this.mDisplayOptions) != 0) {
            ActionBarView.this.mHomeLayout.setVisibility(0);
         }

         if((8 & ActionBarView.this.mDisplayOptions) != 0) {
            if(ActionBarView.this.mTitleLayout == null) {
               ActionBarView.this.initTitle();
            } else {
               ActionBarView.this.mTitleLayout.setVisibility(0);
            }
         }

         if(ActionBarView.this.mTabScrollView != null && ActionBarView.this.mNavigationMode == 2) {
            ActionBarView.this.mTabScrollView.setVisibility(0);
         }

         if(ActionBarView.this.mSpinner != null && ActionBarView.this.mNavigationMode == 1) {
            ActionBarView.this.mSpinner.setVisibility(0);
         }

         if(ActionBarView.this.mCustomNavView != null && (16 & ActionBarView.this.mDisplayOptions) != 0) {
            ActionBarView.this.mCustomNavView.setVisibility(0);
         }

         ActionBarView.this.mExpandedHomeLayout.setIcon((Drawable)null);
         this.mCurrentExpandedItem = null;
         ActionBarView.this.requestLayout();
         var2.setActionViewExpanded(false);
         return true;
      }

      public boolean expandItemActionView(MenuBuilder var1, MenuItemImpl var2) {
         ActionBarView.this.mExpandedActionView = var2.getActionView();
         ActionBarView.this.mExpandedHomeLayout.setIcon(ActionBarView.this.mIcon.getConstantState().newDrawable(ActionBarView.this.getResources()));
         this.mCurrentExpandedItem = var2;
         if(ActionBarView.this.mExpandedActionView.getParent() != ActionBarView.this) {
            ActionBarView.this.addView(ActionBarView.this.mExpandedActionView);
         }

         if(ActionBarView.this.mExpandedHomeLayout.getParent() != ActionBarView.this) {
            ActionBarView.this.addView(ActionBarView.this.mExpandedHomeLayout);
         }

         ActionBarView.this.mHomeLayout.setVisibility(8);
         if(ActionBarView.this.mTitleLayout != null) {
            ActionBarView.this.mTitleLayout.setVisibility(8);
         }

         if(ActionBarView.this.mTabScrollView != null) {
            ActionBarView.this.mTabScrollView.setVisibility(8);
         }

         if(ActionBarView.this.mSpinner != null) {
            ActionBarView.this.mSpinner.setVisibility(8);
         }

         if(ActionBarView.this.mCustomNavView != null) {
            ActionBarView.this.mCustomNavView.setVisibility(8);
         }

         ActionBarView.this.requestLayout();
         var2.setActionViewExpanded(true);
         if(ActionBarView.this.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)ActionBarView.this.mExpandedActionView).onActionViewExpanded();
         }

         return true;
      }

      public boolean flagActionItems() {
         return false;
      }

      public int getId() {
         return 0;
      }

      public MenuView getMenuView(ViewGroup var1) {
         return null;
      }

      public void initForMenu(Context var1, MenuBuilder var2) {
         if(this.mMenu != null && this.mCurrentExpandedItem != null) {
            this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
         }

         this.mMenu = var2;
      }

      public void onCloseMenu(MenuBuilder var1, boolean var2) {
      }

      public void onRestoreInstanceState(Parcelable var1) {
      }

      public Parcelable onSaveInstanceState() {
         return null;
      }

      public boolean onSubMenuSelected(SubMenuBuilder var1) {
         return false;
      }

      public void setCallback(MenuPresenter.Callback var1) {
      }

      public void updateMenuView(boolean var1) {
         if(this.mCurrentExpandedItem != null) {
            MenuBuilder var2 = this.mMenu;
            boolean var3 = false;
            if(var2 != null) {
               int var5 = this.mMenu.size();
               int var6 = 0;

               while(true) {
                  var3 = false;
                  if(var6 >= var5) {
                     break;
                  }

                  if((SupportMenuItem)this.mMenu.getItem(var6) == this.mCurrentExpandedItem) {
                     var3 = true;
                     break;
                  }

                  ++var6;
               }
            }

            if(!var3) {
               this.collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            }
         }

      }
   }

   private static class HomeView extends FrameLayout {
      private Drawable mDefaultUpIndicator;
      private ImageView mIconView;
      private int mUpIndicatorRes;
      private ImageView mUpView;
      private int mUpWidth;

      public HomeView(Context var1) {
         this(var1, (AttributeSet)null);
      }

      public HomeView(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
         CharSequence var2 = this.getContentDescription();
         if(!TextUtils.isEmpty(var2)) {
            var1.getText().add(var2);
         }

         return true;
      }

      public int getLeftOffset() {
         return this.mUpView.getVisibility() == 8?this.mUpWidth:0;
      }

      protected void onConfigurationChanged(Configuration var1) {
         super.onConfigurationChanged(var1);
         if(this.mUpIndicatorRes != 0) {
            this.setUpIndicator(this.mUpIndicatorRes);
         }

      }

      protected void onFinishInflate() {
         this.mUpView = (ImageView)this.findViewById(class_639.class_981.field_2687);
         this.mIconView = (ImageView)this.findViewById(class_639.class_981.home);
         this.mDefaultUpIndicator = this.mUpView.getDrawable();
      }

      protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
         int var6 = (var5 - var3) / 2;
         int var7 = var4 - var2;
         int var8 = this.mUpView.getVisibility();
         int var9 = 0;
         if(var8 != 8) {
            android.widget.FrameLayout.LayoutParams var16 = (android.widget.FrameLayout.LayoutParams)this.mUpView.getLayoutParams();
            int var17 = this.mUpView.getMeasuredHeight();
            int var18 = this.mUpView.getMeasuredWidth();
            int var19 = var6 - var17 / 2;
            this.mUpView.layout(0, var19, var18, var19 + var17);
            var9 = var18 + var16.leftMargin + var16.rightMargin;
            int var10000 = var7 - var9;
            var2 += var9;
         }

         android.widget.FrameLayout.LayoutParams var10 = (android.widget.FrameLayout.LayoutParams)this.mIconView.getLayoutParams();
         int var11 = this.mIconView.getMeasuredHeight();
         int var12 = this.mIconView.getMeasuredWidth();
         int var13 = (var4 - var2) / 2;
         int var14 = var9 + Math.max(var10.leftMargin, var13 - var12 / 2);
         int var15 = Math.max(var10.topMargin, var6 - var11 / 2);
         this.mIconView.layout(var14, var15, var14 + var12, var15 + var11);
      }

      protected void onMeasure(int var1, int var2) {
         this.measureChildWithMargins(this.mUpView, var1, 0, var2, 0);
         android.widget.FrameLayout.LayoutParams var3 = (android.widget.FrameLayout.LayoutParams)this.mUpView.getLayoutParams();
         this.mUpWidth = var3.leftMargin + this.mUpView.getMeasuredWidth() + var3.rightMargin;
         int var4;
         if(this.mUpView.getVisibility() == 8) {
            var4 = 0;
         } else {
            var4 = this.mUpWidth;
         }

         int var5 = var3.topMargin + this.mUpView.getMeasuredHeight() + var3.bottomMargin;
         this.measureChildWithMargins(this.mIconView, var1, var4, var2, 0);
         android.widget.FrameLayout.LayoutParams var6 = (android.widget.FrameLayout.LayoutParams)this.mIconView.getLayoutParams();
         int var7 = var4 + var6.leftMargin + this.mIconView.getMeasuredWidth() + var6.rightMargin;
         int var8 = Math.max(var5, var6.topMargin + this.mIconView.getMeasuredHeight() + var6.bottomMargin);
         int var9 = MeasureSpec.getMode(var1);
         int var10 = MeasureSpec.getMode(var2);
         int var11 = MeasureSpec.getSize(var1);
         int var12 = MeasureSpec.getSize(var2);
         switch(var9) {
         case Integer.MIN_VALUE:
            var7 = Math.min(var7, var11);
            break;
         case 1073741824:
            var7 = var11;
         }

         switch(var10) {
         case Integer.MIN_VALUE:
            var8 = Math.min(var8, var12);
            break;
         case 1073741824:
            var8 = var12;
         }

         this.setMeasuredDimension(var7, var8);
      }

      public void setIcon(Drawable var1) {
         this.mIconView.setImageDrawable(var1);
      }

      public void setUp(boolean var1) {
         ImageView var2 = this.mUpView;
         byte var3;
         if(var1) {
            var3 = 0;
         } else {
            var3 = 8;
         }

         var2.setVisibility(var3);
      }

      public void setUpIndicator(int var1) {
         this.mUpIndicatorRes = var1;
         ImageView var2 = this.mUpView;
         Drawable var3;
         if(var1 != 0) {
            var3 = this.getResources().getDrawable(var1);
         } else {
            var3 = this.mDefaultUpIndicator;
         }

         var2.setImageDrawable(var3);
      }

      public void setUpIndicator(Drawable var1) {
         ImageView var2 = this.mUpView;
         if(var1 == null) {
            var1 = this.mDefaultUpIndicator;
         }

         var2.setImageDrawable(var1);
         this.mUpIndicatorRes = 0;
      }
   }

   static class SavedState extends BaseSavedState {
      public static final Creator<ActionBarView.SavedState> CREATOR = new Creator() {
         public ActionBarView.SavedState createFromParcel(Parcel var1) {
            return new ActionBarView.SavedState(var1, null);
         }

         public ActionBarView.SavedState[] newArray(int var1) {
            return new ActionBarView.SavedState[var1];
         }
      };
      int expandedMenuItemId;
      boolean isOverflowOpen;

      private SavedState(Parcel var1) {
         super(var1);
         this.expandedMenuItemId = var1.readInt();
         boolean var2;
         if(var1.readInt() != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.isOverflowOpen = var2;
      }

      // $FF: synthetic method
      SavedState(Parcel var1, Object var2) {
         this(var1);
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.expandedMenuItemId);
         byte var3;
         if(this.isOverflowOpen) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
      }
   }
}
