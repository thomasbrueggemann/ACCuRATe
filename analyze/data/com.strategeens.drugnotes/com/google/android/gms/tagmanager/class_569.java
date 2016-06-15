package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_618;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.e
class class_569 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2672;
   private static final String aqd;
   private static final String aqe;
   // $FF: renamed from: lM android.content.Context
   private final Context field_2673;

   static {
      field_2672 = class_520.field_2207.toString();
      aqd = class_519.field_1993.toString();
      aqe = class_519.field_1996.toString();
   }

   public class_569(Context var1) {
      String var2 = field_2672;
      String[] var3 = new String[]{aqe};
      super(var2, var3);
      this.field_2673 = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      class_57.class_1084 var2 = (class_57.class_1084)var1.get(aqe);
      if(var2 == null) {
         return class_635.method_3594();
      } else {
         String var3 = class_635.method_3579(var2);
         class_57.class_1084 var4 = (class_57.class_1084)var1.get(aqd);
         String var5;
         if(var4 != null) {
            var5 = class_635.method_3579(var4);
         } else {
            var5 = null;
         }

         String var6 = class_618.method_3518(this.field_2673, var3, var5);
         return var6 != null?class_635.method_3597(var6):class_635.method_3594();
      }
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
