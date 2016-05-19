package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.w
class class_37 implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_286;

   class_37(Core var1) {
      this.field_286 = var1;
   }

   public void run() {
      if(!this.field_286.method_272() && this.field_286.field_318.get() > 0) {
         this.field_286.field_318.getAndDecrement();
         this.field_286.method_260();
      }
   }
}
