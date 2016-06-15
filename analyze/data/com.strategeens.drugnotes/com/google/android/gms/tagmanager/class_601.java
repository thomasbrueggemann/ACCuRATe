package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_597;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.dc
class class_601 extends class_597 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2703;

   static {
      field_2703 = class_520.field_2251.toString();
   }

   public class_601() {
      super(field_2703);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
   protected boolean method_3481(String var1, String var2, Map<String, class_57.class_1084> var3) {
      return var1.startsWith(var2);
   }
}
