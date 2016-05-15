package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.d
class class_33 implements Runnable {
   // $FF: renamed from: a java.lang.String
   // $FF: synthetic field
   final String field_279;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_280;

   class_33(Core var1, String var2) {
      this.field_280 = var1;
      this.field_279 = var2;
   }

   public void run() {
      Core.method_214(this.field_280, this.field_279);
   }
}
