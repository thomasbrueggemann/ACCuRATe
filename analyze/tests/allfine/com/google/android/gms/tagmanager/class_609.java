package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.class_716;
import com.google.android.gms.tagmanager.k;

// $FF: renamed from: com.google.android.gms.tagmanager.bb
class class_609<K, V> implements k<K, V> {
    private LruCache<K, V> apI;

    class_609(final int var1, final class_716.class_1821<K, V> var2) {
        this.apI = new LruCache(var1) {
            protected int sizeOf(K var1, V var2x) {
                return var2.sizeOf(var1, var2x);
            }
        };
    }

    // $FF: renamed from: e (java.lang.Object, java.lang.Object) void
    public void method_386(K var1, V var2) {
        this.apI.put(var1, var2);
    }

    public V get(K var1) {
        return this.apI.get(var1);
    }
}
