package com.comscore.analytics;

import com.comscore.analytics.Core;
import com.comscore.analytics.SessionState;
import com.comscore.utils.Date;

// $FF: renamed from: com.comscore.analytics.ae
class class_10 implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_20;

   class_10(Core var1) {
      this.field_20 = var1;
   }

   public void run() {
      if(!this.field_20.method_272()) {
         if(this.field_20.field_334 < 0) {
            this.field_20.field_334 = 0;
         }

         if(this.field_20.field_335 < 0) {
            this.field_20.field_335 = 0;
         }

         this.field_20.field_340 = Date.unixTime();
         Core var1 = this.field_20;
         ++var1.field_339;
         if(this.field_20.field_329 != SessionState.ACTIVE_USER) {
            this.field_20.method_260();
         } else {
            this.field_20.method_261();
         }
      }
   }
}
