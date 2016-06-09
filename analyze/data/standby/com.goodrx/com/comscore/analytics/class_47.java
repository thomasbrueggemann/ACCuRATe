package com.comscore.analytics;

import com.comscore.analytics.Core;
import com.comscore.utils.TransmissionMode;

// $FF: renamed from: com.comscore.analytics.i
class class_47 implements Runnable {
   // $FF: renamed from: a com.comscore.utils.TransmissionMode
   // $FF: synthetic field
   final TransmissionMode field_306;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_307;

   class_47(Core var1, TransmissionMode var2) {
      this.field_307 = var1;
      this.field_306 = var2;
   }

   public void run() {
      Core.method_213(this.field_307, this.field_306);
   }
}
