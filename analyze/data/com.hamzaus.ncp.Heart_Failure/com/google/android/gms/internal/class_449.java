package com.google.android.gms.internal;

import com.google.android.gms.internal.class_163;
import com.google.android.gms.internal.class_2;
import com.google.android.gms.internal.class_369;
import java.util.HashMap;

// $FF: renamed from: com.google.android.gms.internal.y
class class_449 implements class_2 {
   // $FF: renamed from: lc com.google.android.gms.internal.ey
   private class_369 field_2719;

   public class_449(class_369 var1) {
      this.field_2719 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ad, boolean) void
   public void method_6(class_163 var1, boolean var2) {
      HashMap var3 = new HashMap();
      String var4;
      if(var2) {
         var4 = "1";
      } else {
         var4 = "0";
      }

      var3.put("isVisible", var4);
      this.field_2719.method_2342("onAdVisibilityChanged", var3);
   }
}
