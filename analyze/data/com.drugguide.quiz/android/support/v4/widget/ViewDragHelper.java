package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper {
   private static final int BASE_SETTLE_DURATION = 256;
   public static final int DIRECTION_ALL = 3;
   public static final int DIRECTION_HORIZONTAL = 1;
   public static final int DIRECTION_VERTICAL = 2;
   public static final int EDGE_ALL = 15;
   public static final int EDGE_BOTTOM = 8;
   public static final int EDGE_LEFT = 1;
   public static final int EDGE_RIGHT = 2;
   private static final int EDGE_SIZE = 20;
   public static final int EDGE_TOP = 4;
   public static final int INVALID_POINTER = -1;
   private static final int MAX_SETTLE_DURATION = 600;
   public static final int STATE_DRAGGING = 1;
   public static final int STATE_IDLE = 0;
   public static final int STATE_SETTLING = 2;
   private static final String TAG = "ViewDragHelper";
   private static final Interpolator sInterpolator = new Interpolator() {
      public float getInterpolation(float var1) {
         float var2 = var1 - 1.0F;
         return 1.0F + var2 * var2 * var2 * var2 * var2;
      }
   };
   private int mActivePointerId = -1;
   private final ViewDragHelper.Callback mCallback;
   private View mCapturedView;
   private int mDragState;
   private int[] mEdgeDragsInProgress;
   private int[] mEdgeDragsLocked;
   private int mEdgeSize;
   private int[] mInitialEdgesTouched;
   private float[] mInitialMotionX;
   private float[] mInitialMotionY;
   private float[] mLastMotionX;
   private float[] mLastMotionY;
   private float mMaxVelocity;
   private float mMinVelocity;
   private final ViewGroup mParentView;
   private int mPointersDown;
   private boolean mReleaseInProgress;
   private ScrollerCompat mScroller;
   private final Runnable mSetIdleRunnable = new Runnable() {
      public void run() {
         ViewDragHelper.this.setDragState(0);
      }
   };
   private int mTouchSlop;
   private int mTrackingEdges;
   private VelocityTracker mVelocityTracker;

   private ViewDragHelper(Context var1, ViewGroup var2, ViewDragHelper.Callback var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("Parent view may not be null");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Callback may not be null");
      } else {
         this.mParentView = var2;
         this.mCallback = var3;
         ViewConfiguration var4 = ViewConfiguration.get(var1);
         this.mEdgeSize = (int)(0.5F + 20.0F * var1.getResources().getDisplayMetrics().density);
         this.mTouchSlop = var4.getScaledTouchSlop();
         this.mMaxVelocity = (float)var4.getScaledMaximumFlingVelocity();
         this.mMinVelocity = (float)var4.getScaledMinimumFlingVelocity();
         this.mScroller = ScrollerCompat.create(var1, sInterpolator);
      }
   }

   private boolean checkNewEdgeDrag(float var1, float var2, int var3, int var4) {
      float var5 = Math.abs(var1);
      float var6 = Math.abs(var2);
      if((var4 & this.mInitialEdgesTouched[var3]) == var4 && (var4 & this.mTrackingEdges) != 0 && (var4 & this.mEdgeDragsLocked[var3]) != var4 && (var4 & this.mEdgeDragsInProgress[var3]) != var4 && (var5 > (float)this.mTouchSlop || var6 > (float)this.mTouchSlop)) {
         if(var5 < 0.5F * var6 && this.mCallback.onEdgeLock(var4)) {
            int[] var7 = this.mEdgeDragsLocked;
            var7[var3] |= var4;
            return false;
         }

         if((var4 & this.mEdgeDragsInProgress[var3]) == 0 && var5 > (float)this.mTouchSlop) {
            return true;
         }
      }

      return false;
   }

   private boolean checkTouchSlop(View var1, float var2, float var3) {
      boolean var4 = true;
      if(var1 == null) {
         var4 = false;
      } else {
         boolean var5;
         if(this.mCallback.getViewHorizontalDragRange(var1) > 0) {
            var5 = var4;
         } else {
            var5 = false;
         }

         boolean var6;
         if(this.mCallback.getViewVerticalDragRange(var1) > 0) {
            var6 = var4;
         } else {
            var6 = false;
         }

         if(var5 && var6) {
            if(var2 * var2 + var3 * var3 <= (float)(this.mTouchSlop * this.mTouchSlop)) {
               return false;
            }
         } else if(var5) {
            if(Math.abs(var2) <= (float)this.mTouchSlop) {
               return false;
            }
         } else {
            if(!var6) {
               return false;
            }

            if(Math.abs(var3) <= (float)this.mTouchSlop) {
               return false;
            }
         }
      }

      return var4;
   }

   private float clampMag(float var1, float var2, float var3) {
      float var4 = Math.abs(var1);
      if(var4 < var2) {
         var3 = 0.0F;
      } else {
         if(var4 <= var3) {
            return var1;
         }

         if(var1 <= 0.0F) {
            return -var3;
         }
      }

      return var3;
   }

   private int clampMag(int var1, int var2, int var3) {
      int var4 = Math.abs(var1);
      if(var4 < var2) {
         var3 = 0;
      } else {
         if(var4 <= var3) {
            return var1;
         }

         if(var1 <= 0) {
            return -var3;
         }
      }

      return var3;
   }

   private void clearMotionHistory() {
      if(this.mInitialMotionX != null) {
         Arrays.fill(this.mInitialMotionX, 0.0F);
         Arrays.fill(this.mInitialMotionY, 0.0F);
         Arrays.fill(this.mLastMotionX, 0.0F);
         Arrays.fill(this.mLastMotionY, 0.0F);
         Arrays.fill(this.mInitialEdgesTouched, 0);
         Arrays.fill(this.mEdgeDragsInProgress, 0);
         Arrays.fill(this.mEdgeDragsLocked, 0);
         this.mPointersDown = 0;
      }
   }

   private void clearMotionHistory(int var1) {
      if(this.mInitialMotionX != null) {
         this.mInitialMotionX[var1] = 0.0F;
         this.mInitialMotionY[var1] = 0.0F;
         this.mLastMotionX[var1] = 0.0F;
         this.mLastMotionY[var1] = 0.0F;
         this.mInitialEdgesTouched[var1] = 0;
         this.mEdgeDragsInProgress[var1] = 0;
         this.mEdgeDragsLocked[var1] = 0;
         this.mPointersDown &= ~(1 << var1);
      }
   }

   private int computeAxisDuration(int var1, int var2, int var3) {
      if(var1 == 0) {
         return 0;
      } else {
         int var4 = this.mParentView.getWidth();
         int var5 = var4 / 2;
         float var6 = Math.min(1.0F, (float)Math.abs(var1) / (float)var4);
         float var7 = (float)var5 + (float)var5 * this.distanceInfluenceForSnapDuration(var6);
         int var8 = Math.abs(var2);
         int var9;
         if(var8 > 0) {
            var9 = 4 * Math.round(1000.0F * Math.abs(var7 / (float)var8));
         } else {
            var9 = (int)(256.0F * (1.0F + (float)Math.abs(var1) / (float)var3));
         }

         return Math.min(var9, 600);
      }
   }

   private int computeSettleDuration(View var1, int var2, int var3, int var4, int var5) {
      int var6 = this.clampMag(var4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
      int var7 = this.clampMag(var5, (int)this.mMinVelocity, (int)this.mMaxVelocity);
      int var8 = Math.abs(var2);
      int var9 = Math.abs(var3);
      int var10 = Math.abs(var6);
      int var11 = Math.abs(var7);
      int var12 = var10 + var11;
      int var13 = var8 + var9;
      float var14;
      if(var6 != 0) {
         var14 = (float)var10 / (float)var12;
      } else {
         var14 = (float)var8 / (float)var13;
      }

      float var15;
      if(var7 != 0) {
         var15 = (float)var11 / (float)var12;
      } else {
         var15 = (float)var9 / (float)var13;
      }

      int var16 = this.computeAxisDuration(var2, var6, this.mCallback.getViewHorizontalDragRange(var1));
      int var17 = this.computeAxisDuration(var3, var7, this.mCallback.getViewVerticalDragRange(var1));
      return (int)(var14 * (float)var16 + var15 * (float)var17);
   }

   public static ViewDragHelper create(ViewGroup var0, float var1, ViewDragHelper.Callback var2) {
      ViewDragHelper var3 = create(var0, var2);
      var3.mTouchSlop = (int)((float)var3.mTouchSlop * (1.0F / var1));
      return var3;
   }

   public static ViewDragHelper create(ViewGroup var0, ViewDragHelper.Callback var1) {
      return new ViewDragHelper(var0.getContext(), var0, var1);
   }

   private void dispatchViewReleased(float var1, float var2) {
      this.mReleaseInProgress = true;
      this.mCallback.onViewReleased(this.mCapturedView, var1, var2);
      this.mReleaseInProgress = false;
      if(this.mDragState == 1) {
         this.setDragState(0);
      }

   }

   private float distanceInfluenceForSnapDuration(float var1) {
      return (float)Math.sin((double)((float)(0.4712389167638204D * (double)(var1 - 0.5F))));
   }

   private void dragTo(int var1, int var2, int var3, int var4) {
      int var5 = var1;
      int var6 = var2;
      int var7 = this.mCapturedView.getLeft();
      int var8 = this.mCapturedView.getTop();
      if(var3 != 0) {
         var5 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, var1, var3);
         this.mCapturedView.offsetLeftAndRight(var5 - var7);
      }

      if(var4 != 0) {
         var6 = this.mCallback.clampViewPositionVertical(this.mCapturedView, var2, var4);
         this.mCapturedView.offsetTopAndBottom(var6 - var8);
      }

      if(var3 != 0 || var4 != 0) {
         int var9 = var5 - var7;
         int var10 = var6 - var8;
         this.mCallback.onViewPositionChanged(this.mCapturedView, var5, var6, var9, var10);
      }

   }

   private void ensureMotionHistorySizeForId(int var1) {
      if(this.mInitialMotionX == null || this.mInitialMotionX.length <= var1) {
         float[] var2 = new float[var1 + 1];
         float[] var3 = new float[var1 + 1];
         float[] var4 = new float[var1 + 1];
         float[] var5 = new float[var1 + 1];
         int[] var6 = new int[var1 + 1];
         int[] var7 = new int[var1 + 1];
         int[] var8 = new int[var1 + 1];
         if(this.mInitialMotionX != null) {
            System.arraycopy(this.mInitialMotionX, 0, var2, 0, this.mInitialMotionX.length);
            System.arraycopy(this.mInitialMotionY, 0, var3, 0, this.mInitialMotionY.length);
            System.arraycopy(this.mLastMotionX, 0, var4, 0, this.mLastMotionX.length);
            System.arraycopy(this.mLastMotionY, 0, var5, 0, this.mLastMotionY.length);
            System.arraycopy(this.mInitialEdgesTouched, 0, var6, 0, this.mInitialEdgesTouched.length);
            System.arraycopy(this.mEdgeDragsInProgress, 0, var7, 0, this.mEdgeDragsInProgress.length);
            System.arraycopy(this.mEdgeDragsLocked, 0, var8, 0, this.mEdgeDragsLocked.length);
         }

         this.mInitialMotionX = var2;
         this.mInitialMotionY = var3;
         this.mLastMotionX = var4;
         this.mLastMotionY = var5;
         this.mInitialEdgesTouched = var6;
         this.mEdgeDragsInProgress = var7;
         this.mEdgeDragsLocked = var8;
      }

   }

   private boolean forceSettleCapturedViewAt(int var1, int var2, int var3, int var4) {
      int var5 = this.mCapturedView.getLeft();
      int var6 = this.mCapturedView.getTop();
      int var7 = var1 - var5;
      int var8 = var2 - var6;
      if(var7 == 0 && var8 == 0) {
         this.mScroller.abortAnimation();
         this.setDragState(0);
         return false;
      } else {
         int var9 = this.computeSettleDuration(this.mCapturedView, var7, var8, var3, var4);
         this.mScroller.startScroll(var5, var6, var7, var8, var9);
         this.setDragState(2);
         return true;
      }
   }

   private int getEdgesTouched(int var1, int var2) {
      int var3 = this.mParentView.getLeft() + this.mEdgeSize;
      int var4 = 0;
      if(var1 < var3) {
         var4 = 0 | 1;
      }

      if(var2 < this.mParentView.getTop() + this.mEdgeSize) {
         var4 |= 4;
      }

      if(var1 > this.mParentView.getRight() - this.mEdgeSize) {
         var4 |= 2;
      }

      if(var2 > this.mParentView.getBottom() - this.mEdgeSize) {
         var4 |= 8;
      }

      return var4;
   }

   private void releaseViewForPointerUp() {
      this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
      this.dispatchViewReleased(this.clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), this.clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
   }

   private void reportNewEdgeDrags(float var1, float var2, int var3) {
      boolean var4 = this.checkNewEdgeDrag(var1, var2, var3, 1);
      int var5 = 0;
      if(var4) {
         var5 = 0 | 1;
      }

      if(this.checkNewEdgeDrag(var2, var1, var3, 4)) {
         var5 |= 4;
      }

      if(this.checkNewEdgeDrag(var1, var2, var3, 2)) {
         var5 |= 2;
      }

      if(this.checkNewEdgeDrag(var2, var1, var3, 8)) {
         var5 |= 8;
      }

      if(var5 != 0) {
         int[] var6 = this.mEdgeDragsInProgress;
         var6[var3] |= var5;
         this.mCallback.onEdgeDragStarted(var5, var3);
      }

   }

   private void saveInitialMotion(float var1, float var2, int var3) {
      this.ensureMotionHistorySizeForId(var3);
      float[] var4 = this.mInitialMotionX;
      this.mLastMotionX[var3] = var1;
      var4[var3] = var1;
      float[] var5 = this.mInitialMotionY;
      this.mLastMotionY[var3] = var2;
      var5[var3] = var2;
      this.mInitialEdgesTouched[var3] = this.getEdgesTouched((int)var1, (int)var2);
      this.mPointersDown |= 1 << var3;
   }

   private void saveLastMotion(MotionEvent var1) {
      int var2 = MotionEventCompat.getPointerCount(var1);

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = MotionEventCompat.getPointerId(var1, var3);
         float var5 = MotionEventCompat.getX(var1, var3);
         float var6 = MotionEventCompat.getY(var1, var3);
         this.mLastMotionX[var4] = var5;
         this.mLastMotionY[var4] = var6;
      }

   }

   public void abort() {
      this.cancel();
      if(this.mDragState == 2) {
         int var1 = this.mScroller.getCurrX();
         int var2 = this.mScroller.getCurrY();
         this.mScroller.abortAnimation();
         int var3 = this.mScroller.getCurrX();
         int var4 = this.mScroller.getCurrY();
         this.mCallback.onViewPositionChanged(this.mCapturedView, var3, var4, var3 - var1, var4 - var2);
      }

      this.setDragState(0);
   }

   protected boolean canScroll(View var1, boolean var2, int var3, int var4, int var5, int var6) {
      if(var1 instanceof ViewGroup) {
         ViewGroup var7 = (ViewGroup)var1;
         int var8 = var1.getScrollX();
         int var9 = var1.getScrollY();

         for(int var10 = -1 + var7.getChildCount(); var10 >= 0; --var10) {
            View var11 = var7.getChildAt(var10);
            if(var5 + var8 >= var11.getLeft() && var5 + var8 < var11.getRight() && var6 + var9 >= var11.getTop() && var6 + var9 < var11.getBottom() && this.canScroll(var11, true, var3, var4, var5 + var8 - var11.getLeft(), var6 + var9 - var11.getTop())) {
               return true;
            }
         }
      }

      return var2 && (ViewCompat.canScrollHorizontally(var1, -var3) || ViewCompat.canScrollVertically(var1, -var4));
   }

   public void cancel() {
      this.mActivePointerId = -1;
      this.clearMotionHistory();
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.recycle();
         this.mVelocityTracker = null;
      }

   }

   public void captureChildView(View var1, int var2) {
      if(var1.getParent() != this.mParentView) {
         throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper\'s tracked parent view (" + this.mParentView + ")");
      } else {
         this.mCapturedView = var1;
         this.mActivePointerId = var2;
         this.mCallback.onViewCaptured(var1, var2);
         this.setDragState(1);
      }
   }

   public boolean checkTouchSlop(int var1) {
      int var2 = this.mInitialMotionX.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(this.checkTouchSlop(var1, var3)) {
            return true;
         }
      }

      return false;
   }

   public boolean checkTouchSlop(int var1, int var2) {
      byte var3 = 1;
      if(!this.isPointerDown(var2)) {
         var3 = 0;
      } else {
         byte var4;
         if((var1 & 1) == var3) {
            var4 = var3;
         } else {
            var4 = 0;
         }

         byte var5;
         if((var1 & 2) == 2) {
            var5 = var3;
         } else {
            var5 = 0;
         }

         float var6 = this.mLastMotionX[var2] - this.mInitialMotionX[var2];
         float var7 = this.mLastMotionY[var2] - this.mInitialMotionY[var2];
         if(var4 != 0 && var5 != 0) {
            if(var6 * var6 + var7 * var7 <= (float)(this.mTouchSlop * this.mTouchSlop)) {
               return false;
            }
         } else if(var4 != 0) {
            if(Math.abs(var6) <= (float)this.mTouchSlop) {
               return false;
            }
         } else {
            if(var5 == 0) {
               return false;
            }

            if(Math.abs(var7) <= (float)this.mTouchSlop) {
               return false;
            }
         }
      }

      return (boolean)var3;
   }

   public boolean continueSettling(boolean var1) {
      if(this.mDragState == 2) {
         boolean var2 = this.mScroller.computeScrollOffset();
         int var3 = this.mScroller.getCurrX();
         int var4 = this.mScroller.getCurrY();
         int var5 = var3 - this.mCapturedView.getLeft();
         int var6 = var4 - this.mCapturedView.getTop();
         if(var5 != 0) {
            this.mCapturedView.offsetLeftAndRight(var5);
         }

         if(var6 != 0) {
            this.mCapturedView.offsetTopAndBottom(var6);
         }

         if(var5 != 0 || var6 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, var3, var4, var5, var6);
         }

         if(var2 && var3 == this.mScroller.getFinalX() && var4 == this.mScroller.getFinalY()) {
            this.mScroller.abortAnimation();
            var2 = this.mScroller.isFinished();
         }

         if(!var2) {
            if(var1) {
               this.mParentView.post(this.mSetIdleRunnable);
            } else {
               this.setDragState(0);
            }
         }
      }

      return this.mDragState == 2;
   }

   public View findTopChildUnder(int var1, int var2) {
      for(int var3 = -1 + this.mParentView.getChildCount(); var3 >= 0; --var3) {
         View var4 = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(var3));
         if(var1 >= var4.getLeft() && var1 < var4.getRight() && var2 >= var4.getTop() && var2 < var4.getBottom()) {
            return var4;
         }
      }

      return null;
   }

   public void flingCapturedView(int var1, int var2, int var3, int var4) {
      if(!this.mReleaseInProgress) {
         throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
      } else {
         this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), var1, var3, var2, var4);
         this.setDragState(2);
      }
   }

   public int getActivePointerId() {
      return this.mActivePointerId;
   }

   public View getCapturedView() {
      return this.mCapturedView;
   }

   public int getEdgeSize() {
      return this.mEdgeSize;
   }

   public float getMinVelocity() {
      return this.mMinVelocity;
   }

   public int getTouchSlop() {
      return this.mTouchSlop;
   }

   public int getViewDragState() {
      return this.mDragState;
   }

   public boolean isCapturedViewUnder(int var1, int var2) {
      return this.isViewUnder(this.mCapturedView, var1, var2);
   }

   public boolean isEdgeTouched(int var1) {
      int var2 = this.mInitialEdgesTouched.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(this.isEdgeTouched(var1, var3)) {
            return true;
         }
      }

      return false;
   }

   public boolean isEdgeTouched(int var1, int var2) {
      return this.isPointerDown(var2) && (var1 & this.mInitialEdgesTouched[var2]) != 0;
   }

   public boolean isPointerDown(int var1) {
      return (this.mPointersDown & 1 << var1) != 0;
   }

   public boolean isViewUnder(View var1, int var2, int var3) {
      return var1 != null && var2 >= var1.getLeft() && var2 < var1.getRight() && var3 >= var1.getTop() && var3 < var1.getBottom();
   }

   public void processTouchEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      int var3 = MotionEventCompat.getActionIndex(var1);
      if(var2 == 0) {
         this.cancel();
      }

      if(this.mVelocityTracker == null) {
         this.mVelocityTracker = VelocityTracker.obtain();
      }

      this.mVelocityTracker.addMovement(var1);
      switch(var2) {
      case 0:
         float var30 = var1.getX();
         float var31 = var1.getY();
         int var32 = MotionEventCompat.getPointerId(var1, 0);
         View var33 = this.findTopChildUnder((int)var30, (int)var31);
         this.saveInitialMotion(var30, var31, var32);
         this.tryCaptureViewForDrag(var33, var32);
         int var35 = this.mInitialEdgesTouched[var32];
         if((var35 & this.mTrackingEdges) != 0) {
            this.mCallback.onEdgeTouched(var35 & this.mTrackingEdges, var32);
            return;
         }
         break;
      case 1:
         if(this.mDragState == 1) {
            this.releaseViewForPointerUp();
         }

         this.cancel();
         return;
      case 2:
         if(this.mDragState == 1) {
            int var19 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
            float var20 = MotionEventCompat.getX(var1, var19);
            float var21 = MotionEventCompat.getY(var1, var19);
            int var22 = (int)(var20 - this.mLastMotionX[this.mActivePointerId]);
            int var23 = (int)(var21 - this.mLastMotionY[this.mActivePointerId]);
            this.dragTo(var22 + this.mCapturedView.getLeft(), var23 + this.mCapturedView.getTop(), var22, var23);
            this.saveLastMotion(var1);
            return;
         }

         int var11 = MotionEventCompat.getPointerCount(var1);

         for(int var12 = 0; var12 < var11; ++var12) {
            int var13 = MotionEventCompat.getPointerId(var1, var12);
            float var14 = MotionEventCompat.getX(var1, var12);
            float var15 = MotionEventCompat.getY(var1, var12);
            float var16 = var14 - this.mInitialMotionX[var13];
            float var17 = var15 - this.mInitialMotionY[var13];
            this.reportNewEdgeDrags(var16, var17, var13);
            if(this.mDragState == 1) {
               break;
            }

            View var18 = this.findTopChildUnder((int)var14, (int)var15);
            if(this.checkTouchSlop(var18, var16, var17) && this.tryCaptureViewForDrag(var18, var13)) {
               break;
            }
         }

         this.saveLastMotion(var1);
         return;
      case 3:
         if(this.mDragState == 1) {
            this.dispatchViewReleased(0.0F, 0.0F);
         }

         this.cancel();
         return;
      case 4:
      default:
         break;
      case 5:
         int var24 = MotionEventCompat.getPointerId(var1, var3);
         float var25 = MotionEventCompat.getX(var1, var3);
         float var26 = MotionEventCompat.getY(var1, var3);
         this.saveInitialMotion(var25, var26, var24);
         if(this.mDragState == 0) {
            this.tryCaptureViewForDrag(this.findTopChildUnder((int)var25, (int)var26), var24);
            int var29 = this.mInitialEdgesTouched[var24];
            if((var29 & this.mTrackingEdges) != 0) {
               this.mCallback.onEdgeTouched(var29 & this.mTrackingEdges, var24);
               return;
            }
         } else if(this.isCapturedViewUnder((int)var25, (int)var26)) {
            this.tryCaptureViewForDrag(this.mCapturedView, var24);
            return;
         }
         break;
      case 6:
         int var4 = MotionEventCompat.getPointerId(var1, var3);
         if(this.mDragState == 1 && var4 == this.mActivePointerId) {
            int var5 = -1;
            int var6 = MotionEventCompat.getPointerCount(var1);

            for(int var7 = 0; var7 < var6; ++var7) {
               int var8 = MotionEventCompat.getPointerId(var1, var7);
               if(var8 != this.mActivePointerId) {
                  float var9 = MotionEventCompat.getX(var1, var7);
                  float var10 = MotionEventCompat.getY(var1, var7);
                  if(this.findTopChildUnder((int)var9, (int)var10) == this.mCapturedView && this.tryCaptureViewForDrag(this.mCapturedView, var8)) {
                     var5 = this.mActivePointerId;
                     break;
                  }
               }
            }

            if(var5 == -1) {
               this.releaseViewForPointerUp();
            }
         }

         this.clearMotionHistory(var4);
         return;
      }

   }

   void setDragState(int var1) {
      if(this.mDragState != var1) {
         this.mDragState = var1;
         this.mCallback.onViewDragStateChanged(var1);
         if(var1 == 0) {
            this.mCapturedView = null;
         }
      }

   }

   public void setEdgeTrackingEnabled(int var1) {
      this.mTrackingEdges = var1;
   }

   public void setMinVelocity(float var1) {
      this.mMinVelocity = var1;
   }

   public boolean settleCapturedViewAt(int var1, int var2) {
      if(!this.mReleaseInProgress) {
         throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
      } else {
         return this.forceSettleCapturedViewAt(var1, var2, (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
      }
   }

   public boolean shouldInterceptTouchEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      int var3 = MotionEventCompat.getActionIndex(var1);
      if(var2 == 0) {
         this.cancel();
      }

      if(this.mVelocityTracker == null) {
         this.mVelocityTracker = VelocityTracker.obtain();
      }

      this.mVelocityTracker.addMovement(var1);
      switch(var2) {
      case 0:
         float var18 = var1.getX();
         float var19 = var1.getY();
         int var20 = MotionEventCompat.getPointerId(var1, 0);
         this.saveInitialMotion(var18, var19, var20);
         View var21 = this.findTopChildUnder((int)var18, (int)var19);
         if(var21 == this.mCapturedView && this.mDragState == 2) {
            this.tryCaptureViewForDrag(var21, var20);
         }

         int var22 = this.mInitialEdgesTouched[var20];
         if((var22 & this.mTrackingEdges) != 0) {
            this.mCallback.onEdgeTouched(var22 & this.mTrackingEdges, var20);
         }
         break;
      case 1:
      case 3:
         this.cancel();
         break;
      case 2:
         int var4 = MotionEventCompat.getPointerCount(var1);

         for(int var5 = 0; var5 < var4; ++var5) {
            int var6 = MotionEventCompat.getPointerId(var1, var5);
            float var7 = MotionEventCompat.getX(var1, var5);
            float var8 = MotionEventCompat.getY(var1, var5);
            float var9 = var7 - this.mInitialMotionX[var6];
            float var10 = var8 - this.mInitialMotionY[var6];
            this.reportNewEdgeDrags(var9, var10, var6);
            if(this.mDragState == 1) {
               break;
            }

            View var11 = this.findTopChildUnder((int)var7, (int)var8);
            if(var11 != null && this.checkTouchSlop(var11, var9, var10) && this.tryCaptureViewForDrag(var11, var6)) {
               break;
            }
         }

         this.saveLastMotion(var1);
      case 4:
      default:
         break;
      case 5:
         int var12 = MotionEventCompat.getPointerId(var1, var3);
         float var13 = MotionEventCompat.getX(var1, var3);
         float var14 = MotionEventCompat.getY(var1, var3);
         this.saveInitialMotion(var13, var14, var12);
         if(this.mDragState == 0) {
            int var17 = this.mInitialEdgesTouched[var12];
            if((var17 & this.mTrackingEdges) != 0) {
               this.mCallback.onEdgeTouched(var17 & this.mTrackingEdges, var12);
            }
         } else if(this.mDragState == 2) {
            View var15 = this.findTopChildUnder((int)var13, (int)var14);
            if(var15 == this.mCapturedView) {
               this.tryCaptureViewForDrag(var15, var12);
            }
         }
         break;
      case 6:
         this.clearMotionHistory(MotionEventCompat.getPointerId(var1, var3));
      }

      return this.mDragState == 1;
   }

   public boolean smoothSlideViewTo(View var1, int var2, int var3) {
      this.mCapturedView = var1;
      this.mActivePointerId = -1;
      return this.forceSettleCapturedViewAt(var2, var3, 0, 0);
   }

   boolean tryCaptureViewForDrag(View var1, int var2) {
      if(var1 == this.mCapturedView && this.mActivePointerId == var2) {
         return true;
      } else if(var1 != null && this.mCallback.tryCaptureView(var1, var2)) {
         this.mActivePointerId = var2;
         this.captureChildView(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   public abstract static class Callback {
      public int clampViewPositionHorizontal(View var1, int var2, int var3) {
         return 0;
      }

      public int clampViewPositionVertical(View var1, int var2, int var3) {
         return 0;
      }

      public int getOrderedChildIndex(int var1) {
         return var1;
      }

      public int getViewHorizontalDragRange(View var1) {
         return 0;
      }

      public int getViewVerticalDragRange(View var1) {
         return 0;
      }

      public void onEdgeDragStarted(int var1, int var2) {
      }

      public boolean onEdgeLock(int var1) {
         return false;
      }

      public void onEdgeTouched(int var1, int var2) {
      }

      public void onViewCaptured(View var1, int var2) {
      }

      public void onViewDragStateChanged(int var1) {
      }

      public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
      }

      public void onViewReleased(View var1, float var2, float var3) {
      }

      public abstract boolean tryCaptureView(View var1, int var2);
   }
}
