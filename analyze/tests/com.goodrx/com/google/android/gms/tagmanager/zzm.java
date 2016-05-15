package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.zzba;
import com.google.android.gms.tagmanager.zzcw;
import com.google.android.gms.tagmanager.zzl;

class zzm<K, V> {
   final zzm.zza<K, V> zzbhK = new zzm.zza() {
      public int sizeOf(K var1, V var2) {
         return 1;
      }
   };

   int zzFY() {
      return VERSION.SDK_INT;
   }

   public zzl<K, V> zza(int var1, zzm.zza<K, V> var2) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else {
         return (zzl)(this.zzFY() < 12?new zzcw(var1, var2):new zzba(var1, var2));
      }
   }

   public interface zza<K, V> {
      int sizeOf(K var1, V var2);
   }
}
