package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements NestedScrollingChild, NestedScrollingParent, ScrollingView {
   private static final NestedScrollView.AccessibilityDelegate ACCESSIBILITY_DELEGATE = new NestedScrollView.AccessibilityDelegate();
   static final int ANIMATED_SCROLL_GAP = 250;
   private static final int INVALID_POINTER = -1;
   static final float MAX_SCROLL_FACTOR = 0.5F;
   private static final int[] SCROLLVIEW_STYLEABLE = new int[]{16843130};
   private static final String TAG = "NestedScrollView";
   private int mActivePointerId;
   private final NestedScrollingChildHelper mChildHelper;
   private View mChildToScrollTo;
   private EdgeEffectCompat mEdgeGlowBottom;
   private EdgeEffectCompat mEdgeGlowTop;
   private boolean mFillViewport;
   private boolean mIsBeingDragged;
   private boolean mIsLaidOut;
   private boolean mIsLayoutDirty;
   private int mLastMotionY;
   private long mLastScroll;
   private int mMaximumVelocity;
   private int mMinimumVelocity;
   private int mNestedYOffset;
   private NestedScrollView.OnScrollChangeListener mOnScrollChangeListener;
   private final NestedScrollingParentHelper mParentHelper;
   private NestedScrollView.SavedState mSavedState;
   private final int[] mScrollConsumed;
   private final int[] mScrollOffset;
   private ScrollerCompat mScroller;
   private boolean mSmoothScrollingEnabled;
   private final Rect mTempRect;
   private int mTouchSlop;
   private VelocityTracker mVelocityTracker;
   private float mVerticalScrollFactor;

   public NestedScrollView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public NestedScrollView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public NestedScrollView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mTempRect = new Rect();
      this.mIsLayoutDirty = true;
      this.mIsLaidOut = false;
      this.mChildToScrollTo = null;
      this.mIsBeingDragged = false;
      this.mSmoothScrollingEnabled = true;
      this.mActivePointerId = -1;
      this.mScrollOffset = new int[2];
      this.mScrollConsumed = new int[2];
      this.initScrollView();
      TypedArray var4 = var1.obtainStyledAttributes(var2, SCROLLVIEW_STYLEABLE, var3, 0);
      this.setFillViewport(var4.getBoolean(0, false));
      var4.recycle();
      this.mParentHelper = new NestedScrollingParentHelper(this);
      this.mChildHelper = new NestedScrollingChildHelper(this);
      this.setNestedScrollingEnabled(true);
      ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
   }

   private boolean canScroll() {
      View var1 = this.getChildAt(0);
      boolean var2 = false;
      if(var1 != null) {
         int var3 = var1.getHeight();
         int var4 = this.getHeight();
         int var5 = var3 + this.getPaddingTop() + this.getPaddingBottom();
         var2 = false;
         if(var4 < var5) {
            var2 = true;
         }
      }

      return var2;
   }

   private static int clamp(int var0, int var1, int var2) {
      if(var1 < var2 && var0 >= 0) {
         if(var1 + var0 > var2) {
            return var2 - var1;
         }
      } else {
         var0 = 0;
      }

      return var0;
   }

   private void doScrollY(int var1) {
      if(var1 != 0) {
         if(!this.mSmoothScrollingEnabled) {
            this.scrollBy(0, var1);
            return;
         }

         this.smoothScrollBy(0, var1);
      }

   }

   private void endDrag() {
      this.mIsBeingDragged = false;
      this.recycleVelocityTracker();
      this.stopNestedScroll();
      if(this.mEdgeGlowTop != null) {
         this.mEdgeGlowTop.onRelease();
         this.mEdgeGlowBottom.onRelease();
      }

   }

   private void ensureGlows() {
      if(ViewCompat.getOverScrollMode(this) != 2) {
         if(this.mEdgeGlowTop == null) {
            Context var1 = this.getContext();
            this.mEdgeGlowTop = new EdgeEffectCompat(var1);
            this.mEdgeGlowBottom = new EdgeEffectCompat(var1);
         }

      } else {
         this.mEdgeGlowTop = null;
         this.mEdgeGlowBottom = null;
      }
   }

   private View findFocusableViewInBounds(boolean var1, int var2, int var3) {
      ArrayList var4 = this.getFocusables(2);
      View var5 = null;
      boolean var6 = false;
      int var7 = var4.size();

      for(int var8 = 0; var8 < var7; ++var8) {
         View var9 = (View)var4.get(var8);
         int var10 = var9.getTop();
         int var11 = var9.getBottom();
         if(var2 < var11 && var10 < var3) {
            boolean var12;
            if(var2 < var10 && var11 < var3) {
               var12 = true;
            } else {
               var12 = false;
            }

            if(var5 == null) {
               var5 = var9;
               var6 = var12;
            } else {
               boolean var13;
               if((!var1 || var10 >= var5.getTop()) && (var1 || var11 <= var5.getBottom())) {
                  var13 = false;
               } else {
                  var13 = true;
               }

               if(var6) {
                  if(var12 && var13) {
                     var5 = var9;
                  }
               } else if(var12) {
                  var5 = var9;
                  var6 = true;
               } else if(var13) {
                  var5 = var9;
               }
            }
         }
      }

      return var5;
   }

   private void flingWithNestedDispatch(int var1) {
      int var2 = this.getScrollY();
      boolean var3;
      if(var2 <= 0 && var1 <= 0 || var2 >= this.getScrollRange() && var1 >= 0) {
         var3 = false;
      } else {
         var3 = true;
      }

      if(!this.dispatchNestedPreFling(0.0F, (float)var1)) {
         this.dispatchNestedFling(0.0F, (float)var1, var3);
         if(var3) {
            this.fling(var1);
         }
      }

   }

   private int getScrollRange() {
      int var1 = this.getChildCount();
      int var2 = 0;
      if(var1 > 0) {
         var2 = Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
      }

      return var2;
   }

   private float getVerticalScrollFactorCompat() {
      if(this.mVerticalScrollFactor == 0.0F) {
         TypedValue var1 = new TypedValue();
         Context var2 = this.getContext();
         if(!var2.getTheme().resolveAttribute(16842829, var1, true)) {
            throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
         }

         this.mVerticalScrollFactor = var1.getDimension(var2.getResources().getDisplayMetrics());
      }

      return this.mVerticalScrollFactor;
   }

   private boolean inChild(int var1, int var2) {
      int var3 = this.getChildCount();
      boolean var4 = false;
      if(var3 > 0) {
         int var5 = this.getScrollY();
         View var6 = this.getChildAt(0);
         int var7 = var6.getTop() - var5;
         var4 = false;
         if(var2 >= var7) {
            int var8 = var6.getBottom() - var5;
            var4 = false;
            if(var2 < var8) {
               int var9 = var6.getLeft();
               var4 = false;
               if(var1 >= var9) {
                  int var10 = var6.getRight();
                  var4 = false;
                  if(var1 < var10) {
                     var4 = true;
                  }
               }
            }
         }
      }

      return var4;
   }

   private void initOrResetVelocityTracker() {
      if(this.mVelocityTracker == null) {
         this.mVelocityTracker = VelocityTracker.obtain();
      } else {
         this.mVelocityTracker.clear();
      }
   }

   private void initScrollView() {
      this.mScroller = ScrollerCompat.create(this.getContext(), (Interpolator)null);
      this.setFocusable(true);
      this.setDescendantFocusability(262144);
      this.setWillNotDraw(false);
      ViewConfiguration var1 = ViewConfiguration.get(this.getContext());
      this.mTouchSlop = var1.getScaledTouchSlop();
      this.mMinimumVelocity = var1.getScaledMinimumFlingVelocity();
      this.mMaximumVelocity = var1.getScaledMaximumFlingVelocity();
   }

   private void initVelocityTrackerIfNotExists() {
      if(this.mVelocityTracker == null) {
         this.mVelocityTracker = VelocityTracker.obtain();
      }

   }

   private boolean isOffScreen(View var1) {
      boolean var2 = this.isWithinDeltaOfScreen(var1, 0, this.getHeight());
      boolean var3 = false;
      if(!var2) {
         var3 = true;
      }

      return var3;
   }

   private static boolean isViewDescendantOf(View var0, View var1) {
      if(var0 != var1) {
         ViewParent var2 = var0.getParent();
         if(!(var2 instanceof ViewGroup) || !isViewDescendantOf((View)var2, var1)) {
            return false;
         }
      }

      return true;
   }

   private boolean isWithinDeltaOfScreen(View var1, int var2, int var3) {
      var1.getDrawingRect(this.mTempRect);
      this.offsetDescendantRectToMyCoords(var1, this.mTempRect);
      return var2 + this.mTempRect.bottom >= this.getScrollY() && this.mTempRect.top - var2 <= var3 + this.getScrollY();
   }

   private void onSecondaryPointerUp(MotionEvent var1) {
      int var2 = ('\uff00' & var1.getAction()) >> 8;
      if(MotionEventCompat.getPointerId(var1, var2) == this.mActivePointerId) {
         byte var3;
         if(var2 == 0) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         this.mLastMotionY = (int)MotionEventCompat.getY(var1, var3);
         this.mActivePointerId = MotionEventCompat.getPointerId(var1, var3);
         if(this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
         }
      }

   }

   private void recycleVelocityTracker() {
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.recycle();
         this.mVelocityTracker = null;
      }

   }

   private boolean scrollAndFocus(int var1, int var2, int var3) {
      boolean var4 = true;
      int var5 = this.getHeight();
      int var6 = this.getScrollY();
      int var7 = var6 + var5;
      boolean var8;
      if(var1 == 33) {
         var8 = true;
      } else {
         var8 = false;
      }

      Object var9 = this.findFocusableViewInBounds(var8, var2, var3);
      if(var9 == null) {
         var9 = this;
      }

      if(var2 >= var6 && var3 <= var7) {
         var4 = false;
      } else {
         int var10;
         if(var8) {
            var10 = var2 - var6;
         } else {
            var10 = var3 - var7;
         }

         this.doScrollY(var10);
      }

      if(var9 != this.findFocus()) {
         ((View)var9).requestFocus(var1);
      }

      return var4;
   }

   private void scrollToChild(View var1) {
      var1.getDrawingRect(this.mTempRect);
      this.offsetDescendantRectToMyCoords(var1, this.mTempRect);
      int var2 = this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
      if(var2 != 0) {
         this.scrollBy(0, var2);
      }

   }

   private boolean scrollToChildRect(Rect var1, boolean var2) {
      int var3 = this.computeScrollDeltaToGetChildRectOnScreen(var1);
      boolean var4;
      if(var3 != 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if(var4) {
         if(!var2) {
            this.smoothScrollBy(0, var3);
            return var4;
         }

         this.scrollBy(0, var3);
      }

      return var4;
   }

   public void addView(View var1) {
      if(this.getChildCount() > 0) {
         throw new IllegalStateException("ScrollView can host only one direct child");
      } else {
         super.addView(var1);
      }
   }

   public void addView(View var1, int var2) {
      if(this.getChildCount() > 0) {
         throw new IllegalStateException("ScrollView can host only one direct child");
      } else {
         super.addView(var1, var2);
      }
   }

   public void addView(View var1, int var2, LayoutParams var3) {
      if(this.getChildCount() > 0) {
         throw new IllegalStateException("ScrollView can host only one direct child");
      } else {
         super.addView(var1, var2, var3);
      }
   }

   public void addView(View var1, LayoutParams var2) {
      if(this.getChildCount() > 0) {
         throw new IllegalStateException("ScrollView can host only one direct child");
      } else {
         super.addView(var1, var2);
      }
   }

   public boolean arrowScroll(int var1) {
      View var2 = this.findFocus();
      if(var2 == this) {
         var2 = null;
      }

      View var3 = FocusFinder.getInstance().findNextFocus(this, var2, var1);
      int var4 = this.getMaxScrollAmount();
      boolean var8;
      if(var3 != null && this.isWithinDeltaOfScreen(var3, var4, this.getHeight())) {
         var3.getDrawingRect(this.mTempRect);
         this.offsetDescendantRectToMyCoords(var3, this.mTempRect);
         this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
         var3.requestFocus(var1);
      } else {
         int var5 = var4;
         if(var1 == 33 && this.getScrollY() < var4) {
            var5 = this.getScrollY();
         } else if(var1 == 130 && this.getChildCount() > 0) {
            int var6 = this.getChildAt(0).getBottom();
            int var7 = this.getScrollY() + this.getHeight() - this.getPaddingBottom();
            if(var6 - var7 < var4) {
               var5 = var6 - var7;
            }
         }

         var8 = false;
         if(var5 == 0) {
            return var8;
         }

         int var9;
         if(var1 == 130) {
            var9 = var5;
         } else {
            var9 = -var5;
         }

         this.doScrollY(var9);
      }

      if(var2 != null && var2.isFocused() && this.isOffScreen(var2)) {
         int var10 = this.getDescendantFocusability();
         this.setDescendantFocusability(131072);
         this.requestFocus();
         this.setDescendantFocusability(var10);
      }

      var8 = true;
      return var8;
   }

   public int computeHorizontalScrollExtent() {
      return super.computeHorizontalScrollExtent();
   }

   public int computeHorizontalScrollOffset() {
      return super.computeHorizontalScrollOffset();
   }

   public int computeHorizontalScrollRange() {
      return super.computeHorizontalScrollRange();
   }

   public void computeScroll() {
      byte var1 = 1;
      if(this.mScroller.computeScrollOffset()) {
         int var2 = this.getScrollX();
         int var3 = this.getScrollY();
         int var4 = this.mScroller.getCurrX();
         int var5 = this.mScroller.getCurrY();
         if(var2 != var4 || var3 != var5) {
            int var6 = this.getScrollRange();
            int var7 = ViewCompat.getOverScrollMode(this);
            if(var7 != 0 && (var7 != var1 || var6 <= 0)) {
               var1 = 0;
            }

            this.overScrollByCompat(var4 - var2, var5 - var3, var2, var3, 0, var6, 0, 0, false);
            if(var1 != 0) {
               this.ensureGlows();
               if(var5 <= 0 && var3 > 0) {
                  this.mEdgeGlowTop.onAbsorb((int)this.mScroller.getCurrVelocity());
               } else if(var5 >= var6 && var3 < var6) {
                  this.mEdgeGlowBottom.onAbsorb((int)this.mScroller.getCurrVelocity());
                  return;
               }
            }
         }
      }

   }

   protected int computeScrollDeltaToGetChildRectOnScreen(Rect var1) {
      if(this.getChildCount() != 0) {
         int var2 = this.getHeight();
         int var3 = this.getScrollY();
         int var4 = var3 + var2;
         int var5 = this.getVerticalFadingEdgeLength();
         if(var1.top > 0) {
            var3 += var5;
         }

         if(var1.bottom < this.getChildAt(0).getHeight()) {
            var4 -= var5;
         }

         if(var1.bottom > var4 && var1.top > var3) {
            int var7;
            if(var1.height() > var2) {
               var7 = 0 + (var1.top - var3);
            } else {
               var7 = 0 + (var1.bottom - var4);
            }

            return Math.min(var7, this.getChildAt(0).getBottom() - var4);
         }

         if(var1.top < var3 && var1.bottom < var4) {
            int var6;
            if(var1.height() > var2) {
               var6 = 0 - (var4 - var1.bottom);
            } else {
               var6 = 0 - (var3 - var1.top);
            }

            return Math.max(var6, -this.getScrollY());
         }
      }

      return 0;
   }

   public int computeVerticalScrollExtent() {
      return super.computeVerticalScrollExtent();
   }

   public int computeVerticalScrollOffset() {
      return Math.max(0, super.computeVerticalScrollOffset());
   }

   public int computeVerticalScrollRange() {
      int var1 = this.getChildCount();
      int var2 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
      if(var1 == 0) {
         return var2;
      } else {
         int var3 = this.getChildAt(0).getBottom();
         int var4 = this.getScrollY();
         int var5 = Math.max(0, var3 - var2);
         if(var4 < 0) {
            var3 -= var4;
         } else if(var4 > var5) {
            var3 += var4 - var5;
         }

         return var3;
      }
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      return super.dispatchKeyEvent(var1) || this.executeKeyEvent(var1);
   }

   public boolean dispatchNestedFling(float var1, float var2, boolean var3) {
      return this.mChildHelper.dispatchNestedFling(var1, var2, var3);
   }

   public boolean dispatchNestedPreFling(float var1, float var2) {
      return this.mChildHelper.dispatchNestedPreFling(var1, var2);
   }

   public boolean dispatchNestedPreScroll(int var1, int var2, int[] var3, int[] var4) {
      return this.mChildHelper.dispatchNestedPreScroll(var1, var2, var3, var4);
   }

   public boolean dispatchNestedScroll(int var1, int var2, int var3, int var4, int[] var5) {
      return this.mChildHelper.dispatchNestedScroll(var1, var2, var3, var4, var5);
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      if(this.mEdgeGlowTop != null) {
         int var2 = this.getScrollY();
         if(!this.mEdgeGlowTop.isFinished()) {
            int var6 = var1.save();
            int var7 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            var1.translate((float)this.getPaddingLeft(), (float)Math.min(0, var2));
            this.mEdgeGlowTop.setSize(var7, this.getHeight());
            if(this.mEdgeGlowTop.draw(var1)) {
               ViewCompat.postInvalidateOnAnimation(this);
            }

            var1.restoreToCount(var6);
         }

         if(!this.mEdgeGlowBottom.isFinished()) {
            int var3 = var1.save();
            int var4 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int var5 = this.getHeight();
            var1.translate((float)(-var4 + this.getPaddingLeft()), (float)(var5 + Math.max(this.getScrollRange(), var2)));
            var1.rotate(180.0F, (float)var4, 0.0F);
            this.mEdgeGlowBottom.setSize(var4, var5);
            if(this.mEdgeGlowBottom.draw(var1)) {
               ViewCompat.postInvalidateOnAnimation(this);
            }

            var1.restoreToCount(var3);
         }
      }

   }

   public boolean executeKeyEvent(KeyEvent var1) {
      this.mTempRect.setEmpty();
      if(!this.canScroll()) {
         boolean var7 = this.isFocused();
         boolean var8 = false;
         if(var7) {
            int var9 = var1.getKeyCode();
            var8 = false;
            if(var9 != 4) {
               View var10 = this.findFocus();
               if(var10 == this) {
                  var10 = null;
               }

               View var11 = FocusFinder.getInstance().findNextFocus(this, var10, 130);
               var8 = false;
               if(var11 != null) {
                  var8 = false;
                  if(var11 != this) {
                     boolean var12 = var11.requestFocus(130);
                     var8 = false;
                     if(var12) {
                        var8 = true;
                     }
                  }
               }
            }
         }

         return var8;
      } else {
         int var2 = var1.getAction();
         boolean var3 = false;
         if(var2 == 0) {
            int var4 = var1.getKeyCode();
            var3 = false;
            switch(var4) {
            case 19:
               if(!var1.isAltPressed()) {
                  var3 = this.arrowScroll(33);
               } else {
                  var3 = this.fullScroll(33);
               }
               break;
            case 20:
               if(!var1.isAltPressed()) {
                  var3 = this.arrowScroll(130);
               } else {
                  var3 = this.fullScroll(130);
               }
               break;
            case 62:
               short var5;
               if(var1.isShiftPressed()) {
                  var5 = 33;
               } else {
                  var5 = 130;
               }

               this.pageScroll(var5);
               var3 = false;
            }
         }

         return var3;
      }
   }

   public void fling(int var1) {
      if(this.getChildCount() > 0) {
         int var2 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
         int var3 = this.getChildAt(0).getHeight();
         this.mScroller.fling(this.getScrollX(), this.getScrollY(), 0, var1, 0, 0, 0, Math.max(0, var3 - var2), 0, var2 / 2);
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public boolean fullScroll(int var1) {
      boolean var2;
      if(var1 == 130) {
         var2 = true;
      } else {
         var2 = false;
      }

      int var3 = this.getHeight();
      this.mTempRect.top = 0;
      this.mTempRect.bottom = var3;
      if(var2) {
         int var4 = this.getChildCount();
         if(var4 > 0) {
            View var5 = this.getChildAt(var4 - 1);
            this.mTempRect.bottom = var5.getBottom() + this.getPaddingBottom();
            this.mTempRect.top = this.mTempRect.bottom - var3;
         }
      }

      return this.scrollAndFocus(var1, this.mTempRect.top, this.mTempRect.bottom);
   }

   protected float getBottomFadingEdgeStrength() {
      if(this.getChildCount() == 0) {
         return 0.0F;
      } else {
         int var1 = this.getVerticalFadingEdgeLength();
         int var2 = this.getHeight() - this.getPaddingBottom();
         int var3 = this.getChildAt(0).getBottom() - this.getScrollY() - var2;
         return var3 < var1?(float)var3 / (float)var1:1.0F;
      }
   }

   public int getMaxScrollAmount() {
      return (int)(0.5F * (float)this.getHeight());
   }

   public int getNestedScrollAxes() {
      return this.mParentHelper.getNestedScrollAxes();
   }

   protected float getTopFadingEdgeStrength() {
      if(this.getChildCount() == 0) {
         return 0.0F;
      } else {
         int var1 = this.getVerticalFadingEdgeLength();
         int var2 = this.getScrollY();
         return var2 < var1?(float)var2 / (float)var1:1.0F;
      }
   }

   public boolean hasNestedScrollingParent() {
      return this.mChildHelper.hasNestedScrollingParent();
   }

   public boolean isFillViewport() {
      return this.mFillViewport;
   }

   public boolean isNestedScrollingEnabled() {
      return this.mChildHelper.isNestedScrollingEnabled();
   }

   public boolean isSmoothScrollingEnabled() {
      return this.mSmoothScrollingEnabled;
   }

   protected void measureChild(View var1, int var2, int var3) {
      LayoutParams var4 = var1.getLayoutParams();
      var1.measure(getChildMeasureSpec(var2, this.getPaddingLeft() + this.getPaddingRight(), var4.width), MeasureSpec.makeMeasureSpec(0, 0));
   }

   protected void measureChildWithMargins(View var1, int var2, int var3, int var4, int var5) {
      MarginLayoutParams var6 = (MarginLayoutParams)var1.getLayoutParams();
      var1.measure(getChildMeasureSpec(var2, var3 + this.getPaddingLeft() + this.getPaddingRight() + var6.leftMargin + var6.rightMargin, var6.width), MeasureSpec.makeMeasureSpec(var6.topMargin + var6.bottomMargin, 0));
   }

   public void onAttachedToWindow() {
      this.mIsLaidOut = false;
   }

   public boolean onGenericMotionEvent(MotionEvent var1) {
      if((2 & MotionEventCompat.getSource(var1)) != 0) {
         switch(var1.getAction()) {
         case 8:
            if(!this.mIsBeingDragged) {
               float var2 = MotionEventCompat.getAxisValue(var1, 9);
               if(var2 != 0.0F) {
                  int var3 = (int)(var2 * this.getVerticalScrollFactorCompat());
                  int var4 = this.getScrollRange();
                  int var5 = this.getScrollY();
                  int var6 = var5 - var3;
                  if(var6 < 0) {
                     var6 = 0;
                  } else if(var6 > var4) {
                     var6 = var4;
                  }

                  if(var6 != var5) {
                     super.scrollTo(this.getScrollX(), var6);
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      int var2 = var1.getAction();
      if(var2 == 2 && this.mIsBeingDragged) {
         return true;
      } else {
         switch(var2 & 255) {
         case 0:
            int var3 = (int)var1.getY();
            if(!this.inChild((int)var1.getX(), var3)) {
               this.mIsBeingDragged = false;
               this.recycleVelocityTracker();
            } else {
               this.mLastMotionY = var3;
               this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
               this.initOrResetVelocityTracker();
               this.mVelocityTracker.addMovement(var1);
               this.mScroller.computeScrollOffset();
               boolean var5 = this.mScroller.isFinished();
               boolean var6 = false;
               if(!var5) {
                  var6 = true;
               }

               this.mIsBeingDragged = var6;
               this.startNestedScroll(2);
            }
            break;
         case 1:
         case 3:
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            this.recycleVelocityTracker();
            if(this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
               ViewCompat.postInvalidateOnAnimation(this);
            }

            this.stopNestedScroll();
            break;
         case 2:
            int var8 = this.mActivePointerId;
            if(var8 != -1) {
               int var9 = MotionEventCompat.findPointerIndex(var1, var8);
               if(var9 == -1) {
                  Log.e("NestedScrollView", "Invalid pointerId=" + var8 + " in onInterceptTouchEvent");
               } else {
                  int var10 = (int)MotionEventCompat.getY(var1, var9);
                  if(Math.abs(var10 - this.mLastMotionY) > this.mTouchSlop && (2 & this.getNestedScrollAxes()) == 0) {
                     this.mIsBeingDragged = true;
                     this.mLastMotionY = var10;
                     this.initVelocityTrackerIfNotExists();
                     this.mVelocityTracker.addMovement(var1);
                     this.mNestedYOffset = 0;
                     ViewParent var11 = this.getParent();
                     if(var11 != null) {
                        var11.requestDisallowInterceptTouchEvent(true);
                     }
                  }
               }
            }
         case 4:
         case 5:
         default:
            break;
         case 6:
            this.onSecondaryPointerUp(var1);
         }

         return this.mIsBeingDragged;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.mIsLayoutDirty = false;
      if(this.mChildToScrollTo != null && isViewDescendantOf(this.mChildToScrollTo, this)) {
         this.scrollToChild(this.mChildToScrollTo);
      }

      this.mChildToScrollTo = null;
      if(!this.mIsLaidOut) {
         if(this.mSavedState != null) {
            this.scrollTo(this.getScrollX(), this.mSavedState.scrollPosition);
            this.mSavedState = null;
         }

         int var6;
         if(this.getChildCount() > 0) {
            var6 = this.getChildAt(0).getMeasuredHeight();
         } else {
            var6 = 0;
         }

         int var7 = Math.max(0, var6 - (var5 - var3 - this.getPaddingBottom() - this.getPaddingTop()));
         if(this.getScrollY() > var7) {
            this.scrollTo(this.getScrollX(), var7);
         } else if(this.getScrollY() < 0) {
            this.scrollTo(this.getScrollX(), 0);
         }
      }

      this.scrollTo(this.getScrollX(), this.getScrollY());
      this.mIsLaidOut = true;
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(this.mFillViewport && MeasureSpec.getMode(var2) != 0 && this.getChildCount() > 0) {
         View var3 = this.getChildAt(0);
         int var4 = this.getMeasuredHeight();
         if(var3.getMeasuredHeight() < var4) {
            android.widget.FrameLayout.LayoutParams var5 = (android.widget.FrameLayout.LayoutParams)var3.getLayoutParams();
            var3.measure(getChildMeasureSpec(var1, this.getPaddingLeft() + this.getPaddingRight(), var5.width), MeasureSpec.makeMeasureSpec(var4 - this.getPaddingTop() - this.getPaddingBottom(), 1073741824));
            return;
         }
      }

   }

   public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
      if(!var4) {
         this.flingWithNestedDispatch((int)var3);
         return true;
      } else {
         return false;
      }
   }

   public boolean onNestedPreFling(View var1, float var2, float var3) {
      return false;
   }

   public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
   }

   public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
      int var6 = this.getScrollY();
      this.scrollBy(0, var5);
      int var7 = this.getScrollY() - var6;
      this.dispatchNestedScroll(0, var7, 0, var5 - var7, (int[])null);
   }

   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.mParentHelper.onNestedScrollAccepted(var1, var2, var3);
      this.startNestedScroll(2);
   }

   protected void onOverScrolled(int var1, int var2, boolean var3, boolean var4) {
      super.scrollTo(var1, var2);
   }

   protected boolean onRequestFocusInDescendants(int var1, Rect var2) {
      if(var1 == 2) {
         var1 = 130;
      } else if(var1 == 1) {
         var1 = 33;
      }

      View var3;
      if(var2 == null) {
         var3 = FocusFinder.getInstance().findNextFocus(this, (View)null, var1);
      } else {
         var3 = FocusFinder.getInstance().findNextFocusFromRect(this, var2, var1);
      }

      return var3 != null && !this.isOffScreen(var3)?var3.requestFocus(var1, var2):false;
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      NestedScrollView.SavedState var2 = (NestedScrollView.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      this.mSavedState = var2;
      this.requestLayout();
   }

   protected Parcelable onSaveInstanceState() {
      NestedScrollView.SavedState var1 = new NestedScrollView.SavedState(super.onSaveInstanceState());
      var1.scrollPosition = this.getScrollY();
      return var1;
   }

   protected void onScrollChanged(int var1, int var2, int var3, int var4) {
      super.onScrollChanged(var1, var2, var3, var4);
      if(this.mOnScrollChangeListener != null) {
         this.mOnScrollChangeListener.onScrollChange(this, var1, var2, var3, var4);
      }

   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      View var5 = this.findFocus();
      if(var5 != null && this != var5 && this.isWithinDeltaOfScreen(var5, 0, var4)) {
         var5.getDrawingRect(this.mTempRect);
         this.offsetDescendantRectToMyCoords(var5, this.mTempRect);
         this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
      }
   }

   public boolean onStartNestedScroll(View var1, View var2, int var3) {
      return (var3 & 2) != 0;
   }

   public void onStopNestedScroll(View var1) {
      this.mParentHelper.onStopNestedScroll(var1);
      this.stopNestedScroll();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.initVelocityTrackerIfNotExists();
      MotionEvent var2 = MotionEvent.obtain(var1);
      int var3 = MotionEventCompat.getActionMasked(var1);
      if(var3 == 0) {
         this.mNestedYOffset = 0;
      }

      var2.offsetLocation(0.0F, (float)this.mNestedYOffset);
      switch(var3) {
      case 0:
         if(this.getChildCount() == 0) {
            return false;
         }

         boolean var22;
         if(!this.mScroller.isFinished()) {
            var22 = true;
         } else {
            var22 = false;
         }

         this.mIsBeingDragged = var22;
         if(var22) {
            ViewParent var24 = this.getParent();
            if(var24 != null) {
               var24.requestDisallowInterceptTouchEvent(true);
            }
         }

         if(!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
         }

         this.mLastMotionY = (int)var1.getY();
         this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
         this.startNestedScroll(2);
         break;
      case 1:
         if(this.mIsBeingDragged) {
            VelocityTracker var5 = this.mVelocityTracker;
            var5.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
            int var6 = (int)VelocityTrackerCompat.getYVelocity(var5, this.mActivePointerId);
            if(Math.abs(var6) > this.mMinimumVelocity) {
               this.flingWithNestedDispatch(-var6);
            } else if(this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
               ViewCompat.postInvalidateOnAnimation(this);
            }
         }

         this.mActivePointerId = -1;
         this.endDrag();
         break;
      case 2:
         int var7 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
         if(var7 == -1) {
            Log.e("NestedScrollView", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
         } else {
            int var8 = (int)MotionEventCompat.getY(var1, var7);
            int var9 = this.mLastMotionY - var8;
            if(this.dispatchNestedPreScroll(0, var9, this.mScrollConsumed, this.mScrollOffset)) {
               var9 -= this.mScrollConsumed[1];
               var2.offsetLocation(0.0F, (float)this.mScrollOffset[1]);
               this.mNestedYOffset += this.mScrollOffset[1];
            }

            if(!this.mIsBeingDragged && Math.abs(var9) > this.mTouchSlop) {
               ViewParent var20 = this.getParent();
               if(var20 != null) {
                  var20.requestDisallowInterceptTouchEvent(true);
               }

               this.mIsBeingDragged = true;
               if(var9 > 0) {
                  var9 -= this.mTouchSlop;
               } else {
                  var9 += this.mTouchSlop;
               }
            }

            if(this.mIsBeingDragged) {
               this.mLastMotionY = var8 - this.mScrollOffset[1];
               int var10 = this.getScrollY();
               int var11 = this.getScrollRange();
               int var12 = ViewCompat.getOverScrollMode(this);
               boolean var13;
               if(var12 != 0 && (var12 != 1 || var11 <= 0)) {
                  var13 = false;
               } else {
                  var13 = true;
               }

               if(this.overScrollByCompat(0, var9, 0, this.getScrollY(), 0, var11, 0, 0, true) && !this.hasNestedScrollingParent()) {
                  this.mVelocityTracker.clear();
               }

               int var14 = this.getScrollY() - var10;
               if(this.dispatchNestedScroll(0, var14, 0, var9 - var14, this.mScrollOffset)) {
                  this.mLastMotionY -= this.mScrollOffset[1];
                  var2.offsetLocation(0.0F, (float)this.mScrollOffset[1]);
                  this.mNestedYOffset += this.mScrollOffset[1];
               } else if(var13) {
                  this.ensureGlows();
                  int var15 = var10 + var9;
                  if(var15 < 0) {
                     this.mEdgeGlowTop.onPull((float)var9 / (float)this.getHeight(), MotionEventCompat.getX(var1, var7) / (float)this.getWidth());
                     if(!this.mEdgeGlowBottom.isFinished()) {
                        this.mEdgeGlowBottom.onRelease();
                     }
                  } else if(var15 > var11) {
                     this.mEdgeGlowBottom.onPull((float)var9 / (float)this.getHeight(), 1.0F - MotionEventCompat.getX(var1, var7) / (float)this.getWidth());
                     if(!this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onRelease();
                     }
                  }

                  if(this.mEdgeGlowTop != null && (!this.mEdgeGlowTop.isFinished() || !this.mEdgeGlowBottom.isFinished())) {
                     ViewCompat.postInvalidateOnAnimation(this);
                  }
               }
            }
         }
         break;
      case 3:
         if(this.mIsBeingDragged && this.getChildCount() > 0 && this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
            ViewCompat.postInvalidateOnAnimation(this);
         }

         this.mActivePointerId = -1;
         this.endDrag();
      case 4:
      default:
         break;
      case 5:
         int var4 = MotionEventCompat.getActionIndex(var1);
         this.mLastMotionY = (int)MotionEventCompat.getY(var1, var4);
         this.mActivePointerId = MotionEventCompat.getPointerId(var1, var4);
         break;
      case 6:
         this.onSecondaryPointerUp(var1);
         this.mLastMotionY = (int)MotionEventCompat.getY(var1, MotionEventCompat.findPointerIndex(var1, this.mActivePointerId));
      }

      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.addMovement(var2);
      }

      var2.recycle();
      return true;
   }

   boolean overScrollByCompat(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
      int var10 = ViewCompat.getOverScrollMode(this);
      boolean var11;
      if(this.computeHorizontalScrollRange() > this.computeHorizontalScrollExtent()) {
         var11 = true;
      } else {
         var11 = false;
      }

      boolean var12;
      if(this.computeVerticalScrollRange() > this.computeVerticalScrollExtent()) {
         var12 = true;
      } else {
         var12 = false;
      }

      boolean var13;
      if(var10 != 0 && (var10 != 1 || !var11)) {
         var13 = false;
      } else {
         var13 = true;
      }

      boolean var14;
      if(var10 != 0 && (var10 != 1 || !var12)) {
         var14 = false;
      } else {
         var14 = true;
      }

      int var15 = var3 + var1;
      if(!var13) {
         var7 = 0;
      }

      int var16 = var4 + var2;
      if(!var14) {
         var8 = 0;
      }

      int var17 = -var7;
      int var18 = var7 + var5;
      int var19 = -var8;
      int var20 = var8 + var6;
      boolean var21;
      if(var15 > var18) {
         var15 = var18;
         var21 = true;
      } else {
         var21 = false;
         if(var15 < var17) {
            var15 = var17;
            var21 = true;
         }
      }

      boolean var22;
      if(var16 > var20) {
         var16 = var20;
         var22 = true;
      } else {
         var22 = false;
         if(var16 < var19) {
            var16 = var19;
            var22 = true;
         }
      }

      if(var22) {
         this.mScroller.springBack(var15, var16, 0, 0, 0, this.getScrollRange());
      }

      this.onOverScrolled(var15, var16, var21, var22);
      return var21 || var22;
   }

   public boolean pageScroll(int var1) {
      boolean var2;
      if(var1 == 130) {
         var2 = true;
      } else {
         var2 = false;
      }

      int var3 = this.getHeight();
      if(var2) {
         this.mTempRect.top = var3 + this.getScrollY();
         int var4 = this.getChildCount();
         if(var4 > 0) {
            View var5 = this.getChildAt(var4 - 1);
            if(var3 + this.mTempRect.top > var5.getBottom()) {
               this.mTempRect.top = var5.getBottom() - var3;
            }
         }
      } else {
         this.mTempRect.top = this.getScrollY() - var3;
         if(this.mTempRect.top < 0) {
            this.mTempRect.top = 0;
         }
      }

      this.mTempRect.bottom = var3 + this.mTempRect.top;
      return this.scrollAndFocus(var1, this.mTempRect.top, this.mTempRect.bottom);
   }

   public void requestChildFocus(View var1, View var2) {
      if(!this.mIsLayoutDirty) {
         this.scrollToChild(var2);
      } else {
         this.mChildToScrollTo = var2;
      }

      super.requestChildFocus(var1, var2);
   }

   public boolean requestChildRectangleOnScreen(View var1, Rect var2, boolean var3) {
      var2.offset(var1.getLeft() - var1.getScrollX(), var1.getTop() - var1.getScrollY());
      return this.scrollToChildRect(var2, var3);
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      if(var1) {
         this.recycleVelocityTracker();
      }

      super.requestDisallowInterceptTouchEvent(var1);
   }

   public void requestLayout() {
      this.mIsLayoutDirty = true;
      super.requestLayout();
   }

   public void scrollTo(int var1, int var2) {
      if(this.getChildCount() > 0) {
         View var3 = this.getChildAt(0);
         int var4 = clamp(var1, this.getWidth() - this.getPaddingRight() - this.getPaddingLeft(), var3.getWidth());
         int var5 = clamp(var2, this.getHeight() - this.getPaddingBottom() - this.getPaddingTop(), var3.getHeight());
         if(var4 != this.getScrollX() || var5 != this.getScrollY()) {
            super.scrollTo(var4, var5);
         }
      }

   }

   public void setFillViewport(boolean var1) {
      if(var1 != this.mFillViewport) {
         this.mFillViewport = var1;
         this.requestLayout();
      }

   }

   public void setNestedScrollingEnabled(boolean var1) {
      this.mChildHelper.setNestedScrollingEnabled(var1);
   }

   public void setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener var1) {
      this.mOnScrollChangeListener = var1;
   }

   public void setSmoothScrollingEnabled(boolean var1) {
      this.mSmoothScrollingEnabled = var1;
   }

   public boolean shouldDelayChildPressedState() {
      return true;
   }

   public final void smoothScrollBy(int var1, int var2) {
      if(this.getChildCount() != 0) {
         if(AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250L) {
            int var3 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
            int var4 = Math.max(0, this.getChildAt(0).getHeight() - var3);
            int var5 = this.getScrollY();
            int var6 = Math.max(0, Math.min(var5 + var2, var4)) - var5;
            this.mScroller.startScroll(this.getScrollX(), var5, 0, var6);
            ViewCompat.postInvalidateOnAnimation(this);
         } else {
            if(!this.mScroller.isFinished()) {
               this.mScroller.abortAnimation();
            }

            this.scrollBy(var1, var2);
         }

         this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
      }
   }

   public final void smoothScrollTo(int var1, int var2) {
      this.smoothScrollBy(var1 - this.getScrollX(), var2 - this.getScrollY());
   }

   public boolean startNestedScroll(int var1) {
      return this.mChildHelper.startNestedScroll(var1);
   }

   public void stopNestedScroll() {
      this.mChildHelper.stopNestedScroll();
   }

   static class AccessibilityDelegate extends AccessibilityDelegateCompat {
      public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
         super.onInitializeAccessibilityEvent(var1, var2);
         NestedScrollView var3 = (NestedScrollView)var1;
         var2.setClassName(ScrollView.class.getName());
         AccessibilityRecordCompat var4 = AccessibilityEventCompat.asRecord(var2);
         boolean var5;
         if(var3.getScrollRange() > 0) {
            var5 = true;
         } else {
            var5 = false;
         }

         var4.setScrollable(var5);
         var4.setScrollX(var3.getScrollX());
         var4.setScrollY(var3.getScrollY());
         var4.setMaxScrollX(var3.getScrollX());
         var4.setMaxScrollY(var3.getScrollRange());
      }

      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         super.onInitializeAccessibilityNodeInfo(var1, var2);
         NestedScrollView var3 = (NestedScrollView)var1;
         var2.setClassName(ScrollView.class.getName());
         if(var3.isEnabled()) {
            int var4 = var3.getScrollRange();
            if(var4 > 0) {
               var2.setScrollable(true);
               if(var3.getScrollY() > 0) {
                  var2.addAction(8192);
               }

               if(var3.getScrollY() < var4) {
                  var2.addAction(4096);
               }
            }
         }

      }

      public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
         if(super.performAccessibilityAction(var1, var2, var3)) {
            return true;
         } else {
            NestedScrollView var4 = (NestedScrollView)var1;
            if(!var4.isEnabled()) {
               return false;
            } else {
               switch(var2) {
               case 4096:
                  int var7 = Math.min(var4.getHeight() - var4.getPaddingBottom() - var4.getPaddingTop() + var4.getScrollY(), var4.getScrollRange());
                  if(var7 != var4.getScrollY()) {
                     var4.smoothScrollTo(0, var7);
                     return true;
                  }

                  return false;
               case 8192:
                  int var5 = var4.getHeight() - var4.getPaddingBottom() - var4.getPaddingTop();
                  int var6 = Math.max(var4.getScrollY() - var5, 0);
                  if(var6 != var4.getScrollY()) {
                     var4.smoothScrollTo(0, var6);
                     return true;
                  }

                  return false;
               default:
                  return false;
               }
            }
         }
      }
   }

   public interface OnScrollChangeListener {
      void onScrollChange(NestedScrollView var1, int var2, int var3, int var4, int var5);
   }

   static class SavedState extends BaseSavedState {
      public static final Creator<NestedScrollView.SavedState> CREATOR = new Creator() {
         public NestedScrollView.SavedState createFromParcel(Parcel var1) {
            return new NestedScrollView.SavedState(var1);
         }

         public NestedScrollView.SavedState[] newArray(int var1) {
            return new NestedScrollView.SavedState[var1];
         }
      };
      public int scrollPosition;

      public SavedState(Parcel var1) {
         super(var1);
         this.scrollPosition = var1.readInt();
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public String toString() {
         return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.scrollPosition);
      }
   }
}
