package com.comscore.analytics;

import com.comscore.analytics.Core;
import com.comscore.utils.Constants;

// $FF: renamed from: com.comscore.analytics.m
class class_43 implements Runnable {
   // $FF: renamed from: a boolean
   // $FF: synthetic field
   final boolean field_298;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_299;

   class_43(Core var1, boolean var2) {
      this.field_299 = var1;
      this.field_298 = var2;
   }

   public void run() {
      Constants.DEBUG = this.field_298;
   }
}
