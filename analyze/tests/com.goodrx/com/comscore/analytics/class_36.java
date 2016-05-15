package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.v
class class_36 implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_285;

   class_36(Core var1) {
      this.field_285 = var1;
   }

   public void run() {
      this.field_285.field_344.flush();
   }
}
