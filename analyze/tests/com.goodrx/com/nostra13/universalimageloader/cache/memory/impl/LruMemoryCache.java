package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.LinkedHashMap;

public class LruMemoryCache implements MemoryCache {
   private final LinkedHashMap<String, Bitmap> map;
   private final int maxSize;
   private int size;

   public LruMemoryCache(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else {
         this.maxSize = var1;
         this.map = new LinkedHashMap(0, 0.75F, true);
      }
   }

   private int sizeOf(String var1, Bitmap var2) {
      return var2.getRowBytes() * var2.getHeight();
   }

   private void trimToSize(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void clear() {
      this.trimToSize(-1);
   }

   public final Bitmap get(String param1) {
      // $FF: Couldn't be decompiled
   }

   public Collection<String> keys() {
      // $FF: Couldn't be decompiled
   }

   public final boolean put(String param1, Bitmap param2) {
      // $FF: Couldn't be decompiled
   }

   public final Bitmap remove(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final String toString() {
      synchronized(this){}

      String var3;
      try {
         Object[] var2 = new Object[]{Integer.valueOf(this.maxSize)};
         var3 = String.format("LruCache[maxSize=%d]", var2);
      } finally {
         ;
      }

      return var3;
   }
}
