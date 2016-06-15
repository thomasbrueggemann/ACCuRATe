package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_536;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ce
class class_490 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2848;
   private static final String agC;
   private static final String agD;

   static {
      field_2848 = class_445.field_2400.toString();
      agC = class_444.field_2330.toString();
      agD = class_444.field_2277.toString();
   }

   public class_490() {
      super(field_2848, new String[0]);
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return false;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      class_52.class_816 var2 = (class_52.class_816)var1.get(agC);
      class_52.class_816 var3 = (class_52.class_816)var1.get(agD);
      double var4;
      double var6;
      if(var2 != null && var2 != class_537.method_3020() && var3 != null && var3 != class_537.method_3020()) {
         class_536 var8 = class_537.method_3010(var2);
         class_536 var9 = class_537.method_3010(var3);
         if(var8 != class_537.method_3018() && var9 != class_537.method_3018()) {
            double var10 = var8.doubleValue();
            var4 = var9.doubleValue();
            if(var10 <= var4) {
               var6 = var10;
               return class_537.method_3027(Long.valueOf(Math.round(var6 + Math.random() * (var4 - var6))));
            }
         }
      }

      var4 = 2.147483647E9D;
      var6 = 0.0D;
      return class_537.method_3027(Long.valueOf(Math.round(var6 + Math.random() * (var4 - var6))));
   }
}
