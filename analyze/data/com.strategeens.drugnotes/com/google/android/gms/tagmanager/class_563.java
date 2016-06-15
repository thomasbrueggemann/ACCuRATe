package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.u
class class_563 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2665;
   private static final String NAME;
   private static final String aqZ;
   private final DataLayer aqn;

   static {
      field_2665 = class_520.field_2185.toString();
      NAME = class_519.field_2067.toString();
      aqZ = class_519.field_2057.toString();
   }

   public class_563(DataLayer var1) {
      String var2 = field_2665;
      String[] var3 = new String[]{NAME};
      super(var2, var3);
      this.aqn = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      Object var2 = this.aqn.get(class_635.method_3579((class_57.class_1084)var1.get(NAME)));
      if(var2 == null) {
         class_57.class_1084 var3 = (class_57.class_1084)var1.get(aqZ);
         return var3 != null?var3:class_635.method_3594();
      } else {
         return class_635.method_3597(var2);
      }
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return false;
   }
}
