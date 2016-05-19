package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.MethodMeasurement;
import com.newrelic.agent.android.measurement.producer.BaseMeasurementProducer;
import com.newrelic.agent.android.tracing.Trace;

public class MethodMeasurementProducer extends BaseMeasurementProducer {
   public MethodMeasurementProducer() {
      super(MeasurementType.Method);
   }

   public void produceMeasurement(Trace var1) {
      this.produceMeasurement(new MethodMeasurement(var1.displayName, var1.scope, var1.entryTimestamp, var1.exitTimestamp, var1.exclusiveTime, var1.getCategory()));
   }
}
