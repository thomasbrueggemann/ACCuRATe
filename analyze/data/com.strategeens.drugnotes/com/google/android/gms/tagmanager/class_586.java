package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ca
class class_586 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2689;

   static {
      field_2689 = class_520.field_2197.toString();
   }

   public class_586() {
      super(field_2689, new String[0]);
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      return class_635.method_3597(VERSION.RELEASE);
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
