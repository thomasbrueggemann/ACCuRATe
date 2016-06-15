package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_597;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.q
class class_598 extends class_597 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2700;

   static {
      field_2700 = class_520.field_2253.toString();
   }

   public class_598() {
      super(field_2700);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
   protected boolean method_3481(String var1, String var2, Map<String, class_57.class_1084> var3) {
      return var1.contains(var2);
   }
}
