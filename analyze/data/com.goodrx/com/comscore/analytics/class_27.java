package com.comscore.analytics;

import com.comscore.analytics.Core;
import com.comscore.utils.Utils;
import java.util.HashMap;

// $FF: renamed from: com.comscore.analytics.f
class class_27 implements Runnable {
   // $FF: renamed from: a java.util.HashMap
   // $FF: synthetic field
   final HashMap field_267;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_268;

   class_27(Core var1, HashMap var2) {
      this.field_268 = var1;
      this.field_267 = var2;
   }

   public void run() {
      this.field_268.field_347.putAll(Utils.mapOfStrings(this.field_267));
   }
}
