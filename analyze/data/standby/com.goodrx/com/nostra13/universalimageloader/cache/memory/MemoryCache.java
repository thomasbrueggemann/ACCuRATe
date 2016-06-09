package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import java.util.Collection;

public interface MemoryCache {
   void clear();

   Bitmap get(String var1);

   Collection<String> keys();

   boolean put(String var1, Bitmap var2);

   Bitmap remove(String var1);
}
