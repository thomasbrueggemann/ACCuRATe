package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.widget.AbsActionBarView;
import android.support.v7.view.ActionMode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends AbsActionBarView {
   private static final String TAG = "ActionBarContextView";
   private View mClose;
   private View mCustomView;
   private Drawable mSplitBackground;
   private CharSequence mSubtitle;
   private int mSubtitleStyleRes;
   private TextView mSubtitleView;
   private CharSequence mTitle;
   private LinearLayout mTitleLayout;
   private boolean mTitleOptional;
   private int mTitleStyleRes;
   private TextView mTitleView;

   public ActionBarContextView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ActionBarContextView(Context var1, AttributeSet var2) {
      this(var1, var2, class_639.attr.actionModeStyle);
   }

   public ActionBarContextView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_639.styleable.ActionMode, var3, 0);
      this.setBackgroundDrawable(var4.getDrawable(3));
      this.mTitleStyleRes = var4.getResourceId(1, 0);
      this.mSubtitleStyleRes = var4.getResourceId(2, 0);
      this.mContentHeight = var4.getLayoutDimension(0, 0);
      this.mSplitBackground = var4.getDrawable(4);
      var4.recycle();
   }

   private void initTitle() {
      byte var1 = 8;
      if(this.mTitleLayout == null) {
         LayoutInflater.from(this.getContext()).inflate(class_639.layout.abc_action_bar_title_item, this);
         this.mTitleLayout = (LinearLayout)this.getChildAt(-1 + this.getChildCount());
         this.mTitleView = (TextView)this.mTitleLayout.findViewById(class_639.class_981.action_bar_title);
         this.mSubtitleView = (TextView)this.mTitleLayout.findViewById(class_639.class_981.action_bar_subtitle);
         if(this.mTitleStyleRes != 0) {
            this.mTitleView.setTextAppearance(this.getContext(), this.mTitleStyleRes);
         }

         if(this.mSubtitleStyleRes != 0) {
            this.mSubtitleView.setTextAppearance(this.getContext(), this.mSubtitleStyleRes);
         }
      }

      this.mTitleView.setText(this.mTitle);
      this.mSubtitleView.setText(this.mSubtitle);
      boolean var2;
      if(!TextUtils.isEmpty(this.mTitle)) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3;
      if(!TextUtils.isEmpty(this.mSubtitle)) {
         var3 = true;
      } else {
         var3 = false;
      }

      TextView var4 = this.mSubtitleView;
      byte var5;
      if(var3) {
         var5 = 0;
      } else {
         var5 = var1;
      }

      var4.setVisibility(var5);
      LinearLayout var6 = this.mTitleLayout;
      if(var2 || var3) {
         var1 = 0;
      }

      var6.setVisibility(var1);
      if(this.mTitleLayout.getParent() == null) {
         this.addView(this.mTitleLayout);
      }

   }

   public void closeMode() {
      if(this.mClose == null) {
         this.killMode();
      }

   }

   protected LayoutParams generateDefaultLayoutParams() {
      return new MarginLayoutParams(-1, -2);
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      return new MarginLayoutParams(this.getContext(), var1);
   }

   public CharSequence getSubtitle() {
      return this.mSubtitle;
   }

   public CharSequence getTitle() {
      return this.mTitle;
   }

   public boolean hideOverflowMenu() {
      return this.mActionMenuPresenter != null?this.mActionMenuPresenter.hideOverflowMenu():false;
   }

   public void initForMode(final ActionMode var1) {
      if(this.mClose == null) {
         this.mClose = LayoutInflater.from(this.getContext()).inflate(class_639.layout.abc_action_mode_close_item, this, false);
         this.addView(this.mClose);
      } else if(this.mClose.getParent() == null) {
         this.addView(this.mClose);
      }

      this.mClose.findViewById(class_639.class_981.action_mode_close_button).setOnClickListener(new OnClickListener() {
         public void onClick(View var1x) {
            var1.finish();
         }
      });
      MenuBuilder var2 = (MenuBuilder)var1.getMenu();
      if(this.mActionMenuPresenter != null) {
         this.mActionMenuPresenter.dismissPopupMenus();
      }

      this.mActionMenuPresenter = new ActionMenuPresenter(this.getContext());
      this.mActionMenuPresenter.setReserveOverflow(true);
      LayoutParams var3 = new LayoutParams(-2, -1);
      if(!this.mSplitActionBar) {
         var2.addMenuPresenter(this.mActionMenuPresenter);
         this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
         this.mMenuView.setBackgroundDrawable((Drawable)null);
         this.addView(this.mMenuView, var3);
      } else {
         this.mActionMenuPresenter.setWidthLimit(this.getContext().getResources().getDisplayMetrics().widthPixels, true);
         this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
         var3.width = -1;
         var3.height = this.mContentHeight;
         var2.addMenuPresenter(this.mActionMenuPresenter);
         this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
         this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
         this.mSplitView.addView(this.mMenuView, var3);
      }
   }

   public boolean isOverflowMenuShowing() {
      return this.mActionMenuPresenter != null?this.mActionMenuPresenter.isOverflowMenuShowing():false;
   }

   public boolean isTitleOptional() {
      return this.mTitleOptional;
   }

   public void killMode() {
      this.removeAllViews();
      if(this.mSplitView != null) {
         this.mSplitView.removeView(this.mMenuView);
      }

      this.mCustomView = null;
      this.mMenuView = null;
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mActionMenuPresenter != null) {
         this.mActionMenuPresenter.hideOverflowMenu();
         this.mActionMenuPresenter.hideSubMenus();
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var6 = this.getPaddingLeft();
      int var7 = this.getPaddingTop();
      int var8 = var5 - var3 - this.getPaddingTop() - this.getPaddingBottom();
      if(this.mClose != null && this.mClose.getVisibility() != 8) {
         MarginLayoutParams var12 = (MarginLayoutParams)this.mClose.getLayoutParams();
         int var13 = var6 + var12.leftMargin;
         var6 = var13 + this.positionChild(this.mClose, var13, var7, var8) + var12.rightMargin;
      }

      if(this.mTitleLayout != null && this.mCustomView == null && this.mTitleLayout.getVisibility() != 8) {
         var6 += this.positionChild(this.mTitleLayout, var6, var7, var8);
      }

      int var10000;
      if(this.mCustomView != null) {
         var10000 = var6 + this.positionChild(this.mCustomView, var6, var7, var8);
      }

      int var9 = var4 - var2 - this.getPaddingRight();
      if(this.mMenuView != null) {
         var10000 = var9 - this.positionChildInverse(this.mMenuView, var9, var7, var8);
      }

   }

   protected void onMeasure(int var1, int var2) {
      if(MeasureSpec.getMode(var1) != 1073741824) {
         throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"FILL_PARENT\" (or fill_parent)");
      } else if(MeasureSpec.getMode(var2) == 0) {
         throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
      } else {
         int var3 = MeasureSpec.getSize(var1);
         int var4;
         if(this.mContentHeight > 0) {
            var4 = this.mContentHeight;
         } else {
            var4 = MeasureSpec.getSize(var2);
         }

         int var5 = this.getPaddingTop() + this.getPaddingBottom();
         int var6 = var3 - this.getPaddingLeft() - this.getPaddingRight();
         int var7 = var4 - var5;
         int var8 = MeasureSpec.makeMeasureSpec(var7, Integer.MIN_VALUE);
         if(this.mClose != null) {
            int var23 = this.measureChildView(this.mClose, var6, var8, 0);
            MarginLayoutParams var24 = (MarginLayoutParams)this.mClose.getLayoutParams();
            var6 = var23 - (var24.leftMargin + var24.rightMargin);
         }

         if(this.mMenuView != null && this.mMenuView.getParent() == this) {
            var6 = this.measureChildView(this.mMenuView, var6, var8, 0);
         }

         if(this.mTitleLayout != null && this.mCustomView == null) {
            if(this.mTitleOptional) {
               int var18 = MeasureSpec.makeMeasureSpec(0, 0);
               this.mTitleLayout.measure(var18, var8);
               int var19 = this.mTitleLayout.getMeasuredWidth();
               boolean var20;
               if(var19 <= var6) {
                  var20 = true;
               } else {
                  var20 = false;
               }

               if(var20) {
                  var6 -= var19;
               }

               LinearLayout var21 = this.mTitleLayout;
               byte var22;
               if(var20) {
                  var22 = 0;
               } else {
                  var22 = 8;
               }

               var21.setVisibility(var22);
            } else {
               var6 = this.measureChildView(this.mTitleLayout, var6, var8, 0);
            }
         }

         if(this.mCustomView != null) {
            LayoutParams var13 = this.mCustomView.getLayoutParams();
            int var14;
            if(var13.width != -2) {
               var14 = 1073741824;
            } else {
               var14 = Integer.MIN_VALUE;
            }

            int var15;
            if(var13.width >= 0) {
               var15 = Math.min(var13.width, var6);
            } else {
               var15 = var6;
            }

            int var16;
            if(var13.height != -2) {
               var16 = 1073741824;
            } else {
               var16 = Integer.MIN_VALUE;
            }

            int var17;
            if(var13.height >= 0) {
               var17 = Math.min(var13.height, var7);
            } else {
               var17 = var7;
            }

            this.mCustomView.measure(MeasureSpec.makeMeasureSpec(var15, var14), MeasureSpec.makeMeasureSpec(var17, var16));
         }

         if(this.mContentHeight <= 0) {
            int var9 = 0;
            int var10 = this.getChildCount();

            for(int var11 = 0; var11 < var10; ++var11) {
               int var12 = var5 + this.getChildAt(var11).getMeasuredHeight();
               if(var12 > var9) {
                  var9 = var12;
               }
            }

            this.setMeasuredDimension(var3, var9);
         } else {
            this.setMeasuredDimension(var3, var4);
         }
      }
   }

   public void setContentHeight(int var1) {
      this.mContentHeight = var1;
   }

   public void setCustomView(View var1) {
      if(this.mCustomView != null) {
         this.removeView(this.mCustomView);
      }

      this.mCustomView = var1;
      if(this.mTitleLayout != null) {
         this.removeView(this.mTitleLayout);
         this.mTitleLayout = null;
      }

      if(var1 != null) {
         this.addView(var1);
      }

      this.requestLayout();
   }

   public void setSplitActionBar(boolean var1) {
      if(this.mSplitActionBar != var1) {
         if(this.mActionMenuPresenter != null) {
            LayoutParams var2 = new LayoutParams(-2, -1);
            if(!var1) {
               this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
               this.mMenuView.setBackgroundDrawable((Drawable)null);
               ViewGroup var4 = (ViewGroup)this.mMenuView.getParent();
               if(var4 != null) {
                  var4.removeView(this.mMenuView);
               }

               this.addView(this.mMenuView, var2);
            } else {
               this.mActionMenuPresenter.setWidthLimit(this.getContext().getResources().getDisplayMetrics().widthPixels, true);
               this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
               var2.width = -1;
               var2.height = this.mContentHeight;
               this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
               this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
               ViewGroup var3 = (ViewGroup)this.mMenuView.getParent();
               if(var3 != null) {
                  var3.removeView(this.mMenuView);
               }

               this.mSplitView.addView(this.mMenuView, var2);
            }
         }

         super.setSplitActionBar(var1);
      }

   }

   public void setSubtitle(CharSequence var1) {
      this.mSubtitle = var1;
      this.initTitle();
   }

   public void setTitle(CharSequence var1) {
      this.mTitle = var1;
      this.initTitle();
   }

   public void setTitleOptional(boolean var1) {
      if(var1 != this.mTitleOptional) {
         this.requestLayout();
      }

      this.mTitleOptional = var1;
   }

   public boolean showOverflowMenu() {
      return this.mActionMenuPresenter != null?this.mActionMenuPresenter.showOverflowMenu():false;
   }
}
