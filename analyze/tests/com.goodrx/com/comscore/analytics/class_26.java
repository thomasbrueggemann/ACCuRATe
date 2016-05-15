package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.y
class class_26 implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_266;

   class_26(Core var1) {
      this.field_266 = var1;
   }

   public void run() {
      this.field_266.update();
   }
}
