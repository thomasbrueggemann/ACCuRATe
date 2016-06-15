package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.p
class class_566 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2668;
   // $FF: renamed from: TU java.lang.String
   private final String field_2669;

   static {
      field_2668 = class_520.field_2186.toString();
   }

   public class_566(String var1) {
      super(field_2668, new String[0]);
      this.field_2669 = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      return this.field_2669 == null?class_635.method_3594():class_635.method_3597(this.field_2669);
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
