package com.google.android.gms.internal;

import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_476;
import com.google.android.gms.internal.class_478;
import com.google.android.gms.internal.class_479;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ch
@ey
public class class_455 implements class_46 {
   // $FF: renamed from: qb java.util.Map
   static final Map<String, Integer> field_1536 = new HashMap();

   static {
      field_1536.put("resize", Integer.valueOf(1));
      field_1536.put("playVideo", Integer.valueOf(2));
      field_1536.put("storePicture", Integer.valueOf(3));
      field_1536.put("createCalendarEvent", Integer.valueOf(4));
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
   public void method_213(gu var1, Map<String, String> var2) {
      String var3 = (String)var2.get("a");
      switch(((Integer)field_1536.get(var3)).intValue()) {
      case 1:
         (new class_479(var1, var2)).execute();
         return;
      case 2:
      default:
         class_368.method_2504("Unknown MRAID command called.");
         return;
      case 3:
         (new class_476(var1, var2)).execute();
         return;
      case 4:
         (new class_478(var1, var2)).execute();
      }
   }
}
