package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzpt extends com.google.android.gms.measurement.zze<zzpt> {
   private ProductAction zzPn;
   private final Map<String, List<Product>> zzPo = new HashMap();
   private final List<Promotion> zzPp = new ArrayList();
   private final List<Product> zzPq = new ArrayList();

   public String toString() {
      HashMap var1 = new HashMap();
      if(!this.zzPq.isEmpty()) {
         var1.put("products", this.zzPq);
      }

      if(!this.zzPp.isEmpty()) {
         var1.put("promotions", this.zzPp);
      }

      if(!this.zzPo.isEmpty()) {
         var1.put("impressions", this.zzPo);
      }

      var1.put("productAction", this.zzPn);
      return zzF(var1);
   }

   public ProductAction zzAV() {
      return this.zzPn;
   }

   public List<Product> zzAW() {
      return Collections.unmodifiableList(this.zzPq);
   }

   public Map<String, List<Product>> zzAX() {
      return this.zzPo;
   }

   public List<Promotion> zzAY() {
      return Collections.unmodifiableList(this.zzPp);
   }

   public void zza(Product var1, String var2) {
      if(var1 != null) {
         if(var2 == null) {
            var2 = "";
         }

         if(!this.zzPo.containsKey(var2)) {
            this.zzPo.put(var2, new ArrayList());
         }

         ((List)this.zzPo.get(var2)).add(var1);
      }
   }

   public void zza(zzpt var1) {
      var1.zzPq.addAll(this.zzPq);
      var1.zzPp.addAll(this.zzPp);
      Iterator var4 = this.zzPo.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         String var6 = (String)var5.getKey();
         Iterator var7 = ((List)var5.getValue()).iterator();

         while(var7.hasNext()) {
            var1.zza((Product)var7.next(), var6);
         }
      }

      if(this.zzPn != null) {
         var1.zzPn = this.zzPn;
      }

   }
}
