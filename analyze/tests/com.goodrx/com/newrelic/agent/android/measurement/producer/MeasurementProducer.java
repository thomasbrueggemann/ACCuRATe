package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import java.util.Collection;

public interface MeasurementProducer {
   Collection<Measurement> drainMeasurements();

   MeasurementType getMeasurementType();

   void produceMeasurement(Measurement var1);

   void produceMeasurements(Collection<Measurement> var1);
}
