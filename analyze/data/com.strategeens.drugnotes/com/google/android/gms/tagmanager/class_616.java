package com.google.android.gms.tagmanager;

import android.text.TextUtils;

// $FF: renamed from: com.google.android.gms.tagmanager.ap
class class_616 {
   // $FF: renamed from: Bv long
   private final long field_2719;
   // $FF: renamed from: Bw long
   private final long field_2720;
   // $FF: renamed from: By java.lang.String
   private String field_2721;
   private final long arw;

   class_616(long var1, long var3, long var5) {
      this.field_2719 = var1;
      this.field_2720 = var3;
      this.arw = var5;
   }

   // $FF: renamed from: ak (java.lang.String) void
   void method_3508(String var1) {
      if(var1 != null && !TextUtils.isEmpty(var1.trim())) {
         this.field_2721 = var1;
      }
   }

   // $FF: renamed from: fb () long
   long method_3509() {
      return this.field_2719;
   }

   // $FF: renamed from: pK () long
   long method_3510() {
      return this.arw;
   }

   // $FF: renamed from: pL () java.lang.String
   String method_3511() {
      return this.field_2721;
   }
}
