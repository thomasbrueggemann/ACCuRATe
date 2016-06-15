package com.google.android.gms.analytics;

import android.text.TextUtils;

// $FF: renamed from: com.google.android.gms.analytics.ab
public class class_864 {
   // $FF: renamed from: Bu java.lang.String
   private String field_3699;
   // $FF: renamed from: Bv long
   private final long field_3700;
   // $FF: renamed from: Bw long
   private final long field_3701;
   // $FF: renamed from: Bx java.lang.String
   private final String field_3702;
   // $FF: renamed from: By java.lang.String
   private String field_3703;
   // $FF: renamed from: Bz java.lang.String
   private String field_3704 = "https:";

   public class_864(String var1, long var2, long var4, String var6) {
      this.field_3699 = var1;
      this.field_3700 = var2;
      this.field_3701 = var4;
      this.field_3702 = var6;
   }

   // $FF: renamed from: aj (java.lang.String) void
   public void method_4844(String var1) {
      this.field_3699 = var1;
   }

   // $FF: renamed from: ak (java.lang.String) void
   public void method_4845(String var1) {
      if(var1 != null && !TextUtils.isEmpty(var1.trim())) {
         this.field_3703 = var1;
         if(var1.toLowerCase().startsWith("http:")) {
            this.field_3704 = "http:";
            return;
         }
      }

   }

   // $FF: renamed from: fa () java.lang.String
   public String method_4846() {
      return this.field_3699;
   }

   // $FF: renamed from: fb () long
   public long method_4847() {
      return this.field_3700;
   }

   // $FF: renamed from: fc () long
   public long method_4848() {
      return this.field_3701;
   }

   // $FF: renamed from: fd () java.lang.String
   public String method_4849() {
      return this.field_3704;
   }
}
