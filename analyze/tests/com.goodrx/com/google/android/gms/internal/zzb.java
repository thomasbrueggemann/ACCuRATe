package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public interface zzb {
   zzb.zza zza(String var1);

   void zza();

   void zza(String var1, zzb.zza var2);

   public static class zza {
      public byte[] data;
      public String zzb;
      public long zzc;
      public long zzd;
      public long zze;
      public long zzf;
      public Map<String, String> zzg = Collections.emptyMap();

      public boolean zzb() {
         return this.zze < System.currentTimeMillis();
      }

      public boolean zzc() {
         return this.zzf < System.currentTimeMillis();
      }
   }
}
