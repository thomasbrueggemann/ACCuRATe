package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_482;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_535;
import com.google.android.gms.tagmanager.class_537;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.di
class class_485 extends class_482 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2843;
   private static Map<String, String> aiA;
   private static final String ait;
   private static final String aiu;
   private static final String aiv;
   private static final String aiw;
   private static final String aix;
   private static final String aiy;
   private static Map<String, String> aiz;
   private final DataLayer aer;
   private final Set<String> aiB;
   private final class_535 aiC;

   static {
      field_2843 = class_445.field_2417.toString();
      ait = class_444.field_2195.toString();
      aiu = class_444.field_2230.toString();
      aiv = class_444.field_2229.toString();
      aiw = class_444.field_2365.toString();
      aix = class_444.field_2367.toString();
      aiy = class_444.field_2369.toString();
   }

   public class_485(Context var1, DataLayer var2) {
      this(var1, var2, new class_535(var1));
   }

   class_485(Context var1, DataLayer var2, class_535 var3) {
      super(field_2843, new String[0]);
      this.aer = var2;
      this.aiC = var3;
      this.aiB = new HashSet();
      this.aiB.add("");
      this.aiB.add("0");
      this.aiB.add("false");
   }

   // $FF: renamed from: G (java.util.Map) java.util.Map
   private Map<String, String> method_2892(Map<String, class_52.class_816> var1) {
      class_52.class_816 var2 = (class_52.class_816)var1.get(aix);
      if(var2 != null) {
         return this.method_2896(var2);
      } else {
         if(aiz == null) {
            HashMap var3 = new HashMap();
            var3.put("transactionId", "&ti");
            var3.put("transactionAffiliation", "&ta");
            var3.put("transactionTax", "&tt");
            var3.put("transactionShipping", "&ts");
            var3.put("transactionTotal", "&tr");
            var3.put("transactionCurrency", "&cu");
            aiz = var3;
         }

         return aiz;
      }
   }

   // $FF: renamed from: H (java.util.Map) java.util.Map
   private Map<String, String> method_2893(Map<String, class_52.class_816> var1) {
      class_52.class_816 var2 = (class_52.class_816)var1.get(aiy);
      if(var2 != null) {
         return this.method_2896(var2);
      } else {
         if(aiA == null) {
            HashMap var3 = new HashMap();
            var3.put("name", "&in");
            var3.put("sku", "&ic");
            var3.put("category", "&iv");
            var3.put("price", "&ip");
            var3.put("quantity", "&iq");
            var3.put("currency", "&cu");
            aiA = var3;
         }

         return aiA;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.Tracker, java.util.Map) void
   private void method_2894(Tracker param1, Map<String, class_52.class_816> param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.util.Map, java.lang.String, java.lang.String) void
   private void method_2895(Map<String, String> var1, String var2, String var3) {
      if(var3 != null) {
         var1.put(var2, var3);
      }

   }

   // $FF: renamed from: c (com.google.android.gms.internal.d$a) java.util.Map
   private Map<String, String> method_2896(class_52.class_816 var1) {
      Object var2 = class_537.method_3024(var1);
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

   // $FF: renamed from: cu (java.lang.String) java.lang.String
   private String method_2897(String var1) {
      Object var2 = this.aer.get(var1);
      return var2 == null?null:var2.toString();
   }

   // $FF: renamed from: e (java.util.Map, java.lang.String) boolean
   private boolean method_2898(Map<String, class_52.class_816> var1, String var2) {
      class_52.class_816 var3 = (class_52.class_816)var1.get(var2);
      return var3 == null?false:class_537.method_3022(var3).booleanValue();
   }

   // $FF: renamed from: mZ () java.util.List
   private List<Map<String, String>> method_2899() {
      Object var1 = this.aer.get("transactionProducts");
      if(var1 == null) {
         return null;
      } else if(!(var1 instanceof List)) {
         throw new IllegalArgumentException("transactionProducts should be of type List.");
      } else {
         Iterator var2 = ((List)var1).iterator();

         do {
            if(!var2.hasNext()) {
               return (List)var1;
            }
         } while(var2.next() instanceof Map);

         throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
      }
   }

   // $FF: renamed from: p (com.google.android.gms.internal.d$a) java.util.Map
   private Map<String, String> method_2900(class_52.class_816 var1) {
      if(var1 == null) {
         return new HashMap();
      } else {
         Map var2 = this.method_2896(var1);
         if(var2 == null) {
            return new HashMap();
         } else {
            String var3 = (String)var2.get("&aip");
            if(var3 != null && this.aiB.contains(var3.toLowerCase())) {
               var2.remove("&aip");
            }

            return var2;
         }
      }
   }

   // $FF: renamed from: y (java.util.Map) void
   public void method_2886(Map<String, class_52.class_816> var1) {
      Tracker var2 = this.aiC.method_2994("_GTM_DEFAULT_TRACKER_");
      if(this.method_2898(var1, aiu)) {
         var2.send(this.method_2900((class_52.class_816)var1.get(aiv)));
      } else if(this.method_2898(var1, aiw)) {
         this.method_2894(var2, var1);
      } else {
         class_515.method_2919("Ignoring unknown tag.");
      }
   }
}
