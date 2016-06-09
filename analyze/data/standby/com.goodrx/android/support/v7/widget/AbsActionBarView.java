package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.class_22;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;

abstract class AbsActionBarView extends ViewGroup {
   private static final int FADE_DURATION = 200;
   protected ActionMenuPresenter mActionMenuPresenter;
   protected int mContentHeight;
   private boolean mEatingHover;
   private boolean mEatingTouch;
   protected ActionMenuView mMenuView;
   protected final Context mPopupContext;
   protected final AbsActionBarView.VisibilityAnimListener mVisAnimListener;
   protected ViewPropertyAnimatorCompat mVisibilityAnim;

   AbsActionBarView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   AbsActionBarView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   AbsActionBarView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mVisAnimListener = new AbsActionBarView.VisibilityAnimListener();
      TypedValue var4 = new TypedValue();
      if(var1.getTheme().resolveAttribute(class_22.attr.actionBarPopupTheme, var4, true) && var4.resourceId != 0) {
         this.mPopupContext = new ContextThemeWrapper(var1, var4.resourceId);
      } else {
         this.mPopupContext = var1;
      }
   }

   protected static int next(int var0, int var1, boolean var2) {
      return var2?var0 - var1:var0 + var1;
   }

   public void animateToVisibility(int var1) {
      this.setupAnimatorToVisibility(var1, 200L).start();
   }

   public boolean canShowOverflowMenu() {
      return this.isOverflowReserved() && this.getVisibility() == 0;
   }

   public void dismissPopupMenus() {
      if(this.mActionMenuPresenter != null) {
         this.mActionMenuPresenter.dismissPopupMenus();
      }

   }

   public int getAnimatedVisibility() {
      return this.mVisibilityAnim != null?this.mVisAnimListener.mFinalVisibility:this.getVisibility();
   }

   public int getContentHeight() {
      return this.mContentHeight;
   }

   public boolean hideOverflowMenu() {
      return this.mActionMenuPresenter != null?this.mActionMenuPresenter.hideOverflowMenu():false;
   }

   public boolean isOverflowMenuShowPending() {
      return this.mActionMenuPresenter != null?this.mActionMenuPresenter.isOverflowMenuShowPending():false;
   }

   public boolean isOverflowMenuShowing() {
      return this.mActionMenuPresenter != null?this.mActionMenuPresenter.isOverflowMenuShowing():false;
   }

   public boolean isOverflowReserved() {
      return this.mActionMenuPresenter != null && this.mActionMenuPresenter.isOverflowReserved();
   }

   protected int measureChildView(View var1, int var2, int var3, int var4) {
      var1.measure(MeasureSpec.makeMeasureSpec(var2, Integer.MIN_VALUE), var3);
      return Math.max(0, var2 - var1.getMeasuredWidth() - var4);
   }

   protected void onConfigurationChanged(Configuration var1) {
      if(VERSION.SDK_INT >= 8) {
         super.onConfigurationChanged(var1);
      }

      TypedArray var2 = this.getContext().obtainStyledAttributes((AttributeSet)null, class_22.styleable.ActionBar, class_22.attr.actionBarStyle, 0);
      this.setContentHeight(var2.getLayoutDimension(class_22.styleable.ActionBar_height, 0));
      var2.recycle();
      if(this.mActionMenuPresenter != null) {
         this.mActionMenuPresenter.onConfigurationChanged(var1);
      }

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

   protected int positionChild(View var1, int var2, int var3, int var4, boolean var5) {
      int var6 = var1.getMeasuredWidth();
      int var7 = var1.getMeasuredHeight();
      int var8 = var3 + (var4 - var7) / 2;
      if(var5) {
         var1.layout(var2 - var6, var8, var2, var8 + var7);
      } else {
         var1.layout(var2, var8, var2 + var6, var8 + var7);
      }

      if(var5) {
         var6 = -var6;
      }

      return var6;
   }

   public void postShowOverflowMenu() {
      this.post(new Runnable() {
         public void run() {
            AbsActionBarView.this.showOverflowMenu();
         }
      });
   }

   public void setContentHeight(int var1) {
      this.mContentHeight = var1;
      this.requestLayout();
   }

   public void setVisibility(int var1) {
      if(var1 != this.getVisibility()) {
         if(this.mVisibilityAnim != null) {
            this.mVisibilityAnim.cancel();
         }

         super.setVisibility(var1);
      }

   }

   public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int var1, long var2) {
      if(this.mVisibilityAnim != null) {
         this.mVisibilityAnim.cancel();
      }

      if(var1 == 0) {
         if(this.getVisibility() != 0) {
            ViewCompat.setAlpha(this, 0.0F);
         }

         ViewPropertyAnimatorCompat var7 = ViewCompat.animate(this).alpha(1.0F);
         var7.setDuration(var2);
         var7.setListener(this.mVisAnimListener.withFinalVisibility(var7, var1));
         return var7;
      } else {
         ViewPropertyAnimatorCompat var4 = ViewCompat.animate(this).alpha(0.0F);
         var4.setDuration(var2);
         var4.setListener(this.mVisAnimListener.withFinalVisibility(var4, var1));
         return var4;
      }
   }

   public boolean showOverflowMenu() {
      return this.mActionMenuPresenter != null?this.mActionMenuPresenter.showOverflowMenu():false;
   }

   protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {
      private boolean mCanceled = false;
      int mFinalVisibility;

      public void onAnimationCancel(View var1) {
         this.mCanceled = true;
      }

      public void onAnimationEnd(View var1) {
         if(!this.mCanceled) {
            AbsActionBarView.this.mVisibilityAnim = null;
            AbsActionBarView.super.setVisibility(this.mFinalVisibility);
         }
      }

      public void onAnimationStart(View var1) {
         AbsActionBarView.super.setVisibility(0);
         this.mCanceled = false;
      }

      public AbsActionBarView.VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat var1, int var2) {
         AbsActionBarView.this.mVisibilityAnim = var1;
         this.mFinalVisibility = var2;
         return this;
      }
   }
}
