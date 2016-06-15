package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.class_651;
import com.google.android.gms.analytics.class_660;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.analytics.class_671;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {
   @Deprecated
   public static class AppViewBuilder extends HitBuilders.HitBuilder<HitBuilders.AppViewBuilder> {
      public AppViewBuilder() {
         class_660.method_3794().method_3795(class_660.class_1313.field_3816);
         this.set("&t", "screenview");
      }
   }

   public static class EventBuilder extends HitBuilders.HitBuilder<HitBuilders.EventBuilder> {
      public EventBuilder() {
         class_660.method_3794().method_3795(class_660.class_1313.field_3778);
         this.set("&t", "event");
      }

      public EventBuilder(String var1, String var2) {
         this();
         this.setCategory(var1);
         this.setAction(var2);
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

      public HitBuilders.EventBuilder setValue(long var1) {
         this.set("&ev", Long.toString(var1));
         return this;
      }
   }

   public static class ExceptionBuilder extends HitBuilders.HitBuilder<HitBuilders.ExceptionBuilder> {
      public ExceptionBuilder() {
         class_660.method_3794().method_3795(class_660.class_1313.field_3761);
         this.set("&t", "exception");
      }

      public HitBuilders.ExceptionBuilder setDescription(String var1) {
         this.set("&exd", var1);
         return this;
      }

      public HitBuilders.ExceptionBuilder setFatal(boolean var1) {
         this.set("&exf", class_671.method_3912(var1));
         return this;
      }
   }

   protected static class HitBuilder<T extends HitBuilders.HitBuilder> {
      // $FF: renamed from: wA java.util.List
      List<Product> field_2080 = new ArrayList();
      // $FF: renamed from: ww java.util.Map
      private Map<String, String> field_2081 = new HashMap();
      // $FF: renamed from: wx com.google.android.gms.analytics.ecommerce.ProductAction
      ProductAction field_2082;
      // $FF: renamed from: wy java.util.Map
      Map<String, List<Product>> field_2083 = new HashMap();
      // $FF: renamed from: wz java.util.List
      List<Promotion> field_2084 = new ArrayList();

      public T addImpression(Product var1, String var2) {
         if(var1 == null) {
            class_669.method_3891("product should be non-null");
            return this;
         } else {
            if(var2 == null) {
               var2 = "";
            }

            if(!this.field_2083.containsKey(var2)) {
               this.field_2083.put(var2, new ArrayList());
            }

            ((List)this.field_2083.get(var2)).add(var1);
            return this;
         }
      }

      public T addProduct(Product var1) {
         if(var1 == null) {
            class_669.method_3891("product should be non-null");
            return this;
         } else {
            this.field_2080.add(var1);
            return this;
         }
      }

      public T addPromotion(Promotion var1) {
         if(var1 == null) {
            class_669.method_3891("promotion should be non-null");
            return this;
         } else {
            this.field_2084.add(var1);
            return this;
         }
      }

      public Map<String, String> build() {
         HashMap var1 = new HashMap(this.field_2081);
         if(this.field_2082 != null) {
            var1.putAll(this.field_2082.build());
         }

         Iterator var2 = this.field_2084.iterator();

         for(int var3 = 1; var2.hasNext(); ++var3) {
            var1.putAll(((Promotion)var2.next()).method_3128(class_651.method_3725(var3)));
         }

         Iterator var4 = this.field_2080.iterator();

         for(int var5 = 1; var4.hasNext(); ++var5) {
            var1.putAll(((Product)var4.next()).method_4596(class_651.method_3724(var5)));
         }

         Iterator var6 = this.field_2083.entrySet().iterator();

         for(int var7 = 1; var6.hasNext(); ++var7) {
            Entry var8 = (Entry)var6.next();
            List var9 = (List)var8.getValue();
            String var10 = class_651.method_3727(var7);
            Iterator var11 = var9.iterator();

            for(int var12 = 1; var11.hasNext(); ++var12) {
               var1.putAll(((Product)var11.next()).method_4596(var10 + class_651.method_3726(var12)));
            }

            if(!TextUtils.isEmpty((CharSequence)var8.getKey())) {
               var1.put(var10 + "nm", var8.getKey());
            }
         }

         return var1;
      }

      protected String get(String var1) {
         return (String)this.field_2081.get(var1);
      }

      public final T set(String var1, String var2) {
         class_660.method_3794().method_3795(class_660.class_1313.field_3754);
         if(var1 != null) {
            this.field_2081.put(var1, var2);
            return this;
         } else {
            class_669.method_3891(" HitBuilder.set() called with a null paramName.");
            return this;
         }
      }

      public final T setAll(Map<String, String> var1) {
         class_660.method_3794().method_3795(class_660.class_1313.field_3755);
         if(var1 == null) {
            return this;
         } else {
            this.field_2081.putAll(new HashMap(var1));
            return this;
         }
      }

      public T setCampaignParamsFromUrl(String var1) {
         class_660.method_3794().method_3795(class_660.class_1313.field_3757);
         String var2 = class_671.method_3906(var1);
         if(TextUtils.isEmpty(var2)) {
            return this;
         } else {
            Map var3 = class_671.method_3905(var2);
            this.set("&cc", (String)var3.get("utm_content"));
            this.set("&cm", (String)var3.get("utm_medium"));
            this.set("&cn", (String)var3.get("utm_campaign"));
            this.set("&cs", (String)var3.get("utm_source"));
            this.set("&ck", (String)var3.get("utm_term"));
            this.set("&ci", (String)var3.get("utm_id"));
            this.set("&gclid", (String)var3.get("gclid"));
            this.set("&dclid", (String)var3.get("dclid"));
            this.set("&gmob_t", (String)var3.get("gmob_t"));
            return this;
         }
      }

      public T setCustomDimension(int var1, String var2) {
         this.set(class_651.method_3722(var1), var2);
         return this;
      }

      public T setCustomMetric(int var1, float var2) {
         this.set(class_651.method_3723(var1), Float.toString(var2));
         return this;
      }

      protected T setHitType(String var1) {
         this.set("&t", var1);
         return this;
      }

      public T setNewSession() {
         this.set("&sc", "start");
         return this;
      }

      public T setNonInteraction(boolean var1) {
         this.set("&ni", class_671.method_3912(var1));
         return this;
      }

      public T setProductAction(ProductAction var1) {
         this.field_2082 = var1;
         return this;
      }

      public T setPromotionAction(String var1) {
         this.field_2081.put("&promoa", var1);
         return this;
      }
   }

   @Deprecated
   public static class ItemBuilder extends HitBuilders.HitBuilder<HitBuilders.ItemBuilder> {
      public ItemBuilder() {
         class_660.method_3794().method_3795(class_660.class_1313.field_3779);
         this.set("&t", "item");
      }

      public HitBuilders.ItemBuilder setCategory(String var1) {
         this.set("&iv", var1);
         return this;
      }

      public HitBuilders.ItemBuilder setCurrencyCode(String var1) {
         this.set("&cu", var1);
         return this;
      }

      public HitBuilders.ItemBuilder setName(String var1) {
         this.set("&in", var1);
         return this;
      }

      public HitBuilders.ItemBuilder setPrice(double var1) {
         this.set("&ip", Double.toString(var1));
         return this;
      }

      public HitBuilders.ItemBuilder setQuantity(long var1) {
         this.set("&iq", Long.toString(var1));
         return this;
      }

      public HitBuilders.ItemBuilder setSku(String var1) {
         this.set("&ic", var1);
         return this;
      }

      public HitBuilders.ItemBuilder setTransactionId(String var1) {
         this.set("&ti", var1);
         return this;
      }
   }

   public static class ScreenViewBuilder extends HitBuilders.HitBuilder<HitBuilders.ScreenViewBuilder> {
      public ScreenViewBuilder() {
         class_660.method_3794().method_3795(class_660.class_1313.field_3816);
         this.set("&t", "screenview");
      }
   }

   public static class SocialBuilder extends HitBuilders.HitBuilder<HitBuilders.SocialBuilder> {
      public SocialBuilder() {
         class_660.method_3794().method_3795(class_660.class_1313.field_3764);
         this.set("&t", "social");
      }

      public HitBuilders.SocialBuilder setAction(String var1) {
         this.set("&sa", var1);
         return this;
      }

      public HitBuilders.SocialBuilder setNetwork(String var1) {
         this.set("&sn", var1);
         return this;
      }

      public HitBuilders.SocialBuilder setTarget(String var1) {
         this.set("&st", var1);
         return this;
      }
   }

   public static class TimingBuilder extends HitBuilders.HitBuilder<HitBuilders.TimingBuilder> {
      public TimingBuilder() {
         class_660.method_3794().method_3795(class_660.class_1313.field_3763);
         this.set("&t", "timing");
      }

      public TimingBuilder(String var1, String var2, long var3) {
         this();
         this.setVariable(var2);
         this.setValue(var3);
         this.setCategory(var1);
      }

      public HitBuilders.TimingBuilder setCategory(String var1) {
         this.set("&utc", var1);
         return this;
      }

      public HitBuilders.TimingBuilder setLabel(String var1) {
         this.set("&utl", var1);
         return this;
      }

      public HitBuilders.TimingBuilder setValue(long var1) {
         this.set("&utt", Long.toString(var1));
         return this;
      }

      public HitBuilders.TimingBuilder setVariable(String var1) {
         this.set("&utv", var1);
         return this;
      }
   }

   @Deprecated
   public static class TransactionBuilder extends HitBuilders.HitBuilder<HitBuilders.TransactionBuilder> {
      public TransactionBuilder() {
         class_660.method_3794().method_3795(class_660.class_1313.field_3812);
         this.set("&t", "transaction");
      }

      public HitBuilders.TransactionBuilder setAffiliation(String var1) {
         this.set("&ta", var1);
         return this;
      }

      public HitBuilders.TransactionBuilder setCurrencyCode(String var1) {
         this.set("&cu", var1);
         return this;
      }

      public HitBuilders.TransactionBuilder setRevenue(double var1) {
         this.set("&tr", Double.toString(var1));
         return this;
      }

      public HitBuilders.TransactionBuilder setShipping(double var1) {
         this.set("&ts", Double.toString(var1));
         return this;
      }

      public HitBuilders.TransactionBuilder setTax(double var1) {
         this.set("&tt", Double.toString(var1));
         return this;
      }

      public HitBuilders.TransactionBuilder setTransactionId(String var1) {
         this.set("&ti", var1);
         return this;
      }
   }
}
