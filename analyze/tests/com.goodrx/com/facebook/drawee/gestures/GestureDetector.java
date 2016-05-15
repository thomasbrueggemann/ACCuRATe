package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.internal.VisibleForTesting;

public class GestureDetector {
   @VisibleForTesting
   long mActionDownTime;
   @VisibleForTesting
   float mActionDownX;
   @VisibleForTesting
   float mActionDownY;
   @VisibleForTesting
   GestureDetector.ClickListener mClickListener;
   @VisibleForTesting
   boolean mIsCapturingGesture;
   @VisibleForTesting
   boolean mIsClickCandidate;
   @VisibleForTesting
   final float mSingleTapSlopPx;

   public GestureDetector(Context var1) {
      this.mSingleTapSlopPx = (float)ViewConfiguration.get(var1).getScaledTouchSlop();
      this.init();
   }

   public static GestureDetector newInstance(Context var0) {
      return new GestureDetector(var0);
   }

   public void init() {
      this.mClickListener = null;
      this.reset();
   }

   public boolean isCapturingGesture() {
      return this.mIsCapturingGesture;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      switch(var1.getAction()) {
      case 0:
         this.mIsCapturingGesture = true;
         this.mIsClickCandidate = true;
         this.mActionDownTime = var1.getEventTime();
         this.mActionDownX = var1.getX();
         this.mActionDownY = var1.getY();
         return true;
      case 1:
         this.mIsCapturingGesture = false;
         if(Math.abs(var1.getX() - this.mActionDownX) > this.mSingleTapSlopPx || Math.abs(var1.getY() - this.mActionDownY) > this.mSingleTapSlopPx) {
            this.mIsClickCandidate = false;
         }

         if(this.mIsClickCandidate && var1.getEventTime() - this.mActionDownTime <= (long)ViewConfiguration.getLongPressTimeout() && this.mClickListener != null) {
            this.mClickListener.onClick();
         }

         this.mIsClickCandidate = false;
         return true;
      case 2:
         if(Math.abs(var1.getX() - this.mActionDownX) <= this.mSingleTapSlopPx && Math.abs(var1.getY() - this.mActionDownY) <= this.mSingleTapSlopPx) {
            break;
         }

         this.mIsClickCandidate = false;
         return true;
      case 3:
         this.mIsCapturingGesture = false;
         this.mIsClickCandidate = false;
         return true;
      }

      return true;
   }

   public void reset() {
      this.mIsCapturingGesture = false;
      this.mIsClickCandidate = false;
   }

   public void setClickListener(GestureDetector.ClickListener var1) {
      this.mClickListener = var1;
   }

   public interface ClickListener {
      boolean onClick();
   }
}
