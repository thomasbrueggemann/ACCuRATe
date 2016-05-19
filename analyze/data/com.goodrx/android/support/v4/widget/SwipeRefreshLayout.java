package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.CircleImageView;
import android.support.v4.widget.MaterialProgressDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
   private static final int ALPHA_ANIMATION_DURATION = 300;
   private static final int ANIMATE_TO_START_DURATION = 200;
   private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
   private static final int CIRCLE_BG_LIGHT = -328966;
   private static final int CIRCLE_DIAMETER = 40;
   private static final int CIRCLE_DIAMETER_LARGE = 56;
   private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0F;
   public static final int DEFAULT = 1;
   private static final int DEFAULT_CIRCLE_TARGET = 64;
   private static final float DRAG_RATE = 0.5F;
   private static final int INVALID_POINTER = -1;
   public static final int LARGE = 0;
   private static final int[] LAYOUT_ATTRS = new int[]{16842766};
   private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
   private static final int MAX_ALPHA = 255;
   private static final float MAX_PROGRESS_ANGLE = 0.8F;
   private static final int SCALE_DOWN_DURATION = 150;
   private static final int STARTING_PROGRESS_ALPHA = 76;
   private int mActivePointerId;
   private Animation mAlphaMaxAnimation;
   private Animation mAlphaStartAnimation;
   private final Animation mAnimateToCorrectPosition;
   private final Animation mAnimateToStartPosition;
   private int mCircleHeight;
   private CircleImageView mCircleView;
   private int mCircleViewIndex;
   private int mCircleWidth;
   private int mCurrentTargetOffsetTop;
   private final DecelerateInterpolator mDecelerateInterpolator;
   protected int mFrom;
   private float mInitialDownY;
   private float mInitialMotionY;
   private boolean mIsBeingDragged;
   private SwipeRefreshLayout.OnRefreshListener mListener;
   private int mMediumAnimationDuration;
   private boolean mNestedScrollInProgress;
   private final NestedScrollingChildHelper mNestedScrollingChildHelper;
   private final NestedScrollingParentHelper mNestedScrollingParentHelper;
   private boolean mNotify;
   private boolean mOriginalOffsetCalculated;
   protected int mOriginalOffsetTop;
   private final int[] mParentOffsetInWindow;
   private final int[] mParentScrollConsumed;
   private MaterialProgressDrawable mProgress;
   private AnimationListener mRefreshListener;
   private boolean mRefreshing;
   private boolean mReturningToStart;
   private boolean mScale;
   private Animation mScaleAnimation;
   private Animation mScaleDownAnimation;
   private Animation mScaleDownToStartAnimation;
   private float mSpinnerFinalOffset;
   private float mStartingScale;
   private View mTarget;
   private float mTotalDragDistance;
   private float mTotalUnconsumed;
   private int mTouchSlop;
   private boolean mUsingCustomStart;

   public SwipeRefreshLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SwipeRefreshLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mRefreshing = false;
      this.mTotalDragDistance = -1.0F;
      this.mParentScrollConsumed = new int[2];
      this.mParentOffsetInWindow = new int[2];
      this.mOriginalOffsetCalculated = false;
      this.mActivePointerId = -1;
      this.mCircleViewIndex = -1;
      this.mRefreshListener = new AnimationListener() {
         public void onAnimationEnd(Animation var1) {
            if(SwipeRefreshLayout.this.mRefreshing) {
               SwipeRefreshLayout.this.mProgress.setAlpha(255);
               SwipeRefreshLayout.this.mProgress.start();
               if(SwipeRefreshLayout.this.mNotify && SwipeRefreshLayout.this.mListener != null) {
                  SwipeRefreshLayout.this.mListener.onRefresh();
               }

               SwipeRefreshLayout.this.mCurrentTargetOffsetTop = SwipeRefreshLayout.this.mCircleView.getTop();
            } else {
               SwipeRefreshLayout.this.reset();
            }
         }

         public void onAnimationRepeat(Animation var1) {
         }

         public void onAnimationStart(Animation var1) {
         }
      };
      this.mAnimateToCorrectPosition = new Animation() {
         public void applyTransformation(float var1, Transformation var2) {
            int var3;
            if(!SwipeRefreshLayout.this.mUsingCustomStart) {
               var3 = (int)(SwipeRefreshLayout.this.mSpinnerFinalOffset - (float)Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop));
            } else {
               var3 = (int)SwipeRefreshLayout.this.mSpinnerFinalOffset;
            }

            int var4 = SwipeRefreshLayout.this.mFrom + (int)(var1 * (float)(var3 - SwipeRefreshLayout.this.mFrom)) - SwipeRefreshLayout.this.mCircleView.getTop();
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(var4, false);
            SwipeRefreshLayout.this.mProgress.setArrowScale(1.0F - var1);
         }
      };
      this.mAnimateToStartPosition = new Animation() {
         public void applyTransformation(float var1, Transformation var2) {
            SwipeRefreshLayout.this.moveToStart(var1);
         }
      };
      this.mTouchSlop = ViewConfiguration.get(var1).getScaledTouchSlop();
      this.mMediumAnimationDuration = this.getResources().getInteger(17694721);
      this.setWillNotDraw(false);
      this.mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
      TypedArray var3 = var1.obtainStyledAttributes(var2, LAYOUT_ATTRS);
      this.setEnabled(var3.getBoolean(0, true));
      var3.recycle();
      DisplayMetrics var4 = this.getResources().getDisplayMetrics();
      this.mCircleWidth = (int)(40.0F * var4.density);
      this.mCircleHeight = (int)(40.0F * var4.density);
      this.createProgressView();
      ViewCompat.setChildrenDrawingOrderEnabled(this, true);
      this.mSpinnerFinalOffset = 64.0F * var4.density;
      this.mTotalDragDistance = this.mSpinnerFinalOffset;
      this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
      this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
      this.setNestedScrollingEnabled(true);
   }

   private void animateOffsetToCorrectPosition(int var1, AnimationListener var2) {
      this.mFrom = var1;
      this.mAnimateToCorrectPosition.reset();
      this.mAnimateToCorrectPosition.setDuration(200L);
      this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
      if(var2 != null) {
         this.mCircleView.setAnimationListener(var2);
      }

      this.mCircleView.clearAnimation();
      this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
   }

   private void animateOffsetToStartPosition(int var1, AnimationListener var2) {
      if(this.mScale) {
         this.startScaleDownReturnToStartAnimation(var1, var2);
      } else {
         this.mFrom = var1;
         this.mAnimateToStartPosition.reset();
         this.mAnimateToStartPosition.setDuration(200L);
         this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
         if(var2 != null) {
            this.mCircleView.setAnimationListener(var2);
         }

         this.mCircleView.clearAnimation();
         this.mCircleView.startAnimation(this.mAnimateToStartPosition);
      }
   }

   private void createProgressView() {
      this.mCircleView = new CircleImageView(this.getContext(), -328966, 20.0F);
      this.mProgress = new MaterialProgressDrawable(this.getContext(), this);
      this.mProgress.setBackgroundColor(-328966);
      this.mCircleView.setImageDrawable(this.mProgress);
      this.mCircleView.setVisibility(8);
      this.addView(this.mCircleView);
   }

   private void ensureTarget() {
      if(this.mTarget == null) {
         for(int var1 = 0; var1 < this.getChildCount(); ++var1) {
            View var2 = this.getChildAt(var1);
            if(!var2.equals(this.mCircleView)) {
               this.mTarget = var2;
               break;
            }
         }
      }

   }

   private void finishSpinner(float var1) {
      if(var1 > this.mTotalDragDistance) {
         this.setRefreshing(true, true);
      } else {
         this.mRefreshing = false;
         this.mProgress.setStartEndTrim(0.0F, 0.0F);
         boolean var2 = this.mScale;
         AnimationListener var3 = null;
         if(!var2) {
            var3 = new AnimationListener() {
               public void onAnimationEnd(Animation var1) {
                  if(!SwipeRefreshLayout.this.mScale) {
                     SwipeRefreshLayout.this.startScaleDownAnimation((AnimationListener)null);
                  }

               }

               public void onAnimationRepeat(Animation var1) {
               }

               public void onAnimationStart(Animation var1) {
               }
            };
         }

         this.animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, var3);
         this.mProgress.showArrow(false);
      }
   }

   private float getMotionEventY(MotionEvent var1, int var2) {
      int var3 = MotionEventCompat.findPointerIndex(var1, var2);
      return var3 < 0?-1.0F:MotionEventCompat.getY(var1, var3);
   }

   private boolean isAlphaUsedForScale() {
      return VERSION.SDK_INT < 11;
   }

   private boolean isAnimationRunning(Animation var1) {
      return var1 != null && var1.hasStarted() && !var1.hasEnded();
   }

   private void moveSpinner(float var1) {
      this.mProgress.showArrow(true);
      float var2 = Math.min(1.0F, Math.abs(var1 / this.mTotalDragDistance));
      float var3 = 5.0F * (float)Math.max((double)var2 - 0.4D, 0.0D) / 3.0F;
      float var4 = Math.abs(var1) - this.mTotalDragDistance;
      float var5;
      if(this.mUsingCustomStart) {
         var5 = this.mSpinnerFinalOffset - (float)this.mOriginalOffsetTop;
      } else {
         var5 = this.mSpinnerFinalOffset;
      }

      float var6 = Math.max(0.0F, Math.min(var4, 2.0F * var5) / var5);
      float var7 = 2.0F * (float)((double)(var6 / 4.0F) - Math.pow((double)(var6 / 4.0F), 2.0D));
      float var8 = 2.0F * var5 * var7;
      int var9 = this.mOriginalOffsetTop + (int)(var8 + var5 * var2);
      if(this.mCircleView.getVisibility() != 0) {
         this.mCircleView.setVisibility(0);
      }

      if(!this.mScale) {
         ViewCompat.setScaleX(this.mCircleView, 1.0F);
         ViewCompat.setScaleY(this.mCircleView, 1.0F);
      }

      if(this.mScale) {
         this.setAnimationProgress(Math.min(1.0F, var1 / this.mTotalDragDistance));
      }

      if(var1 < this.mTotalDragDistance) {
         if(this.mProgress.getAlpha() > 76 && !this.isAnimationRunning(this.mAlphaStartAnimation)) {
            this.startProgressAlphaStartAnimation();
         }
      } else if(this.mProgress.getAlpha() < 255 && !this.isAnimationRunning(this.mAlphaMaxAnimation)) {
         this.startProgressAlphaMaxAnimation();
      }

      float var10 = var3 * 0.8F;
      this.mProgress.setStartEndTrim(0.0F, Math.min(0.8F, var10));
      this.mProgress.setArrowScale(Math.min(1.0F, var3));
      float var11 = 0.5F * (-0.25F + 0.4F * var3 + 2.0F * var7);
      this.mProgress.setProgressRotation(var11);
      this.setTargetOffsetTopAndBottom(var9 - this.mCurrentTargetOffsetTop, true);
   }

   private void moveToStart(float var1) {
      this.setTargetOffsetTopAndBottom(this.mFrom + (int)(var1 * (float)(this.mOriginalOffsetTop - this.mFrom)) - this.mCircleView.getTop(), false);
   }

   private void onSecondaryPointerUp(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionIndex(var1);
      if(MotionEventCompat.getPointerId(var1, var2) == this.mActivePointerId) {
         byte var3;
         if(var2 == 0) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         this.mActivePointerId = MotionEventCompat.getPointerId(var1, var3);
      }

   }

   private void reset() {
      this.mCircleView.clearAnimation();
      this.mProgress.stop();
      this.mCircleView.setVisibility(8);
      this.setColorViewAlpha(255);
      if(this.mScale) {
         this.setAnimationProgress(0.0F);
      } else {
         this.setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop, true);
      }

      this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
   }

   private void setAnimationProgress(float var1) {
      if(this.isAlphaUsedForScale()) {
         this.setColorViewAlpha((int)(255.0F * var1));
      } else {
         ViewCompat.setScaleX(this.mCircleView, var1);
         ViewCompat.setScaleY(this.mCircleView, var1);
      }
   }

   private void setColorViewAlpha(int var1) {
      this.mCircleView.getBackground().setAlpha(var1);
      this.mProgress.setAlpha(var1);
   }

   private void setRefreshing(boolean var1, boolean var2) {
      if(this.mRefreshing != var1) {
         this.mNotify = var2;
         this.ensureTarget();
         this.mRefreshing = var1;
         if(!this.mRefreshing) {
            this.startScaleDownAnimation(this.mRefreshListener);
            return;
         }

         this.animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
      }

   }

   private void setTargetOffsetTopAndBottom(int var1, boolean var2) {
      this.mCircleView.bringToFront();
      this.mCircleView.offsetTopAndBottom(var1);
      this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
      if(var2 && VERSION.SDK_INT < 11) {
         this.invalidate();
      }

   }

   private Animation startAlphaAnimation(final int var1, final int var2) {
      if(this.mScale && this.isAlphaUsedForScale()) {
         return null;
      } else {
         Animation var3 = new Animation() {
            public void applyTransformation(float var1x, Transformation var2x) {
               SwipeRefreshLayout.this.mProgress.setAlpha((int)((float)var1 + var1x * (float)(var2 - var1)));
            }
         };
         var3.setDuration(300L);
         this.mCircleView.setAnimationListener((AnimationListener)null);
         this.mCircleView.clearAnimation();
         this.mCircleView.startAnimation(var3);
         return var3;
      }
   }

   private void startProgressAlphaMaxAnimation() {
      this.mAlphaMaxAnimation = this.startAlphaAnimation(this.mProgress.getAlpha(), 255);
   }

   private void startProgressAlphaStartAnimation() {
      this.mAlphaStartAnimation = this.startAlphaAnimation(this.mProgress.getAlpha(), 76);
   }

   private void startScaleDownAnimation(AnimationListener var1) {
      this.mScaleDownAnimation = new Animation() {
         public void applyTransformation(float var1, Transformation var2) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0F - var1);
         }
      };
      this.mScaleDownAnimation.setDuration(150L);
      this.mCircleView.setAnimationListener(var1);
      this.mCircleView.clearAnimation();
      this.mCircleView.startAnimation(this.mScaleDownAnimation);
   }

   private void startScaleDownReturnToStartAnimation(int var1, AnimationListener var2) {
      this.mFrom = var1;
      if(this.isAlphaUsedForScale()) {
         this.mStartingScale = (float)this.mProgress.getAlpha();
      } else {
         this.mStartingScale = ViewCompat.getScaleX(this.mCircleView);
      }

      this.mScaleDownToStartAnimation = new Animation() {
         public void applyTransformation(float var1, Transformation var2) {
            float var3 = SwipeRefreshLayout.this.mStartingScale + var1 * -SwipeRefreshLayout.this.mStartingScale;
            SwipeRefreshLayout.this.setAnimationProgress(var3);
            SwipeRefreshLayout.this.moveToStart(var1);
         }
      };
      this.mScaleDownToStartAnimation.setDuration(150L);
      if(var2 != null) {
         this.mCircleView.setAnimationListener(var2);
      }

      this.mCircleView.clearAnimation();
      this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
   }

   private void startScaleUpAnimation(AnimationListener var1) {
      this.mCircleView.setVisibility(0);
      if(VERSION.SDK_INT >= 11) {
         this.mProgress.setAlpha(255);
      }

      this.mScaleAnimation = new Animation() {
         public void applyTransformation(float var1, Transformation var2) {
            SwipeRefreshLayout.this.setAnimationProgress(var1);
         }
      };
      this.mScaleAnimation.setDuration((long)this.mMediumAnimationDuration);
      if(var1 != null) {
         this.mCircleView.setAnimationListener(var1);
      }

      this.mCircleView.clearAnimation();
      this.mCircleView.startAnimation(this.mScaleAnimation);
   }

   public boolean canChildScrollUp() {
      if(VERSION.SDK_INT >= 14) {
         return ViewCompat.canScrollVertically(this.mTarget, -1);
      } else if(this.mTarget instanceof AbsListView) {
         AbsListView var3 = (AbsListView)this.mTarget;
         return var3.getChildCount() > 0 && (var3.getFirstVisiblePosition() > 0 || var3.getChildAt(0).getTop() < var3.getPaddingTop());
      } else {
         boolean var1;
         if(!ViewCompat.canScrollVertically(this.mTarget, -1)) {
            int var2 = this.mTarget.getScrollY();
            var1 = false;
            if(var2 <= 0) {
               return var1;
            }
         }

         var1 = true;
         return var1;
      }
   }

   public boolean dispatchNestedFling(float var1, float var2, boolean var3) {
      return this.mNestedScrollingChildHelper.dispatchNestedFling(var1, var2, var3);
   }

   public boolean dispatchNestedPreFling(float var1, float var2) {
      return this.mNestedScrollingChildHelper.dispatchNestedPreFling(var1, var2);
   }

   public boolean dispatchNestedPreScroll(int var1, int var2, int[] var3, int[] var4) {
      return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(var1, var2, var3, var4);
   }

   public boolean dispatchNestedScroll(int var1, int var2, int var3, int var4, int[] var5) {
      return this.mNestedScrollingChildHelper.dispatchNestedScroll(var1, var2, var3, var4, var5);
   }

   protected int getChildDrawingOrder(int var1, int var2) {
      if(this.mCircleViewIndex >= 0) {
         if(var2 == var1 - 1) {
            return this.mCircleViewIndex;
         }

         if(var2 >= this.mCircleViewIndex) {
            return var2 + 1;
         }
      }

      return var2;
   }

   public int getNestedScrollAxes() {
      return this.mNestedScrollingParentHelper.getNestedScrollAxes();
   }

   public int getProgressCircleDiameter() {
      return this.mCircleView != null?this.mCircleView.getMeasuredHeight():0;
   }

   public boolean hasNestedScrollingParent() {
      return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
   }

   public boolean isNestedScrollingEnabled() {
      return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
   }

   public boolean isRefreshing() {
      return this.mRefreshing;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.reset();
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      this.ensureTarget();
      int var2 = MotionEventCompat.getActionMasked(var1);
      if(this.mReturningToStart && var2 == 0) {
         this.mReturningToStart = false;
      }

      if(this.isEnabled() && !this.mReturningToStart && !this.canChildScrollUp() && !this.mRefreshing && !this.mNestedScrollInProgress) {
         switch(var2) {
         case 0:
            this.setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
            this.mIsBeingDragged = false;
            float var5 = this.getMotionEventY(var1, this.mActivePointerId);
            if(var5 == -1.0F) {
               return false;
            }

            this.mInitialDownY = var5;
            break;
         case 1:
         case 3:
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            break;
         case 2:
            if(this.mActivePointerId == -1) {
               Log.e(LOG_TAG, "Got ACTION_MOVE event but don\'t have an active pointer id.");
               return false;
            }

            float var3 = this.getMotionEventY(var1, this.mActivePointerId);
            if(var3 == -1.0F) {
               return false;
            }

            if(var3 - this.mInitialDownY > (float)this.mTouchSlop && !this.mIsBeingDragged) {
               this.mInitialMotionY = this.mInitialDownY + (float)this.mTouchSlop;
               this.mIsBeingDragged = true;
               this.mProgress.setAlpha(76);
            }
         case 4:
         case 5:
         default:
            break;
         case 6:
            this.onSecondaryPointerUp(var1);
         }

         return this.mIsBeingDragged;
      } else {
         return false;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var6 = this.getMeasuredWidth();
      int var7 = this.getMeasuredHeight();
      if(this.getChildCount() != 0) {
         if(this.mTarget == null) {
            this.ensureTarget();
         }

         if(this.mTarget != null) {
            View var8 = this.mTarget;
            int var9 = this.getPaddingLeft();
            int var10 = this.getPaddingTop();
            int var11 = var6 - this.getPaddingLeft() - this.getPaddingRight();
            int var12 = var7 - this.getPaddingTop() - this.getPaddingBottom();
            var8.layout(var9, var10, var9 + var11, var10 + var12);
            int var13 = this.mCircleView.getMeasuredWidth();
            int var14 = this.mCircleView.getMeasuredHeight();
            this.mCircleView.layout(var6 / 2 - var13 / 2, this.mCurrentTargetOffsetTop, var6 / 2 + var13 / 2, var14 + this.mCurrentTargetOffsetTop);
            return;
         }
      }

   }

   public void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(this.mTarget == null) {
         this.ensureTarget();
      }

      if(this.mTarget != null) {
         this.mTarget.measure(MeasureSpec.makeMeasureSpec(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), 1073741824));
         this.mCircleView.measure(MeasureSpec.makeMeasureSpec(this.mCircleWidth, 1073741824), MeasureSpec.makeMeasureSpec(this.mCircleHeight, 1073741824));
         if(!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
            this.mOriginalOffsetCalculated = true;
            int var4 = -this.mCircleView.getMeasuredHeight();
            this.mOriginalOffsetTop = var4;
            this.mCurrentTargetOffsetTop = var4;
         }

         this.mCircleViewIndex = -1;

         for(int var3 = 0; var3 < this.getChildCount(); ++var3) {
            if(this.getChildAt(var3) == this.mCircleView) {
               this.mCircleViewIndex = var3;
               return;
            }
         }
      }

   }

   public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
      return this.dispatchNestedFling(var2, var3, var4);
   }

   public boolean onNestedPreFling(View var1, float var2, float var3) {
      return this.dispatchNestedPreFling(var2, var3);
   }

   public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
      if(var3 > 0 && this.mTotalUnconsumed > 0.0F) {
         if((float)var3 > this.mTotalUnconsumed) {
            var4[1] = var3 - (int)this.mTotalUnconsumed;
            this.mTotalUnconsumed = 0.0F;
         } else {
            this.mTotalUnconsumed -= (float)var3;
            var4[1] = var3;
         }

         this.moveSpinner(this.mTotalUnconsumed);
      }

      if(this.mUsingCustomStart && var3 > 0 && this.mTotalUnconsumed == 0.0F && Math.abs(var3 - var4[1]) > 0) {
         this.mCircleView.setVisibility(8);
      }

      int[] var5 = this.mParentScrollConsumed;
      if(this.dispatchNestedPreScroll(var2 - var4[0], var3 - var4[1], var5, (int[])null)) {
         var4[0] += var5[0];
         var4[1] += var5[1];
      }

   }

   public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
      this.dispatchNestedScroll(var2, var3, var4, var5, this.mParentOffsetInWindow);
      int var7 = var5 + this.mParentOffsetInWindow[1];
      if(var7 < 0) {
         this.mTotalUnconsumed += (float)Math.abs(var7);
         this.moveSpinner(this.mTotalUnconsumed);
      }

   }

   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.mNestedScrollingParentHelper.onNestedScrollAccepted(var1, var2, var3);
      this.startNestedScroll(var3 & 2);
      this.mTotalUnconsumed = 0.0F;
      this.mNestedScrollInProgress = true;
   }

   public boolean onStartNestedScroll(View var1, View var2, int var3) {
      return this.isEnabled() && this.canChildScrollUp() && !this.mReturningToStart && !this.mRefreshing && (var3 & 2) != 0;
   }

   public void onStopNestedScroll(View var1) {
      this.mNestedScrollingParentHelper.onStopNestedScroll(var1);
      this.mNestedScrollInProgress = false;
      if(this.mTotalUnconsumed > 0.0F) {
         this.finishSpinner(this.mTotalUnconsumed);
         this.mTotalUnconsumed = 0.0F;
      }

      this.stopNestedScroll();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      if(this.mReturningToStart && var2 == 0) {
         this.mReturningToStart = false;
      }

      if(this.isEnabled() && !this.mReturningToStart && !this.canChildScrollUp() && !this.mNestedScrollInProgress) {
         switch(var2) {
         case 0:
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
            this.mIsBeingDragged = false;
            break;
         case 1:
            int var3 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
            if(var3 < 0) {
               Log.e(LOG_TAG, "Got ACTION_UP event but don\'t have an active pointer id.");
               return false;
            }

            float var4 = 0.5F * (MotionEventCompat.getY(var1, var3) - this.mInitialMotionY);
            this.mIsBeingDragged = false;
            this.finishSpinner(var4);
            this.mActivePointerId = -1;
            return false;
         case 2:
            int var8 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
            if(var8 < 0) {
               Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
               return false;
            }

            float var9 = 0.5F * (MotionEventCompat.getY(var1, var8) - this.mInitialMotionY);
            if(this.mIsBeingDragged) {
               if(var9 <= 0.0F) {
                  return false;
               }

               this.moveSpinner(var9);
            }
            break;
         case 3:
            return false;
         case 4:
         default:
            break;
         case 5:
            int var6 = MotionEventCompat.getActionIndex(var1);
            if(var6 < 0) {
               Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
               return false;
            }

            this.mActivePointerId = MotionEventCompat.getPointerId(var1, var6);
            break;
         case 6:
            this.onSecondaryPointerUp(var1);
         }

         return true;
      } else {
         return false;
      }
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      if((VERSION.SDK_INT >= 21 || !(this.mTarget instanceof AbsListView)) && (this.mTarget == null || ViewCompat.isNestedScrollingEnabled(this.mTarget))) {
         super.requestDisallowInterceptTouchEvent(var1);
      }
   }

   @Deprecated
   public void setColorScheme(@ColorInt int... var1) {
      this.setColorSchemeResources(var1);
   }

   @ColorInt
   public void setColorSchemeColors(int... var1) {
      this.ensureTarget();
      this.mProgress.setColorSchemeColors(var1);
   }

   public void setColorSchemeResources(@ColorRes int... var1) {
      Resources var2 = this.getResources();
      int[] var3 = new int[var1.length];

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var3[var4] = var2.getColor(var1[var4]);
      }

      this.setColorSchemeColors(var3);
   }

   public void setDistanceToTriggerSync(int var1) {
      this.mTotalDragDistance = (float)var1;
   }

   public void setNestedScrollingEnabled(boolean var1) {
      this.mNestedScrollingChildHelper.setNestedScrollingEnabled(var1);
   }

   public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener var1) {
      this.mListener = var1;
   }

   @Deprecated
   public void setProgressBackgroundColor(int var1) {
      this.setProgressBackgroundColorSchemeResource(var1);
   }

   public void setProgressBackgroundColorSchemeColor(@ColorInt int var1) {
      this.mCircleView.setBackgroundColor(var1);
      this.mProgress.setBackgroundColor(var1);
   }

   public void setProgressBackgroundColorSchemeResource(@ColorRes int var1) {
      this.setProgressBackgroundColorSchemeColor(this.getResources().getColor(var1));
   }

   public void setProgressViewEndTarget(boolean var1, int var2) {
      this.mSpinnerFinalOffset = (float)var2;
      this.mScale = var1;
      this.mCircleView.invalidate();
   }

   public void setProgressViewOffset(boolean var1, int var2, int var3) {
      this.mScale = var1;
      this.mCircleView.setVisibility(8);
      this.mCurrentTargetOffsetTop = var2;
      this.mOriginalOffsetTop = var2;
      this.mSpinnerFinalOffset = (float)var3;
      this.mUsingCustomStart = true;
      this.mCircleView.invalidate();
   }

   public void setRefreshing(boolean var1) {
      if(var1 && this.mRefreshing != var1) {
         this.mRefreshing = var1;
         int var2;
         if(!this.mUsingCustomStart) {
            var2 = (int)(this.mSpinnerFinalOffset + (float)this.mOriginalOffsetTop);
         } else {
            var2 = (int)this.mSpinnerFinalOffset;
         }

         this.setTargetOffsetTopAndBottom(var2 - this.mCurrentTargetOffsetTop, true);
         this.mNotify = false;
         this.startScaleUpAnimation(this.mRefreshListener);
      } else {
         this.setRefreshing(var1, false);
      }
   }

   public void setSize(int var1) {
      if(var1 == 0 || var1 == 1) {
         DisplayMetrics var2 = this.getResources().getDisplayMetrics();
         if(var1 == 0) {
            int var4 = (int)(56.0F * var2.density);
            this.mCircleWidth = var4;
            this.mCircleHeight = var4;
         } else {
            int var3 = (int)(40.0F * var2.density);
            this.mCircleWidth = var3;
            this.mCircleHeight = var3;
         }

         this.mCircleView.setImageDrawable((Drawable)null);
         this.mProgress.updateSizes(var1);
         this.mCircleView.setImageDrawable(this.mProgress);
      }
   }

   public boolean startNestedScroll(int var1) {
      return this.mNestedScrollingChildHelper.startNestedScroll(var1);
   }

   public void stopNestedScroll() {
      this.mNestedScrollingChildHelper.stopNestedScroll();
   }

   public interface OnRefreshListener {
      void onRefresh();
   }
}
