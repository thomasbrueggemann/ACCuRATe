package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_498;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.q
class class_499 extends class_498 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2856;

   static {
      field_2856 = class_445.field_2442.toString();
   }

   public class_499() {
      super(field_2856);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
   protected boolean method_2907(String var1, String var2, Map<String, class_52.class_816> var3) {
      return var1.contains(var2);
   }
}
