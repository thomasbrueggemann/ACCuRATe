package com.koushikdutta.ion.bitmap;

import android.graphics.Bitmap;

public interface Transform {
   String key();

   Bitmap transform(Bitmap var1);
}
