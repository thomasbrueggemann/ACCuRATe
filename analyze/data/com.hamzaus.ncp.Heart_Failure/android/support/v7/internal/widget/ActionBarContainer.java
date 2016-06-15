package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.view.ActionMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout {
   private ActionBarView mActionBarView;
   private Drawable mBackground;
   private boolean mIsSplit;
   private boolean mIsStacked;
   private boolean mIsTransitioning;
   private Drawable mSplitBackground;
   private Drawable mStackedBackground;
   private View mTabContainer;

   public ActionBarContainer(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ActionBarContainer(Context var1, AttributeSet var2) {
      boolean var3 = true;
      super(var1, var2);
      this.setBackgroundDrawable((Drawable)null);
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_639.styleable.ActionBar);
      this.mBackground = var4.getDrawable(10);
      this.mStackedBackground = var4.getDrawable(11);
      if(this.getId() == class_639.class_981.split_action_bar) {
         this.mIsSplit = var3;
         this.mSplitBackground = var4.getDrawable(12);
      }

      var4.recycle();
      if(this.mIsSplit) {
         if(this.mSplitBackground != null) {
            var3 = false;
         }
      } else if(this.mBackground != null || this.mStackedBackground != null) {
         var3 = false;
      }

      this.setWillNotDraw(var3);
   }

   private void drawBackgroundDrawable(Drawable var1, Canvas var2) {
      Rect var3 = var1.getBounds();
      if(var1 instanceof ColorDrawable && !var3.isEmpty() && VERSION.SDK_INT < 11) {
         var2.save();
         var2.clipRect(var3);
         var1.draw(var2);
         var2.restore();
      } else {
         var1.draw(var2);
      }
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if(this.mBackground != null && this.mBackground.isStateful()) {
         this.mBackground.setState(this.getDrawableState());
      }

      if(this.mStackedBackground != null && this.mStackedBackground.isStateful()) {
         this.mStackedBackground.setState(this.getDrawableState());
      }

      if(this.mSplitBackground != null && this.mSplitBackground.isStateful()) {
         this.mSplitBackground.setState(this.getDrawableState());
      }

   }

   public View getTabContainer() {
      return this.mTabContainer;
   }

   public void onDraw(Canvas var1) {
      if(this.getWidth() != 0 && this.getHeight() != 0) {
         if(this.mIsSplit) {
            if(this.mSplitBackground != null) {
               this.drawBackgroundDrawable(this.mSplitBackground, var1);
               return;
            }
         } else {
            if(this.mBackground != null) {
               this.drawBackgroundDrawable(this.mBackground, var1);
            }

            if(this.mStackedBackground != null && this.mIsStacked) {
               this.drawBackgroundDrawable(this.mStackedBackground, var1);
               return;
            }
         }
      }

   }

   public void onFinishInflate() {
      super.onFinishInflate();
      this.mActionBarView = (ActionBarView)this.findViewById(class_639.class_981.action_bar);
   }

   public boolean onHoverEvent(MotionEvent var1) {
      return true;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      return this.mIsTransitioning || super.onInterceptTouchEvent(var1);
   }

   public void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      boolean var6;
      if(this.mTabContainer != null && this.mTabContainer.getVisibility() != 8) {
         var6 = true;
      } else {
         var6 = false;
      }

      if(this.mTabContainer != null && this.mTabContainer.getVisibility() != 8) {
         int var11 = this.getMeasuredHeight();
         int var12 = this.mTabContainer.getMeasuredHeight();
         if((2 & this.mActionBarView.getDisplayOptions()) == 0) {
            int var13 = this.getChildCount();

            for(int var14 = 0; var14 < var13; ++var14) {
               View var15 = this.getChildAt(var14);
               if(var15 != this.mTabContainer && !this.mActionBarView.isCollapsed()) {
                  var15.offsetTopAndBottom(var12);
               }
            }

            this.mTabContainer.layout(var2, 0, var4, var12);
         } else {
            this.mTabContainer.layout(var2, var11 - var12, var4, var11);
         }
      }

      boolean var8;
      if(this.mIsSplit) {
         Drawable var10 = this.mSplitBackground;
         var8 = false;
         if(var10 != null) {
            this.mSplitBackground.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
            var8 = true;
         }
      } else {
         Drawable var7 = this.mBackground;
         var8 = false;
         if(var7 != null) {
            this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
            var8 = true;
         }

         boolean var9;
         if(var6 && this.mStackedBackground != null) {
            var9 = true;
         } else {
            var9 = false;
         }

         this.mIsStacked = var9;
         if(var9) {
            this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
            var8 = true;
         }
      }

      if(var8) {
         this.invalidate();
      }

   }

   public void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(this.mActionBarView != null) {
         LayoutParams var3 = (LayoutParams)this.mActionBarView.getLayoutParams();
         int var4;
         if(this.mActionBarView.isCollapsed()) {
            var4 = 0;
         } else {
            var4 = this.mActionBarView.getMeasuredHeight() + var3.topMargin + var3.bottomMargin;
         }

         if(this.mTabContainer != null && this.mTabContainer.getVisibility() != 8 && MeasureSpec.getMode(var2) == Integer.MIN_VALUE) {
            int var5 = MeasureSpec.getSize(var2);
            this.setMeasuredDimension(this.getMeasuredWidth(), Math.min(var4 + this.mTabContainer.getMeasuredHeight(), var5));
            return;
         }
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      super.onTouchEvent(var1);
      return true;
   }

   public void setPrimaryBackground(Drawable var1) {
      boolean var2 = true;
      if(this.mBackground != null) {
         this.mBackground.setCallback((Callback)null);
         this.unscheduleDrawable(this.mBackground);
      }

      this.mBackground = var1;
      if(var1 != null) {
         var1.setCallback(this);
         if(this.mActionBarView != null) {
            this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
         }
      }

      if(this.mIsSplit) {
         if(this.mSplitBackground != null) {
            var2 = false;
         }
      } else if(this.mBackground != null || this.mStackedBackground != null) {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.invalidate();
   }

   public void setSplitBackground(Drawable var1) {
      boolean var2 = true;
      if(this.mSplitBackground != null) {
         this.mSplitBackground.setCallback((Callback)null);
         this.unscheduleDrawable(this.mSplitBackground);
      }

      this.mSplitBackground = var1;
      if(var1 != null) {
         var1.setCallback(this);
         if(this.mIsSplit && this.mSplitBackground != null) {
            this.mSplitBackground.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
         }
      }

      if(this.mIsSplit) {
         if(this.mSplitBackground != null) {
            var2 = false;
         }
      } else if(this.mBackground != null || this.mStackedBackground != null) {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.invalidate();
   }

   public void setStackedBackground(Drawable var1) {
      boolean var2 = true;
      if(this.mStackedBackground != null) {
         this.mStackedBackground.setCallback((Callback)null);
         this.unscheduleDrawable(this.mStackedBackground);
      }

      this.mStackedBackground = var1;
      if(var1 != null) {
         var1.setCallback(this);
         if(this.mIsStacked && this.mStackedBackground != null) {
            this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
         }
      }

      if(this.mIsSplit) {
         if(this.mSplitBackground != null) {
            var2 = false;
         }
      } else if(this.mBackground != null || this.mStackedBackground != null) {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.invalidate();
   }

   public void setTabContainer(ScrollingTabContainerView var1) {
      if(this.mTabContainer != null) {
         this.removeView(this.mTabContainer);
      }

      this.mTabContainer = var1;
      if(var1 != null) {
         this.addView(var1);
         android.view.ViewGroup.LayoutParams var2 = var1.getLayoutParams();
         var2.width = -1;
         var2.height = -2;
         var1.setAllowCollapse(false);
      }

   }

   public void setTransitioning(boolean var1) {
      this.mIsTransitioning = var1;
      int var2;
      if(var1) {
         var2 = 393216;
      } else {
         var2 = 262144;
      }

      this.setDescendantFocusability(var2);
   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      boolean var2;
      if(var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(this.mBackground != null) {
         this.mBackground.setVisible(var2, false);
      }

      if(this.mStackedBackground != null) {
         this.mStackedBackground.setVisible(var2, false);
      }

      if(this.mSplitBackground != null) {
         this.mSplitBackground.setVisible(var2, false);
      }

   }

   public ActionMode startActionModeForChild(View var1, ActionMode.Callback var2) {
      return null;
   }

   protected boolean verifyDrawable(Drawable var1) {
      return var1 == this.mBackground && !this.mIsSplit || var1 == this.mStackedBackground && this.mIsStacked || var1 == this.mSplitBackground && this.mIsSplit || super.verifyDrawable(var1);
   }
}
