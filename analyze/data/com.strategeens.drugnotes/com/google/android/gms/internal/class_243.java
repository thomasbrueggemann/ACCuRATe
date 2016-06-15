package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.internal.class_11;
import com.google.android.gms.internal.class_68;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.bo
@ey
public final class class_243 extends class_11.class_1409 {
   // $FF: renamed from: px com.google.android.gms.internal.w
   private final class_68 field_487;
   // $FF: renamed from: py java.lang.String
   private final String field_488;
   // $FF: renamed from: pz java.lang.String
   private final String field_489;

   public class_243(class_68 var1, String var2, String var3) {
      this.field_487 = var1;
      this.field_488 = var2;
      this.field_489 = var3;
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.d) void
   public void method_38(class_198 var1) {
      if(var1 != null) {
         this.field_487.method_377((View)class_960.method_5292(var1));
      }
   }

   // $FF: renamed from: av () void
   public void method_39() {
      this.field_487.method_375();
   }

   // $FF: renamed from: aw () void
   public void method_40() {
      this.field_487.method_376();
   }

   // $FF: renamed from: bA () java.lang.String
   public String method_41() {
      return this.field_489;
   }

   // $FF: renamed from: bz () java.lang.String
   public String method_42() {
      return this.field_488;
   }
}
