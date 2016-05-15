package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.r
class class_40 implements Runnable {
   // $FF: renamed from: a int
   // $FF: synthetic field
   final int field_292;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_293;

   class_40(Core var1, int var2) {
      this.field_293 = var1;
      this.field_292 = var2;
   }

   public void run() {
      this.field_293.field_344.setCacheWaitMinutes(this.field_292);
   }
}
