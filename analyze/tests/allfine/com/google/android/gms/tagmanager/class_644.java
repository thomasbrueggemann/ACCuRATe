package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.class_716;
import com.google.android.gms.tagmanager.k;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.da
class class_644<K, V> implements k<K, V> {
    private final Map<K, V> arD = new HashMap();
    private final int arE;
    private final class_716.class_1821<K, V> arF;
    private int arG;

    class_644(int var1, class_716.class_1821<K, V> var2) {
        this.arE = var1;
        this.arF = var2;
    }

    // $FF: renamed from: e (java.lang.Object, java.lang.Object) void
    public void method_386(K param1, V param2) {
        // $FF: Couldn't be decompiled
    }

    public V get(K var1) {
        synchronized(this) {}

        Object var3;
        try {
            var3 = this.arD.get(var1);
        } finally {
            ;
        }

        return var3;
    }
}
