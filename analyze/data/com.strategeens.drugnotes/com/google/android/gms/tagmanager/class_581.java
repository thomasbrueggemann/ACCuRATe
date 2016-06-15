package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_580;
import com.google.android.gms.tagmanager.class_635;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.w
class class_581 extends class_580 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2684;
   private static final String VALUE;
   private static final String ark;
   private final DataLayer aqn;

   static {
      field_2684 = class_520.field_2242.toString();
      VALUE = class_519.field_2175.toString();
      ark = class_519.field_1989.toString();
   }

   public class_581(DataLayer var1) {
      String var2 = field_2684;
      String[] var3 = new String[]{VALUE};
      super(var2, var3);
      this.aqn = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a) void
   private void method_3455(class_57.class_1084 var1) {
      if(var1 != null && var1 != class_635.method_3587()) {
         String var2 = class_635.method_3579(var1);
         if(var2 != class_635.method_3593()) {
            this.aqn.method_4998(var2);
            return;
         }
      }

   }

   // $FF: renamed from: b (com.google.android.gms.internal.d$a) void
   private void method_3456(class_57.class_1084 var1) {
      if(var1 != null && var1 != class_635.method_3587()) {
         Object var2 = class_635.method_3584(var1);
         if(var2 instanceof List) {
            Iterator var3 = ((List)var2).iterator();

            while(var3.hasNext()) {
               Object var4 = var3.next();
               if(var4 instanceof Map) {
                  Map var5 = (Map)var4;
                  this.aqn.push(var5);
               }
            }
         }
      }

   }

   // $FF: renamed from: D (java.util.Map) void
   public void method_3454(Map<String, class_57.class_1084> var1) {
      this.method_3456((class_57.class_1084)var1.get(VALUE));
      this.method_3455((class_57.class_1084)var1.get(ark));
   }
}
