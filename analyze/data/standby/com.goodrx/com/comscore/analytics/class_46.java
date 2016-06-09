package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.p
class class_46 implements Runnable {
   // $FF: renamed from: a int
   // $FF: synthetic field
   final int field_304;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_305;

   class_46(Core var1, int var2) {
      this.field_305 = var1;
      this.field_304 = var2;
   }

   public void run() {
      this.field_305.field_344.setCacheMaxBatchFiles(this.field_304);
   }
}
