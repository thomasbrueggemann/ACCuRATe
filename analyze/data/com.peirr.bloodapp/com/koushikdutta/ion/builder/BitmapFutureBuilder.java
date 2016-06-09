package com.koushikdutta.ion.builder;

import android.graphics.Bitmap;
import com.koushikdutta.async.future.Future;

public interface BitmapFutureBuilder {
   Future<Bitmap> asBitmap();
}
