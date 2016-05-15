package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import java.util.ArrayList;
import java.util.Collection;

public class BaseMeasurementProducer implements MeasurementProducer {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private final MeasurementType producedMeasurementType;
   private final ArrayList<Measurement> producedMeasurements = new ArrayList();

   public BaseMeasurementProducer(MeasurementType var1) {
      this.producedMeasurementType = var1;
   }

   public Collection<Measurement> drainMeasurements() {
      // $FF: Couldn't be decompiled
   }

   public MeasurementType getMeasurementType() {
      return this.producedMeasurementType;
   }

   public void produceMeasurement(Measurement param1) {
      // $FF: Couldn't be decompiled
   }

   public void produceMeasurements(Collection<Measurement> param1) {
      // $FF: Couldn't be decompiled
   }
}
