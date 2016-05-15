package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import java.util.Collection;
import java.util.Iterator;

public class BaseMeasurementConsumer extends HarvestAdapter implements MeasurementConsumer {
   private final MeasurementType measurementType;

   public BaseMeasurementConsumer(MeasurementType var1) {
      this.measurementType = var1;
   }

   public void consumeMeasurement(Measurement var1) {
   }

   public void consumeMeasurements(Collection<Measurement> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.consumeMeasurement((Measurement)var2.next());
      }

   }

   public MeasurementType getMeasurementType() {
      return this.measurementType;
   }
}
