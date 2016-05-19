package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.measurement.CategorizedMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;

public class MethodMeasurement extends CategorizedMeasurement {
   public MethodMeasurement(String var1, String var2, long var3, long var5, long var7, MetricCategory var9) {
      super(MeasurementType.Method);
      this.setName(var1);
      this.setScope(var2);
      this.setStartTime(var3);
      this.setEndTime(var5);
      this.setExclusiveTime(var7);
      this.setCategory(var9);
   }
}
