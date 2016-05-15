package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.consumer.MetricMeasurementConsumer;

public class ActivityMeasurementConsumer extends MetricMeasurementConsumer {
   public ActivityMeasurementConsumer() {
      super(MeasurementType.Activity);
   }

   protected String formatMetricName(String var1) {
      return var1;
   }
}
