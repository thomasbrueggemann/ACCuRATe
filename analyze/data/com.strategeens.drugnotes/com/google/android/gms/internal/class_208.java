package com.google.android.gms.internal;

import com.google.android.gms.internal.class_199;
import com.google.android.gms.internal.class_2;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.ey;
import java.util.HashMap;

// $FF: renamed from: com.google.android.gms.internal.aa
@ey
class class_208 implements class_2 {
   // $FF: renamed from: mt com.google.android.gms.internal.gu
   private class_371 field_349;

   public class_208(class_371 var1) {
      this.field_349 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.af, boolean) void
   public void method_8(class_199 var1, boolean var2) {
      HashMap var3 = new HashMap();
      String var4;
      if(var2) {
         var4 = "1";
      } else {
         var4 = "0";
      }

      var3.put("isVisible", var4);
      this.field_349.method_2523("onAdVisibilityChanged", var3);
   }
}
