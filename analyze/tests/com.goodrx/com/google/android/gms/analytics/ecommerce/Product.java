package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Product {
   Map<String, String> zzPU = new HashMap();

   void put(String var1, String var2) {
      zzx.zzb(var1, "Name should be non-null");
      this.zzPU.put(var1, var2);
   }

   public Product setBrand(String var1) {
      this.put("br", var1);
      return this;
   }

   public Product setCategory(String var1) {
      this.put("ca", var1);
      return this;
   }

   public Product setCouponCode(String var1) {
      this.put("cc", var1);
      return this;
   }

   public Product setCustomDimension(int var1, String var2) {
      this.put(zzc.zzae(var1), var2);
      return this;
   }

   public Product setCustomMetric(int var1, int var2) {
      this.put(zzc.zzaf(var1), Integer.toString(var2));
      return this;
   }

   public Product setId(String var1) {
      this.put("id", var1);
      return this;
   }

   public Product setName(String var1) {
      this.put("nm", var1);
      return this;
   }

   public Product setPosition(int var1) {
      this.put("ps", Integer.toString(var1));
      return this;
   }

   public Product setPrice(double var1) {
      this.put("pr", Double.toString(var1));
      return this;
   }

   public Product setQuantity(int var1) {
      this.put("qt", Integer.toString(var1));
      return this;
   }

   public Product setVariant(String var1) {
      this.put("va", var1);
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
