package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
   private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5F;
   private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0F;
   private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5F;
   public static final int STATE_DRAGGING = 1;
   public static final int STATE_IDLE = 0;
   public static final int STATE_SETTLING = 2;
   public static final int SWIPE_DIRECTION_ANY = 2;
   public static final int SWIPE_DIRECTION_END_TO_START = 1;
   public static final int SWIPE_DIRECTION_START_TO_END;
   private float mAlphaEndSwipeDistance = 0.5F;
   private float mAlphaStartSwipeDistance = 0.0F;
   private final ViewDragHelper.Callback mDragCallback = new ViewDragHelper.Callback() {
      private int mOriginalCapturedViewLeft;

      private boolean shouldDismiss(View var1, float var2) {
         if(var2 != 0.0F) {
            boolean var5;
            if(ViewCompat.getLayoutDirection(var1) == 1) {
               var5 = true;
            } else {
               var5 = false;
            }

            if(SwipeDismissBehavior.this.mSwipeDirection != 2) {
               if(SwipeDismissBehavior.this.mSwipeDirection == 0) {
                  if(var5) {
                     if(var2 >= 0.0F) {
                        return false;
                     }
                  } else if(var2 <= 0.0F) {
                     return false;
                  }
               } else {
                  if(SwipeDismissBehavior.this.mSwipeDirection != 1) {
                     return false;
                  }

                  if(var5) {
                     if(var2 <= 0.0F) {
                        return false;
                     }
                  } else if(var2 >= 0.0F) {
                     return false;
                  }
               }
            }
         } else {
            int var3 = var1.getLeft() - this.mOriginalCapturedViewLeft;
            int var4 = Math.round((float)var1.getWidth() * SwipeDismissBehavior.this.mDragDismissThreshold);
            if(Math.abs(var3) < var4) {
               return false;
            }
         }

         return true;
      }

      public int clampViewPositionHorizontal(View var1, int var2, int var3) {
         boolean var4;
         if(ViewCompat.getLayoutDirection(var1) == 1) {
            var4 = true;
         } else {
            var4 = false;
         }

         int var5;
         int var6;
         if(SwipeDismissBehavior.this.mSwipeDirection == 0) {
            if(var4) {
               var5 = this.mOriginalCapturedViewLeft - var1.getWidth();
               var6 = this.mOriginalCapturedViewLeft;
            } else {
               var5 = this.mOriginalCapturedViewLeft;
               var6 = this.mOriginalCapturedViewLeft + var1.getWidth();
            }
         } else if(SwipeDismissBehavior.this.mSwipeDirection == 1) {
            if(var4) {
               var5 = this.mOriginalCapturedViewLeft;
               var6 = this.mOriginalCapturedViewLeft + var1.getWidth();
            } else {
               var5 = this.mOriginalCapturedViewLeft - var1.getWidth();
               var6 = this.mOriginalCapturedViewLeft;
            }
         } else {
            var5 = this.mOriginalCapturedViewLeft - var1.getWidth();
            var6 = this.mOriginalCapturedViewLeft + var1.getWidth();
         }

         return SwipeDismissBehavior.clamp(var5, var2, var6);
      }

      public int clampViewPositionVertical(View var1, int var2, int var3) {
         return var1.getTop();
      }

      public int getViewHorizontalDragRange(View var1) {
         return var1.getWidth();
      }

      public void onViewCaptured(View var1, int var2) {
         this.mOriginalCapturedViewLeft = var1.getLeft();
         ViewParent var3 = var1.getParent();
         if(var3 != null) {
            var3.requestDisallowInterceptTouchEvent(true);
         }

      }

      public void onViewDragStateChanged(int var1) {
         if(SwipeDismissBehavior.this.mListener != null) {
            SwipeDismissBehavior.this.mListener.onDragStateChanged(var1);
         }

      }

      public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
         float var6 = (float)this.mOriginalCapturedViewLeft + (float)var1.getWidth() * SwipeDismissBehavior.this.mAlphaStartSwipeDistance;
         float var7 = (float)this.mOriginalCapturedViewLeft + (float)var1.getWidth() * SwipeDismissBehavior.this.mAlphaEndSwipeDistance;
         if((float)var2 <= var6) {
            ViewCompat.setAlpha(var1, 1.0F);
         } else if((float)var2 >= var7) {
            ViewCompat.setAlpha(var1, 0.0F);
         } else {
            ViewCompat.setAlpha(var1, SwipeDismissBehavior.clamp(0.0F, 1.0F - SwipeDismissBehavior.fraction(var6, var7, (float)var2), 1.0F));
         }
      }

      public void onViewReleased(View var1, float var2, float var3) {
         ViewParent var4 = var1.getParent();
         if(var4 != null) {
            var4.requestDisallowInterceptTouchEvent(false);
         }

         int var5 = var1.getWidth();
         int var6;
         boolean var7;
         if(this.shouldDismiss(var1, var2)) {
            if(var1.getLeft() < this.mOriginalCapturedViewLeft) {
               var6 = this.mOriginalCapturedViewLeft - var5;
            } else {
               var6 = var5 + this.mOriginalCapturedViewLeft;
            }

            var7 = true;
         } else {
            var6 = this.mOriginalCapturedViewLeft;
            var7 = false;
         }

         if(SwipeDismissBehavior.this.mViewDragHelper.settleCapturedViewAt(var6, var1.getTop())) {
            ViewCompat.postOnAnimation(var1, SwipeDismissBehavior.this.new SettleRunnable(var1, var7));
         } else if(var7 && SwipeDismissBehavior.this.mListener != null) {
            SwipeDismissBehavior.this.mListener.onDismiss(var1);
            return;
         }

      }

      public boolean tryCaptureView(View var1, int var2) {
         return SwipeDismissBehavior.this.canSwipeDismissView(var1);
      }
   };
   private float mDragDismissThreshold = 0.5F;
   private boolean mIgnoreEvents;
   private SwipeDismissBehavior.OnDismissListener mListener;
   private float mSensitivity = 0.0F;
   private boolean mSensitivitySet;
   private int mSwipeDirection = 2;
   private ViewDragHelper mViewDragHelper;

   private static float clamp(float var0, float var1, float var2) {
      return Math.min(Math.max(var0, var1), var2);
   }

   private static int clamp(int var0, int var1, int var2) {
      return Math.min(Math.max(var0, var1), var2);
   }

   private void ensureViewDragHelper(ViewGroup var1) {
      if(this.mViewDragHelper == null) {
         ViewDragHelper var2;
         if(this.mSensitivitySet) {
            var2 = ViewDragHelper.create(var1, this.mSensitivity, this.mDragCallback);
         } else {
            var2 = ViewDragHelper.create(var1, this.mDragCallback);
         }

         this.mViewDragHelper = var2;
      }

   }

   static float fraction(float var0, float var1, float var2) {
      return (var2 - var0) / (var1 - var0);
   }

   public boolean canSwipeDismissView(@NonNull View var1) {
      return true;
   }

   public int getDragState() {
      return this.mViewDragHelper != null?this.mViewDragHelper.getViewDragState():0;
   }

   public boolean onInterceptTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
      switch(MotionEventCompat.getActionMasked(var3)) {
      case 1:
      case 3:
         if(this.mIgnoreEvents) {
            this.mIgnoreEvents = false;
            return false;
         }
         break;
      case 2:
      default:
         boolean var4;
         if(!var1.isPointInChildBounds(var2, (int)var3.getX(), (int)var3.getY())) {
            var4 = true;
         } else {
            var4 = false;
         }

         this.mIgnoreEvents = var4;
      }

      if(this.mIgnoreEvents) {
         return false;
      } else {
         this.ensureViewDragHelper(var1);
         return this.mViewDragHelper.shouldInterceptTouchEvent(var3);
      }
   }

   public boolean onTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
      if(this.mViewDragHelper != null) {
         this.mViewDragHelper.processTouchEvent(var3);
         return true;
      } else {
         return false;
      }
   }

   public void setDragDismissDistance(float var1) {
      this.mDragDismissThreshold = clamp(0.0F, var1, 1.0F);
   }

   public void setEndAlphaSwipeDistance(float var1) {
      this.mAlphaEndSwipeDistance = clamp(0.0F, var1, 1.0F);
   }

   public void setListener(SwipeDismissBehavior.OnDismissListener var1) {
      this.mListener = var1;
   }

   public void setSensitivity(float var1) {
      this.mSensitivity = var1;
      this.mSensitivitySet = true;
   }

   public void setStartAlphaSwipeDistance(float var1) {
      this.mAlphaStartSwipeDistance = clamp(0.0F, var1, 1.0F);
   }

   public void setSwipeDirection(int var1) {
      this.mSwipeDirection = var1;
   }

   public interface OnDismissListener {
      void onDismiss(View var1);

      void onDragStateChanged(int var1);
   }

   private class SettleRunnable implements Runnable {
      private final boolean mDismiss;
      private final View mView;

      SettleRunnable(View var2, boolean var3) {
         this.mView = var2;
         this.mDismiss = var3;
      }

      public void run() {
         if(SwipeDismissBehavior.this.mViewDragHelper != null && SwipeDismissBehavior.this.mViewDragHelper.continueSettling(true)) {
            ViewCompat.postOnAnimation(this.mView, this);
         } else if(this.mDismiss && SwipeDismissBehavior.this.mListener != null) {
            SwipeDismissBehavior.this.mListener.onDismiss(this.mView);
            return;
         }

      }
   }
}
