package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.o
class class_45 implements Runnable {
   // $FF: renamed from: a int
   // $FF: synthetic field
   final int field_302;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_303;

   class_45(Core var1, int var2) {
      this.field_303 = var1;
      this.field_302 = var2;
   }

   public void run() {
      this.field_303.field_344.setCacheMaxMeasurements(this.field_302);
   }
}
