package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.RectF;

public interface TransformCallback {
   void getRootBounds(RectF var1);

   void getTransform(Matrix var1);
}
