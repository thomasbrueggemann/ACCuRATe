package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheTracker;

public class InstrumentedMemoryCache<K, V> implements MemoryCache<K, V> {
   private final MemoryCache<K, V> mDelegate;
   private final MemoryCacheTracker mTracker;

   public InstrumentedMemoryCache(MemoryCache<K, V> var1, MemoryCacheTracker var2) {
      this.mDelegate = var1;
      this.mTracker = var2;
   }

   public CloseableReference<V> cache(K var1, CloseableReference<V> var2) {
      this.mTracker.onCachePut();
      return this.mDelegate.cache(var1, var2);
   }

   public boolean contains(Predicate<K> var1) {
      return this.mDelegate.contains(var1);
   }

   public CloseableReference<V> get(K var1) {
      CloseableReference var2 = this.mDelegate.get(var1);
      if(var2 == null) {
         this.mTracker.onCacheMiss();
         return var2;
      } else {
         this.mTracker.onCacheHit();
         return var2;
      }
   }

   public int removeAll(Predicate<K> var1) {
      return this.mDelegate.removeAll(var1);
   }
}
