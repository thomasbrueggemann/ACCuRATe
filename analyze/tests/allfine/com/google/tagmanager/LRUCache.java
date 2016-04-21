package com.google.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.google.tagmanager.Cache;
import com.google.tagmanager.CacheFactory;

@TargetApi(12)
class LRUCache<K, V> implements Cache<K, V> {
    private LruCache<K, V> lruCache;

    LRUCache(final int var1, final CacheFactory.CacheSizeManager<K, V> var2) {
        this.lruCache = new LruCache(var1) {
            protected int sizeOf(K var1, V var2x) {
                return var2.sizeOf(var1, var2x);
            }
        };
    }

    public V get(K var1) {
        return this.lruCache.get(var1);
    }

    public void put(K var1, V var2) {
        this.lruCache.put(var1, var2);
    }
}
