package com.comscore.measurement;

import com.comscore.measurement.Measurement;
import com.comscore.measurement.MeasurementDispatcher;

// $FF: renamed from: com.comscore.measurement.a
class class_53 implements Runnable {
   // $FF: renamed from: a com.comscore.measurement.Measurement
   // $FF: synthetic field
   final Measurement field_452;
   // $FF: renamed from: b com.comscore.measurement.MeasurementDispatcher
   // $FF: synthetic field
   final MeasurementDispatcher field_453;

   class_53(MeasurementDispatcher var1, Measurement var2) {
      this.field_453 = var1;
      this.field_452 = var2;
   }

   public void run() {
      MeasurementDispatcher.method_309(this.field_453, this.field_452);
   }
}
