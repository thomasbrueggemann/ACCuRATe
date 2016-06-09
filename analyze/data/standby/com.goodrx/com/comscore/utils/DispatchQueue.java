package com.comscore.utils;

import com.comscore.analytics.Core;
import com.comscore.measurement.Measurement;
import com.comscore.utils.CSLog;
import com.comscore.utils.TransmissionMode;
import java.util.concurrent.ConcurrentLinkedQueue;

@Deprecated
public class DispatchQueue extends ConcurrentLinkedQueue<Runnable> {
   public static final int LIVE_TRANSMISSION_MODE = 0;
   public static final int MEASUREMENT_LABEL_ORDER = 3;
   public static final int OFFLINE_TRANSMISSION_MODE = 1;
   public static final int SECURE_MODE = 2;
   // $FF: renamed from: a long
   private static final long field_106 = 1L;
   // $FF: renamed from: b com.comscore.analytics.Core
   private Core field_107;

   public DispatchQueue(Core var1) {
      this.field_107 = var1;
   }

   @Deprecated
   public void enqueue(Measurement var1) {
      this.offer(var1);
   }

   @Deprecated
   public void enqueueSettingChange(int var1, Object var2) {
      switch(var1) {
      case 0:
         this.field_107.allowLiveTransmission((TransmissionMode)var2, true);
         return;
      case 1:
         this.field_107.allowOfflineTransmission((TransmissionMode)var2, true);
         return;
      case 2:
         this.field_107.setSecure(((Boolean)var2).booleanValue(), true);
         return;
      case 3:
         this.field_107.setMeasurementLabelOrder((String[])((String[])var2), true);
         return;
      default:
      }
   }

   @Deprecated
   public boolean offer(Measurement var1) {
      CSLog.method_372(this, "offer(): " + var1.retrieveLabelsAsString(this.field_107.getMeasurementLabelOrder()));
      return this.field_107.getMeasurementDispatcher().sendMeasurmement(var1, true);
   }

   @Deprecated
   public boolean offer(Runnable var1) {
      return this.field_107.getTaskExecutor().execute(var1, true);
   }

   @Deprecated
   public void processAggregateData(Measurement var1) {
      this.field_107.getMeasurementDispatcher().addAggregateData(var1);
   }

   @Deprecated
   public void processEventCounter(Measurement var1) {
      this.field_107.getMeasurementDispatcher().addEventCounter(var1);
   }

   @Deprecated
   public void stop() {
      this.field_107.getTaskExecutor().removeAllEnqueuedTasks();
   }
}
