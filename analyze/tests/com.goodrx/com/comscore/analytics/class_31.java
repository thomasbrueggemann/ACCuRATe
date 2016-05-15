package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.b
class class_31 implements Runnable {
   // $FF: renamed from: a java.lang.String
   // $FF: synthetic field
   final String field_276;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_277;

   class_31(Core var1, String var2) {
      this.field_277 = var1;
      this.field_276 = var2;
   }

   public void run() {
      this.field_277.field_344.setUrl(this.field_276);
   }
}
