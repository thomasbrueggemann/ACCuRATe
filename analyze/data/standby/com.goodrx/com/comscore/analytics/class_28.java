package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.e
class class_28 implements Runnable {
   // $FF: renamed from: a java.lang.String
   // $FF: synthetic field
   final String field_269;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_270;

   class_28(Core var1, String var2) {
      this.field_270 = var1;
      this.field_269 = var2;
   }

   public void run() {
      Core.method_219(this.field_270, this.field_269);
   }
}
