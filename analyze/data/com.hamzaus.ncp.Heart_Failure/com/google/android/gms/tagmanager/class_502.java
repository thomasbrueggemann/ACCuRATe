package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_498;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.db
class class_502 extends class_498 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2859;

   static {
      field_2859 = class_445.field_2440.toString();
   }

   public class_502() {
      super(field_2859);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
   protected boolean method_2907(String var1, String var2, Map<String, class_52.class_816> var3) {
      return var1.startsWith(var2);
   }
}
