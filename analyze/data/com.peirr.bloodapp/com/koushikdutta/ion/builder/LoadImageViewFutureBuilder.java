package com.koushikdutta.ion.builder;

import android.widget.ImageView;
import com.koushikdutta.async.future.Future;

public interface LoadImageViewFutureBuilder {
   Future<ImageView> load(String var1);

   Future<ImageView> load(String var1, String var2);
}
