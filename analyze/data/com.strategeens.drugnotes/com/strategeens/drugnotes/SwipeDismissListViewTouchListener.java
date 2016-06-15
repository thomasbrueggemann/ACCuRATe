package com.strategeens.drugnotes;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SwipeDismissListViewTouchListener implements OnTouchListener {
   private long mAnimationTime;
   private SwipeDismissListViewTouchListener.DismissCallbacks mCallbacks;
   private int mDismissAnimationRefCount = 0;
   private int mDownPosition;
   private View mDownView;
   private float mDownX;
   private float mDownY;
   private ListView mListView;
   private int mMaxFlingVelocity;
   private int mMinFlingVelocity;
   private boolean mPaused;
   private List<SwipeDismissListViewTouchListener.PendingDismissData> mPendingDismisses = new ArrayList();
   private int mSlop;
   private boolean mSwiping;
   private int mSwipingSlop;
   private VelocityTracker mVelocityTracker;
   private int mViewWidth = 1;

   public SwipeDismissListViewTouchListener(ListView var1, SwipeDismissListViewTouchListener.DismissCallbacks var2) {
      ViewConfiguration var3 = ViewConfiguration.get(var1.getContext());
      this.mSlop = var3.getScaledTouchSlop();
      this.mMinFlingVelocity = 16 * var3.getScaledMinimumFlingVelocity();
      this.mMaxFlingVelocity = var3.getScaledMaximumFlingVelocity();
      this.mAnimationTime = (long)var1.getContext().getResources().getInteger(17694720);
      this.mListView = var1;
      this.mCallbacks = var2;
   }

   private void performDismiss(final View var1, int var2) {
      final LayoutParams var3 = var1.getLayoutParams();
      final int var4 = var1.getHeight();
      ValueAnimator var5 = ValueAnimator.ofInt(new int[]{var4, 1}).setDuration(this.mAnimationTime);
      var5.addListener(new AnimatorListenerAdapter() {
         public void onAnimationEnd(Animator var1) {
            SwipeDismissListViewTouchListener var2 = SwipeDismissListViewTouchListener.this;
            var2.mDismissAnimationRefCount = -1 + var2.mDismissAnimationRefCount;
            if(SwipeDismissListViewTouchListener.this.mDismissAnimationRefCount == 0) {
               Collections.sort(SwipeDismissListViewTouchListener.this.mPendingDismisses);
               int[] var3 = new int[SwipeDismissListViewTouchListener.this.mPendingDismisses.size()];

               for(int var4x = -1 + SwipeDismissListViewTouchListener.this.mPendingDismisses.size(); var4x >= 0; --var4x) {
                  var3[var4x] = ((SwipeDismissListViewTouchListener.PendingDismissData)SwipeDismissListViewTouchListener.this.mPendingDismisses.get(var4x)).position;
               }

               SwipeDismissListViewTouchListener.this.mCallbacks.onDismiss(SwipeDismissListViewTouchListener.this.mListView, var3);
               SwipeDismissListViewTouchListener.this.mDownPosition = -1;
               Iterator var5 = SwipeDismissListViewTouchListener.this.mPendingDismisses.iterator();

               while(var5.hasNext()) {
                  SwipeDismissListViewTouchListener.PendingDismissData var6 = (SwipeDismissListViewTouchListener.PendingDismissData)var5.next();
                  var6.view.setAlpha(1.0F);
                  var6.view.setTranslationX(0.0F);
                  LayoutParams var7 = var6.view.getLayoutParams();
                  var7.height = var4;
                  var6.view.setLayoutParams(var7);
               }

               long var8 = SystemClock.uptimeMillis();
               MotionEvent var10 = MotionEvent.obtain(var8, var8, 3, 0.0F, 0.0F, 0);
               SwipeDismissListViewTouchListener.this.mListView.dispatchTouchEvent(var10);
               SwipeDismissListViewTouchListener.this.mPendingDismisses.clear();
            }

         }
      });
      var5.addUpdateListener(new AnimatorUpdateListener() {
         public void onAnimationUpdate(ValueAnimator var1x) {
            var3.height = ((Integer)var1x.getAnimatedValue()).intValue();
            var1.setLayoutParams(var3);
         }
      });
      this.mPendingDismisses.add(new SwipeDismissListViewTouchListener.PendingDismissData(var2, var1));
      var5.start();
   }

   public OnScrollListener makeScrollListener() {
      return new OnScrollListener() {
         public void onScroll(AbsListView var1, int var2, int var3, int var4) {
         }

         public void onScrollStateChanged(AbsListView var1, int var2) {
            byte var3 = 1;
            SwipeDismissListViewTouchListener var4 = SwipeDismissListViewTouchListener.this;
            if(var2 == var3) {
               var3 = 0;
            }

            var4.setEnabled((boolean)var3);
         }
      };
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      if(this.mViewWidth < 2) {
         this.mViewWidth = this.mListView.getWidth();
      }

      switch(var2.getActionMasked()) {
      case 0:
         if(this.mPaused) {
            return false;
         }

         Rect var29 = new Rect();
         int var30 = this.mListView.getChildCount();
         int[] var31 = new int[2];
         this.mListView.getLocationOnScreen(var31);
         int var32 = (int)var2.getRawX() - var31[0];
         int var33 = (int)var2.getRawY() - var31[1];

         for(int var34 = 0; var34 < var30; ++var34) {
            View var35 = this.mListView.getChildAt(var34);
            var35.getHitRect(var29);
            if(var29.contains(var32, var33)) {
               this.mDownView = var35;
               break;
            }
         }

         if(this.mDownView != null) {
            this.mDownX = var2.getRawX();
            this.mDownY = var2.getRawY();
            this.mDownPosition = this.mListView.getPositionForView(this.mDownView);
            if(this.mCallbacks.canDismiss(this.mDownPosition)) {
               this.mVelocityTracker = VelocityTracker.obtain();
               this.mVelocityTracker.addMovement(var2);
            } else {
               this.mDownView = null;
            }
         }

         return false;
      case 1:
         if(this.mVelocityTracker != null) {
            float var8 = var2.getRawX() - this.mDownX;
            this.mVelocityTracker.addMovement(var2);
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float var9 = this.mVelocityTracker.getXVelocity();
            float var10 = Math.abs(var9);
            float var11 = Math.abs(this.mVelocityTracker.getYVelocity());
            boolean var13;
            boolean var14;
            if(Math.abs(var8) > (float)(this.mViewWidth / 2) && this.mSwiping) {
               var13 = true;
               if(var8 > 0.0F) {
                  var14 = true;
               } else {
                  var14 = false;
               }
            } else {
               float var36;
               int var12 = (var36 = (float)this.mMinFlingVelocity - var10) == 0.0F?0:(var36 < 0.0F?-1:1);
               var13 = false;
               var14 = false;
               if(var12 <= 0) {
                  float var37;
                  int var15 = (var37 = var10 - (float)this.mMaxFlingVelocity) == 0.0F?0:(var37 < 0.0F?-1:1);
                  var13 = false;
                  var14 = false;
                  if(var15 <= 0) {
                     float var38;
                     int var16 = (var38 = var11 - var10) == 0.0F?0:(var38 < 0.0F?-1:1);
                     var13 = false;
                     var14 = false;
                     if(var16 < 0) {
                        boolean var17 = this.mSwiping;
                        var13 = false;
                        var14 = false;
                        if(var17) {
                           boolean var18;
                           if(var9 < 0.0F) {
                              var18 = true;
                           } else {
                              var18 = false;
                           }

                           boolean var19;
                           if(var8 < 0.0F) {
                              var19 = true;
                           } else {
                              var19 = false;
                           }

                           if(var18 == var19) {
                              var13 = true;
                           } else {
                              var13 = false;
                           }

                           if(this.mVelocityTracker.getXVelocity() > 0.0F) {
                              var14 = true;
                           } else {
                              var14 = false;
                           }
                        }
                     }
                  }
               }
            }

            if(var13 && this.mDownPosition != -1) {
               final View var21 = this.mDownView;
               final int var22 = this.mDownPosition;
               ++this.mDismissAnimationRefCount;
               ViewPropertyAnimator var23 = this.mDownView.animate();
               int var24;
               if(var14) {
                  var24 = this.mViewWidth;
               } else {
                  var24 = -this.mViewWidth;
               }

               ViewPropertyAnimator var25 = var23.translationX((float)var24).alpha(0.0F).setDuration(this.mAnimationTime);
               AnimatorListenerAdapter var26 = new AnimatorListenerAdapter() {
                  public void onAnimationEnd(Animator var1) {
                     SwipeDismissListViewTouchListener.this.performDismiss(var21, var22);
                  }
               };
               var25.setListener(var26);
            } else {
               this.mDownView.animate().translationX(0.0F).alpha(1.0F).setDuration(this.mAnimationTime).setListener((AnimatorListener)null);
            }

            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mDownX = 0.0F;
            this.mDownY = 0.0F;
            this.mDownView = null;
            this.mDownPosition = -1;
            this.mSwiping = false;
         }
         break;
      case 2:
         if(this.mVelocityTracker != null && !this.mPaused) {
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
               this.mListView.requestDisallowInterceptTouchEvent(true);
               MotionEvent var6 = MotionEvent.obtain(var2);
               var6.setAction(3 | var2.getActionIndex() << 8);
               this.mListView.onTouchEvent(var6);
               var6.recycle();
            }

            if(this.mSwiping) {
               this.mDownView.setTranslationX(var3 - (float)this.mSwipingSlop);
               this.mDownView.setAlpha(Math.max(0.0F, Math.min(1.0F, 1.0F - 2.0F * Math.abs(var3) / (float)this.mViewWidth)));
               return true;
            }
         }
         break;
      case 3:
         if(this.mVelocityTracker != null) {
            if(this.mDownView != null && this.mSwiping) {
               this.mDownView.animate().translationX(0.0F).alpha(1.0F).setDuration(this.mAnimationTime).setListener((AnimatorListener)null);
            }

            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mDownX = 0.0F;
            this.mDownY = 0.0F;
            this.mDownView = null;
            this.mDownPosition = -1;
            this.mSwiping = false;
         }
      }

      return false;
   }

   public void setEnabled(boolean var1) {
      boolean var2;
      if(var1) {
         var2 = false;
      } else {
         var2 = true;
      }

      this.mPaused = var2;
   }

   public interface DismissCallbacks {
      boolean canDismiss(int var1);

      void onDismiss(View var1, int[] var2);
   }

   class PendingDismissData implements Comparable<SwipeDismissListViewTouchListener.PendingDismissData> {
      public int position;
      public View view;

      public PendingDismissData(int var2, View var3) {
         this.position = var2;
         this.view = var3;
      }

      public int compareTo(SwipeDismissListViewTouchListener.PendingDismissData var1) {
         return var1.position - this.position;
      }
   }
}
