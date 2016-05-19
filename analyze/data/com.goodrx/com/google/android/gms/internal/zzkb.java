package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class zzkb extends com.google.android.gms.measurement.zze<zzkb> {
   private Map<Integer, String> zzPL = new HashMap(4);

   public String toString() {
      HashMap var1 = new HashMap();
      Iterator var2 = this.zzPL.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put("dimension" + var3.getKey(), var3.getValue());
      }

      return zzF(var1);
   }

   public void zza(zzkb var1) {
      var1.zzPL.putAll(this.zzPL);
   }

   public Map<Integer, String> zziP() {
      return Collections.unmodifiableMap(this.zzPL);
   }
}
