package com.comscore.analytics;

import com.comscore.analytics.Core;

public class Core$UserInteractionTask implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_610;

   public Core$UserInteractionTask(Core var1) {
      this.field_610 = var1;
   }

   public void run() {
      if(Core.method_223(this.field_610) && this.field_610.field_342 != null) {
         this.field_610.field_364.removeEnqueuedTask(this.field_610.field_342);
         this.field_610.field_342 = null;
         this.field_610.method_260();
      }
   }
}
