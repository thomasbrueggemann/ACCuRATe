package com.google.android.gms.tagmanager;

import android.text.TextUtils;

// $FF: renamed from: com.google.android.gms.tagmanager.ap
class class_518 {
   private final long afC;
   private String afD;
   // $FF: renamed from: wt long
   private final long field_2873;
   // $FF: renamed from: wu long
   private final long field_2874;

   class_518(long var1, long var3, long var5) {
      this.field_2873 = var1;
      this.field_2874 = var3;
      this.afC = var5;
   }

   // $FF: renamed from: R (java.lang.String) void
   void method_2933(String var1) {
      if(var1 != null && !TextUtils.isEmpty(var1.trim())) {
         this.afD = var1;
      }
   }

   // $FF: renamed from: dg () long
   long method_2934() {
      return this.field_2873;
   }

   // $FF: renamed from: lI () long
   long method_2935() {
      return this.afC;
   }

   // $FF: renamed from: lJ () java.lang.String
   String method_2936() {
      return this.afD;
   }
}
