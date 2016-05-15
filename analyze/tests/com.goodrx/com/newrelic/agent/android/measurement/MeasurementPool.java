package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.producer.BaseMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class MeasurementPool extends BaseMeasurementProducer implements MeasurementConsumer {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private final Collection<MeasurementConsumer> consumers = new CopyOnWriteArrayList();
   private final Collection<MeasurementProducer> producers = new CopyOnWriteArrayList();

   public MeasurementPool() {
      super(MeasurementType.Any);
      this.addMeasurementProducer(this);
   }

   public void addMeasurementConsumer(MeasurementConsumer param1) {
      // $FF: Couldn't be decompiled
   }

   public void addMeasurementProducer(MeasurementProducer param1) {
      // $FF: Couldn't be decompiled
   }

   public void broadcastMeasurements() {
      // $FF: Couldn't be decompiled
   }

   public void consumeMeasurement(Measurement var1) {
      this.produceMeasurement(var1);
   }

   public void consumeMeasurements(Collection<Measurement> var1) {
      this.produceMeasurements(var1);
   }

   public Collection<MeasurementConsumer> getMeasurementConsumers() {
      return this.consumers;
   }

   public Collection<MeasurementProducer> getMeasurementProducers() {
      return this.producers;
   }

   public MeasurementType getMeasurementType() {
      return MeasurementType.Any;
   }

   public void removeMeasurementConsumer(MeasurementConsumer param1) {
      // $FF: Couldn't be decompiled
   }

   public void removeMeasurementProducer(MeasurementProducer param1) {
      // $FF: Couldn't be decompiled
   }
}
