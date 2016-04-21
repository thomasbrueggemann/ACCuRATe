package com.google.tagmanager;

import com.google.tagmanager.Cache;
import com.google.tagmanager.CacheFactory;
import java.util.HashMap;
import java.util.Map;

class SimpleCache<K, V> implements Cache<K, V> {
    private final Map<K, V> mHashMap = new HashMap();
    private final int mMaxSize;
    private final CacheFactory.CacheSizeManager<K, V> mSizeManager;
    private int mTotalSize;

    SimpleCache(int var1, CacheFactory.CacheSizeManager<K, V> var2) {
        this.mMaxSize = var1;
        this.mSizeManager = var2;
    }

    public V get(K var1) {
        synchronized(this) {}

        Object var3;
        try {
            var3 = this.mHashMap.get(var1);
        } finally {
            ;
        }

        return var3;
    }

    public void put(K param1, V param2) {
        // $FF: Couldn't be decompiled
    }
}
