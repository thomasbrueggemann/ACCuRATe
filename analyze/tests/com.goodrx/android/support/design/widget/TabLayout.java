package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.class_5;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.TabItem;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ViewUtils;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatDrawableManager;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.FrameLayout.LayoutParams;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayout extends HorizontalScrollView {
   private static final int ANIMATION_DURATION = 300;
   private static final int DEFAULT_GAP_TEXT_ICON = 8;
   private static final int DEFAULT_HEIGHT = 48;
   private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
   private static final int FIXED_WRAP_GUTTER_MIN = 16;
   public static final int GRAVITY_CENTER = 1;
   public static final int GRAVITY_FILL = 0;
   private static final int INVALID_WIDTH = -1;
   public static final int MODE_FIXED = 1;
   public static final int MODE_SCROLLABLE = 0;
   private static final int MOTION_NON_ADJACENT_OFFSET = 24;
   private static final int TAB_MIN_WIDTH_MARGIN = 56;
   private static final Pools.Pool<TabLayout.Tab> sTabPool = new Pools.SynchronizedPool(16);
   private int mContentInsetStart;
   private int mMode;
   private TabLayout.OnTabSelectedListener mOnTabSelectedListener;
   private TabLayout.TabLayoutOnPageChangeListener mPageChangeListener;
   private PagerAdapter mPagerAdapter;
   private DataSetObserver mPagerAdapterObserver;
   private final int mRequestedTabMaxWidth;
   private final int mRequestedTabMinWidth;
   private ValueAnimatorCompat mScrollAnimator;
   private final int mScrollableTabMinWidth;
   private TabLayout.Tab mSelectedTab;
   private final int mTabBackgroundResId;
   private int mTabGravity;
   private int mTabMaxWidth;
   private int mTabPaddingBottom;
   private int mTabPaddingEnd;
   private int mTabPaddingStart;
   private int mTabPaddingTop;
   private final TabLayout.SlidingTabStrip mTabStrip;
   private int mTabTextAppearance;
   private ColorStateList mTabTextColors;
   private float mTabTextMultiLineSize;
   private float mTabTextSize;
   private final Pools.Pool<TabLayout.TabView> mTabViewPool;
   private final ArrayList<TabLayout.Tab> mTabs;
   private ViewPager mViewPager;

   public TabLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public TabLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public TabLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mTabs = new ArrayList();
      this.mTabMaxWidth = Integer.MAX_VALUE;
      this.mTabViewPool = new Pools.SimplePool(12);
      ThemeUtils.checkAppCompatTheme(var1);
      this.setHorizontalScrollBarEnabled(false);
      this.mTabStrip = new TabLayout.SlidingTabStrip(var1);
      super.addView(this.mTabStrip, 0, new LayoutParams(-2, -1));
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_5.styleable.TabLayout, var3, class_5.style.Widget_Design_TabLayout);
      this.mTabStrip.setSelectedIndicatorHeight(var4.getDimensionPixelSize(class_5.styleable.TabLayout_tabIndicatorHeight, 0));
      this.mTabStrip.setSelectedIndicatorColor(var4.getColor(class_5.styleable.TabLayout_tabIndicatorColor, 0));
      int var5 = var4.getDimensionPixelSize(class_5.styleable.TabLayout_tabPadding, 0);
      this.mTabPaddingBottom = var5;
      this.mTabPaddingEnd = var5;
      this.mTabPaddingTop = var5;
      this.mTabPaddingStart = var5;
      this.mTabPaddingStart = var4.getDimensionPixelSize(class_5.styleable.TabLayout_tabPaddingStart, this.mTabPaddingStart);
      this.mTabPaddingTop = var4.getDimensionPixelSize(class_5.styleable.TabLayout_tabPaddingTop, this.mTabPaddingTop);
      this.mTabPaddingEnd = var4.getDimensionPixelSize(class_5.styleable.TabLayout_tabPaddingEnd, this.mTabPaddingEnd);
      this.mTabPaddingBottom = var4.getDimensionPixelSize(class_5.styleable.TabLayout_tabPaddingBottom, this.mTabPaddingBottom);
      this.mTabTextAppearance = var4.getResourceId(class_5.styleable.TabLayout_tabTextAppearance, class_5.style.TextAppearance_Design_Tab);
      TypedArray var6 = var1.obtainStyledAttributes(this.mTabTextAppearance, class_5.styleable.TextAppearance);

      try {
         this.mTabTextSize = (float)var6.getDimensionPixelSize(class_5.styleable.TextAppearance_android_textSize, 0);
         this.mTabTextColors = var6.getColorStateList(class_5.styleable.TextAppearance_android_textColor);
      } finally {
         var6.recycle();
      }

      if(var4.hasValue(class_5.styleable.TabLayout_tabTextColor)) {
         this.mTabTextColors = var4.getColorStateList(class_5.styleable.TabLayout_tabTextColor);
      }

      if(var4.hasValue(class_5.styleable.TabLayout_tabSelectedTextColor)) {
         int var9 = var4.getColor(class_5.styleable.TabLayout_tabSelectedTextColor, 0);
         this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), var9);
      }

      this.mRequestedTabMinWidth = var4.getDimensionPixelSize(class_5.styleable.TabLayout_tabMinWidth, -1);
      this.mRequestedTabMaxWidth = var4.getDimensionPixelSize(class_5.styleable.TabLayout_tabMaxWidth, -1);
      this.mTabBackgroundResId = var4.getResourceId(class_5.styleable.TabLayout_tabBackground, 0);
      this.mContentInsetStart = var4.getDimensionPixelSize(class_5.styleable.TabLayout_tabContentStart, 0);
      this.mMode = var4.getInt(class_5.styleable.TabLayout_tabMode, 1);
      this.mTabGravity = var4.getInt(class_5.styleable.TabLayout_tabGravity, 0);
      var4.recycle();
      Resources var8 = this.getResources();
      this.mTabTextMultiLineSize = (float)var8.getDimensionPixelSize(class_5.dimen.design_tab_text_size_2line);
      this.mScrollableTabMinWidth = var8.getDimensionPixelSize(class_5.dimen.design_tab_scrollable_min_width);
      this.applyModeAndGravity();
   }

   private void addTabFromItemView(@NonNull TabItem var1) {
      TabLayout.Tab var2 = this.newTab();
      if(var1.mText != null) {
         var2.setText(var1.mText);
      }

      if(var1.mIcon != null) {
         var2.setIcon(var1.mIcon);
      }

      if(var1.mCustomLayout != 0) {
         var2.setCustomView(var1.mCustomLayout);
      }

      this.addTab(var2);
   }

   private void addTabView(TabLayout.Tab var1, int var2, boolean var3) {
      TabLayout.TabView var4 = var1.mView;
      this.mTabStrip.addView(var4, var2, this.createLayoutParamsForTabs());
      if(var3) {
         var4.setSelected(true);
      }

   }

   private void addTabView(TabLayout.Tab var1, boolean var2) {
      TabLayout.TabView var3 = var1.mView;
      this.mTabStrip.addView(var3, this.createLayoutParamsForTabs());
      if(var2) {
         var3.setSelected(true);
      }

   }

   private void addViewInternal(View var1) {
      if(var1 instanceof TabItem) {
         this.addTabFromItemView((TabItem)var1);
      } else {
         throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
      }
   }

   private void animateToTab(int var1) {
      if(var1 != -1) {
         if(this.getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.mTabStrip.childrenNeedLayout()) {
            int var2 = this.getScrollX();
            int var3 = this.calculateScrollXForTab(var1, 0.0F);
            if(var2 != var3) {
               if(this.mScrollAnimator == null) {
                  this.mScrollAnimator = ViewUtils.createAnimator();
                  this.mScrollAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                  this.mScrollAnimator.setDuration(300);
                  this.mScrollAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener() {
                     public void onAnimationUpdate(ValueAnimatorCompat var1) {
                        TabLayout.this.scrollTo(var1.getAnimatedIntValue(), 0);
                     }
                  });
               }

               this.mScrollAnimator.setIntValues(var2, var3);
               this.mScrollAnimator.start();
            }

            this.mTabStrip.animateIndicatorToPosition(var1, 300);
         } else {
            this.setScrollPosition(var1, 0.0F, true);
         }
      }
   }

   private void applyModeAndGravity() {
      int var1 = this.mMode;
      int var2 = 0;
      if(var1 == 0) {
         var2 = Math.max(0, this.mContentInsetStart - this.mTabPaddingStart);
      }

      ViewCompat.setPaddingRelative(this.mTabStrip, var2, 0, 0, 0);
      switch(this.mMode) {
      case 0:
         this.mTabStrip.setGravity(8388611);
         break;
      case 1:
         this.mTabStrip.setGravity(1);
      }

      this.updateTabViews(true);
   }

   private int calculateScrollXForTab(int var1, float var2) {
      int var3 = this.mMode;
      int var4 = 0;
      if(var3 == 0) {
         View var5 = this.mTabStrip.getChildAt(var1);
         View var6;
         if(var1 + 1 < this.mTabStrip.getChildCount()) {
            var6 = this.mTabStrip.getChildAt(var1 + 1);
         } else {
            var6 = null;
         }

         int var7;
         if(var5 != null) {
            var7 = var5.getWidth();
         } else {
            var7 = 0;
         }

         int var8 = 0;
         if(var6 != null) {
            var8 = var6.getWidth();
         }

         var4 = var5.getLeft() + (int)(0.5F * var2 * (float)(var7 + var8)) + var5.getWidth() / 2 - this.getWidth() / 2;
      }

      return var4;
   }

   private void configureTab(TabLayout.Tab var1, int var2) {
      var1.setPosition(var2);
      this.mTabs.add(var2, var1);
      int var3 = this.mTabs.size();

      for(int var4 = var2 + 1; var4 < var3; ++var4) {
         ((TabLayout.Tab)this.mTabs.get(var4)).setPosition(var4);
      }

   }

   private static ColorStateList createColorStateList(int var0, int var1) {
      int[][] var2 = new int[2][];
      int[] var3 = new int[2];
      var2[0] = SELECTED_STATE_SET;
      var3[0] = var1;
      int var4 = 0 + 1;
      var2[var4] = EMPTY_STATE_SET;
      var3[var4] = var0;
      int var10000 = var4 + 1;
      return new ColorStateList(var2, var3);
   }

   private android.widget.LinearLayout.LayoutParams createLayoutParamsForTabs() {
      android.widget.LinearLayout.LayoutParams var1 = new android.widget.LinearLayout.LayoutParams(-2, -1);
      this.updateTabViewLayoutParams(var1);
      return var1;
   }

   private TabLayout.TabView createTabView(@NonNull TabLayout.Tab var1) {
      TabLayout.TabView var2;
      if(this.mTabViewPool != null) {
         var2 = (TabLayout.TabView)this.mTabViewPool.acquire();
      } else {
         var2 = null;
      }

      if(var2 == null) {
         var2 = new TabLayout.TabView(this.getContext());
      }

      var2.setTab(var1);
      var2.setFocusable(true);
      var2.setMinimumWidth(this.getTabMinWidth());
      return var2;
   }

   private int dpToPx(int var1) {
      return Math.round(this.getResources().getDisplayMetrics().density * (float)var1);
   }

   private int getDefaultHeight() {
      int var1 = 0;
      int var2 = this.mTabs.size();

      boolean var3;
      while(true) {
         var3 = false;
         if(var1 >= var2) {
            break;
         }

         TabLayout.Tab var4 = (TabLayout.Tab)this.mTabs.get(var1);
         if(var4 != null && var4.getIcon() != null && !TextUtils.isEmpty(var4.getText())) {
            var3 = true;
            break;
         }

         ++var1;
      }

      return var3?72:48;
   }

   private float getScrollPosition() {
      return this.mTabStrip.getIndicatorPosition();
   }

   private int getTabMaxWidth() {
      return this.mTabMaxWidth;
   }

   private int getTabMinWidth() {
      return this.mRequestedTabMinWidth != -1?this.mRequestedTabMinWidth:(this.mMode == 0?this.mScrollableTabMinWidth:0);
   }

   private int getTabScrollRange() {
      return Math.max(0, this.mTabStrip.getWidth() - this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
   }

   private void populateFromPagerAdapter() {
      this.removeAllTabs();
      if(this.mPagerAdapter == null) {
         this.removeAllTabs();
      } else {
         int var1 = this.mPagerAdapter.getCount();

         for(int var2 = 0; var2 < var1; ++var2) {
            this.addTab(this.newTab().setText(this.mPagerAdapter.getPageTitle(var2)), false);
         }

         if(this.mViewPager != null && var1 > 0) {
            int var3 = this.mViewPager.getCurrentItem();
            if(var3 != this.getSelectedTabPosition() && var3 < this.getTabCount()) {
               this.selectTab(this.getTabAt(var3));
            }
         }

      }
   }

   private void removeTabViewAt(int var1) {
      TabLayout.TabView var2 = (TabLayout.TabView)this.mTabStrip.getChildAt(var1);
      this.mTabStrip.removeViewAt(var1);
      if(var2 != null) {
         var2.reset();
         this.mTabViewPool.release(var2);
      }

      this.requestLayout();
   }

   private void setPagerAdapter(@Nullable PagerAdapter var1, boolean var2) {
      if(this.mPagerAdapter != null && this.mPagerAdapterObserver != null) {
         this.mPagerAdapter.unregisterDataSetObserver(this.mPagerAdapterObserver);
      }

      this.mPagerAdapter = var1;
      if(var2 && var1 != null) {
         if(this.mPagerAdapterObserver == null) {
            this.mPagerAdapterObserver = new TabLayout.PagerAdapterObserver(null);
         }

         var1.registerDataSetObserver(this.mPagerAdapterObserver);
      }

      this.populateFromPagerAdapter();
   }

   private void setScrollPosition(int var1, float var2, boolean var3, boolean var4) {
      int var5 = Math.round(var2 + (float)var1);
      if(var5 >= 0 && var5 < this.mTabStrip.getChildCount()) {
         if(var4) {
            this.mTabStrip.setIndicatorPositionFromTabPosition(var1, var2);
         }

         if(this.mScrollAnimator != null && this.mScrollAnimator.isRunning()) {
            this.mScrollAnimator.cancel();
         }

         this.scrollTo(this.calculateScrollXForTab(var1, var2), 0);
         if(var3) {
            this.setSelectedTabView(var5);
            return;
         }
      }

   }

   private void setSelectedTabView(int var1) {
      int var2 = this.mTabStrip.getChildCount();
      if(var1 < var2 && !this.mTabStrip.getChildAt(var1).isSelected()) {
         for(int var3 = 0; var3 < var2; ++var3) {
            View var4 = this.mTabStrip.getChildAt(var3);
            boolean var5;
            if(var3 == var1) {
               var5 = true;
            } else {
               var5 = false;
            }

            var4.setSelected(var5);
         }
      }

   }

   private void updateAllTabs() {
      int var1 = 0;

      for(int var2 = this.mTabs.size(); var1 < var2; ++var1) {
         ((TabLayout.Tab)this.mTabs.get(var1)).updateView();
      }

   }

   private void updateTabViewLayoutParams(android.widget.LinearLayout.LayoutParams var1) {
      if(this.mMode == 1 && this.mTabGravity == 0) {
         var1.width = 0;
         var1.weight = 1.0F;
      } else {
         var1.width = -2;
         var1.weight = 0.0F;
      }
   }

   private void updateTabViews(boolean var1) {
      for(int var2 = 0; var2 < this.mTabStrip.getChildCount(); ++var2) {
         View var3 = this.mTabStrip.getChildAt(var2);
         var3.setMinimumWidth(this.getTabMinWidth());
         this.updateTabViewLayoutParams((android.widget.LinearLayout.LayoutParams)var3.getLayoutParams());
         if(var1) {
            var3.requestLayout();
         }
      }

   }

   public void addTab(@NonNull TabLayout.Tab var1) {
      this.addTab(var1, this.mTabs.isEmpty());
   }

   public void addTab(@NonNull TabLayout.Tab var1, int var2) {
      this.addTab(var1, var2, this.mTabs.isEmpty());
   }

   public void addTab(@NonNull TabLayout.Tab var1, int var2, boolean var3) {
      if(var1.mParent != this) {
         throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
      } else {
         this.addTabView(var1, var2, var3);
         this.configureTab(var1, var2);
         if(var3) {
            var1.select();
         }

      }
   }

   public void addTab(@NonNull TabLayout.Tab var1, boolean var2) {
      if(var1.mParent != this) {
         throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
      } else {
         this.addTabView(var1, var2);
         this.configureTab(var1, this.mTabs.size());
         if(var2) {
            var1.select();
         }

      }
   }

   public void addView(View var1) {
      this.addViewInternal(var1);
   }

   public void addView(View var1, int var2) {
      this.addViewInternal(var1);
   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      this.addViewInternal(var1);
   }

   public void addView(View var1, android.view.ViewGroup.LayoutParams var2) {
      this.addViewInternal(var1);
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      return this.generateDefaultLayoutParams();
   }

   public int getSelectedTabPosition() {
      return this.mSelectedTab != null?this.mSelectedTab.getPosition():-1;
   }

   @Nullable
   public TabLayout.Tab getTabAt(int var1) {
      return (TabLayout.Tab)this.mTabs.get(var1);
   }

   public int getTabCount() {
      return this.mTabs.size();
   }

   public int getTabGravity() {
      return this.mTabGravity;
   }

   public int getTabMode() {
      return this.mMode;
   }

   @Nullable
   public ColorStateList getTabTextColors() {
      return this.mTabTextColors;
   }

   @NonNull
   public TabLayout.Tab newTab() {
      TabLayout.Tab var1 = (TabLayout.Tab)sTabPool.acquire();
      if(var1 == null) {
         var1 = new TabLayout.Tab(this);
      }

      var1.mView = this.createTabView(var1);
      return var1;
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = this.dpToPx(this.getDefaultHeight()) + this.getPaddingTop() + this.getPaddingBottom();
      switch(MeasureSpec.getMode(var2)) {
      case Integer.MIN_VALUE:
         var2 = MeasureSpec.makeMeasureSpec(Math.min(var3, MeasureSpec.getSize(var2)), 1073741824);
         break;
      case 0:
         var2 = MeasureSpec.makeMeasureSpec(var3, 1073741824);
      }

      int var4 = MeasureSpec.getSize(var1);
      if(MeasureSpec.getMode(var1) != 0) {
         int var9;
         if(this.mRequestedTabMaxWidth > 0) {
            var9 = this.mRequestedTabMaxWidth;
         } else {
            var9 = var4 - this.dpToPx(56);
         }

         this.mTabMaxWidth = var9;
      }

      super.onMeasure(var1, var2);
      if(this.getChildCount() == 1) {
         View var5 = this.getChildAt(0);
         int var6 = this.mMode;
         boolean var7 = false;
         switch(var6) {
         case 0:
            if(var5.getMeasuredWidth() < this.getMeasuredWidth()) {
               var7 = true;
            } else {
               var7 = false;
            }
            break;
         case 1:
            if(var5.getMeasuredWidth() != this.getMeasuredWidth()) {
               var7 = true;
            } else {
               var7 = false;
            }
         }

         if(var7) {
            int var8 = getChildMeasureSpec(var2, this.getPaddingTop() + this.getPaddingBottom(), var5.getLayoutParams().height);
            var5.measure(MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824), var8);
         }
      }

   }

   public void removeAllTabs() {
      for(int var1 = -1 + this.mTabStrip.getChildCount(); var1 >= 0; --var1) {
         this.removeTabViewAt(var1);
      }

      Iterator var2 = this.mTabs.iterator();

      while(var2.hasNext()) {
         TabLayout.Tab var3 = (TabLayout.Tab)var2.next();
         var2.remove();
         var3.reset();
         sTabPool.release(var3);
      }

      this.mSelectedTab = null;
   }

   public void removeTab(TabLayout.Tab var1) {
      if(var1.mParent != this) {
         throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
      } else {
         this.removeTabAt(var1.getPosition());
      }
   }

   public void removeTabAt(int var1) {
      int var2;
      if(this.mSelectedTab != null) {
         var2 = this.mSelectedTab.getPosition();
      } else {
         var2 = 0;
      }

      this.removeTabViewAt(var1);
      TabLayout.Tab var3 = (TabLayout.Tab)this.mTabs.remove(var1);
      if(var3 != null) {
         var3.reset();
         sTabPool.release(var3);
      }

      int var4 = this.mTabs.size();

      for(int var5 = var1; var5 < var4; ++var5) {
         ((TabLayout.Tab)this.mTabs.get(var5)).setPosition(var5);
      }

      if(var2 == var1) {
         TabLayout.Tab var6;
         if(this.mTabs.isEmpty()) {
            var6 = null;
         } else {
            var6 = (TabLayout.Tab)this.mTabs.get(Math.max(0, var1 - 1));
         }

         this.selectTab(var6);
      }

   }

   void selectTab(TabLayout.Tab var1) {
      this.selectTab(var1, true);
   }

   void selectTab(TabLayout.Tab var1, boolean var2) {
      if(this.mSelectedTab == var1) {
         if(this.mSelectedTab != null) {
            if(this.mOnTabSelectedListener != null) {
               this.mOnTabSelectedListener.onTabReselected(this.mSelectedTab);
            }

            this.animateToTab(var1.getPosition());
         }
      } else {
         if(var2) {
            int var3;
            if(var1 != null) {
               var3 = var1.getPosition();
            } else {
               var3 = -1;
            }

            if(var3 != -1) {
               this.setSelectedTabView(var3);
            }

            if((this.mSelectedTab == null || this.mSelectedTab.getPosition() == -1) && var3 != -1) {
               this.setScrollPosition(var3, 0.0F, true);
            } else {
               this.animateToTab(var3);
            }
         }

         if(this.mSelectedTab != null && this.mOnTabSelectedListener != null) {
            this.mOnTabSelectedListener.onTabUnselected(this.mSelectedTab);
         }

         this.mSelectedTab = var1;
         if(this.mSelectedTab != null && this.mOnTabSelectedListener != null) {
            this.mOnTabSelectedListener.onTabSelected(this.mSelectedTab);
            return;
         }
      }

   }

   public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener var1) {
      this.mOnTabSelectedListener = var1;
   }

   public void setScrollPosition(int var1, float var2, boolean var3) {
      this.setScrollPosition(var1, var2, var3, true);
   }

   public void setSelectedTabIndicatorColor(@ColorInt int var1) {
      this.mTabStrip.setSelectedIndicatorColor(var1);
   }

   public void setSelectedTabIndicatorHeight(int var1) {
      this.mTabStrip.setSelectedIndicatorHeight(var1);
   }

   public void setTabGravity(int var1) {
      if(this.mTabGravity != var1) {
         this.mTabGravity = var1;
         this.applyModeAndGravity();
      }

   }

   public void setTabMode(int var1) {
      if(var1 != this.mMode) {
         this.mMode = var1;
         this.applyModeAndGravity();
      }

   }

   public void setTabTextColors(int var1, int var2) {
      this.setTabTextColors(createColorStateList(var1, var2));
   }

   public void setTabTextColors(@Nullable ColorStateList var1) {
      if(this.mTabTextColors != var1) {
         this.mTabTextColors = var1;
         this.updateAllTabs();
      }

   }

   @Deprecated
   public void setTabsFromPagerAdapter(@Nullable PagerAdapter var1) {
      this.setPagerAdapter(var1, false);
   }

   public void setupWithViewPager(@Nullable ViewPager var1) {
      if(this.mViewPager != null && this.mPageChangeListener != null) {
         this.mViewPager.removeOnPageChangeListener(this.mPageChangeListener);
      }

      if(var1 != null) {
         PagerAdapter var2 = var1.getAdapter();
         if(var2 == null) {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
         } else {
            this.mViewPager = var1;
            if(this.mPageChangeListener == null) {
               this.mPageChangeListener = new TabLayout.TabLayoutOnPageChangeListener(this);
            }

            this.mPageChangeListener.reset();
            var1.addOnPageChangeListener(this.mPageChangeListener);
            this.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(var1));
            this.setPagerAdapter(var2, true);
         }
      } else {
         this.mViewPager = null;
         this.setOnTabSelectedListener((TabLayout.OnTabSelectedListener)null);
         this.setPagerAdapter((PagerAdapter)null, true);
      }
   }

   public boolean shouldDelayChildPressedState() {
      return this.getTabScrollRange() > 0;
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface Mode {
   }

   public interface OnTabSelectedListener {
      void onTabReselected(TabLayout.Tab var1);

      void onTabSelected(TabLayout.Tab var1);

      void onTabUnselected(TabLayout.Tab var1);
   }

   private class PagerAdapterObserver extends DataSetObserver {
      private PagerAdapterObserver() {
      }

      // $FF: synthetic method
      PagerAdapterObserver(Object var2) {
         this();
      }

      public void onChanged() {
         TabLayout.this.populateFromPagerAdapter();
      }

      public void onInvalidated() {
         TabLayout.this.populateFromPagerAdapter();
      }
   }

   private class SlidingTabStrip extends LinearLayout {
      private ValueAnimatorCompat mIndicatorAnimator;
      private int mIndicatorLeft = -1;
      private int mIndicatorRight = -1;
      private int mSelectedIndicatorHeight;
      private final Paint mSelectedIndicatorPaint;
      private int mSelectedPosition = -1;
      private float mSelectionOffset;

      SlidingTabStrip(Context var2) {
         super(var2);
         this.setWillNotDraw(false);
         this.mSelectedIndicatorPaint = new Paint();
      }

      private void setIndicatorPosition(int var1, int var2) {
         if(var1 != this.mIndicatorLeft || var2 != this.mIndicatorRight) {
            this.mIndicatorLeft = var1;
            this.mIndicatorRight = var2;
            ViewCompat.postInvalidateOnAnimation(this);
         }

      }

      private void updateIndicatorPosition() {
         View var1 = this.getChildAt(this.mSelectedPosition);
         int var2;
         int var3;
         if(var1 != null && var1.getWidth() > 0) {
            var3 = var1.getLeft();
            var2 = var1.getRight();
            if(this.mSelectionOffset > 0.0F && this.mSelectedPosition < -1 + this.getChildCount()) {
               View var4 = this.getChildAt(1 + this.mSelectedPosition);
               var3 = (int)(this.mSelectionOffset * (float)var4.getLeft() + (1.0F - this.mSelectionOffset) * (float)var3);
               var2 = (int)(this.mSelectionOffset * (float)var4.getRight() + (1.0F - this.mSelectionOffset) * (float)var2);
            }
         } else {
            var2 = -1;
            var3 = var2;
         }

         this.setIndicatorPosition(var3, var2);
      }

      void animateIndicatorToPosition(final int var1, int var2) {
         if(this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
            this.mIndicatorAnimator.cancel();
         }

         boolean var3;
         if(ViewCompat.getLayoutDirection(this) == 1) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var4 = this.getChildAt(var1);
         if(var4 == null) {
            this.updateIndicatorPosition();
         } else {
            final int var5 = var4.getLeft();
            final int var6 = var4.getRight();
            final int var8;
            final int var9;
            if(Math.abs(var1 - this.mSelectedPosition) <= 1) {
               var9 = this.mIndicatorLeft;
               var8 = this.mIndicatorRight;
            } else {
               int var7 = TabLayout.this.dpToPx(24);
               if(var1 < this.mSelectedPosition) {
                  if(var3) {
                     var8 = var5 - var7;
                     var9 = var8;
                  } else {
                     var8 = var6 + var7;
                     var9 = var8;
                  }
               } else if(var3) {
                  var8 = var6 + var7;
                  var9 = var8;
               } else {
                  var8 = var5 - var7;
                  var9 = var8;
               }
            }

            if(var9 != var5 || var8 != var6) {
               ValueAnimatorCompat var10 = ViewUtils.createAnimator();
               this.mIndicatorAnimator = var10;
               var10.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
               var10.setDuration(var2);
               var10.setFloatValues(0.0F, 1.0F);
               var10.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener() {
                  public void onAnimationUpdate(ValueAnimatorCompat var1) {
                     float var2 = var1.getAnimatedFraction();
                     SlidingTabStrip.this.setIndicatorPosition(AnimationUtils.lerp(var9, var5, var2), AnimationUtils.lerp(var8, var6, var2));
                  }
               });
               var10.setListener(new ValueAnimatorCompat.AnimatorListenerAdapter() {
                  public void onAnimationEnd(ValueAnimatorCompat var1x) {
                     SlidingTabStrip.this.mSelectedPosition = var1;
                     SlidingTabStrip.this.mSelectionOffset = 0.0F;
                  }
               });
               var10.start();
               return;
            }
         }

      }

      boolean childrenNeedLayout() {
         int var1 = 0;

         for(int var2 = this.getChildCount(); var1 < var2; ++var1) {
            if(this.getChildAt(var1).getWidth() <= 0) {
               return true;
            }
         }

         return false;
      }

      public void draw(Canvas var1) {
         super.draw(var1);
         if(this.mIndicatorLeft >= 0 && this.mIndicatorRight > this.mIndicatorLeft) {
            var1.drawRect((float)this.mIndicatorLeft, (float)(this.getHeight() - this.mSelectedIndicatorHeight), (float)this.mIndicatorRight, (float)this.getHeight(), this.mSelectedIndicatorPaint);
         }

      }

      float getIndicatorPosition() {
         return (float)this.mSelectedPosition + this.mSelectionOffset;
      }

      protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
         super.onLayout(var1, var2, var3, var4, var5);
         if(this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
            this.mIndicatorAnimator.cancel();
            long var6 = this.mIndicatorAnimator.getDuration();
            this.animateIndicatorToPosition(this.mSelectedPosition, Math.round((1.0F - this.mIndicatorAnimator.getAnimatedFraction()) * (float)var6));
         } else {
            this.updateIndicatorPosition();
         }
      }

      protected void onMeasure(int var1, int var2) {
         super.onMeasure(var1, var2);
         if(MeasureSpec.getMode(var1) == 1073741824 && TabLayout.this.mMode == 1 && TabLayout.this.mTabGravity == 1) {
            int var3 = this.getChildCount();
            int var4 = 0;

            for(int var5 = 0; var5 < var3; ++var5) {
               View var11 = this.getChildAt(var5);
               if(var11.getVisibility() == 0) {
                  var4 = Math.max(var4, var11.getMeasuredWidth());
               }
            }

            if(var4 > 0) {
               int var6 = TabLayout.this.dpToPx(16);
               boolean var7 = false;
               if(var4 * var3 > this.getMeasuredWidth() - var6 * 2) {
                  TabLayout.this.mTabGravity = 0;
                  TabLayout.this.updateTabViews(false);
                  var7 = true;
               } else {
                  for(int var9 = 0; var9 < var3; ++var9) {
                     android.widget.LinearLayout.LayoutParams var10 = (android.widget.LinearLayout.LayoutParams)this.getChildAt(var9).getLayoutParams();
                     if(var10.width != var4 || var10.weight != 0.0F) {
                        var10.width = var4;
                        var10.weight = 0.0F;
                        var7 = true;
                     }
                  }
               }

               if(var7) {
                  super.onMeasure(var1, var2);
                  return;
               }
            }
         }

      }

      void setIndicatorPositionFromTabPosition(int var1, float var2) {
         if(this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
            this.mIndicatorAnimator.cancel();
         }

         this.mSelectedPosition = var1;
         this.mSelectionOffset = var2;
         this.updateIndicatorPosition();
      }

      void setSelectedIndicatorColor(int var1) {
         if(this.mSelectedIndicatorPaint.getColor() != var1) {
            this.mSelectedIndicatorPaint.setColor(var1);
            ViewCompat.postInvalidateOnAnimation(this);
         }

      }

      void setSelectedIndicatorHeight(int var1) {
         if(this.mSelectedIndicatorHeight != var1) {
            this.mSelectedIndicatorHeight = var1;
            ViewCompat.postInvalidateOnAnimation(this);
         }

      }
   }

   public static final class Tab {
      public static final int INVALID_POSITION = -1;
      private CharSequence mContentDesc;
      private View mCustomView;
      private Drawable mIcon;
      private final TabLayout mParent;
      private int mPosition = -1;
      private Object mTag;
      private CharSequence mText;
      private TabLayout.TabView mView;

      Tab(TabLayout var1) {
         this.mParent = var1;
      }

      private void reset() {
         this.mView = null;
         this.mTag = null;
         this.mIcon = null;
         this.mText = null;
         this.mContentDesc = null;
         this.mPosition = -1;
         this.mCustomView = null;
      }

      private void updateView() {
         if(this.mView != null) {
            this.mView.update();
         }

      }

      @Nullable
      public CharSequence getContentDescription() {
         return this.mContentDesc;
      }

      @Nullable
      public View getCustomView() {
         return this.mCustomView;
      }

      @Nullable
      public Drawable getIcon() {
         return this.mIcon;
      }

      public int getPosition() {
         return this.mPosition;
      }

      @Nullable
      public Object getTag() {
         return this.mTag;
      }

      @Nullable
      public CharSequence getText() {
         return this.mText;
      }

      public boolean isSelected() {
         return this.mParent.getSelectedTabPosition() == this.mPosition;
      }

      public void select() {
         this.mParent.selectTab(this);
      }

      @NonNull
      public TabLayout.Tab setContentDescription(@StringRes int var1) {
         return this.setContentDescription(this.mParent.getResources().getText(var1));
      }

      @NonNull
      public TabLayout.Tab setContentDescription(@Nullable CharSequence var1) {
         this.mContentDesc = var1;
         this.updateView();
         return this;
      }

      @NonNull
      public TabLayout.Tab setCustomView(@LayoutRes int var1) {
         return this.setCustomView(LayoutInflater.from(this.mView.getContext()).inflate(var1, this.mView, false));
      }

      @NonNull
      public TabLayout.Tab setCustomView(@Nullable View var1) {
         this.mCustomView = var1;
         this.updateView();
         return this;
      }

      @NonNull
      public TabLayout.Tab setIcon(@DrawableRes int var1) {
         return this.setIcon(AppCompatDrawableManager.get().getDrawable(this.mParent.getContext(), var1));
      }

      @NonNull
      public TabLayout.Tab setIcon(@Nullable Drawable var1) {
         this.mIcon = var1;
         this.updateView();
         return this;
      }

      void setPosition(int var1) {
         this.mPosition = var1;
      }

      @NonNull
      public TabLayout.Tab setTag(@Nullable Object var1) {
         this.mTag = var1;
         return this;
      }

      @NonNull
      public TabLayout.Tab setText(@StringRes int var1) {
         return this.setText(this.mParent.getResources().getText(var1));
      }

      @NonNull
      public TabLayout.Tab setText(@Nullable CharSequence var1) {
         this.mText = var1;
         this.updateView();
         return this;
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface TabGravity {
   }

   public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
      private int mPreviousScrollState;
      private int mScrollState;
      private final WeakReference<TabLayout> mTabLayoutRef;

      public TabLayoutOnPageChangeListener(TabLayout var1) {
         this.mTabLayoutRef = new WeakReference(var1);
      }

      private void reset() {
         this.mScrollState = 0;
         this.mPreviousScrollState = 0;
      }

      public void onPageScrollStateChanged(int var1) {
         this.mPreviousScrollState = this.mScrollState;
         this.mScrollState = var1;
      }

      public void onPageScrolled(int var1, float var2, int var3) {
         TabLayout var4 = (TabLayout)this.mTabLayoutRef.get();
         if(var4 != null) {
            boolean var5;
            if(this.mScrollState == 2 && this.mPreviousScrollState != 1) {
               var5 = false;
            } else {
               var5 = true;
            }

            boolean var6;
            if(this.mScrollState == 2 && this.mPreviousScrollState == 0) {
               var6 = false;
            } else {
               var6 = true;
            }

            var4.setScrollPosition(var1, var2, var5, var6);
         }

      }

      public void onPageSelected(int var1) {
         TabLayout var2 = (TabLayout)this.mTabLayoutRef.get();
         if(var2 != null && var2.getSelectedTabPosition() != var1) {
            boolean var3;
            if(this.mScrollState != 0 && (this.mScrollState != 2 || this.mPreviousScrollState != 0)) {
               var3 = false;
            } else {
               var3 = true;
            }

            var2.selectTab(var2.getTabAt(var1), var3);
         }

      }
   }

   class TabView extends LinearLayout implements OnLongClickListener {
      private ImageView mCustomIconView;
      private TextView mCustomTextView;
      private View mCustomView;
      private int mDefaultMaxLines = 2;
      private ImageView mIconView;
      private TabLayout.Tab mTab;
      private TextView mTextView;

      public TabView(Context var2) {
         super(var2);
         if(TabLayout.this.mTabBackgroundResId != 0) {
            this.setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(var2, TabLayout.this.mTabBackgroundResId));
         }

         ViewCompat.setPaddingRelative(this, TabLayout.this.mTabPaddingStart, TabLayout.this.mTabPaddingTop, TabLayout.this.mTabPaddingEnd, TabLayout.this.mTabPaddingBottom);
         this.setGravity(17);
         this.setOrientation(1);
         this.setClickable(true);
      }

      private float approximateLineWidth(Layout var1, int var2, float var3) {
         return var1.getLineWidth(var2) * (var3 / var1.getPaint().getTextSize());
      }

      private void reset() {
         this.setTab((TabLayout.Tab)null);
         this.setSelected(false);
      }

      private void setTab(@Nullable TabLayout.Tab var1) {
         if(var1 != this.mTab) {
            this.mTab = var1;
            this.update();
         }

      }

      private void updateTextAndIcon(@Nullable TextView var1, @Nullable ImageView var2) {
         Drawable var3;
         if(this.mTab != null) {
            var3 = this.mTab.getIcon();
         } else {
            var3 = null;
         }

         CharSequence var4;
         if(this.mTab != null) {
            var4 = this.mTab.getText();
         } else {
            var4 = null;
         }

         CharSequence var5;
         if(this.mTab != null) {
            var5 = this.mTab.getContentDescription();
         } else {
            var5 = null;
         }

         if(var2 != null) {
            if(var3 != null) {
               var2.setImageDrawable(var3);
               var2.setVisibility(0);
               this.setVisibility(0);
            } else {
               var2.setVisibility(8);
               var2.setImageDrawable((Drawable)null);
            }

            var2.setContentDescription(var5);
         }

         boolean var6;
         if(!TextUtils.isEmpty(var4)) {
            var6 = true;
         } else {
            var6 = false;
         }

         if(var1 != null) {
            if(var6) {
               var1.setText(var4);
               var1.setVisibility(0);
               this.setVisibility(0);
            } else {
               var1.setVisibility(8);
               var1.setText((CharSequence)null);
            }

            var1.setContentDescription(var5);
         }

         if(var2 != null) {
            MarginLayoutParams var7 = (MarginLayoutParams)var2.getLayoutParams();
            int var8 = 0;
            if(var6) {
               int var9 = var2.getVisibility();
               var8 = 0;
               if(var9 == 0) {
                  var8 = TabLayout.this.dpToPx(8);
               }
            }

            if(var8 != var7.bottomMargin) {
               var7.bottomMargin = var8;
               var2.requestLayout();
            }
         }

         if(!var6 && !TextUtils.isEmpty(var5)) {
            this.setOnLongClickListener(this);
         } else {
            this.setOnLongClickListener((OnLongClickListener)null);
            this.setLongClickable(false);
         }
      }

      public TabLayout.Tab getTab() {
         return this.mTab;
      }

      @TargetApi(14)
      public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
         super.onInitializeAccessibilityEvent(var1);
         var1.setClassName(ActionBar.Tab.class.getName());
      }

      @TargetApi(14)
      public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
         super.onInitializeAccessibilityNodeInfo(var1);
         var1.setClassName(ActionBar.Tab.class.getName());
      }

      public boolean onLongClick(View var1) {
         int[] var2 = new int[2];
         this.getLocationOnScreen(var2);
         Context var3 = this.getContext();
         int var4 = this.getWidth();
         int var5 = this.getHeight();
         int var6 = var3.getResources().getDisplayMetrics().widthPixels;
         Toast var7 = Toast.makeText(var3, this.mTab.getContentDescription(), 0);
         var7.setGravity(49, var2[0] + var4 / 2 - var6 / 2, var5);
         var7.show();
         return true;
      }

      public void onMeasure(int var1, int var2) {
         int var3 = MeasureSpec.getSize(var1);
         int var4 = MeasureSpec.getMode(var1);
         int var5 = TabLayout.this.getTabMaxWidth();
         int var6;
         if(var5 > 0 && (var4 == 0 || var3 > var5)) {
            var6 = MeasureSpec.makeMeasureSpec(TabLayout.this.mTabMaxWidth, Integer.MIN_VALUE);
         } else {
            var6 = var1;
         }

         super.onMeasure(var6, var2);
         if(this.mTextView != null) {
            this.getResources();
            float var8 = TabLayout.this.mTabTextSize;
            int var9 = this.mDefaultMaxLines;
            if(this.mIconView != null && this.mIconView.getVisibility() == 0) {
               var9 = 1;
            } else if(this.mTextView != null && this.mTextView.getLineCount() > 1) {
               var8 = TabLayout.this.mTabTextMultiLineSize;
            }

            float var10 = this.mTextView.getTextSize();
            int var11 = this.mTextView.getLineCount();
            int var12 = TextViewCompat.getMaxLines(this.mTextView);
            if(var8 != var10 || var12 >= 0 && var9 != var12) {
               boolean var13 = true;
               if(TabLayout.this.mMode == 1 && var8 > var10 && var11 == 1) {
                  Layout var14 = this.mTextView.getLayout();
                  if(var14 == null || this.approximateLineWidth(var14, 0, var8) > (float)var14.getWidth()) {
                     var13 = false;
                  }
               }

               if(var13) {
                  this.mTextView.setTextSize(0, var8);
                  this.mTextView.setMaxLines(var9);
                  super.onMeasure(var6, var2);
               }
            }
         }

      }

      public boolean performClick() {
         boolean var1 = super.performClick();
         if(this.mTab != null) {
            this.mTab.select();
            var1 = true;
         }

         return var1;
      }

      public void setSelected(boolean var1) {
         boolean var2;
         if(this.isSelected() != var1) {
            var2 = true;
         } else {
            var2 = false;
         }

         super.setSelected(var1);
         if(var2 && var1) {
            this.sendAccessibilityEvent(4);
            if(this.mTextView != null) {
               this.mTextView.setSelected(var1);
            }

            if(this.mIconView != null) {
               this.mIconView.setSelected(var1);
            }
         }

      }

      final void update() {
         TabLayout.Tab var1 = this.mTab;
         View var2;
         if(var1 != null) {
            var2 = var1.getCustomView();
         } else {
            var2 = null;
         }

         if(var2 != null) {
            ViewParent var5 = var2.getParent();
            if(var5 != this) {
               if(var5 != null) {
                  ((ViewGroup)var5).removeView(var2);
               }

               this.addView(var2);
            }

            this.mCustomView = var2;
            if(this.mTextView != null) {
               this.mTextView.setVisibility(8);
            }

            if(this.mIconView != null) {
               this.mIconView.setVisibility(8);
               this.mIconView.setImageDrawable((Drawable)null);
            }

            this.mCustomTextView = (TextView)var2.findViewById(16908308);
            if(this.mCustomTextView != null) {
               this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mCustomTextView);
            }

            this.mCustomIconView = (ImageView)var2.findViewById(16908294);
         } else {
            if(this.mCustomView != null) {
               this.removeView(this.mCustomView);
               this.mCustomView = null;
            }

            this.mCustomTextView = null;
            this.mCustomIconView = null;
         }

         if(this.mCustomView == null) {
            if(this.mIconView == null) {
               ImageView var4 = (ImageView)LayoutInflater.from(this.getContext()).inflate(class_5.layout.design_layout_tab_icon, this, false);
               this.addView(var4, 0);
               this.mIconView = var4;
            }

            if(this.mTextView == null) {
               TextView var3 = (TextView)LayoutInflater.from(this.getContext()).inflate(class_5.layout.design_layout_tab_text, this, false);
               this.addView(var3);
               this.mTextView = var3;
               this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mTextView);
            }

            this.mTextView.setTextAppearance(this.getContext(), TabLayout.this.mTabTextAppearance);
            if(TabLayout.this.mTabTextColors != null) {
               this.mTextView.setTextColor(TabLayout.this.mTabTextColors);
            }

            this.updateTextAndIcon(this.mTextView, this.mIconView);
         } else if(this.mCustomTextView != null || this.mCustomIconView != null) {
            this.updateTextAndIcon(this.mCustomTextView, this.mCustomIconView);
            return;
         }

      }
   }

   public static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
      private final ViewPager mViewPager;

      public ViewPagerOnTabSelectedListener(ViewPager var1) {
         this.mViewPager = var1;
      }

      public void onTabReselected(TabLayout.Tab var1) {
      }

      public void onTabSelected(TabLayout.Tab var1) {
         this.mViewPager.setCurrentItem(var1.getPosition());
      }

      public void onTabUnselected(TabLayout.Tab var1) {
      }
   }
}
