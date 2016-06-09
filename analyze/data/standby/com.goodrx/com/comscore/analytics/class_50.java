package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.l
class class_50 implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_312;

   class_50(Core var1) {
      this.field_312 = var1;
   }

   public void run() {
      if(!this.field_312.method_272()) {
         if(this.field_312.field_334 < 0) {
            this.field_312.field_334 = 0;
         }

         this.field_312.field_318.getAndIncrement();
         this.field_312.method_260();
      }
   }
}
