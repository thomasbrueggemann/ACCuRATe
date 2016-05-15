package com.comscore.streaming;

import com.comscore.applications.ApplicationMeasurement;
import com.comscore.applications.EventType;
import com.comscore.streaming.StreamSense;
import java.util.HashMap;

// $FF: renamed from: com.comscore.streaming.e
class class_65 implements Runnable {
   // $FF: renamed from: a java.util.HashMap
   // $FF: synthetic field
   final HashMap field_496;
   // $FF: renamed from: b java.lang.String
   // $FF: synthetic field
   final String field_497;
   // $FF: renamed from: c com.comscore.streaming.StreamSense
   // $FF: synthetic field
   final StreamSense field_498;

   class_65(StreamSense var1, HashMap var2, String var3) {
      this.field_498 = var1;
      this.field_496 = var2;
      this.field_497 = var3;
   }

   public void run() {
      ApplicationMeasurement var1 = ApplicationMeasurement.newApplicationMeasurement(this.field_498.field_145, EventType.HIDDEN, this.field_496, this.field_497);
      this.field_498.field_145.getMeasurementDispatcher().sendMeasurmement(var1, false);
   }
}
