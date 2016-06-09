package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;

public class ActivityMeasurement extends BaseMeasurement {
   public ActivityMeasurement(String var1, long var2, long var4) {
      super(MeasurementType.Activity);
      this.setName(var1);
      this.setStartTime(var2);
      this.setEndTime(var4);
   }
}
