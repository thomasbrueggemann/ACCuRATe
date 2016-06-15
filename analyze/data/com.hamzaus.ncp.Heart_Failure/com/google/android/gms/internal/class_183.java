package com.google.android.gms.internal;

import com.google.android.gms.internal.class_10;
import com.google.android.gms.internal.class_7;
import com.google.android.gms.internal.ey;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.bf
public class class_183 implements class_10 {
   // $FF: renamed from: na com.google.android.gms.internal.bg
   private final class_7 field_590;

   public class_183(class_7 var1) {
      this.field_590 = var1;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
   public void method_19(ey var1, Map<String, String> var2) {
      boolean var3 = "1".equals(var2.get("transparentBackground"));
      this.field_590.method_17(var3);
   }
}
