package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

public final class GestureDetectorCompat {
   private final GestureDetectorCompat.GestureDetectorCompatImpl mImpl;

   public GestureDetectorCompat(Context var1, OnGestureListener var2) {
      this(var1, var2, (Handler)null);
   }

   public GestureDetectorCompat(Context var1, OnGestureListener var2, Handler var3) {
      if(VERSION.SDK_INT > 17) {
         this.mImpl = new GestureDetectorCompat.GestureDetectorCompatImplJellybeanMr2(var1, var2, var3);
      } else {
         this.mImpl = new GestureDetectorCompat.GestureDetectorCompatImplBase(var1, var2, var3);
      }
   }

   public boolean isLongpressEnabled() {
      return this.mImpl.isLongpressEnabled();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.mImpl.onTouchEvent(var1);
   }

   public void setIsLongpressEnabled(boolean var1) {
      this.mImpl.setIsLongpressEnabled(var1);
   }

   public void setOnDoubleTapListener(OnDoubleTapListener var1) {
      this.mImpl.setOnDoubleTapListener(var1);
   }

   interface GestureDetectorCompatImpl {
      boolean isLongpressEnabled();

      boolean onTouchEvent(MotionEvent var1);

      void setIsLongpressEnabled(boolean var1);

      void setOnDoubleTapListener(OnDoubleTapListener var1);
   }

   static class GestureDetectorCompatImplBase implements GestureDetectorCompat.GestureDetectorCompatImpl {
      private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
      private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
      private static final int LONG_PRESS = 2;
      private static final int SHOW_PRESS = 1;
      private static final int TAP = 3;
      private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
      private boolean mAlwaysInBiggerTapRegion;
      private boolean mAlwaysInTapRegion;
      private MotionEvent mCurrentDownEvent;
      private boolean mDeferConfirmSingleTap;
      private OnDoubleTapListener mDoubleTapListener;
      private int mDoubleTapSlopSquare;
      private float mDownFocusX;
      private float mDownFocusY;
      private final Handler mHandler;
      private boolean mInLongPress;
      private boolean mIsDoubleTapping;
      private boolean mIsLongpressEnabled;
      private float mLastFocusX;
      private float mLastFocusY;
      private final OnGestureListener mListener;
      private int mMaximumFlingVelocity;
      private int mMinimumFlingVelocity;
      private MotionEvent mPreviousUpEvent;
      private boolean mStillDown;
      private int mTouchSlopSquare;
      private VelocityTracker mVelocityTracker;

      public GestureDetectorCompatImplBase(Context var1, OnGestureListener var2, Handler var3) {
         if(var3 != null) {
            this.mHandler = new GestureDetectorCompat.GestureHandler(var3);
         } else {
            this.mHandler = new GestureDetectorCompat.GestureHandler();
         }

         this.mListener = var2;
         if(var2 instanceof OnDoubleTapListener) {
            this.setOnDoubleTapListener((OnDoubleTapListener)var2);
         }

         this.init(var1);
      }

      private void cancel() {
         this.mHandler.removeMessages(1);
         this.mHandler.removeMessages(2);
         this.mHandler.removeMessages(3);
         this.mVelocityTracker.recycle();
         this.mVelocityTracker = null;
         this.mIsDoubleTapping = false;
         this.mStillDown = false;
         this.mAlwaysInTapRegion = false;
         this.mAlwaysInBiggerTapRegion = false;
         this.mDeferConfirmSingleTap = false;
         if(this.mInLongPress) {
            this.mInLongPress = false;
         }

      }

      private void cancelTaps() {
         this.mHandler.removeMessages(1);
         this.mHandler.removeMessages(2);
         this.mHandler.removeMessages(3);
         this.mIsDoubleTapping = false;
         this.mAlwaysInTapRegion = false;
         this.mAlwaysInBiggerTapRegion = false;
         this.mDeferConfirmSingleTap = false;
         if(this.mInLongPress) {
            this.mInLongPress = false;
         }

      }

      private void dispatchLongPress() {
         this.mHandler.removeMessages(3);
         this.mDeferConfirmSingleTap = false;
         this.mInLongPress = true;
         this.mListener.onLongPress(this.mCurrentDownEvent);
      }

      private void init(Context var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("Context must not be null");
         } else if(this.mListener == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
         } else {
            this.mIsLongpressEnabled = true;
            ViewConfiguration var2 = ViewConfiguration.get(var1);
            int var3 = var2.getScaledTouchSlop();
            int var4 = var2.getScaledDoubleTapSlop();
            this.mMinimumFlingVelocity = var2.getScaledMinimumFlingVelocity();
            this.mMaximumFlingVelocity = var2.getScaledMaximumFlingVelocity();
            this.mTouchSlopSquare = var3 * var3;
            this.mDoubleTapSlopSquare = var4 * var4;
         }
      }

      private boolean isConsideredDoubleTap(MotionEvent var1, MotionEvent var2, MotionEvent var3) {
         if(this.mAlwaysInBiggerTapRegion && var3.getEventTime() - var2.getEventTime() <= (long)DOUBLE_TAP_TIMEOUT) {
            int var4 = (int)var1.getX() - (int)var3.getX();
            int var5 = (int)var1.getY() - (int)var3.getY();
            if(var4 * var4 + var5 * var5 < this.mDoubleTapSlopSquare) {
               return true;
            }
         }

         return false;
      }

      public boolean isLongpressEnabled() {
         return this.mIsLongpressEnabled;
      }

      public boolean onTouchEvent(MotionEvent var1) {
         int var2 = var1.getAction();
         if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
         }

         this.mVelocityTracker.addMovement(var1);
         boolean var3;
         if((var2 & 255) == 6) {
            var3 = true;
         } else {
            var3 = false;
         }

         int var4;
         if(var3) {
            var4 = MotionEventCompat.getActionIndex(var1);
         } else {
            var4 = -1;
         }

         float var5 = 0.0F;
         float var6 = 0.0F;
         int var7 = MotionEventCompat.getPointerCount(var1);

         for(int var8 = 0; var8 < var7; ++var8) {
            if(var4 != var8) {
               var5 += MotionEventCompat.getX(var1, var8);
               var6 += MotionEventCompat.getY(var1, var8);
            }
         }

         int var9;
         if(var3) {
            var9 = var7 - 1;
         } else {
            var9 = var7;
         }

         float var10 = var5 / (float)var9;
         float var11 = var6 / (float)var9;
         int var12 = var2 & 255;
         boolean var13 = false;
         switch(var12) {
         case 0:
            OnDoubleTapListener var31 = this.mDoubleTapListener;
            boolean var32 = false;
            if(var31 != null) {
               boolean var35 = this.mHandler.hasMessages(3);
               if(var35) {
                  this.mHandler.removeMessages(3);
               }

               if(this.mCurrentDownEvent != null && this.mPreviousUpEvent != null && var35 && this.isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, var1)) {
                  this.mIsDoubleTapping = true;
                  var32 = false | this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | this.mDoubleTapListener.onDoubleTapEvent(var1);
               } else {
                  this.mHandler.sendEmptyMessageDelayed(3, (long)DOUBLE_TAP_TIMEOUT);
                  var32 = false;
               }
            }

            this.mLastFocusX = var10;
            this.mDownFocusX = var10;
            this.mLastFocusY = var11;
            this.mDownFocusY = var11;
            if(this.mCurrentDownEvent != null) {
               this.mCurrentDownEvent.recycle();
            }

            this.mCurrentDownEvent = MotionEvent.obtain(var1);
            this.mAlwaysInTapRegion = true;
            this.mAlwaysInBiggerTapRegion = true;
            this.mStillDown = true;
            this.mInLongPress = false;
            this.mDeferConfirmSingleTap = false;
            if(this.mIsLongpressEnabled) {
               this.mHandler.removeMessages(2);
               this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + (long)TAP_TIMEOUT + (long)LONGPRESS_TIMEOUT);
            }

            this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + (long)TAP_TIMEOUT);
            return var32 | this.mListener.onDown(var1);
         case 1:
            this.mStillDown = false;
            MotionEvent var14 = MotionEvent.obtain(var1);
            boolean var19;
            if(this.mIsDoubleTapping) {
               var19 = false | this.mDoubleTapListener.onDoubleTapEvent(var1);
            } else if(this.mInLongPress) {
               this.mHandler.removeMessages(3);
               this.mInLongPress = false;
               var19 = false;
            } else if(this.mAlwaysInTapRegion) {
               var19 = this.mListener.onSingleTapUp(var1);
               if(this.mDeferConfirmSingleTap && this.mDoubleTapListener != null) {
                  this.mDoubleTapListener.onSingleTapConfirmed(var1);
               }
            } else {
               label101: {
                  VelocityTracker var15 = this.mVelocityTracker;
                  int var16 = MotionEventCompat.getPointerId(var1, 0);
                  var15.computeCurrentVelocity(1000, (float)this.mMaximumFlingVelocity);
                  float var17 = VelocityTrackerCompat.getYVelocity(var15, var16);
                  float var18 = VelocityTrackerCompat.getXVelocity(var15, var16);
                  if(Math.abs(var17) <= (float)this.mMinimumFlingVelocity) {
                     float var44;
                     int var20 = (var44 = Math.abs(var18) - (float)this.mMinimumFlingVelocity) == 0.0F?0:(var44 < 0.0F?-1:1);
                     var19 = false;
                     if(var20 <= 0) {
                        break label101;
                     }
                  }

                  var19 = this.mListener.onFling(this.mCurrentDownEvent, var1, var18, var17);
               }
            }

            if(this.mPreviousUpEvent != null) {
               this.mPreviousUpEvent.recycle();
            }

            this.mPreviousUpEvent = var14;
            if(this.mVelocityTracker != null) {
               this.mVelocityTracker.recycle();
               this.mVelocityTracker = null;
            }

            this.mIsDoubleTapping = false;
            this.mDeferConfirmSingleTap = false;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            return var19;
         case 2:
            boolean var22 = this.mInLongPress;
            var13 = false;
            if(var22) {
               break;
            }

            float var23 = this.mLastFocusX - var10;
            float var24 = this.mLastFocusY - var11;
            if(this.mIsDoubleTapping) {
               return false | this.mDoubleTapListener.onDoubleTapEvent(var1);
            }

            if(this.mAlwaysInTapRegion) {
               int var27 = (int)(var10 - this.mDownFocusX);
               int var28 = (int)(var11 - this.mDownFocusY);
               int var29 = var27 * var27 + var28 * var28;
               int var30 = this.mTouchSlopSquare;
               var13 = false;
               if(var29 > var30) {
                  var13 = this.mListener.onScroll(this.mCurrentDownEvent, var1, var23, var24);
                  this.mLastFocusX = var10;
                  this.mLastFocusY = var11;
                  this.mAlwaysInTapRegion = false;
                  this.mHandler.removeMessages(3);
                  this.mHandler.removeMessages(1);
                  this.mHandler.removeMessages(2);
               }

               if(var29 > this.mTouchSlopSquare) {
                  this.mAlwaysInBiggerTapRegion = false;
                  return var13;
               }
               break;
            } else {
               if(Math.abs(var23) < 1.0F) {
                  float var45;
                  int var26 = (var45 = Math.abs(var24) - 1.0F) == 0.0F?0:(var45 < 0.0F?-1:1);
                  var13 = false;
                  if(var26 < 0) {
                     break;
                  }
               }

               boolean var25 = this.mListener.onScroll(this.mCurrentDownEvent, var1, var23, var24);
               this.mLastFocusX = var10;
               this.mLastFocusY = var11;
               return var25;
            }
         case 3:
            this.cancel();
            return false;
         case 4:
         default:
            break;
         case 5:
            this.mLastFocusX = var10;
            this.mDownFocusX = var10;
            this.mLastFocusY = var11;
            this.mDownFocusY = var11;
            this.cancelTaps();
            return false;
         case 6:
            this.mLastFocusX = var10;
            this.mDownFocusX = var10;
            this.mLastFocusY = var11;
            this.mDownFocusY = var11;
            this.mVelocityTracker.computeCurrentVelocity(1000, (float)this.mMaximumFlingVelocity);
            int var37 = MotionEventCompat.getActionIndex(var1);
            int var38 = MotionEventCompat.getPointerId(var1, var37);
            float var39 = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, var38);
            float var40 = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, var38);
            int var41 = 0;

            while(true) {
               var13 = false;
               if(var41 >= var7) {
                  break;
               }

               if(var41 != var37) {
                  int var43 = MotionEventCompat.getPointerId(var1, var41);
                  if(var39 * VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, var43) + var40 * VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, var43) < 0.0F) {
                     this.mVelocityTracker.clear();
                     return false;
                  }
               }

               ++var41;
            }
         }

         return var13;
      }

      public void setIsLongpressEnabled(boolean var1) {
         this.mIsLongpressEnabled = var1;
      }

      public void setOnDoubleTapListener(OnDoubleTapListener var1) {
         this.mDoubleTapListener = var1;
      }
   }

   private class GestureHandler extends Handler {
      GestureHandler() {
      }

      GestureHandler(Handler var2) {
         super(var2.getLooper());
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            GestureDetectorCompat.super.mListener.onShowPress(GestureDetectorCompat.super.mCurrentDownEvent);
            break;
         case 2:
            GestureDetectorCompat.super.dispatchLongPress();
            return;
         case 3:
            if(GestureDetectorCompat.super.mDoubleTapListener != null) {
               if(!GestureDetectorCompat.super.mStillDown) {
                  GestureDetectorCompat.super.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompat.super.mCurrentDownEvent);
                  return;
               }

               GestureDetectorCompat.super.mDeferConfirmSingleTap = true;
               return;
            }
            break;
         default:
            throw new RuntimeException("Unknown message " + var1);
         }

      }
   }

   static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompat.GestureDetectorCompatImpl {
      private final GestureDetector mDetector;

      public GestureDetectorCompatImplJellybeanMr2(Context var1, OnGestureListener var2, Handler var3) {
         this.mDetector = new GestureDetector(var1, var2, var3);
      }

      public boolean isLongpressEnabled() {
         return this.mDetector.isLongpressEnabled();
      }

      public boolean onTouchEvent(MotionEvent var1) {
         return this.mDetector.onTouchEvent(var1);
      }

      public void setIsLongpressEnabled(boolean var1) {
         this.mDetector.setIsLongpressEnabled(var1);
      }

      public void setOnDoubleTapListener(OnDoubleTapListener var1) {
         this.mDetector.setOnDoubleTapListener(var1);
      }
   }
}
