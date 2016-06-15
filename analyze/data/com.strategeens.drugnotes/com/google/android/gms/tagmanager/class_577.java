package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.cv
class class_577 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2681;

   static {
      field_2681 = class_520.field_2203.toString();
   }

   public class_577() {
      super(field_2681, new String[0]);
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      return class_635.method_3597(Integer.valueOf(VERSION.SDK_INT));
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
