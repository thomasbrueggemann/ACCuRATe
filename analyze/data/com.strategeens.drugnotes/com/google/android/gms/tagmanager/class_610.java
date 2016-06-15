package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.class_673;
import com.google.android.gms.tagmanager.k;

// $FF: renamed from: com.google.android.gms.tagmanager.bb
class class_610<K, V> implements k<K, V> {
   private LruCache<K, V> arR;

   class_610(final int var1, final class_673.class_1689<K, V> var2) {
      this.arR = new LruCache(var1) {
         protected int sizeOf(K var1, V var2x) {
            return var2.sizeOf(var1, var2x);
         }
      };
   }

   // $FF: renamed from: e (java.lang.Object, java.lang.Object) void
   public void method_443(K var1, V var2) {
      this.arR.put(var1, var2);
   }

   public V get(K var1) {
      return this.arR.get(var1);
   }
}
