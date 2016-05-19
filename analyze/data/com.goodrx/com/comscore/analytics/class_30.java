package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.g
class class_30 implements Runnable {
   // $FF: renamed from: a java.lang.String
   // $FF: synthetic field
   final String field_273;
   // $FF: renamed from: b java.lang.String
   // $FF: synthetic field
   final String field_274;
   // $FF: renamed from: c com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_275;

   class_30(Core var1, String var2, String var3) {
      this.field_275 = var1;
      this.field_273 = var2;
      this.field_274 = var3;
   }

   public void run() {
      Core.method_215(this.field_275, this.field_273, this.field_274);
   }
}
