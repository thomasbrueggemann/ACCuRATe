package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.widget.AdapterViewICS;
import android.support.v7.internal.widget.CompatTextView;
import android.support.v7.internal.widget.SpinnerICS;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterViewICS.OnItemClickListener {
   private static final String TAG = "ScrollingTabContainerView";
   private boolean mAllowCollapse;
   private int mContentHeight;
   private final LayoutInflater mInflater;
   int mMaxTabWidth;
   private int mSelectedTabIndex;
   int mStackedTabMaxWidth;
   private ScrollingTabContainerView.TabClickListener mTabClickListener;
   private LinearLayout mTabLayout;
   Runnable mTabSelector;
   private SpinnerICS mTabSpinner;

   public ScrollingTabContainerView(Context var1) {
      super(var1);
      this.mInflater = LayoutInflater.from(var1);
      this.setHorizontalScrollBarEnabled(false);
      ActionBarPolicy var2 = ActionBarPolicy.get(var1);
      this.setContentHeight(var2.getTabContainerHeight());
      this.mStackedTabMaxWidth = var2.getStackedTabMaxWidth();
      this.mTabLayout = (LinearLayout)this.mInflater.inflate(class_639.layout.abc_action_bar_tabbar, this, false);
      this.addView(this.mTabLayout, new LayoutParams(-2, -1));
   }

   private SpinnerICS createSpinner() {
      SpinnerICS var1 = new SpinnerICS(this.getContext(), (AttributeSet)null, class_639.attr.actionDropDownStyle);
      var1.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
      var1.setOnItemClickListenerInt(this);
      return var1;
   }

   private ScrollingTabContainerView.TabView createTabView(ActionBar.Tab var1, boolean var2) {
      ScrollingTabContainerView.TabView var3 = (ScrollingTabContainerView.TabView)this.mInflater.inflate(class_639.layout.abc_action_bar_tab, this.mTabLayout, false);
      var3.attach(this, var1, var2);
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
            this.mTabSpinner.setAdapter((SpinnerAdapter)(new ScrollingTabContainerView.TabAdapter(null)));
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
      this.mTabLayout.addView(var4, var2, new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F));
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
      this.mTabLayout.addView(var3, new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F));
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

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      if(this.mTabSelector != null) {
         this.post(this.mTabSelector);
      }

   }

   protected void onConfigurationChanged(Configuration var1) {
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

   public void onItemClick(AdapterViewICS<?> var1, View var2, int var3, long var4) {
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

   public static class TabView extends LinearLayout {
      private View mCustomView;
      private ImageView mIconView;
      private ScrollingTabContainerView mParent;
      private ActionBar.Tab mTab;
      private TextView mTextView;

      public TabView(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      void attach(ScrollingTabContainerView var1, ActionBar.Tab var2, boolean var3) {
         this.mParent = var1;
         this.mTab = var2;
         if(var3) {
            this.setGravity(19);
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

      public void onMeasure(int var1, int var2) {
         super.onMeasure(var1, var2);
         int var3;
         if(this.mParent != null) {
            var3 = this.mParent.mMaxTabWidth;
         } else {
            var3 = 0;
         }

         if(var3 > 0 && this.getMeasuredWidth() > var3) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(var3, 1073741824), var2);
         }

      }

      public void update() {
         ActionBar.Tab var1 = this.mTab;
         View var2 = var1.getCustomView();
         if(var2 != null) {
            ViewParent var9 = var2.getParent();
            if(var9 != this) {
               if(var9 != null) {
                  ((ViewGroup)var9).removeView(var2);
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
                  ImageView var7 = new ImageView(this.getContext());
                  android.widget.LinearLayout.LayoutParams var8 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                  var8.gravity = 16;
                  var7.setLayoutParams(var8);
                  this.addView(var7, 0);
                  this.mIconView = var7;
               }

               this.mIconView.setImageDrawable(var3);
               this.mIconView.setVisibility(0);
            } else if(this.mIconView != null) {
               this.mIconView.setVisibility(8);
               this.mIconView.setImageDrawable((Drawable)null);
            }

            if(var4 != null) {
               if(this.mTextView == null) {
                  CompatTextView var5 = new CompatTextView(this.getContext(), (AttributeSet)null, class_639.attr.actionBarTabTextStyle);
                  var5.setEllipsize(TruncateAt.END);
                  android.widget.LinearLayout.LayoutParams var6 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                  var6.gravity = 16;
                  var5.setLayoutParams(var6);
                  this.addView(var5);
                  this.mTextView = var5;
               }

               this.mTextView.setText(var4);
               this.mTextView.setVisibility(0);
            } else if(this.mTextView != null) {
               this.mTextView.setVisibility(8);
               this.mTextView.setText((CharSequence)null);
            }

            if(this.mIconView != null) {
               this.mIconView.setContentDescription(var1.getContentDescription());
               return;
            }
         }

      }
   }
}
