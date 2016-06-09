package android.support.design.widget;

import android.view.animation.Interpolator;

class ValueAnimatorCompat {
   private final ValueAnimatorCompat.Impl mImpl;

   ValueAnimatorCompat(ValueAnimatorCompat.Impl var1) {
      this.mImpl = var1;
   }

   public void cancel() {
      this.mImpl.cancel();
   }

   public void end() {
      this.mImpl.end();
   }

   public float getAnimatedFloatValue() {
      return this.mImpl.getAnimatedFloatValue();
   }

   public float getAnimatedFraction() {
      return this.mImpl.getAnimatedFraction();
   }

   public int getAnimatedIntValue() {
      return this.mImpl.getAnimatedIntValue();
   }

   public long getDuration() {
      return this.mImpl.getDuration();
   }

   public boolean isRunning() {
      return this.mImpl.isRunning();
   }

   public void setDuration(int var1) {
      this.mImpl.setDuration(var1);
   }

   public void setFloatValues(float var1, float var2) {
      this.mImpl.setFloatValues(var1, var2);
   }

   public void setIntValues(int var1, int var2) {
      this.mImpl.setIntValues(var1, var2);
   }

   public void setInterpolator(Interpolator var1) {
      this.mImpl.setInterpolator(var1);
   }

   public void setListener(final ValueAnimatorCompat.AnimatorListener var1) {
      if(var1 != null) {
         this.mImpl.setListener(new ValueAnimatorCompat.AnimatorListenerProxy() {
            public void onAnimationCancel() {
               var1.onAnimationCancel(ValueAnimatorCompat.this);
            }

            public void onAnimationEnd() {
               var1.onAnimationEnd(ValueAnimatorCompat.this);
            }

            public void onAnimationStart() {
               var1.onAnimationStart(ValueAnimatorCompat.this);
            }
         });
      } else {
         this.mImpl.setListener((ValueAnimatorCompat.AnimatorListenerProxy)null);
      }
   }

   public void setUpdateListener(final ValueAnimatorCompat.AnimatorUpdateListener var1) {
      if(var1 != null) {
         this.mImpl.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListenerProxy() {
            public void onAnimationUpdate() {
               var1.onAnimationUpdate(ValueAnimatorCompat.this);
            }
         });
      } else {
         this.mImpl.setUpdateListener((ValueAnimatorCompat.AnimatorUpdateListenerProxy)null);
      }
   }

   public void start() {
      this.mImpl.start();
   }

   interface AnimatorListener {
      void onAnimationCancel(ValueAnimatorCompat var1);

      void onAnimationEnd(ValueAnimatorCompat var1);

      void onAnimationStart(ValueAnimatorCompat var1);
   }

   static class AnimatorListenerAdapter implements ValueAnimatorCompat.AnimatorListener {
      public void onAnimationCancel(ValueAnimatorCompat var1) {
      }

      public void onAnimationEnd(ValueAnimatorCompat var1) {
      }

      public void onAnimationStart(ValueAnimatorCompat var1) {
      }
   }

   interface AnimatorUpdateListener {
      void onAnimationUpdate(ValueAnimatorCompat var1);
   }

   interface Creator {
      ValueAnimatorCompat createAnimator();
   }

   abstract static class Impl {
      abstract void cancel();

      abstract void end();

      abstract float getAnimatedFloatValue();

      abstract float getAnimatedFraction();

      abstract int getAnimatedIntValue();

      abstract long getDuration();

      abstract boolean isRunning();

      abstract void setDuration(int var1);

      abstract void setFloatValues(float var1, float var2);

      abstract void setIntValues(int var1, int var2);

      abstract void setInterpolator(Interpolator var1);

      abstract void setListener(ValueAnimatorCompat.AnimatorListenerProxy var1);

      abstract void setUpdateListener(ValueAnimatorCompat.AnimatorUpdateListenerProxy var1);

      abstract void start();
   }

   interface AnimatorListenerProxy {
      void onAnimationCancel();

      void onAnimationEnd();

      void onAnimationStart();
   }

   interface AnimatorUpdateListenerProxy {
      void onAnimationUpdate();
   }
}
