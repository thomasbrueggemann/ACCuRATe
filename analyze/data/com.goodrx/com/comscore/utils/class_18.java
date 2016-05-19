package com.comscore.utils;

import com.comscore.measurement.Measurement;
import com.comscore.utils.OfflineMeasurementsCache;

// $FF: renamed from: com.comscore.utils.c
class class_18 implements Runnable {
   // $FF: renamed from: a com.comscore.measurement.Measurement
   // $FF: synthetic field
   final Measurement field_131;
   // $FF: renamed from: b com.comscore.utils.OfflineMeasurementsCache
   // $FF: synthetic field
   final OfflineMeasurementsCache field_132;

   class_18(OfflineMeasurementsCache var1, Measurement var2) {
      this.field_132 = var1;
      this.field_131 = var2;
   }

   public void run() {
      this.field_132.saveEvent(this.field_131.retrieveLabelsAsString(this.field_132.field_249.getMeasurementLabelOrder()));
   }
}
