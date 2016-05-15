package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer;

public class MethodMeasurementConsumer extends MetricMeasurementConsumer {
   private static final String METRIC_PREFIX = "Method/";

   public MethodMeasurementConsumer() {
      super(MeasurementType.Method);
   }

   protected String formatMetricName(String var1) {
      return "Method/" + var1.replace("#", "/");
   }
}
