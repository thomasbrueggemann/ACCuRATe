package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Cache;
import com.google.tagmanager.LRUCache;
import com.google.tagmanager.SimpleCache;

class CacheFactory<K, V> {
    @VisibleForTesting
    final CacheFactory.CacheSizeManager<K, V> mDefaultSizeManager = new CacheFactory.CacheSizeManager() {
        public int sizeOf(K var1, V var2) {
            return 1;
        }
    };

    public Cache<K, V> createCache(int var1) {
        return this.createCache(var1, this.mDefaultSizeManager);
    }

    public Cache<K, V> createCache(int var1, CacheFactory.CacheSizeManager<K, V> var2) {
        if(var1 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else {
            return (Cache)(this.getSdkVersion() < 12?new SimpleCache(var1, var2):new LRUCache(var1, var2));
        }
    }

    @VisibleForTesting
    int getSdkVersion() {
        return VERSION.SDK_INT;
    }

    public interface CacheSizeManager<K, V> {
        int sizeOf(K var1, V var2);
    }
}
