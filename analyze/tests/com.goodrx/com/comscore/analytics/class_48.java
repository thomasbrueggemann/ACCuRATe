package com.comscore.analytics;

import com.comscore.analytics.Core;
import com.comscore.utils.TransmissionMode;

// $FF: renamed from: com.comscore.analytics.j
class class_48 implements Runnable {
   // $FF: renamed from: a com.comscore.utils.TransmissionMode
   // $FF: synthetic field
   final TransmissionMode field_308;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_309;

   class_48(Core var1, TransmissionMode var2) {
      this.field_309 = var1;
      this.field_308 = var2;
   }

   public void run() {
      Core.method_218(this.field_309, this.field_308);
   }
}
