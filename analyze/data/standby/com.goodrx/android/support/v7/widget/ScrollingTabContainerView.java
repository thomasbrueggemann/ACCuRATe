package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.TintTypedArray;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class ScrollingTabContainerView extends HorizontalScrollView implements OnItemSelectedListener {
   private static final int FADE_DURATION = 200;
   private static final String TAG = "ScrollingTabContainerView";
   private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
   private boolean mAllowCollapse;
   private int mContentHeight;
   int mMaxTabWidth;
   private int mSelectedTabIndex;
   int mStackedTabMaxWidth;
   private ScrollingTabContainerView.TabClickListener mTabClickListener;
   private LinearLayoutCompat mTabLayout;
   Runnable mTabSelector;
   private Spinner mTabSpinner;
   protected final ScrollingTabContainerView.VisibilityAnimListener mVisAnimListener = new ScrollingTabContainerView.VisibilityAnimListener();
   protected ViewPropertyAnimatorCompat mVisibilityAnim;

   public ScrollingTabContainerView(Context var1) {
      super(var1);
      this.setHorizontalScrollBarEnabled(false);
      ActionBarPolicy var2 = ActionBarPolicy.get(var1);
      this.setContentHeight(var2.getTabContainerHeight());
      this.mStackedTabMaxWidth = var2.getStackedTabMaxWidth();
      this.mTabLayout = this.createTabLayout();
      this.addView(this.mTabLayout, new LayoutParams(-2, -1));
   }

   private Spinner createSpinner() {
      AppCompatSpinner var1 = new AppCompatSpinner(this.getContext(), (AttributeSet)null, class_22.attr.actionDropDownStyle);
      var1.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
      var1.setOnItemSelectedListener(this);
      return var1;
   }

   private LinearLayoutCompat createTabLayout() {
      LinearLayoutCompat var1 = new LinearLayoutCompat(this.getContext(), (AttributeSet)null, class_22.attr.actionBarTabBarStyle);
      var1.setMeasureWithLargestChildEnabled(true);
      var1.setGravity(17);
      var1.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
      return var1;
   }

   private ScrollingTabContainerView.TabView createTabView(ActionBar.Tab var1, boolean var2) {
      ScrollingTabContainerView.TabView var3 = new ScrollingTabContainerView.TabView(this.getContext(), var1, var2);
      if(var2) {
         var3.setBackgroundDrawable((Drawable)null);
         var3.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, this.mContentHeight));
         return var3;
      } else {
         var3.setFocusable(true);
         if(this.mTabClickListener == null) {
            this.mTabClickListener = new ScrollingTabContainerView.TabClickListener(null);
         }

         var3.setOnClickListener(this.mTabClickListener);
         return var3;
      }
   }

   private boolean isCollapsed() {
      return this.mTabSpinner != null && this.mTabSpinner.getParent() == this;
   }

   private void performCollapse() {
      if(!this.isCollapsed()) {
         if(this.mTabSpinner == null) {
            this.mTabSpinner = this.createSpinner();
         }

         this.removeView(this.mTabLayout);
         this.addView(this.mTabSpinner, new LayoutParams(-2, -1));
         if(this.mTabSpinner.getAdapter() == null) {
            this.mTabSpinner.setAdapter(new ScrollingTabContainerView.TabAdapter(null));
         }

         if(this.mTabSelector != null) {
            this.removeCallbacks(this.mTabSelector);
            this.mTabSelector = null;
         }

         this.mTabSpinner.setSelection(this.mSelectedTabIndex);
      }
   }

   private boolean performExpand() {
      if(!this.isCollapsed()) {
         return false;
      } else {
         this.removeView(this.mTabSpinner);
         this.addView(this.mTabLayout, new LayoutParams(-2, -1));
         this.setTabSelected(this.mTabSpinner.getSelectedItemPosition());
         return false;
      }
   }

   public void addTab(ActionBar.Tab var1, int var2, boolean var3) {
      ScrollingTabContainerView.TabView var4 = this.createTabView(var1, false);
      this.mTabLayout.addView(var4, var2, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
      if(this.mTabSpinner != null) {
         ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
      }

      if(var3) {
         var4.setSelected(true);
      }

      if(this.mAllowCollapse) {
         this.requestLayout();
      }

   }

   public void addTab(ActionBar.Tab var1, boolean var2) {
      ScrollingTabContainerView.TabView var3 = this.createTabView(var1, false);
      this.mTabLayout.addView(var3, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
      if(this.mTabSpinner != null) {
         ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
      }

      if(var2) {
         var3.setSelected(true);
      }

      if(this.mAllowCollapse) {
         this.requestLayout();
      }

   }

   public void animateToTab(int var1) {
      final View var2 = this.mTabLayout.getChildAt(var1);
      if(this.mTabSelector != null) {
         this.removeCallbacks(this.mTabSelector);
      }

      this.mTabSelector = new Runnable() {
         public void run() {
            int var1 = var2.getLeft() - (ScrollingTabContainerView.this.getWidth() - var2.getWidth()) / 2;
            ScrollingTabContainerView.this.smoothScrollTo(var1, 0);
            ScrollingTabContainerView.this.mTabSelector = null;
         }
      };
      this.post(this.mTabSelector);
   }

   public void animateToVisibility(int var1) {
      if(this.mVisibilityAnim != null) {
         this.mVisibilityAnim.cancel();
      }

      if(var1 == 0) {
         if(this.getVisibility() != 0) {
            ViewCompat.setAlpha(this, 0.0F);
         }

         ViewPropertyAnimatorCompat var6 = ViewCompat.animate(this).alpha(1.0F);
         var6.setDuration(200L);
         var6.setInterpolator(sAlphaInterpolator);
         var6.setListener(this.mVisAnimListener.withFinalVisibility(var6, var1));
         var6.start();
      } else {
         ViewPropertyAnimatorCompat var2 = ViewCompat.animate(this).alpha(0.0F);
         var2.setDuration(200L);
         var2.setInterpolator(sAlphaInterpolator);
         var2.setListener(this.mVisAnimListener.withFinalVisibility(var2, var1));
         var2.start();
      }
   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      if(this.mTabSelector != null) {
         this.post(this.mTabSelector);
      }

   }

   protected void onConfigurationChanged(Configuration var1) {
      if(VERSION.SDK_INT >= 8) {
         super.onConfigurationChanged(var1);
      }

      ActionBarPolicy var2 = ActionBarPolicy.get(this.getContext());
      this.setContentHeight(var2.getTabContainerHeight());
      this.mStackedTabMaxWidth = var2.getStackedTabMaxWidth();
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mTabSelector != null) {
         this.removeCallbacks(this.mTabSelector);
      }

   }

   public void onItemSelected(AdapterView<?> var1, View var2, int var3, long var4) {
      ((ScrollingTabContainerView.TabView)var2).getTab().select();
   }

   public void onMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getMode(var1);
      boolean var4;
      if(var3 == 1073741824) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.setFillViewport(var4);
      int var5 = this.mTabLayout.getChildCount();
      if(var5 <= 1 || var3 != 1073741824 && var3 != Integer.MIN_VALUE) {
         this.mMaxTabWidth = -1;
      } else {
         if(var5 > 2) {
            this.mMaxTabWidth = (int)(0.4F * (float)MeasureSpec.getSize(var1));
         } else {
            this.mMaxTabWidth = MeasureSpec.getSize(var1) / 2;
         }

         this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
      }

      int var6 = MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
      boolean var7;
      if(!var4 && this.mAllowCollapse) {
         var7 = true;
      } else {
         var7 = false;
      }

      if(var7) {
         this.mTabLayout.measure(0, var6);
         if(this.mTabLayout.getMeasuredWidth() > MeasureSpec.getSize(var1)) {
            this.performCollapse();
         } else {
            this.performExpand();
         }
      } else {
         this.performExpand();
      }

      int var9 = this.getMeasuredWidth();
      super.onMeasure(var1, var6);
      int var10 = this.getMeasuredWidth();
      if(var4 && var9 != var10) {
         this.setTabSelected(this.mSelectedTabIndex);
      }

   }

   public void onNothingSelected(AdapterView<?> var1) {
   }

   public void removeAllTabs() {
      this.mTabLayout.removeAllViews();
      if(this.mTabSpinner != null) {
         ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
      }

      if(this.mAllowCollapse) {
         this.requestLayout();
      }

   }

   public void removeTabAt(int var1) {
      this.mTabLayout.removeViewAt(var1);
      if(this.mTabSpinner != null) {
         ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
      }

      if(this.mAllowCollapse) {
         this.requestLayout();
      }

   }

   public void setAllowCollapse(boolean var1) {
      this.mAllowCollapse = var1;
   }

   public void setContentHeight(int var1) {
      this.mContentHeight = var1;
      this.requestLayout();
   }

   public void setTabSelected(int var1) {
      this.mSelectedTabIndex = var1;
      int var2 = this.mTabLayout.getChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         View var4 = this.mTabLayout.getChildAt(var3);
         boolean var5;
         if(var3 == var1) {
            var5 = true;
         } else {
            var5 = false;
         }

         var4.setSelected(var5);
         if(var5) {
            this.animateToTab(var1);
         }
      }

      if(this.mTabSpinner != null && var1 >= 0) {
         this.mTabSpinner.setSelection(var1);
      }

   }

   public void updateTab(int var1) {
      ((ScrollingTabContainerView.TabView)this.mTabLayout.getChildAt(var1)).update();
      if(this.mTabSpinner != null) {
         ((ScrollingTabContainerView.TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
      }

      if(this.mAllowCollapse) {
         this.requestLayout();
      }

   }

   private class TabAdapter extends BaseAdapter {
      private TabAdapter() {
      }

      // $FF: synthetic method
      TabAdapter(Object var2) {
         this();
      }

      public int getCount() {
         return ScrollingTabContainerView.this.mTabLayout.getChildCount();
      }

      public Object getItem(int var1) {
         return ((ScrollingTabContainerView.TabView)ScrollingTabContainerView.this.mTabLayout.getChildAt(var1)).getTab();
      }

      public long getItemId(int var1) {
         return (long)var1;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         if(var2 == null) {
            return ScrollingTabContainerView.this.createTabView((ActionBar.Tab)this.getItem(var1), true);
         } else {
            ((ScrollingTabContainerView.TabView)var2).bindTab((ActionBar.Tab)this.getItem(var1));
            return var2;
         }
      }
   }

   private class TabClickListener implements OnClickListener {
      private TabClickListener() {
      }

      // $FF: synthetic method
      TabClickListener(Object var2) {
         this();
      }

      public void onClick(View var1) {
         ((ScrollingTabContainerView.TabView)var1).getTab().select();
         int var2 = ScrollingTabContainerView.this.mTabLayout.getChildCount();

         for(int var3 = 0; var3 < var2; ++var3) {
            View var4 = ScrollingTabContainerView.this.mTabLayout.getChildAt(var3);
            boolean var5;
            if(var4 == var1) {
               var5 = true;
            } else {
               var5 = false;
            }

            var4.setSelected(var5);
         }

      }
   }

   private class TabView extends LinearLayoutCompat implements OnLongClickListener {
      private final int[] BG_ATTRS = new int[]{16842964};
      private View mCustomView;
      private ImageView mIconView;
      private ActionBar.Tab mTab;
      private TextView mTextView;

      public TabView(Context var2, ActionBar.Tab var3, boolean var4) {
         super(var2, (AttributeSet)null, class_22.attr.actionBarTabStyle);
         this.mTab = var3;
         TintTypedArray var5 = TintTypedArray.obtainStyledAttributes(var2, (AttributeSet)null, this.BG_ATTRS, class_22.attr.actionBarTabStyle, 0);
         if(var5.hasValue(0)) {
            this.setBackgroundDrawable(var5.getDrawable(0));
         }

         var5.recycle();
         if(var4) {
            this.setGravity(8388627);
         }

         this.update();
      }

      public void bindTab(ActionBar.Tab var1) {
         this.mTab = var1;
         this.update();
      }

      public ActionBar.Tab getTab() {
         return this.mTab;
      }

      public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
         super.onInitializeAccessibilityEvent(var1);
         var1.setClassName(ActionBar.Tab.class.getName());
      }

      public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
         super.onInitializeAccessibilityNodeInfo(var1);
         if(VERSION.SDK_INT >= 14) {
            var1.setClassName(ActionBar.Tab.class.getName());
         }

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
         super.onMeasure(var1, var2);
         if(ScrollingTabContainerView.this.mMaxTabWidth > 0 && this.getMeasuredWidth() > ScrollingTabContainerView.this.mMaxTabWidth) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.mMaxTabWidth, 1073741824), var2);
         }

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
         }

      }

      public void update() {
         ActionBar.Tab var1 = this.mTab;
         View var2 = var1.getCustomView();
         if(var2 != null) {
            ViewParent var10 = var2.getParent();
            if(var10 != this) {
               if(var10 != null) {
                  ((ViewGroup)var10).removeView(var2);
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

         } else {
            if(this.mCustomView != null) {
               this.removeView(this.mCustomView);
               this.mCustomView = null;
            }

            Drawable var3 = var1.getIcon();
            CharSequence var4 = var1.getText();
            if(var3 != null) {
               if(this.mIconView == null) {
                  ImageView var8 = new ImageView(this.getContext());
                  LinearLayoutCompat.LayoutParams var9 = new LinearLayoutCompat.LayoutParams(-2, -2);
                  var9.gravity = 16;
                  var8.setLayoutParams(var9);
                  this.addView(var8, 0);
                  this.mIconView = var8;
               }

               this.mIconView.setImageDrawable(var3);
               this.mIconView.setVisibility(0);
            } else if(this.mIconView != null) {
               this.mIconView.setVisibility(8);
               this.mIconView.setImageDrawable((Drawable)null);
            }

            boolean var5;
            if(!TextUtils.isEmpty(var4)) {
               var5 = true;
            } else {
               var5 = false;
            }

            if(var5) {
               if(this.mTextView == null) {
                  AppCompatTextView var6 = new AppCompatTextView(this.getContext(), (AttributeSet)null, class_22.attr.actionBarTabTextStyle);
                  var6.setEllipsize(TruncateAt.END);
                  LinearLayoutCompat.LayoutParams var7 = new LinearLayoutCompat.LayoutParams(-2, -2);
                  var7.gravity = 16;
                  var6.setLayoutParams(var7);
                  this.addView(var6);
                  this.mTextView = var6;
               }

               this.mTextView.setText(var4);
               this.mTextView.setVisibility(0);
            } else if(this.mTextView != null) {
               this.mTextView.setVisibility(8);
               this.mTextView.setText((CharSequence)null);
            }

            if(this.mIconView != null) {
               this.mIconView.setContentDescription(var1.getContentDescription());
            }

            if(!var5 && !TextUtils.isEmpty(var1.getContentDescription())) {
               this.setOnLongClickListener(this);
            } else {
               this.setOnLongClickListener((OnLongClickListener)null);
               this.setLongClickable(false);
            }
         }
      }
   }

   protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {
      private boolean mCanceled = false;
      private int mFinalVisibility;

      public void onAnimationCancel(View var1) {
         this.mCanceled = true;
      }

      public void onAnimationEnd(View var1) {
         if(!this.mCanceled) {
            ScrollingTabContainerView.this.mVisibilityAnim = null;
            ScrollingTabContainerView.this.setVisibility(this.mFinalVisibility);
         }
      }

      public void onAnimationStart(View var1) {
         ScrollingTabContainerView.this.setVisibility(0);
         this.mCanceled = false;
      }

      public ScrollingTabContainerView.VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat var1, int var2) {
         this.mFinalVisibility = var2;
         ScrollingTabContainerView.this.mVisibilityAnim = var1;
         return this;
      }
   }
}
