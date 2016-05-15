package com.newrelic.agent.android.stats;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.metric.Metric;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class StatsEngine extends HarvestAdapter {
   public static final StatsEngine INSTANCE = new StatsEngine();
   public boolean enabled = true;
   private ConcurrentHashMap<String, Metric> statsMap = new ConcurrentHashMap();

   public static void disable() {
      synchronized(StatsEngine.class){}

      try {
         INSTANCE.enabled = false;
      } finally {
         ;
      }

   }

   public static void enable() {
      synchronized(StatsEngine.class){}

      try {
         INSTANCE.enabled = true;
      } finally {
         ;
      }

   }

   public static StatsEngine get() {
      return INSTANCE;
   }

   private Metric lazyGet(String var1) {
      Metric var2 = (Metric)this.statsMap.get(var1);
      if(var2 == null) {
         var2 = new Metric(var1);
         if(this.enabled) {
            this.statsMap.put(var1, var2);
         }
      }

      return var2;
   }

   public static void populateMetrics() {
      Iterator var0 = INSTANCE.getStatsMap().entrySet().iterator();

      while(var0.hasNext()) {
         TaskQueue.queue((Metric)((Entry)var0.next()).getValue());
      }

   }

   public static void reset() {
      INSTANCE.getStatsMap().clear();
   }

   public ConcurrentHashMap<String, Metric> getStatsMap() {
      return this.statsMap;
   }

   public void inc(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void inc(String param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   public void onHarvest() {
      populateMetrics();
      reset();
   }

   public void sample(String param1, float param2) {
      // $FF: Couldn't be decompiled
   }

   public void sampleTimeMs(String var1, long var2) {
      this.sample(var1, (float)var2 / 1000.0F);
   }
}
