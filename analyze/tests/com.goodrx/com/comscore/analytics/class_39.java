package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.q
class class_39 implements Runnable {
   // $FF: renamed from: a int
   // $FF: synthetic field
   final int field_290;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_291;

   class_39(Core var1, int var2) {
      this.field_291 = var1;
      this.field_290 = var2;
   }

   public void run() {
      this.field_291.field_344.setCacheMaxPosts(this.field_290);
   }
}
