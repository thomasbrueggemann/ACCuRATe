package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.class_609;
import com.google.android.gms.tagmanager.class_644;
import com.google.android.gms.tagmanager.class_91;
import com.google.android.gms.tagmanager.k;

// $FF: renamed from: com.google.android.gms.tagmanager.l
class class_716<K, V> {
    final class_716.class_1821<K, V> aoa = new class_716.class_1821() {
        public int sizeOf(K var1, V var2) {
            return 1;
        }
    };

    // $FF: renamed from: a (int, com.google.android.gms.tagmanager.l$a) com.google.android.gms.tagmanager.k
    public k<K, V> method_3917(int var1, class_716.class_1821<K, V> var2) {
        if(var1 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else {
            return (class_91)(this.method_3918() < 12?new class_644(var1, var2):new class_609(var1, var2));
        }
    }

    // $FF: renamed from: nP () int
    int method_3918() {
        return VERSION.SDK_INT;
    }

    public interface class_1821<K, V> {
        int sizeOf(K var1, V var2);
    }
}
