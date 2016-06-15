package com.google.android.gms.internal;

import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_45;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ca
@ey
public final class class_452 implements class_46 {
   // $FF: renamed from: pP com.google.android.gms.internal.cb
   private final class_45 field_1523;

   public class_452(class_45 var1) {
      this.field_1523 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
   public void method_213(gu var1, Map<String, String> var2) {
      String var3 = (String)var2.get("name");
      if(var3 == null) {
         class_368.method_2506("App event with no name parameter.");
      } else {
         this.field_1523.onAppEvent(var3, (String)var2.get("info"));
      }
   }
}
