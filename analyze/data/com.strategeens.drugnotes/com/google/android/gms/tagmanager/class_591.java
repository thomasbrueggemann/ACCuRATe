package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_618;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ax
class class_591 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2694;
   private static final String aqd;
   // $FF: renamed from: lM android.content.Context
   private final Context field_2695;

   static {
      field_2694 = class_520.field_2238.toString();
      aqd = class_519.field_1993.toString();
   }

   public class_591(Context var1) {
      super(field_2694, new String[0]);
      this.field_2695 = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      String var2;
      if((class_57.class_1084)var1.get(aqd) != null) {
         var2 = class_635.method_3579((class_57.class_1084)var1.get(aqd));
      } else {
         var2 = null;
      }

      String var3 = class_618.method_3517(this.field_2695, var2);
      return var3 != null?class_635.method_3597(var3):class_635.method_3594();
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
