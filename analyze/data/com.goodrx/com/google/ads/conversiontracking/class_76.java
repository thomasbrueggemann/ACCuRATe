package com.google.ads.conversiontracking;

import com.google.ads.conversiontracking.class_79;

// $FF: renamed from: com.google.ads.conversiontracking.d
public class class_76 {
   // $FF: renamed from: a boolean
   public final boolean field_571;
   // $FF: renamed from: b boolean
   public final boolean field_572;
   // $FF: renamed from: c int
   public final int field_573;
   // $FF: renamed from: d long
   public final long field_574;
   // $FF: renamed from: e java.lang.String
   public final String field_575;
   // $FF: renamed from: f java.lang.String
   public final String field_576;
   // $FF: renamed from: g java.lang.String
   public final String field_577;
   // $FF: renamed from: h long
   public long field_578;

   public class_76(long var1, String var3, String var4, boolean var5, boolean var6, String var7, long var8, int var10) {
      this.field_578 = var1;
      this.field_577 = var3;
      this.field_576 = var4;
      this.field_572 = var5;
      this.field_571 = var6;
      this.field_575 = var7;
      this.field_574 = var8;
      this.field_573 = var10;
   }

   public class_76(String var1, class_79.class_95 var2, boolean var3, boolean var4) {
      this.field_577 = var1;
      this.field_572 = var4;
      this.field_571 = var3;
      this.field_578 = 0L;
      this.field_574 = class_79.method_522();
      this.field_573 = 0;
      if(!var4 && var3) {
         this.field_576 = class_79.method_543(var2);
         this.field_575 = class_79.method_530(var2);
      } else {
         this.field_576 = null;
         this.field_575 = null;
      }
   }
}
