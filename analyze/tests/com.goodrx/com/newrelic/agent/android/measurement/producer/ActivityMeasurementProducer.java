package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.measurement.ActivityMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.producer.BaseMeasurementProducer;

public class ActivityMeasurementProducer extends BaseMeasurementProducer {
   public ActivityMeasurementProducer() {
      super(MeasurementType.Activity);
   }

   public void produceMeasurement(MeasuredActivity var1) {
      super.produceMeasurement(new ActivityMeasurement(var1.getMetricName(), var1.getStartTime(), var1.getEndTime()));
      super.produceMeasurement(new ActivityMeasurement(var1.getBackgroundMetricName(), var1.getStartTime(), var1.getEndTime()));
   }
}
