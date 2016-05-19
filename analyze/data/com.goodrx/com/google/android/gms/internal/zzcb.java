package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzhb;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzhb
public class zzcb {
   private final Object zzpV = new Object();
   private final Map<String, String> zzxA = new LinkedHashMap();
   private zzcb zzxD;
   boolean zzxi;
   private final List<zzbz> zzxz = new LinkedList();

   public zzcb(boolean var1, String var2, String var3) {
      this.zzxi = var1;
      this.zzxA.put("action", var2);
      this.zzxA.put("ad_format", var3);
   }

   public boolean zza(zzbz param1, long param2, String... param4) {
      // $FF: Couldn't be decompiled
   }

   public boolean zza(zzbz var1, String... var2) {
      return this.zzxi && var1 != null?this.zza(var1, com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime(), var2):false;
   }

   public zzbz zzb(long var1) {
      return !this.zzxi?null:new zzbz(var1, (String)null, (zzbz)null);
   }

   public void zzc(zzcb param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzc(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public zzbz zzdB() {
      return this.zzb(com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime());
   }
}
