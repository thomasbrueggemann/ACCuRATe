package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzc;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {
   public static class EventBuilder extends HitBuilders.HitBuilder<HitBuilders.EventBuilder> {
      public EventBuilder() {
         this.set("&t", "event");
      }

      public HitBuilders.EventBuilder setAction(String var1) {
         this.set("&ea", var1);
         return this;
      }

      public HitBuilders.EventBuilder setCategory(String var1) {
         this.set("&ec", var1);
         return this;
      }

      public HitBuilders.EventBuilder setLabel(String var1) {
         this.set("&el", var1);
         return this;
      }
   }

   public static class ExceptionBuilder extends HitBuilders.HitBuilder<HitBuilders.ExceptionBuilder> {
      public ExceptionBuilder() {
         this.set("&t", "exception");
      }

      public HitBuilders.ExceptionBuilder setDescription(String var1) {
         this.set("&exd", var1);
         return this;
      }

      public HitBuilders.ExceptionBuilder setFatal(boolean var1) {
         this.set("&exf", zzam.zzK(var1));
         return this;
      }
   }

   protected static class HitBuilder<T extends HitBuilders.HitBuilder> {
      private Map<String, String> zzPm = new HashMap();
      ProductAction zzPn;
      Map<String, List<Product>> zzPo = new HashMap();
      List<Promotion> zzPp = new ArrayList();
      List<Product> zzPq = new ArrayList();

      public T addImpression(Product var1, String var2) {
         if(var1 == null) {
            zzae.zzaK("product should be non-null");
            return this;
         } else {
            if(var2 == null) {
               var2 = "";
            }

            if(!this.zzPo.containsKey(var2)) {
               this.zzPo.put(var2, new ArrayList());
            }

            ((List)this.zzPo.get(var2)).add(var1);
            return this;
         }
      }

      public T addProduct(Product var1) {
         if(var1 == null) {
            zzae.zzaK("product should be non-null");
            return this;
         } else {
            this.zzPq.add(var1);
            return this;
         }
      }

      public T addPromotion(Promotion var1) {
         if(var1 == null) {
            zzae.zzaK("promotion should be non-null");
            return this;
         } else {
            this.zzPp.add(var1);
            return this;
         }
      }

      public Map<String, String> build() {
         HashMap var1 = new HashMap(this.zzPm);
         if(this.zzPn != null) {
            var1.putAll(this.zzPn.build());
         }

         Iterator var2 = this.zzPp.iterator();

         for(int var3 = 1; var2.hasNext(); ++var3) {
            var1.putAll(((Promotion)var2.next()).zzba(zzc.zzZ(var3)));
         }

         Iterator var4 = this.zzPq.iterator();

         for(int var5 = 1; var4.hasNext(); ++var5) {
            var1.putAll(((Product)var4.next()).zzba(zzc.zzX(var5)));
         }

         Iterator var6 = this.zzPo.entrySet().iterator();

         for(int var7 = 1; var6.hasNext(); ++var7) {
            Entry var8 = (Entry)var6.next();
            List var9 = (List)var8.getValue();
            String var10 = zzc.zzac(var7);
            Iterator var11 = var9.iterator();

            for(int var12 = 1; var11.hasNext(); ++var12) {
               var1.putAll(((Product)var11.next()).zzba(var10 + zzc.zzab(var12)));
            }

            if(!TextUtils.isEmpty((CharSequence)var8.getKey())) {
               var1.put(var10 + "nm", var8.getKey());
            }
         }

         return var1;
      }

      public final T set(String var1, String var2) {
         if(var1 != null) {
            this.zzPm.put(var1, var2);
            return this;
         } else {
            zzae.zzaK(" HitBuilder.set() called with a null paramName.");
            return this;
         }
      }

      public final T setAll(Map<String, String> var1) {
         if(var1 == null) {
            return this;
         } else {
            this.zzPm.putAll(new HashMap(var1));
            return this;
         }
      }

      public T setCustomDimension(int var1, String var2) {
         this.set(zzc.zzT(var1), var2);
         return this;
      }

      public T setProductAction(ProductAction var1) {
         this.zzPn = var1;
         return this;
      }
   }

   public static class ScreenViewBuilder extends HitBuilders.HitBuilder<HitBuilders.ScreenViewBuilder> {
      public ScreenViewBuilder() {
         this.set("&t", "screenview");
      }
   }
}
