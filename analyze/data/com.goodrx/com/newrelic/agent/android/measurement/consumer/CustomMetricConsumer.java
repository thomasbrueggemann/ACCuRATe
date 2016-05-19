package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.measurement.CustomMetricMeasurement;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer;
import com.newrelic.agent.android.metric.Metric;

public class CustomMetricConsumer extends MetricMeasurementConsumer {
   private static final String METRIC_PREFIX = "Custom/";

   public CustomMetricConsumer() {
      super(MeasurementType.Custom);
   }

   public void consumeMeasurement(Measurement var1) {
      Metric var2 = ((CustomMetricMeasurement)var1).getCustomMetric();
      var2.setName(this.formatMetricName(var2.getName()));
      this.addMetric(var2);
   }

   protected String formatMetricName(String var1) {
      return "Custom/" + var1;
   }
}
