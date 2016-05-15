package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ProductAction {
   Map<String, String> zzPU = new HashMap();

   public ProductAction(String var1) {
      this.put("&pa", var1);
   }

   public Map<String, String> build() {
      return new HashMap(this.zzPU);
   }

   void put(String var1, String var2) {
      zzx.zzb(var1, "Name should be non-null");
      this.zzPU.put(var1, var2);
   }

   public ProductAction setCheckoutOptions(String var1) {
      this.put("&col", var1);
      return this;
   }

   public ProductAction setCheckoutStep(int var1) {
      this.put("&cos", Integer.toString(var1));
      return this;
   }

   public ProductAction setProductActionList(String var1) {
      this.put("&pal", var1);
      return this;
   }

   public ProductAction setTransactionAffiliation(String var1) {
      this.put("&ta", var1);
      return this;
   }

   public ProductAction setTransactionCouponCode(String var1) {
      this.put("&tcc", var1);
      return this;
   }

   public ProductAction setTransactionId(String var1) {
      this.put("&ti", var1);
      return this;
   }

   public ProductAction setTransactionRevenue(double var1) {
      this.put("&tr", Double.toString(var1));
      return this;
   }

   public ProductAction setTransactionShipping(double var1) {
      this.put("&ts", Double.toString(var1));
      return this;
   }

   public ProductAction setTransactionTax(double var1) {
      this.put("&tt", Double.toString(var1));
      return this;
   }

   public String toString() {
      HashMap var1 = new HashMap();
      Iterator var2 = this.zzPU.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).startsWith("&")) {
            var1.put(((String)var3.getKey()).substring(1), var3.getValue());
         } else {
            var1.put(var3.getKey(), var3.getValue());
         }
      }

      return zze.zzO(var1);
   }
}
