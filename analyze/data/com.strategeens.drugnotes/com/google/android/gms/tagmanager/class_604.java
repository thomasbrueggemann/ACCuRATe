package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_603;
import com.google.android.gms.tagmanager.dh;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.al
class class_604 extends class_603 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2705;

   static {
      field_2705 = class_520.field_2258.toString();
   }

   public class_604() {
      super(field_2705);
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.dh, com.google.android.gms.tagmanager.dh, java.util.Map) boolean
   protected boolean method_3482(dh var1, dh var2, Map<String, class_57.class_1084> var3) {
      return var1.method_3604(var2) >= 0;
   }
}