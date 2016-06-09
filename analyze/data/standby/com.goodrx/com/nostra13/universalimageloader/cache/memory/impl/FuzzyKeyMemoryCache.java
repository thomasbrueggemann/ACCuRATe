package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Comparator;

public class FuzzyKeyMemoryCache implements MemoryCache {
   private final MemoryCache cache;
   private final Comparator<String> keyComparator;

   public FuzzyKeyMemoryCache(MemoryCache var1, Comparator<String> var2) {
      this.cache = var1;
      this.keyComparator = var2;
   }

   public void clear() {
      this.cache.clear();
   }

   public Bitmap get(String var1) {
      return this.cache.get(var1);
   }

   public Collection<String> keys() {
      return this.cache.keys();
   }

   public boolean put(String param1, Bitmap param2) {
      // $FF: Couldn't be decompiled
   }

   public Bitmap remove(String var1) {
      return this.cache.remove(var1);
   }
}
