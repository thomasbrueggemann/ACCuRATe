package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.ac
class class_8 implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_17;

   class_8(Core var1) {
      this.field_17 = var1;
   }

   public void run() {
      if(!this.field_17.method_272()) {
         this.field_17.field_383.getAndIncrement();
         this.field_17.method_260();
      }
   }
}
