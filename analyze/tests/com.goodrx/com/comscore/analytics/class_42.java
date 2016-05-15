package com.comscore.analytics;

import com.comscore.analytics.Core;

// $FF: renamed from: com.comscore.analytics.t
class class_42 implements Runnable {
   // $FF: renamed from: a long
   // $FF: synthetic field
   final long field_296;
   // $FF: renamed from: b com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_297;

   class_42(Core var1, long var2) {
      this.field_297 = var1;
      this.field_296 = var2;
   }

   public void run() {
      this.field_297.field_350 = this.field_296;
      if(this.field_297.field_362 != null) {
         this.field_297.field_362.update();
      }

   }
}
