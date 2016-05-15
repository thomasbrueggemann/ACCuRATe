package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Promotion {
   Map<String, String> zzPU = new HashMap();

   void put(String var1, String var2) {
      zzx.zzb(var1, "Name should be non-null");
      this.zzPU.put(var1, var2);
   }

   public Promotion setCreative(String var1) {
      this.put("cr", var1);
      return this;
   }

   public Promotion setId(String var1) {
      this.put("id", var1);
      return this;
   }

   public Promotion setName(String var1) {
      this.put("nm", var1);
      return this;
   }

   public Promotion setPosition(String var1) {
      this.put("ps", var1);
      return this;
   }

   public String toString() {
      return zze.zzO(this.zzPU);
   }

   public Map<String, String> zzba(String var1) {
      HashMap var2 = new HashMap();
      Iterator var3 = this.zzPU.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         var2.put(var1 + (String)var4.getKey(), var4.getValue());
      }

      return var2;
   }
}
