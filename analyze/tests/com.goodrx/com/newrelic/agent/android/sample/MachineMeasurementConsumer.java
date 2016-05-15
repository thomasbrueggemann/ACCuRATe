package com.newrelic.agent.android.sample;

import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.sample.Sampler;
import com.newrelic.agent.android.tracing.Sample;

public class MachineMeasurementConsumer extends MetricMeasurementConsumer {
   public MachineMeasurementConsumer() {
      super(MeasurementType.Machine);
   }

   public void consumeMeasurement(Measurement var1) {
   }

   protected String formatMetricName(String var1) {
      return var1;
   }

   public void onHarvest() {
      Sample var1 = Sampler.sampleMemory();
      if(var1 != null) {
         Metric var2 = new Metric("Memory/Used");
         var2.sample(var1.getValue().doubleValue());
         this.addMetric(var2);
      }

      super.onHarvest();
   }
}
