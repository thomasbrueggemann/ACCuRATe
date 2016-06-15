package com.strategeens.drugnotes;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;

public class SwipeDismissTouchListener implements OnTouchListener {
   private long mAnimationTime;
   private SwipeDismissTouchListener.DismissCallbacks mCallbacks;
   private float mDownX;
   private float mDownY;
   private int mMaxFlingVelocity;
   private int mMinFlingVelocity;
   private int mSlop;
   private boolean mSwiping;
   private int mSwipingSlop;
   private Object mToken;
   private float mTranslationX;
   private VelocityTracker mVelocityTracker;
   private View mView;
   private int mViewWidth = 1;

   public SwipeDismissTouchListener(View var1, Object var2, SwipeDismissTouchListener.DismissCallbacks var3) {
      ViewConfiguration var4 = ViewConfiguration.get(var1.getContext());
      this.mSlop = var4.getScaledTouchSlop();
      this.mMinFlingVelocity = 16 * var4.getScaledMinimumFlingVelocity();
      this.mMaxFlingVelocity = var4.getScaledMaximumFlingVelocity();
      this.mAnimationTime = (long)var1.getContext().getResources().getInteger(17694720);
      this.mView = var1;
      this.mToken = var2;
      this.mCallbacks = var3;
   }

   private void performDismiss() {
      final LayoutParams var1 = this.mView.getLayoutParams();
      final int var2 = this.mView.getHeight();
      ValueAnimator var3 = ValueAnimator.ofInt(new int[]{var2, 1}).setDuration(this.mAnimationTime);
      var3.addListener(new AnimatorListenerAdapter() {
         public void onAnimationEnd(Animator var1x) {
            SwipeDismissTouchListener.this.mCallbacks.onDismiss(SwipeDismissTouchListener.this.mView, SwipeDismissTouchListener.this.mToken);
            SwipeDismissTouchListener.this.mView.setAlpha(1.0F);
            SwipeDismissTouchListener.this.mView.setTranslationX(0.0F);
            var1.height = var2;
            SwipeDismissTouchListener.this.mView.setLayoutParams(var1);
         }
      });
      var3.addUpdateListener(new AnimatorUpdateListener() {
         public void onAnimationUpdate(ValueAnimator var1x) {
            var1.height = ((Integer)var1x.getAnimatedValue()).intValue();
            SwipeDismissTouchListener.this.mView.setLayoutParams(var1);
         }
      });
      var3.start();
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      var2.offsetLocation(this.mTranslationX, 0.0F);
      if(this.mViewWidth < 2) {
         this.mViewWidth = this.mView.getWidth();
      }

      switch(var2.getActionMasked()) {
      case 0:
         this.mDownX = var2.getRawX();
         this.mDownY = var2.getRawY();
         if(this.mCallbacks.canDismiss(this.mToken)) {
            this.mVelocityTracker = VelocityTracker.obtain();
            this.mVelocityTracker.addMovement(var2);
         }

         return false;
      case 1:
         if(this.mVelocityTracker != null) {
            float var9 = var2.getRawX() - this.mDownX;
            this.mVelocityTracker.addMovement(var2);
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float var10 = this.mVelocityTracker.getXVelocity();
            float var11 = Math.abs(var10);
            float var12 = Math.abs(this.mVelocityTracker.getYVelocity());
            boolean var14;
            boolean var15;
            if(Math.abs(var9) > (float)(this.mViewWidth / 2) && this.mSwiping) {
               var14 = true;
               if(var9 > 0.0F) {
                  var15 = true;
               } else {
                  var15 = false;
               }
            } else {
               float var25;
               int var13 = (var25 = (float)this.mMinFlingVelocity - var11) == 0.0F?0:(var25 < 0.0F?-1:1);
               var14 = false;
               var15 = false;
               if(var13 <= 0) {
                  float var26;
                  int var16 = (var26 = var11 - (float)this.mMaxFlingVelocity) == 0.0F?0:(var26 < 0.0F?-1:1);
                  var14 = false;
                  var15 = false;
                  if(var16 <= 0) {
                     float var27;
                     int var17 = (var27 = var12 - var11) == 0.0F?0:(var27 < 0.0F?-1:1);
                     var14 = false;
                     var15 = false;
                     if(var17 < 0) {
                        float var28;
                        int var18 = (var28 = var12 - var11) == 0.0F?0:(var28 < 0.0F?-1:1);
                        var14 = false;
                        var15 = false;
                        if(var18 < 0) {
                           boolean var19 = this.mSwiping;
                           var14 = false;
                           var15 = false;
                           if(var19) {
                              boolean var20;
                              if(var10 < 0.0F) {
                                 var20 = true;
                              } else {
                                 var20 = false;
                              }

                              boolean var21;
                              if(var9 < 0.0F) {
                                 var21 = true;
                              } else {
                                 var21 = false;
                              }

                              if(var20 == var21) {
                                 var14 = true;
                              } else {
                                 var14 = false;
                              }

                              if(this.mVelocityTracker.getXVelocity() > 0.0F) {
                                 var15 = true;
                              } else {
                                 var15 = false;
                              }
                           }
                        }
                     }
                  }
               }
            }

            if(var14) {
               ViewPropertyAnimator var23 = this.mView.animate();
               int var24;
               if(var15) {
                  var24 = this.mViewWidth;
               } else {
                  var24 = -this.mViewWidth;
               }

               var23.translationX((float)var24).alpha(0.0F).setDuration(this.mAnimationTime).setListener(new AnimatorListenerAdapter() {
                  public void onAnimationEnd(Animator var1) {
                     SwipeDismissTouchListener.this.performDismiss();
                  }
               });
            } else if(this.mSwiping) {
               this.mView.animate().translationX(0.0F).alpha(1.0F).setDuration(this.mAnimationTime).setListener((AnimatorListener)null);
            }

            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mTranslationX = 0.0F;
            this.mDownX = 0.0F;
            this.mDownY = 0.0F;
            this.mSwiping = false;
         }
         break;
      case 2:
         if(this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(var2);
            float var3 = var2.getRawX() - this.mDownX;
            float var4 = var2.getRawY() - this.mDownY;
            if(Math.abs(var3) > (float)this.mSlop && Math.abs(var4) < Math.abs(var3) / 2.0F) {
               this.mSwiping = true;
               int var5;
               if(var3 > 0.0F) {
                  var5 = this.mSlop;
               } else {
                  var5 = -this.mSlop;
               }

               this.mSwipingSlop = var5;
               this.mView.getParent().requestDisallowInterceptTouchEvent(true);
               MotionEvent var6 = MotionEvent.obtain(var2);
               var6.setAction(3 | var2.getActionIndex() << 8);
               this.mView.onTouchEvent(var6);
               var6.recycle();
            }

            if(this.mSwiping) {
               this.mTranslationX = var3;
               this.mView.setTranslationX(var3 - (float)this.mSwipingSlop);
               this.mView.setAlpha(Math.max(0.0F, Math.min(1.0F, 1.0F - 2.0F * Math.abs(var3) / (float)this.mViewWidth)));
               return true;
            }
         }
         break;
      case 3:
         if(this.mVelocityTracker != null) {
            this.mView.animate().translationX(0.0F).alpha(1.0F).setDuration(this.mAnimationTime).setListener((AnimatorListener)null);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mTranslationX = 0.0F;
            this.mDownX = 0.0F;
            this.mDownY = 0.0F;
            this.mSwiping = false;
         }
      }

      return false;
   }

   public interface DismissCallbacks {
      boolean canDismiss(Object var1);

      void onDismiss(View var1, Object var2);
   }
}
