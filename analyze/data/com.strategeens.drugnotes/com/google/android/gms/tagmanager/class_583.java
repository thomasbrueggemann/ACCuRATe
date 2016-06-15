package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_580;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_634;
import com.google.android.gms.tagmanager.class_635;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $FF: renamed from: com.google.android.gms.tagmanager.dj
class class_583 extends class_580 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2686;
   private static final String aul;
   private static final String aum;
   private static final String aun;
   private static final String auo;
   private static final String aup;
   private static final String auq;
   private static final String aur;
   private static final String aus;
   private static final String aut;
   private static final List<String> auu;
   private static final Pattern auv;
   private static final Pattern auw;
   private static Map<String, String> aux;
   private static Map<String, String> auy;
   private final DataLayer aqn;
   private final class_634 auA;
   private final Set<String> auz;

   static {
      field_2686 = class_520.field_2223.toString();
      aul = class_519.field_1997.toString();
      aum = class_519.field_2006.toString();
      aun = class_519.field_2018.toString();
      auo = class_519.field_2065.toString();
      aup = class_519.field_2064.toString();
      auq = class_519.field_2005.toString();
      aur = class_519.field_2131.toString();
      aus = class_519.field_2134.toString();
      aut = class_519.field_2136.toString();
      auu = Arrays.asList(new String[]{"detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund"});
      auv = Pattern.compile("dimension(\\d+)");
      auw = Pattern.compile("metric(\\d+)");
   }

   public class_583(Context var1, DataLayer var2) {
      this(var1, var2, new class_634(var1));
   }

   class_583(Context var1, DataLayer var2, class_634 var3) {
      super(field_2686, new String[0]);
      this.aqn = var2;
      this.auA = var3;
      this.auz = new HashSet();
      this.auz.add("");
      this.auz.add("0");
      this.auz.add("false");
   }

   // $FF: renamed from: L (java.util.Map) com.google.android.gms.analytics.ecommerce.Promotion
   private Promotion method_3460(Map<String, String> var1) {
      Promotion var2 = new Promotion();
      String var3 = (String)var1.get("id");
      if(var3 != null) {
         var2.setId(String.valueOf(var3));
      }

      String var4 = (String)var1.get("name");
      if(var4 != null) {
         var2.setName(String.valueOf(var4));
      }

      String var5 = (String)var1.get("creative");
      if(var5 != null) {
         var2.setCreative(String.valueOf(var5));
      }

      String var6 = (String)var1.get("position");
      if(var6 != null) {
         var2.setPosition(String.valueOf(var6));
      }

      return var2;
   }

   // $FF: renamed from: M (java.util.Map) com.google.android.gms.analytics.ecommerce.Product
   private Product method_3461(Map<String, Object> var1) {
      Product var2 = new Product();
      Object var3 = var1.get("id");
      if(var3 != null) {
         var2.setId(String.valueOf(var3));
      }

      Object var4 = var1.get("name");
      if(var4 != null) {
         var2.setName(String.valueOf(var4));
      }

      Object var5 = var1.get("brand");
      if(var5 != null) {
         var2.setBrand(String.valueOf(var5));
      }

      Object var6 = var1.get("category");
      if(var6 != null) {
         var2.setCategory(String.valueOf(var6));
      }

      Object var7 = var1.get("variant");
      if(var7 != null) {
         var2.setVariant(String.valueOf(var7));
      }

      Object var8 = var1.get("coupon");
      if(var8 != null) {
         var2.setCouponCode(String.valueOf(var8));
      }

      Object var9 = var1.get("position");
      if(var9 != null) {
         var2.setPosition(this.method_3474(var9).intValue());
      }

      Object var10 = var1.get("price");
      if(var10 != null) {
         var2.setPrice(this.method_3473(var10).doubleValue());
      }

      Object var11 = var1.get("quantity");
      if(var11 != null) {
         var2.setQuantity(this.method_3474(var11).intValue());
      }

      Iterator var12 = var1.keySet().iterator();

      while(true) {
         while(var12.hasNext()) {
            String var13 = (String)var12.next();
            Matcher var14 = auv.matcher(var13);
            if(var14.matches()) {
               int var20;
               try {
                  var20 = Integer.parseInt(var14.group(1));
               } catch (NumberFormatException var22) {
                  class_613.method_3494("illegal number in custom dimension value: " + var13);
                  continue;
               }

               var2.setCustomDimension(var20, String.valueOf(var1.get(var13)));
            } else {
               Matcher var15 = auw.matcher(var13);
               if(var15.matches()) {
                  int var17;
                  try {
                     var17 = Integer.parseInt(var15.group(1));
                  } catch (NumberFormatException var21) {
                     class_613.method_3494("illegal number in custom metric value: " + var13);
                     continue;
                  }

                  var2.setCustomMetric(var17, this.method_3474(var1.get(var13)).intValue());
               }
            }
         }

         return var2;
      }
   }

   // $FF: renamed from: N (java.util.Map) java.util.Map
   private Map<String, String> method_3462(Map<String, class_57.class_1084> var1) {
      class_57.class_1084 var2 = (class_57.class_1084)var1.get(aus);
      if(var2 != null) {
         return this.method_3468(var2);
      } else {
         if(aux == null) {
            HashMap var3 = new HashMap();
            var3.put("transactionId", "&ti");
            var3.put("transactionAffiliation", "&ta");
            var3.put("transactionTax", "&tt");
            var3.put("transactionShipping", "&ts");
            var3.put("transactionTotal", "&tr");
            var3.put("transactionCurrency", "&cu");
            aux = var3;
         }

         return aux;
      }
   }

   // $FF: renamed from: O (java.util.Map) java.util.Map
   private Map<String, String> method_3463(Map<String, class_57.class_1084> var1) {
      class_57.class_1084 var2 = (class_57.class_1084)var1.get(aut);
      if(var2 != null) {
         return this.method_3468(var2);
      } else {
         if(auy == null) {
            HashMap var3 = new HashMap();
            var3.put("name", "&in");
            var3.put("sku", "&ic");
            var3.put("category", "&iv");
            var3.put("price", "&ip");
            var3.put("quantity", "&iq");
            var3.put("currency", "&cu");
            auy = var3;
         }

         return auy;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.Tracker, java.util.Map) void
   private void method_3464(Tracker param1, Map<String, class_57.class_1084> param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.analytics.Tracker, java.util.Map) void
   private void method_3465(Tracker param1, Map<String, class_57.class_1084> param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.util.Map, java.lang.String, java.lang.String) void
   private void method_3466(Map<String, String> var1, String var2, String var3) {
      if(var3 != null) {
         var1.put(var2, var3);
      }

   }

   // $FF: renamed from: c (java.lang.String, java.util.Map) com.google.android.gms.analytics.ecommerce.ProductAction
   private ProductAction method_3467(String var1, Map<String, Object> var2) {
      ProductAction var3 = new ProductAction(var1);
      Object var4 = var2.get("id");
      if(var4 != null) {
         var3.setTransactionId(String.valueOf(var4));
      }

      Object var5 = var2.get("affiliation");
      if(var5 != null) {
         var3.setTransactionAffiliation(String.valueOf(var5));
      }

      Object var6 = var2.get("coupon");
      if(var6 != null) {
         var3.setTransactionCouponCode(String.valueOf(var6));
      }

      Object var7 = var2.get("list");
      if(var7 != null) {
         var3.setProductActionList(String.valueOf(var7));
      }

      Object var8 = var2.get("option");
      if(var8 != null) {
         var3.setCheckoutOptions(String.valueOf(var8));
      }

      Object var9 = var2.get("revenue");
      if(var9 != null) {
         var3.setTransactionRevenue(this.method_3473(var9).doubleValue());
      }

      Object var10 = var2.get("tax");
      if(var10 != null) {
         var3.setTransactionTax(this.method_3473(var10).doubleValue());
      }

      Object var11 = var2.get("shipping");
      if(var11 != null) {
         var3.setTransactionShipping(this.method_3473(var11).doubleValue());
      }

      Object var12 = var2.get("step");
      if(var12 != null) {
         var3.setCheckoutStep(this.method_3474(var12).intValue());
      }

      return var3;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.d$a) java.util.Map
   private Map<String, String> method_3468(class_57.class_1084 var1) {
      Object var2 = class_635.method_3584(var1);
      if(!(var2 instanceof Map)) {
         return null;
      } else {
         Map var3 = (Map)var2;
         LinkedHashMap var4 = new LinkedHashMap();
         Iterator var5 = var3.entrySet().iterator();

         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            var4.put(var6.getKey().toString(), var6.getValue().toString());
         }

         return var4;
      }
   }

   // $FF: renamed from: de (java.lang.String) java.lang.String
   private String method_3469(String var1) {
      Object var2 = this.aqn.get(var1);
      return var2 == null?null:var2.toString();
   }

   // $FF: renamed from: df (java.lang.String) java.util.List
   private List<Map<String, String>> method_3470(String var1) {
      Object var2 = this.aqn.get(var1);
      if(var2 == null) {
         return null;
      } else if(!(var2 instanceof List)) {
         throw new IllegalArgumentException("transactionProducts should be of type List.");
      } else {
         Iterator var3 = ((List)var2).iterator();

         do {
            if(!var3.hasNext()) {
               return (List)var2;
            }
         } while(var3.next() instanceof Map);

         throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
      }
   }

   // $FF: renamed from: f (java.util.Map, java.lang.String) boolean
   private boolean method_3471(Map<String, class_57.class_1084> var1, String var2) {
      class_57.class_1084 var3 = (class_57.class_1084)var1.get(var2);
      return var3 == null?false:class_635.method_3583(var3).booleanValue();
   }

   // $FF: renamed from: p (com.google.android.gms.internal.d$a) java.util.Map
   private Map<String, String> method_3472(class_57.class_1084 var1) {
      if(var1 == null) {
         return new HashMap();
      } else {
         Map var2 = this.method_3468(var1);
         if(var2 == null) {
            return new HashMap();
         } else {
            String var3 = (String)var2.get("&aip");
            if(var3 != null && this.auz.contains(var3.toLowerCase())) {
               var2.remove("&aip");
            }

            return var2;
         }
      }
   }

   // $FF: renamed from: y (java.lang.Object) java.lang.Double
   private Double method_3473(Object var1) {
      if(var1 instanceof String) {
         try {
            Double var3 = Double.valueOf((String)var1);
            return var3;
         } catch (NumberFormatException var4) {
            throw new RuntimeException("Cannot convert the object to Double: " + var4.getMessage());
         }
      } else if(var1 instanceof Integer) {
         return Double.valueOf(((Integer)var1).doubleValue());
      } else if(var1 instanceof Double) {
         return (Double)var1;
      } else {
         throw new RuntimeException("Cannot convert the object to Double: " + var1.toString());
      }
   }

   // $FF: renamed from: z (java.lang.Object) java.lang.Integer
   private Integer method_3474(Object var1) {
      if(var1 instanceof String) {
         try {
            Integer var3 = Integer.valueOf((String)var1);
            return var3;
         } catch (NumberFormatException var4) {
            throw new RuntimeException("Cannot convert the object to Integer: " + var4.getMessage());
         }
      } else if(var1 instanceof Double) {
         return Integer.valueOf(((Double)var1).intValue());
      } else if(var1 instanceof Integer) {
         return (Integer)var1;
      } else {
         throw new RuntimeException("Cannot convert the object to Integer: " + var1.toString());
      }
   }

   // $FF: renamed from: D (java.util.Map) void
   public void method_3454(Map<String, class_57.class_1084> var1) {
      Tracker var2 = this.auA.method_3573("_GTM_DEFAULT_TRACKER_");
      var2.enableAdvertisingIdCollection(this.method_3471(var1, "collect_adid"));
      if(this.method_3471(var1, aun)) {
         this.method_3465(var2, var1);
      } else if(this.method_3471(var1, aum)) {
         var2.send(this.method_3472((class_57.class_1084)var1.get(auq)));
      } else if(this.method_3471(var1, aur)) {
         this.method_3464(var2, var1);
      } else {
         class_613.method_3494("Ignoring unknown tag.");
      }
   }
}
