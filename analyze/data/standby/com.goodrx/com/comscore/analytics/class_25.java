package com.comscore.analytics;

import com.comscore.analytics.Core;
import com.comscore.applications.EventType;
import java.util.HashMap;

// $FF: renamed from: com.comscore.analytics.z
class class_25 implements Runnable {
   // $FF: renamed from: a com.comscore.applications.EventType
   // $FF: synthetic field
   final EventType field_263;
   // $FF: renamed from: b java.util.HashMap
   // $FF: synthetic field
   final HashMap field_264;
   // $FF: renamed from: c com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_265;

   class_25(Core var1, EventType var2, HashMap var3) {
      this.field_265 = var1;
      this.field_263 = var2;
      this.field_264 = var3;
   }

   public void run() {
      this.field_265.method_237(this.field_263, this.field_264);
   }
}
