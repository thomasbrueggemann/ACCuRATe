package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class zzkc extends com.google.android.gms.measurement.zze<zzkc> {
   private Map<Integer, Double> zzPM = new HashMap(4);

   public String toString() {
      HashMap var1 = new HashMap();
      Iterator var2 = this.zzPM.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put("metric" + var3.getKey(), var3.getValue());
      }

      return zzF(var1);
   }

   public void zza(zzkc var1) {
      var1.zzPM.putAll(this.zzPM);
   }

   public Map<Integer, Double> zziQ() {
      return Collections.unmodifiableMap(this.zzPM);
   }
}
