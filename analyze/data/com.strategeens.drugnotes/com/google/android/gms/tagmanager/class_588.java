package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.class_636;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.cf
class class_588 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2691;
   private static final String asu;
   private static final String asv;

   static {
      field_2691 = class_520.field_2199.toString();
      asu = class_519.field_2117.toString();
      asv = class_519.field_2116.toString();
   }

   public class_588() {
      super(field_2691, new String[0]);
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      class_57.class_1084 var2 = (class_57.class_1084)var1.get(asu);
      class_57.class_1084 var3 = (class_57.class_1084)var1.get(asv);
      double var4;
      double var6;
      if(var2 != null && var2 != class_635.method_3594() && var3 != null && var3 != class_635.method_3594()) {
         class_636 var8 = class_635.method_3580(var2);
         class_636 var9 = class_635.method_3580(var3);
         if(var8 != class_635.method_3591() && var9 != class_635.method_3591()) {
            double var10 = var8.doubleValue();
            var4 = var9.doubleValue();
            if(var10 <= var4) {
               var6 = var10;
               return class_635.method_3597(Long.valueOf(Math.round(var6 + Math.random() * (var4 - var6))));
            }
         }
      }

      var4 = 2.147483647E9D;
      var6 = 0.0D;
      return class_635.method_3597(Long.valueOf(Math.round(var6 + Math.random() * (var4 - var6))));
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return false;
   }
}
