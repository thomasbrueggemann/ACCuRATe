package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.consumer.BaseMeasurementConsumer;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricStore;
import java.util.Iterator;

public abstract class MetricMeasurementConsumer extends BaseMeasurementConsumer implements HarvestLifecycleAware {
   protected MetricStore metrics = new MetricStore();
   protected boolean recordUnscopedMetrics = true;

   public MetricMeasurementConsumer(MeasurementType var1) {
      super(var1);
      Harvest.addHarvestListener(this);
   }

   protected void addMetric(Metric var1) {
      Metric var2;
      if(var1.getScope() != null) {
         var2 = this.metrics.get(var1.getName(), var1.getScope());
      } else {
         var2 = this.metrics.get(var1.getName());
      }

      if(var2 != null) {
         var2.aggregate(var1);
      } else {
         this.metrics.add(var1);
      }
   }

   public void consumeMeasurement(Measurement var1) {
      String var2 = this.formatMetricName(var1.getName());
      String var3 = var1.getScope();
      double var4 = var1.getEndTimeInSeconds() - var1.getStartTimeInSeconds();
      if(var3 != null) {
         Metric var7 = this.metrics.get(var2, var3);
         if(var7 == null) {
            var7 = new Metric(var2, var3);
            this.metrics.add(var7);
         }

         var7.sample(var4);
         var7.addExclusive(var1.getExclusiveTimeInSeconds());
      }

      if(this.recordUnscopedMetrics) {
         Metric var6 = this.metrics.get(var2);
         if(var6 == null) {
            var6 = new Metric(var2);
            this.metrics.add(var6);
         }

         var6.sample(var4);
         var6.addExclusive(var1.getExclusiveTimeInSeconds());
      }
   }

   protected abstract String formatMetricName(String var1);

   public void onHarvest() {
      Iterator var1 = this.metrics.getAll().iterator();

      while(var1.hasNext()) {
         Harvest.addMetric((Metric)var1.next());
      }

   }

   public void onHarvestComplete() {
      this.metrics.clear();
   }

   public void onHarvestError() {
      this.metrics.clear();
   }

   public void onHarvestSendFailed() {
      this.metrics.clear();
   }
}
