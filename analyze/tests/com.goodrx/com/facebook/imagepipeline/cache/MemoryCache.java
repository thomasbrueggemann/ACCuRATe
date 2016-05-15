package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

public interface MemoryCache<K, V> {
   @Nullable
   CloseableReference<V> cache(K var1, CloseableReference<V> var2);

   boolean contains(Predicate<K> var1);

   @Nullable
   CloseableReference<V> get(K var1);

   int removeAll(Predicate<K> var1);
}
