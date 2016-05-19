package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.u
class class_35 implements Runnable {
   // $FF: renamed from: a java.lang.String[]
   // $FF: synthetic field
   final String[] field_283;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_284;

   class_35(Core var1, String[] var2) {
      this.field_284 = var1;
      this.field_283 = var2;
   }

   public void run() {
      this.field_284.field_356 = this.field_283;
   }
}
