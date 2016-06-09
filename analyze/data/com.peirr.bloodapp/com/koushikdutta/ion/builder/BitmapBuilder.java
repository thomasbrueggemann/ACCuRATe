package com.koushikdutta.ion.builder;

import com.koushikdutta.ion.bitmap.Transform;

public interface BitmapBuilder<B extends BitmapBuilder<?>> {
   B centerCrop();

   B centerInside();

   B resize(int var1, int var2);

   B transform(Transform var1);
}
