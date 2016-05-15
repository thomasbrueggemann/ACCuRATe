package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.k
class class_49 implements Runnable {
   // $FF: renamed from: a boolean
   // $FF: synthetic field
   final boolean field_310;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_311;

   class_49(Core var1, boolean var2) {
      this.field_311 = var1;
      this.field_310 = var2;
   }

   public void run() {
      if(this.field_311.isSecure() != this.field_310) {
         this.field_311.field_353 = this.field_310;
      }

   }
}
