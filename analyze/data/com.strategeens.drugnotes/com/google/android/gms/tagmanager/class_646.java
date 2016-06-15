package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_55;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ai
class class_646 {
   // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$d) void
   private static void method_3676(DataLayer var0, class_55.class_1271 var1) {
      class_57.class_1084[] var2 = var1.field_681;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var0.method_4998(class_635.method_3579(var2[var4]));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$i) void
   public static void method_3677(DataLayer var0, class_55.class_1258 var1) {
      if(var1.field_725 == null) {
         class_613.method_3494("supplemental missing experimentSupplemental");
      } else {
         method_3676(var0, var1.field_725);
         method_3678(var0, var1.field_725);
         method_3680(var0, var1.field_725);
      }
   }

   // $FF: renamed from: b (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$d) void
   private static void method_3678(DataLayer var0, class_55.class_1271 var1) {
      class_57.class_1084[] var2 = var1.field_680;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Map var5 = method_3679(var2[var4]);
         if(var5 != null) {
            var0.push(var5);
         }
      }

   }

   // $FF: renamed from: c (com.google.android.gms.internal.d$a) java.util.Map
   private static Map<String, Object> method_3679(class_57.class_1084 var0) {
      Object var1 = class_635.method_3584(var0);
      if(!(var1 instanceof Map)) {
         class_613.method_3494("value: " + var1 + " is not a map value, ignored.");
         return null;
      } else {
         return (Map)var1;
      }
   }

   // $FF: renamed from: c (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$d) void
   private static void method_3680(DataLayer var0, class_55.class_1271 var1) {
      class_55.class_1272[] var2 = var1.field_682;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_55.class_1272 var5 = var2[var4];
         if(var5.field_675 == null) {
            class_613.method_3494("GaExperimentRandom: No key");
         } else {
            Object var6 = var0.get(var5.field_675);
            Long var7;
            if(!(var6 instanceof Number)) {
               var7 = null;
            } else {
               var7 = Long.valueOf(((Number)var6).longValue());
            }

            long var8 = var5.field_676;
            long var10 = var5.field_677;
            if(!var5.field_678 || var7 == null || var7.longValue() < var8 || var7.longValue() > var10) {
               if(var8 > var10) {
                  class_613.method_3494("GaExperimentRandom: random range invalid");
                  continue;
               }

               var6 = Long.valueOf(Math.round(Math.random() * (double)(var10 - var8) + (double)var8));
            }

            var0.method_4998(var5.field_675);
            Map var12 = var0.method_4997(var5.field_675, var6);
            if(var5.field_679 > 0L) {
               if(!var12.containsKey("gtm")) {
                  Object[] var15 = new Object[]{"lifetime", Long.valueOf(var5.field_679)};
                  var12.put("gtm", DataLayer.mapOf(var15));
               } else {
                  Object var13 = var12.get("gtm");
                  if(var13 instanceof Map) {
                     ((Map)var13).put("lifetime", Long.valueOf(var5.field_679));
                  } else {
                     class_613.method_3494("GaExperimentRandom: gtm not a map");
                  }
               }
            }

            var0.push(var12);
         }
      }

   }
}
