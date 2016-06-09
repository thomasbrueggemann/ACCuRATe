package com.koushikdutta.ion.bitmap;

import android.graphics.Bitmap;

public class BitmapInfo {
   public Bitmap bitmap;
   public long drawTime;
   public String key;
   public long loadTime = System.currentTimeMillis();
   public int loadedFrom;
}
