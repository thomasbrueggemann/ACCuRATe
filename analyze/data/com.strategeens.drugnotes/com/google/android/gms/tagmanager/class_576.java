package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.class_640;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ah
class class_576 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2680;
   private final class_640 aqo;

   static {
      field_2680 = class_520.field_2193.toString();
   }

   public class_576(class_640 var1) {
      super(field_2680, new String[0]);
      this.aqo = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      String var2 = this.aqo.method_3654();
      return var2 == null?class_635.method_3594():class_635.method_3597(var2);
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return false;
   }
}
