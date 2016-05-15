package android.support.design.widget;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Animation.AnimationListener;

class AnimationUtils {
   static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
   static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
   static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
   static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
   static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();

   static float lerp(float var0, float var1, float var2) {
      return var0 + var2 * (var1 - var0);
   }

   static int lerp(int var0, int var1, float var2) {
      return var0 + Math.round(var2 * (float)(var1 - var0));
   }

   static class AnimationListenerAdapter implements AnimationListener {
      public void onAnimationEnd(Animation var1) {
      }

      public void onAnimationRepeat(Animation var1) {
      }

      public void onAnimationStart(Animation var1) {
      }
   }
}
