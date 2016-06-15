package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_597;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ad
class class_599 extends class_597 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2701;

   static {
      field_2701 = class_520.field_2252.toString();
   }

   public class_599() {
      super(field_2701);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
   protected boolean method_3481(String var1, String var2, Map<String, class_57.class_1084> var3) {
      return var1.endsWith(var2);
   }
}
