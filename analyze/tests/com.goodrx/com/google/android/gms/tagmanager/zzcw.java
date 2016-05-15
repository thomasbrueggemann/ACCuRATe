package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzl;
import com.google.android.gms.tagmanager.zzm;
import java.util.HashMap;
import java.util.Map;

class zzcw<K, V> implements zzl<K, V> {
   private final Map<K, V> zzbld = new HashMap();
   private final int zzble;
   private final zzm.zza<K, V> zzblf;
   private int zzblg;

   zzcw(int var1, zzm.zza<K, V> var2) {
      this.zzble = var1;
      this.zzblf = var2;
   }

   public V get(K var1) {
      synchronized(this){}

      Object var3;
      try {
         var3 = this.zzbld.get(var1);
      } finally {
         ;
      }

      return var3;
   }

   public void zzh(K param1, V param2) {
      // $FF: Couldn't be decompiled
   }
}
