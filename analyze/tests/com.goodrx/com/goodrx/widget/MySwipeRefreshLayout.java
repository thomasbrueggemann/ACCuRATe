package com.goodrx.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MySwipeRefreshLayout extends SwipeRefreshLayout {
   private int mActivePointerId;

   public MySwipeRefreshLayout(Context var1) {
      super(var1);
   }

   public MySwipeRefreshLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
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

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      if(var1.getAction() == 3) {
         int var2 = MotionEventCompat.getPointerCount(var1);
         this.mActivePointerId = MotionEventCompat.getPointerId(var1, MotionEventCompat.getActionIndex(var1));
         int var3 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
         if(var3 <= -1 || var3 >= var2) {
            return true;
         }

         super.onInterceptTouchEvent(var1);
      } else {
         if(var1.getAction() == 5 && super.onInterceptTouchEvent(var1)) {
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, MotionEventCompat.getActionIndex(var1));
            return false;
         }

         if(var1.getAction() == 6 && super.onInterceptTouchEvent(var1)) {
            this.onSecondaryPointerUp(var1);
            return false;
         }

         if(var1.getAction() == 0 && super.onInterceptTouchEvent(var1)) {
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
            return false;
         }
      }

      return super.onInterceptTouchEvent(var1);
   }
}
