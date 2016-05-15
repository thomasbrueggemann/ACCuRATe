package com.goodrx.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

public class ViewUtils {
   public static void hide(final View var0) {
      if(var0.isShown()) {
         ObjectAnimator var1 = ObjectAnimator.ofFloat(var0, "alpha", new float[]{0.0F});
         var1.setDuration(500L);
         var1.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator var1) {
               super.onAnimationEnd(var1);
               var0.setVisibility(8);
            }
         });
         var1.start();
      }
   }

   public static void show(View var0) {
      show(var0, 1.0F);
   }

   public static void show(View var0, float var1) {
      if(!var0.isShown()) {
         var0.setVisibility(0);
         var0.setAlpha(0.0F);
         ObjectAnimator var2 = ObjectAnimator.ofFloat(var0, "alpha", new float[]{var1});
         var2.setDuration(500L);
         var2.start();
      }
   }
}
