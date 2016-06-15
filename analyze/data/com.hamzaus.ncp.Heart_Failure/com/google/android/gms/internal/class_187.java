package com.google.android.gms.internal;

import com.google.android.gms.internal.class_10;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_8;
import com.google.android.gms.internal.ey;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ba
public final class class_187 implements class_10 {
   // $FF: renamed from: mQ com.google.android.gms.internal.bb
   private final class_8 field_601;

   public class_187(class_8 var1) {
      this.field_601 = var1;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
   public void method_19(ey var1, Map<String, String> var2) {
      String var3 = (String)var2.get("name");
      if(var3 == null) {
         class_370.method_2358("App event with no name parameter.");
      } else {
         this.field_601.onAppEvent(var3, (String)var2.get("info"));
      }
   }
}
