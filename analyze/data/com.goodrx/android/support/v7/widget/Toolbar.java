package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.RtlSpacingHelper;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.support.v7.widget.ViewUtils;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
   private static final String TAG = "Toolbar";
   private MenuPresenter.Callback mActionMenuPresenterCallback;
   private int mButtonGravity;
   private ImageButton mCollapseButtonView;
   private CharSequence mCollapseDescription;
   private Drawable mCollapseIcon;
   private boolean mCollapsible;
   private final RtlSpacingHelper mContentInsets;
   private final AppCompatDrawableManager mDrawableManager;
   private boolean mEatingHover;
   private boolean mEatingTouch;
   View mExpandedActionView;
   private Toolbar.ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
   private int mGravity;
   private final ArrayList<View> mHiddenViews;
   private ImageView mLogoView;
   private int mMaxButtonHeight;
   private MenuBuilder.Callback mMenuBuilderCallback;
   private ActionMenuView mMenuView;
   private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
   private ImageButton mNavButtonView;
   private Toolbar.OnMenuItemClickListener mOnMenuItemClickListener;
   private ActionMenuPresenter mOuterActionMenuPresenter;
   private Context mPopupContext;
   private int mPopupTheme;
   private final Runnable mShowOverflowMenuRunnable;
   private CharSequence mSubtitleText;
   private int mSubtitleTextAppearance;
   private int mSubtitleTextColor;
   private TextView mSubtitleTextView;
   private final int[] mTempMargins;
   private final ArrayList<View> mTempViews;
   private int mTitleMarginBottom;
   private int mTitleMarginEnd;
   private int mTitleMarginStart;
   private int mTitleMarginTop;
   private CharSequence mTitleText;
   private int mTitleTextAppearance;
   private int mTitleTextColor;
   private TextView mTitleTextView;
   private ToolbarWidgetWrapper mWrapper;

   public Toolbar(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public Toolbar(Context var1, @Nullable AttributeSet var2) {
      this(var1, var2, class_22.attr.toolbarStyle);
   }

   public Toolbar(Context var1, @Nullable AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mContentInsets = new RtlSpacingHelper();
      this.mGravity = 8388627;
      this.mTempViews = new ArrayList();
      this.mHiddenViews = new ArrayList();
      this.mTempMargins = new int[2];
      ActionMenuView.OnMenuItemClickListener var4 = new ActionMenuView.OnMenuItemClickListener() {
         public boolean onMenuItemClick(MenuItem var1) {
            return Toolbar.this.mOnMenuItemClickListener != null?Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(var1):false;
         }
      };
      this.mMenuViewItemClickListener = var4;
      Runnable var5 = new Runnable() {
         public void run() {
            Toolbar.this.showOverflowMenu();
         }
      };
      this.mShowOverflowMenuRunnable = var5;
      TintTypedArray var6 = TintTypedArray.obtainStyledAttributes(this.getContext(), var2, class_22.styleable.Toolbar, var3, 0);
      this.mTitleTextAppearance = var6.getResourceId(class_22.styleable.Toolbar_titleTextAppearance, 0);
      this.mSubtitleTextAppearance = var6.getResourceId(class_22.styleable.Toolbar_subtitleTextAppearance, 0);
      this.mGravity = var6.getInteger(class_22.styleable.Toolbar_android_gravity, this.mGravity);
      this.mButtonGravity = 48;
      int var7 = var6.getDimensionPixelOffset(class_22.styleable.Toolbar_titleMargins, 0);
      this.mTitleMarginBottom = var7;
      this.mTitleMarginTop = var7;
      this.mTitleMarginEnd = var7;
      this.mTitleMarginStart = var7;
      int var8 = var6.getDimensionPixelOffset(class_22.styleable.Toolbar_titleMarginStart, -1);
      if(var8 >= 0) {
         this.mTitleMarginStart = var8;
      }

      int var9 = var6.getDimensionPixelOffset(class_22.styleable.Toolbar_titleMarginEnd, -1);
      if(var9 >= 0) {
         this.mTitleMarginEnd = var9;
      }

      int var10 = var6.getDimensionPixelOffset(class_22.styleable.Toolbar_titleMarginTop, -1);
      if(var10 >= 0) {
         this.mTitleMarginTop = var10;
      }

      int var11 = var6.getDimensionPixelOffset(class_22.styleable.Toolbar_titleMarginBottom, -1);
      if(var11 >= 0) {
         this.mTitleMarginBottom = var11;
      }

      this.mMaxButtonHeight = var6.getDimensionPixelSize(class_22.styleable.Toolbar_maxButtonHeight, -1);
      int var12 = var6.getDimensionPixelOffset(class_22.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
      int var13 = var6.getDimensionPixelOffset(class_22.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
      int var14 = var6.getDimensionPixelSize(class_22.styleable.Toolbar_contentInsetLeft, 0);
      int var15 = var6.getDimensionPixelSize(class_22.styleable.Toolbar_contentInsetRight, 0);
      this.mContentInsets.setAbsolute(var14, var15);
      if(var12 != Integer.MIN_VALUE || var13 != Integer.MIN_VALUE) {
         this.mContentInsets.setRelative(var12, var13);
      }

      this.mCollapseIcon = var6.getDrawable(class_22.styleable.Toolbar_collapseIcon);
      this.mCollapseDescription = var6.getText(class_22.styleable.Toolbar_collapseContentDescription);
      CharSequence var16 = var6.getText(class_22.styleable.Toolbar_title);
      if(!TextUtils.isEmpty(var16)) {
         this.setTitle(var16);
      }

      CharSequence var17 = var6.getText(class_22.styleable.Toolbar_subtitle);
      if(!TextUtils.isEmpty(var17)) {
         this.setSubtitle(var17);
      }

      this.mPopupContext = this.getContext();
      this.setPopupTheme(var6.getResourceId(class_22.styleable.Toolbar_popupTheme, 0));
      Drawable var18 = var6.getDrawable(class_22.styleable.Toolbar_navigationIcon);
      if(var18 != null) {
         this.setNavigationIcon(var18);
      }

      CharSequence var19 = var6.getText(class_22.styleable.Toolbar_navigationContentDescription);
      if(!TextUtils.isEmpty(var19)) {
         this.setNavigationContentDescription(var19);
      }

      Drawable var20 = var6.getDrawable(class_22.styleable.Toolbar_logo);
      if(var20 != null) {
         this.setLogo(var20);
      }

      CharSequence var21 = var6.getText(class_22.styleable.Toolbar_logoDescription);
      if(!TextUtils.isEmpty(var21)) {
         this.setLogoDescription(var21);
      }

      if(var6.hasValue(class_22.styleable.Toolbar_titleTextColor)) {
         this.setTitleTextColor(var6.getColor(class_22.styleable.Toolbar_titleTextColor, -1));
      }

      if(var6.hasValue(class_22.styleable.Toolbar_subtitleTextColor)) {
         this.setSubtitleTextColor(var6.getColor(class_22.styleable.Toolbar_subtitleTextColor, -1));
      }

      var6.recycle();
      this.mDrawableManager = AppCompatDrawableManager.get();
   }

   private void addCustomViewsWithGravity(List<View> var1, int var2) {
      byte var3 = 1;
      if(ViewCompat.getLayoutDirection(this) != var3) {
         var3 = 0;
      }

      int var4 = this.getChildCount();
      int var5 = GravityCompat.getAbsoluteGravity(var2, ViewCompat.getLayoutDirection(this));
      var1.clear();
      if(var3 != 0) {
         for(int var10 = var4 - 1; var10 >= 0; --var10) {
            View var11 = this.getChildAt(var10);
            Toolbar.LayoutParams var12 = (Toolbar.LayoutParams)var11.getLayoutParams();
            if(var12.mViewType == 0 && this.shouldLayout(var11) && this.getChildHorizontalGravity(var12.gravity) == var5) {
               var1.add(var11);
            }
         }
      } else {
         for(int var6 = 0; var6 < var4; ++var6) {
            View var7 = this.getChildAt(var6);
            Toolbar.LayoutParams var8 = (Toolbar.LayoutParams)var7.getLayoutParams();
            if(var8.mViewType == 0 && this.shouldLayout(var7) && this.getChildHorizontalGravity(var8.gravity) == var5) {
               var1.add(var7);
            }
         }
      }

   }

   private void addSystemView(View var1, boolean var2) {
      android.view.ViewGroup.LayoutParams var3 = var1.getLayoutParams();
      Toolbar.LayoutParams var4;
      if(var3 == null) {
         var4 = this.generateDefaultLayoutParams();
      } else if(!this.checkLayoutParams(var3)) {
         var4 = this.generateLayoutParams(var3);
      } else {
         var4 = (Toolbar.LayoutParams)var3;
      }

      var4.mViewType = 1;
      if(var2 && this.mExpandedActionView != null) {
         var1.setLayoutParams(var4);
         this.mHiddenViews.add(var1);
      } else {
         this.addView(var1, var4);
      }
   }

   private void ensureCollapseButtonView() {
      if(this.mCollapseButtonView == null) {
         this.mCollapseButtonView = new ImageButton(this.getContext(), (AttributeSet)null, class_22.attr.toolbarNavigationButtonStyle);
         this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
         this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
         Toolbar.LayoutParams var1 = this.generateDefaultLayoutParams();
         var1.gravity = 8388611 | 112 & this.mButtonGravity;
         var1.mViewType = 2;
         this.mCollapseButtonView.setLayoutParams(var1);
         this.mCollapseButtonView.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               Toolbar.this.collapseActionView();
            }
         });
      }

   }

   private void ensureLogoView() {
      if(this.mLogoView == null) {
         this.mLogoView = new ImageView(this.getContext());
      }

   }

   private void ensureMenu() {
      this.ensureMenuView();
      if(this.mMenuView.peekMenu() == null) {
         MenuBuilder var1 = (MenuBuilder)this.mMenuView.getMenu();
         if(this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new Toolbar.ExpandedActionViewMenuPresenter(null);
         }

         this.mMenuView.setExpandedActionViewsExclusive(true);
         var1.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
      }

   }

   private void ensureMenuView() {
      if(this.mMenuView == null) {
         this.mMenuView = new ActionMenuView(this.getContext());
         this.mMenuView.setPopupTheme(this.mPopupTheme);
         this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
         this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
         Toolbar.LayoutParams var1 = this.generateDefaultLayoutParams();
         var1.gravity = 8388613 | 112 & this.mButtonGravity;
         this.mMenuView.setLayoutParams(var1);
         this.addSystemView(this.mMenuView, false);
      }

   }

   private void ensureNavButtonView() {
      if(this.mNavButtonView == null) {
         this.mNavButtonView = new ImageButton(this.getContext(), (AttributeSet)null, class_22.attr.toolbarNavigationButtonStyle);
         Toolbar.LayoutParams var1 = this.generateDefaultLayoutParams();
         var1.gravity = 8388611 | 112 & this.mButtonGravity;
         this.mNavButtonView.setLayoutParams(var1);
      }

   }

   private int getChildHorizontalGravity(int var1) {
      int var2 = ViewCompat.getLayoutDirection(this);
      int var3 = 7 & GravityCompat.getAbsoluteGravity(var1, var2);
      switch(var3) {
      case 2:
      case 4:
      default:
         byte var4;
         if(var2 == 1) {
            var4 = 5;
         } else {
            var4 = 3;
         }

         var3 = var4;
      case 1:
      case 3:
      case 5:
         return var3;
      }
   }

   private int getChildTop(View var1, int var2) {
      Toolbar.LayoutParams var3 = (Toolbar.LayoutParams)var1.getLayoutParams();
      int var4 = var1.getMeasuredHeight();
      int var5;
      if(var2 > 0) {
         var5 = (var4 - var2) / 2;
      } else {
         var5 = 0;
      }

      switch(this.getChildVerticalGravity(var3.gravity)) {
      case 48:
         return this.getPaddingTop() - var5;
      case 80:
         return this.getHeight() - this.getPaddingBottom() - var4 - var3.bottomMargin - var5;
      default:
         int var6 = this.getPaddingTop();
         int var7 = this.getPaddingBottom();
         int var8 = this.getHeight();
         int var9 = (var8 - var6 - var7 - var4) / 2;
         if(var9 < var3.topMargin) {
            var9 = var3.topMargin;
         } else {
            int var10 = var8 - var7 - var4 - var9 - var6;
            if(var10 < var3.bottomMargin) {
               var9 = Math.max(0, var9 - (var3.bottomMargin - var10));
            }
         }

         return var6 + var9;
      }
   }

   private int getChildVerticalGravity(int var1) {
      int var2 = var1 & 112;
      switch(var2) {
      default:
         var2 = 112 & this.mGravity;
      case 16:
      case 48:
      case 80:
         return var2;
      }
   }

   private int getHorizontalMargins(View var1) {
      MarginLayoutParams var2 = (MarginLayoutParams)var1.getLayoutParams();
      return MarginLayoutParamsCompat.getMarginStart(var2) + MarginLayoutParamsCompat.getMarginEnd(var2);
   }

   private MenuInflater getMenuInflater() {
      return new SupportMenuInflater(this.getContext());
   }

   private int getVerticalMargins(View var1) {
      MarginLayoutParams var2 = (MarginLayoutParams)var1.getLayoutParams();
      return var2.topMargin + var2.bottomMargin;
   }

   private int getViewListMeasuredWidth(List<View> var1, int[] var2) {
      int var3 = var2[0];
      int var4 = var2[1];
      int var5 = 0;
      int var6 = var1.size();

      for(int var7 = 0; var7 < var6; ++var7) {
         View var8 = (View)var1.get(var7);
         Toolbar.LayoutParams var9 = (Toolbar.LayoutParams)var8.getLayoutParams();
         int var10 = var9.leftMargin - var3;
         int var11 = var9.rightMargin - var4;
         int var12 = Math.max(0, var10);
         int var13 = Math.max(0, var11);
         var3 = Math.max(0, -var10);
         var4 = Math.max(0, -var11);
         var5 += var13 + var12 + var8.getMeasuredWidth();
      }

      return var5;
   }

   private boolean isChildOrHidden(View var1) {
      return var1.getParent() == this || this.mHiddenViews.contains(var1);
   }

   private static boolean isCustomView(View var0) {
      return ((Toolbar.LayoutParams)var0.getLayoutParams()).mViewType == 0;
   }

   private int layoutChildLeft(View var1, int var2, int[] var3, int var4) {
      Toolbar.LayoutParams var5 = (Toolbar.LayoutParams)var1.getLayoutParams();
      int var6 = var5.leftMargin - var3[0];
      int var7 = var2 + Math.max(0, var6);
      var3[0] = Math.max(0, -var6);
      int var8 = this.getChildTop(var1, var4);
      int var9 = var1.getMeasuredWidth();
      var1.layout(var7, var8, var7 + var9, var8 + var1.getMeasuredHeight());
      return var7 + var9 + var5.rightMargin;
   }

   private int layoutChildRight(View var1, int var2, int[] var3, int var4) {
      Toolbar.LayoutParams var5 = (Toolbar.LayoutParams)var1.getLayoutParams();
      int var6 = var5.rightMargin - var3[1];
      int var7 = var2 - Math.max(0, var6);
      var3[1] = Math.max(0, -var6);
      int var8 = this.getChildTop(var1, var4);
      int var9 = var1.getMeasuredWidth();
      var1.layout(var7 - var9, var8, var7, var8 + var1.getMeasuredHeight());
      return var7 - (var9 + var5.leftMargin);
   }

   private int measureChildCollapseMargins(View var1, int var2, int var3, int var4, int var5, int[] var6) {
      MarginLayoutParams var7 = (MarginLayoutParams)var1.getLayoutParams();
      int var8 = var7.leftMargin - var6[0];
      int var9 = var7.rightMargin - var6[1];
      int var10 = Math.max(0, var8) + Math.max(0, var9);
      var6[0] = Math.max(0, -var8);
      var6[1] = Math.max(0, -var9);
      var1.measure(getChildMeasureSpec(var2, var3 + var10 + this.getPaddingLeft() + this.getPaddingRight(), var7.width), getChildMeasureSpec(var4, var5 + this.getPaddingTop() + this.getPaddingBottom() + var7.topMargin + var7.bottomMargin, var7.height));
      return var10 + var1.getMeasuredWidth();
   }

   private void measureChildConstrained(View var1, int var2, int var3, int var4, int var5, int var6) {
      MarginLayoutParams var7 = (MarginLayoutParams)var1.getLayoutParams();
      int var8 = getChildMeasureSpec(var2, var3 + this.getPaddingLeft() + this.getPaddingRight() + var7.leftMargin + var7.rightMargin, var7.width);
      int var9 = getChildMeasureSpec(var4, var5 + this.getPaddingTop() + this.getPaddingBottom() + var7.topMargin + var7.bottomMargin, var7.height);
      int var10 = MeasureSpec.getMode(var9);
      if(var10 != 1073741824 && var6 >= 0) {
         int var11;
         if(var10 != 0) {
            var11 = Math.min(MeasureSpec.getSize(var9), var6);
         } else {
            var11 = var6;
         }

         var9 = MeasureSpec.makeMeasureSpec(var11, 1073741824);
      }

      var1.measure(var8, var9);
   }

   private void postShowOverflowMenu() {
      this.removeCallbacks(this.mShowOverflowMenuRunnable);
      this.post(this.mShowOverflowMenuRunnable);
   }

   private boolean shouldCollapse() {
      if(this.mCollapsible) {
         int var1 = this.getChildCount();
         int var2 = 0;

         while(true) {
            if(var2 >= var1) {
               return true;
            }

            View var3 = this.getChildAt(var2);
            if(this.shouldLayout(var3) && var3.getMeasuredWidth() > 0 && var3.getMeasuredHeight() > 0) {
               break;
            }

            ++var2;
         }
      }

      return false;
   }

   private boolean shouldLayout(View var1) {
      return var1 != null && var1.getParent() == this && var1.getVisibility() != 8;
   }

   void addChildrenForExpandedActionView() {
      for(int var1 = -1 + this.mHiddenViews.size(); var1 >= 0; --var1) {
         this.addView((View)this.mHiddenViews.get(var1));
      }

      this.mHiddenViews.clear();
   }

   public boolean canShowOverflowMenu() {
      return this.getVisibility() == 0 && this.mMenuView != null && this.mMenuView.isOverflowReserved();
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return super.checkLayoutParams(var1) && var1 instanceof Toolbar.LayoutParams;
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

   public void dismissPopupMenus() {
      if(this.mMenuView != null) {
         this.mMenuView.dismissPopupMenus();
      }

   }

   protected Toolbar.LayoutParams generateDefaultLayoutParams() {
      return new Toolbar.LayoutParams(-2, -2);
   }

   public Toolbar.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new Toolbar.LayoutParams(this.getContext(), var1);
   }

   protected Toolbar.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof Toolbar.LayoutParams?new Toolbar.LayoutParams((Toolbar.LayoutParams)var1):(var1 instanceof ActionBar.LayoutParams?new Toolbar.LayoutParams((ActionBar.LayoutParams)var1):(var1 instanceof MarginLayoutParams?new Toolbar.LayoutParams((MarginLayoutParams)var1):new Toolbar.LayoutParams(var1)));
   }

   public int getContentInsetEnd() {
      return this.mContentInsets.getEnd();
   }

   public int getContentInsetLeft() {
      return this.mContentInsets.getLeft();
   }

   public int getContentInsetRight() {
      return this.mContentInsets.getRight();
   }

   public int getContentInsetStart() {
      return this.mContentInsets.getStart();
   }

   public Drawable getLogo() {
      return this.mLogoView != null?this.mLogoView.getDrawable():null;
   }

   public CharSequence getLogoDescription() {
      return this.mLogoView != null?this.mLogoView.getContentDescription():null;
   }

   public Menu getMenu() {
      this.ensureMenu();
      return this.mMenuView.getMenu();
   }

   @Nullable
   public CharSequence getNavigationContentDescription() {
      return this.mNavButtonView != null?this.mNavButtonView.getContentDescription():null;
   }

   @Nullable
   public Drawable getNavigationIcon() {
      return this.mNavButtonView != null?this.mNavButtonView.getDrawable():null;
   }

   @Nullable
   public Drawable getOverflowIcon() {
      this.ensureMenu();
      return this.mMenuView.getOverflowIcon();
   }

   public int getPopupTheme() {
      return this.mPopupTheme;
   }

   public CharSequence getSubtitle() {
      return this.mSubtitleText;
   }

   public CharSequence getTitle() {
      return this.mTitleText;
   }

   public DecorToolbar getWrapper() {
      if(this.mWrapper == null) {
         this.mWrapper = new ToolbarWidgetWrapper(this, true);
      }

      return this.mWrapper;
   }

   public boolean hasExpandedActionView() {
      return this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null;
   }

   public boolean hideOverflowMenu() {
      return this.mMenuView != null && this.mMenuView.hideOverflowMenu();
   }

   public void inflateMenu(@MenuRes int var1) {
      this.getMenuInflater().inflate(var1, this.getMenu());
   }

   public boolean isOverflowMenuShowPending() {
      return this.mMenuView != null && this.mMenuView.isOverflowMenuShowPending();
   }

   public boolean isOverflowMenuShowing() {
      return this.mMenuView != null && this.mMenuView.isOverflowMenuShowing();
   }

   public boolean isTitleTruncated() {
      if(this.mTitleTextView != null) {
         Layout var1 = this.mTitleTextView.getLayout();
         if(var1 != null) {
            int var2 = var1.getLineCount();

            for(int var3 = 0; var3 < var2; ++var3) {
               if(var1.getEllipsisCount(var3) > 0) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.removeCallbacks(this.mShowOverflowMenuRunnable);
   }

   public boolean onHoverEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      if(var2 == 9) {
         this.mEatingHover = false;
      }

      if(!this.mEatingHover) {
         boolean var3 = super.onHoverEvent(var1);
         if(var2 == 9 && !var3) {
            this.mEatingHover = true;
         }
      }

      if(var2 == 10 || var2 == 3) {
         this.mEatingHover = false;
      }

      return true;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      boolean var6;
      if(ViewCompat.getLayoutDirection(this) == 1) {
         var6 = true;
      } else {
         var6 = false;
      }

      int var7 = this.getWidth();
      int var8 = this.getHeight();
      int var9 = this.getPaddingLeft();
      int var10 = this.getPaddingRight();
      int var11 = this.getPaddingTop();
      int var12 = this.getPaddingBottom();
      int var13 = var9;
      int var14 = var7 - var10;
      int[] var15 = this.mTempMargins;
      var15[1] = 0;
      var15[0] = 0;
      int var16 = ViewCompat.getMinimumHeight(this);
      if(this.shouldLayout(this.mNavButtonView)) {
         if(var6) {
            var14 = this.layoutChildRight(this.mNavButtonView, var14, var15, var16);
         } else {
            var13 = this.layoutChildLeft(this.mNavButtonView, var9, var15, var16);
         }
      }

      if(this.shouldLayout(this.mCollapseButtonView)) {
         if(var6) {
            var14 = this.layoutChildRight(this.mCollapseButtonView, var14, var15, var16);
         } else {
            var13 = this.layoutChildLeft(this.mCollapseButtonView, var13, var15, var16);
         }
      }

      if(this.shouldLayout(this.mMenuView)) {
         if(var6) {
            var13 = this.layoutChildLeft(this.mMenuView, var13, var15, var16);
         } else {
            var14 = this.layoutChildRight(this.mMenuView, var14, var15, var16);
         }
      }

      var15[0] = Math.max(0, this.getContentInsetLeft() - var13);
      var15[1] = Math.max(0, this.getContentInsetRight() - (var7 - var10 - var14));
      int var17 = this.getContentInsetLeft();
      int var18 = Math.max(var13, var17);
      int var19 = var7 - var10 - this.getContentInsetRight();
      int var20 = Math.min(var14, var19);
      if(this.shouldLayout(this.mExpandedActionView)) {
         if(var6) {
            var20 = this.layoutChildRight(this.mExpandedActionView, var20, var15, var16);
         } else {
            var18 = this.layoutChildLeft(this.mExpandedActionView, var18, var15, var16);
         }
      }

      if(this.shouldLayout(this.mLogoView)) {
         if(var6) {
            var20 = this.layoutChildRight(this.mLogoView, var20, var15, var16);
         } else {
            var18 = this.layoutChildLeft(this.mLogoView, var18, var15, var16);
         }
      }

      boolean var21 = this.shouldLayout(this.mTitleTextView);
      boolean var22 = this.shouldLayout(this.mSubtitleTextView);
      int var23 = 0;
      if(var21) {
         Toolbar.LayoutParams var67 = (Toolbar.LayoutParams)this.mTitleTextView.getLayoutParams();
         var23 = 0 + var67.topMargin + this.mTitleTextView.getMeasuredHeight() + var67.bottomMargin;
      }

      if(var22) {
         Toolbar.LayoutParams var66 = (Toolbar.LayoutParams)this.mSubtitleTextView.getLayoutParams();
         var23 += var66.topMargin + this.mSubtitleTextView.getMeasuredHeight() + var66.bottomMargin;
      }

      if(var21 || var22) {
         TextView var24;
         if(var21) {
            var24 = this.mTitleTextView;
         } else {
            var24 = this.mSubtitleTextView;
         }

         TextView var25;
         if(var22) {
            var25 = this.mSubtitleTextView;
         } else {
            var25 = this.mTitleTextView;
         }

         Toolbar.LayoutParams var26 = (Toolbar.LayoutParams)var24.getLayoutParams();
         Toolbar.LayoutParams var27 = (Toolbar.LayoutParams)var25.getLayoutParams();
         boolean var28;
         if((!var21 || this.mTitleTextView.getMeasuredWidth() <= 0) && (!var22 || this.mSubtitleTextView.getMeasuredWidth() <= 0)) {
            var28 = false;
         } else {
            var28 = true;
         }

         int var29;
         switch(112 & this.mGravity) {
         case 48:
            var29 = this.getPaddingTop() + var26.topMargin + this.mTitleMarginTop;
            break;
         case 80:
            var29 = var8 - var12 - var27.bottomMargin - this.mTitleMarginBottom - var23;
            break;
         default:
            int var63 = (var8 - var11 - var12 - var23) / 2;
            int var64 = var26.topMargin + this.mTitleMarginTop;
            if(var63 < var64) {
               var63 = var26.topMargin + this.mTitleMarginTop;
            } else {
               int var65 = var8 - var12 - var23 - var63 - var11;
               if(var65 < var26.bottomMargin + this.mTitleMarginBottom) {
                  var63 = Math.max(0, var63 - (var27.bottomMargin + this.mTitleMarginBottom - var65));
               }
            }

            var29 = var11 + var63;
         }

         int var10000;
         if(var6) {
            int var51;
            if(var28) {
               var51 = this.mTitleMarginStart;
            } else {
               var51 = 0;
            }

            int var52 = var51 - var15[1];
            var20 -= Math.max(0, var52);
            var15[1] = Math.max(0, -var52);
            int var53 = var20;
            int var54 = var20;
            if(var21) {
               Toolbar.LayoutParams var60 = (Toolbar.LayoutParams)this.mTitleTextView.getLayoutParams();
               int var61 = var20 - this.mTitleTextView.getMeasuredWidth();
               int var62 = var29 + this.mTitleTextView.getMeasuredHeight();
               this.mTitleTextView.layout(var61, var29, var20, var62);
               var53 = var61 - this.mTitleMarginEnd;
               var29 = var62 + var60.bottomMargin;
            }

            if(var22) {
               Toolbar.LayoutParams var55 = (Toolbar.LayoutParams)this.mSubtitleTextView.getLayoutParams();
               int var56 = var29 + var55.topMargin;
               int var57 = var20 - this.mSubtitleTextView.getMeasuredWidth();
               int var58 = var56 + this.mSubtitleTextView.getMeasuredHeight();
               this.mSubtitleTextView.layout(var57, var56, var20, var58);
               var54 = var20 - this.mTitleMarginEnd;
               var10000 = var58 + var55.bottomMargin;
            }

            if(var28) {
               var20 = Math.min(var53, var54);
            }
         } else {
            int var30;
            if(var28) {
               var30 = this.mTitleMarginStart;
            } else {
               var30 = 0;
            }

            int var31 = var30 - var15[0];
            var18 += Math.max(0, var31);
            var15[0] = Math.max(0, -var31);
            int var32 = var18;
            int var33 = var18;
            if(var21) {
               Toolbar.LayoutParams var48 = (Toolbar.LayoutParams)this.mTitleTextView.getLayoutParams();
               int var49 = var18 + this.mTitleTextView.getMeasuredWidth();
               int var50 = var29 + this.mTitleTextView.getMeasuredHeight();
               this.mTitleTextView.layout(var18, var29, var49, var50);
               var32 = var49 + this.mTitleMarginEnd;
               var29 = var50 + var48.bottomMargin;
            }

            if(var22) {
               Toolbar.LayoutParams var43 = (Toolbar.LayoutParams)this.mSubtitleTextView.getLayoutParams();
               int var44 = var29 + var43.topMargin;
               int var45 = var18 + this.mSubtitleTextView.getMeasuredWidth();
               int var46 = var44 + this.mSubtitleTextView.getMeasuredHeight();
               this.mSubtitleTextView.layout(var18, var44, var45, var46);
               var33 = var45 + this.mTitleMarginEnd;
               var10000 = var46 + var43.bottomMargin;
            }

            if(var28) {
               var18 = Math.max(var32, var33);
            }
         }
      }

      this.addCustomViewsWithGravity(this.mTempViews, 3);
      int var34 = this.mTempViews.size();

      for(int var35 = 0; var35 < var34; ++var35) {
         var18 = this.layoutChildLeft((View)this.mTempViews.get(var35), var18, var15, var16);
      }

      this.addCustomViewsWithGravity(this.mTempViews, 5);
      int var36 = this.mTempViews.size();

      for(int var37 = 0; var37 < var36; ++var37) {
         var20 = this.layoutChildRight((View)this.mTempViews.get(var37), var20, var15, var16);
      }

      this.addCustomViewsWithGravity(this.mTempViews, 1);
      int var38 = this.getViewListMeasuredWidth(this.mTempViews, var15);
      int var39 = var9 + (var7 - var9 - var10) / 2 - var38 / 2;
      int var40 = var39 + var38;
      if(var39 < var18) {
         var39 = var18;
      } else if(var40 > var20) {
         var39 -= var40 - var20;
      }

      int var41 = this.mTempViews.size();

      for(int var42 = 0; var42 < var41; ++var42) {
         var39 = this.layoutChildLeft((View)this.mTempViews.get(var42), var39, var15, var16);
      }

      this.mTempViews.clear();
   }

   protected void onMeasure(int var1, int var2) {
      int[] var3 = this.mTempMargins;
      byte var4;
      byte var5;
      if(ViewUtils.isLayoutRtl(this)) {
         var5 = 1;
         var4 = 0;
      } else {
         var4 = 1;
         var5 = 0;
      }

      boolean var6 = this.shouldLayout(this.mNavButtonView);
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      if(var6) {
         this.measureChildConstrained(this.mNavButtonView, var1, 0, var2, 0, this.mMaxButtonHeight);
         var9 = this.mNavButtonView.getMeasuredWidth() + this.getHorizontalMargins(this.mNavButtonView);
         var8 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + this.getVerticalMargins(this.mNavButtonView));
         var7 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mNavButtonView));
      }

      if(this.shouldLayout(this.mCollapseButtonView)) {
         this.measureChildConstrained(this.mCollapseButtonView, var1, 0, var2, 0, this.mMaxButtonHeight);
         var9 = this.mCollapseButtonView.getMeasuredWidth() + this.getHorizontalMargins(this.mCollapseButtonView);
         int var42 = this.mCollapseButtonView.getMeasuredHeight() + this.getVerticalMargins(this.mCollapseButtonView);
         var8 = Math.max(var8, var42);
         int var43 = ViewCompat.getMeasuredState(this.mCollapseButtonView);
         var7 = ViewUtils.combineMeasuredStates(var7, var43);
      }

      int var10 = this.getContentInsetStart();
      int var11 = 0 + Math.max(var10, var9);
      var3[var5] = Math.max(0, var10 - var9);
      boolean var12 = this.shouldLayout(this.mMenuView);
      int var13 = 0;
      if(var12) {
         this.measureChildConstrained(this.mMenuView, var1, var11, var2, 0, this.mMaxButtonHeight);
         var13 = this.mMenuView.getMeasuredWidth() + this.getHorizontalMargins(this.mMenuView);
         int var40 = this.mMenuView.getMeasuredHeight() + this.getVerticalMargins(this.mMenuView);
         var8 = Math.max(var8, var40);
         int var41 = ViewCompat.getMeasuredState(this.mMenuView);
         var7 = ViewUtils.combineMeasuredStates(var7, var41);
      }

      int var14 = this.getContentInsetEnd();
      int var15 = var11 + Math.max(var14, var13);
      var3[var4] = Math.max(0, var14 - var13);
      if(this.shouldLayout(this.mExpandedActionView)) {
         var15 += this.measureChildCollapseMargins(this.mExpandedActionView, var1, var15, var2, 0, var3);
         int var38 = this.mExpandedActionView.getMeasuredHeight() + this.getVerticalMargins(this.mExpandedActionView);
         var8 = Math.max(var8, var38);
         int var39 = ViewCompat.getMeasuredState(this.mExpandedActionView);
         var7 = ViewUtils.combineMeasuredStates(var7, var39);
      }

      if(this.shouldLayout(this.mLogoView)) {
         var15 += this.measureChildCollapseMargins(this.mLogoView, var1, var15, var2, 0, var3);
         int var36 = this.mLogoView.getMeasuredHeight() + this.getVerticalMargins(this.mLogoView);
         var8 = Math.max(var8, var36);
         int var37 = ViewCompat.getMeasuredState(this.mLogoView);
         var7 = ViewUtils.combineMeasuredStates(var7, var37);
      }

      int var16 = this.getChildCount();

      for(int var17 = 0; var17 < var16; ++var17) {
         View var33 = this.getChildAt(var17);
         if(((Toolbar.LayoutParams)var33.getLayoutParams()).mViewType == 0 && this.shouldLayout(var33)) {
            var15 += this.measureChildCollapseMargins(var33, var1, var15, var2, 0, var3);
            int var34 = var33.getMeasuredHeight() + this.getVerticalMargins(var33);
            var8 = Math.max(var8, var34);
            int var35 = ViewCompat.getMeasuredState(var33);
            var7 = ViewUtils.combineMeasuredStates(var7, var35);
         }
      }

      int var18 = this.mTitleMarginTop + this.mTitleMarginBottom;
      int var19 = this.mTitleMarginStart + this.mTitleMarginEnd;
      boolean var20 = this.shouldLayout(this.mTitleTextView);
      int var21 = 0;
      int var22 = 0;
      if(var20) {
         this.measureChildCollapseMargins(this.mTitleTextView, var1, var15 + var19, var2, var18, var3);
         var22 = this.mTitleTextView.getMeasuredWidth() + this.getHorizontalMargins(this.mTitleTextView);
         var21 = this.mTitleTextView.getMeasuredHeight() + this.getVerticalMargins(this.mTitleTextView);
         int var32 = ViewCompat.getMeasuredState(this.mTitleTextView);
         var7 = ViewUtils.combineMeasuredStates(var7, var32);
      }

      if(this.shouldLayout(this.mSubtitleTextView)) {
         int var29 = this.measureChildCollapseMargins(this.mSubtitleTextView, var1, var15 + var19, var2, var21 + var18, var3);
         var22 = Math.max(var22, var29);
         var21 += this.mSubtitleTextView.getMeasuredHeight() + this.getVerticalMargins(this.mSubtitleTextView);
         int var30 = ViewCompat.getMeasuredState(this.mSubtitleTextView);
         var7 = ViewUtils.combineMeasuredStates(var7, var30);
      }

      int var23 = var15 + var22;
      int var24 = Math.max(var8, var21);
      int var25 = var23 + this.getPaddingLeft() + this.getPaddingRight();
      int var26 = var24 + this.getPaddingTop() + this.getPaddingBottom();
      int var27 = ViewCompat.resolveSizeAndState(Math.max(var25, this.getSuggestedMinimumWidth()), var1, -16777216 & var7);
      int var28 = ViewCompat.resolveSizeAndState(Math.max(var26, this.getSuggestedMinimumHeight()), var2, var7 << 16);
      if(this.shouldCollapse()) {
         var28 = 0;
      }

      this.setMeasuredDimension(var27, var28);
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      Toolbar.SavedState var2 = (Toolbar.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      MenuBuilder var3;
      if(this.mMenuView != null) {
         var3 = this.mMenuView.peekMenu();
      } else {
         var3 = null;
      }

      if(var2.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && var3 != null) {
         MenuItem var4 = var3.findItem(var2.expandedMenuItemId);
         if(var4 != null) {
            MenuItemCompat.expandActionView(var4);
         }
      }

      if(var2.isOverflowOpen) {
         this.postShowOverflowMenu();
      }

   }

   public void onRtlPropertiesChanged(int var1) {
      byte var2 = 1;
      if(VERSION.SDK_INT >= 17) {
         super.onRtlPropertiesChanged(var1);
      }

      RtlSpacingHelper var3 = this.mContentInsets;
      if(var1 != var2) {
         var2 = 0;
      }

      var3.setDirection((boolean)var2);
   }

   protected Parcelable onSaveInstanceState() {
      Toolbar.SavedState var1 = new Toolbar.SavedState(super.onSaveInstanceState());
      if(this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null) {
         var1.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
      }

      var1.isOverflowOpen = this.isOverflowMenuShowing();
      return var1;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      if(var2 == 0) {
         this.mEatingTouch = false;
      }

      if(!this.mEatingTouch) {
         boolean var3 = super.onTouchEvent(var1);
         if(var2 == 0 && !var3) {
            this.mEatingTouch = true;
         }
      }

      if(var2 == 1 || var2 == 3) {
         this.mEatingTouch = false;
      }

      return true;
   }

   void removeChildrenForExpandedActionView() {
      for(int var1 = -1 + this.getChildCount(); var1 >= 0; --var1) {
         View var2 = this.getChildAt(var1);
         if(((Toolbar.LayoutParams)var2.getLayoutParams()).mViewType != 2 && var2 != this.mMenuView) {
            this.removeViewAt(var1);
            this.mHiddenViews.add(var2);
         }
      }

   }

   public void setCollapsible(boolean var1) {
      this.mCollapsible = var1;
      this.requestLayout();
   }

   public void setContentInsetsAbsolute(int var1, int var2) {
      this.mContentInsets.setAbsolute(var1, var2);
   }

   public void setContentInsetsRelative(int var1, int var2) {
      this.mContentInsets.setRelative(var1, var2);
   }

   public void setLogo(@DrawableRes int var1) {
      this.setLogo(this.mDrawableManager.getDrawable(this.getContext(), var1));
   }

   public void setLogo(Drawable var1) {
      if(var1 != null) {
         this.ensureLogoView();
         if(!this.isChildOrHidden(this.mLogoView)) {
            this.addSystemView(this.mLogoView, true);
         }
      } else if(this.mLogoView != null && this.isChildOrHidden(this.mLogoView)) {
         this.removeView(this.mLogoView);
         this.mHiddenViews.remove(this.mLogoView);
      }

      if(this.mLogoView != null) {
         this.mLogoView.setImageDrawable(var1);
      }

   }

   public void setLogoDescription(@StringRes int var1) {
      this.setLogoDescription(this.getContext().getText(var1));
   }

   public void setLogoDescription(CharSequence var1) {
      if(!TextUtils.isEmpty(var1)) {
         this.ensureLogoView();
      }

      if(this.mLogoView != null) {
         this.mLogoView.setContentDescription(var1);
      }

   }

   public void setMenu(MenuBuilder var1, ActionMenuPresenter var2) {
      if(var1 != null || this.mMenuView != null) {
         this.ensureMenuView();
         MenuBuilder var3 = this.mMenuView.peekMenu();
         if(var3 != var1) {
            if(var3 != null) {
               var3.removeMenuPresenter(this.mOuterActionMenuPresenter);
               var3.removeMenuPresenter(this.mExpandedMenuPresenter);
            }

            if(this.mExpandedMenuPresenter == null) {
               this.mExpandedMenuPresenter = new Toolbar.ExpandedActionViewMenuPresenter(null);
            }

            var2.setExpandedActionViewsExclusive(true);
            if(var1 != null) {
               var1.addMenuPresenter(var2, this.mPopupContext);
               var1.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
            } else {
               var2.initForMenu(this.mPopupContext, (MenuBuilder)null);
               this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, (MenuBuilder)null);
               var2.updateMenuView(true);
               this.mExpandedMenuPresenter.updateMenuView(true);
            }

            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setPresenter(var2);
            this.mOuterActionMenuPresenter = var2;
            return;
         }
      }

   }

   public void setMenuCallbacks(MenuPresenter.Callback var1, MenuBuilder.Callback var2) {
      this.mActionMenuPresenterCallback = var1;
      this.mMenuBuilderCallback = var2;
      if(this.mMenuView != null) {
         this.mMenuView.setMenuCallbacks(var1, var2);
      }

   }

   public void setNavigationContentDescription(@StringRes int var1) {
      CharSequence var2;
      if(var1 != 0) {
         var2 = this.getContext().getText(var1);
      } else {
         var2 = null;
      }

      this.setNavigationContentDescription(var2);
   }

   public void setNavigationContentDescription(@Nullable CharSequence var1) {
      if(!TextUtils.isEmpty(var1)) {
         this.ensureNavButtonView();
      }

      if(this.mNavButtonView != null) {
         this.mNavButtonView.setContentDescription(var1);
      }

   }

   public void setNavigationIcon(@DrawableRes int var1) {
      this.setNavigationIcon(this.mDrawableManager.getDrawable(this.getContext(), var1));
   }

   public void setNavigationIcon(@Nullable Drawable var1) {
      if(var1 != null) {
         this.ensureNavButtonView();
         if(!this.isChildOrHidden(this.mNavButtonView)) {
            this.addSystemView(this.mNavButtonView, true);
         }
      } else if(this.mNavButtonView != null && this.isChildOrHidden(this.mNavButtonView)) {
         this.removeView(this.mNavButtonView);
         this.mHiddenViews.remove(this.mNavButtonView);
      }

      if(this.mNavButtonView != null) {
         this.mNavButtonView.setImageDrawable(var1);
      }

   }

   public void setNavigationOnClickListener(OnClickListener var1) {
      this.ensureNavButtonView();
      this.mNavButtonView.setOnClickListener(var1);
   }

   public void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener var1) {
      this.mOnMenuItemClickListener = var1;
   }

   public void setOverflowIcon(@Nullable Drawable var1) {
      this.ensureMenu();
      this.mMenuView.setOverflowIcon(var1);
   }

   public void setPopupTheme(@StyleRes int var1) {
      if(this.mPopupTheme != var1) {
         this.mPopupTheme = var1;
         if(var1 != 0) {
            this.mPopupContext = new ContextThemeWrapper(this.getContext(), var1);
            return;
         }

         this.mPopupContext = this.getContext();
      }

   }

   public void setSubtitle(@StringRes int var1) {
      this.setSubtitle(this.getContext().getText(var1));
   }

   public void setSubtitle(CharSequence var1) {
      if(!TextUtils.isEmpty(var1)) {
         if(this.mSubtitleTextView == null) {
            Context var3 = this.getContext();
            this.mSubtitleTextView = new TextView(var3);
            this.mSubtitleTextView.setSingleLine();
            this.mSubtitleTextView.setEllipsize(TruncateAt.END);
            if(this.mSubtitleTextAppearance != 0) {
               this.mSubtitleTextView.setTextAppearance(var3, this.mSubtitleTextAppearance);
            }

            if(this.mSubtitleTextColor != 0) {
               this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
            }
         }

         if(!this.isChildOrHidden(this.mSubtitleTextView)) {
            this.addSystemView(this.mSubtitleTextView, true);
         }
      } else if(this.mSubtitleTextView != null && this.isChildOrHidden(this.mSubtitleTextView)) {
         this.removeView(this.mSubtitleTextView);
         this.mHiddenViews.remove(this.mSubtitleTextView);
      }

      if(this.mSubtitleTextView != null) {
         this.mSubtitleTextView.setText(var1);
      }

      this.mSubtitleText = var1;
   }

   public void setSubtitleTextAppearance(Context var1, @StyleRes int var2) {
      this.mSubtitleTextAppearance = var2;
      if(this.mSubtitleTextView != null) {
         this.mSubtitleTextView.setTextAppearance(var1, var2);
      }

   }

   public void setSubtitleTextColor(@ColorInt int var1) {
      this.mSubtitleTextColor = var1;
      if(this.mSubtitleTextView != null) {
         this.mSubtitleTextView.setTextColor(var1);
      }

   }

   public void setTitle(@StringRes int var1) {
      this.setTitle(this.getContext().getText(var1));
   }

   public void setTitle(CharSequence var1) {
      if(!TextUtils.isEmpty(var1)) {
         if(this.mTitleTextView == null) {
            Context var3 = this.getContext();
            this.mTitleTextView = new TextView(var3);
            this.mTitleTextView.setSingleLine();
            this.mTitleTextView.setEllipsize(TruncateAt.END);
            if(this.mTitleTextAppearance != 0) {
               this.mTitleTextView.setTextAppearance(var3, this.mTitleTextAppearance);
            }

            if(this.mTitleTextColor != 0) {
               this.mTitleTextView.setTextColor(this.mTitleTextColor);
            }
         }

         if(!this.isChildOrHidden(this.mTitleTextView)) {
            this.addSystemView(this.mTitleTextView, true);
         }
      } else if(this.mTitleTextView != null && this.isChildOrHidden(this.mTitleTextView)) {
         this.removeView(this.mTitleTextView);
         this.mHiddenViews.remove(this.mTitleTextView);
      }

      if(this.mTitleTextView != null) {
         this.mTitleTextView.setText(var1);
      }

      this.mTitleText = var1;
   }

   public void setTitleTextAppearance(Context var1, @StyleRes int var2) {
      this.mTitleTextAppearance = var2;
      if(this.mTitleTextView != null) {
         this.mTitleTextView.setTextAppearance(var1, var2);
      }

   }

   public void setTitleTextColor(@ColorInt int var1) {
      this.mTitleTextColor = var1;
      if(this.mTitleTextView != null) {
         this.mTitleTextView.setTextColor(var1);
      }

   }

   public boolean showOverflowMenu() {
      return this.mMenuView != null && this.mMenuView.showOverflowMenu();
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
         if(Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)Toolbar.this.mExpandedActionView).onActionViewCollapsed();
         }

         Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
         Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
         Toolbar.this.mExpandedActionView = null;
         Toolbar.this.addChildrenForExpandedActionView();
         this.mCurrentExpandedItem = null;
         Toolbar.this.requestLayout();
         var2.setActionViewExpanded(false);
         return true;
      }

      public boolean expandItemActionView(MenuBuilder var1, MenuItemImpl var2) {
         Toolbar.this.ensureCollapseButtonView();
         if(Toolbar.this.mCollapseButtonView.getParent() != Toolbar.this) {
            Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
         }

         Toolbar.this.mExpandedActionView = var2.getActionView();
         this.mCurrentExpandedItem = var2;
         if(Toolbar.this.mExpandedActionView.getParent() != Toolbar.this) {
            Toolbar.LayoutParams var3 = Toolbar.this.generateDefaultLayoutParams();
            var3.gravity = 8388611 | 112 & Toolbar.this.mButtonGravity;
            var3.mViewType = 2;
            Toolbar.this.mExpandedActionView.setLayoutParams(var3);
            Toolbar.this.addView(Toolbar.this.mExpandedActionView);
         }

         Toolbar.this.removeChildrenForExpandedActionView();
         Toolbar.this.requestLayout();
         var2.setActionViewExpanded(true);
         if(Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)Toolbar.this.mExpandedActionView).onActionViewExpanded();
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

                  if(this.mMenu.getItem(var6) == this.mCurrentExpandedItem) {
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

   public static class LayoutParams extends ActionBar.LayoutParams {
      static final int CUSTOM = 0;
      static final int EXPANDED = 2;
      static final int SYSTEM = 1;
      int mViewType;

      public LayoutParams(int var1) {
         this(-2, -1, var1);
      }

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.mViewType = 0;
         this.gravity = 8388627;
      }

      public LayoutParams(int var1, int var2, int var3) {
         super(var1, var2);
         this.mViewType = 0;
         this.gravity = var3;
      }

      public LayoutParams(@NonNull Context var1, AttributeSet var2) {
         super(var1, var2);
         this.mViewType = 0;
      }

      public LayoutParams(ActionBar.LayoutParams var1) {
         super(var1);
         this.mViewType = 0;
      }

      public LayoutParams(Toolbar.LayoutParams var1) {
         super((ActionBar.LayoutParams)var1);
         this.mViewType = 0;
         this.mViewType = var1.mViewType;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
         this.mViewType = 0;
      }

      public LayoutParams(MarginLayoutParams var1) {
         super((android.view.ViewGroup.LayoutParams)var1);
         this.mViewType = 0;
         this.copyMarginsFromCompat(var1);
      }

      void copyMarginsFromCompat(MarginLayoutParams var1) {
         this.leftMargin = var1.leftMargin;
         this.topMargin = var1.topMargin;
         this.rightMargin = var1.rightMargin;
         this.bottomMargin = var1.bottomMargin;
      }
   }

   public interface OnMenuItemClickListener {
      boolean onMenuItemClick(MenuItem var1);
   }

   public static class SavedState extends BaseSavedState {
      public static final Creator<Toolbar.SavedState> CREATOR = new Creator() {
         public Toolbar.SavedState createFromParcel(Parcel var1) {
            return new Toolbar.SavedState(var1);
         }

         public Toolbar.SavedState[] newArray(int var1) {
            return new Toolbar.SavedState[var1];
         }
      };
      int expandedMenuItemId;
      boolean isOverflowOpen;

      public SavedState(Parcel var1) {
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

      public SavedState(Parcelable var1) {
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
