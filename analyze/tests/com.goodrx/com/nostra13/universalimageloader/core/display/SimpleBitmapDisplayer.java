package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public final class SimpleBitmapDisplayer implements BitmapDisplayer {
   public void display(Bitmap var1, ImageAware var2, LoadedFrom var3) {
      var2.setImageBitmap(var1);
   }
}
