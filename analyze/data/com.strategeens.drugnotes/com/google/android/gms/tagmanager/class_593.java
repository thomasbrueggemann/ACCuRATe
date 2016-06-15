package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.bj
class class_593 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2697;
   private static final String arp;

   static {
      field_2697 = class_520.field_2243.toString();
      arp = class_519.field_2010.toString();
   }

   public class_593() {
      String var1 = field_2697;
      String[] var2 = new String[]{arp};
      super(var1, var2);
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      return class_635.method_3597(class_635.method_3579((class_57.class_1084)var1.get(arp)).toLowerCase());
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
