package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.x
class class_38 implements Runnable {
   // $FF: renamed from: a int
   // $FF: synthetic field
   final int field_287;
   // $FF: renamed from: b boolean
   // $FF: synthetic field
   final boolean field_288;
   // $FF: renamed from: c com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_289;

   class_38(Core var1, int var2, boolean var3) {
      this.field_289 = var1;
      this.field_287 = var2;
      this.field_288 = var3;
   }

   public void run() {
      this.field_289.method_232(this.field_287, this.field_288);
   }
}
