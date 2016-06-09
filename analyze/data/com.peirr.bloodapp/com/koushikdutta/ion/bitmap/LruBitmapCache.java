package com.koushikdutta.ion.bitmap;

import android.graphics.Bitmap;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.LruCache;

class LruBitmapCache extends LruCache<String, BitmapInfo> {
   public LruBitmapCache(int var1) {
      super(var1);
   }

   protected int sizeOf(String var1, BitmapInfo var2) {
      Bitmap var3 = var2.bitmap;
      return var3 == null?0:var3.getRowBytes() * var3.getHeight();
   }
}
