package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.class_572;
import com.google.android.gms.tagmanager.k;

// $FF: renamed from: com.google.android.gms.tagmanager.bb
class class_511<K, V> implements k<K, V> {
   private LruCache<K, V> afZ;

   class_511(final int var1, final class_572.class_1292<K, V> var2) {
      this.afZ = new LruCache(var1) {
         protected int sizeOf(K var1, V var2x) {
            return var2.sizeOf(var1, var2x);
         }
      };
   }

   // $FF: renamed from: e (java.lang.Object, java.lang.Object) void
   public void method_401(K var1, V var2) {
      this.afZ.put(var1, var2);
   }

   public V get(K var1) {
      return this.afZ.get(var1);
   }
}
