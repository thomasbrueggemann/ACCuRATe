package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricStore;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import java.util.HashMap;
import java.util.Iterator;

public class MachineMeasurements extends HarvestableArray {
   private final MetricStore metrics = new MetricStore();

   public void addMetric(Metric var1) {
      this.metrics.add(var1);
   }

   public void addMetric(String var1, double var2) {
      Metric var4 = new Metric(var1);
      var4.sample(var2);
      this.addMetric(var4);
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.metrics.getAll().iterator();

      while(var2.hasNext()) {
         Metric var3 = (Metric)var2.next();
         JsonArray var4 = new JsonArray();
         HashMap var5 = new HashMap();
         var5.put("name", var3.getName());
         var5.put("scope", var3.getStringScope());
         var4.add((new Gson()).toJsonTree(var5, GSON_STRING_MAP_TYPE));
         var4.add(var3.asJsonObject());
         var1.add(var4);
      }

      return var1;
   }

   public void clear() {
      this.metrics.clear();
   }

   public MetricStore getMetrics() {
      return this.metrics;
   }

   public boolean isEmpty() {
      return this.metrics.isEmpty();
   }
}
