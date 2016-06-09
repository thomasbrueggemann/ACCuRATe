package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.a
class class_32 implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_278;

   class_32(Core var1) {
      this.field_278 = var1;
   }

   public void run() {
      Core.method_211(this.field_278).resetVisitorId();
   }
}
