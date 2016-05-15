package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.google.android.gms.tagmanager.zzl;
import com.google.android.gms.tagmanager.zzm;

@TargetApi(12)
class zzba<K, V> implements zzl<K, V> {
   private LruCache<K, V> zzbjq;

   zzba(final int var1, final zzm.zza<K, V> var2) {
      this.zzbjq = new LruCache(var1) {
         protected int sizeOf(K var1, V var2x) {
            return var2.sizeOf(var1, var2x);
         }
      };
   }

   public V get(K var1) {
      return this.zzbjq.get(var1);
   }

   public void zzh(K var1, V var2) {
      this.zzbjq.put(var1, var2);
   }
}
