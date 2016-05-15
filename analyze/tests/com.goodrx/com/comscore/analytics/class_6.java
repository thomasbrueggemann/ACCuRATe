package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.ah
class class_6 implements Runnable {
   // $FF: renamed from: a java.lang.String
   // $FF: synthetic field
   final String field_13;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_14;

   class_6(Core var1, String var2) {
      this.field_14 = var1;
      this.field_13 = var2;
   }

   public void run() {
      this.field_14.method_239(this.field_13);
   }
}
