package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.ad
class class_11 implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_21;

   class_11(Core var1) {
      this.field_21 = var1;
   }

   public void run() {
      if(!this.field_21.method_272() && this.field_21.field_383.get() > 0) {
         this.field_21.field_383.getAndDecrement();
         this.field_21.method_260();
      }
   }
}
