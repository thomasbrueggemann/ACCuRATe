package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import java.util.Locale;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.bc
class class_595 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2699;

   static {
      field_2699 = class_520.field_2196.toString();
   }

   public class_595() {
      super(field_2699, new String[0]);
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      Locale var2 = Locale.getDefault();
      if(var2 == null) {
         return class_635.method_3594();
      } else {
         String var3 = var2.getLanguage();
         return var3 == null?class_635.method_3594():class_635.method_3597(var3.toLowerCase());
      }
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return false;
   }
}
