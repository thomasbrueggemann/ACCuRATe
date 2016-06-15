package com.google.android.gms.analytics;

import android.text.TextUtils;

// $FF: renamed from: com.google.android.gms.analytics.x
class class_654 {
   // $FF: renamed from: ws java.lang.String
   private String field_3421;
   // $FF: renamed from: wt long
   private final long field_3422;
   // $FF: renamed from: wu long
   private final long field_3423;
   // $FF: renamed from: wv java.lang.String
   private String field_3424 = "https:";

   class_654(String var1, long var2, long var4) {
      this.field_3421 = var1;
      this.field_3422 = var2;
      this.field_3423 = var4;
   }

   // $FF: renamed from: Q (java.lang.String) void
   void method_3738(String var1) {
      this.field_3421 = var1;
   }

   // $FF: renamed from: R (java.lang.String) void
   void method_3739(String var1) {
      if(var1 != null && !TextUtils.isEmpty(var1.trim()) && var1.toLowerCase().startsWith("http:")) {
         this.field_3424 = "http:";
      }
   }

   // $FF: renamed from: df () java.lang.String
   String method_3740() {
      return this.field_3421;
   }

   // $FF: renamed from: dg () long
   long method_3741() {
      return this.field_3422;
   }

   // $FF: renamed from: dh () long
   long method_3742() {
      return this.field_3423;
   }

   // $FF: renamed from: di () java.lang.String
   String method_3743() {
      return this.field_3424;
   }
}
