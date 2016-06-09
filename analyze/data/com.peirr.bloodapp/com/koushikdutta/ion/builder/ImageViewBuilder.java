package com.koushikdutta.ion.builder;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;

public interface ImageViewBuilder<I extends ImageViewBuilder<?>> {
   I animateIn(int var1);

   I animateIn(Animation var1);

   I animateLoad(int var1);

   I animateLoad(Animation var1);

   I error(int var1);

   I error(Drawable var1);

   I placeholder(int var1);

   I placeholder(Drawable var1);
}
