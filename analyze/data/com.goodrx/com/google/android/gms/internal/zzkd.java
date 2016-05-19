package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzkd extends com.google.android.gms.measurement.zze<zzkd> {
   private final Map<String, Object> zzxA = new HashMap();

   private String zzaW(String var1) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      if(var1 != null && var1.startsWith("&")) {
         var1 = var1.substring(1);
      }

      com.google.android.gms.common.internal.zzx.zzh(var1, "Name can not be empty or \"&\"");
      return var1;
   }

   public void set(String var1, String var2) {
      String var3 = this.zzaW(var1);
      this.zzxA.put(var3, var2);
   }

   public String toString() {
      return zzF(this.zzxA);
   }

   public void zza(zzkd var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      var1.zzxA.putAll(this.zzxA);
   }

   public Map<String, Object> zziR() {
      return Collections.unmodifiableMap(this.zzxA);
   }
}
