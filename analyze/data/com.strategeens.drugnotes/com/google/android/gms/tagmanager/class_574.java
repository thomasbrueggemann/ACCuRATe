package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.aa
class class_574 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2678;

   static {
      field_2678 = class_520.field_2188.toString();
   }

   public class_574() {
      super(field_2678, new String[0]);
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      String var2 = Build.MANUFACTURER;
      String var3 = Build.MODEL;
      if(!var3.startsWith(var2) && !var2.equals("unknown")) {
         var3 = var2 + " " + var3;
      }

      return class_635.method_3597(var3);
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
