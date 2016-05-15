package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public interface BitmapDisplayer {
   void display(Bitmap var1, ImageAware var2, LoadedFrom var3);
}
