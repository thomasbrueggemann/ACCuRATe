package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.design.class_5;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.MathUtils;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
   private static final float HIDE_FRICTION = 0.1F;
   private static final float HIDE_THRESHOLD = 0.5F;
   public static final int STATE_COLLAPSED = 4;
   public static final int STATE_DRAGGING = 1;
   public static final int STATE_EXPANDED = 3;
   public static final int STATE_HIDDEN = 5;
   public static final int STATE_SETTLING = 2;
   private int mActivePointerId;
   private BottomSheetBehavior.BottomSheetCallback mCallback;
   private final ViewDragHelper.Callback mDragCallback = new ViewDragHelper.Callback() {
      public int clampViewPositionHorizontal(View var1, int var2, int var3) {
         return var1.getLeft();
      }

      public int clampViewPositionVertical(View var1, int var2, int var3) {
         int var4 = BottomSheetBehavior.this.mMinOffset;
         int var5;
         if(BottomSheetBehavior.this.mHideable) {
            var5 = BottomSheetBehavior.this.mParentHeight;
         } else {
            var5 = BottomSheetBehavior.this.mMaxOffset;
         }

         return MathUtils.constrain(var2, var4, var5);
      }

      public int getViewVerticalDragRange(View var1) {
         return BottomSheetBehavior.this.mHideable?BottomSheetBehavior.this.mParentHeight - BottomSheetBehavior.this.mMinOffset:BottomSheetBehavior.this.mMaxOffset - BottomSheetBehavior.this.mMinOffset;
      }

      public void onViewDragStateChanged(int var1) {
         if(var1 == 1) {
            BottomSheetBehavior.this.setStateInternal(1);
         }

      }

      public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
         BottomSheetBehavior.this.dispatchOnSlide(var3);
      }

      public void onViewReleased(View var1, float var2, float var3) {
         int var4;
         byte var5;
         if(var3 < 0.0F) {
            var4 = BottomSheetBehavior.this.mMinOffset;
            var5 = 3;
         } else if(BottomSheetBehavior.this.mHideable && BottomSheetBehavior.this.shouldHide(var1, var3)) {
            var4 = BottomSheetBehavior.this.mParentHeight;
            var5 = 5;
         } else if(var3 == 0.0F) {
            int var6 = var1.getTop();
            if(Math.abs(var6 - BottomSheetBehavior.this.mMinOffset) < Math.abs(var6 - BottomSheetBehavior.this.mMaxOffset)) {
               var4 = BottomSheetBehavior.this.mMinOffset;
               var5 = 3;
            } else {
               var4 = BottomSheetBehavior.this.mMaxOffset;
               var5 = 4;
            }
         } else {
            var4 = BottomSheetBehavior.this.mMaxOffset;
            var5 = 4;
         }

         if(BottomSheetBehavior.this.mViewDragHelper.settleCapturedViewAt(var1.getLeft(), var4)) {
            BottomSheetBehavior.this.setStateInternal(2);
            ViewCompat.postOnAnimation(var1, BottomSheetBehavior.this.new SettleRunnable(var1, var5));
         } else {
            BottomSheetBehavior.this.setStateInternal(var5);
         }
      }

      public boolean tryCaptureView(View var1, int var2) {
         byte var3 = 1;
         if(BottomSheetBehavior.this.mState != var3 && !BottomSheetBehavior.this.mTouchingScrollingChild) {
            if(BottomSheetBehavior.this.mState == 3 && BottomSheetBehavior.this.mActivePointerId == var2) {
               View var4 = (View)BottomSheetBehavior.this.mNestedScrollingChildRef.get();
               if(var4 != null && ViewCompat.canScrollVertically(var4, -1)) {
                  return false;
               }
            }

            if(BottomSheetBehavior.this.mViewRef == null || BottomSheetBehavior.this.mViewRef.get() != var1) {
               var3 = 0;
            }

            return (boolean)var3;
         } else {
            return false;
         }
      }
   };
   private boolean mHideable;
   private boolean mIgnoreEvents;
   private int mInitialY;
   private int mLastNestedScrollDy;
   private int mMaxOffset;
   private float mMaximumVelocity;
   private int mMinOffset;
   private boolean mNestedScrolled;
   private WeakReference<View> mNestedScrollingChildRef;
   private int mParentHeight;
   private int mPeekHeight;
   private int mState = 4;
   private boolean mTouchingScrollingChild;
   private VelocityTracker mVelocityTracker;
   private ViewDragHelper mViewDragHelper;
   private WeakReference<V> mViewRef;

   public BottomSheetBehavior() {
   }

   public BottomSheetBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_5.styleable.BottomSheetBehavior_Params);
      this.setPeekHeight(var3.getDimensionPixelSize(class_5.styleable.BottomSheetBehavior_Params_behavior_peekHeight, 0));
      this.setHideable(var3.getBoolean(class_5.styleable.BottomSheetBehavior_Params_behavior_hideable, false));
      var3.recycle();
      this.mMaximumVelocity = (float)ViewConfiguration.get(var1).getScaledMaximumFlingVelocity();
   }

   private void dispatchOnSlide(int var1) {
      View var2 = (View)this.mViewRef.get();
      if(var2 != null && this.mCallback != null) {
         if(var1 <= this.mMaxOffset) {
            this.mCallback.onSlide(var2, (float)(this.mMaxOffset - var1) / (float)(this.mMaxOffset - this.mMinOffset));
            return;
         }

         this.mCallback.onSlide(var2, (float)(this.mMaxOffset - var1) / (float)this.mPeekHeight);
      }

   }

   private View findScrollingChild(View var1) {
      if(var1 instanceof NestedScrollingChild) {
         return var1;
      } else {
         if(var1 instanceof ViewGroup) {
            ViewGroup var2 = (ViewGroup)var1;
            int var3 = 0;

            for(int var4 = var2.getChildCount(); var3 < var4; ++var3) {
               View var5 = this.findScrollingChild(var2.getChildAt(var3));
               if(var5 != null) {
                  return var5;
               }
            }
         }

         return null;
      }
   }

   public static <V extends View> BottomSheetBehavior<V> from(V var0) {
      LayoutParams var1 = var0.getLayoutParams();
      if(!(var1 instanceof CoordinatorLayout.LayoutParams)) {
         throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
      } else {
         CoordinatorLayout.Behavior var2 = ((CoordinatorLayout.LayoutParams)var1).getBehavior();
         if(!(var2 instanceof BottomSheetBehavior)) {
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
         } else {
            return (BottomSheetBehavior)var2;
         }
      }
   }

   private float getYVelocity() {
      this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
      return VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
   }

   private void reset() {
      this.mActivePointerId = -1;
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.recycle();
         this.mVelocityTracker = null;
      }

   }

   private void setStateInternal(int var1) {
      if(this.mState != var1) {
         this.mState = var1;
         View var2 = (View)this.mViewRef.get();
         if(var2 != null && this.mCallback != null) {
            this.mCallback.onStateChanged(var2, var1);
            return;
         }
      }

   }

   private boolean shouldHide(View var1, float var2) {
      return var1.getTop() >= this.mMaxOffset && Math.abs((float)var1.getTop() + 0.1F * var2 - (float)this.mMaxOffset) / (float)this.mPeekHeight > 0.5F;
   }

   public final int getPeekHeight() {
      return this.mPeekHeight;
   }

   public final int getState() {
      return this.mState;
   }

   public boolean isHideable() {
      return this.mHideable;
   }

   public boolean onInterceptTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
      byte var4 = 1;
      if(!var2.isShown()) {
         return false;
      } else {
         int var5 = MotionEventCompat.getActionMasked(var3);
         if(var5 == 0) {
            this.reset();
         }

         if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
         }

         this.mVelocityTracker.addMovement(var3);
         switch(var5) {
         case 0:
            int var6 = (int)var3.getX();
            this.mInitialY = (int)var3.getY();
            View var7 = (View)this.mNestedScrollingChildRef.get();
            if(var7 != null && var1.isPointInChildBounds(var7, var6, this.mInitialY)) {
               this.mActivePointerId = var3.getPointerId(var3.getActionIndex());
               this.mTouchingScrollingChild = (boolean)var4;
            }

            byte var8;
            if(this.mActivePointerId == -1 && !var1.isPointInChildBounds(var2, var6, this.mInitialY)) {
               var8 = var4;
            } else {
               var8 = 0;
            }

            this.mIgnoreEvents = (boolean)var8;
            break;
         case 1:
         case 3:
            this.mTouchingScrollingChild = false;
            this.mActivePointerId = -1;
            if(this.mIgnoreEvents) {
               this.mIgnoreEvents = false;
               return false;
            }
         case 2:
         }

         if(!this.mIgnoreEvents && this.mViewDragHelper.shouldInterceptTouchEvent(var3)) {
            return (boolean)var4;
         } else {
            View var9 = (View)this.mNestedScrollingChildRef.get();
            if(var5 != 2 || var9 == null || this.mIgnoreEvents || this.mState == var4 || var1.isPointInChildBounds(var9, (int)var3.getX(), (int)var3.getY()) || Math.abs((float)this.mInitialY - var3.getY()) <= (float)this.mViewDragHelper.getTouchSlop()) {
               var4 = 0;
            }

            return (boolean)var4;
         }
      }
   }

   public boolean onLayoutChild(CoordinatorLayout var1, V var2, int var3) {
      if(this.mState != 1 && this.mState != 2) {
         var1.onLayoutChild(var2, var3);
      }

      this.mParentHeight = var1.getHeight();
      this.mMinOffset = Math.max(0, this.mParentHeight - var2.getHeight());
      this.mMaxOffset = this.mParentHeight - this.mPeekHeight;
      if(this.mState == 3) {
         ViewCompat.offsetTopAndBottom(var2, this.mMinOffset);
      } else if(this.mHideable && this.mState == 5) {
         ViewCompat.offsetTopAndBottom(var2, this.mParentHeight);
      } else if(this.mState == 4) {
         ViewCompat.offsetTopAndBottom(var2, this.mMaxOffset);
      }

      if(this.mViewDragHelper == null) {
         this.mViewDragHelper = ViewDragHelper.create(var1, this.mDragCallback);
      }

      this.mViewRef = new WeakReference(var2);
      this.mNestedScrollingChildRef = new WeakReference(this.findScrollingChild(var2));
      return true;
   }

   public boolean onNestedPreFling(CoordinatorLayout var1, V var2, View var3, float var4, float var5) {
      return var3 == this.mNestedScrollingChildRef.get() && (this.mState != 3 || super.onNestedPreFling(var1, var2, var3, var4, var5));
   }

   public void onNestedPreScroll(CoordinatorLayout var1, V var2, View var3, int var4, int var5, int[] var6) {
      if(var3 == (View)this.mNestedScrollingChildRef.get()) {
         int var7 = var2.getTop();
         int var8 = var7 - var5;
         if(var5 > 0) {
            if(var8 < this.mMinOffset) {
               var6[1] = var7 - this.mMinOffset;
               ViewCompat.offsetTopAndBottom(var2, -var6[1]);
               this.setStateInternal(3);
            } else {
               var6[1] = var5;
               ViewCompat.offsetTopAndBottom(var2, -var5);
               this.setStateInternal(1);
            }
         } else if(var5 < 0 && !ViewCompat.canScrollVertically(var3, -1)) {
            if(var8 > this.mMaxOffset && !this.mHideable) {
               var6[1] = var7 - this.mMaxOffset;
               ViewCompat.offsetTopAndBottom(var2, -var6[1]);
               this.setStateInternal(4);
            } else {
               var6[1] = var5;
               ViewCompat.offsetTopAndBottom(var2, -var5);
               this.setStateInternal(1);
            }
         }

         this.dispatchOnSlide(var2.getTop());
         this.mLastNestedScrollDy = var5;
         this.mNestedScrolled = true;
      }
   }

   public void onRestoreInstanceState(CoordinatorLayout var1, V var2, Parcelable var3) {
      BottomSheetBehavior.SavedState var4 = (BottomSheetBehavior.SavedState)var3;
      super.onRestoreInstanceState(var1, var2, var4.getSuperState());
      if(var4.state != 1 && var4.state != 2) {
         this.mState = var4.state;
      } else {
         this.mState = 4;
      }
   }

   public Parcelable onSaveInstanceState(CoordinatorLayout var1, V var2) {
      return new BottomSheetBehavior.SavedState(super.onSaveInstanceState(var1, var2), this.mState);
   }

   public boolean onStartNestedScroll(CoordinatorLayout var1, V var2, View var3, View var4, int var5) {
      this.mLastNestedScrollDy = 0;
      this.mNestedScrolled = false;
      int var6 = var5 & 2;
      boolean var7 = false;
      if(var6 != 0) {
         var7 = true;
      }

      return var7;
   }

   public void onStopNestedScroll(CoordinatorLayout var1, V var2, View var3) {
      if(var2.getTop() == this.mMinOffset) {
         this.setStateInternal(3);
      } else if(var3 == this.mNestedScrollingChildRef.get() && this.mNestedScrolled) {
         int var4;
         byte var5;
         if(this.mLastNestedScrollDy > 0) {
            var4 = this.mMinOffset;
            var5 = 3;
         } else if(this.mHideable && this.shouldHide(var2, this.getYVelocity())) {
            var4 = this.mParentHeight;
            var5 = 5;
         } else if(this.mLastNestedScrollDy == 0) {
            int var6 = var2.getTop();
            if(Math.abs(var6 - this.mMinOffset) < Math.abs(var6 - this.mMaxOffset)) {
               var4 = this.mMinOffset;
               var5 = 3;
            } else {
               var4 = this.mMaxOffset;
               var5 = 4;
            }
         } else {
            var4 = this.mMaxOffset;
            var5 = 4;
         }

         if(this.mViewDragHelper.smoothSlideViewTo(var2, var2.getLeft(), var4)) {
            this.setStateInternal(2);
            ViewCompat.postOnAnimation(var2, new BottomSheetBehavior.SettleRunnable(var2, var5));
         } else {
            this.setStateInternal(var5);
         }

         this.mNestedScrolled = false;
         return;
      }

   }

   public boolean onTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
      byte var4 = 1;
      if(!var2.isShown()) {
         var4 = 0;
      } else {
         int var5 = MotionEventCompat.getActionMasked(var3);
         if(this.mState != var4 || var5 != 0) {
            this.mViewDragHelper.processTouchEvent(var3);
            if(var5 == 0) {
               this.reset();
            }

            if(this.mVelocityTracker == null) {
               this.mVelocityTracker = VelocityTracker.obtain();
            }

            this.mVelocityTracker.addMovement(var3);
            if(var5 == 2 && Math.abs((float)this.mInitialY - var3.getY()) > (float)this.mViewDragHelper.getTouchSlop()) {
               this.mViewDragHelper.captureChildView(var2, var3.getPointerId(var3.getActionIndex()));
               return (boolean)var4;
            }
         }
      }

      return (boolean)var4;
   }

   public void setBottomSheetCallback(BottomSheetBehavior.BottomSheetCallback var1) {
      this.mCallback = var1;
   }

   public void setHideable(boolean var1) {
      this.mHideable = var1;
   }

   public final void setPeekHeight(int var1) {
      this.mPeekHeight = Math.max(0, var1);
      this.mMaxOffset = this.mParentHeight - var1;
   }

   public final void setState(int var1) {
      View var2 = (View)this.mViewRef.get();
      if(var2 != null) {
         int var3;
         if(var1 == 4) {
            var3 = this.mMaxOffset;
         } else if(var1 == 3) {
            var3 = this.mMinOffset;
         } else {
            if(!this.mHideable || var1 != 5) {
               throw new IllegalArgumentException("Illegal state argument: " + var1);
            }

            var3 = this.mParentHeight;
         }

         this.setStateInternal(2);
         if(this.mViewDragHelper.smoothSlideViewTo(var2, var2.getLeft(), var3)) {
            ViewCompat.postOnAnimation(var2, new BottomSheetBehavior.SettleRunnable(var2, var1));
            return;
         }
      }

   }

   public abstract static class BottomSheetCallback {
      public abstract void onSlide(@NonNull View var1, float var2);

      public abstract void onStateChanged(@NonNull View var1, int var2);
   }

   protected static class SavedState extends BaseSavedState {
      public static final Creator<BottomSheetBehavior.SavedState> CREATOR = new Creator() {
         public BottomSheetBehavior.SavedState createFromParcel(Parcel var1) {
            return new BottomSheetBehavior.SavedState(var1);
         }

         public BottomSheetBehavior.SavedState[] newArray(int var1) {
            return new BottomSheetBehavior.SavedState[var1];
         }
      };
      final int state;

      public SavedState(Parcel var1) {
         super(var1);
         this.state = var1.readInt();
      }

      public SavedState(Parcelable var1, int var2) {
         super(var1);
         this.state = var2;
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.state);
      }
   }

   private class SettleRunnable implements Runnable {
      private final int mTargetState;
      private final View mView;

      SettleRunnable(View var2, int var3) {
         this.mView = var2;
         this.mTargetState = var3;
      }

      public void run() {
         if(BottomSheetBehavior.this.mViewDragHelper != null && BottomSheetBehavior.this.mViewDragHelper.continueSettling(true)) {
            ViewCompat.postOnAnimation(this.mView, this);
         } else {
            BottomSheetBehavior.this.setStateInternal(this.mTargetState);
         }
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface State {
   }
}
