package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.class_675;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.c
class class_567 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2670;
   private final class_675 aqc;

   static {
      field_2670 = class_520.field_2271.toString();
   }

   public class_567(Context var1) {
      this(class_675.method_3829(var1));
   }

   class_567(class_675 var1) {
      super(field_2670, new String[0]);
      this.aqc = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      boolean var2;
      if(!this.aqc.isLimitAdTrackingEnabled()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return class_635.method_3597(Boolean.valueOf(var2));
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return false;
   }
}
