package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_504;
import com.google.android.gms.tagmanager.dg;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.am
class class_506 extends class_504 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2862;

   static {
      field_2862 = class_445.field_2446.toString();
   }

   public class_506() {
      super(field_2862);
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.dg, com.google.android.gms.tagmanager.dg, java.util.Map) boolean
   protected boolean method_2908(dg var1, dg var2, Map<String, class_52.class_816> var3) {
      return var1.method_2998(var2) > 0;
   }
}
