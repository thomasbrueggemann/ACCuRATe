package com.facebook.imagepipeline.animated.base;

import android.graphics.drawable.Animatable;
import com.nineoldandroids.animation.ValueAnimator;

public interface AnimatableDrawable extends Animatable {
   ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener();

   ValueAnimator createValueAnimator();

   ValueAnimator createValueAnimator(int var1);
}
