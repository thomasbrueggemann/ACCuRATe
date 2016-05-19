package com.facebook.cache.common;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;

public class SimpleCacheKey implements CacheKey {
   final String mKey;

   public SimpleCacheKey(String var1) {
      this.mKey = (String)Preconditions.checkNotNull(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof SimpleCacheKey) {
         SimpleCacheKey var2 = (SimpleCacheKey)var1;
         return this.mKey.equals(var2.mKey);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.mKey.hashCode();
   }

   public String toString() {
      return this.mKey;
   }
}
