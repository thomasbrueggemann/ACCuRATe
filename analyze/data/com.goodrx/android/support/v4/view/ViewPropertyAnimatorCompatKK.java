package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;

class ViewPropertyAnimatorCompatKK {
   public static void setUpdateListener(final View var0, final ViewPropertyAnimatorUpdateListener var1) {
      AnimatorUpdateListener var2 = null;
      if(var1 != null) {
         var2 = new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator var1x) {
               var1.onAnimationUpdate(var0);
            }
         };
      }

      var0.animate().setUpdateListener(var2);
   }
}
