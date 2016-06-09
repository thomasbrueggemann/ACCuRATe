package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.measurement.CategorizedMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.metric.Metric;

public class CustomMetricMeasurement extends CategorizedMeasurement {
   private Metric customMetric;

   public CustomMetricMeasurement() {
      super(MeasurementType.Custom);
   }

   public CustomMetricMeasurement(String var1, int var2, double var3, double var5) {
      this();
      this.setName(var1);
      this.customMetric = new Metric(var1);
      this.customMetric.sample(var3);
      this.customMetric.setCount((long)var2);
      this.customMetric.setExclusive(Double.valueOf(var5));
   }

   public Metric getCustomMetric() {
      return this.customMetric;
   }
}
