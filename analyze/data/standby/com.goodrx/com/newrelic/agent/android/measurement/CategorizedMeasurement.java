package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;

public class CategorizedMeasurement extends BaseMeasurement {
   private MetricCategory category;

   public CategorizedMeasurement(MeasurementType var1) {
      super(var1);
   }

   public MetricCategory getCategory() {
      return this.category;
   }

   public void setCategory(MetricCategory var1) {
      this.category = var1;
   }
}
