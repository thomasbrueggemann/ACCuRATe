package com.comscore.analytics;

import com.comscore.analytics.ApplicationState;
import com.comscore.analytics.Core;
import com.comscore.analytics.SessionState;

// $FF: renamed from: com.comscore.analytics.af
class class_13 implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.ApplicationState
   // $FF: synthetic field
   final ApplicationState field_23;
   // $FF: renamed from: b com.comscore.analytics.ApplicationState
   // $FF: synthetic field
   final ApplicationState field_24;
   // $FF: renamed from: c com.comscore.analytics.SessionState
   // $FF: synthetic field
   final SessionState field_25;
   // $FF: renamed from: d com.comscore.analytics.SessionState
   // $FF: synthetic field
   final SessionState field_26;
   // $FF: renamed from: e com.comscore.analytics.Core
   // $FF: synthetic field
   final Core field_27;

   class_13(Core var1, ApplicationState var2, ApplicationState var3, SessionState var4, SessionState var5) {
      this.field_27 = var1;
      this.field_23 = var2;
      this.field_24 = var3;
      this.field_25 = var4;
      this.field_26 = var5;
   }

   public void run() {
      boolean var1 = true;
      boolean var2;
      if(this.field_23 != this.field_24) {
         this.field_27.method_233(this.field_27.field_382);
         this.field_27.method_244(this.field_24);
         this.field_27.method_265();
         this.field_27.field_382 = this.field_24;
         var2 = var1;
      } else {
         var2 = false;
      }

      if(this.field_25 != this.field_26) {
         this.field_27.method_235(this.field_27.field_329);
         this.field_27.method_245(this.field_26);
         this.field_27.method_266();
         this.field_27.field_329 = this.field_26;
      } else {
         var1 = false;
      }

      if(var2) {
         this.field_27.method_234(this.field_23, this.field_27.field_382);
      }

      if(var1) {
         this.field_27.method_236(this.field_25, this.field_27.field_329);
      }

   }
}
