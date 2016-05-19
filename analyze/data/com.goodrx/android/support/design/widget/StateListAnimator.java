package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class StateListAnimator {
   private AnimationListener mAnimationListener = new AnimationListener() {
      public void onAnimationEnd(Animation var1) {
         if(StateListAnimator.this.mRunningAnimation == var1) {
            StateListAnimator.this.mRunningAnimation = null;
         }

      }

      public void onAnimationRepeat(Animation var1) {
      }

      public void onAnimationStart(Animation var1) {
      }
   };
   private StateListAnimator.Tuple mLastMatch = null;
   private Animation mRunningAnimation = null;
   private final ArrayList<StateListAnimator.Tuple> mTuples = new ArrayList();
   private WeakReference<View> mViewRef;

   private void cancel() {
      if(this.mRunningAnimation != null) {
         View var1 = this.getTarget();
         if(var1 != null && var1.getAnimation() == this.mRunningAnimation) {
            var1.clearAnimation();
         }

         this.mRunningAnimation = null;
      }

   }

   private void clearTarget() {
      View var1 = this.getTarget();
      int var2 = this.mTuples.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         Animation var4 = ((StateListAnimator.Tuple)this.mTuples.get(var3)).mAnimation;
         if(var1.getAnimation() == var4) {
            var1.clearAnimation();
         }
      }

      this.mViewRef = null;
      this.mLastMatch = null;
      this.mRunningAnimation = null;
   }

   private void start(StateListAnimator.Tuple var1) {
      this.mRunningAnimation = var1.mAnimation;
      View var2 = this.getTarget();
      if(var2 != null) {
         var2.startAnimation(this.mRunningAnimation);
      }

   }

   public void addState(int[] var1, Animation var2) {
      StateListAnimator.Tuple var3 = new StateListAnimator.Tuple(var1, var2, null);
      var2.setAnimationListener(this.mAnimationListener);
      this.mTuples.add(var3);
   }

   Animation getRunningAnimation() {
      return this.mRunningAnimation;
   }

   View getTarget() {
      return this.mViewRef == null?null:(View)this.mViewRef.get();
   }

   ArrayList<StateListAnimator.Tuple> getTuples() {
      return this.mTuples;
   }

   public void jumpToCurrentState() {
      if(this.mRunningAnimation != null) {
         View var1 = this.getTarget();
         if(var1 != null && var1.getAnimation() == this.mRunningAnimation) {
            var1.clearAnimation();
         }
      }

   }

   void setState(int[] var1) {
      int var2 = this.mTuples.size();
      int var3 = 0;

      StateListAnimator.Tuple var4;
      while(true) {
         var4 = null;
         if(var3 >= var2) {
            break;
         }

         StateListAnimator.Tuple var6 = (StateListAnimator.Tuple)this.mTuples.get(var3);
         if(StateSet.stateSetMatches(var6.mSpecs, var1)) {
            var4 = var6;
            break;
         }

         ++var3;
      }

      if(var4 != this.mLastMatch) {
         if(this.mLastMatch != null) {
            this.cancel();
         }

         this.mLastMatch = var4;
         View var5 = (View)this.mViewRef.get();
         if(var4 != null && var5 != null && var5.getVisibility() == 0) {
            this.start(var4);
            return;
         }
      }

   }

   void setTarget(View var1) {
      View var2 = this.getTarget();
      if(var2 != var1) {
         if(var2 != null) {
            this.clearTarget();
         }

         if(var1 != null) {
            this.mViewRef = new WeakReference(var1);
            return;
         }
      }

   }

   static class Tuple {
      final Animation mAnimation;
      final int[] mSpecs;

      private Tuple(int[] var1, Animation var2) {
         this.mSpecs = var1;
         this.mAnimation = var2;
      }

      // $FF: synthetic method
      Tuple(int[] var1, Animation var2, Object var3) {
         this(var1, var2);
      }

      Animation getAnimation() {
         return this.mAnimation;
      }

      int[] getSpecs() {
         return this.mSpecs;
      }
   }
}
