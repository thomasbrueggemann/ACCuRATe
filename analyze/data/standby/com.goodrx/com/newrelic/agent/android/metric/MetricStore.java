package com.newrelic.agent.android.metric;

import com.newrelic.agent.android.metric.Metric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class MetricStore {
   private final Map<String, Map<String, Metric>> metricStore = new ConcurrentHashMap();

   public void add(Metric var1) {
      String var2 = var1.getStringScope();
      String var3 = var1.getName();
      if(!this.metricStore.containsKey(var2)) {
         this.metricStore.put(var2, new HashMap());
      }

      if(((Map)this.metricStore.get(var2)).containsKey(var3)) {
         ((Metric)((Map)this.metricStore.get(var2)).get(var3)).aggregate(var1);
      } else {
         ((Map)this.metricStore.get(var2)).put(var3, var1);
      }
   }

   public void clear() {
      this.metricStore.clear();
   }

   public Metric get(String var1) {
      return this.get(var1, "");
   }

   public Metric get(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public List<Metric> getAll() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.metricStore.entrySet().iterator();

      while(var2.hasNext()) {
         Iterator var3 = ((Map)((Entry)var2.next()).getValue()).entrySet().iterator();

         while(var3.hasNext()) {
            var1.add(((Entry)var3.next()).getValue());
         }
      }

      return var1;
   }

   public List<Metric> getAllByScope(String param1) {
      // $FF: Couldn't be decompiled
   }

   public List<Metric> getAllUnscoped() {
      return this.getAllByScope("");
   }

   public boolean isEmpty() {
      return this.metricStore.isEmpty();
   }

   public void remove(Metric var1) {
      String var2 = var1.getStringScope();
      String var3 = var1.getName();
      if(this.metricStore.containsKey(var2) && ((Map)this.metricStore.get(var2)).containsKey(var3)) {
         ((Map)this.metricStore.get(var2)).remove(var3);
      }
   }

   public void removeAll(List<Metric> param1) {
      // $FF: Couldn't be decompiled
   }

   public List<Metric> removeAllWithScope(String var1) {
      List var2 = this.getAllByScope(var1);
      if(!var2.isEmpty()) {
         this.removeAll(var2);
      }

      return var2;
   }
}
