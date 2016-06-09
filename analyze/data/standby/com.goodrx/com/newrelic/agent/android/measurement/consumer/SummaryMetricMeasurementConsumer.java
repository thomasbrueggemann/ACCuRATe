package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.CustomMetricMeasurement;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.MethodMeasurement;
import com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SummaryMetricMeasurementConsumer extends MetricMeasurementConsumer implements TraceLifecycleAware {
   private static final String ACTIVITY_METRIC_PREFIX = "Mobile/Activity/Summary/Name/";
   private static final String METRIC_PREFIX = "Mobile/Summary/";
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private final List<ActivityTrace> completedTraces = new CopyOnWriteArrayList();

   public SummaryMetricMeasurementConsumer() {
      super(MeasurementType.Any);
      this.recordUnscopedMetrics = false;
      TraceMachine.addTraceListener(this);
   }

   private void consumeCustomMeasurement(CustomMetricMeasurement var1) {
      if(var1.getCategory() != null && var1.getCategory() != MetricCategory.NONE) {
         BaseMeasurement var2 = new BaseMeasurement(var1);
         var2.setName(var1.getCategory().getCategoryName());
         super.consumeMeasurement(var2);
      }
   }

   private void consumeMethodMeasurement(MethodMeasurement var1) {
      if(var1.getCategory() == null || var1.getCategory() == MetricCategory.NONE) {
         var1.setCategory(MetricCategory.categoryForMethod(var1.getName()));
         if(var1.getCategory() == MetricCategory.NONE) {
            return;
         }
      }

      BaseMeasurement var2 = new BaseMeasurement(var1);
      var2.setName(var1.getCategory().getCategoryName());
      super.consumeMeasurement(var2);
   }

   private void consumeNetworkMeasurement(HttpTransactionMeasurement var1) {
      BaseMeasurement var2 = new BaseMeasurement(var1);
      var2.setName(MetricCategory.NETWORK.getCategoryName());
      super.consumeMeasurement(var2);
   }

   private void summarizeActivityMetrics(ActivityTrace var1) {
      Trace var2 = var1.rootTrace;
      List var3 = this.metrics.removeAllWithScope(var2.metricName);
      List var4 = this.metrics.removeAllWithScope(var2.metricBackgroundName);
      HashMap var5 = new HashMap();
      Iterator var6 = var3.iterator();

      while(var6.hasNext()) {
         Metric var22 = (Metric)var6.next();
         var5.put(var22.getName(), var22);
      }

      Iterator var7 = var4.iterator();

      while(var7.hasNext()) {
         Metric var20 = (Metric)var7.next();
         if(var5.containsKey(var20.getName())) {
            ((Metric)var5.get(var20.getName())).aggregate(var20);
         } else {
            var5.put(var20.getName(), var20);
         }
      }

      double var8 = 0.0D;

      for(Iterator var10 = var5.values().iterator(); var10.hasNext(); var8 += ((Metric)var10.next()).getExclusive()) {
         ;
      }

      double var11 = (double)(var2.exitTimestamp - var2.entryTimestamp) / 1000.0D;
      Iterator var13 = var5.values().iterator();

      while(var13.hasNext()) {
         Metric var14 = (Metric)var13.next();
         double var15 = 0.0D;
         if(var14.getExclusive() != 0.0D && var8 != 0.0D) {
            var15 = var14.getExclusive() / var8;
         }

         double var17 = var15 * var11;
         var14.setTotal(Double.valueOf(var17));
         var14.setExclusive(Double.valueOf(var17));
         var14.setMinFieldValue(Double.valueOf(0.0D));
         var14.setMaxFieldValue(Double.valueOf(0.0D));
         var14.setSumOfSquares(Double.valueOf(0.0D));
         var14.setScope("Mobile/Activity/Summary/Name/" + var2.displayName);
         Harvest.addMetric(var14);
         Metric var19 = new Metric(var14);
         var19.setScope((String)null);
         Harvest.addMetric(var19);
      }

      this.summarizeActivityNetworkMetrics(var1);
   }

   private void summarizeActivityNetworkMetrics(ActivityTrace var1) {
      String var2 = var1.getActivityName();
      if(var1.networkCountMetric.getCount() > 0L) {
         String var4 = var1.networkCountMetric.getName();
         var1.networkCountMetric.setName(var4.replace("<activity>", var2));
         var1.networkCountMetric.setCount(1L);
         var1.networkCountMetric.setMinFieldValue(Double.valueOf(var1.networkCountMetric.getTotal()));
         var1.networkCountMetric.setMaxFieldValue(Double.valueOf(var1.networkCountMetric.getTotal()));
         Harvest.addMetric(var1.networkCountMetric);
      }

      if(var1.networkTimeMetric.getCount() > 0L) {
         String var3 = var1.networkTimeMetric.getName();
         var1.networkTimeMetric.setName(var3.replace("<activity>", var2));
         var1.networkTimeMetric.setCount(1L);
         var1.networkTimeMetric.setMinFieldValue(Double.valueOf(var1.networkTimeMetric.getTotal()));
         var1.networkTimeMetric.setMaxFieldValue(Double.valueOf(var1.networkTimeMetric.getTotal()));
         Harvest.addMetric(var1.networkTimeMetric);
      }

   }

   public void consumeMeasurement(Measurement var1) {
      if(var1 != null) {
         switch(null.$SwitchMap$com$newrelic$agent$android$measurement$MeasurementType[var1.getType().ordinal()]) {
         case 1:
            this.consumeMethodMeasurement((MethodMeasurement)var1);
            return;
         case 2:
            this.consumeNetworkMeasurement((HttpTransactionMeasurement)var1);
            return;
         case 3:
            this.consumeCustomMeasurement((CustomMetricMeasurement)var1);
            return;
         default:
         }
      }
   }

   protected String formatMetricName(String var1) {
      return "Mobile/Summary/" + var1.replace("#", "/");
   }

   public void onEnterMethod() {
   }

   public void onExitMethod() {
   }

   public void onHarvest() {
      if(this.metrics.getAll().size() != 0 && this.completedTraces.size() != 0) {
         Iterator var1 = this.completedTraces.iterator();

         while(var1.hasNext()) {
            this.summarizeActivityMetrics((ActivityTrace)var1.next());
         }

         if(this.metrics.getAll().size() != 0) {
            log.debug("Not all metrics were summarized!");
         }

         this.completedTraces.clear();
      }
   }

   public void onHarvestComplete() {
   }

   public void onHarvestError() {
   }

   public void onTraceComplete(ActivityTrace var1) {
      if(!this.completedTraces.contains(var1)) {
         this.completedTraces.add(var1);
      }

   }

   public void onTraceStart(ActivityTrace var1) {
   }
}
