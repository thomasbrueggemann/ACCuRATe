package com.google.android.gms.internal;

import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_48;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.cf
@ey
public class class_454 implements class_46 {
   // $FF: renamed from: qa com.google.android.gms.internal.cg
   private final class_48 field_1535;

   public class_454(class_48 var1) {
      this.field_1535 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
   public void method_213(gu var1, Map<String, String> var2) {
      boolean var3 = "1".equals(var2.get("transparentBackground"));
      this.field_1535.method_215(var3);
   }
}
