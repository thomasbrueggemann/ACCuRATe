package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.n
class class_44 implements Runnable {
   // $FF: renamed from: a boolean
   // $FF: synthetic field
   final boolean field_300;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_301;

   class_44(Core var1, boolean var2) {
      this.field_301 = var1;
      this.field_300 = var2;
   }

   public void run() {
      this.field_301.field_380 = this.field_300;
   }
}
