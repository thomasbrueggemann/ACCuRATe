package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.aa
class class_7 implements Runnable {
   // $FF: renamed from: a boolean
   // $FF: synthetic field
   final boolean field_15;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_16;

   class_7(Core var1, boolean var2) {
      this.field_16 = var1;
      this.field_15 = var2;
   }

   public void run() {
      if(this.field_15 && !Core.method_223(this.field_16)) {
         Core.method_217(this.field_16, true);
         this.field_16.setErrorHandlingEnabled(Core.method_227(this.field_16));
         this.field_16.reset();
         this.field_16.getConnectivityReceiver().start();
         this.field_16.getKeepAlive().start(3000);
      } else if(!this.field_15 && Core.method_223(this.field_16)) {
         Core.method_217(this.field_16, false);
         Core.method_224(this.field_16, this.field_16.field_351);
         if(Thread.getDefaultUncaughtExceptionHandler() != this.field_16.field_352) {
            Thread.setDefaultUncaughtExceptionHandler(this.field_16.field_352);
         }

         this.field_16.getConnectivityReceiver().stop();
         this.field_16.getKeepAlive().stop();
         this.field_16.getOfflineCache().clear();
         this.field_16.field_364.removeAllEnqueuedTasks();
         return;
      }

   }
}
