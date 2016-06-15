package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ai
class class_547 {
   // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$d) void
   private static void method_3096(DataLayer var0, class_51.class_967 var1) {
      class_52.class_816[] var2 = var1.field_838;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var0.method_3997(class_537.method_3009(var2[var4]));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$i) void
   public static void method_3097(DataLayer var0, class_51.class_960 var1) {
      if(var1.field_883 == null) {
         class_515.method_2919("supplemental missing experimentSupplemental");
      } else {
         method_3096(var0, var1.field_883);
         method_3098(var0, var1.field_883);
         method_3100(var0, var1.field_883);
      }
   }

   // $FF: renamed from: b (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$d) void
   private static void method_3098(DataLayer var0, class_51.class_967 var1) {
      class_52.class_816[] var2 = var1.field_837;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Map var5 = method_3099(var2[var4]);
         if(var5 != null) {
            var0.push(var5);
         }
      }

   }

   // $FF: renamed from: c (com.google.android.gms.internal.d$a) java.util.Map
   private static Map<String, Object> method_3099(class_52.class_816 var0) {
      Object var1 = class_537.method_3024(var0);
      if(!(var1 instanceof Map)) {
         class_515.method_2919("value: " + var1 + " is not a map value, ignored.");
         return null;
      } else {
         return (Map)var1;
      }
   }

   // $FF: renamed from: c (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$d) void
   private static void method_3100(DataLayer var0, class_51.class_967 var1) {
      class_51.class_968[] var2 = var1.field_839;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_51.class_968 var5 = var2[var4];
         if(var5.field_832 == null) {
            class_515.method_2919("GaExperimentRandom: No key");
         } else {
            Object var6 = var0.get(var5.field_832);
            Long var7;
            if(!(var6 instanceof Number)) {
               var7 = null;
            } else {
               var7 = Long.valueOf(((Number)var6).longValue());
            }

            long var8 = var5.field_833;
            long var10 = var5.field_834;
            if(!var5.field_835 || var7 == null || var7.longValue() < var8 || var7.longValue() > var10) {
               if(var8 > var10) {
                  class_515.method_2919("GaExperimentRandom: random range invalid");
                  continue;
               }

               var6 = Long.valueOf(Math.round(Math.random() * (double)(var10 - var8) + (double)var8));
            }

            var0.method_3997(var5.field_832);
            Map var12 = var0.method_3998(var5.field_832, var6);
            if(var5.field_836 > 0L) {
               if(!var12.containsKey("gtm")) {
                  Object[] var15 = new Object[]{"lifetime", Long.valueOf(var5.field_836)};
                  var12.put("gtm", DataLayer.mapOf(var15));
               } else {
                  Object var13 = var12.get("gtm");
                  if(var13 instanceof Map) {
                     ((Map)var13).put("lifetime", Long.valueOf(var5.field_836));
                  } else {
                     class_515.method_2919("GaExperimentRandom: gtm not a map");
                  }
               }
            }

            var0.push(var12);
         }
      }

   }
}
