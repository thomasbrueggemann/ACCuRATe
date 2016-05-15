package com.newrelic.agent.android;

import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.activity.NamedActivity;
import com.newrelic.agent.android.measurement.MeasurementException;
import com.newrelic.agent.android.measurement.MeasurementPool;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MeasurementEngine {
   private final Map<String, MeasuredActivity> activities = new ConcurrentHashMap();
   private final MeasurementPool rootMeasurementPool = new MeasurementPool();

   public void addMeasurementConsumer(MeasurementConsumer var1) {
      this.rootMeasurementPool.addMeasurementConsumer(var1);
   }

   public void addMeasurementProducer(MeasurementProducer var1) {
      this.rootMeasurementPool.addMeasurementProducer(var1);
   }

   public void broadcastMeasurements() {
      this.rootMeasurementPool.broadcastMeasurements();
   }

   public void clear() {
      this.activities.clear();
   }

   public MeasuredActivity endActivity(String var1) {
      MeasuredActivity var2 = (MeasuredActivity)this.activities.get(var1);
      if(var2 == null) {
         throw new MeasurementException("Activity \'" + var1 + "\' has not been started.");
      } else {
         this.endActivity(var2);
         return var2;
      }
   }

   public void endActivity(MeasuredActivity var1) {
      this.rootMeasurementPool.removeMeasurementConsumer(var1.getMeasurementPool());
      this.activities.remove(var1.getName());
      var1.finish();
   }

   public void removeMeasurementConsumer(MeasurementConsumer var1) {
      this.rootMeasurementPool.removeMeasurementConsumer(var1);
   }

   public void removeMeasurementProducer(MeasurementProducer var1) {
      this.rootMeasurementPool.removeMeasurementProducer(var1);
   }

   public void renameActivity(String var1, String var2) {
      MeasuredActivity var3 = (MeasuredActivity)this.activities.remove(var1);
      if(var3 != null && var3 instanceof NamedActivity) {
         this.activities.put(var2, var3);
         ((NamedActivity)var3).rename(var2);
      }

   }

   public MeasuredActivity startActivity(String var1) {
      if(this.activities.containsKey(var1)) {
         throw new MeasurementException("An activity with the name \'" + var1 + "\' has already started.");
      } else {
         NamedActivity var2 = new NamedActivity(var1);
         this.activities.put(var1, var2);
         MeasurementPool var4 = new MeasurementPool();
         var2.setMeasurementPool(var4);
         this.rootMeasurementPool.addMeasurementConsumer(var4);
         return var2;
      }
   }
}
