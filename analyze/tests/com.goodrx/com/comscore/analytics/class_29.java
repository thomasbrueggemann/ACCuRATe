package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.h
class class_29 implements Runnable {
   // $FF: renamed from: a java.lang.String
   // $FF: synthetic field
   final String field_271;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_272;

   class_29(Core var1, String var2) {
      this.field_272 = var1;
      this.field_271 = var2;
   }

   public void run() {
      Core.method_225(this.field_272, this.field_271);
   }
}
