package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.class_5;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.HeaderBehavior;
import android.support.design.widget.HeaderScrollingViewBehavior;
import android.support.design.widget.MathUtils;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ViewUtils;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.DefaultBehavior("Landroid/support/design/widget/AppBarLayout$Behavior;")
public class AppBarLayout extends LinearLayout {
   private static final int INVALID_SCROLL_RANGE = -1;
   private static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
   private static final int PENDING_ACTION_COLLAPSED = 2;
   private static final int PENDING_ACTION_EXPANDED = 1;
   private static final int PENDING_ACTION_NONE;
   private int mDownPreScrollRange;
   private int mDownScrollRange;
   boolean mHaveChildWithInterpolator;
   private WindowInsetsCompat mLastInsets;
   private final List<AppBarLayout.OnOffsetChangedListener> mListeners;
   private int mPendingAction;
   private float mTargetElevation;
   private int mTotalScrollRange;

   public AppBarLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppBarLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mTotalScrollRange = -1;
      this.mDownPreScrollRange = -1;
      this.mDownScrollRange = -1;
      this.mPendingAction = 0;
      this.setOrientation(1);
      ThemeUtils.checkAppCompatTheme(var1);
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_5.styleable.AppBarLayout, 0, class_5.style.Widget_Design_AppBarLayout);
      this.mTargetElevation = (float)var3.getDimensionPixelSize(class_5.styleable.AppBarLayout_elevation, 0);
      this.setBackgroundDrawable(var3.getDrawable(class_5.styleable.AppBarLayout_android_background));
      if(var3.hasValue(class_5.styleable.AppBarLayout_expanded)) {
         this.setExpanded(var3.getBoolean(class_5.styleable.AppBarLayout_expanded, false));
      }

      var3.recycle();
      ViewUtils.setBoundsViewOutlineProvider(this);
      this.mListeners = new ArrayList();
      ViewCompat.setElevation(this, this.mTargetElevation);
      ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
         public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
            return AppBarLayout.this.setWindowInsets(var2);
         }
      });
   }

   private int getDownNestedPreScrollRange() {
      if(this.mDownPreScrollRange != -1) {
         return this.mDownPreScrollRange;
      } else {
         int var1 = 0;

         for(int var2 = -1 + this.getChildCount(); var2 >= 0; --var2) {
            View var4 = this.getChildAt(var2);
            AppBarLayout.LayoutParams var5 = (AppBarLayout.LayoutParams)var4.getLayoutParams();
            int var6 = var4.getMeasuredHeight();
            int var7 = var5.mScrollFlags;
            if((var7 & 5) == 5) {
               int var8 = var1 + var5.topMargin + var5.bottomMargin;
               if((var7 & 8) != 0) {
                  var1 = var8 + ViewCompat.getMinimumHeight(var4);
               } else if((var7 & 2) != 0) {
                  var1 = var8 + (var6 - ViewCompat.getMinimumHeight(var4));
               } else {
                  var1 = var8 + var6;
               }
            } else if(var1 > 0) {
               break;
            }
         }

         int var3 = Math.max(0, var1 - this.getTopInset());
         this.mDownPreScrollRange = var3;
         return var3;
      }
   }

   private int getDownNestedScrollRange() {
      if(this.mDownScrollRange != -1) {
         return this.mDownScrollRange;
      } else {
         int var1 = 0;
         int var2 = 0;

         for(int var3 = this.getChildCount(); var2 < var3; ++var2) {
            View var5 = this.getChildAt(var2);
            AppBarLayout.LayoutParams var6 = (AppBarLayout.LayoutParams)var5.getLayoutParams();
            int var7 = var5.getMeasuredHeight() + var6.topMargin + var6.bottomMargin;
            int var8 = var6.mScrollFlags;
            if((var8 & 1) == 0) {
               break;
            }

            var1 += var7;
            if((var8 & 2) != 0) {
               var1 -= ViewCompat.getMinimumHeight(var5) + this.getTopInset();
               break;
            }
         }

         int var4 = Math.max(0, var1);
         this.mDownScrollRange = var4;
         return var4;
      }
   }

   private int getPendingAction() {
      return this.mPendingAction;
   }

   private int getTopInset() {
      return this.mLastInsets != null?this.mLastInsets.getSystemWindowInsetTop():0;
   }

   private int getUpNestedPreScrollRange() {
      return this.getTotalScrollRange();
   }

   private boolean hasChildWithInterpolator() {
      return this.mHaveChildWithInterpolator;
   }

   private boolean hasScrollableChildren() {
      return this.getTotalScrollRange() != 0;
   }

   private void invalidateScrollRanges() {
      this.mTotalScrollRange = -1;
      this.mDownPreScrollRange = -1;
      this.mDownScrollRange = -1;
   }

   private void resetPendingAction() {
      this.mPendingAction = 0;
   }

   private WindowInsetsCompat setWindowInsets(WindowInsetsCompat var1) {
      this.mTotalScrollRange = -1;
      this.mLastInsets = var1;
      return var1;
   }

   public void addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener var1) {
      if(var1 != null && !this.mListeners.contains(var1)) {
         this.mListeners.add(var1);
      }

   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof AppBarLayout.LayoutParams;
   }

   protected AppBarLayout.LayoutParams generateDefaultLayoutParams() {
      return new AppBarLayout.LayoutParams(-1, -2);
   }

   public AppBarLayout.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new AppBarLayout.LayoutParams(this.getContext(), var1);
   }

   protected AppBarLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof android.widget.LinearLayout.LayoutParams?new AppBarLayout.LayoutParams((android.widget.LinearLayout.LayoutParams)var1):(var1 instanceof MarginLayoutParams?new AppBarLayout.LayoutParams((MarginLayoutParams)var1):new AppBarLayout.LayoutParams(var1));
   }

   final int getMinimumHeightForVisibleOverlappingContent() {
      int var1 = this.getTopInset();
      int var2 = ViewCompat.getMinimumHeight(this);
      if(var2 != 0) {
         return var1 + var2 * 2;
      } else {
         int var3 = this.getChildCount();
         return var3 >= 1?var1 + 2 * ViewCompat.getMinimumHeight(this.getChildAt(var3 - 1)):0;
      }
   }

   public float getTargetElevation() {
      return this.mTargetElevation;
   }

   public final int getTotalScrollRange() {
      if(this.mTotalScrollRange != -1) {
         return this.mTotalScrollRange;
      } else {
         int var1 = 0;
         int var2 = 0;

         for(int var3 = this.getChildCount(); var2 < var3; ++var2) {
            View var5 = this.getChildAt(var2);
            AppBarLayout.LayoutParams var6 = (AppBarLayout.LayoutParams)var5.getLayoutParams();
            int var7 = var5.getMeasuredHeight();
            int var8 = var6.mScrollFlags;
            if((var8 & 1) == 0) {
               break;
            }

            var1 += var7 + var6.topMargin + var6.bottomMargin;
            if((var8 & 2) != 0) {
               var1 -= ViewCompat.getMinimumHeight(var5);
               break;
            }
         }

         int var4 = Math.max(0, var1 - this.getTopInset());
         this.mTotalScrollRange = var4;
         return var4;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.invalidateScrollRanges();
      this.mHaveChildWithInterpolator = false;
      int var6 = 0;

      for(int var7 = this.getChildCount(); var6 < var7; ++var6) {
         if(((AppBarLayout.LayoutParams)this.getChildAt(var6).getLayoutParams()).getScrollInterpolator() != null) {
            this.mHaveChildWithInterpolator = true;
            break;
         }
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      this.invalidateScrollRanges();
   }

   public void removeOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener var1) {
      if(var1 != null) {
         this.mListeners.remove(var1);
      }

   }

   public void setExpanded(boolean var1) {
      this.setExpanded(var1, ViewCompat.isLaidOut(this));
   }

   public void setExpanded(boolean var1, boolean var2) {
      byte var3;
      if(var1) {
         var3 = 1;
      } else {
         var3 = 2;
      }

      byte var4;
      if(var2) {
         var4 = 4;
      } else {
         var4 = 0;
      }

      this.mPendingAction = var4 | var3;
      this.requestLayout();
   }

   public void setOrientation(int var1) {
      if(var1 != 1) {
         throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
      } else {
         super.setOrientation(var1);
      }
   }

   public void setTargetElevation(float var1) {
      this.mTargetElevation = var1;
   }

   public static class Behavior extends HeaderBehavior<AppBarLayout> {
      private static final int ANIMATE_OFFSET_DIPS_PER_SECOND = 300;
      private static final int INVALID_POSITION = -1;
      private ValueAnimatorCompat mAnimator;
      private WeakReference<View> mLastNestedScrollingChildRef;
      private int mOffsetDelta;
      private int mOffsetToChildIndexOnLayout = -1;
      private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
      private float mOffsetToChildIndexOnLayoutPerc;
      private AppBarLayout.DragCallback mOnDragCallback;
      private boolean mSkipNestedPreScroll;
      private boolean mWasNestedFlung;

      public Behavior() {
      }

      public Behavior(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      private void animateOffsetTo(final CoordinatorLayout var1, final AppBarLayout var2, int var3) {
         int var4 = this.getTopBottomOffsetForScrollingSibling();
         if(var4 == var3) {
            if(this.mAnimator != null && this.mAnimator.isRunning()) {
               this.mAnimator.cancel();
            }

         } else {
            if(this.mAnimator == null) {
               this.mAnimator = ViewUtils.createAnimator();
               this.mAnimator.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
               this.mAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener() {
                  public void onAnimationUpdate(ValueAnimatorCompat var1x) {
                     Behavior.this.setHeaderTopBottomOffset(var1, var2, var1x.getAnimatedIntValue());
                  }
               });
            } else {
               this.mAnimator.cancel();
            }

            float var5 = (float)Math.abs(var4 - var3) / var1.getResources().getDisplayMetrics().density;
            this.mAnimator.setDuration(Math.round(1000.0F * var5 / 300.0F));
            this.mAnimator.setIntValues(var4, var3);
            this.mAnimator.start();
         }
      }

      private void dispatchOffsetUpdates(AppBarLayout var1) {
         List var2 = var1.mListeners;
         int var3 = 0;

         for(int var4 = var2.size(); var3 < var4; ++var3) {
            AppBarLayout.OnOffsetChangedListener var5 = (AppBarLayout.OnOffsetChangedListener)var2.get(var3);
            if(var5 != null) {
               var5.onOffsetChanged(var1, this.getTopAndBottomOffset());
            }
         }

      }

      private View getChildOnOffset(AppBarLayout var1, int var2) {
         int var3 = 0;

         for(int var4 = var1.getChildCount(); var3 < var4; ++var3) {
            View var5 = var1.getChildAt(var3);
            if(var5.getTop() <= -var2 && var5.getBottom() >= -var2) {
               return var5;
            }
         }

         return null;
      }

      private int interpolateOffset(AppBarLayout var1, int var2) {
         int var3 = Math.abs(var2);
         int var4 = 0;

         for(int var5 = var1.getChildCount(); var4 < var5; ++var4) {
            View var6 = var1.getChildAt(var4);
            AppBarLayout.LayoutParams var7 = (AppBarLayout.LayoutParams)var6.getLayoutParams();
            Interpolator var8 = var7.getScrollInterpolator();
            if(var3 >= var6.getTop() && var3 <= var6.getBottom()) {
               if(var8 != null) {
                  int var9 = var7.getScrollFlags();
                  int var10 = var9 & 1;
                  int var11 = 0;
                  if(var10 != 0) {
                     var11 = 0 + var6.getHeight() + var7.topMargin + var7.bottomMargin;
                     if((var9 & 2) != 0) {
                        var11 -= ViewCompat.getMinimumHeight(var6);
                     }
                  }

                  if(ViewCompat.getFitsSystemWindows(var6)) {
                     var11 -= var1.getTopInset();
                  }

                  if(var11 > 0) {
                     int var12 = var3 - var6.getTop();
                     int var13 = Math.round((float)var11 * var8.getInterpolation((float)var12 / (float)var11));
                     var2 = Integer.signum(var2) * (var13 + var6.getTop());
                  }
               }
               break;
            }
         }

         return var2;
      }

      private void snapToChildIfNeeded(CoordinatorLayout var1, AppBarLayout var2) {
         int var3 = this.getTopBottomOffsetForScrollingSibling();
         View var4 = this.getChildOnOffset(var2, var3);
         if(var4 != null) {
            AppBarLayout.LayoutParams var5 = (AppBarLayout.LayoutParams)var4.getLayoutParams();
            if((17 & var5.getScrollFlags()) == 17) {
               int var6 = -var4.getTop();
               int var7 = -var4.getBottom();
               if((2 & var5.getScrollFlags()) == 2) {
                  var7 += ViewCompat.getMinimumHeight(var4);
               }

               int var8;
               if(var3 < (var7 + var6) / 2) {
                  var8 = var7;
               } else {
                  var8 = var6;
               }

               this.animateOffsetTo(var1, var2, MathUtils.constrain(var8, -var2.getTotalScrollRange(), 0));
            }
         }

      }

      boolean canDragView(AppBarLayout var1) {
         boolean var2 = true;
         if(this.mOnDragCallback != null) {
            var2 = this.mOnDragCallback.canDrag(var1);
         } else if(this.mLastNestedScrollingChildRef != null) {
            View var3 = (View)this.mLastNestedScrollingChildRef.get();
            if(var3 == null || !var3.isShown() || ViewCompat.canScrollVertically(var3, -1)) {
               return false;
            }
         }

         return var2;
      }

      int getMaxDragOffset(AppBarLayout var1) {
         return -var1.getDownNestedScrollRange();
      }

      int getScrollRangeForDragFling(AppBarLayout var1) {
         return var1.getTotalScrollRange();
      }

      int getTopBottomOffsetForScrollingSibling() {
         return this.getTopAndBottomOffset() + this.mOffsetDelta;
      }

      void onFlingFinished(CoordinatorLayout var1, AppBarLayout var2) {
         this.snapToChildIfNeeded(var1, var2);
      }

      public boolean onLayoutChild(CoordinatorLayout var1, AppBarLayout var2, int var3) {
         boolean var4 = super.onLayoutChild(var1, var2, var3);
         int var5 = var2.getPendingAction();
         if(var5 != 0) {
            boolean var11;
            if((var5 & 4) != 0) {
               var11 = true;
            } else {
               var11 = false;
            }

            if((var5 & 2) != 0) {
               int var13 = -var2.getUpNestedPreScrollRange();
               if(var11) {
                  this.animateOffsetTo(var1, var2, var13);
               } else {
                  this.setHeaderTopBottomOffset(var1, var2, var13);
               }
            } else if((var5 & 1) != 0) {
               if(var11) {
                  this.animateOffsetTo(var1, var2, 0);
               } else {
                  this.setHeaderTopBottomOffset(var1, var2, 0);
               }
            }
         } else if(this.mOffsetToChildIndexOnLayout >= 0) {
            View var6 = var2.getChildAt(this.mOffsetToChildIndexOnLayout);
            int var7 = -var6.getBottom();
            int var8;
            if(this.mOffsetToChildIndexOnLayoutIsMinHeight) {
               var8 = var7 + ViewCompat.getMinimumHeight(var6);
            } else {
               var8 = var7 + Math.round((float)var6.getHeight() * this.mOffsetToChildIndexOnLayoutPerc);
            }

            this.setTopAndBottomOffset(var8);
         }

         var2.resetPendingAction();
         this.mOffsetToChildIndexOnLayout = -1;
         this.setTopAndBottomOffset(MathUtils.constrain(this.getTopAndBottomOffset(), -var2.getTotalScrollRange(), 0));
         this.dispatchOffsetUpdates(var2);
         return var4;
      }

      public boolean onNestedFling(CoordinatorLayout var1, AppBarLayout var2, View var3, float var4, float var5, boolean var6) {
         boolean var9;
         if(!var6) {
            var9 = this.fling(var1, var2, -var2.getTotalScrollRange(), 0, -var5);
         } else if(var5 < 0.0F) {
            int var10 = -var2.getTotalScrollRange() + var2.getDownNestedPreScrollRange();
            int var11 = this.getTopBottomOffsetForScrollingSibling();
            var9 = false;
            if(var11 < var10) {
               this.animateOffsetTo(var1, var2, var10);
               var9 = true;
            }
         } else {
            int var7 = -var2.getUpNestedPreScrollRange();
            int var8 = this.getTopBottomOffsetForScrollingSibling();
            var9 = false;
            if(var8 > var7) {
               this.animateOffsetTo(var1, var2, var7);
               var9 = true;
            }
         }

         this.mWasNestedFlung = var9;
         return var9;
      }

      public void onNestedPreScroll(CoordinatorLayout var1, AppBarLayout var2, View var3, int var4, int var5, int[] var6) {
         if(var5 != 0 && !this.mSkipNestedPreScroll) {
            int var7;
            int var8;
            if(var5 < 0) {
               var7 = -var2.getTotalScrollRange();
               var8 = var7 + var2.getDownNestedPreScrollRange();
            } else {
               var7 = -var2.getUpNestedPreScrollRange();
               var8 = 0;
            }

            var6[1] = this.scroll(var1, var2, var5, var7, var8);
         }

      }

      public void onNestedScroll(CoordinatorLayout var1, AppBarLayout var2, View var3, int var4, int var5, int var6, int var7) {
         if(var7 < 0) {
            this.scroll(var1, var2, var7, -var2.getDownNestedScrollRange(), 0);
            this.mSkipNestedPreScroll = true;
         } else {
            this.mSkipNestedPreScroll = false;
         }
      }

      public void onRestoreInstanceState(CoordinatorLayout var1, AppBarLayout var2, Parcelable var3) {
         if(var3 instanceof AppBarLayout.SavedState) {
            AppBarLayout.SavedState var4 = (AppBarLayout.SavedState)var3;
            super.onRestoreInstanceState(var1, var2, var4.getSuperState());
            this.mOffsetToChildIndexOnLayout = var4.firstVisibleChildIndex;
            this.mOffsetToChildIndexOnLayoutPerc = var4.firstVisibileChildPercentageShown;
            this.mOffsetToChildIndexOnLayoutIsMinHeight = var4.firstVisibileChildAtMinimumHeight;
         } else {
            super.onRestoreInstanceState(var1, var2, var3);
            this.mOffsetToChildIndexOnLayout = -1;
         }
      }

      public Parcelable onSaveInstanceState(CoordinatorLayout var1, AppBarLayout var2) {
         Parcelable var3 = super.onSaveInstanceState(var1, var2);
         int var4 = this.getTopAndBottomOffset();
         int var5 = 0;

         for(int var6 = var2.getChildCount(); var5 < var6; ++var5) {
            View var7 = var2.getChildAt(var5);
            int var8 = var4 + var7.getBottom();
            if(var4 + var7.getTop() <= 0 && var8 >= 0) {
               AppBarLayout.SavedState var9 = new AppBarLayout.SavedState(var3);
               var9.firstVisibleChildIndex = var5;
               boolean var10;
               if(var8 == ViewCompat.getMinimumHeight(var7)) {
                  var10 = true;
               } else {
                  var10 = false;
               }

               var9.firstVisibileChildAtMinimumHeight = var10;
               var9.firstVisibileChildPercentageShown = (float)var8 / (float)var7.getHeight();
               return var9;
            }
         }

         return var3;
      }

      public boolean onStartNestedScroll(CoordinatorLayout var1, AppBarLayout var2, View var3, View var4, int var5) {
         boolean var6;
         if((var5 & 2) != 0 && var2.hasScrollableChildren() && var1.getHeight() - var3.getHeight() <= var2.getHeight()) {
            var6 = true;
         } else {
            var6 = false;
         }

         if(var6 && this.mAnimator != null) {
            this.mAnimator.cancel();
         }

         this.mLastNestedScrollingChildRef = null;
         return var6;
      }

      public void onStopNestedScroll(CoordinatorLayout var1, AppBarLayout var2, View var3) {
         if(!this.mWasNestedFlung) {
            this.snapToChildIfNeeded(var1, var2);
         }

         this.mSkipNestedPreScroll = false;
         this.mWasNestedFlung = false;
         this.mLastNestedScrollingChildRef = new WeakReference(var3);
      }

      public void setDragCallback(@Nullable AppBarLayout.DragCallback var1) {
         this.mOnDragCallback = var1;
      }

      int setHeaderTopBottomOffset(CoordinatorLayout var1, AppBarLayout var2, int var3, int var4, int var5) {
         int var6 = this.getTopBottomOffsetForScrollingSibling();
         if(var4 != 0 && var6 >= var4 && var6 <= var5) {
            int var7 = MathUtils.constrain(var3, var4, var5);
            int var8 = 0;
            if(var6 != var7) {
               int var9;
               if(var2.hasChildWithInterpolator()) {
                  var9 = this.interpolateOffset(var2, var7);
               } else {
                  var9 = var7;
               }

               boolean var10 = this.setTopAndBottomOffset(var9);
               var8 = var6 - var7;
               this.mOffsetDelta = var7 - var9;
               if(!var10 && var2.hasChildWithInterpolator()) {
                  var1.dispatchDependentViewsChanged(var2);
               }

               this.dispatchOffsetUpdates(var2);
            }

            return var8;
         } else {
            this.mOffsetDelta = 0;
            return 0;
         }
      }
   }

   public abstract static class DragCallback {
      public abstract boolean canDrag(@NonNull AppBarLayout var1);
   }

   protected static class SavedState extends BaseSavedState {
      public static final Creator<AppBarLayout.SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks() {
         public AppBarLayout.SavedState createFromParcel(Parcel var1, ClassLoader var2) {
            return new AppBarLayout.SavedState(var1, var2);
         }

         public AppBarLayout.SavedState[] newArray(int var1) {
            return new AppBarLayout.SavedState[var1];
         }
      });
      boolean firstVisibileChildAtMinimumHeight;
      float firstVisibileChildPercentageShown;
      int firstVisibleChildIndex;

      public SavedState(Parcel var1, ClassLoader var2) {
         super(var1);
         this.firstVisibleChildIndex = var1.readInt();
         this.firstVisibileChildPercentageShown = var1.readFloat();
         boolean var3;
         if(var1.readByte() != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.firstVisibileChildAtMinimumHeight = var3;
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.firstVisibleChildIndex);
         var1.writeFloat(this.firstVisibileChildPercentageShown);
         byte var3;
         if(this.firstVisibileChildAtMinimumHeight) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeByte((byte)var3);
      }
   }

   public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
      static final int FLAG_QUICK_RETURN = 5;
      static final int FLAG_SNAP = 17;
      public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
      public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
      public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
      public static final int SCROLL_FLAG_SCROLL = 1;
      public static final int SCROLL_FLAG_SNAP = 16;
      int mScrollFlags = 1;
      Interpolator mScrollInterpolator;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(int var1, int var2, float var3) {
         super(var1, var2, var3);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, class_5.styleable.AppBarLayout_LayoutParams);
         this.mScrollFlags = var3.getInt(class_5.styleable.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
         if(var3.hasValue(class_5.styleable.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
            this.mScrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(var1, var3.getResourceId(class_5.styleable.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
         }

         var3.recycle();
      }

      public LayoutParams(AppBarLayout.LayoutParams var1) {
         super(var1);
         this.mScrollFlags = var1.mScrollFlags;
         this.mScrollInterpolator = var1.mScrollInterpolator;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }

      public LayoutParams(android.widget.LinearLayout.LayoutParams var1) {
         super(var1);
      }

      public int getScrollFlags() {
         return this.mScrollFlags;
      }

      public Interpolator getScrollInterpolator() {
         return this.mScrollInterpolator;
      }

      public void setScrollFlags(int var1) {
         this.mScrollFlags = var1;
      }

      public void setScrollInterpolator(Interpolator var1) {
         this.mScrollInterpolator = var1;
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface ScrollFlags {
   }

   public interface OnOffsetChangedListener {
      void onOffsetChanged(AppBarLayout var1, int var2);
   }

   public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
      public ScrollingViewBehavior() {
      }

      public ScrollingViewBehavior(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, class_5.styleable.ScrollingViewBehavior_Params);
         this.setOverlayTop(var3.getDimensionPixelSize(class_5.styleable.ScrollingViewBehavior_Params_behavior_overlapTop, 0));
         var3.recycle();
      }

      private static int getAppBarLayoutOffset(AppBarLayout var0) {
         CoordinatorLayout.Behavior var1 = ((CoordinatorLayout.LayoutParams)var0.getLayoutParams()).getBehavior();
         return var1 instanceof AppBarLayout.Behavior?((AppBarLayout.Behavior)var1).getTopBottomOffsetForScrollingSibling():0;
      }

      private void offsetChildAsNeeded(CoordinatorLayout var1, View var2, View var3) {
         CoordinatorLayout.Behavior var4 = ((CoordinatorLayout.LayoutParams)var3.getLayoutParams()).getBehavior();
         if(var4 instanceof AppBarLayout.Behavior) {
            AppBarLayout.Behavior var5 = (AppBarLayout.Behavior)var4;
            var5.getTopBottomOffsetForScrollingSibling();
            var2.offsetTopAndBottom(var3.getBottom() - var2.getTop() + var5.mOffsetDelta + this.getVerticalLayoutGap() - this.getOverlapPixelsForOffset(var3));
         }

      }

      View findFirstDependency(List<View> var1) {
         int var2 = 0;

         for(int var3 = var1.size(); var2 < var3; ++var2) {
            View var4 = (View)var1.get(var2);
            if(var4 instanceof AppBarLayout) {
               return var4;
            }
         }

         return null;
      }

      float getOverlapRatioForOffset(View var1) {
         if(var1 instanceof AppBarLayout) {
            AppBarLayout var2 = (AppBarLayout)var1;
            int var3 = var2.getTotalScrollRange();
            int var4 = var2.getDownNestedPreScrollRange();
            int var5 = getAppBarLayoutOffset(var2);
            if(var4 == 0 || var3 + var5 > var4) {
               int var6 = var3 - var4;
               if(var6 != 0) {
                  return 1.0F + (float)var5 / (float)var6;
               }
            }
         }

         return 0.0F;
      }

      int getScrollRange(View var1) {
         return var1 instanceof AppBarLayout?((AppBarLayout)var1).getTotalScrollRange():super.getScrollRange(var1);
      }

      public boolean layoutDependsOn(CoordinatorLayout var1, View var2, View var3) {
         return var3 instanceof AppBarLayout;
      }

      public boolean onDependentViewChanged(CoordinatorLayout var1, View var2, View var3) {
         this.offsetChildAsNeeded(var1, var2, var3);
         return false;
      }
   }
}
