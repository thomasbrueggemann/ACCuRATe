package com.newrelic.agent.android.instrumentation;

import java.util.HashMap;
import java.util.Map;

public enum MetricCategory {
   DATABASE("Database"),
   IMAGE("Images"),
   JSON("JSON"),
   NETWORK("Network"),
   NONE("None"),
   VIEW_LAYOUT("Layout"),
   VIEW_LOADING("View Loading");

   private static final Map<String, MetricCategory> methodMap;
   private String categoryName;

   static {
      MetricCategory[] var0 = new MetricCategory[]{NONE, VIEW_LOADING, VIEW_LAYOUT, DATABASE, IMAGE, JSON, NETWORK};
      methodMap = new HashMap() {
         {
            this.put("onCreate", MetricCategory.VIEW_LOADING);
         }
      };
   }

   private MetricCategory(String var3) {
      this.categoryName = var3;
   }

   public static MetricCategory categoryForMethod(String var0) {
      MetricCategory var3;
      if(var0 == null) {
         var3 = NONE;
      } else {
         int var1 = var0.indexOf("#");
         String var2 = null;
         if(var1 >= 0) {
            var2 = var0.substring(var1 + 1);
         }

         var3 = (MetricCategory)methodMap.get(var2);
         if(var3 == null) {
            return NONE;
         }
      }

      return var3;
   }

   public String getCategoryName() {
      return this.categoryName;
   }
}
