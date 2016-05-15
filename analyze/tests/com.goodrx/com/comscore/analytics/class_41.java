package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.s
class class_41 implements Runnable {
   // $FF: renamed from: a int
   // $FF: synthetic field
   final int field_294;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_295;

   class_41(Core var1, int var2) {
      this.field_295 = var1;
      this.field_294 = var2;
   }

   public void run() {
      this.field_295.field_344.setCacheMeasurementExpiry(this.field_294);
   }
}
